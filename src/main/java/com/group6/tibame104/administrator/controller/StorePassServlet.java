package com.group6.tibame104.administrator.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.group6.tibame104.administrator.model.AdministratorJDBCDAO;
import com.group6.tibame104.store.model.StoreVO;

@WebServlet("/back-end/administrator/StorePassServlet")
public class StorePassServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		
		/*GSON*/
		Gson gson = new Gson();
		
		
		 /*搜尋資料 審核通過*/
		 List<StoreVO> findAllByAudit1 = new  AdministratorJDBCDAO().findAllByAudit1();
		 String json = gson.toJson(findAllByAudit1);
		 writer.write(json);
		 System.out.println(json);
	
	}
}
