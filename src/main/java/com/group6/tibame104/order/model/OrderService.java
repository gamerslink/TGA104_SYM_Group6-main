package com.group6.tibame104.order.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group6.tibame104.orderlist.model.OrderlistVO;

@Service
public class OrderService {
	
	@Autowired
	private OrderDAO_interface dao;


	public int addOrder(OrderVO orderVO, List<OrderlistVO> buylist) {
		
		return dao.insert(orderVO, buylist);
		
	}


	public OrderVO getOrder(Integer orderID) {
	
		return dao.getbyOrderID(orderID);
	}
	public List<OrderVO> getAllOrderByComposite(Map<String, String> map ) {
		

		return  dao.getAllByComposite( map );
	}
	
	public void updateOrder(Integer orderID, Integer orderStatus) {
		
		dao.updateOrder(orderID, orderStatus);
	}

}
