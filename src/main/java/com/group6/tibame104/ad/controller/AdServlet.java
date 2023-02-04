package com.group6.tibame104.ad.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.group6.tibame104.ad.model.AdService;
import com.group6.tibame104.ad.model.AdVO;
@WebServlet("/back-end/ad/adServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class AdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String saveDirectory = "front-end/images";

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("adSerialID");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入廣告編號");
				}

			// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/ad/select_page2.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				Integer adSerialID = null;

				try {
					adSerialID = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/ad/select_page2.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				
				
			/*************************** 2.開始查詢資料 *****************************************/
			AdService adSvc = new AdService();
			AdVO adVO = adSvc.getOneAd(adSerialID);
				if (adVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/ad/select_page2.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("adVO", adVO); // 資料庫取出的advVO物件,存入req
			String url = "/back-end/ad/listOneAd2.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
Integer adSerialID = Integer.valueOf(req.getParameter("adSerialID"));
			/*************************** 2.開始查詢資料 ****************************************/
			AdService adSvc = new AdService();
			AdVO adVO = adSvc.getOneAd(adSerialID);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("adVO", adVO); // 資料庫取出的advVO物件,存入req
			String url = "/back-end/ad/update_ad_input2.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
Integer adSerialID = Integer.valueOf(req.getParameter("adSerialID").trim());
			String adTitle = req.getParameter("adTitle");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (adTitle == null || adTitle.trim().length() == 0) {
				errorMsgs.add("adSerialID廣告標題: 請勿空白");
			}
			
			
			/*測試*/
//			else if (!adTitle.trim().matches(enameReg)) { // 以下練習正則(規)表示式(regular-expression)
//				System.out.println(enameReg);
//				errorMsgs.add("只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//			}

String adType = req.getParameter("adType");

			
String adDescribe = req.getParameter("adDescribe");
			if (adDescribe == null || adDescribe.trim().length() == 0) {
				errorMsgs.add("廣告描述: 請勿空白");
			}

java.sql.Date adStartDate = null;
			try {
				adStartDate = java.sql.Date.valueOf(req.getParameter("adStartDate").trim());
			} catch (IllegalArgumentException e) {
				adStartDate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入上架日期!");
			}

java.sql.Date adEndDate = null;
			try {
				adEndDate = java.sql.Date.valueOf(req.getParameter("adEndDate").trim());
			} catch (IllegalArgumentException e) {
				adEndDate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入下架日期!");
			}

			
//			圖片上傳
			String realPath = getServletContext().getRealPath(saveDirectory);
			File fsaveDirectory = new File(realPath);
			if (!fsaveDirectory.exists())
				fsaveDirectory.mkdirs(); // �� ContextPath ���U,�۰ʫإߥئa�ؿ�

			Collection<Part> parts = req.getParts(); // Servlet3.0�s�W�FPart�����A���ڭ̤�K���i���ɮפW�ǳB�z
			byte[] imgAdd= null;
			for (Part part : parts) {
				String filename = part.getSubmittedFileName();
				if (filename != null && filename.length() != 0 && part.getContentType() != null) {
					InputStream inputStream = part.getInputStream();
					imgAdd = inputStream.readAllBytes();
				}
			}
			
			

//Integer groupBuyID = Integer.valueOf(req.getParameter("groupBuyID").trim());


			AdVO adVO = new AdVO();
			
			adVO.setAdSerialID(adSerialID);
//			adVO.setGroupBuyID(groupBuyID);
			adVO.setAdTitle(adTitle);
			adVO.setAdType("團購活動");
			adVO.setAdDescribe(adDescribe);
			adVO.setAdPhoto(imgAdd);
			adVO.setAdStartDate(adStartDate);
			adVO.setAdEndDate(adEndDate);
//			adVO.setUpdateTime(updateTime);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("adVO", adVO); // 含有輸入格式錯誤的advVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/ad/update_ad_input2.jsp");
				failureView.forward(req, res);
//				System.out.println(errorMsgs);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			AdService adSvc = new AdService();
			adVO = adSvc.updateAd(adSerialID, adTitle, adType, adDescribe, imgAdd, adStartDate, adEndDate);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("adVO", adVO); // 資料庫update成功後,正確的的advVO物件,存入req
			String url = "/back-end/ad/listAllAd2.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/	
Integer administratorID = Integer.valueOf(req.getParameter("administratorID"));

Integer groupBuyID = Integer.valueOf(req.getParameter("groupBuyID"));
			
String adTitle = req.getParameter("adTitle");
//			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//			if (adTitle == null || adTitle.trim().length() == 0) {
//				errorMsgs.add("廣告標題: 請勿空白");
//			} else if (!adTitle.trim().matches(enameReg)) { // 以下練習正則(規)表示式(regular-expression)
//				errorMsgs.add("只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//			}

String adType = req.getParameter("adType");
//			if (adType == null || adType.trim().length() == 0) {
//				errorMsgs.add("請勿空白類別");
//			}
			
String adDescribe = req.getParameter("adDescribe");
			if (adDescribe == null || adDescribe.trim().length() == 0) {
				errorMsgs.add("請勿空白");
			}

java.sql.Date adStartDate = null;
			try {
				adStartDate = java.sql.Date.valueOf(req.getParameter("adStartDate").trim());
			} catch (IllegalArgumentException e) {
				adStartDate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入上架日期!");
			}

java.sql.Date adEndDate = null;
			try {
				adEndDate = java.sql.Date.valueOf(req.getParameter("adEndDate").trim());
			} catch (IllegalArgumentException e) {
				adEndDate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入下架日期!");
			}

			
			
//			圖片上傳
			String realPath = getServletContext().getRealPath(saveDirectory);
			File fsaveDirectory = new File(realPath);
			if (!fsaveDirectory.exists())
				fsaveDirectory.mkdirs(); // �� ContextPath ���U,�۰ʫإߥئa�ؿ�

			Collection<Part> parts = req.getParts(); // Servlet3.0�s�W�FPart�����A���ڭ̤�K���i���ɮפW�ǳB�z

			byte[] imgAdd= null;
			for (Part part : parts) {
				System.out.println(part.getName());
				String filename = part.getSubmittedFileName();
				System.out.println("filename = " + filename);
				if (filename != null && filename.length() != 0 && part.getContentType() != null) {
					InputStream inputStream = part.getInputStream();
					imgAdd = inputStream.readAllBytes();
				}
			}

			AdVO adVO = new AdVO();
			adVO.setAdministratorID(administratorID);
			adVO.setGroupBuyID(groupBuyID);
			adVO.setAdTitle(adTitle);
			adVO.setAdType(adType);
			adVO.setAdDescribe(adDescribe);
			adVO.setAdStartDate(adStartDate);
			adVO.setAdEndDate(adEndDate);
			adVO.setAdPhoto(imgAdd);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("adVO", adVO); // 含有輸入格式錯誤的advVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/ad/addAd2.jsp");
				failureView.forward(req, res);
				return;
			}

			
			/*************************** 2.開始新增資料 ***************************************/
			AdService adSvc = new AdService();
			adVO = adSvc.addAd(administratorID, groupBuyID, adTitle, adType, adDescribe, adStartDate, adEndDate, imgAdd);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/ad/listAllAd2.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer adSerialID = Integer.valueOf(req.getParameter("adSerialID"));

			/*************************** 2.開始刪除資料 ***************************************/
			AdService adSvc = new AdService();
			adSvc.deleteAd(adSerialID);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/ad/listAllAd2.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
	

}
