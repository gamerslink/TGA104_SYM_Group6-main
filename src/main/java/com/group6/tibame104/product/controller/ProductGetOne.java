package com.group6.tibame104.product.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group6.tibame104.product.model.ProductVO;
import com.group6.tibame104.product.service.ProductService;

@Controller
@RequestMapping("/product/productGetOne")
public class ProductGetOne {
	
	@Autowired
	private ProductService productSvc;

	@GetMapping("/get")
	public String update(Model model, HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("productID") String productIDStr) {
			
		
		Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
		model.addAttribute("errorMsgs", errorMsgs);

		if (productIDStr == null || (productIDStr.trim()).length() == 0) {
			errorMsgs.put("productID", "請輸入正常的數字");
		}

		Integer productID = null;
		try {
			productID = Integer.valueOf(productIDStr);
		} catch (Exception e) {
			errorMsgs.put("productID", "請輸入正常的數字");
		}
		/*
		 * 如果報錯 轉去 Error 頁面
		 */
		if (!errorMsgs.isEmpty()) {
			return "front-end/store/Error";
		}
		/*
		 * 取得資料
		 * 
		 */
		ProductVO productVO = productSvc.findByPrimaryKey(productID);

		/* 
		 * 導向 productUpdate頁面
		 */
		model.addAttribute("productVO", productVO);
		return "front-end/product/updateProduct";
		
	}

}
