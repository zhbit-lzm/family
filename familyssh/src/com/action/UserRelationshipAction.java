package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.Family;
import com.opensymphony.xwork2.ActionSupport;
import com.service.interfaces.PersonalInformationService;
import com.service.interfaces.UserRelationshipService;
import com.tablebean.UserInfo;
import com.tablebean.UserRelationship;

public class UserRelationshipAction extends ActionSupport {
	@Resource
	private UserRelationshipService userRelationshipService;
	@Resource
	private PersonalInformationService personalInformationService;
	
	private List list=new ArrayList<Family>();
	
	

	public UserRelationshipService getUserRelationshipService() {
		return userRelationshipService;
	}

	public void setUserRelationshipService(
			UserRelationshipService userRelationshipService) {
		this.userRelationshipService = userRelationshipService;
	}
	
	
	public PersonalInformationService getPersonalInformationService() {
		return personalInformationService;
	}

	public void setPersonalInformationService(
			PersonalInformationService personalInformationService) {
		this.personalInformationService = personalInformationService;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String getAllRelationship()
	{
		List getlist=userRelationshipService.getAllRelationship();
		//获取用户关系列表
		//通过循环获取用户信息 父母配偶的信息
		for(int i=0;i<getlist.size();i++)
		{
			UserRelationship  user=(UserRelationship) getlist.get(i);
			//System.out.println("父亲："+user.getUserInfoByUserFather().getOid()+" 母亲:"+user.getUserInfoByUserMother().getOid()+" 配偶："+user.getUserInfoByUserSpouse().getOid());
			Family family=new Family();
			
			//获取父亲信息
			if(user.getUserInfoByUserFather()!=null)
			{
				family.setFather(personalInformationService.getUserPI(user.getUserInfoByUserFather().getOid()));
			}
			else
			{
				family.setFather(null);
			}
			
			//获取母亲信息
			if(user.getUserInfoByUserMother()!=null)
			{
				family.setMother(personalInformationService.getUserPI(user.getUserInfoByUserMother().getOid()));
			}
			else
			{
				family.setMother(null);
			}
			
			//获取自己的信息
			family.setMyself(personalInformationService.getUserPI(user.getUserInfoByUserOid().getOid()));
			
			//获取配偶信息
			if(user.getUserInfoByUserSpouse()!=null)
			{
				family.setSpouse(personalInformationService.getUserPI(user.getUserInfoByUserSpouse().getOid()));
			}
			//加入到数组中
			list.add(family);
	
		}
	
		
		
		return "success";
	}

	
	public void validateGetAllRelationship() {
		
		HttpSession session= ServletActionContext.getRequest().getSession();
		UserInfo nowuser=(UserInfo) session.getAttribute("user");
		
		if(nowuser.getUserType().getTypeValue()!=2)
		{
			addFieldError("error", "非法操作");
		}
		
	}
	
	
	

}
