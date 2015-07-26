package com.tablebean;

/**
 * UserRelationship entity. @author MyEclipse Persistence Tools
 */

public class UserRelationship implements java.io.Serializable {

	// Fields

	private Integer oid;
	private UserInfo userInfoByUserMother;
	private UserInfo userInfoByUserFather;
	private UserInfo userInfoByUserOid;

	// Constructors

	/** default constructor */
	public UserRelationship() {
	}

	/** full constructor */
	public UserRelationship(UserInfo userInfoByUserMother,
			UserInfo userInfoByUserFather, UserInfo userInfoByUserOid) {
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