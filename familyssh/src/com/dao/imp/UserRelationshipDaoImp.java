package com.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.dao.interfaces.UserRelationshipDao;

public class UserRelationshipDaoImp implements UserRelationshipDao{
	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public List getAllRelationship() {

		return sessionFactory.getCurrentSession().createQuery("from UserRelationship").list();
	}
	

}
