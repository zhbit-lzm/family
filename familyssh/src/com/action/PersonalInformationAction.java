package com.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.interfaces.PersonalInformationService;
import com.tablebean.PersonalInformation;

public class PersonalInformationAction extends ActionSupport {
	private PersonalInformation PI;
	@Resource
	private PersonalInformationService personalInformationService;
	public PersonalInformation getPI() {
		return PI;
	}
	public void setPI(PersonalInformation pI) {
		PI = pI;
	}
	public PersonalInformationService getPersonalInformationService() {
		return personalInformationService;
	}
	public void setPersonalInformationService(
			PersonalInformationService personalInformationService) {
		this.personalInformationService = personalInformationService;
	}
	
	public String getUserPI()//获取用户个人信息
	{
		
		
		return "success";
		
	}

	public void validateGetUserPI() {
		
		HttpSession session= ServletActionContext.getRequest().getSession();
		if(session.getAttribute("user")==null)
		{
			addFieldError("error", "请登录");
		}
		
		
		
	}
	
	
	
	

}
