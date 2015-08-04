package com.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.dao.interfaces.UserDao;
import com.service.interfaces.UserService;
import com.tablebean.PersonalInformation;
import com.tablebean.UserInfo;
import com.tablebean.UserRelationship;
@Transactional
public class UserServiceImp implements UserService {
	@Resource
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public boolean checkUser(UserInfo user) {
		
		return userDao.checkUser(user);
	}

	
	public UserInfo getUser(UserInfo user) {
		
		return userDao.getUser(user);
	}


	public boolean register(UserInfo user) {
		
		return userDao.register(user);
	}

	
	public boolean resetPassword(UserInfo user) {
		
		return userDao.resetPassword(user);
	}

	
	public boolean addPersonalInformation(PersonalInformation PI) {
		
		return userDao.addPersonalInformation(PI);
	}

	
	public boolean addUserRelationship(UserRelationship UR) {
		
		return userDao.addUserRelationship(UR);
	}

	
	public PersonalInformation getUserPI(int UserOid) {
		
		return userDao.getUserPI(UserOid);
	}


	public List getUsers() {
	
		return userDao.getUsers();
	}


	public void refuseUser(int userOid) {
	
		userDao.refuseUser(userOid);
	}

	
	public void acceptUser(int userOid) {
		userDao.acceptUser(userOid);
		
	}
	

}
