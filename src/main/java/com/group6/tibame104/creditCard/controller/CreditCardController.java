package com.group6.tibame104.creditCard.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group6.tibame104.creditCard.model.CreditCardService;
import com.group6.tibame104.creditCard.model.CreditCardVO;

@Controller
@RequestMapping("/front-end/cerditCard")
public class CreditCardController {

	@Autowired
	private CreditCardService cardSvc;

	@PostMapping("/update")
	public String update(Model model, @RequestParam("creditCardNumber") String creditCardNumber,
			@RequestParam("securityCode") String securityCode, @RequestParam("exDate") java.sql.Date exDate,
			@RequestParam("creditCardID") Integer creditCardID) {

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/

		CreditCardVO cardVO = new CreditCardVO();
		cardVO.setCreditCardNumber(creditCardNumber);
		cardVO.setSecurityCode(securityCode);
		cardVO.setExDate(exDate);
		cardVO.setCreditCardID(creditCardID);

		/*************************** 2.開始修改資料 *****************************************/

		cardVO = cardSvc.updateCreditCard(creditCardNumber, securityCode, exDate, creditCardID);

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		model.addAttribute("cardVO", cardVO); // 資料庫update成功後,正確的的memVO物件,存入req

		return "/front-end/member/my-account";

	}

	@PostMapping("/insert")
	public String insert(HttpSession session, Model model, @RequestParam("memberID") Integer memberID,
			@RequestParam("creditCardNumber") String creditCardNumber,
			@RequestParam("securityCode") String securityCode, @RequestParam("exDate") java.sql.Date exDate) {

		/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

		CreditCardVO cardVO = new CreditCardVO();
		cardVO.setMemberID(memberID);
		cardVO.setCreditCardNumber(creditCardNumber);
		cardVO.setSecurityCode(securityCode);
		cardVO.setExDate(exDate);

		/*************************** 2.開始新增資料 ***************************************/
		cardVO = cardSvc.addCreditCard(memberID, creditCardNumber, securityCode, exDate);

		/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/

		return getAll(session, model, memberID);

	}

	@PostMapping("/delete")
	public String insert(HttpSession session, Model model, @RequestParam("creditCardID") Integer creditCardID,
			@RequestParam("memberID") Integer memberID) {

		cardSvc.deletecreditCard(creditCardID);

		return getAll(session, model, memberID);

	}

	public String getAll(HttpSession session, Model model, @RequestParam("memberID") Integer memberID) {

		List<CreditCardVO> cardVO = cardSvc.getAll(memberID);

		session.setAttribute("cardVO", cardVO);

		return "/front-end/member/my-account";
	}

}
