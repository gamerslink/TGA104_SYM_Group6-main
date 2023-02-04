package com.group6.tibame104.product.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.group6.tibame104.product.model.ProductVO;
import com.group6.tibame104.product.service.ProductService;
import com.group6.tibame104.product.service.ProductService_interface;
import com.group6.tibame104.store.model.StoreVO;

/*JSP 已被ProductController取代*/
@WebServlet("/product/productServletOld")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String saveDirectory = "front-end/images";

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

		PrintWriter out = res.getWriter();
		String action = req.getParameter("action");

		/*
		 * 商品新增
		 */
		if ("insert".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/* 1. 請求參數的格式整理 */
			HttpSession session = req.getSession();
			StoreVO attribute = (StoreVO)session.getAttribute("storeVO2");
			Integer storeID = attribute.getStoreID();
			
			String productName = req.getParameter("productName");
			String productNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (productName == null || productName.trim().length() == 0) {
				errorMsgs.add("產品名稱: 請勿空白");
			} else if (!productName.trim().matches(productNameReg)) {
				errorMsgs.add("產品名稱: 只能是中 英字母 數字 _ , 且長度介於2-10之間");
			}

			Integer productSec = null;
			try {
				productSec = Integer.valueOf(req.getParameter("productSec").trim());
			} catch (NumberFormatException e) {
				productSec = 0;
				errorMsgs.add("商品次分類不正確");
			}

			Integer productStock = null;
			try {
				productStock = Integer.valueOf(req.getParameter("productStock").trim());
			} catch (NumberFormatException e) {
				productStock = 0;
				errorMsgs.add("庫存請填數字");
			}

			Integer productPrice = null;
			try {
				productPrice = Integer.valueOf(req.getParameter("productPrice").trim());
			} catch (NumberFormatException e) {
				productPrice = 0;
				errorMsgs.add("商品價格請填數字");
			}

			String productDesc = req.getParameter("productDesc");

			if (productDesc == null || productDesc.trim().length() == 0) {
				errorMsgs.add("產品描述: 請勿空白");
			}

			String source = req.getParameter("source");

			if (source == null || source.trim().length() == 0) {
				errorMsgs.add("產地: 請勿空白");
			}

			Integer productStatusInt = null;
			try {
				productStatusInt = Integer.valueOf(req.getParameter("productStatus").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("商品狀態請填寫正確");
			}

			Boolean productStatus = null;

			if (new Integer(1).equals(productStatusInt)) {
				productStatus = true;
			} else {
				productStatus = false;
			}

			/* 圖片1 */
			/* getServletContext().getRealPath("front-end/images") */
			String realPath = getServletContext().getRealPath(saveDirectory);
//			System.out.println("realPath=" + realPath);
			File fsaveDirectory = new File(realPath);
			if (!fsaveDirectory.exists())
				fsaveDirectory.mkdirs();

			Collection<Part> parts = req.getParts();

			List<String> pList = new ArrayList<String>();
			List<byte[]> bList = new ArrayList<byte[]>();
			for (Part part : parts) {
				String filename = part.getSubmittedFileName();
				if (filename != null && filename.length() != 0 && part.getContentType() != null) {
					InputStream inputStream = part.getInputStream();
					pList.add(part.getName());
					bList.add(inputStream.readAllBytes());
				}
			}

			/* 圖片2 */
			ProductVO productVO = new ProductVO();
			productVO.setStoreID(storeID);
			productVO.setProductSecID(productSec);
			productVO.setProductName(productName);
			productVO.setProductStock(productStock);
			productVO.setProductPrice(productPrice);
			productVO.setProductDesc(productDesc);
			productVO.setSource(source);
			if (pList.contains("upfile1")) {
				productVO.setProductImg(bList.get(pList.indexOf("upfile1")));
			}
			if (pList.contains("upfile2")) {
				productVO.setProductImg2(bList.get(pList.indexOf("upfile2")));
			}
			if (pList.contains("upfile3")) {
				productVO.setProductImg3(bList.get(pList.indexOf("upfile3")));
			}
			productVO.setProductStatus(productStatus);
			productVO.setCommentTotal(0);
			productVO.setCommentAvgStar(0.0);

			// Send the use back to the form, if there were errors
			/*
			 * 如果報錯 轉去 addProduct 頁面
			 */
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/store/Error.jsp");
				try {
					failureView.forward(req, res);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return;
			}

			/***************************
			 * 2.新增資料
			 ***************************************/
			ProductService_interface productService = new ProductService();
			productService.insert(productVO);
			productVO.setProductID(productService.findMaxID());
			/*
			 * 導向 listOneProduct頁面
			 */
			req.setAttribute("productVO", productVO);
			String url = "/front-end/store/myStore.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		/*
		 * 商品修改
		 */
		if ("update".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/* 1. 請求參數的格式整理 */
			Integer productID = null;
			try {
				productID = Integer.valueOf(req.getParameter("productID").trim());
			} catch (NumberFormatException e) {
				productID = 0;
				errorMsgs.add("productID不正確");
			}

			String productName = req.getParameter("productName");
			String productNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (productName == null || productName.trim().length() == 0) {
				errorMsgs.add("產品名稱: 請勿空白");
			} else if (!productName.trim().matches(productNameReg)) {
				errorMsgs.add("產品名稱: 只能是中 英字母 數字 _ , 且長度介於2-10之間");
			}

			Integer productSec = null;
			try {
				productSec = Integer.valueOf(req.getParameter("productSec").trim());
			} catch (NumberFormatException e) {
				productSec = 0;
				errorMsgs.add("商品次分類不正確");
			}

			Integer productStock = null;
			try {
				productStock = Integer.valueOf(req.getParameter("productStock").trim());
			} catch (NumberFormatException e) {
				productStock = 0;
				errorMsgs.add("庫存請填數字");
			}

			Integer productPrice = null;
			try {
				productPrice = Integer.valueOf(req.getParameter("productPrice").trim());
			} catch (NumberFormatException e) {
				productPrice = 0;
				errorMsgs.add("商品價格請填數字");
			}

			String productDesc = req.getParameter("productDesc");

			if (productDesc == null || productDesc.trim().length() == 0) {
				errorMsgs.add("產品描述: 請勿空白");
			}

			String source = req.getParameter("source");

			if (source == null || source.trim().length() == 0) {
				errorMsgs.add("產地: 請勿空白");
			}

			/* 圖片1 */
			/* getServletContext().getRealPath("front-end/images") */
			String realPath = getServletContext().getRealPath(saveDirectory);
//			System.out.println("realPath=" + realPath);
			File fsaveDirectory = new File(realPath);
			if (!fsaveDirectory.exists())
				fsaveDirectory.mkdirs();

			Collection<Part> parts = req.getParts();

			List<String> pList = new ArrayList<String>();
			List<byte[]> bList = new ArrayList<byte[]>();
			for (Part part : parts) {
				String filename = part.getSubmittedFileName();
				if (filename != null && filename.length() != 0 && part.getContentType() != null) {
					InputStream inputStream = part.getInputStream();
					pList.add(part.getName());
					bList.add(inputStream.readAllBytes());
				}
			}

			/* 圖片2 */
			ProductVO productVO = new ProductVO();
			productVO.setProductID(productID);
			productVO.setProductSecID(productSec);
			productVO.setProductName(productName);
			productVO.setProductStock(productStock);
			productVO.setProductPrice(productPrice);
			productVO.setProductDesc(productDesc);
			productVO.setSource(source);
			if (pList.contains("upfile1")) {
				productVO.setProductImg(bList.get(pList.indexOf("upfile1")));
			}
			if (pList.contains("upfile2")) {
				productVO.setProductImg2(bList.get(pList.indexOf("upfile2")));
			}
			if (pList.contains("upfile3")) {
				productVO.setProductImg3(bList.get(pList.indexOf("upfile3")));
			}
			productVO.setCommentTotal(0);
			productVO.setCommentAvgStar(0.0);

			// Send the use back to the form, if there were errors
			/*
			 * 如果報錯 轉去 addProduct 頁面
			 */
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/store/Error.jsp");
				try {
					failureView.forward(req, res);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return;
			}

			/***************************
			 * 2.修改資料
			 ***************************************/
			new ProductService().update(productVO);

			/*
			 * 導向 myStore頁面
			 */
			req.setAttribute("productVO", productVO);
			String url = "/front-end/store/myStore.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);

		}
		/*
		 * 單一查詢
		 */
		if ("getOne_For_Display".equals(action)) {

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			String str = req.getParameter("productID");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.put("productID", "請輸入正常的數字");
			}
 
			/*
			 * 如果報錯 轉去 addProduct 頁面
			 */
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/product/addProduct.jsp");
				try {
					failureView.forward(req, res);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return;
			}

			Integer productID = null;
			try {
				productID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.put("productID", "請輸入正常的數字");
			}
			/*
			 * 如果報錯 轉去 addProduct 頁面
			 */
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/product/addProduct.jsp");
				try {
					failureView.forward(req, res);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return;
			}
			/*
			 * 取得資料
			 * 
			 */
			ProductVO productVO = new ProductService().findByPrimaryKey(productID);

			/*
			 * 導向 listOneProduct頁面
			 */
			req.setAttribute("productVO", productVO);
			String url = "/front-end/product_detail/product_detail.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		/* 取得所有商品 */
		if ("getAll_For_Display".equals(action)) {

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*
			 * 商品名稱取值
			 */
			String productName = req.getParameter("productName");

			List<ProductVO> productVOall;

			/*
			 * 搜尋 商品名稱 為空 全部 不為空 有條件
			 */
			if (productName.trim().length() == 0) {
				productVOall = new ProductService().getAll();
			} else {
				productVOall = new ProductService().getAll(productName);
			}

			/*
			 * 如果報錯 轉去 addProduct 頁面
			 */
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/product/addProduct.jsp");
				try {
					failureView.forward(req, res);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return;
			}

			/*
			 * 轉去 listAllProduct 頁面
			 */
			req.setAttribute("productVOall", productVOall);
			String url = "/front-end/product/listAllProduct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		/* 取得有條件所有商品 */
		if ("getAll_For_More_Display".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			Map<String, String> queryString = new LinkedHashMap<String, String>();

			/* 1. 請求參數的格式整理 */
			Integer storeID = null;
			if (req.getParameter("storeID").trim().length() != 0) {
				try {
					storeID = Integer.valueOf(req.getParameter("storeID").trim());
				} catch (NumberFormatException e) {
					storeID = 0;
					errorMsgs.add("商店ID不正確");
				}
				if (storeID != 0) {
					queryString.put("storeID", "" + storeID);
				}

			}

			Integer productID = null;
			if (req.getParameter("productID").trim().length() != 0) {
				try {
					productID = Integer.valueOf(req.getParameter("productID").trim());
				} catch (NumberFormatException e) {
					productID = 0;
					errorMsgs.add("商品ID不正確");
				}
				if (productID != 0) {
					queryString.put("productID", "" + productID);
				}
			}

			Integer productID2 = null;
			if (req.getParameter("productID2").trim().length() != 0) {
				try {
					productID2 = Integer.valueOf(req.getParameter("productID2").trim());
				} catch (NumberFormatException e) {
					productID2 = 0;
					errorMsgs.add("商品ID不正確");
				}
				if (productID2 != 0) {
					queryString.put("productID2", "" + productID2);
				}
			}

			String productName = req.getParameter("productName");
			String productNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (productName != null && productName.trim().length() != 0) {
				if (!productName.trim().matches(productNameReg)) {
					errorMsgs.add("產品名稱: 只能是中 英字母 數字 _ , 且長度介於2-10之間");
				} else {
					queryString.put("productName", "" + productName);
				}
			}

			Integer productSecID = null;

			if (req.getParameter("productSecID").trim().length() != 0
					&& !("selected".equals(req.getParameter("productSecID")))) {
				try {
					productSecID = Integer.valueOf(req.getParameter("productSecID").trim());
				} catch (NumberFormatException e) {
					productSecID = 0;
					errorMsgs.add("商品次分類不正確");
				}
				if (productSecID != 0) {
					queryString.put("productSecID", "" + productSecID);
				}
			}

			Integer productStock = null;
			if (req.getParameter("productStock").trim().length() != 0) {
				try {
					productStock = Integer.valueOf(req.getParameter("productStock").trim());
				} catch (NumberFormatException e) {
					productStock = 0;
					errorMsgs.add("庫存請填數字");
				}
				if (productStock != 0) {
					queryString.put("productStock", "" + productStock);
				}
			}

			Integer productStock2 = null;
			if (req.getParameter("productStock2").trim().length() != 0) {
				try {
					productStock2 = Integer.valueOf(req.getParameter("productStock2").trim());
				} catch (NumberFormatException e) {
					productStock2 = 0;
					errorMsgs.add("庫存請填數字");
				}
				if (productStock2 != 0) {
					queryString.put("productStock2", "" + productStock2);
				}
			}

			Integer productPrice = null;
			if (req.getParameter("productPrice").trim().length() != 0) {
				try {
					productPrice = Integer.valueOf(req.getParameter("productPrice").trim());
				} catch (NumberFormatException e) {
					productPrice = 0;
					errorMsgs.add("商品價格請填數字");
				}
				if (productPrice != 0) {
					queryString.put("productPrice", "" + productPrice);
				}
			}

			Integer productPrice2 = null;
			if (req.getParameter("productPrice2").trim().length() != 0) {
				try {
					productPrice2 = Integer.valueOf(req.getParameter("productPrice2").trim());
				} catch (NumberFormatException e) {
					productPrice2 = 0;
					errorMsgs.add("商品價格請填數字");
				}
				if (productPrice2 != 0) {
					queryString.put("productPrice2", "" + productPrice2);
				}
			}

			Integer productStatusInt = null;
			Boolean productStatus = null;
			if (req.getParameter("productStatus").trim().length() != 0
					&& !("selected".equals(req.getParameter("productStatus")))) {
				try {
					productStatusInt = Integer.valueOf(req.getParameter("productStatus").trim());
				} catch (NumberFormatException e) {
					errorMsgs.add("商品狀態請填寫正確");
				}
				if (new Integer(1).equals(productStatusInt)) {
					productStatus = true;
				} else {
					productStatus = false;
				}
				queryString.put("productStatus", "" + productStatus);
			}

			/*
			 * 商品名稱取值
			 * 
			 * 
			 * List<ProductVO> productVOall;
			 * 
			 * /* 搜尋 商品名稱 為空 全部 不為空 有條件
			 */

			List<ProductVO> productVOall = new ProductService().getAllByCond(queryString);

			/*
			 * 如果報錯 轉去 addProduct 頁面
			 */
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/product/addProduct.jsp");
				try {
					failureView.forward(req, res);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return;
			}

			/*
			 * 轉去 listAllProduct 頁面
			 */
			req.setAttribute("productVOall", productVOall);
			String url = "/front-end/product/listAllProduct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

	}
}
