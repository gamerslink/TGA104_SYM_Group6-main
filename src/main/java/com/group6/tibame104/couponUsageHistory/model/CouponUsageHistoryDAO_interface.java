package com.group6.tibame104.couponUsageHistory.model;

import java.util.List;

public interface CouponUsageHistoryDAO_interface {
	public void insert(CouponUsageHistoryVO couponUsageHistoryVO);
	List<CouponUsageHistoryVO> getAllCouponUsageHistoryVO(Integer memberID);
	public List<CouponUsageHistoryVO> getAll(Integer memberID);
	public List<CouponUsageHistoryVO> getAll2();
}
