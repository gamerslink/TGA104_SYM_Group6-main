package com.group6.tibame104.administrator.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group6.tibame104.administrator.model.MailService;
import com.group6.tibame104.member.model.MemberService;
import com.group6.tibame104.member.model.MemberVO;



@WebServlet("/back-end/administrator/AdminMailServlet")
public class AdminMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer memberID = null;
		try {
			memberID =Integer.valueOf(req.getParameter("memberID"));
			com.group6.tibame104.store.model.StoreJDBCDAO storeJDBCDAO = new com.group6.tibame104.store.model.StoreJDBCDAO();
			storeJDBCDAO.pass(memberID);
			MemberVO memberVO = new MemberService().getOneMem(memberID);
			MailService mailService = new MailService();
			
			String to = memberVO.getMail();
			System.out.println("to = "+to);

			String subject = "賣場開通通知";
			String ch_name = memberVO.getUserName();
            String messageText = "Hello! " + ch_name + " 你的賣場開通囉 \n (已經啟用)";
			
			mailService.sendMail(to, subject, messageText);
			
			String url = "/back-end/administrator/sellerVerify.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, resp);
		} catch(Exception e) {
			
		}
	}
}
