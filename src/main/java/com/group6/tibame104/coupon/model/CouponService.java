package com.group6.tibame104.coupon.model;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CouponService {

	@Autowired
	private CouponDAO_interface dao;

	public CouponVO addCoupon(String couponName, Date startDate, Date endDate, Double discount, Integer discountAmount,
			Integer fullCondition, Date couponTimeBegins, Date couponTimeEnd, Integer exchangeAmount,
			 String couponDescription) {

		CouponVO couponVO = new CouponVO();

		couponVO.setCouponName(couponName);
		couponVO.setStartDate(startDate);
		couponVO.setEndDate(endDate);
		couponVO.setDiscount(discount);
		couponVO.setDiscountAmount(discountAmount);
		couponVO.setFullCondition(fullCondition);
		couponVO.setCouponTimeBegins(couponTimeBegins);
		couponVO.setCouponTimeEnd(couponTimeEnd);
		couponVO.setExchangeAmount(exchangeAmount);

		couponVO.setCouponDescription(couponDescription);

		dao.insert(couponVO);

		return couponVO;
	}

	public CouponVO updateCoupon(Integer couponID, String couponName, Date startDate, Date endDate, Double discount,
			Integer discountAmount, Integer fullCondition, Date couponTimeBegins, Date couponTimeEnd,
			Integer exchangeAmount, String couponDescription) {

		CouponVO couponVO = new CouponVO();
		couponVO.setCouponID(couponID);
		couponVO.setCouponName(couponName);
		couponVO.setStartDate(startDate);
		couponVO.setEndDate(endDate);
		couponVO.setDiscount(discount);
		couponVO.setDiscountAmount(discountAmount);
		couponVO.setFullCondition(fullCondition);
		couponVO.setCouponTimeBegins(couponTimeBegins);
		couponVO.setCouponTimeEnd(couponTimeEnd);
		couponVO.setExchangeAmount(exchangeAmount);

		couponVO.setCouponDescription(couponDescription);

		dao.update(couponVO);

		return couponVO;
	}

	public void deleteCoupon(Integer couponID) {
		dao.delete(couponID);
	}

	public CouponVO getOneCoupon(Integer couponID) {
		return dao.findByPrimaryKey(couponID);
	}

	public List<CouponVO> getAll() {
		return dao.getAll();
	}

//	private CouponJDBCDAO couponJDBCDAO = new CouponJDBCDAO();
//	
//	
//	public void DiscountMoney() {
//		
//	}
//	u
//	

}
//	public static void main(String[] args) {
//		
//	}
//}
//
