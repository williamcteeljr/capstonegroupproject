package com.capstone.project.user;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class User{

	
	
	//@XmlElement (name="userName")
	private String userName;
	//@XmlElement (name="passWord")
	private String passWord;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
