package com.group6.tibame104.ad.model;

import java.sql.Date;
import java.sql.Timestamp;

public class AdVO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer adSerialID;
	private Integer administratorID;
	private Integer groupBuyID;
	private String adTitle;
	private String adType;
	private String adDescribe;
	private byte[] adPhoto;
	private Date adStartDate;
	private Date adEndDate;
	private Timestamp updateTime;
	public Integer getAdSerialID() {
		return adSerialID;
	}
	public void setAdSerialID(Integer adSerialID) {
		this.adSerialID = adSerialID;
	}
	public Integer getAdministratorID() {
		return administratorID;
	}
	public void setAdministratorID(Integer administratorID) {
		this.administratorID = administratorID;
	}
	public Integer getGroupBuyID() {
		return groupBuyID;
	}
	public void setGroupBuyID(Integer groupBuyID) {
		this.groupBuyID = groupBuyID;
	}
	public String getAdTitle() {
		return adTitle;
	}
	public void setAdTitle(String adTitle) {
		this.adTitle = adTitle;
	}
	public String getAdType() {
		return adType;
	}
	public void setAdType(String adType) {
		this.adType = adType;
	}
	public String getAdDescribe() {
		return adDescribe;
	}
	public void setAdDescribe(String adDescribe) {
		this.adDescribe = adDescribe;
	}
	public byte[] getAdPhoto() {
		return adPhoto;
	}
	public void setAdPhoto(byte[] adPhoto) {
		this.adPhoto = adPhoto;
	}
	public Date getAdStartDate() {
		return adStartDate;
	}
	public void setAdStartDate(Date adStartDate) {
		this.adStartDate = adStartDate;
	}
	public Date getAdEndDate() {
		return adEndDate;
	}
	public void setAdEndDate(Date adEndDate) {
		this.adEndDate = adEndDate;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
