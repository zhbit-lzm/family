package com.tablebean;

import java.util.HashSet;
import java.util.Set;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	private Integer oid;
	private UserType userType;
	private String userAccount;
	private String userPassword;
	private String userEmail;
	private Set userRelationshipsForUserOid = new HashSet(0);
	private Set personalInformations = new HashSet(0);
	private Set userRelationshipsForUserMother = new HashSet(0);
	private Set userRelationshipsForUserFather = new HashSet(0);

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(UserType userType, String userAccount, String userPassword,
			String userEmail) {
		this.userType = userType;
		this.userAccount = userAccount;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
	}

	/** full constructor */
	public UserInfo(UserType userType, String userAccount, String userPassword,
			String userEmail, Set userRelationshipsForUserOid,
			Set personalInformations, Set userRelationshipsForUserMother,
			Set userRelationshipsForUserFather) {
		this.userType = userType;
		this.userAccount = userAccount;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userRelationshipsForUserOid = userRelationshipsForUserOid;
		this.personalInformations = personalInformations;
		this.userRelationshipsForUserMother = userRelationshipsForUserMother;
		this.userRelationshipsForUserFather = userRelationshipsForUserFather;
	}

	// Property accessors

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public UserType getUserType() {
		return this.userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Set getUserRelationshipsForUserOid() {
		return this.userRelationshipsForUserOid;
	}

	public void setUserRelationshipsForUserOid(Set userRelationshipsForUserOid) {
		this.userRelationshipsForUserOid = userRelationshipsForUserOid;
	}

	public Set getPersonalInformations() {
		return this.personalInformations;
	}

	public void setPersonalInformations(Set personalInformations) {
		this.personalInformations = personalInformations;
	}

	public Set getUserRelationshipsForUserMother() {
		return this.userRelationshipsForUserMother;
	}

	public void setUserRelationshipsForUserMother(
			Set userRelationshipsForUserMother) {
		this.userRelationshipsForUserMother = userRelationshipsForUserMother;
	}

	public Set getUserRelationshipsForUserFather() {
		return this.userRelationshipsForUserFather;
	}

	public void setUserRelationshipsForUserFather(
			Set userRelationshipsForUserFather) {
		this.userRelationshipsForUserFather = userRelationshipsForUserFather;
	}

}