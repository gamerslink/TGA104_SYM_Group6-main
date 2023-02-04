package com.group6.tibame104.search.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.group6.tibame104.category.model.CategoryService;
import com.group6.tibame104.category.model.CategoryVO;
import com.group6.tibame104.orderlist.model.OrderlistService;
import com.group6.tibame104.orderlist.model.OrderlistVO;
import com.group6.tibame104.product.model.ProductVO;
import com.group6.tibame104.product.service.ProductService;
import com.group6.tibame104.store.model.StoreJDBCDAO;

@Component
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private OrderlistService orderlistSvc;
	@Autowired
	private CategoryService categorySvc;
	
	
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			doPost(req,res);
	}
	

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		    req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html; charset=UTF-8");
		    
		    String action = req.getParameter("action");
		    HttpSession session = req.getSession();
		
		if("getAll_For_Display".equals(action)) {

		    Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*
			 * 商品名稱取值
			 */
			String productName = req.getParameter("productName");
			List<CategoryVO> categoryVOall;
			

			/*
			 * 搜尋 商品名稱 為空 全部 不為空 有條件
			 */
			if (productName.trim().length() == 0) {
				categoryVOall = categorySvc.getAll();
				session.removeAttribute("categoryOther");
			} else {
				
				categoryVOall = categorySvc.getbyProductName(productName, true) ;
				List<CategoryVO> categoryOther = categorySvc.getbyProductName(productName, false) ;
				session.setAttribute("categoryOther", categoryOther);
			}


			
			

			/*
			 * 轉去 listAllProduct 頁面
			 */
			session.removeAttribute("categoryVOall_forsort");
			session.setAttribute("categoryVOall", categoryVOall);
			
			String url = "/front-end/product_detail/productList.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
		
		if("category".equals(action)) {

		    Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*
			 * 商品名稱取值
			 */
			Integer productMainID = Integer.valueOf(req.getParameter("productMainID"));
			
			
			List<CategoryVO> categoryVOall = categorySvc.getbyProductMainID(productMainID, true);
			List<CategoryVO> categoryOther = categorySvc.getbyProductMainID(productMainID, false);
			

		


			/*
			 * 轉去 listAllProduct 頁面
			 */
			session.removeAttribute("categoryVOall_forsort");
			
			session.setAttribute("categoryVOall", categoryVOall);
			session.setAttribute("categoryOther", categoryOther);
			String url = "/front-end/product_detail/productList.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
		if("getOne_For_Display".equals(action)) {
			
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			
			Integer productID = Integer.valueOf(req.getParameter("productID"));
			Integer productMainID = Integer.valueOf(req.getParameter("productMainID"));
			Integer storeID = Integer.valueOf(req.getParameter("storeID"));

			CategoryVO categoryVO = categorySvc.getbyProductID(productID);
			List<CategoryVO> categoryMainID = categorySvc.getbyProductMainID(productMainID,  true);
			List<CategoryVO> categoryStoreID  = categorySvc.getbyStoreID(storeID);
			
			
			List<OrderlistVO> list = orderlistSvc.findByProductID(productID, false); //查詢有評價的訂單明細
			int listAll = orderlistSvc.findquantityByProductID(productID); //查詢所有的訂單明細
			
			Collections.reverse(list);
			/*
			 * 導向 listOneProduct頁面
			 */
			req.setAttribute("categoryVO", categoryVO);
			req.setAttribute("categoryMainID", categoryMainID);
			req.setAttribute("categoryStoreID", categoryStoreID);
			
			session.setAttribute("list", list);
			session.setAttribute("listAll", listAll);

			String url = "/front-end/product_detail/product_detail.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
	}


}
