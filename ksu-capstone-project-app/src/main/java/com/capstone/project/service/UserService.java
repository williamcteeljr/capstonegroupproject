package com.capstone.project.service;

import java.time.LocalDate;
import java.util.List;

import com.capstone.project.dto.UserDTO;
import com.capstone.project.dto.UserRoleDTO;
import com.capstone.project.dto.UserRolePermissionDTO;

public interface UserService {

	UserDTO getRegisteredUserByLoginIdAndPassword(String loginUserId, String password);
	UserDTO getRegisteredUserByUserId(Integer userId);
	UserRoleDTO getUserRoleByUserId(Integer userId);
	UserRoleDTO getUserRoleByLogonId(String loginUserId);
	List<UserRolePermissionDTO> getUserPermissionsByUserRoleId(Integer userRoleId);
	void createRegisteredUser(String lastName, String firstName, String loginUserId, String passWord,
		    Integer familyId, String gender, LocalDate dateOfBirth, String userType);
	void saveRegisteredUserChanges(String lastName, String firstName, String loginUserId, String passWord,
		    Integer familyId, String gender, LocalDate dateOfBirth, String userType);
	void removeRegisteredUser(String loginUserId);
}
