package com.capstone.project.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.capstone.project.family.Child;
import com.capstone.project.family.Wishitem;

public class AdminDaoImpl implements AdminDao {

	DataSource dataSource;

	@Override
	public AdminResponse getAllFamilies() {

		String sql1 = "select * from  familydonations.family";
		String sql2 = "select * from  familydonations.child";
		String sql3 = "select * from  familydonations.wishitem";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<AdminStatus> statusList = jdbcTemplate.query(sql1, new RowMapper<AdminStatus>() {

					public AdminStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
		
						AdminStatus a = new AdminStatus();
						a.setBiography(rs.getString("biography"));
						a.setStatus(rs.getString("status"));
						a.setUsername(rs.getString("username"));
						a.setName(rs.getString("name"));
						
						return a;
					}
				});

		List<Child> childList = jdbcTemplate.query(sql2,
				new RowMapper<Child>() {

					public Child mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Child a = new Child();
						a.setFamilyid(rs.getString("familyid"));
						a.setName(rs.getString("name"));
						a.setWishname(rs.getString("wishitemname"));
						return a;
					}
				});

		List<Wishitem> wishList = jdbcTemplate.query(sql3,
				
				new RowMapper<Wishitem>() {

					public Wishitem mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Wishitem a = new Wishitem();
						a.setFamilyid(rs.getString("familyid"));
						a.setName(rs.getString("name"));
						a.setChildname(rs.getString("childname"));
						return a;
					}
				});
		
		Map<String ,AdminStatus > statusMAp = new HashMap<String ,AdminStatus>();
		for(AdminStatus a : statusList){
			statusMAp.put(a.getUsername(), a);
		}
		
		Map<String ,Set<String> > childMAp = new HashMap<String ,Set<String>>();
		
		for(Child c : childList){
			if(childMAp.get(c.getFamilyid()) !=null){
				Set<String> child = childMAp.get(c.getFamilyid());
				child.add(c.getName());
				childMAp.put(c.getFamilyid(), child);
			}else{
				Set<String> child= new HashSet<String>();
				child.add(c.getName());
				childMAp.put(c.getFamilyid(), child);
			}
		}
		
		
		
	Map<String ,Set<String> > wishMAp = new HashMap<String ,Set<String>>();
		
		for(Wishitem c : wishList){
			if(wishMAp.get(c.getFamilyid()) !=null){
				Set<String> wish = wishMAp.get(c.getFamilyid());
				wish.add(c.getName());
				wishMAp.put(c.getFamilyid(), wish);
			}else{
				Set<String> wish= new HashSet<String>();
				wish.add(c.getName());
				wishMAp.put(c.getFamilyid(), wish);
			}
		}
		
		AdminResponse resp = new AdminResponse();
		List<AdminDTO> admindtos = new ArrayList<AdminDTO>();
		 AdminDTO dto = null;
		 
		 //wishMAp childMAp statusMAp
		 
		 for(String username : statusMAp.keySet()){
			  dto = new AdminDTO();	  
			  dto.setFamilyname(statusMAp.get(username).getName());
			  dto.setChildname(StringUtils.join(childMAp.get(username), ','));
			  dto.setWishlist(StringUtils.join(wishMAp.get(username), ','));
			  dto.setBiography(statusMAp.get(username).getBiography());
			  dto.setStatus(statusMAp.get(username).getStatus());
			  dto.setUsername(statusMAp.get(username).getUsername());
			  admindtos.add(dto);
			  
		 }
		 
		 resp.setAdmindtos(admindtos);
		 return resp;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
