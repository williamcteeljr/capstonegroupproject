package com.capstone.project.family;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

public class FamilyDaoImpl implements FamilyDao {

	DataSource dataSource;

	@Override
	public void registerFamily(FamilyDTOUI d) {

		String sql = "INSERT INTO familydonations.family "
				+ "(username, password , name , street , city , zipcode , "
				+ "phoneno , emailaddress , picturename , noofchildren , biography , status )"
				+ " VALUES ('%s', '%s' ,'%s' , '%s', '%s' ,'%s', "
				+ "'%s', '%s' ,'%s','%s' ,'%s' , 'SUBMITTED')";
		
		sql = String.format(sql, d.getUsername(), d.getPassword(), d.getName(),
				d.getStreet(), d.getCity(), d.getZipcode(), d.getPhoneno(),
				d.getEmailaddress(), d.getProfilepicture(),
				d.getNoofchildren(), d.getBiography());

		System.out.println(sql);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);
		
		registerChild(d);
		registerWishItem(d);

	}

	
	
	private void registerWishItem(FamilyDTOUI d) {

		final List<Wishitem> wishList = new ArrayList<Wishitem>();

		if (d.getChildname_0() != null) {

			Wishitem c = new Wishitem();
			c.setName(d.getWishlist1_0());
			c.setImage(d.getWishlist1image_0());
			c.setChildname(d.getChildname_0());
			c.setFamilyid(d.getUsername());

			wishList.add(c);

			Wishitem c1 = new Wishitem();

			c1.setName(d.getWishlist2_0());
			c1.setImage(d.getWishlist2image_0());
			c1.setChildname(d.getChildname_0());
			c1.setFamilyid(d.getUsername());

			wishList.add(c1);

			Wishitem c2 = new Wishitem();

			c2.setName(d.getWishlist3_0());
			c2.setImage(d.getWishlist3image_0());
			c2.setChildname(d.getChildname_0());
			c2.setFamilyid(d.getUsername());

			wishList.add(c2);
		}

		if (d.getChildname_1() != null) {

			Wishitem c = new Wishitem();
			c.setName(d.getWishlist1_1());
			c.setImage(d.getWishlist1image_1());
			c.setChildname(d.getChildname_1());
			c.setFamilyid(d.getUsername());

			wishList.add(c);

			Wishitem c1 = new Wishitem();

			c1.setName(d.getWishlist2_1());
			c1.setImage(d.getWishlist2image_1());
			c1.setChildname(d.getChildname_1());
			c1.setFamilyid(d.getUsername());

			wishList.add(c1);

			Wishitem c2 = new Wishitem();

			c2.setName(d.getWishlist3_1());
			c2.setImage(d.getWishlist3image_1());
			c2.setChildname(d.getChildname_1());
			c2.setFamilyid(d.getUsername());

			wishList.add(c2);

		}

		if (d.getChildname_2() != null) {

			Wishitem c = new Wishitem();
			c.setName(d.getWishlist1_2());
			c.setImage(d.getWishlist1image_2());
			c.setChildname(d.getChildname_2());
			c.setFamilyid(d.getUsername());

			wishList.add(c);

			Wishitem c1 = new Wishitem();

			c1.setName(d.getWishlist2_2());
			c1.setImage(d.getWishlist2image_2());
			c1.setChildname(d.getChildname_2());
			c1.setFamilyid(d.getUsername());

			wishList.add(c1);

			Wishitem c2 = new Wishitem();

			c2.setName(d.getWishlist3_2());
			c2.setImage(d.getWishlist3image_2());
			c2.setChildname(d.getChildname_2());
			c2.setFamilyid(d.getUsername());

			wishList.add(c2);

		}
		
		
		

		String sql = "INSERT INTO familydonations.wishitem "
				+ "( name , image , childname , familyId )"
				+ " VALUES ( ?, ? , ? , ? )";
		
	
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
					
		/*	Wishitem c = new Wishitem();
			c.setName(d.getWishlist1_2());
			c.setImage(d.getWishlist1image_2());
			c.setChildname(d.getChildname_2());
			c.setFamilyid(d.getUsername());*/

			//@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Wishitem w = wishList.get(i);
				ps.setString(1, w.getName());
				ps.setString(2, w.getImage());
				ps.setString(3, w.getChildname() );
				ps.setString(4, w.getFamilyid());
			}
			
			//@Override
			public int getBatchSize() {
				return wishList.size();
			}
			
		});
		
	
	}

	
	
	private void registerChild(FamilyDTOUI d) {
		
	
		final List<Child> childList = new ArrayList<Child>();

		if (d.getChildname_0() != null) {

			Child c = new Child();
			c.setName(d.getChildname_0());
			c.setImage(d.getChildimage_0());
			c.setWishname(d.getWishlist1_0());
			c.setFamilyid(d.getUsername());

			childList.add(c);

			Child c1 = new Child();
			c1.setName(d.getChildname_0());
			c1.setImage(d.getChildimage_0());
			c1.setWishname(d.getWishlist2_0());
			c1.setFamilyid(d.getUsername());

			childList.add(c1);

			Child c2 = new Child();
			c2.setName(d.getChildname_0());
			c2.setImage(d.getChildimage_0());
			c2.setWishname(d.getWishlist3_0());
			c2.setFamilyid(d.getUsername());

			childList.add(c2);

		}

		if (d.getChildname_1() != null) {

			Child c = new Child();
			c.setName(d.getChildname_1());
			c.setImage(d.getChildimage_1());
			c.setWishname(d.getWishlist1_1());
			c.setFamilyid(d.getUsername());

			childList.add(c);

			Child c1 = new Child();
			c1.setName(d.getChildname_1());
			c1.setImage(d.getChildimage_1());
			c1.setWishname(d.getWishlist2_1());
			c1.setFamilyid(d.getUsername());

			childList.add(c1);

			Child c2 = new Child();
			c2.setName(d.getChildname_1());
			c2.setImage(d.getChildimage_1());
			c2.setWishname(d.getWishlist3_1());
			c2.setFamilyid(d.getUsername());

			childList.add(c2);

		}

		if (d.getChildname_2() != null) {

			Child c = new Child();
			c.setName(d.getChildname_2());
			c.setImage(d.getChildimage_2());
			c.setWishname(d.getWishlist1_2());
			c.setFamilyid(d.getUsername());

			childList.add(c);

			Child c1 = new Child();
			c1.setName(d.getChildname_2());
			c1.setImage(d.getChildimage_2());
			c1.setWishname(d.getWishlist2_2());
			c1.setFamilyid(d.getUsername());

			childList.add(c1);

			Child c2 = new Child();
			c2.setName(d.getChildname_2());
			c2.setImage(d.getChildimage_2());
			c2.setWishname(d.getWishlist3_2());
			c2.setFamilyid(d.getUsername());

			childList.add(c2);
		}
		
		String sql = "INSERT INTO familydonations.child "
				+ "( name , image , wishitemname , familyId )"
				+ " VALUES ( ?, ? , ? , ? )";
		
	
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
		/*	Wishitem c = new Wishitem();
			c.setName(d.getWishlist1_2());
			c.setImage(d.getWishlist1image_2());
			c.setChildname(d.getChildname_2());
			c.setFamilyid(d.getUsername());*/

			//@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Child w = childList.get(i);
				
				ps.setString(1, w.getName());
				ps.setString(2, w.getImage());
				ps.setString(3, w.getWishname() );
				ps.setString(4, w.getFamilyid());
			}
			
			//@Override
			public int getBatchSize() {
				return childList.size();
			}
			
		});

	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
