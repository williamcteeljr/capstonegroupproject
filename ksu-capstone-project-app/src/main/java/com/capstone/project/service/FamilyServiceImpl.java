package com.capstone.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.capstone.project.dao.FamilyDao;
import com.capstone.project.dao.FamilyDaoImpl;
import com.capstone.project.dto.FamilyDTO;
import com.capstone.project.dto.FamilyMemberDTO;
import com.capstone.project.model.Family;

public class FamilyServiceImpl implements FamilyService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FamilyServiceImpl.class);

	@Resource
	private FamilyDao _familyDao;

	public void setFamilyDao(FamilyDao familyDao) {
		_familyDao = familyDao;
	}

	@Override
	public List<FamilyDTO> getFamiliesList() {
		
		FamilyDTO familyDto = null;
		List<Family> familyList = new ArrayList<>();
		List<FamilyDTO> familyDtoList = new ArrayList<>();
		try {
			familyList = _familyDao.getFamiles();
			if (Objects.isNull(familyList)) {
				LOGGER.error("[FamilyServiceImpl.getFamiliesList] _familyDao.getFamiles() returned null. Returning an empty FamilyDTO list.");
				return familyDtoList;
			}
			for (Family family : familyList) {
				familyDto = new FamilyDTO();
				familyDto.setFamilyId(family.getFamilyId());
				familyDto.setFamilyName(family.getFamilyName());
				familyDto.setAddress1(family.getAddress1());
				familyDto.setAddress2(family.getAddress2());
				familyDto.setCity(family.getCity());
				familyDto.setState(family.getState());
				familyDto.setZip(family.getZip());
				familyDto.setContactPhone(family.getContactPhone());
				familyDto.setEmail(family.getEmail());
				familyDtoList.add(familyDto);			
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return familyDtoList;
	}

	@Override
	public FamilyDTO getFamilyByFamilyId(Integer familyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FamilyDTO getFamilyByFamilyName(String familyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FamilyMemberDTO> getFamilyMembersByFamilyId(Integer familyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FamilyMemberDTO getFamilyMemberByMemberName(String familyMemberFullName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createFamily(String familyName, String address1, String address2, String city, String state, String zip,
			String contactPhone, String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveFamilyChanges(String familyName, String address1, String address2, String city, String state,
			String zip, String contactPhone, String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFamily(Integer familyId) {
		// TODO Auto-generated method stub

	}

}
