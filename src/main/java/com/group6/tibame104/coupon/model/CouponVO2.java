package com.group6.tibame104.coupon.model;

public class CouponVO2 implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer memberID;
	private String userAccount;
	private String userName;
	private Integer couponID;
	private Integer usageRecord;
	private String couponName;
	private Double discount;
	private Integer discountAmount;
	private Integer fullCondition;
	private String couponDescription;
	
	public Integer getMemberID() {
		return memberID;
	}
	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getCouponID() {
		return couponID;
	}
	public void setCouponID(Integer couponID) {
		this.couponID = couponID;
	}
	public Integer getUsageRecord() {
		return usageRecord;
	}
	public void setUsageRecord(Integer usageRecord) {
		this.usageRecord = usageRecord;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Integer getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(Integer discountAmount) {
		this.discountAmount = discountAmount;
	}
	public Integer getFullCondition() {
		return fullCondition;
	}
	public void setFullCondition(Integer fullCondition) {
		this.fullCondition = fullCondition;
	}
	public String getCouponDescription() {
		return couponDescription;
	}
	public void setCouponDescription(String couponDescription) {
		this.couponDescription = couponDescription;
	}
	@Override
	public String toString() {
		return "CouponVO2 [memberID=" + memberID + ", userAccount=" + userAccount + ", userName=" + userName
				+ ", couponID=" + couponID + ", usageRecord=" + usageRecord + ", couponName=" + couponName
				+ ", discount=" + discount + ", discountAmount=" + discountAmount + ", fullCondition=" + fullCondition
				+ ", couponDescription=" + couponDescription + "]";
	}
	
	
}
