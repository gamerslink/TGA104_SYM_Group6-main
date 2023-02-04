package com.group6.tibame104.administrator.model;

public class AdministratorVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer administratorID;
	private String administratorName;
	private String administratorAccount;
	private String administratorPassword;
	
	
	public Integer getAdministratorID() {
		return administratorID;
	}
	public void setAdministratorID(Integer administratorID) {
		this.administratorID = administratorID;
	}
	public String getAdministratorName() {
		return administratorName;
	}
	public void setAdministratorName(String administratorName) {
		this.administratorName = administratorName;
	}
	public String getAdministratorAccount() {
		return administratorAccount;
	}
	public void setAdministratorAccount(String administratorAccount) {
		this.administratorAccount = administratorAccount;
	}
	public String getAdministratorPassword() {
		return administratorPassword;
	}
	public void setAdministratorPassword(String administratorPassword) {
		this.administratorPassword = administratorPassword;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}


