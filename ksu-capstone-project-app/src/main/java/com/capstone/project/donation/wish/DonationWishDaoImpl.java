package com.capstone.project.donation.wish;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.capstone.project.family.Wishitem;

public class DonationWishDaoImpl implements DonationWishDao {

	DataSource dataSource;

	@Override
	public List<DonationWish> geallWish(String familyId) {

		List<DonationWish> wishes = new ArrayList<DonationWish>();

		String sql1 = "select * from familydonations.child where familyId='%s'";
		sql1 = String.format(sql1, familyId);

		String sql2 = "select * from familydonations.wishitem where familyId='%s' and status <> 'COMPLETED' ";
		sql2 = String.format(sql2, familyId);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<DonationChild> childList = jdbcTemplate.query(sql1,
				new RowMapper<DonationChild>() {

					public DonationChild mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						DonationChild a = new DonationChild();
						a.setName(rs.getString("name"));
						a.setImage(rs.getString("image"));
						return a;
					}
				});
		List<Wishitem> wishList = jdbcTemplate.query(sql2,

		new RowMapper<Wishitem>() {
			public Wishitem mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Wishitem a = new Wishitem();
				a.setFamilyid(rs.getString("familyid"));
				a.setName(rs.getString("name"));
				a.setChildname(rs.getString("childname"));
				a.setImage(rs.getString("image"));
				return a;
			}
		});


		Set<String> childCheck =  new HashSet<String>();
		
		for (DonationChild c : childList) {

			if(!childCheck.contains(c.name)){
				childCheck.add(c.getName());
				
				DonationWish d = new DonationWish();
				DonationChild child = new DonationChild();

				child.setImage(c.getImage());
				child.setName(c.getName());

				List<WishFamilyitem> wishlist = new ArrayList<WishFamilyitem>();

				for (Wishitem w : wishList) {
					WishFamilyitem i = null;
					if (w.getChildname().equalsIgnoreCase(c.getName())) {
						i = new WishFamilyitem();
						i.setImage(w.getImage());
						i.setName(w.getName());
						wishlist.add(i);
					}
				}

				d.setChild(child);
				d.setWishlist(wishlist);
				wishes.add(d);				
			}
		}

		return wishes;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
