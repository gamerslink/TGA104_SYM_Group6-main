package com.group6.tibame104.coupon.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.group6.tibame104.coupon.model.CouponJDBCDAO;
import com.group6.tibame104.coupon.model.CouponService;
import com.group6.tibame104.coupon.model.CouponVO;
import com.group6.tibame104.group.model.GroupService;

@WebServlet("/CouponAll")
public class CouponAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private CouponService couponSvc;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

		PrintWriter writer = res.getWriter();

		Gson gson = new Gson();
		List<CouponVO> all = new CouponJDBCDAO().getAll();
		
		writer.write(gson.toJson(all));
	}


}
