package com.group6.tibame104.coupon.controller;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group6.tibame104.coupon.model.CouponService;
import com.group6.tibame104.coupon.model.CouponVO;
import com.group6.tibame104.couponUsageHistory.model.CouponUsageHistoryVO;
import com.group6.tibame104.group.model.GroupVO;
import com.group6.tibame104.groupdiscount.model.GroupdiscountVO;

@Controller
@RequestMapping("/front-end/coupon")
public class CouponController {
	@Autowired
	private CouponService couponSvc;
	
	@PostMapping("/getOne_For_Display")
	public String getOneForDisplay(Model model,
			@RequestParam("couponID") String str
		) {
		List<String> errorMsgs = new LinkedList<String>();
		model.addAttribute("errorMsgs", errorMsgs);
		if (str == null || (str.trim()).length() == 0) {
			errorMsgs.add("請輸入ID");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			return "/front-end/coupon/select_page";
		}

		Integer couponID = null;
		try {
			couponID = Integer.valueOf(str);
		} catch (Exception e) {
			errorMsgs.add("會員ID不正確");
		}
		
		if (!errorMsgs.isEmpty()) {
			return "/front-end/coupon/select_page";
		}

		CouponVO couponVO = couponSvc.getOneCoupon(couponID);
		if (couponVO == null) {
			errorMsgs.add("查無資料");
		}
		if (!errorMsgs.isEmpty()) {
			return "/front-end/coupon/select_page";// �{�����_
		}

		model.addAttribute("couponVO", couponVO); 
		return "/back-end/coupon/newAllCoupon";
	}
	
	@PostMapping("/update")
	public String update(Model model,
			@RequestParam("couponID") String str, 
			@RequestParam("couponName") String str2,
			@RequestParam("startDate") String str3,
			@RequestParam("endDate") String str4,
			@RequestParam("discount") String str5,
			@RequestParam("discountAmount") String str6,
			@RequestParam("fullCondition") String str7,
			@RequestParam("couponTimeBegins") String str8,
			@RequestParam("couponTimeEnd") String str9,
			@RequestParam("exchangeAmount") String str10,
			@RequestParam("couponDescription") String str11
		) {
		List<String> errorMsgs = new LinkedList<String>();
		model.addAttribute("errorMsgs", errorMsgs);
		
		Integer couponID = null;
		try {
			couponID = Integer.valueOf(str);
		} catch (Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		String couponName = null;
		try {
			couponName = String.valueOf(str2);
		} catch (Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		java.sql.Date startDate = null;
		try {
			startDate = Date.valueOf(str3);
		} catch (Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		java.sql.Date endDate = null;
		try {
			endDate = Date.valueOf(str4);
		} catch (Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		Double discount = null;
		try {
			discount = Double.valueOf(str5);
		} catch (Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		Integer discountAmount = null;
		try {
			discountAmount = Integer.valueOf(str6);
		} catch (Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		Integer fullCondition = null;
		try {
			fullCondition = Integer.valueOf(str7);
		} catch (Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		java.sql.Date couponTimeBegins = null;
		try {
			couponTimeBegins = Date.valueOf(str8);
		} catch (Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		java.sql.Date couponTimeEnd = null;
		try {
			couponTimeEnd = Date.valueOf(str9);
		} catch (Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		Integer exchangeAmount = null;
		try {
			exchangeAmount = Integer.valueOf(str10);
		} catch (Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		String couponDescription = null;
		try {
			couponDescription = String.valueOf(str11);
		} catch (Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}

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

		if (!errorMsgs.isEmpty()) {
			model.addAttribute("couponVO", couponVO);
			return "/front-end/coupon/getAll";
		}

		/*************************** 2.�}�l�ק��� *****************************************/
		
		couponVO = couponSvc.updateCoupon( couponID, couponName, startDate, endDate, discount, discountAmount, fullCondition,
				couponTimeBegins, couponTimeEnd, exchangeAmount, couponDescription );

		/*************************** 3.�ק粒��,�ǳ����(Send the Success view) *************/
		model.addAttribute("couponVO", couponVO);
		System.out.println("couponVO = "+couponVO.getCouponName());
		return "/front-end/coupon/getAll";
	}
	
	@PostMapping("/insert")
	public String insert(Model model,
			@RequestParam("couponName") String str,
			@RequestParam("startDate") String str2,
			@RequestParam("endDate") String str3,
			@RequestParam("discount") String str4,
			@RequestParam("discountAmount") String str5,
			@RequestParam("fullCondition") String str6,
			@RequestParam("couponTimeBegins") String str7,
			@RequestParam("couponTimeEnd") String str8,
			@RequestParam("exchangeAmount") String str9,
			@RequestParam("couponDescription") String str10
			
		) {
		List<String> errorMsgs = new LinkedList<String>();
		model.addAttribute("errorMsgs", errorMsgs);

		String couponName = null;
		try {
			couponName = String.valueOf(str);
		} catch (Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		java.sql.Date startDate = null;
		try {
			startDate = Date.valueOf(str2);
		} catch (Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		java.sql.Date endDate = null;
		try {
			endDate = Date.valueOf(str3);
		} catch (Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		Double discount = null;
		try {
			discount = Double.valueOf(str4);
		} catch (Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		Integer discountAmount = null;
		try {
			discountAmount = Integer.valueOf(str5);
		} catch (Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		Integer fullCondition = null;
		try {
			fullCondition = Integer.valueOf(str6);
		} catch (Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		java.sql.Date couponTimeBegins = null;
		try {
			couponTimeBegins = Date.valueOf(str7);
		} catch (Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		java.sql.Date couponTimeEnd = null;
		try {
			couponTimeEnd = Date.valueOf(str8);
		} catch (Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		Integer exchangeAmount = null;
		try {
			exchangeAmount = Integer.valueOf(str9);
		} catch (Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		String couponDescription = null;
		try {
			couponDescription = String.valueOf(str10);
		} catch (Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
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

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			model.addAttribute("couponVO", couponVO);
			return "/front-end/coupon/getAll";
		}
		

		couponVO = couponSvc.addCoupon(couponName, startDate, endDate, discount, discountAmount, fullCondition,
				couponTimeBegins, couponTimeEnd, exchangeAmount, couponDescription);

		List<CouponVO> list = couponSvc.getAll();
		model.addAttribute("couponVO", list);
		return getAll(model);
	
	}
	@PostMapping("/getAll")
	public String getAll(Model model) {
		List<CouponVO> couponVO = couponSvc.getAll();
		model.addAttribute("couponVO", couponVO);
		return "back-end/coupon/newAllCoupon";
	}
}
