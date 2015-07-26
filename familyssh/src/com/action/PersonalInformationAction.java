package com.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.interfaces.PersonalInformationService;
import com.tablebean.PersonalInformation;
import com.tablebean.UserInfo;

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
		HttpSession session= ServletActionContext.getRequest().getSession();
		UserInfo user=(UserInfo) session.getAttribute("user");
		//从session 中获取用户编号
		 PI=personalInformationService.getUserPI(user.getOid());
		
		if(PI==null)
		{
			addFieldError("error", "获取失败，没用记录");
			return "error";
		}
	
		
		//session.setAttribute("userPI", PI);
		
		return "success";
		
	}

	public void validateGetUserPI() {
		
		HttpSession session= ServletActionContext.getRequest().getSession();
		if(session.getAttribute("user")==null)
		{
			addFieldError("error", "请登录");
		}	
	}
	public String updateUserPI()
	{
		//加载其他信息
		PersonalInformation nowPI=personalInformationService.loadUserPI(PI.getOid());
		
		//更新信息
		nowPI.setUserAddress(PI.getUserAddress());
		nowPI.setUserBirthday(PI.getUserBirthday());
		nowPI.setUserName(PI.getUserName());
		nowPI.setUserPhone(PI.getUserPhone());
		nowPI.setUserSex(PI.getUserSex());
		System.out.println(" "+PI.getUserSex());
		
		personalInformationService.updatePI(nowPI);
		
		
		return "success";
	}
	
	
	
	

}
