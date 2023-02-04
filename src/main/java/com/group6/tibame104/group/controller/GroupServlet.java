package com.group6.tibame104.group.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.group6.tibame104.group.model.GroupService;
import com.group6.tibame104.group.model.GroupVO;
import com.group6.tibame104.groupproduct.model.GroupproductService;
import com.group6.tibame104.groupproduct.model.GroupproductVO;

@WebServlet("/front-end/group/Group.do")
public class GroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private GroupService groupSvc;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("groupBuyID");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入折扣表編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/groupdiscount/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer groupBuyID = null;
			try {
				groupBuyID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("折扣表格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/groupdiscount/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			GroupService groupSvc = new GroupService();
			GroupVO groupVO = groupSvc.getOneGroup(groupBuyID);

			if (groupVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/grouporder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("groupVO", groupVO); // 資料庫取出的empVO物件,存入req
			String url = "/back-end/group/listOneEmp.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}
		if ("addOrder".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("groupBuyID");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入折扣表編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/groupdiscount/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer groupBuyID = null;
			try {
				groupBuyID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("折扣表格式不正確1");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/groupdiscount/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
			String str2 = req.getParameter("groupBuyProductID");
			Integer groupBuyProductID = null;
			try {
				groupBuyProductID = Integer.valueOf(str2);
			} catch (Exception e) {
				errorMsgs.add("團購編號錯了");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/groupdiscount/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
			String str3 = req.getParameter("groupBuyCount");
			Double groupBuyCount = null;
			try {
				groupBuyCount = Double.valueOf(str3);
			} catch (Exception e) {
				errorMsgs.add("折扣表格不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/groupdiscount/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			GroupService groupSvc = new GroupService();
			GroupproductService groupproductSvc = new GroupproductService();
			GroupVO groupVO = groupSvc.getOneGroup(groupBuyID);
			GroupproductVO groupproductVO = groupproductSvc.getOneGroupproduct(groupBuyProductID);

			if (groupVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/grouporder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			HttpSession session = req.getSession();
			session.setAttribute("groupVO", groupVO); // 資料庫取出的empVO物件,存入req
			session.setAttribute("groupBuyCount", groupBuyCount);
			session.setAttribute("groupproductVO", groupproductVO);

			String url = "/front-end/group/addOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer groupBuyID = Integer.valueOf(req.getParameter("groupBuyID"));

			/*************************** 2.開始查詢資料 ****************************************/
			GroupService groupSvc = new GroupService();
			GroupVO groupVO = groupSvc.getOneGroup(groupBuyID);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("groupVO", groupVO); // 資料庫取出的empVO物件,存入req
			String url = "/back-end/group/updateGroup.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer groupBuyID = Integer.valueOf(req.getParameter("groupBuyID").trim());
			Integer groupBuyProductID = Integer.valueOf(req.getParameter("groupBuyProductID").trim());
			Integer administratorID = Integer.valueOf(req.getParameter("administratorID").trim());
			Integer groupBuyProductOrderTotal = Integer.valueOf(req.getParameter("groupBuyProductOrderTotal").trim());
			Boolean groupBuyingState = Boolean.valueOf(req.getParameter("groupBuyingState").trim());
			// 獲得時間戳記
			Timestamp updateTime = new Timestamp(System.currentTimeMillis());// 獲取系統當前時間
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String timeStr = df.format(updateTime);
			updateTime = Timestamp.valueOf(timeStr);
			
			
			Timestamp groupBuyingOnLoadDate = Timestamp.valueOf(req.getParameter("groupBuyingOnLoadDate").trim());
			Timestamp groupBuyingOffLoadDate = Timestamp.valueOf(req.getParameter("groupBuyingOffLoadDate").trim());

			GroupVO groupVO = new GroupVO();

			groupVO.setGroupBuyProductID(groupBuyProductID);
			groupVO.setAdministratorID(administratorID);
			groupVO.setGroupBuyProductOrderTotal(groupBuyProductOrderTotal);
			groupVO.setGroupBuyingState(groupBuyingState);
			groupVO.setGroupBuyingOnLoadDate(groupBuyingOnLoadDate);
			groupVO.setGroupBuyingOffLoadDate(groupBuyingOffLoadDate);
			groupVO.setUpdateTime(updateTime);
			groupVO.setGroupBuyID(groupBuyID);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("groupVO", groupVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/emp/update_emp_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			GroupService groupSvc = new GroupService();
			groupVO = groupSvc.updateGroup(groupBuyProductID, administratorID, groupBuyProductOrderTotal,
					groupBuyingState, groupBuyingOnLoadDate, groupBuyingOffLoadDate, updateTime, groupBuyID);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("groupVO", groupVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/back-end/group/listAllGroup.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

			Integer groupBuyProductID = Integer.valueOf(req.getParameter("groupBuyProductID").trim());
			Integer administratorID = Integer.valueOf(req.getParameter("administratorID").trim());
			Integer groupBuyProductOrderTotal = Integer.valueOf(req.getParameter("groupBuyProductOrderTotal").trim());
			Boolean groupBuyingState = Boolean.valueOf(req.getParameter("groupBuyingState").trim());

			// 獲得時間戳記
			Timestamp updateTime = new Timestamp(System.currentTimeMillis());// 獲取系統當前時間
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String timeStr = df.format(updateTime);
			updateTime = Timestamp.valueOf(timeStr);

			Timestamp groupBuyingOnLoadDate = Timestamp.valueOf(req.getParameter("groupBuyingOnLoadDate").trim());
			Timestamp groupBuyingOffLoadDate = Timestamp.valueOf(req.getParameter("groupBuyingOffLoadDate").trim());

			GroupVO groupVO = new GroupVO();

			groupVO.setGroupBuyProductID(groupBuyProductID);
			groupVO.setAdministratorID(administratorID);
			groupVO.setGroupBuyProductOrderTotal(groupBuyProductOrderTotal);
			groupVO.setGroupBuyingState(groupBuyingState);
			groupVO.setGroupBuyingOnLoadDate(groupBuyingOnLoadDate);
			groupVO.setGroupBuyingOffLoadDate(groupBuyingOffLoadDate);
			groupVO.setUpdateTime(updateTime);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("groupVO", groupVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/group/addEmp.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			GroupService groupSvc = new GroupService();
			groupVO = groupSvc.addGroup(groupBuyProductID, administratorID, groupBuyProductOrderTotal, groupBuyingState,
					groupBuyingOnLoadDate, groupBuyingOffLoadDate, updateTime);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/group/listAllGroup.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer groupBuyID = Integer.valueOf(req.getParameter("groupBuyID"));

			/*************************** 2.開始刪除資料 ***************************************/
			GroupService groupSvc = new GroupService();
			groupSvc.deleteGroup(groupBuyID);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/group/listAllGroup.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}

}
