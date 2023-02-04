package com.group6.tibame104.shoppingGoldRecord.model;

import java.sql.Timestamp;

public class ShoppingGoldRecordVO {
	private Integer shoppingGoldRecordID;
	private Integer memberID;
	private Timestamp useDate;
	private	Integer obtainShoppingCoin;
	private Integer plusOrMinus;
	public Integer getShoppingGoldRecordID() {
		return shoppingGoldRecordID;
	}
	public void setShoppingGoldRecordID(Integer shoppingGoldRecordID) {
		this.shoppingGoldRecordID = shoppingGoldRecordID;
	}
	public Integer getMemberID() {
		return memberID;
	}
	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}
	public Timestamp getUseDate() {
		return useDate;
	}
	public void setUseDate(Timestamp useDate) {
		this.useDate = useDate;
	}
	public Integer getObtainShoppingCoin() {
		return obtainShoppingCoin;
	}
	public void setObtainShoppingCoin(Integer obtainShoppingCoin) {
		this.obtainShoppingCoin = obtainShoppingCoin;
	}
	public Integer getPlusOrMinus() {
		return plusOrMinus;
	}
	public void setPlusOrMinus(Integer plusOrMinus) {
		this.plusOrMinus = plusOrMinus;
	}

}
