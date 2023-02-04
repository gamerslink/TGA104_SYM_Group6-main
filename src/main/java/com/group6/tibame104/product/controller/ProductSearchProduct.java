package com.group6.tibame104.product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

import com.google.gson.Gson;
import com.group6.tibame104.product.model.ProductVO;
import com.group6.tibame104.product.service.ProductService;

@Controller
@RequestMapping("/product/productSearchProduct")
public class ProductSearchProduct {

	@Autowired
	private ProductService productSvc;

	@GetMapping("/getAll_By_Cond")
	public void getAllByCond(Model model,
			HttpServletResponse response,
			@RequestParam("storeID") String storeID,
			@RequestParam(value="productID",required=false) String productIDStr,
			@RequestParam(value="productSecID",required=false) String productSecIDStr,
			@RequestParam("productStatus") String productStatus) {
		
		List<String> errorMsgs = new LinkedList<String>();
		model.addAttribute("errorMsgs", errorMsgs);		

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*queryString*/
		Map<String, String>  queryString = new HashMap<String,String>();
		
		/*JSON*/
		Gson gson = new Gson();
		
		/* 1. 請求參數的格式整理 */
		
		queryString.put("storeID", storeID);

		Integer productID = null;
		try {
			productID = Integer.valueOf(productIDStr.trim());
			queryString.put("productID", productID+"");
		} catch (Exception e) {
			System.out.println("錯誤");
		}


		Integer productSecID = null;
		try {
			productSecID = Integer.valueOf(productSecIDStr.trim());
			queryString.put("productSecID", productSecID+"");
		} catch (Exception e) {
			System.out.println("錯誤");
		}
		
		queryString.put("productStatus", productStatus);

		
		/***************************
		 * 搜尋資料
		 ***************************************/
		System.out.println("queryString = " + queryString);
		List<ProductVO> allByCond = productSvc.getAllByCondFront(queryString);

		String json = gson.toJson(allByCond);
		writer.write(json);

	}

}
