package com.group6.tibame104.sort.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

@Component
@WebServlet("/sortbyPrice")
public class SortServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Autowired
	CategoryService categorySvc;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		@SuppressWarnings("unchecked")
		List<CategoryVO> list = (List<CategoryVO>) session.getAttribute("categoryVOall");

		if ("sort_price".equals(action) || "sort_price_reverse".equals(action) ) {
			
			if(session.getAttribute("categoryVOall_forsort") != null) {
				list = (List<CategoryVO>) session.getAttribute("categoryVOall_forsort");
			}

			Collections.sort(list, new Comparator<CategoryVO>() {

				@Override
				public int compare(CategoryVO o1, CategoryVO o2) {

					return o1.getProductPrice().compareTo(o2.getProductPrice());
				}
			});
			
			if("sort_price_reverse".equals(action))
				Collections.reverse(list);

			req.setAttribute("categoryVOall", list);
			
			
			String url = "/front-end/product_detail/productList.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		else if ("sort_0_1000".equals(action) || "sort_1000_5000".equals(action) ||
				"sort_5000_10000".equals(action) || "sort_10000".equals(action) ||
				"sort_0".equals(action)) {
			
			String[] tokens = action.split("_");
			int min = Integer.valueOf(tokens[1]) ;	
			List<CategoryVO> newlist = new ArrayList<CategoryVO>();
			
			if(tokens.length == 3) {
				
				int max = Integer.valueOf(tokens[2]) ;	
			
				for(CategoryVO categoryVO : list) {
					if( categoryVO.getProductPrice()>= min && categoryVO.getProductPrice() < max )
						newlist.add(categoryVO);
				}
			
			} else if(tokens.length == 2) {
				
				for(CategoryVO categoryVO : list) {
					if( categoryVO.getProductPrice()>= min)
						newlist.add(categoryVO);
				}
			}
			
			req.setAttribute("categoryVOall", newlist);
			session.setAttribute("categoryVOall_forsort", newlist);
			String url = "/front-end/product_detail/productList.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);		
		}
		
		

	}

}
