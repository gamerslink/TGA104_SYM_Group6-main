package com.group6.tibame104.memberBlockList.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.group6.tibame104.memberBlockList.model.MemberBlockListService;
import com.group6.tibame104.memberBlockList.model.MemberBlockListVO;

@WebServlet("/member/MemberBlockListServlet")
public class MemberBlockListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberBlockListService mblSvc;

	@Override
	public void init() throws ServletException {
		ApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		mblSvc = applicationContext.getBean(MemberBlockListService.class);

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

			Integer memberID = Integer.valueOf(req.getParameter("memberID"));
			Integer storeID = Integer.valueOf(req.getParameter("storeID"));

			MemberBlockListVO mblVO = new MemberBlockListVO();
			mblVO.setMemberID(memberID);
			mblVO.setStoreID(storeID);

			// Send the use back to the form, if there were errors
			req.setAttribute("mblVO", mblVO); // 含有輸入格式錯誤的empVO物件,也存入req
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/member/login.jsp");

				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
//			System.out.println("memberID = " + memberID);
			mblVO = mblSvc.addBlock(memberID, storeID);

			req.setAttribute("mblVO", mblVO);
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/member/register2.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交register2.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer blockListID = Integer.valueOf(req.getParameter("blockListID"));

			/*************************** 2.開始刪除資料 ***************************************/
			mblSvc.delete(blockListID);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/member/listAllMember.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}

	}

}
