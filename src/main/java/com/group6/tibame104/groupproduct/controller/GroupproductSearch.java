package com.group6.tibame104.groupproduct.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.group6.tibame104.groupproduct.model.GroupproductService;
import com.group6.tibame104.groupproduct.model.GroupproductVO;

@WebServlet("/front-end/groupproduct/GroupproductSearch")
public class GroupproductSearch extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter writer = res.getWriter();
		/* queryString */
		Map<String, String> queryString = new HashMap<String, String>();
		/* JSON */
		Gson gson = new Gson();

		/* 1. 請求參數的格式整理 */

		Integer groupbuyProductID = null;
		try {
			groupbuyProductID = Integer.valueOf(req.getParameter("groupbuyProductID").trim());
			queryString.put("groupbuyProductID", groupbuyProductID + "");
		} catch (Exception e) {
			System.out.println("groupbuyProductID錯誤");
		}
		
		Integer groupbuyProductPrice = null;
		try {
			groupbuyProductPrice = Integer.valueOf(req.getParameter("groupbuyProductPrice").trim());
			queryString.put("groupbuyProductPrice", groupbuyProductPrice + "");
		} catch (Exception e) {
			System.out.println("groupbuyProductPrice錯誤");
		}
		String groupbuyProductDescrip = null;
		try {
			groupbuyProductDescrip = req.getParameter("groupbuyProductDescrip").trim();
			queryString.put("groupbuyProductDescrip", "'"+ groupbuyProductDescrip + "'");
		} catch (Exception e) {
			System.out.println("groupbuyProductDescrip錯誤");
		}
		
//		System.out.println("queryString = " + queryString);
		
		List<GroupproductVO> allByCond = new GroupproductService().getAllBySearch(queryString);

		String json = gson.toJson(allByCond);
		writer.write(json);
		
	}

}
