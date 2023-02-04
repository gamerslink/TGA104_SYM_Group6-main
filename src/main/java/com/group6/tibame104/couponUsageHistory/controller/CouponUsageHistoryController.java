package com.group6.tibame104.couponUsageHistory.controller;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group6.tibame104.coupon.model.CouponVO;
import com.group6.tibame104.couponUsageHistory.model.CouponUsageHistoryService;
import com.group6.tibame104.couponUsageHistory.model.CouponUsageHistoryVO;

@Controller
@RequestMapping("/front-end/couponUsageHistory")
public class CouponUsageHistoryController {
	@Autowired
	private CouponUsageHistoryService couponUsageHistorySvc;
	
	@PostMapping("/getOne_For_Display")
	public String getOneForDisplay(Model model, @RequestParam("memberID") String str) {
		List<String> errorMsgs = new LinkedList<String>();
		model.addAttribute("errorMsgs", errorMsgs);
		if (str == null || (str.trim()).length() == 0) {
			errorMsgs.add("請輸入");
		}

		if (!errorMsgs.isEmpty()) {
			return "front-end/couponUsageHistory/newCouponUsageHistory";
		}

		Integer memberID = null;
		try {
			memberID = Integer.valueOf(str);
		} catch (Exception e) {
			errorMsgs.add("格式不正確");
		}
		
		if (!errorMsgs.isEmpty()) {
			return "front-end/couponUsageHistory/newCouponUsageHistory";
		}
		
		List<CouponUsageHistoryVO> list = couponUsageHistorySvc.getAll(memberID);
		if (list == null) {
			errorMsgs.add("查無資料");
		}
	
		if (!errorMsgs.isEmpty()) {
			return "front-end/couponUsageHistory/newCouponUsageHistory";
		}
		System.out.println(list.size());
		model.addAttribute("list", list); 
//		CouponUsageHistoryService cardSvc = new CouponUsageHistoryService();
//		List<CouponUsageHistoryVO> list = cardSvc.getAll(2);
//		req.setAttribute("list", list);
		return "back-end/couponUsageHistory/newOneCouponUsageHistory";
	}
	
	@PostMapping("/insert")
	public String insert(Model model, 
			@RequestParam("memberID") String str, 
			@RequestParam("couponID") String str2,
			@RequestParam("usageRecord") String str3,
			@RequestParam("useDate") String str4
		) {
		List<String> errorMsgs = new LinkedList<String>();
		model.addAttribute("errorMsgs", errorMsgs);

		Integer memberID = null;
		try {
			memberID = Integer.valueOf(str);
		}catch(Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		Integer couponID = null;
		try {
			couponID = Integer.valueOf(str2);
		}catch(Exception e) {
			errorMsgs.add("�u�f��ID�榡�����T");
		}
		Integer usageRecord = null;
		try {
			usageRecord = Integer.valueOf(str3);
		}catch(Exception e) {
			errorMsgs.add("�ϥά����榡�����T");
		}
		
		Timestamp useDate = null;
		try {
			useDate = Timestamp.valueOf(str4);
		}catch(Exception e) {
			useDate = new Timestamp(System.currentTimeMillis());
		}
		

		CouponUsageHistoryVO couponUsageHistoryVO = new CouponUsageHistoryVO();

		couponUsageHistoryVO.setMemberID(memberID);
		couponUsageHistoryVO.setCouponID(couponID);
		couponUsageHistoryVO.setUsageRecord(usageRecord);
		couponUsageHistoryVO.setUseDate(useDate);

		if (!errorMsgs.isEmpty()) { 
			return "front-end/couponUsageHistory/getAll2";
		}
		
		couponUsageHistoryVO = couponUsageHistorySvc.addCouponUsageHistory(memberID, couponID, usageRecord,
				useDate);

		List<CouponUsageHistoryVO> list = couponUsageHistorySvc.getAll2();
		model.addAttribute("couponUsageHistoryVO", list);
		return getAll2(model);
	}
	@PostMapping("/getAll2")
	public String getAll2(Model model) {
		List<CouponUsageHistoryVO> couponUsageHistoryVO = couponUsageHistorySvc.getAll2();
		model.addAttribute("couponUsageHistoryVO", couponUsageHistoryVO);
		return "back-end/couponUsageHistory/newAllCouponUsageHistory";
	}
}
