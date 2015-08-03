package com.dao.imp;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.dao.interfaces.PasswordRecoveryDao;
import com.tablebean.PasswordRecovery;
import com.tablebean.UserInfo;

public class PasswordRecoveryDaoImp implements PasswordRecoveryDao {
	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public UserInfo getUserInfoByEmail(String userEmail) {
		
		return (UserInfo) sessionFactory.getCurrentSession().createQuery("from UserInfo where userEmail=?").setString(0,userEmail).uniqueResult();
				
	}


	public void alertPR(PasswordRecovery PR) {
		
		//首先判断该用户是否存在这条记录
		PasswordRecovery nowPR=(PasswordRecovery) sessionFactory.getCurrentSession().createQuery("from PasswordRecovery where userInfo.oid=?").setInteger(0,PR.getUserInfo().getOid()).uniqueResult();
		
		if(nowPR==null)
		{
			sessionFactory.getCurrentSession().save(PR);
		}		//sessionFactory.getCurrentSession().saveOrUpdate(object);
		else
		{
			nowPR.setCode(PR.getCode());
			nowPR.setUsefulTime(PR.getUsefulTime());
			nowPR.setIsUsed(PR.getIsUsed());
			sessionFactory.getCurrentSession().update(nowPR);
			
		}
		
	}

	
	public PasswordRecovery checkCodeEmail(String code, String Email) {
		
		return (PasswordRecovery) sessionFactory.getCurrentSession().createQuery("from PasswordRecovery where code=? and userInfo.userEmail=?").setString(0, code).setString(1, Email).uniqueResult();
	}

	
	public void PRisUsed(int PRoid) {
		PasswordRecovery pr=(PasswordRecovery) sessionFactory.getCurrentSession().load(PasswordRecovery.class, PRoid);
		pr.setIsUsed(true);
	}
	

}
