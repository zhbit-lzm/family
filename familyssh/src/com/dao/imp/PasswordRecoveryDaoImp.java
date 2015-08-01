package com.dao.imp;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.dao.interfaces.PasswordRecoveryDao;

public class PasswordRecoveryDaoImp implements PasswordRecoveryDao {
	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

}
