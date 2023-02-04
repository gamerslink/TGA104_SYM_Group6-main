package com.group6.tibame104.grouporder.controller;

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

import com.group6.tibame104.group.model.GroupService;
import com.group6.tibame104.group.model.GroupVO;
import com.group6.tibame104.grouporder.model.GrouporderService;
import com.group6.tibame104.grouporder.model.GrouporderVO;
@WebServlet("/front-end/grouporder/Grouporder.do")
public class GrouporderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GrouporderServlet() {
		super();
	}

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
			String str = req.getParameter("groupBuyOrderID");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入團購訂單編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/grouporder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer groupBuyOrderID = null;
			try {
				groupBuyOrderID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("團購訂單編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/grouporder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			GrouporderService grouporderSvc = new GrouporderService();

			GrouporderVO grouporderVO = grouporderSvc.getOneGrouporder(groupBuyOrderID);

			if (grouporderVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/grouporder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("grouporderVO", grouporderVO); // 資料庫取出的empVO物件,存入req

			String url = "/back-end/grouporder/listOneEmp.jsp";
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
				errorMsgs.add("請輸入團購訂單編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/grouporder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer groupBuyID = null;
			try {
				groupBuyID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("團購訂單編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/grouporder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			GrouporderService grouporderSvc = new GrouporderService();

			GrouporderVO grouporderVO = grouporderSvc.getOneGrouporder(groupBuyID);

			if (grouporderVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/grouporder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("grouporderVO", grouporderVO); // 資料庫取出的empVO物件,存入req

			String url = "/back-end/grouporder/listOneEmp.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer groupBuyOrderID = Integer.valueOf(req.getParameter("groupBuyOrderID"));

			/*************************** 2.開始查詢資料 ****************************************/
			GrouporderService grouporderSvc = new GrouporderService();
			GrouporderVO grouporderVO = grouporderSvc.getOneGrouporder(groupBuyOrderID);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("grouporderVO", grouporderVO); // 資料庫取出的empVO物件,存入req
			String url = "/back-end/grouporder/update_GroupOrder_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer groupBuyOrderID = Integer.valueOf(req.getParameter("groupBuyOrderID").trim());
			
			Integer groupBuyID = null;
			try {
				groupBuyID = Integer.valueOf(req.getParameter("groupBuyID").trim());
			}catch(NumberFormatException e){
				groupBuyID = 0;
				errorMsgs.add("團購編號請填數字.");
			}
			
			Integer memberID = null;
			try {
				memberID = Integer.valueOf(req.getParameter("memberID").trim());
			}catch(NumberFormatException e){
				memberID = 0;
				errorMsgs.add("會員編號請填數字.");
			}
			
			Integer groupBuyProductID = null;
			try {
				groupBuyProductID = Integer.valueOf(req.getParameter("groupBuyProductID").trim());
			}catch(NumberFormatException e){
				groupBuyProductID = 0;
				errorMsgs.add("團購商品編號請填數字.");
			}
			
			Integer groupBuyQuantity = null;
			try {
				groupBuyQuantity = Integer.valueOf(req.getParameter("groupBuyQuantity").trim());
			}catch(NumberFormatException e){
				groupBuyQuantity = 0;
				errorMsgs.add("團購數量請填數字.");
			}
			
			Integer groupBuyTotal = null;
			try {
				groupBuyTotal = Integer.valueOf(req.getParameter("groupBuyTotal").trim());
			}catch(NumberFormatException e){
				groupBuyTotal = 0;
				errorMsgs.add("總金額請填數字.");
			}
			
			Timestamp orderTime = null;
			try {
				orderTime = Timestamp.valueOf(req.getParameter("orderTime").trim());
			} catch (IllegalArgumentException e) {
				orderTime = new Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}
			String paymentTerm = req.getParameter("paymentTerm").trim();
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (paymentTerm == null || paymentTerm.trim().length() == 0) {
				errorMsgs.add("員工姓名: 請勿空白");
			} else if(!paymentTerm.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
            }
			
			Integer giftVoucher = null;
			try {
				giftVoucher = Integer.valueOf(req.getParameter("giftVoucher").trim());
			}catch(NumberFormatException e){
				giftVoucher = 0;
				errorMsgs.add("購物金請填數字.");
			}
			Integer paymentState = null;
			try {
				paymentState = Integer.valueOf(req.getParameter("paymentState").trim());
			}catch(NumberFormatException e){
				paymentState = 0;
				errorMsgs.add("結帳狀態請填數字.");
			}
			String contactNumber = req.getParameter("contactNumber").trim();
			if (paymentTerm == null || paymentTerm.trim().length() == 0) {
				errorMsgs.add("員工姓名: 請勿空白");
			} else if(!paymentTerm.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
            }
			String shippingLocation = req.getParameter("shippingLocation").trim();
			if (paymentTerm == null || paymentTerm.trim().length() == 0) {
				errorMsgs.add("員工姓名: 請勿空白");
			} else if(!paymentTerm.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
            }
			
			

			GrouporderVO grouporderVO = new GrouporderVO();
			
			grouporderVO.setGroupBuyOrderID(groupBuyOrderID);
			grouporderVO.setGroupBuyID(groupBuyID);
			grouporderVO.setMemberID(memberID);
			grouporderVO.setGroupBuyProductID(groupBuyProductID);
			grouporderVO.setGroupBuyQuantity(groupBuyQuantity);
			grouporderVO.setGroupBuyTotal(groupBuyTotal);
			grouporderVO.setOrderTime(orderTime);
			grouporderVO.setPaymentTerm(paymentTerm);
			grouporderVO.setPaymentState(paymentState);
			grouporderVO.setGiftVoucher(giftVoucher);
			grouporderVO.setContactNumber(contactNumber);
			grouporderVO.setShippingLocation(shippingLocation);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("grouporderVO", grouporderVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/grouporder/update_GroupOrder_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			GrouporderService grouporderSvc = new GrouporderService();
			grouporderVO = grouporderSvc.updateGrouporder(groupBuyOrderID, groupBuyID, memberID,
					 groupBuyProductID, groupBuyQuantity,  groupBuyTotal, orderTime, paymentTerm,
					 paymentState,  giftVoucher,  contactNumber, shippingLocation);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("grouporderVO", grouporderVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/back-end/grouporder/listOneGroupOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}
		//新增團購訂單後 更改團購的團購總數量
			if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
				
				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);

					/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

				
				Integer groupBuyID = Integer.valueOf(req.getParameter("groupBuyID").trim());
				Integer memberID = Integer.valueOf(req.getParameter("memberID").trim());
				Integer groupBuyProductID = Integer.valueOf(req.getParameter("groupBuyProductID").trim());
				Integer groupBuyQuantity = Integer.valueOf(req.getParameter("groupBuyQuantity").trim());
				Double groupBuyTotal1 = Double.valueOf(req.getParameter("groupBuyTotal"));
				Integer groupBuyTotal = (int) Math.ceil(groupBuyTotal1);
				
				Timestamp orderTime = null;
				try {
					orderTime = Timestamp.valueOf(req.getParameter("orderTime").trim());
				} catch (Exception e) {
					orderTime = new Timestamp(System.currentTimeMillis());
					
				}
				String paymentTerm = req.getParameter("paymentTerm").trim();
				Integer giftVoucher = Integer.valueOf(req.getParameter("giftVoucher").trim());
				Integer paymentState = Integer.valueOf(req.getParameter("paymentState").trim());
				String contactNumber = req.getParameter("contactNumber").trim();
				String shippingLocation = req.getParameter("shippingLocation").trim();

				GrouporderVO grouporderVO = new GrouporderVO();
				
				
				grouporderVO.setMemberID(memberID);
				grouporderVO.setGroupBuyProductID(groupBuyProductID);
				grouporderVO.setGroupBuyQuantity(groupBuyQuantity);
				grouporderVO.setGroupBuyTotal(groupBuyTotal);
				grouporderVO.setOrderTime(orderTime);
				grouporderVO.setPaymentTerm(paymentTerm);
				grouporderVO.setPaymentState(paymentState);
				grouporderVO.setGiftVoucher(giftVoucher);
				grouporderVO.setContactNumber(contactNumber);
				grouporderVO.setShippingLocation(shippingLocation);

				GroupService groupSvc =new GroupService();			
				GroupVO groupVO = new GroupVO();
				groupVO = groupSvc.getOneGroup(groupBuyID);
				
				Integer currentQua = groupVO.getGroupBuyProductOrderTotal();
					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
	req.setAttribute("grouporderVO", grouporderVO); // 含有輸入格式錯誤的empVO物件,也存入req
						RequestDispatcher failureView = req
								.getRequestDispatcher("/back-end/grouporder/addEmp.jsp");
						failureView.forward(req, res);
						return;
					}
					/***************************2.開始新增資料***************************************/
					GrouporderService grouporderSvc = new GrouporderService();
					grouporderVO = grouporderSvc.addGrouporder(groupBuyID, groupBuyProductID, memberID, groupBuyQuantity,  groupBuyTotal, orderTime, paymentTerm,
							 paymentState,  giftVoucher,  contactNumber, shippingLocation);
					/**更新團購總數**/
					GroupService GroupSvc = new GroupService();
					groupVO = GroupSvc.updateGroupQua(currentQua+groupBuyQuantity,groupBuyID);
					
					/***************************3.新增完成,準備轉交(Send the Success view)***********/
					String url = "/back-end/grouporder/listAllGroupOrder.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
					successView.forward(req, res);				
			}
			//用memberID查所有訂單
			if ("getOrder_By_Mem".equals(action)) { // 來自select_page.jsp的請求

				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);

				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				String str = req.getParameter("memberID");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入會員編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/front-end/grouporder/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				Integer memberID = null;
				try {
					memberID = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("折扣表格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/front-end/grouporder/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 2.開始查詢資料 *****************************************/
				GrouporderService grouporderSvc = new GrouporderService();
				List<GrouporderVO> grouporderVO = grouporderSvc.getAllByMemID(memberID);

				if (grouporderVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/front-end/grouporder/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				req.setAttribute("grouporderVO", grouporderVO); // 資料庫取出的empVO物件,存入req
				String url = "/back-end/grouporder/listMyGroupOrder.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
			}
			if ("delete".equals(action)) { // 來自listAllEmp.jsp

				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);
		
					/***************************1.接收請求參數***************************************/
					Integer groupBuyOrderID = Integer.valueOf(req.getParameter("groupBuyOrderID"));
					
					/***************************2.開始刪除資料***************************************/
					GrouporderService grouporderSvc = new GrouporderService();
					grouporderSvc.deleteGrouporder(groupBuyOrderID);
					
					/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
					String url = "/back-end/grouporder/listAllGroupOrder.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
					successView.forward(req, res);
			}
	}
	

}
