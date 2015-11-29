package com.capstone.project.dao;

import java.util.List;

import com.capstone.project.user.User;

public interface UserDao {
	
	public List<User> getUserList();
	public void registerUser(User user);

}
