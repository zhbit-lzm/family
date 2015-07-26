package com.service.interfaces;

import com.tablebean.PersonalInformation;

public interface PersonalInformationService {
	public PersonalInformation getUserPI(int UserOid);
	public PersonalInformation loadUserPI(int PIoid);//通过用户信息编号加载信息
	public void updatePI(PersonalInformation PI);//更新用户信息

}
