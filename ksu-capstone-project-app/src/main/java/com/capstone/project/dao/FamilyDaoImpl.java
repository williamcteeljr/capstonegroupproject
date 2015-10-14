package com.capstone.project.dao;

import java.util.List;

import javax.annotation.Resource;

import com.capstone.project.model.Family;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FamilyDaoImpl implements FamilyDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FamilyDaoImpl.class);
	
	@Resource
	private SessionFactory _sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		_sessionFactory = sessionFactory;
	}	

	@Override
	public List<Family> getFamiles() {
		
		List<Family> familyList = null;		
		try {
			Session currentSession = _sessionFactory.getCurrentSession();
			Query query = currentSession.getNamedQuery("getFamilies");
			query.setResultTransformer(Transformers.aliasToBean(Family.class));
			familyList = (List<Family>) query.list();
		} catch (Exception e) {
			LOGGER.error("[FamilyDaoImpl.getFamiles] Error retrieving list of families", e);
			throw e;
		}
		return familyList;
	}

	//TODO: finish building out other Family queries
}
