package com.capstone.project.donation.wish.submit;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.capstone.project.donar.transaction.TransactionDTO;

public class WishSubmitDaoImpl implements WishSubmitDao {

	DataSource dataSource;

	@Override
	public WishSubmitResponse finalSubmitDonation(WishSubmitRequest r) {

		// make all wishitemname -in wishlist APPROVED

		WishSubmitResponse resp = new WishSubmitResponse();
		String sql = "UPDATE familydonations.wishitem SET status='COMPLETED'  WHERE familyId ='%s' and name IN (%s) ";

		Set<String> params = new HashSet<String>(r.getGift());

		StringBuilder param = new StringBuilder();

		for (String s : params) {
			param.append("'");
			param.append(s);
			param.append("',");
		}

		String giftparam = param.toString();

		giftparam = giftparam.substring(0, giftparam.length() - 1);

		sql = String.format(sql, r.getFamilyId(), giftparam);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		if (jdbcTemplate.update(sql) > 0) {
			resp.setMessage("success");
		}

		
		String sql1 = "INSERT INTO familydonations.transaction  (familyId, wishItems, userId) "
				+ " VALUES (?, ?, ?) ";

		final List<TransactionDTO> transDto = new ArrayList<TransactionDTO>();

		for (String s : params) {
			TransactionDTO d = new TransactionDTO();
			
			d.setUserId(r.getUserId());
			d.setItem(s);
			d.setFamilyId(r.getFamilyId());

			transDto.add(d);
		}

		jdbcTemplate.batchUpdate(sql1, new BatchPreparedStatementSetter() {

			// @Override

			public void setValues(PreparedStatement ps, int i) throws SQLException {
				
				TransactionDTO w = transDto.get(i);
				
				ps.setString(1, w.getFamilyId());
				ps.setString(2, w.getItem());
				ps.setString(3, w.getUserId());
			
			}

			// @Override
			public int getBatchSize() {
				return transDto.size();
			}

		});

		return resp;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
