package com.group6.tibame104.coupon.model;

import java.sql.Date;

public class CouponVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer couponID;
	private String couponName;
	private Date startDate;
	private Date endDate;
	private Double discount;
	private Integer discountAmount;
	private Integer fullCondition;
	private Date couponTimeBegins;
	private Date couponTimeEnd;
	private Integer exchangeAmount;
	private byte[] couponPicture;
	private String couponDescription;
	
	public Integer getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(Integer discountAmount) {
		this.discountAmount = discountAmount;
	}
	
	public Integer getCouponID() {
		return couponID;
	}
	public void setCouponID(Integer couponID) {
		this.couponID = couponID;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
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
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Integer getFullCondition() {
		return fullCondition;
	}
	public void setFullCondition(Integer fullCondition) {
		this.fullCondition = fullCondition;
	}
	public Date getCouponTimeBegins() {
		return couponTimeBegins;
	}
	public void setCouponTimeBegins(Date couponTimeBegins) {
		this.couponTimeBegins = couponTimeBegins;
	}
	public Date getCouponTimeEnd() {
		return couponTimeEnd;
	}
	public void setCouponTimeEnd(Date couponTimeEnd) {
		this.couponTimeEnd = couponTimeEnd;
	}
	public Integer getExchangeAmount() {
		return exchangeAmount;
	}
	public void setExchangeAmount(Integer exchangeAmount) {
		this.exchangeAmount = exchangeAmount;
	}
	public byte[] getCouponPicture() {
		return couponPicture;
	}
	public void setCouponPicture(byte[] couponPicture) {
		this.couponPicture = couponPicture;
	}
	public String getCouponDescription() {
		return couponDescription;
	}
	public void setCouponDescription(String couponDescription) {
		this.couponDescription = couponDescription;
	}

}
