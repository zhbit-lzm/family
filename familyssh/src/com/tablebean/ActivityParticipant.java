package com.tablebean;

import java.util.Date;

/**
 * ActivityParticipant entity. @author MyEclipse Persistence Tools
 */

public class ActivityParticipant implements java.io.Serializable {

	// Fields

	private Integer oid;
	private UserInfo userInfo;
	private ActivityInfo activityInfo;
	private Date joinTime;

	// Constructors

	/** default constructor */
	public ActivityParticipant() {
	}

	/** full constructor */
	public ActivityParticipant(UserInfo userInfo, ActivityInfo activityInfo,
			Date joinTime) {
		this.userInfo = userInfo;
		this.activityInfo = activityInfo;
		this.joinTime = joinTime;
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

	public ActivityInfo getActivityInfo() {
		return this.activityInfo;
	}

	public void setActivityInfo(ActivityInfo activityInfo) {
		this.activityInfo = activityInfo;
	}

	public Date getJoinTime() {
		return this.joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

}