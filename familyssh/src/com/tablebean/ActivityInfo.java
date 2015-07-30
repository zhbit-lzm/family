package com.tablebean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ActivityInfo entity. @author MyEclipse Persistence Tools
 */

public class ActivityInfo implements java.io.Serializable {

	// Fields

	private Integer oid;
	private UserInfo userInfo;
	private String information;
	private Date playDate;
	private String activityPost;
	private Set activityParticipants = new HashSet(0);
	private Set activityPictures = new HashSet(0);

	// Constructors

	/** default constructor */
	public ActivityInfo() {
	}

	/** full constructor */
	public ActivityInfo(UserInfo userInfo, String information, Date playDate,
			String activityPost, Set activityParticipants, Set activityPictures) {
		this.userInfo = userInfo;
		this.information = information;
		this.playDate = playDate;
		this.activityPost = activityPost;
		this.activityParticipants = activityParticipants;
		this.activityPictures = activityPictures;
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

	public String getInformation() {
		return this.information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public Date getPlayDate() {
		return this.playDate;
	}

	public void setPlayDate(Date playDate) {
		this.playDate = playDate;
	}

	public String getActivityPost() {
		return this.activityPost;
	}

	public void setActivityPost(String activityPost) {
		this.activityPost = activityPost;
	}

	public Set getActivityParticipants() {
		return this.activityParticipants;
	}

	public void setActivityParticipants(Set activityParticipants) {
		this.activityParticipants = activityParticipants;
	}

	public Set getActivityPictures() {
		return this.activityPictures;
	}

	public void setActivityPictures(Set activityPictures) {
		this.activityPictures = activityPictures;
	}

}