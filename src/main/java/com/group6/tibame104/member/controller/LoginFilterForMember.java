package com.group6.tibame104.member.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/front-end/member/my-account.jsp", "/front-end/group/addOrder" })
public class LoginFilterForMember extends HttpFilter {
	private static final long serialVersionUID = 1L;
	private FilterConfig config;

	@Override
	public void init(FilterConfig config) {
		this.config = config;
	}

	@Override
	public void destroy() {
		config = null;
	}

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		// 【取得 session】
		HttpSession session = req.getSession();
		// 【從 session 判斷此user是否登入過】
		Object account = session.getAttribute("mail");
		if (account == null) {
//			System.out.println(req.getRequestURI());
//			System.out.println(req.getRequestURL());
//			System.out.println(req.getHeader("Referer"));
			String fullURL = req.getHeader("Referer");
			String targetURL = fullURL.split(req.getContextPath())[1];
			session.setAttribute("location", targetURL);
			res.sendRedirect(req.getContextPath() + "/front-end/member/login.jsp");
			return;
		} else {
			chain.doFilter(req, res);
		}

	}

}
