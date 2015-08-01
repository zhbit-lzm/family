package com.service.interfaces;

import com.tablebean.PersonalInformation;

public interface PersonalInformationService {
	public PersonalInformation getUserPI(int UserOid);//通过用户编号获取用户个人信息
	public PersonalInformation loadUserPI(int PIoid);//通过用户信息编号加载信息
	public void updatePI(PersonalInformation PI);//更新用户信息

}
