package com.group6.tibame104.ad.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group6.tibame104.ad.model.AdService;
import com.group6.tibame104.ad.model.AdVO;

@WebServlet("/back-end/ad/adHomeServlet")
public class AdHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		
		AdService adService = new AdService();
		List<AdVO> list = adService.getAll();
		req.setAttribute("list", list);
		RequestDispatcher failureView = req.getRequestDispatcher("/index_sym.jsp");
		failureView.forward(req, resp);
	
	}

}
