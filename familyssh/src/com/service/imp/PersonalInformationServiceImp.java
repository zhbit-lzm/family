package com.service.imp;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.dao.interfaces.PersonalInformationDao;
import com.service.interfaces.PersonalInformationService;
import com.tablebean.PersonalInformation;

@Transactional
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

	
	public PersonalInformation getUserPI(int UserOid) {
		
		return personalInformationDao.getUserPI(UserOid);
	}


	public PersonalInformation loadUserPI(int PIoid) {
		
		return personalInformationDao.loadUserPI(PIoid);
	}


	public void updatePI(PersonalInformation PI) {
	
		personalInformationDao.updatePI(PI);
	}
	

}
