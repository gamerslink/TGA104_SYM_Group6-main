package com.group6.tibame104.product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.group6.tibame104.product.model.ProductVO;
import com.group6.tibame104.product.service.ProductService;

@WebServlet("/product/productSearchLiu")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class ProductSerchLiu extends HttpServlet {
	private static final String saveDirectory = "front-end/images";

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

		PrintWriter writer = res.getWriter();

		List<String> errorMsgs = new LinkedList<String>();
		req.setAttribute("errorMsgs", errorMsgs);
		Map<String, String> queryString = new LinkedHashMap<String, String>();


		String productName = req.getParameter("productName");
		System.out.println("productName ="+productName);
		String productNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
		if (productName != null && productName.trim().length() != 0) {
			if (!productName.trim().matches(productNameReg)) {
				errorMsgs.add("wrong productName");
			} else {
				queryString.put("productName", "" + productName);
			}
		}

		Gson gson = new Gson();
		List<ProductVO> productVOall = new ProductService().getAll(productName);
		
		writer.write(gson.toJson(productVOall));
	}

}
