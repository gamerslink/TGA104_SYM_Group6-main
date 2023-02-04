package com.group6.tibame104.order.model;

import java.util.List;
import java.util.Map;

import com.group6.tibame104.orderlist.model.OrderlistVO;

//import com.emp.model.EmpVO;

public interface OrderDAO_interface {
	
	 public int insert(OrderVO orderVO, List<OrderlistVO> buylist);

   
     public OrderVO getbyOrderID(Integer orderID);
     
     public List<OrderVO> getAll();
     
     public List<OrderVO> getAllByComposite(Map<String, String> queryString );

     public void updateOrder(Integer orderID, Integer orderStatus);
     
}
