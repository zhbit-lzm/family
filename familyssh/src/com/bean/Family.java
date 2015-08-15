package com.bean;

import com.tablebean.PersonalInformation;

/**
 * @author Administrator
 *
 */
public class Family {
	private PersonalInformation father;
	private PersonalInformation mother;
	private PersonalInformation Spouse;
	private PersonalInformation myself;
	public PersonalInformation getFather() {
		return father;
	}
	public void setFather(PersonalInformation father) {
		this.father = father;
	}
	public PersonalInformation getMother() {
		return mother;
	}
	public void setMother(PersonalInformation mother) {
		this.mother = mother;
	}
	public PersonalInformation getSpouse() {
		return Spouse;
	}
	public void setSpouse(PersonalInformation spouse) {
		Spouse = spouse;
	}
	
	
	public PersonalInformation getMyself() {
		return myself;
	}
	public void setMyself(PersonalInformation myself) {
		this.myself = myself;
	}
	public Family()
	{
		
	}
	
}
