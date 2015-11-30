package com.capstone.project.admin.status;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class AdminStatusDaoImpl implements AdminStatusDao {

	DataSource dataSource;

	
	@Override
	public AdminStatusResponse changeStatus(AdminStatusRequest r) {
		
		AdminStatusResponse resp = new AdminStatusResponse();
		String sql = "UPDATE familydonations.family SET status='%s'  WHERE username ='%s'";
		sql=String.format(sql, r.getStatus(), r.getUsername());
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		if (jdbcTemplate.update(sql) > 0){
			resp.setMessage("success");
		}
		
		return resp;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
}
