package com.capstone.project.donation;

import java.util.List;

import com.capstone.project.family.FamilyDTO;

public class DonationFamilyResponse {

	private List<FamilyDTO> familyList;
	

	public List<FamilyDTO> getFamilyList() {
		return familyList;
	}

	public void setFamilyList(List<FamilyDTO> familyList) {
		this.familyList = familyList;
	}
}
