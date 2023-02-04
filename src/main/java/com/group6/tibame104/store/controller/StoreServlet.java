package com.group6.tibame104.store.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group6.tibame104.member.model.MemberVO;
import com.group6.tibame104.store.model.StoreJDBCDAO;
import com.group6.tibame104.store.model.StoreVO;

@WebServlet("/store/storeServlet")
public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

		PrintWriter out = res.getWriter();
		String action = req.getParameter("action");

		
		/*
		 * 商店修改
		 */
		if ("update".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			/* 1. 請求參數的格式整理 */
			HttpSession session = req.getSession();
			
			Integer memberID = null;
			try {
				MemberVO attribute = (MemberVO)session.getAttribute("memVO");
				memberID = attribute.getMemberID();
			} catch (NumberFormatException e) {
				memberID = 0;
				errorMsgs.add("memberID不正確");
			}

			String storeName = req.getParameter("storeName");
			String Reg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (storeName == null || storeName.trim().length() == 0) {
				errorMsgs.add("商店名稱: 請勿空白");
			} else if (!storeName.trim().matches(Reg)) {
				errorMsgs.add("商店名稱: 只能是中 英字母 數字 _ , 且長度介於2-10之間");
			}

			String storeDelBank = req.getParameter("storeDelBank");

			if (storeDelBank == null || storeDelBank.trim().length() == 0) {
				errorMsgs.add("銀行代碼 請勿空白");
			}

			String storeBankAccount = req.getParameter("storeBankAccount");

			if (storeBankAccount == null || storeBankAccount.trim().length() == 0) {
				errorMsgs.add("銀行帳號 請勿空白");
			}

			String storeAddress = req.getParameter("storeAddress");

			if (storeAddress == null || storeAddress.trim().length() == 0) {
				errorMsgs.add("商店地址: 請勿空白");
			}
			
			String phoneNumber = req.getParameter("phoneNumber");

			if (phoneNumber == null || phoneNumber.trim().length() == 0) {
				errorMsgs.add("電話號碼: 請勿空白");
			}

			String taxID = req.getParameter("taxID");

			if (taxID == null || taxID.trim().length() == 0) {
				errorMsgs.add("稅務代號: 請勿空白");
			}

			/* VO */
			StoreVO storeVO = (StoreVO)session.getAttribute("storeVO2");
			storeVO.setMemberID(memberID);
			storeVO.setStoreName(storeName);
			storeVO.setStoreDelBankCode(storeDelBank);
			storeVO.setStoreBankAccount(storeBankAccount);
			storeVO.setStoreAddress(storeAddress);
			storeVO.setPhoneNumber(phoneNumber);
			storeVO.setTaxID(taxID);

			// Send the use back to the form, if there were errors
			/*
			 * 如果報錯 轉去 addProduct 頁面
			 */
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/store/Error.jsp");
				try {
					failureView.forward(req, res);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return;
			}

			/***************************
			 * 2.修改資料
			 ***************************************/
			new StoreJDBCDAO().update(storeVO);

			/*
			 * 導向 listOneProduct頁面
			 */
			req.getSession().setAttribute("storeVO2", storeVO);
			String url = "/front-end/store/myStore.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);

		}
		
		/***************************
		 * 賣場審核
		 ***************************************/
		if("GET_All_STMT_BY_AUDI_0".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			/* 1. 請求參數的格式整理 */
			HttpSession session = req.getSession();
			
			
			
		}
		
	}
}
