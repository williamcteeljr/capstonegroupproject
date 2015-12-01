package com.capstone.project.donar.transaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.capstone.project.admin.AdminStatus;
import com.capstone.project.donar.transaction.TransactionDTO;

public class DonarTransactionDaoImpl implements DonarTransactionDao {

	DataSource dataSource;
	
	
	@Override
	public DonarTransactionResponse finalSubmitTransactionRequest(String userId) {
		
		DonarTransactionResponse r = new DonarTransactionResponse();
		String sql = "select * from  familydonations.transaction where userId='%s'";
		
		
		sql= String.format(sql, userId);
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<TransactionDTO> itemList = jdbcTemplate.query(sql, new RowMapper<TransactionDTO>() {

					public TransactionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						TransactionDTO a = new TransactionDTO();				
						a.setItem(rs.getString("wishitems"));
						a.setSubmittedDate(rs.getDate("submitteddate"));
						return a;
					}
				});
		
		if( itemList !=null && itemList.size() > 0){
			r.setItemList(itemList);
			
		}
		
		return r;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
