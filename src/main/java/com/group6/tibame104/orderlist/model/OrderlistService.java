package com.group6.tibame104.orderlist.model;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OrderlistService {
	@Autowired
	private OrderlistDAO_interface dao;


	public void addOrderlist(OrderlistVO orderlistVO) {

		dao.insert(orderlistVO);

	}

	public List<OrderlistVO> searchOrderlist(Integer orderID) {
		
		return dao.findByOrderID(orderID);

	}
	
	public void updateOrderlist(Integer orderDetailID, Integer buyerReview, String buyerComment, byte[] pic) {

		dao.update(orderDetailID, buyerReview, buyerComment, pic);

	}
	
	public OrderlistVO findByOrderlistID(Integer OrderlistID) {
		
		return dao.findByOrderlistID(OrderlistID);
		
	}
	public List<OrderlistVO> findByProductID(Integer productID, Boolean all) {
		
		
		return dao.findByProductID(productID, all);
		
	}

	public int findquantityByProductID(Integer productID) {

		return dao.findquantityByProductID(productID);

	}
}
