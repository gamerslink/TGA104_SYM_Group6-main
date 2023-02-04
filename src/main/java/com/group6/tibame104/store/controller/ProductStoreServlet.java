package com.group6.tibame104.store.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group6.tibame104.store.model.StoreJDBCDAO;
import com.group6.tibame104.store.model.StoreVO;

@WebServlet("/store/productStoreServlet")
public class ProductStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		String storeIDstr = req.getParameter("storeID");
		Integer storeID = null;
		try {
			storeID = Integer.parseInt(storeIDstr);
		}catch(Exception e) {
			e.printStackTrace();
		}
		StoreJDBCDAO storeJDBCDAO = new StoreJDBCDAO();
		
		StoreVO storeVO = storeJDBCDAO.findByPrimaryKey(storeJDBCDAO.findMemberID(storeID));
		req.setAttribute("storeVO", storeVO);
		/*
		 * 導向productStore頁面
		 */
		
		String url = "/front-end/store/productStore.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res);

	}
}
