package com.group6.tibame104.announcement.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "announcement")
public class AnnouncementVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "announcementSerialID")
	private Integer announcementSerialID;
	@Column(name = "administratorID")
	private Integer administratorID;
	@Column(name = "announcementTitle")
	private String announcementTitle;
	@Column(name = "announcementContent")
	private String announcementContent;
	@Column(name = "startDate")
	private Date startDate;
	@Column(name = "endDate")
	private Date endDate;
	@Column(name = "updateTime")
	private Timestamp updateTime;
	@Column(name = "offLoadStatus")
	private Boolean offLoadStatus;
	@Column(name = "showStatus")
	private Boolean showStatus;
	public Integer getAnnouncementSerialID() {
		return announcementSerialID;
	}
	public void setAnnouncementSerialID(Integer announcementSerialID) {
		this.announcementSerialID = announcementSerialID;
	}
	public Integer getAdministratorID() {
		return administratorID;
	}
	public void setAdministratorID(Integer administratorID) {
		this.administratorID = administratorID;
	}
	public String getAnnouncementTitle() {
		return announcementTitle;
	}
	public void setAnnouncementTitle(String announcementTitle) {
		this.announcementTitle = announcementTitle;
	}
	public String getAnnouncementContent() {
		return announcementContent;
	}
	public void setAnnouncementContent(String announcementContent) {
		this.announcementContent = announcementContent;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Boolean getOffLoadStatus() {
		return offLoadStatus;
	}
	public void setOffLoadStatus(Boolean offLoadStatus) {
		this.offLoadStatus = offLoadStatus;
	}
	public Boolean getShowStatus() {
		return showStatus;
	}
	public void setShowStatus(Boolean showStatus) {
		this.showStatus = showStatus;
	}
	
}
