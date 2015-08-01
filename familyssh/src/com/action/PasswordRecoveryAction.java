package com.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.service.interfaces.PasswordRecoveryService;

public class PasswordRecoveryAction extends ActionSupport {
	//用户找回密码表操作
	@Resource
	PasswordRecoveryService passwordRecoveryService;

	public PasswordRecoveryService getPasswordRecoveryService() {
		return passwordRecoveryService;
	}

	public void setPasswordRecoveryService(
			PasswordRecoveryService passwordRecoveryService) {
		this.passwordRecoveryService = passwordRecoveryService;
	}
	

}
