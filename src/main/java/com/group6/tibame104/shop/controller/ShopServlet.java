package com.group6.tibame104.shop.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.group6.tibame104.creditCard.model.CreditCardService;
import com.group6.tibame104.creditCard.model.CreditCardVO;
import com.group6.tibame104.order.model.OrderService;
import com.group6.tibame104.order.model.OrderVO;
import com.group6.tibame104.orderlist.model.OrderlistVO;
import com.group6.tibame104.orderlist.model.Product;
import com.group6.tibame104.product.model.ProductVO;
import com.group6.tibame104.product.service.ProductService;

//import redis.clients.jedis.Jedis;

//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;

//import redis.clients.jedis.JedisPool;

//@WebServlet("/front-end/shop/ShopServlet")
@Component
@WebServlet("/front-end/shop/ShopServlet")
public class ShopServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Autowired
	OrderService ordsvc;
	@Autowired
	CategoryService categorySvc;
	@Autowired
	CreditCardService creditSvc;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();

		@SuppressWarnings("unchecked")
//		List<Product> buylist = (Vector<Product>) session.getAttribute("check");
		Map<Integer, List<Product>> check = (Map<Integer, List<Product>>)session.getAttribute("check");
		
		String action = req.getParameter("action");
		Integer count_string = (Integer) session.getAttribute("count_num");
		int count_num;
		if(count_string == null)
			count_num = 0;
		else
			count_num = count_string;

		if (!action.equals("CHECKOUT") && !action.equals("CHECK")) {
			
			// 新增書籍至購物車中
			 if (action.equals("ADD")) {

				// 取得後來新增的書籍
				Product product = getProduct(req);
				Integer storeID = product.getStoreID();
				


				if (check==null) {
					
					List<Product> list = new ArrayList<Product>();
					list.add(product);
					
					check = new HashMap<Integer, List<Product>>();
					check.put(storeID, list);
					count_num++;

				} else {
					if(check.get(storeID)==null) {
						List<Product> buylist = new ArrayList<Product>();
						buylist.add(product);
						check.put(storeID, buylist);
						count_num++;
					} else {
						
					List<Product> buylist = check.get(storeID);
					
					if (buylist.contains(product)) {

						Product innerProduct = buylist.get(buylist.indexOf(product));
						innerProduct.setQuantity(innerProduct.getQuantity() + product.getQuantity());

					} else {
						buylist.add(product);
						check.put(storeID, buylist);
						count_num++;
				
					}
				  }
				}

			
			}
	
			session.setAttribute("check", check);
			session.setAttribute("count_num", count_num);
			CategoryVO categoryVO =categorySvc.getbyProductID(Integer.parseInt(req.getParameter("productID")));		
			req.setAttribute("categoryVO", categoryVO);
			
			if(req.getParameter("method").equals("bag")) {
				System.out.println(check.size());
				String url = "/front-end/shop/Cart_new.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(url);
				rd.forward(req, res);
			}
			if(req.getParameter("method").equals("cart")) {

				
				String url = "/front-end/product_detail/product_detail.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(url);
				rd.forward(req, res);
			}
			
		}
		

		// 結帳，計算購物車書籍價錢總數
		if (action.equals("CHECK")) {
			Map<Integer, List<Product>> check_new = new HashMap<Integer, List<Product>>() ;
			
			Set<Integer> set = check.keySet();
			Iterator<Integer> it = set.iterator();
			
			while (it.hasNext()) {
			int total = 0;
			

			Integer storeID = it.next();
			List<Product> buylist = check.get(storeID);
			List<Product> buylist_new = new ArrayList<Product>();
	
				for (int i = 0; i < buylist.size(); i++) {
					String valuelist = req.getParameter("check"+storeID+i);
					if("1".equals(valuelist)) {
						Product product = buylist.get(i);

						String str = req.getParameter("product"+product.getStoreID()+i);
						Integer quantity = Integer.parseInt(str);
						
						product.setQuantity(quantity);
						
						buylist_new.add(product);

				}
		
			 }
				if(!buylist_new.isEmpty())
					check_new.put(storeID, buylist_new);
				
	

			}
			List<CreditCardVO> credit = creditSvc.getAll(Integer.valueOf(req.getParameter("memberID")));
			
//			session.setAttribute("total", total);
			session.setAttribute("credit", credit);
			session.setAttribute("check_new", check_new);
			String url = "/front-end/shop/Check.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);

		}
		
		if("CHECKOUT".equals(action)) {
			@SuppressWarnings("unchecked")
			Map<Integer, List<Product>> check_new = (Map<Integer, List<Product>>) session.getAttribute("check_new");
//			List<OrderVO> orderVO_list = new ArrayList();
			Map<OrderVO,List<OrderlistVO>> orderVO_list = new HashMap<OrderVO,List<OrderlistVO>>();
			
			Set<Integer> set = check_new.keySet();
			Iterator<Integer> it = set.iterator();
			
			while (it.hasNext()) {
			int total = 0;
			
			List<OrderlistVO> orderlist = new ArrayList<OrderlistVO>();
			Integer storeID = it.next();
			List<Product> buylist = check_new.get(storeID);
			

			
			
			for (int i = 0; i < buylist.size() ; i++) {
					Product product = buylist.get(i);

				
					OrderlistVO list = new OrderlistVO(); //產生訂單明細物件

					list.setProductID(product.getProductID());
					list.setProductName(product.getName());
					list.setPrice(product.getPrice());
					list.setQuantity(product.getQuantity());
					list.setSubTotal(product.getPrice()*product.getQuantity());
					list.setUserAccount(req.getParameter("userAccount"));
					
					total += product.getPrice()*product.getQuantity();

					orderlist.add(list);
				}

			OrderVO ordervo = new OrderVO(); //產生訂單物件
			
			
			
			String str = req.getParameter("storeID"+storeID.toString());

			Integer useShoppingGold = Integer.valueOf(req.getParameter("useShoppingGold"));
			Double count = Double.valueOf(req.getParameter("couponID"));
			

	      

			ordervo.setMemberID(Integer.parseInt( req.getParameter("memberID") ));
			ordervo.setStoreID(Integer.parseInt(str));
			ordervo.setStoreName(req.getParameter("storeName"+str));
			ordervo.setCreditcardNumber("10");
			ordervo.setReceiver(req.getParameter("receiver"+str));
			ordervo.setPayType(req.getParameter("type"));
			if("credit".equals(req.getParameter("type"))) {
				ordervo.setOrderStatus(1);
			} else {
				ordervo.setOrderStatus(0);
			}
			ordervo.setPhone(req.getParameter("phone"+str));
			ordervo.setAddress(req.getParameter("address"+str));
			
			ordervo.setOriginalTotal(total);
			ordervo.setCouponID(1);
			ordervo.setUseCouponGold((int) (total * (1 - count)));
			ordervo.setUseShoppingGold(useShoppingGold);
			ordervo.setFinalTotal((int) (total * count - useShoppingGold + 60));
			
			int orderID = ordsvc.addOrder(ordervo, orderlist);
			OrderVO order =ordsvc.getOrder(orderID);
		
			
			orderVO_list.put(order, orderlist);
			
			
			}
			
			session.setAttribute("orderVO_list", orderVO_list);
			
			String url;
			if(req.getParameter("type").equals("atm")) {
				url = "/front-end/shop/ATM.jsp";
				
			} else if(req.getParameter("type").equals("credit")) {
			
			    url = "/front-end/shop/Confirm.jsp";
			
			} else {
				url = "/front-end/shop/select_Order?status=0";
			}
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
			
			session.removeAttribute("check");
			session.removeAttribute("count_num");

		}
	}

	private Product getProduct(HttpServletRequest req) {
//		req.getAttribute(name);
//		String memberID = req.getParameter("memberID");
		String quantity = req.getParameter("quantity");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String productID = req.getParameter("productID");
		String storeID = req.getParameter("storeID");
		String storeName = req.getParameter("storeName");
//		String storeID = req.getParameter("storeID");

		Product product = new Product();

		product.setProductID(Integer.parseInt(productID));
		product.setName(name);
		product.setPrice(new Integer(price));
		product.setQuantity((new Integer(quantity)).intValue());
		product.setStoreID(Integer.parseInt(storeID));
		product.setStoreName(storeName);
		return product;
	}
	

//	static void addCart(Long userID, Long productID, int num) {
//		Jedis jedis = new Jedis("localhost",6379);
//		String product = jedis.hget("cart" + userID, String.valueOf(productID));
//		if(product!=null || !"".equals(product)) {
//			jedis.hincrBy("cart:"+userID, String.valueOf(productID), num);
//		} else {
//			jedis.hset("cart:"+userID, String.valueOf(productID), String.valueOf(num));
//		}
//		
//		jedis.close();
//	}

}
