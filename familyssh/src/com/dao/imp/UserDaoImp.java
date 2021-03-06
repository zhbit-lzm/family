package com.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.dao.interfaces.UserDao;
import com.tablebean.PersonalInformation;
import com.tablebean.UserInfo;
import com.tablebean.UserRelationship;

public class UserDaoImp implements UserDao {
	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public boolean checkUser() {
		//用户验证
		return false;
	}


	public boolean checkUser(UserInfo user) {
		//System.out.println("check");
		
	 UserInfo users=(UserInfo) sessionFactory.getCurrentSession().createQuery("from UserInfo where userAccount=? and userPassword=?").setString(0,user.getUserAccount()).setString(1,user.getUserPassword()).uniqueResult();
	if(users==null)
	{
		return false;
	}
	else
	{
		 return true;
	}
	
	 
	 
	}

	
	public UserInfo getUser(UserInfo user) {
		
		return (UserInfo) sessionFactory.getCurrentSession().createQuery("from UserInfo where userAccount=? and userPassword=?").setString(0,user.getUserAccount()).setString(1,user.getUserPassword()).uniqueResult();
	}

	
	public boolean register(UserInfo user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
		return true;
	}

	
	public boolean resetPassword(UserInfo user) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
		return true;
	}


	public boolean addPersonalInformation(PersonalInformation PI) {
		sessionFactory.getCurrentSession().save(PI);
		
		return true;
	}

	
	public boolean addUserRelationship(UserRelationship UR) {
		sessionFactory.getCurrentSession().save(UR);
		
		return true;
	}


	public PersonalInformation getUserPI(int UserOid) {
		
		//根据用户编号返回用户个人信息
		return (PersonalInformation) sessionFactory.getCurrentSession().createQuery("from PersonalInformation where userInfo.oid=?")
						.setInteger(0, UserOid).uniqueResult();
	}

	
	public List getUsers() {
		
		return sessionFactory.getCurrentSession().createQuery("from UserInfo").list();
	}


	public void refuseUser(int userOid) {
		
		UserInfo user=(UserInfo) sessionFactory.getCurrentSession().load(UserInfo.class, userOid);
		user.setUsable(false);
	}


	public void acceptUser(int userOid) {

		UserInfo user=(UserInfo) sessionFactory.getCurrentSession().load(UserInfo.class, userOid);
		user.setUsable(true);
		
	}
	

}
