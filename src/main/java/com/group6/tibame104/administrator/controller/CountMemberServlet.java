package com.group6.tibame104.administrator.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.group6.tibame104.administrator.model.AdministratorJDBCDAO;
import com.group6.tibame104.administrator.model.CountMemberVO;

@WebServlet("/back-end/administrator/CountMemberServlet")
public class CountMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();

		/* GSON */
		Gson gson = new Gson();

		/* 搜尋資料 */
		// 1. 建立 VO
		CountMemberVO countMemberVO = new CountMemberVO();
		// 2. 把VO轉成JSON寫出
		AdministratorJDBCDAO administratorJDBCDAO = new AdministratorJDBCDAO();
		countMemberVO.setMemberTotal(administratorJDBCDAO.countMember());
		countMemberVO.setStoreTotal(administratorJDBCDAO.countStore());
		countMemberVO.setStatusTotalY(administratorJDBCDAO.countStatusY());
		countMemberVO.setStatusTotalN(administratorJDBCDAO.countStatusN());
		String json = gson.toJson(countMemberVO);
		writer.write(json);
		
	}
}
