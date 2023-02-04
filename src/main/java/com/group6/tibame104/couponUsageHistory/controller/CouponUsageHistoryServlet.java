package com.group6.tibame104.couponUsageHistory.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group6.tibame104.couponUsageHistory.model.CouponUsageHistoryService;
import com.group6.tibame104.couponUsageHistory.model.CouponUsageHistoryVO;

@WebServlet("/front-end/couponUsageHistory/CouponUsageHistory.do")
public class CouponUsageHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // �Ӧ�select_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/
			String str = req.getParameter("memberID");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("�п�J���u�s��");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/couponUsageHistory/select_page.jsp");
				failureView.forward(req, res);
				return;// �{�����_
			}

			Integer memberID = null;
			try {
				memberID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("���u�s���榡�����T");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/couponUsageHistory/select_page.jsp");
				failureView.forward(req, res);
				return;// �{�����_
			}

			/*************************** 2.�}�l�d�߸�� *****************************************/
			CouponUsageHistoryService couponUsageHistorySvc = new CouponUsageHistoryService();
			List<CouponUsageHistoryVO> list = couponUsageHistorySvc.getAll(memberID);
			if (list == null) {
				errorMsgs.add("�d�L���");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/couponUsageHistory/select_page.jsp");
				failureView.forward(req, res);
				return;// �{�����_
			}

			/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) *************/
			req.setAttribute("list", list); // ��Ʈw���X��empVO����,�s�Jreq
			CouponUsageHistoryService cardSvc = new CouponUsageHistoryService();
//			List<CouponUsageHistoryVO> list = cardSvc.getAll(2);
//			req.setAttribute("list", list);
			String url = "/back-end/couponUsageHistory/listOneCouponUsageHistory.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
			successView.forward(req, res);
		}
		if ("insert".equals(action)) { // �Ӧ�addEmp.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z *************************/
			Integer memberID = null;
			try {
				memberID = Integer.valueOf(req.getParameter("memberID").trim());
			}catch(Exception e) {
				errorMsgs.add("�|��ID�榡�����T");
			}
			Integer couponID = null;
			try {
				couponID = Integer.valueOf(req.getParameter("couponID").trim());
			}catch(Exception e) {
				errorMsgs.add("�u�f��ID�榡�����T");
			}
			Integer usageRecord = null;
			try {
				usageRecord = Integer.valueOf(req.getParameter("usageRecord").trim());
			}catch(Exception e) {
				errorMsgs.add("�ϥά����榡�����T");
			}
			
			Timestamp useDate = null;
			try {
				useDate = Timestamp.valueOf(req.getParameter("useDate").trim());
			}catch(Exception e) {
				useDate = new Timestamp(System.currentTimeMillis());
			}
			

			CouponUsageHistoryVO couponUsageHistoryVO = new CouponUsageHistoryVO();

			couponUsageHistoryVO.setMemberID(memberID);
			couponUsageHistoryVO.setCouponID(couponID);
			couponUsageHistoryVO.setUsageRecord(usageRecord);
			couponUsageHistoryVO.setUseDate(useDate);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("couponUsageHistoryVO", couponUsageHistoryVO); // �t����J�榡���~��empVO����,�]�s�Jreq
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/couponUsageHistory/addCouponUsageHistory.jsp");
				failureView.forward(req, res);
				return;
			}
			
			/*************************** 2.�}�l�s�W��� ***************************************/
			CouponUsageHistoryService couponUsageHistorySvc = new CouponUsageHistoryService();
			couponUsageHistoryVO = couponUsageHistorySvc.addCouponUsageHistory(memberID, couponID, usageRecord,
					useDate);

			/*************************** 3.�s�W����,�ǳ����(Send the Success view) ***********/
			String url = "/back-end/couponUsageHistory/listAllCouponUsageHistory.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
			successView.forward(req, res);
		}

	}

}
