package com.group6.tibame104.couponUsageHistory.model;

import java.sql.Timestamp;

public class CouponUsageHistoryVO {
	private Integer memberID;
	private Integer couponID;
	private Integer usageRecord;
	private Timestamp useDate;
	public Integer getMemberID() {
		return memberID;
	}
	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
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
	public Timestamp getUseDate() {
		return useDate;
	}
	public void setUseDate(Timestamp useDate) {
		this.useDate = useDate;
	}
}
