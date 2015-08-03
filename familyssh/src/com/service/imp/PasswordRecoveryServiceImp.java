package com.service.imp;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.dao.interfaces.PasswordRecoveryDao;
import com.service.interfaces.PasswordRecoveryService;
import com.tablebean.PasswordRecovery;
import com.tablebean.UserInfo;

@Transactional
public class PasswordRecoveryServiceImp implements PasswordRecoveryService {
	@Resource
	private PasswordRecoveryDao passwordRecoveryDao;

	public PasswordRecoveryDao getPasswordRecoveryDao() {
		return passwordRecoveryDao;
	}

	public void setPasswordRecoveryDao(PasswordRecoveryDao passwordRecoveryDao) {
		this.passwordRecoveryDao = passwordRecoveryDao;
	}


	public UserInfo getUserInfoByEmail(String userEmail) {
		return passwordRecoveryDao.getUserInfoByEmail(userEmail);
		
	}


	public void alertPR(PasswordRecovery PR) {
		passwordRecoveryDao.alertPR(PR);
		
	}


	public PasswordRecovery checkCodeEmail(String code, String Email) {
		
		return passwordRecoveryDao.checkCodeEmail(code, Email);
	}


	public void PRisUsed(int PRoid) {
	         passwordRecoveryDao.PRisUsed(PRoid);
		
	}
	
	

}
