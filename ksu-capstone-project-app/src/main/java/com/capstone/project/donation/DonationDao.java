package com.capstone.project.donation;

import java.util.List;

import com.capstone.project.family.FamilyDTO;


public interface DonationDao {
	
	public List<FamilyDTO> getapprovedFamilies();
	
}
