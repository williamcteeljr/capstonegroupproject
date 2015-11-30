package com.capstone.project.donation.wish;

import java.util.List;

public class DonationWish {

	private DonationChild child;	
	private List<WishFamilyitem> wishlist;



	public List<WishFamilyitem> getWishlist() {
		return wishlist;
	}


	public void setWishlist(List<WishFamilyitem> wishlist) {
		this.wishlist = wishlist;
	}


	public DonationChild getChild() {
		return child;
	}


	public void setChild(DonationChild child) {
		this.child = child;
	}
	


}
