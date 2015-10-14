package com.capstone.project.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer _userId;
	private String _lastName;
	private String _firstName;
	private String _loginUserId;
	private String _passWord;
	private Integer _familyId;
	private String _gender;
	private LocalDate _dateOfBirth;
	private String _userType; //FAMILY, DONOR, ADMIN
	
	public User(Integer userId, String lastName, String firstName, String loginUserId, String passWord,
			Integer familyId, String gender, LocalDate dateOfBirth, String userType) {
		super();
		_userId = userId;
		_lastName = lastName;
		_firstName = firstName;
		_loginUserId = loginUserId;
		_passWord = passWord;
		_familyId = familyId;
		_gender = gender;
		_dateOfBirth = dateOfBirth;
		_userType = userType;
	}

	public Integer getUserId() {
		return _userId;
	}

	public void setUserId(Integer userId) {
		_userId = userId;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLoginUserId() {
		return _loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		_loginUserId = loginUserId;
	}

	public String getPassWord() {
		return _passWord;
	}

	public void setPassWord(String passWord) {
		_passWord = passWord;
	}

	public Integer getFamilyId() {
		return _familyId;
	}

	public void setFamilyId(Integer familyId) {
		_familyId = familyId;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return _dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		_dateOfBirth = dateOfBirth;
	}
	
	public String getDonorType() {
		return _userType;
	}

	public void setDonorType(String userType) {
		_userType = userType;
	}

	@Override
	public String toString() {
		return "User [_userId=" + _userId + ", _lastName=" + _lastName + ", _firstName=" + _firstName
				+ ", _loginUserId=" + _loginUserId + ", _passWord=" + _passWord + ", _familyId=" + _familyId
				+ ", _gender=" + _gender + ", _dateOfBirth=" + _dateOfBirth + ", _userType=" + _userType + "]";
	}

}
