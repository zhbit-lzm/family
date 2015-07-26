package com.service.imp;

import javax.annotation.Resource;

import com.dao.interfaces.PersonalInformationDao;
import com.service.interfaces.PersonalInformationService;

public class PersonalInformationServiceImp implements
		PersonalInformationService {
	@Resource
	private PersonalInformationDao personalInformationDao;

	public PersonalInformationDao getPersonalInformationDao() {
		return personalInformationDao;
	}

	public void setPersonalInformationDao(
			PersonalInformationDao personalInformationDao) {
		this.personalInformationDao = personalInformationDao;
	}
	

}
