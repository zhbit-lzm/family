package com.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.dao.interfaces.UserRelationshipDao;
import com.service.interfaces.UserRelationshipService;
@Transactional
public class UserRelationshipServiceImp implements UserRelationshipService {
	@Resource
	private UserRelationshipDao userRelationshipDao;

	public UserRelationshipDao getUserRelationshipDao() {
		return userRelationshipDao;
	}

	public void setUserRelationshipDao(UserRelationshipDao userRelationshipDao) {
		this.userRelationshipDao = userRelationshipDao;
	}

	
	public List getAllRelationship() {
		
		return userRelationshipDao.getAllRelationship();
	}
	

}
