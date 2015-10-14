package com.capstone.project.dto;

import java.io.Serializable;
import java.util.List;

public class FamilyDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer _familyId;
	private String _familyName;
	private String _address1;
	private String _address2;
	private String _city;
	private String _state;
	private String _zip;
	private String _contactPhone;
	private String _email;
	
	public FamilyDTO() {
	}

	public FamilyDTO(Integer familyId, String familyName, String address1, String address2, String city, String state,
			String zip, String contactPhone, String email) {
		super();
		_familyId = familyId;
		_familyName = familyName;
		_address1 = address1;
		_address2 = address2;
		_city = city;
		_state = state;
		_zip = zip;
		_contactPhone = contactPhone;
		_email = email;
	}

	public Integer getFamilyId() {
		return _familyId;
	}

	public void setFamilyId(Integer familyId) {
		_familyId = familyId;
	}

	public String getFamilyName() {
		return _familyName;
	}

	public void setFamilyName(String familyName) {
		_familyName = familyName;
	}

	public String getAddress1() {
		return _address1;
	}

	public void setAddress1(String address1) {
		_address1 = address1;
	}

	public String getAddress2() {
		return _address2;
	}

	public void setAddress2(String address2) {
		_address2 = address2;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getZip() {
		return _zip;
	}

	public void setZip(String zip) {
		_zip = zip;
	}

	public String getContactPhone() {
		return _contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		_contactPhone = contactPhone;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	@Override
	public String toString() {
		return "Family [_familyId=" + _familyId + ", _familyName=" + _familyName + ", _address1=" + _address1
				+ ", _address2=" + _address2 + ", _city=" + _city + ", _state=" + _state + ", _zip=" + _zip
				+ ", _contactPhone=" + _contactPhone + ", _email=" + _email + "]";
	}
}
