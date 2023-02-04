package com.group6.tibame104.administrator.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/back-end/loginAdm/loginAdm")
public class loginhandlerAd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 檢查帳號密碼
	 * 實際應至資料庫搜尋比對
	 * */
	protected boolean allowUser(String account, String password) {
		
		/**
		 * 管理員帳密
		 * */
		if ("AD0001@symgmail.com".equals(account) && "a123456789".equals(password))
			return true;
		else {
			return false;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
			
		/**
		 * 取得帳號密碼
		 * */
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		
		/**
		 * 檢查帳號密碼，是否有效
		 * 帳密無效，執行
		 * */
		if(!allowUser(account, password)) {
			out.println("<HTML><HEAD><TITLE>Access Denied</TITLE></HEAD>");
			out.println("\"<BODY>你的帳號 , 密碼無效!<BR>\"");
			out.println("請按此重新登入 <A HREF="+req.getContextPath()+"/loginAdm.html>重新登入</A>");
			out.println("</BODY></HTML>");
		} else { // 帳密有效，執行
			/**
			 * 取出 session 物件
			 * */
			HttpSession session = req.getSession();
			
			/**
			 * 呼叫"account"
			 * */
			session.setAttribute("account", account);
			
			try {
				String location = (String) session.getAttribute("location");
				if (location != null) {
					session.removeAttribute("location");   //*工作2: 看看有無來源網頁 (-->如有來源網頁:則重導至來源網頁)
					resp.sendRedirect(location);            
					return;
				}
			}catch (Exception ignored) { }

		      resp.sendRedirect(req.getContextPath()+"/loginAdm.html");  //*工作3: (-->如無來源網頁:則重導至login_success.jsp)
		    }
		}
}
