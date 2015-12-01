package com.capstone.project.family.transaction;

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

public class FamilyTransactionDaoImpl implements FamilyTransactionDao {

	DataSource dataSource;
	
	
	@Override
	public FamilyTransactionResponse finalSubmitDonation(String familyId) {
		
		FamilyTransactionResponse r = new FamilyTransactionResponse();
		String sql = "select * from  familydonations.wishitem where familyId='%s'";
		
		
		sql= String.format(sql, familyId);
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<FamilyTransactionDTO> itemList = jdbcTemplate.query(sql, new RowMapper<FamilyTransactionDTO>() {

					public FamilyTransactionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
						FamilyTransactionDTO a = new FamilyTransactionDTO();
						
						a.setItemname(rs.getString("name"));
						a.setStatus(rs.getString("status"));
						
						
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
