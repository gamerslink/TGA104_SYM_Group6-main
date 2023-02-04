package com.group6.tibame104.creditCard.controller;

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

import com.group6.tibame104.creditCard.model.CreditCardService;
import com.group6.tibame104.creditCard.model.CreditCardVO;
import com.group6.tibame104.member.model.MemberService;
import com.group6.tibame104.member.model.MemberVO;

@WebServlet("/member/CreditCardServlet")
public class CreditCardServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CreditCardService cardSvc;
	private MemberService memSvc;

	@Override
	public void init() throws ServletException {
		ApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		cardSvc = applicationContext.getBean(CreditCardService.class);
		memSvc = applicationContext.getBean(MemberService.class);

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/

			String creditCardNumber = req.getParameter("creditCardNumber");
			String securityCode = req.getParameter("securityCode").trim();
			java.sql.Date exDate = null;
			exDate = java.sql.Date.valueOf(req.getParameter("exDate"));
			Integer creditCardID = Integer.valueOf(req.getParameter("creditCardID"));

			CreditCardVO cardVO = new CreditCardVO();
			cardVO.setCreditCardNumber(creditCardNumber);
			cardVO.setSecurityCode(securityCode);
			cardVO.setExDate(exDate);
			cardVO.setCreditCardID(creditCardID);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("cardVO", cardVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/member/update_member_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/

			cardVO = cardSvc.updateCreditCard(creditCardNumber, securityCode, exDate, creditCardID);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("cardVO", cardVO); // 資料庫update成功後,正確的的memVO物件,存入req
			String url = "/front-end/member/register2.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);

		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

			Integer memberID = Integer.valueOf(req.getParameter("memberID"));
			String creditCardNumber = req.getParameter("creditCardNumber").trim();
			String securityCode = req.getParameter("securityCode").trim();

			java.sql.Date exDate = null;

			exDate = java.sql.Date.valueOf(req.getParameter("exDate"));

			MemberVO memVO = new MemberVO();
			CreditCardVO cardVO = new CreditCardVO();
			cardVO.setMemberID(memberID);
			cardVO.setCreditCardNumber(creditCardNumber);
			cardVO.setSecurityCode(securityCode);
			cardVO.setExDate(exDate);

			// Send the use back to the form, if there were errors
			req.setAttribute("cardVO", cardVO); // 含有輸入格式錯誤的empVO物件,也存入req
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/member/login.jsp");

				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			cardVO = cardSvc.addCreditCard(memberID, creditCardNumber, securityCode, exDate);

			memVO = memSvc.getOneMem(memberID);

			req.setAttribute("memVO2", memVO);
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/front-end/member/my-account.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交register2.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer creditCardID = Integer.valueOf(req.getParameter("creditCardID"));
			Integer memberID = Integer.valueOf(req.getParameter("memberID"));

			MemberVO memVO = new MemberVO();
			memVO.setMemberID(memberID);

			/*************************** 2.開始刪除資料 ***************************************/
			cardSvc.deletecreditCard(creditCardID);
			memVO = memSvc.getOneMem(memberID);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			req.setAttribute("memVO2", memVO);
			String url = "/front-end/member/my-account.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}

	}

}
