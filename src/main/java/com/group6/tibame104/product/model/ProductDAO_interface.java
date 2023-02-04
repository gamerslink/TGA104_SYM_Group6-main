package com.group6.tibame104.product.model;

import java.util.*;

public interface ProductDAO_interface {
	/*
	 * 前台
	 * 1.插入商品
	 * 2.修改商品
	 * 3.刪除商品(應該是改狀態?)
	 * 4.List 1
	 * 5.List All
	 * 6.List + 條件(前端?)
	 * 
	 * 
	 * 後台
	 * 
	 * 1.插入商品
	 * 2.修改商品
	 * 3.刪除商品(應該是改狀態?)
	 * 4.List 1
	 * 5.List All
	 * 6.List + 條件	 
	 * 
	 * */
	public void insert(ProductVO productVO);

	public void update(ProductVO productVO);

	public ProductVO findByPrimaryKey(Integer productID);

	public List<ProductVO> getAll();
	
	public List<ProductVO> getAll(String productName);
	
	public Integer findMaxID();
	
	public List<ProductVO> getAllByCond(String queryString);
	
	public void putOn(Integer productID);

	public void putOff(Integer productID);
}
