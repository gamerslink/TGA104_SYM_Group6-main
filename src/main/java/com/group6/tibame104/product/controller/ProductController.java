package com.group6.tibame104.product.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group6.tibame104.group.model.GroupService;
import com.group6.tibame104.group.model.GroupVO;
import com.group6.tibame104.product.model.ProductVO;
import com.group6.tibame104.product.service.ProductService;
import com.group6.tibame104.product.service.ProductService_interface;
import com.group6.tibame104.store.model.StoreVO;

@Controller
@RequestMapping("/product/productServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class ProductController {
	@Autowired
	private ProductService productSvc;

	@PostMapping("/getOne_For_Display")
	public String getOneForDisplay(Model model, @RequestParam("productID") String str) {
		List<String> errorMsgs = new LinkedList<String>();
		model.addAttribute("errorMsgs", errorMsgs);
		if (str == null || (str.trim()).length() == 0) {
			errorMsgs.add("請輸入正常的數字");
		}
		if (!errorMsgs.isEmpty()) {
			return "front-end/product/addProduct.jsp";
		}

		Integer productID = null;
		try {
			productID = Integer.valueOf(str);
		} catch (Exception e) {
			errorMsgs.add("請輸入正常的數字");
		}
		if (!errorMsgs.isEmpty()) {
			return "front-end/product/addProduct";
		}

		ProductVO productVO = productSvc.findByPrimaryKey(productID);
		if (productVO == null) {
			errorMsgs.add("查無資料");
		}
		if (!errorMsgs.isEmpty()) {
			return "front-end/product/addProduct";
		}

		model.addAttribute("productVO", productVO);
		return "front-end/product_detail/product_detail";

	}

	@PostMapping("/insert")
	public String insert(Model model, HttpServletRequest request, @RequestParam("productName") String productName,
			@RequestParam("productSec") String productSecStr, @RequestParam("productStock") String productStockStr,
			@RequestParam("productPrice") String productPriceStr, @RequestParam("productDesc") String productDesc,
			@RequestParam("source") String source, @RequestParam("productStatus") String productStatusStr) throws IOException, ServletException {

		List<String> errorMsgs = new LinkedList<String>();
		model.addAttribute("errorMsgs", errorMsgs);

		HttpSession session = request.getSession();
		StoreVO attribute = (StoreVO) session.getAttribute("storeVO2");
		Integer storeID = attribute.getStoreID();

		/* 1. 請求參數的格式整理 */

		String productNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
		if (productName == null || productName.trim().length() == 0) {
			errorMsgs.add("產品名稱: 請勿空白");
		} else if (!productName.trim().matches(productNameReg)) {
			errorMsgs.add("產品名稱: 只能是中 英字母 數字 _ , 且長度介於2-10之間");
		}

		Integer productSec = null;
		try {
			productSec = Integer.valueOf(productSecStr.trim());
		} catch (NumberFormatException e) {
			productSec = 0;
			errorMsgs.add("商品次分類不正確");
		}

		Integer productStock = null;
		try {
			productStock = Integer.valueOf(productStockStr.trim());
		} catch (NumberFormatException e) {
			productStock = 0;
			errorMsgs.add("庫存請填數字");
		}

		Integer productPrice = null;
		try {
			productPrice = Integer.valueOf(productPriceStr.trim());
		} catch (NumberFormatException e) {
			productPrice = 0;
			errorMsgs.add("商品價格請填數字");
		}

		if (productDesc == null || productDesc.trim().length() == 0) {
			errorMsgs.add("產品描述: 請勿空白");
		}

		if (source == null || source.trim().length() == 0) {
			errorMsgs.add("產地: 請勿空白");
		}

		Integer productStatusInt = null;
		try {
			productStatusInt = Integer.valueOf(productStatusStr.trim());
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
		Collection<Part> parts = request.getParts();

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
			model.addAttribute("productVO", productVO); // 含有輸入格式錯誤的empVO物件,也存入req
			return "front-end/store/Error";
		}

		/***************************
		 * 2.新增資料
		 ***************************************/
		productSvc.insert(productVO);
		productVO.setProductID(productSvc.findMaxID());
		/*
		 * 導向 listOneProduct頁面
		 */
		model.addAttribute("productVO", productVO);
		return "front-end/store/myStore";

	}

	@PostMapping("/update")
	public String update(Model model, HttpServletRequest request, @RequestParam("productID2") String productIDStr,
			@RequestParam("productName") String productName, @RequestParam("productSec") String productSecStr,
			@RequestParam("productStock") String productStockStr, @RequestParam("productPrice") String productPriceStr,
			@RequestParam("productDesc") String productDesc, @RequestParam("source") String source) throws IOException, ServletException {

		List<String> errorMsgs = new LinkedList<String>();
		model.addAttribute("errorMsgs", errorMsgs);

		/* 1. 請求參數的格式整理 */
		Integer productID = null;
		try {
			productID = Integer.valueOf(productIDStr.trim());
		} catch (NumberFormatException e) {
			productID = 0;
			errorMsgs.add("productID不正確");
		}

		String productNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
		if (productName == null || productName.trim().length() == 0) {
			errorMsgs.add("產品名稱: 請勿空白");
		} else if (!productName.trim().matches(productNameReg)) {
			errorMsgs.add("產品名稱: 只能是中 英字母 數字 _ , 且長度介於2-10之間");
		}

		Integer productSec = null;
		try {
			productSec = Integer.valueOf(productSecStr.trim());
		} catch (NumberFormatException e) {
			productSec = 0;
			errorMsgs.add("商品次分類不正確");
		}

		Integer productStock = null;
		try {
			productStock = Integer.valueOf(productStockStr.trim());
		} catch (NumberFormatException e) {
			productStock = 0;
			errorMsgs.add("庫存請填數字");
		}

		Integer productPrice = null;
		try {
			productPrice = Integer.valueOf(productPriceStr.trim());
		} catch (NumberFormatException e) {
			productPrice = 0;
			errorMsgs.add("商品價格請填數字");
		}

		if (productDesc == null || productDesc.trim().length() == 0) {
			errorMsgs.add("產品描述: 請勿空白");
		}

		if (source == null || source.trim().length() == 0) {
			errorMsgs.add("產地: 請勿空白");
		}

		Collection<Part> parts = request.getParts();

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
		
		ProductVO findByPrimaryKey = productSvc.findByPrimaryKey(productID);

		if (pList.contains("upfile1")) {
			productVO.setProductImg(bList.get(pList.indexOf("upfile1")));
		}else {
			productVO.setProductImg(findByPrimaryKey.getProductImg());
		}
		if (pList.contains("upfile2")) {
			productVO.setProductImg2(bList.get(pList.indexOf("upfile2")));
		}else {
			productVO.setProductImg(findByPrimaryKey.getProductImg());
		}
		if (pList.contains("upfile3")) {
			productVO.setProductImg3(bList.get(pList.indexOf("upfile3")));
		}else {
			productVO.setProductImg(findByPrimaryKey.getProductImg());
		}
		productVO.setCommentTotal(0);
		productVO.setCommentAvgStar(0.0);

		// Send the use back to the form, if there were errors
		/*
		 * 如果報錯 轉去 Error 頁面
		 */
		if (!errorMsgs.isEmpty()) {
			return "front-end/store/Error";
		}

		/***************************
		 * 2.修改資料
		 ***************************************/
		productSvc.update(productVO);

		/*
		 * 導向 myStore頁面
		 */
		model.addAttribute("productVO", productVO);
		return "front-end/store/myStore";

	}

	@PostMapping("/getAll_For_Display")
	public String getAllForDisplay(Model model, HttpServletRequest request,
			@RequestParam("productName") String productName) {

		Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
		model.addAttribute("errorMsgs", errorMsgs);

		/*
		 * 商品名稱取值
		 */

		List<ProductVO> productVOall;

		/*
		 * 搜尋 商品名稱 為空 全部 不為空 有條件
		 */
		if (productName.trim().length() == 0) {
			productVOall = productSvc.getAll();
		} else {
			productVOall = productSvc.getAll(productName);
		}

		/*
		 * 如果報錯 轉去 addProduct 頁面
		 */

		if (!errorMsgs.isEmpty()) {
			return "front-end/product/addProduct.jsp";
		}

		/*
		 * 轉去 listAllProduct 頁面
		 */
		model.addAttribute("productVOall", productVOall);
		return "front-end/product/listAllProduct";
	}

	@PostMapping("/getAll_For_More_Display")
	public String getAllForMoreDisplay(Model model, HttpServletRequest request,
			@RequestParam("storeID") String storeIDStr, @RequestParam("productID") String productIDStr,
			@RequestParam("productID2") String productIDStr2, @RequestParam("productName") String productName,
			@RequestParam("productSecID") String productSecIDStr, @RequestParam("productStock") String productStockStr,
			@RequestParam("productStock2") String productStockStr2,
			@RequestParam("productPrice") String productPriceStr,
			@RequestParam("productPrice2") String productPriceStr2,
			@RequestParam("productStatus") String productStatusStr) {

		List<String> errorMsgs = new LinkedList<String>();
		model.addAttribute("errorMsgs", errorMsgs);
		Map<String, String> queryString = new LinkedHashMap<String, String>();

		/* 1. 請求參數的格式整理 */
		Integer storeID = null;
		if (storeIDStr.trim().length() != 0) {
			try {
				storeID = Integer.valueOf(storeIDStr.trim());
			} catch (NumberFormatException e) {
				storeID = 0;
				errorMsgs.add("商店ID不正確");
			}
			if (storeID != 0) {
				queryString.put("storeID", "" + storeID);
			}

		}

		Integer productID = null;
		if (productIDStr.trim().length() != 0) {
			try {
				productID = Integer.valueOf(productIDStr.trim());
			} catch (NumberFormatException e) {
				productID = 0;
				errorMsgs.add("商品ID不正確");
			}
			if (productID != 0) {
				queryString.put("productID", "" + productID);
			}
		}

		Integer productID2 = null;
		if (productIDStr2.trim().length() != 0) {
			try {
				productID2 = Integer.valueOf(productIDStr2.trim());
			} catch (NumberFormatException e) {
				productID2 = 0;
				errorMsgs.add("商品ID不正確");
			}
			if (productID2 != 0) {
				queryString.put("productID2", "" + productID2);
			}
		}

		String productNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
		if (productName != null && productName.trim().length() != 0) {
			if (!productName.trim().matches(productNameReg)) {
				errorMsgs.add("產品名稱: 只能是中 英字母 數字 _ , 且長度介於2-10之間");
			} else {
				queryString.put("productName", "" + productName);
			}
		}

		Integer productSecID = null;

		if (productSecIDStr.trim().length() != 0 && !("selected".equals(productSecIDStr))) {
			try {
				productSecID = Integer.valueOf(productSecIDStr.trim());
			} catch (NumberFormatException e) {
				productSecID = 0;
				errorMsgs.add("商品次分類不正確");
			}
			if (productSecID != 0) {
				queryString.put("productSecID", "" + productSecID);
			}
		}

		Integer productStock = null;
		if (productStockStr.length() != 0) {
			try {
				productStock = Integer.valueOf(productStockStr.trim());
			} catch (NumberFormatException e) {
				productStock = 0;
				errorMsgs.add("庫存請填數字");
			}
			if (productStock != 0) {
				queryString.put("productStock", "" + productStock);
			}
		}

		Integer productStock2 = null;
		if (productStockStr2.trim().length() != 0) {
			try {
				productStock2 = Integer.valueOf(productStockStr2.trim());
			} catch (NumberFormatException e) {
				productStock2 = 0;
				errorMsgs.add("庫存請填數字");
			}
			if (productStock2 != 0) {
				queryString.put("productStock2", "" + productStock2);
			}
		}

		Integer productPrice = null;
		if (productPriceStr.trim().length() != 0) {
			try {
				productPrice = Integer.valueOf(productPriceStr.trim());
			} catch (NumberFormatException e) {
				productPrice = 0;
				errorMsgs.add("商品價格請填數字");
			}
			if (productPrice != 0) {
				queryString.put("productPrice", "" + productPrice);
			}
		}

		Integer productPrice2 = null;
		if (productPriceStr2.trim().length() != 0) {
			try {
				productPrice2 = Integer.valueOf(productPriceStr2.trim());
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
		if (productStatusStr.trim().length() != 0 && !("selected".equals(productStatusStr))) {
			try {
				productStatusInt = Integer.valueOf(productStatusStr.trim());
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

		List<ProductVO> productVOall = productSvc.getAllByCond(queryString);

		/*
		 * 如果報錯 轉去 addProduct 頁面
		 */

		if (!errorMsgs.isEmpty()) {
			return "front-end/product/addProduct.jsp";
		}

		/*
		 * 轉去 listAllProduct 頁面
		 */
		model.addAttribute("productVOall", productVOall);
		return "front-end/product/listAllProduct";
	}

}
