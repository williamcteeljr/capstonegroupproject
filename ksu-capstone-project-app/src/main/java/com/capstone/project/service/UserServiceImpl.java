package com.capstone.project.service;

import java.time.LocalDate;
import java.util.List;

import com.capstone.project.dto.UserDTO;
import com.capstone.project.dto.UserRoleDTO;
import com.capstone.project.dto.UserRolePermissionDTO;

public class UserServiceImpl implements UserService {

	@Override
	public UserDTO getRegisteredUserByLoginIdAndPassword(String loginUserId, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO getRegisteredUserByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRoleDTO getUserRoleByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRoleDTO getUserRoleByLogonId(String loginUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRolePermissionDTO> getUserPermissionsByUserRoleId(Integer userRoleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createRegisteredUser(String lastName, String firstName, String loginUserId, String passWord,
			Integer familyId, String gender, LocalDate dateOfBirth, String userType) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveRegisteredUserChanges(String lastName, String firstName, String loginUserId, String passWord,
			Integer familyId, String gender, LocalDate dateOfBirth, String userType) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRegisteredUser(String loginUserId) {
		// TODO Auto-generated method stub

	}

}
