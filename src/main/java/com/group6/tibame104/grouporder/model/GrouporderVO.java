package com.group6.tibame104.grouporder.model;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="groupBuyOrder")
public class GrouporderVO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="groupBuyOrderID")
	private Integer groupBuyOrderID;
	@Column(name="groupBuyID")
	private Integer groupBuyID;
	@Column(name="memberID")
	private Integer memberID;
	@Column(name="groupBuyProductID")
	private Integer groupBuyProductID;
	@Column(name="groupBuyQuantity")
	private Integer groupBuyQuantity;
	@Column(name="groupBuyTotal")
	private Integer groupBuyTotal;
	@Column(name="orderTime")
	private Timestamp orderTime;
	@Column(name="paymentTerm")
	private String paymentTerm;
	@Column(name="paymentState", columnDefinition = "bit")
	private Integer paymentState;
	@Column(name="giftVoucher")
	private Integer giftVoucher;
	@Column(name="contactNumber")
	private String contactNumber;
	@Column(name="shippingLocation")
	private String shippingLocation;

	@Override
	public String toString() {
		return "GrouporderVO [groupBuyOrderID=" + groupBuyOrderID + ", groupBuyID=" + groupBuyID + ", memberID="
				+ memberID + ", groupBuyProductID=" + groupBuyProductID + ", groupBuyQuantity=" + groupBuyQuantity
				+ ", groupBuyTotal=" + groupBuyTotal + ", orderTime=" + orderTime + ", paymentTerm=" + paymentTerm
				+ ", paymentState=" + paymentState + ", giftVoucher=" + giftVoucher + ", contactNumber=" + contactNumber
				+ ", shippingLocation=" + shippingLocation + "]";
	}

	public Integer getGroupBuyOrderID() {
		return groupBuyOrderID;
	}

	public void setGroupBuyOrderID(Integer groupBuyOrderID) {
		this.groupBuyOrderID = groupBuyOrderID;
	}

	public Integer getGroupBuyID() {
		return groupBuyID;
	}

	public void setGroupBuyID(Integer groupBuyID) {
		this.groupBuyID = groupBuyID;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public Integer getGroupBuyProductID() {
		return groupBuyProductID;
	}

	public void setGroupBuyProductID(Integer groupBuyProductID) {
		this.groupBuyProductID = groupBuyProductID;
	}

	public Integer getGroupBuyQuantity() {
		return groupBuyQuantity;
	}

	public void setGroupBuyQuantity(Integer groupBuyQuantity) {
		this.groupBuyQuantity = groupBuyQuantity;
	}

	public Integer getGroupBuyTotal() {
		return groupBuyTotal;
	}

	public void setGroupBuyTotal(Integer groupBuyTotal) {
		this.groupBuyTotal = groupBuyTotal;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public String getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public Integer getPaymentState() {
		return paymentState;
	}

	public void setPaymentState(Integer paymentState) {
		this.paymentState = paymentState;
	}

	public Integer getGiftVoucher() {
		return giftVoucher;
	}

	public void setGiftVoucher(Integer giftVoucher) {
		this.giftVoucher = giftVoucher;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getShippingLocation() {
		return shippingLocation;
	}

	public void setShippingLocation(String shippingLocation) {
		this.shippingLocation = shippingLocation;
	}

}
