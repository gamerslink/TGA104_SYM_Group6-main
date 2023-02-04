package com.group6.tibame104.coupon.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.group6.tibame104.coupon.model.CouponService;
import com.group6.tibame104.coupon.model.CouponVO;

@WebServlet("/front-end/coupon/Coupon.do")
public class CouponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private CouponService couponSvc;
	
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
			String str = req.getParameter("couponID");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入會員ID");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/coupon/select_page.jsp");
				failureView.forward(req, res);
				return;// �{�����_
			}

			Integer couponID = null;
			try {
				couponID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("會員ID不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/coupon/select_page.jsp");
				failureView.forward(req, res);
				return;// �{�����_
			}

			/*************************** 2.�}�l�d�߸�� *****************************************/
			CouponService couponSvc = new CouponService();
			CouponVO couponVO = couponSvc.getOneCoupon(couponID);
			if (couponVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/coupon/select_page.jsp");
				failureView.forward(req, res);
				return;// �{�����_
			}

			/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) *************/
			req.setAttribute("couponVO", couponVO); // ��Ʈw���X��empVO����,�s�Jreq
			String url = "/back-end/coupon/listOneCoupon2.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
			successView.forward(req, res);
		}
		if ("update".equals(action)) { // �Ӧ�update_emp_input.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/
			
			Integer couponID = Integer.valueOf(req.getParameter("couponID").trim());
			String couponName = req.getParameter("couponName");
			java.sql.Date startDate = null;
			java.sql.Date endDate = null;
			Double discount = Double.valueOf(req.getParameter("discount").trim());
			Integer discountAmount = Integer.valueOf(req.getParameter("discountAmount").trim());
			Integer fullCondition = Integer.valueOf(req.getParameter("fullCondition").trim());
			java.sql.Date couponTimeBegins = null;
			java.sql.Date couponTimeEnd = null;
			Integer exchangeAmount = Integer.valueOf(req.getParameter("exchangeAmount").trim());
			String couponDescription = req.getParameter("couponDescription");
//				if (couponName == null || couponName.trim().length() == 0) {
//					errorMsgs.add("���u�m�W: �ФŪť�");
//				} else if(!couponName.trim().matches(couponNameReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
//					errorMsgs.add("���u�m�W: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
//	            }

//				String job = req.getParameter("job").trim();
//				if (job == null || job.trim().length() == 0) {
//					errorMsgs.add("¾��ФŪť�");
//				}	
////				
//				java.sql.Date hiredate = null;
//				try {
//					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					hiredate=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("�п�J���!");
//				}
//
//				Double sal = null;
//				try {
//					sal = Double.valueOf(req.getParameter("sal").trim());
//				} catch (NumberFormatException e) {
//					sal = 0.0;
//					errorMsgs.add("�~���ж�Ʀr.");
//				}
//
//				Double comm = null;
//				try {
//					comm = Double.valueOf(req.getParameter("comm").trim());
//				} catch (NumberFormatException e) {
//					comm = 0.0;
//					errorMsgs.add("�����ж�Ʀr.");
//				}
//
//				Integer deptno = Integer.valueOf(req.getParameter("deptno").trim());

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

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("couponVO", couponVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/coupon/update_emp_input.jsp");
				failureView.forward(req, res);
				return; // �{�����_
			}

			/*************************** 2.�}�l�ק��� *****************************************/
			
			CouponService couponSvc = new CouponService();
			couponVO = couponSvc.updateCoupon( couponID, couponName, startDate, endDate, discount, discountAmount, fullCondition,
					couponTimeBegins, couponTimeEnd, exchangeAmount, couponDescription );

			/*************************** 3.�ק粒��,�ǳ����(Send the Success view) *************/
			req.setAttribute("couponVO", couponVO); // ��Ʈwupdate���\��,���T����empVO����,�s�Jreq
			System.out.println("couponVO = "+couponVO.getCouponName());
			String url = "/back-end/coupon/listOneCoupon2.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneEmp.jsp
			successView.forward(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllEmp.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.�����ШD�Ѽ� ****************************************/
			Integer couponID = Integer.valueOf(req.getParameter("couponID"));

			/*************************** 2.�}�l�d�߸�� ****************************************/
			CouponService couponSvc = new CouponService();
			CouponVO couponVO = couponSvc.getOneCoupon(couponID);

			/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) ************/
			req.setAttribute("couponVO", couponVO); // ��Ʈw���X��empVO����,�s�Jreq
			String url = "/back-end/coupon/newUpdateCoupon.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_emp_input.jsp
			successView.forward(req, res);
		}
		if ("insert".equals(action)) { // �Ӧ�addEmp.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z *************************/
			String couponName = req.getParameter("couponName");
			String couponNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//			if (couponName == null || couponName.trim().length() == 0) {
//				errorMsgs.add("���u�m�W: �ФŪť�");
//			} else if (!couponName.trim().matches(couponNameReg)) { // �H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
//				errorMsgs.add("���u�m�W: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
//			}
			java.sql.Date startDate = null;
			java.sql.Date endDate = null;
			Double discount = Double.valueOf(req.getParameter("discount").trim());
			Integer discountAmount = Integer.valueOf(req.getParameter("discountAmount").trim());
			Integer fullCondition = Integer.valueOf(req.getParameter("fullCondition"));
			java.sql.Date couponTimeBegins = null;
			java.sql.Date couponTimeEnd = null;
			Integer exchangeAmount = Integer.valueOf(req.getParameter("exchangeAmount").trim());
			byte[] couponPicture = null;
			String couponDescription =  req.getParameter("couponDescription").trim();
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
//			couponVO.setCouponPicture(couponPicture);
			couponVO.setCouponDescription(couponDescription);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("couponVO", couponVO); // �t����J�榡���~��empVO����,�]�s�Jreq
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/coupon/newCoupon.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.�}�l�s�W��� ***************************************/
			CouponService couponSvc = new CouponService();
			couponVO = couponSvc.addCoupon(couponName, startDate, endDate, discount, discountAmount, fullCondition,
					couponTimeBegins, couponTimeEnd, exchangeAmount, couponDescription);

			/*************************** 3.�s�W����,�ǳ����(Send the Success view) ***********/
			String url = "/back-end/coupon/newAllCoupon.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
			successView.forward(req, res);
		}

	}

}
