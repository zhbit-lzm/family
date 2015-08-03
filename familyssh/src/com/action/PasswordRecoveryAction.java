package com.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.http.server.ServletServerHttpRequest;

import com.bean.MD5Util;
import com.bean.SendEmail;
import com.opensymphony.xwork2.ActionSupport;
import com.service.interfaces.PasswordRecoveryService;
import com.service.interfaces.UserService;
import com.tablebean.PasswordRecovery;
import com.tablebean.UserInfo;

public class PasswordRecoveryAction extends ActionSupport {
	
	private String userEmail;
	private String userCode;
	private String result;//返回结果
	private String userPassword;
	
	
	
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	//用户找回密码表操作
	@Resource
	PasswordRecoveryService passwordRecoveryService;
	@Resource
	UserService userService;
	
	

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public PasswordRecoveryService getPasswordRecoveryService() {
		return passwordRecoveryService;
	}

	public void setPasswordRecoveryService(
			PasswordRecoveryService passwordRecoveryService) {
		this.passwordRecoveryService = passwordRecoveryService;
	}
	
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String sendCode()
	{
		//System.out.println(" "+userEmail);
		//result=userEmail;
		
		UserInfo user=passwordRecoveryService.getUserInfoByEmail(userEmail);
		if(user==null)
		{
			result="false";
			return "success";
		}
		
		//生成6位验证码
		String code="";
		Random r=new Random();
		for(int i=0;i<6;i++)
		{
			code=code+""+r.nextInt(10);
			
		}
		Date time=new Date();
		time.setMinutes(time.getMinutes()+30);//30分钟内有效
		
		
		
		
		PasswordRecovery pr=new PasswordRecovery();
		pr.setIsUsed(false);
		pr.setUserInfo(user);
		pr.setCode(code);
		pr.setUsefulTime(new Timestamp(time.getTime()));
		
		//System.out.println(" "+code);
		passwordRecoveryService.alertPR(pr);
		
		//发送验证码
		SendEmail se=new SendEmail();
		se.setUserEmail(userEmail);
		se.setVerificationCode(code);
		try {
			se.sendEmail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="error";
		}
		
		
		
		result="true";
		return "success";
	}
	
	public String codeEmailCheck()
	{
		System.out.println(userEmail+" "+userCode);
		//addFieldError("success", "验证成功");
		
		PasswordRecovery PR= passwordRecoveryService.checkCodeEmail(userCode, userEmail);
		if(PR==null)
		{
			//不存在
			addFieldError("error","验证码或邮箱不正确，请重新输入或重新获取");
			return "input";
		}
		
		if(PR.getIsUsed())
		{
			//已经验证了
			addFieldError("error","已经验证过了，请重新获取验证码");
			return "input";
			
		}
		Date nowtime=new Date();
		if(nowtime.after(PR.getUsefulTime()))
		{
			//当前时间迟于有效时间
			addFieldError("error","已经验证以经过期，请重新获取验证码");
			return "input";
			
		}
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("PR", PR);
		
		return "success";
	}
	public String findBackPassword()
	{
		if(userPassword.length()<6||userPassword.length()>18)
		{
			addFieldError("error","密码长度必须为6-18位");
			return "error";
		}
		
	    //获取信息
		HttpSession session=ServletActionContext.getRequest().getSession();
		PasswordRecovery pr= (PasswordRecovery) session.getAttribute("PR");
		UserInfo user=pr.getUserInfo();
		
		MD5Util md5=new MD5Util();
		user.setUserPassword(md5.getMD5(userPassword.getBytes()));
		
		
		passwordRecoveryService.PRisUsed(pr.getOid());
		userService.resetPassword(user);
		
		session.removeAttribute("PR");
		
		System.out.println(" "+userPassword);
		
		return "success";
	}

	//验证是否已经符合安全操作
	public void validateFindBackPassword() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		if(session.getAttribute("PR")==null)
		{
			addFieldError("error", "非法操作");
		}
	
	}
	
	
	

}
