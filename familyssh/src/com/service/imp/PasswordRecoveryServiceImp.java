package com.service.imp;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.dao.interfaces.PasswordRecoveryDao;
import com.service.interfaces.PasswordRecoveryService;

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
	
	

}
