package com.capstone.project.donation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.capstone.project.family.FamilyDTO;

public class DonationDaoImpl implements DonationDao {

	DataSource dataSource;

	@Override
	public List<FamilyDTO> getapprovedFamilies() {

		String sql = "select * from  familydonations.family where status='APPROVED'";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<FamilyDTO> familyList = jdbcTemplate.query(sql,
				new RowMapper<FamilyDTO>() {

					public FamilyDTO mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						FamilyDTO a = new FamilyDTO();

						a.setBiography(rs.getString("biography"));
						a.setStatus(rs.getString("status"));
						a.setUsername(rs.getString("username"));
						a.setName(rs.getString("name"));
						a.setCity(rs.getString("city"));
						a.setProfilepicture(rs.getString("picturename"));

						return a;
					}
				});
		
		return familyList;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
