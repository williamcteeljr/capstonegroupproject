package com.capstone.project.service;

import java.util.List;

import com.capstone.project.dto.FamilyDTO;
import com.capstone.project.dto.FamilyMemberDTO;

public interface FamilyService {
	
	List<FamilyDTO> getFamiliesList();
	FamilyDTO getFamilyByFamilyId(Integer familyId);
	FamilyDTO getFamilyByFamilyName(String familyName);
	List<FamilyMemberDTO> getFamilyMembersByFamilyId(Integer familyId);
	FamilyMemberDTO getFamilyMemberByMemberName(String familyMemberFullName);
	void createFamily(String familyName, String address1, String address2, String city, 
			String state, String zip, String contactPhone, String email);
	void saveFamilyChanges(String familyName, String address1, String address2, String city, 
			String state, String zip, String contactPhone, String email);
	void removeFamily(Integer familyId);  //ADMIN use only
}
