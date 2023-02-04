package com.group6.tibame104.coupon.model;

import java.util.List;

public interface CouponDAO_interface {
	 public void insert(CouponVO couponVO);
     public void update(CouponVO couponVO);
     public void delete(Integer couponID);
     public CouponVO findByPrimaryKey(Integer couponID);
     public List<CouponVO> getAll();
     public List<CouponVO2> getAllByCouponUsage();
//     �d�߬Y���������u(�@��h)(�^�� Set)
//     public Set<EmpVO> getEmpsByDeptno(Integer deptno);

}
