package com.capstone.project.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class FamilyMemberDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer _familyMemeberId;
	private String _fullName;
	private String _gender;
	private LocalDate _dateOfBirth;
	
	public FamilyMemberDTO(Integer familyMemeberId, String fullName, String gender, LocalDate dateOfBirth) {
		super();
		_familyMemeberId = familyMemeberId;
		_fullName = fullName;
		_gender = gender;
		_dateOfBirth = dateOfBirth;
	}

	public Integer getFamilyMemeberId() {
		return _familyMemeberId;
	}

	public void setFamilyMemeberId(Integer familyMemeberId) {
		_familyMemeberId = familyMemeberId;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
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

	@Override
	public String toString() {
		return "FamilyMember [_familyMemeberId=" + _familyMemeberId + ", _fullName=" + _fullName + ", _gender="
				+ _gender + ", _dateOfBirth=" + _dateOfBirth + "]";
	}
	
	
}
