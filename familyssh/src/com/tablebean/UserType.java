package com.tablebean;

import java.util.HashSet;
import java.util.Set;

/**
 * UserType entity. @author MyEclipse Persistence Tools
 */

public class UserType implements java.io.Serializable {

	// Fields

	private Integer oid;
	private Integer typeValue;
	private String typeDescription;
	private Set userInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public UserType() {
	}

	/** minimal constructor */
	public UserType(Integer typeValue) {
		this.typeValue = typeValue;
	}

	/** full constructor */
	public UserType(Integer typeValue, String typeDescription, Set userInfos) {
		this.typeValue = typeValue;
		this.typeDescription = typeDescription;
		this.userInfos = userInfos;
	}

	// Property accessors

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getTypeValue() {
		return this.typeValue;
	}

	public void setTypeValue(Integer typeValue) {
		this.typeValue = typeValue;
	}

	public String getTypeDescription() {
		return this.typeDescription;
	}

	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}

	public Set getUserInfos() {
		return this.userInfos;
	}

	public void setUserInfos(Set userInfos) {
		this.userInfos = userInfos;
	}

}