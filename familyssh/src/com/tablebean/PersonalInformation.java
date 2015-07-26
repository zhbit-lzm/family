package com.tablebean;

import java.util.Date;

/**
 * PersonalInformation entity. @author MyEclipse Persistence Tools
 */

public class PersonalInformation implements java.io.Serializable {

	// Fields

	private Integer oid;
	private UserInfo userInfo;
	private String userName;
	private String userSex;
	private String userLogo;
	private String userAddress;
	private String userPhone;
	private Date userBirthday;

	// Constructors

	/** default constructor */
	public PersonalInformation() {
	}

	/** full constructor */
	public PersonalInformation(UserInfo userInfo, String userName,
			String userSex, String userLogo, String userAddress,
			String userPhone, Date userBirthday) {
		this.userInfo = userInfo;
		this.userName = userName;
		this.userSex = userSex;
		this.userLogo = userLogo;
		this.userAddress = userAddress;
		this.userPhone = userPhone;
		this.userBirthday = userBirthday;
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

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserLogo() {
		return this.userLogo;
	}

	public void setUserLogo(String userLogo) {
		this.userLogo = userLogo;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Date getUserBirthday() {
		return this.userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

}