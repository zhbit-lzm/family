package com.tablebean;

import java.sql.Timestamp;

/**
 * PasswordRecovery entity. @author MyEclipse Persistence Tools
 */

public class PasswordRecovery implements java.io.Serializable {

	// Fields

	private Integer oid;
	private UserInfo userInfo;
	private Boolean isUsed;
	private String code;
	private Timestamp usefulTime;

	// Constructors

	/** default constructor */
	public PasswordRecovery() {
	}

	/** full constructor */
	public PasswordRecovery(UserInfo userInfo, Boolean isUsed, String code,
			Timestamp usefulTime) {
		this.userInfo = userInfo;
		this.isUsed = isUsed;
		this.code = code;
		this.usefulTime = usefulTime;
	}

	// Property accessors

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Boolean getIsUsed() {
		return this.isUsed;
	}

	public void setIsUsed(Boolean isUsed) {
		this.isUsed = isUsed;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Timestamp getUsefulTime() {
		return this.usefulTime;
	}

	public void setUsefulTime(Timestamp usefulTime) {
		this.usefulTime = usefulTime;
	}

}