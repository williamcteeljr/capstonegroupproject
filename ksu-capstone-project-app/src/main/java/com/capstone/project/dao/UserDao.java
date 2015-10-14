package com.capstone.project.dao;

import com.capstone.project.model.User;

public interface UserDao {

	User getUserByLogonIdAndPassword(String loginUserId, String password);
}
