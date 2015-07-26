package com.dao.imp;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.dao.interfaces.PersonalInformationDao;
import com.tablebean.PersonalInformation;

public class PersonalInformationDaoImp implements PersonalInformationDao {
	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public PersonalInformation getUserPI(int UserOid) {
	
		//根据用户编号返回用户信息
		return (PersonalInformation) sessionFactory.getCurrentSession().createQuery("from PersonalInformation where userInfo.oid=?")
		.setInteger(0, UserOid).uniqueResult();
	}

	
	public PersonalInformation loadUserPI(int PIoid) {
		
		return (PersonalInformation) sessionFactory.getCurrentSession().createQuery("from PersonalInformation where oid=?")
				.setInteger(0, PIoid).uniqueResult();
	}

	
	public void updatePI(PersonalInformation PI) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(PI);
		
	}
	

}
