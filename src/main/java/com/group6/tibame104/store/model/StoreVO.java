package com.group6.tibame104.store.model;

import java.sql.Timestamp;

public class StoreVO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer storeID;
	private Integer memberID;
	private String storeName;
	private String storeDelBankCode;
	private String storeBankAccount;
	private String storeAddress;
	private String phoneNumber;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String taxID;
	private Integer storeAuditStatus;

	public Integer getStoreID() {
		return storeID;
	}

	public void setStoreID(Integer storeID) {
		this.storeID = storeID;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreDelBankCode() {
		return storeDelBankCode;
	}

	public void setStoreDelBankCode(String storeDelBankCode) {
		this.storeDelBankCode = storeDelBankCode;
	}

	public String getStoreBankAccount() {
		return storeBankAccount;
	}

	public void setStoreBankAccount(String storeBankAccount) {
		this.storeBankAccount = storeBankAccount;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getTaxID() {
		return taxID;
	}

	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	public Integer getStoreAuditStatus() {
		return storeAuditStatus;
	}

	public void setStoreAuditStatus(Integer storeAuditStatus) {
		this.storeAuditStatus = storeAuditStatus;
	}

	@Override
	public String toString() {
		return "StoreVO [storeID=" + storeID + ", memberID=" + memberID + ", storeName=" + storeName
				+ ", storeDelBankCode=" + storeDelBankCode + ", storeBankAccount=" + storeBankAccount
				+ ", storeAddress=" + storeAddress + ", phoneNumber=" + phoneNumber + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", taxID=" + taxID + ", storeAuditStatus=" + storeAuditStatus + "]";
	}

}
