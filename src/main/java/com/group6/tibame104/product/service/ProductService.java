package com.group6.tibame104.product.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group6.tibame104.product.model.ProductDAO_interface;
import com.group6.tibame104.product.model.ProductJDBCDAO;
import com.group6.tibame104.product.model.ProductVO;

@Service
@Transactional
public class ProductService implements ProductService_interface {
	@Autowired
	private ProductDAO_interface dao;

	@Override
	public void insert(ProductVO productVO) {
		dao.insert(productVO);
	}

	@Override
	public void update(ProductVO productVO) {
		dao.update(productVO);
	}

	@Override
	public ProductVO findByPrimaryKey(Integer productID) {
		return dao.findByPrimaryKey(productID);
	}

	@Override
	public List<ProductVO> getAll() {
		return dao.getAll();
	}

	@Override
	public List<ProductVO> getAll(String productName) {
		return dao.getAll(productName);
	}

	@Override
	public Integer findMaxID() {
		return dao.findMaxID();
	}

	@Override
	public List<ProductVO> getAllByCond(Map<String, String> queryString) {
		StringBuilder sb = new StringBuilder();
		Iterator<Entry<String, String>> it = queryString.entrySet().iterator();
		int i = 0;
		if (it.hasNext()) {
			sb.append(" where ");
		}
		while (it.hasNext()) {
			Entry<String, String> next = it.next();
			if (i > 0) {
				sb.append(" and ");
			}
			if ("storeID".equals(next.getKey())) {
				sb.append(next.getKey() + " = " + next.getValue());
			} else if ("productID".equals(next.getKey())) {
				sb.append(next.getKey() + " >= " + next.getValue());
			} else if ("productID2".equals(next.getKey())) {
				sb.append("productID" + " <= " + next.getValue());
			} else if ("productName".equals(next.getKey())) {
				sb.append("productName" + " like '%" + next.getValue() + "%'");
			} else if ("productSecID".equals(next.getKey())) {
				sb.append("productSecID" + " = " + next.getValue());
			} else if ("productStock".equals(next.getKey())) {
				sb.append("productStock" + " >= " + next.getValue());
			} else if ("productStock2".equals(next.getKey())) {
				sb.append("productStock" + " <= " + next.getValue());
			} else if ("productPrice".equals(next.getKey())) {
				sb.append("productPrice" + " >= " + next.getValue());
			} else if ("productPrice2".equals(next.getKey())) {
				sb.append("productPrice" + " <= " + next.getValue());
			} else if ("productStatus".equals(next.getKey())) {
				sb.append("productStatus" + " = " + next.getValue());
			}
			i++;
		}
		System.out.println(sb);

		return dao.getAllByCond(sb.toString());
	}
	
	@Override
	public List<ProductVO> getAllByCondFront(Map<String, String> queryString) {
		StringBuilder sb = new StringBuilder();
		Iterator<Entry<String, String>> it = queryString.entrySet().iterator();
		int i = 0;
		if (it.hasNext()) {
			sb.append(" where ");
		}
		while (it.hasNext()) {
			Entry<String, String> next = it.next();
			if (i > 0) {
				sb.append(" and ");
			}
			if ("storeID".equals(next.getKey())) {
				sb.append(next.getKey() + " = " + next.getValue());
			} else if ("productID".equals(next.getKey())) {
				sb.append(next.getKey() + " = " + next.getValue());
			} else if ("productSecID".equals(next.getKey())) {
				sb.append("productSecID" + " = " + next.getValue());
			} else if ("productStatus".equals(next.getKey())) {
				sb.append("productStatus" + " = " + next.getValue());
			}
			i++;
		}
		System.out.println(sb);

		return dao.getAllByCond(sb.toString());
	}

	@Override
	public String putOn(Integer productID) {
		dao.putOn(productID);
		return "1";
	}

	@Override
	public String putOff(Integer productID) {
		dao.putOff(productID);
		return "0";
	}

}
