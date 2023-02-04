package com.group6.tibame104.shoppingGoldRecord.controller;

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
import com.group6.tibame104.shoppingGoldRecord.model.ShoppingGoldRecordService;
import com.group6.tibame104.shoppingGoldRecord.model.ShoppingGoldRecordVO;

@Controller
@RequestMapping("/front-end/shoppingGoldRecord")
public class ShoppingGoldRecordController {
	@Autowired
	private ShoppingGoldRecordService shoppingGoldRecordSvc;
	
	@PostMapping("/getOne_For_Display")
	public String getOneForDisplay(Model model, @RequestParam("memberID") String str) {
		List<String> errorMsgs = new LinkedList<String>();
		model.addAttribute("errorMsgs", errorMsgs);
		if (str == null || (str.trim()).length() == 0) {
			errorMsgs.add("�п�J�|��ID");
		}

		if (!errorMsgs.isEmpty()) {
			return"front-end/shoppingGoldRecord/select_page";
		}

		Integer memberID = null;
		try {
			memberID = Integer.valueOf(str);
		} catch (Exception e) {
			errorMsgs.add("���uID�榡�����T");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			return "front-end/shoppingGoldRecord/select_page";
		}

		List<ShoppingGoldRecordVO> list = shoppingGoldRecordSvc.getOneShoppingGoldRecord(memberID);
		if (list == null) {
			errorMsgs.add("�d�L���");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			return "front-end/shoppingGoldRecord/select_page";// �{�����_
		}

		/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) *************/
		model.addAttribute("list", list);
		return "back-end/shoppingGoldRecord/newOneShoppingGoldRecord";
	}
	
	@RequestMapping("/insert")
		public String insert(Model model, 
				@RequestParam("memberID") String str,
				@RequestParam("useDate") String str2,
				@RequestParam("obtainShoppingCoin") String str3,
				@RequestParam("plusOrMinus") String str4
		) {
		List<String> errorMsgs = new LinkedList<String>();
		model.addAttribute("errorMsgs", errorMsgs);
		
		Integer memberID = null;
		try {
			memberID = Integer.valueOf(str);
		}catch(Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		Timestamp useDate = null;
		try {
			useDate = Timestamp.valueOf(str2);
		}catch(Exception e) {
			useDate = new Timestamp(System.currentTimeMillis());
		}
		Integer obtainShoppingCoin = null;
		try {
			obtainShoppingCoin = Integer.valueOf(str3);
		}catch(Exception e) {
			errorMsgs.add("�ϥά����榡�����T");
		}
		
		Integer plusOrMinus = null;
		try {
			plusOrMinus = Integer.valueOf(str4);
		}catch(Exception e) {
			errorMsgs.add("�ϥά����榡�����T");
		}
		

		ShoppingGoldRecordVO shoppingGoldRecordVO = new ShoppingGoldRecordVO();	
		shoppingGoldRecordVO.setMemberID(memberID);
		shoppingGoldRecordVO.setUseDate(useDate);
		shoppingGoldRecordVO.setObtainShoppingCoin(obtainShoppingCoin);
		shoppingGoldRecordVO.setPlusOrMinus(plusOrMinus);

		if (!errorMsgs.isEmpty()) {
			return "front-end/shoppingGoldRecord/getAll";
		}

		shoppingGoldRecordVO = shoppingGoldRecordSvc.addShoppingGoldRecord( memberID, useDate, obtainShoppingCoin, plusOrMinus);
		model.addAttribute(shoppingGoldRecordVO);
		return getAll(model);
	}
	
	@RequestMapping("/getOne_For_Update")
	public String getOneForUpdate(Model model,
			@RequestParam("memberID") String str,
			@RequestParam("useDate") String str2,
			@RequestParam("obtainShoppingCoin") String str3,
			@RequestParam("plusOrMinus") String str4
		) {
		List<String> errorMsgs = new LinkedList<String>();
		model.addAttribute("errorMsgs", errorMsgs);

		Integer memberID = null;
		try {
			memberID = Integer.valueOf(str);
		}catch(Exception e) {
			errorMsgs.add("�|��ID�榡�����T");
		}
		Timestamp useDate = null;
		try {
			useDate = Timestamp.valueOf(str2);
		}catch(Exception e) {
			useDate = new Timestamp(System.currentTimeMillis());
		}
		Integer obtainShoppingCoin = null;
		try {
			obtainShoppingCoin = Integer.valueOf(str3);
		}catch(Exception e) {
			errorMsgs.add("�ϥά����榡�����T");
		}
		
		Integer plusOrMinus = null;
		try {
			plusOrMinus = Integer.valueOf(str4);
		}catch(Exception e) {
			errorMsgs.add("�ϥά����榡�����T");
		}

		/*************************** 2.�}�l�d�߸�� ****************************************/
		ShoppingGoldRecordVO shoppingGoldRecordVO = (ShoppingGoldRecordVO) shoppingGoldRecordSvc.getOneShoppingGoldRecord(memberID);

		/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) ************/
		model.addAttribute("shoppingGoldRecordVO", shoppingGoldRecordVO); // ��Ʈw���X��empVO����,�s�Jreq

		return "front-end/shoppingGoldRecord/update_shoppingGoldRecord_input";
	}
	@PostMapping("/getAll")
	public String getAll(Model model) {
		List<ShoppingGoldRecordVO> shoppingGoldRecordVO = shoppingGoldRecordSvc.getAll();
		model.addAttribute("shoppingGoldRecordVO", shoppingGoldRecordVO);
		return "back-end/shoppingGoldRecord/newAllShoppingGoldRecord";
	}
}
