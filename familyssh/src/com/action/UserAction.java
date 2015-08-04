package com.action;

import java.util.ArrayList;
import java.util.List;

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
	private List userList=new ArrayList();
	
	

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
	
	
	public void setUserList(List userList) {
		this.userList = userList;
	}
	
	public List getUserList() {
		return userList;
	}

	//用户登录
	public String login()
	{
		//密码加密
		user.setUserPassword(md5.getMD5(user.getUserPassword().getBytes()));
		
		if(userService.checkUser(user))
		{
			
			UserInfo nowuser=userService.getUser(user);
			if(nowuser.getUsable()==false)
			{
				addFieldError("error", "该帐号没有经过审批,请联系管理员");
				return "input";
			}
			
			nowuser.setUserPassword("");
			
			HttpSession session= ServletActionContext.getRequest().getSession();
			session.setAttribute("user",nowuser);	
			
			//获取用户个人信息加载到session
			PersonalInformation PI=userService.getUserPI(nowuser.getOid());
			session.setAttribute("userPI", PI);
			
			
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
		session.removeAttribute("userPI");
		return "success";
	}
	//用户注册
	public String register()
	{
		//设置用户类型
		UserType userType=new UserType();
		userType.setOid(1);
		user.setUserType(userType);
		user.setUsable(false);//没有审批
		
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
	
	public String getUsers()
	{
		HttpSession session= ServletActionContext.getRequest().getSession();
		UserInfo user=(UserInfo) session.getAttribute("user");
		if(user.getUserType().getTypeValue()!=2)
		{
			addFieldError("error","非法操作");
			return "error";
		}
		
		userList =userService.getUsers();
		
		return "success";
	}

	
	public void validateGetUsers() {
		HttpSession session= ServletActionContext.getRequest().getSession();
		if(session.getAttribute("user")==null)
		{
			addFieldError("error", "请登录");
		}
	}
	
	//用户授权
	public String acceptUser()
	{
		HttpSession session= ServletActionContext.getRequest().getSession();
		UserInfo nowuser=(UserInfo) session.getAttribute("user");
		
		if(nowuser.getOid()==user.getOid())
		{
			addFieldError("error", "自己不能修改自己");
			return "success";
		}
		
		userService.acceptUser(user.getOid());
		
		return "success";
	}
	//
	public String refuseUser()
	{
		HttpSession session= ServletActionContext.getRequest().getSession();
		UserInfo nowuser=(UserInfo) session.getAttribute("user");
		
		if(nowuser.getOid()==user.getOid())
		{
			addFieldError("error", "自己不能修改自己");
			return "success";
		}
		userService.refuseUser(user.getOid());
		
		return "success";
	}
	
	
	

}
