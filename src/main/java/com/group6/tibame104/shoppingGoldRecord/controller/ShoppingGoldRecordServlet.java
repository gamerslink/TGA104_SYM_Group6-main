package com.group6.tibame104.shoppingGoldRecord.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group6.tibame104.shoppingGoldRecord.model.ShoppingGoldRecordService;
import com.group6.tibame104.shoppingGoldRecord.model.ShoppingGoldRecordVO;

@WebServlet("/front-end/shoppingGoldRecord/ShoppingGoldRecord.do")
public class ShoppingGoldRecordServlet extends HttpServlet {
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
				errorMsgs.add("�п�J�|��ID");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/shoppingGoldRecord/select_page.jsp");
				failureView.forward(req, res);
				return;// �{�����_
			}

			Integer memberID = null;
			try {
				memberID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("���uID�榡�����T");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/shoppingGoldRecord/select_page.jsp");
				failureView.forward(req, res);
				return;// �{�����_
			}

			/*************************** 2.�}�l�d�߸�� *****************************************/
			ShoppingGoldRecordService shoppingGoldRecordSvc = new ShoppingGoldRecordService();

			List<ShoppingGoldRecordVO> list = shoppingGoldRecordSvc.getOneShoppingGoldRecord(memberID);
			if (list == null) {
				errorMsgs.add("�d�L���");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/shoppingGoldRecord/select_page.jsp");
				failureView.forward(req, res);
				return;// �{�����_
			}

			/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) *************/
			req.setAttribute("list", list); // ��Ʈw���X��empVO����,�s�Jreq

			String url = "/back-end/shoppingGoldRecord/listOneShoppingGoldRecord.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
			successView.forward(req, res);
		}
//		if ("update".equals(action)) { // �Ӧ�update_emp_input.jsp���ШD
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/
//			Integer shoppingGoldRecordID = Integer.valueOf(req.getParameter("shoppingGoldRecordID").trim());
//			Integer memberID = Integer.valueOf(req.getParameter("memberID").trim());
//			Timestamp useDate = null;
//			Integer obtainShoppingCoin = Integer.valueOf(req.getParameter("obtainShoppingCoin").trim());
//			Integer plusOrMinus = Integer.valueOf(req.getParameter("plusOrMinus").trim());
////			java.sql.Date startDate = null;
////			java.sql.Date endDate = null;
////			Integer discount = Integer.valueOf(req.getParameter("discount").trim());
////			Integer discountAmount = Integer.valueOf(req.getParameter("discountAmount").trim());
////			Integer fullCondition = Integer.valueOf(req.getParameter("fullCondition").trim());
////			java.sql.Date couponTimeBegins = null;
////			java.sql.Date couponTimeEnd = null;
////			Integer exchangeAmount = Integer.valueOf(req.getParameter("exchangeAmount").trim());
////			byte[] couponPicture = null;
////			String couponDescription = req.getParameter("couponDescription");
////				if (couponName == null || couponName.trim().length() == 0) {
////					errorMsgs.add("���u�m�W: �ФŪť�");
////				} else if(!couponName.trim().matches(couponNameReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
////					errorMsgs.add("���u�m�W: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
////	            }
//
////				String job = req.getParameter("job").trim();
////				if (job == null || job.trim().length() == 0) {
////					errorMsgs.add("¾��ФŪť�");
////				}	
//////				
////				java.sql.Date hiredate = null;
////				try {
////					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
////				} catch (IllegalArgumentException e) {
////					hiredate=new java.sql.Date(System.currentTimeMillis());
////					errorMsgs.add("�п�J���!");
////				}
////
////				Double sal = null;
////				try {
////					sal = Double.valueOf(req.getParameter("sal").trim());
////				} catch (NumberFormatException e) {
////					sal = 0.0;
////					errorMsgs.add("�~���ж�Ʀr.");
////				}
////
////				Double comm = null;
////				try {
////					comm = Double.valueOf(req.getParameter("comm").trim());
////				} catch (NumberFormatException e) {
////					comm = 0.0;
////					errorMsgs.add("�����ж�Ʀr.");
////				}
////
////				Integer deptno = Integer.valueOf(req.getParameter("deptno").trim());
//
//			ShoppingGoldRecordVO shoppingGoldRecordVO = new ShoppingGoldRecordVO();
//			shoppingGoldRecordVO.setShoppingGoldRecordID(shoppingGoldRecordID);
//			shoppingGoldRecordVO.setMemberID(memberID);
//			shoppingGoldRecordVO.setUseDate(useDate);
//			shoppingGoldRecordVO.setObtainShoppingCoin(obtainShoppingCoin);
//			shoppingGoldRecordVO.setPlusOrMinus(plusOrMinus);
			

//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				req.setAttribute("shoppingGoldRecordVO", shoppingGoldRecordVO); // �t����J�榡���~��empVO����,�]�s�Jreq
//				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/shoppingGoldRecord/update_emp_input.jsp");
//				failureView.forward(req, res);
//				return; // �{�����_
//			}
//
//			/*************************** 2.�}�l�ק��� *****************************************/
//			ShoppingGoldRecordService shoppingGoldRecordSvc = new ShoppingGoldRecordService();
//			shoppingGoldRecordVO = shoppingGoldRecordSvc.updateShoppingGoldRecord(shoppingGoldRecordID, memberID, useDate, obtainShoppingCoin, plusOrMinus);
//
//			/*************************** 3.�ק粒��,�ǳ����(Send the Success view) *************/
//			req.setAttribute("shoppingGoldRecordVO", shoppingGoldRecordVO); // ��Ʈwupdate���\��,���T����empVO����,�s�Jreq
//			String url = "/back-end/shoppingGoldRecord/listOneEmp.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneEmp.jsp
//			successView.forward(req, res);
//		}
		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllEmp.jsp���ШD

//			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.�����ШD�Ѽ� ****************************************/
			Integer memberID = Integer.valueOf(req.getParameter("memberID"));

			/*************************** 2.�}�l�d�߸�� ****************************************/
			ShoppingGoldRecordService shoppingGoldRecordSvc = new ShoppingGoldRecordService();
			ShoppingGoldRecordVO shoppingGoldRecordVO = (ShoppingGoldRecordVO) shoppingGoldRecordSvc.getOneShoppingGoldRecord(memberID);

			/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) ************/
			req.setAttribute("shoppingGoldRecordVO", shoppingGoldRecordVO); // ��Ʈw���X��empVO����,�s�Jreq
			String url = "/front-end/shoppingGoldRecord/update_shoppingGoldRecord_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_emp_input.jsp
			successView.forward(req, res);
		}
		if ("insert".equals(action)) { // �Ӧ�addEmp.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z *************************/
//			Integer shoppingGoldRecordID = Integer.valueOf(req.getParameter("shoppingGoldRecordID").trim());
//			String memberID = req.getParameter("memberID");
//			String memberIDReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//			if (couponName == null || couponName.trim().length() == 0) {
//				errorMsgs.add("���u�m�W: �ФŪť�");
//			} else if (!couponName.trim().matches(couponNameReg)) { // �H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
//				errorMsgs.add("���u�m�W: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
//			}
			Integer memberID = Integer.valueOf(req.getParameter("memberID").trim());
			java.sql.Timestamp useDate = null;
			Integer obtainShoppingCoin = Integer.valueOf(req.getParameter("obtainShoppingCoin").trim());
			Integer plusOrMinus = Integer.valueOf(req.getParameter("plusOrMinus").trim());
//			if (job == null || job.trim().length() == 0) {
//				errorMsgs.add("¾��ФŪť�");
//			}
			
//			java.sql.Date hiredate = null;
//			try {
//				hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//			} catch (IllegalArgumentException e) {
//				hiredate = new java.sql.Date(System.currentTimeMillis());
//				errorMsgs.add("�п�J���!");
//			}

//			Double sal = null;
//			try {
//				sal = Double.valueOf(req.getParameter("sal").trim());
//			} catch (NumberFormatException e) {
//				sal = 0.0;
//				errorMsgs.add("�~���ж�Ʀr.");
//			}

//			Double comm = null;
//			try {
//				comm = Double.valueOf(req.getParameter("comm").trim());
//			} catch (NumberFormatException e) {
//				comm = 0.0;
//				errorMsgs.add("�����ж�Ʀr.");
//			}

//			Integer deptno = Integer.valueOf(req.getParameter("deptno").trim());

			
			ShoppingGoldRecordVO shoppingGoldRecordVO = new ShoppingGoldRecordVO();
			
			
			shoppingGoldRecordVO.setMemberID(memberID);
			shoppingGoldRecordVO.setUseDate(useDate);
			shoppingGoldRecordVO.setObtainShoppingCoin(obtainShoppingCoin);
			shoppingGoldRecordVO.setPlusOrMinus(plusOrMinus);
			
			

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("shoppingGoldRecordVO", shoppingGoldRecordVO); // �t����J�榡���~��empVO����,�]�s�Jreq
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/shoppingGoldRecord/addShoppingGoldRecord.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.�}�l�s�W��� ***************************************/
			ShoppingGoldRecordService shoppingGoldRecordSvc = new ShoppingGoldRecordService();
			shoppingGoldRecordVO = shoppingGoldRecordSvc.addShoppingGoldRecord( memberID, useDate, obtainShoppingCoin, plusOrMinus);

			/*************************** 3.�s�W����,�ǳ����(Send the Success view) ***********/
			String url = "/back-end/shoppingGoldRecord/listAllShoppingGoldRecord.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
			successView.forward(req, res);
		}

	}
}
		
