package com.capstone.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.capstone.project.user.User;

public class UserDaoImpl implements UserDao {

	DataSource dataSource;

	public List<User> getUserList() {

		List<User> userList = new ArrayList<User>();
		String sql = "select * from familydonations.USER_APP";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rownumber) throws SQLException {
				User e = new User();
				e.setUserName(rs.getString(1));
				e.setPassWord(rs.getString(2));
				e.setRole(rs.getString(3));
				return e;
			}
		});
		return userList;
	}

	public void registerUser(User user) {

		String sql = "INSERT INTO familydonations.USER_APP (username, password ,role) VALUES ('%s', '%s' ,'%s')";
		sql=String.format(sql, user.getUserName(), user.getPassWord() , user.getRole());
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