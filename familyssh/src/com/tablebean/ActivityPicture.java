package com.tablebean;

/**
 * ActivityPicture entity. @author MyEclipse Persistence Tools
 */

public class ActivityPicture implements java.io.Serializable {

	// Fields

	private Integer oid;
	private ActivityInfo activityInfo;
	private String imgPath;
	private String descripte;

	// Constructors

	/** default constructor */
	public ActivityPicture() {
	}

	/** full constructor */
	public ActivityPicture(ActivityInfo activityInfo, String imgPath,
			String descripte) {
		this.activityInfo = activityInfo;
		this.imgPath = imgPath;
		this.descripte = descripte;
	}

	// Property accessors

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public ActivityInfo getActivityInfo() {
		return this.activityInfo;
	}

	public void setActivityInfo(ActivityInfo activityInfo) {
		this.activityInfo = activityInfo;
	}

	public String getImgPath() {
		return this.imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getDescripte() {
		return this.descripte;
	}

	public void setDescripte(String descripte) {
		this.descripte = descripte;
	}

}