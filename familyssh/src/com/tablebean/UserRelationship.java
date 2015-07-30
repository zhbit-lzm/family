package com.tablebean;

/**
 * UserRelationship entity. @author MyEclipse Persistence Tools
 */

public class UserRelationship implements java.io.Serializable {

	// Fields

	private Integer oid;
	private UserInfo userInfoByUserSpouse;
	private UserInfo userInfoByUserMother;
	private UserInfo userInfoByUserFather;
	private UserInfo userInfoByUserOid;

	// Constructors

	/** default constructor */
	public UserRelationship() {
	}

	/** full constructor */
	public UserRelationship(UserInfo userInfoByUserSpouse,
			UserInfo userInfoByUserMother, UserInfo userInfoByUserFather,
			UserInfo userInfoByUserOid) {
		this.userInfoByUserSpouse = userInfoByUserSpouse;
		this.userInfoByUserMother = userInfoByUserMother;
		this.userInfoByUserFather = userInfoByUserFather;
		this.userInfoByUserOid = userInfoByUserOid;
	}

	// Property accessors

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public UserInfo getUserInfoByUserSpouse() {
		return this.userInfoByUserSpouse;
	}

	public void setUserInfoByUserSpouse(UserInfo userInfoByUserSpouse) {
		this.userInfoByUserSpouse = userInfoByUserSpouse;
	}

	public UserInfo getUserInfoByUserMother() {
		return this.userInfoByUserMother;
	}

	public void setUserInfoByUserMother(UserInfo userInfoByUserMother) {
		this.userInfoByUserMother = userInfoByUserMother;
	}

	public UserInfo getUserInfoByUserFather() {
		return this.userInfoByUserFather;
	}

	public void setUserInfoByUserFather(UserInfo userInfoByUserFather) {
		this.userInfoByUserFather = userInfoByUserFather;
	}

	public UserInfo getUserInfoByUserOid() {
		return this.userInfoByUserOid;
	}

	public void setUserInfoByUserOid(UserInfo userInfoByUserOid) {
		this.userInfoByUserOid = userInfoByUserOid;
	}

}