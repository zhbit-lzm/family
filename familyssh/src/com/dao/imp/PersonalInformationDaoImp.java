package com.dao.imp;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.dao.interfaces.PersonalInformationDao;

public class PersonalInformationDaoImp implements PersonalInformationDao {
	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

}
