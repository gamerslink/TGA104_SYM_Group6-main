package com.group6.tibame104.order.model;


import java.sql.Date;
import java.sql.Timestamp;

public class OrderVO {
	private Integer orderID ;
	private Integer storeID ;
	private String storeName ;
	private Integer memberID ;
	
	
	private Timestamp orderDate ;
	private Integer orderStatus;
	private String receiver;
	private String phone ;
	private String creditcardNumber;
	private String address ;
	private String payType;
	private Integer couponID ;
	private Integer originalTotal;
	private Integer useShoppingGold;
	private Integer useCouponGold;
	private Integer finalTotal;
	
	
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public Integer getOrderID() {
		return orderID;
	}
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
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
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp timestamp) {
		this.orderDate = timestamp;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCreditcardNumber() {
		return creditcardNumber;
	}
	public void setCreditcardNumber(String creditcardNumber) {
		this.creditcardNumber = creditcardNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public Integer getCouponID() {
		return couponID;
	}
	public void setCouponID(Integer couponID) {
		this.couponID = couponID;
	}
	public Integer getOriginalTotal() {
		return originalTotal;
	}
	public void setOriginalTotal(Integer originalTotal) {
		this.originalTotal = originalTotal;
	}
	public Integer getUseShoppingGold() {
		return useShoppingGold;
	}
	public void setUseShoppingGold(Integer useShoppingGold) {
		this.useShoppingGold = useShoppingGold;
	}
	public Integer getUseCouponGold() {
		return useCouponGold;
	}
	public void setUseCouponGold(Integer useCouponGold) {
		this.useCouponGold = useCouponGold;
	}
	public Integer getFinalTotal() {
		return finalTotal;
	}
	public void setFinalTotal(Integer finalTotal) {
		this.finalTotal = finalTotal;
	}
}
