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
	private Boolean usable;
	private Set passwordRecoveries = new HashSet(0);
	private Set userRelationshipsForUserSpouse = new HashSet(0);
	private Set userRelationshipsForUserMother = new HashSet(0);
	private Set personalInformations = new HashSet(0);
	private Set activityParticipants = new HashSet(0);
	private Set activityInfos = new HashSet(0);
	private Set userRelationshipsForUserFather = new HashSet(0);
	private Set userRelationshipsForUserOid = new HashSet(0);

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
			String userEmail, Boolean usable, Set passwordRecoveries,
			Set userRelationshipsForUserSpouse,
			Set userRelationshipsForUserMother, Set personalInformations,
			Set activityParticipants, Set activityInfos,
			Set userRelationshipsForUserFather, Set userRelationshipsForUserOid) {
		this.userType = userType;
		this.userAccount = userAccount;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.usable = usable;
		this.passwordRecoveries = passwordRecoveries;
		this.userRelationshipsForUserSpouse = userRelationshipsForUserSpouse;
		this.userRelationshipsForUserMother = userRelationshipsForUserMother;
		this.personalInformations = personalInformations;
		this.activityParticipants = activityParticipants;
		this.activityInfos = activityInfos;
		this.userRelationshipsForUserFather = userRelationshipsForUserFather;
		this.userRelationshipsForUserOid = userRelationshipsForUserOid;
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

	public Boolean getUsable() {
		return this.usable;
	}

	public void setUsable(Boolean usable) {
		this.usable = usable;
	}

	public Set getPasswordRecoveries() {
		return this.passwordRecoveries;
	}

	public void setPasswordRecoveries(Set passwordRecoveries) {
		this.passwordRecoveries = passwordRecoveries;
	}

	public Set getUserRelationshipsForUserSpouse() {
		return this.userRelationshipsForUserSpouse;
	}

	public void setUserRelationshipsForUserSpouse(
			Set userRelationshipsForUserSpouse) {
		this.userRelationshipsForUserSpouse = userRelationshipsForUserSpouse;
	}

	public Set getUserRelationshipsForUserMother() {
		return this.userRelationshipsForUserMother;
	}

	public void setUserRelationshipsForUserMother(
			Set userRelationshipsForUserMother) {
		this.userRelationshipsForUserMother = userRelationshipsForUserMother;
	}

	public Set getPersonalInformations() {
		return this.personalInformations;
	}

	public void setPersonalInformations(Set personalInformations) {
		this.personalInformations = personalInformations;
	}

	public Set getActivityParticipants() {
		return this.activityParticipants;
	}

	public void setActivityParticipants(Set activityParticipants) {
		this.activityParticipants = activityParticipants;
	}

	public Set getActivityInfos() {
		return this.activityInfos;
	}

	public void setActivityInfos(Set activityInfos) {
		this.activityInfos = activityInfos;
	}

	public Set getUserRelationshipsForUserFather() {
		return this.userRelationshipsForUserFather;
	}

	public void setUserRelationshipsForUserFather(
			Set userRelationshipsForUserFather) {
		this.userRelationshipsForUserFather = userRelationshipsForUserFather;
	}

	public Set getUserRelationshipsForUserOid() {
		return this.userRelationshipsForUserOid;
	}

	public void setUserRelationshipsForUserOid(Set userRelationshipsForUserOid) {
		this.userRelationshipsForUserOid = userRelationshipsForUserOid;
	}

}