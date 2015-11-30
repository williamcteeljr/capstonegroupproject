package com.capstone.project.donation.wish.submit;

import java.util.List;

public class WishSubmitRequest {

	private List<String> gift;
	private String familyId;
	private String userId;
	
	
	public List<String> getGift() {
		return gift;
	}
	public void setGift(List<String> gift) {
		this.gift = gift;
	}
	public String getFamilyId() {
		return familyId;
	}
	public void setFamilyId(String familyId) {
		this.familyId = familyId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}	
}
