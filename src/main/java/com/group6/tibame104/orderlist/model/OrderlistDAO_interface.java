package com.group6.tibame104.orderlist.model;

import java.util.List;


public interface OrderlistDAO_interface {
	public void insert(OrderlistVO orderlistVO);
	
    public void update(Integer orderDetailID, Integer buyerReview, String buyerComment, byte[] pic);

    public List<OrderlistVO> findByOrderID(Integer orderID);
    
    public OrderlistVO findByOrderlistID(Integer orderlistID);
    
    public List<OrderlistVO> findByProductID(Integer productID, Boolean all);

	public int findquantityByProductID(Integer productID);

}
