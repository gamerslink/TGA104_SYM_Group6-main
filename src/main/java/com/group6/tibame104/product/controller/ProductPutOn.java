package com.group6.tibame104.product.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
import com.group6.tibame104.product.service.ProductService;

@Controller
@RequestMapping("/product/productPutOn")
public class ProductPutOn{

	@Autowired
	private ProductService productSvc;

	@PostMapping("/on")
	public void update(Model model,
			HttpServletResponse response,
			@RequestParam("productID") String productIDStr) throws IOException {

		PrintWriter writer = response.getWriter();
		
		Integer productID = null;

		try {
			productID = Integer.valueOf(productIDStr.trim());
		} catch (Exception e) {
			productID = 0;
		}
		Gson gson = new Gson();
		String json = gson.toJson(productSvc.putOn(productID));
		writer.write(json);
	}

}
