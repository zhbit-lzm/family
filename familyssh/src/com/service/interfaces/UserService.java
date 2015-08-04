package com.service.interfaces;

import java.util.List;

import com.tablebean.PersonalInformation;
import com.tablebean.UserInfo;
import com.tablebean.UserRelationship;

public interface UserService {
	public boolean checkUser(UserInfo user);//验证用户是否存在
	public UserInfo getUser(UserInfo user);//获取用户信息
	public boolean register(UserInfo user);//注册用户
	public boolean resetPassword(UserInfo user);//重置密码
	public boolean addPersonalInformation(PersonalInformation PI);//添加一条用户信息记录
	public boolean addUserRelationship(UserRelationship UR);//添加用户关系记录
	public PersonalInformation getUserPI(int UserOid);//通过用户编号获取用户个人信息
	public List getUsers();//获取用户列表
	public void refuseUser(int userOid);//用户回收授权
	public void acceptUser(int userOid);//用户授权

}
