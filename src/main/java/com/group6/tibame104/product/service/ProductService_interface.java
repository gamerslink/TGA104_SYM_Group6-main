package com.group6.tibame104.product.service;

import java.util.List;
import java.util.Map;

import com.group6.tibame104.product.model.ProductVO;

public interface ProductService_interface {

	/* 插入product */
	public void insert(ProductVO productVO);

	/* 修改product */
	public void update(ProductVO productVO);

	/* 根據productID找到product */
	public ProductVO findByPrimaryKey(Integer productID);

	/* 取得所有product */
	public List<ProductVO> getAll();

	/* 根據productName取得所有product */
	public List<ProductVO> getAll(String productName);

	/* 找到ID最大值 */
	public Integer findMaxID();

	/* 多條件找到所有product */
	public List<ProductVO> getAllByCond(Map<String, String> queryString);
	
	/*多條件找到所有某賣家的product*/
	public List<ProductVO> getAllByCondFront(Map<String, String> queryString);
	
	/*上架*/
	public String putOn(Integer productID);
	
	/*下架*/
	public String putOff(Integer productID);
}
