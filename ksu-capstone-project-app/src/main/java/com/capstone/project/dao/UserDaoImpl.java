package com.capstone.project.dao;

import java.util.Objects;

import java.util.List;
import com.capstone.project.model.Family;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.capstone.project.model.User;

public class UserDaoImpl implements UserDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
	private SessionFactory _sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		_sessionFactory = sessionFactory;
	}	
	
	@Override
	public User getUserByLogonIdAndPassword(String loginUserId, String password) throws IllegalStateException {		
		
		if (Objects.isNull(loginUserId) || Objects.isNull(password)) {
			LOGGER.error("[UserDaoImpl.getUserByLogonIdAndPassword] Error retrieving user. The user's login id and/or password is null.");
			return null;
		}
		
		User user = null;
		
		//Step 1: decrypt password
		//xxxxxx
		
		//Step 2: create a SHA-256 hash of the password
		String hashedPassword = "";
		
		try {
			Session currentSession = _sessionFactory.getCurrentSession();
			Query query = currentSession.getNamedQuery("getUserByUserIdAndPassword");
			query.setString("LoginUserId", loginUserId);
			query.setString("Password", hashedPassword);
			query.setResultTransformer(Transformers.aliasToBean(User.class));
			user = (User) query.uniqueResult();
		} catch (Exception e) {
			LOGGER.error("[UserDaoImpl.getUserByLogonIdAndPassword] Error retrieving user by login id and password", e);
			throw new IllegalStateException(e);
		}
		
		return user;
	}

}
