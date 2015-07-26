package com.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.MD5Util;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.interfaces.UserService;
import com.tablebean.PersonalInformation;
import com.tablebean.UserInfo;
import com.tablebean.UserRelationship;
import com.tablebean.UserType;

public class UserAction extends ActionSupport {
	private UserInfo user;
	
	
	@Resource(name="userService")
	private UserService userService;
	private MD5Util md5=new MD5Util();
	
	

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//用户登录
	public String login()
	{
		//密码加密
		user.setUserPassword(md5.getMD5(user.getUserPassword().getBytes()));
		
		if(userService.checkUser(user))
		{
			UserInfo nowuser=userService.getUser(user);
			nowuser.setUserPassword("");
			
			HttpSession session= ServletActionContext.getRequest().getSession();
			
			session.setAttribute("user",nowuser);	
			int type=nowuser.getUserType().getTypeValue();
			if(type==1)
			{
				return "user";
			}
			if(type==2)
			{
				return "admin";
			}
			
			return "success";
		}
		else	
		{
			addFieldError("error", "用户帐号或用户密码不正确");
			return "input";
		}

	}
	//注销用户
	public String logout()
	{
		HttpSession session= ServletActionContext.getRequest().getSession();
		session.removeAttribute("user");
		return "success";
	}
	//用户注册
	public String register()
	{
		//设置用户类型
		UserType userType=new UserType();
		userType.setOid(1);
		user.setUserType(userType);
		
		//密码加密
		user.setUserPassword(md5.getMD5(user.getUserPassword().getBytes()));
		
		boolean ok=false;
		try
		{
		 ok=userService.register(user);
		 
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		//	System.out.println("捕获异常");
			
		}
		
		if(ok)
		{
			UserInfo nowuser=userService.getUser(user);
			
			PersonalInformation PI=new PersonalInformation();
			PI.setUserInfo(nowuser);
			UserRelationship UR=new UserRelationship();
			UR.setUserInfoByUserOid(nowuser);
			
			
			userService.addPersonalInformation(PI);
			userService.addUserRelationship(UR);
			
			
			
			return "success";
		}
		else
		{
			addFieldError("error", "注册失败邮箱或帐号已存在");
			return "input";
		}

	}
	
	public String resetPassword()
	{
		HttpSession session= ServletActionContext.getRequest().getSession();
		UserInfo nowuser=(UserInfo) session.getAttribute("user");
		nowuser.setUserPassword(md5.getMD5(user.getUserPassword().getBytes()));
		
		try{
		userService.resetPassword(nowuser);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			addFieldError("error", "重置失败");
			return "input";
		}
		
		
		return "success";
	}


	public void validateResetPassword() {
		HttpSession session= ServletActionContext.getRequest().getSession();
		
		
		if(session.getAttribute("user")==null)
		{
			addFieldError("error","必须先登录");
		}
		
		
	}
	
	
	

}
