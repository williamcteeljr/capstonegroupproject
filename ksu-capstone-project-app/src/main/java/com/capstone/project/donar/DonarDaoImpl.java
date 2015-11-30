package com.capstone.project.donar;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class DonarDaoImpl implements DonarDao {

	DataSource dataSource;
	
	
	@Override
	public void registerDonar(DonarDTO d) {

		String sql = "INSERT INTO familydonations.donar "
				+ "(username, password , name , street , city , zipcode , phoneno , emailaddress , picturename)"
				+ " VALUES ('%s', '%s' ,'%s' , '%s', '%s' ,'%s', '%s', '%s' ,'%s')";
		sql=String.format(sql, d.getUsername(), d.getPassword(), d.getName() ,
				d.getStreet(),d.getCity(), d.getZipcode(), d.getPhoneno() , d.getEmailaddress() , d.getProfilepicture());
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.update(sql);
		
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
}
