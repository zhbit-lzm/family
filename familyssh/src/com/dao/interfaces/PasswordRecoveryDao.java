package com.dao.interfaces;

import com.tablebean.PasswordRecovery;
import com.tablebean.UserInfo;

public interface PasswordRecoveryDao {
	public UserInfo getUserInfoByEmail(String userEmail);//根据用户电子邮件获取用户信息
	public void alertPR(PasswordRecovery PR);//更新用户找回密码表
	public PasswordRecovery checkCodeEmail(String code,String Email);//验证邮箱和验证码
	public void PRisUsed(int PRoid);//使用验证码
}
