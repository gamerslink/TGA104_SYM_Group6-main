package com.group6.tibame104.orderlist.model;

import java.sql.Timestamp;

public class OrderlistVO {
	private Integer orderDetailID;
	private Integer orderID;
	private Integer productID;
	private String productName;
	private Timestamp orderDate;
	private Integer quantity;
	private Integer price;
	private Integer subTotal;
	private Integer shopReview;
	private String shopComment;
	private Integer buyerReview;
	private String buyerComment;
	private String userAccount;
	private byte[] buyerCommentPic;
	
  
	public byte[] getBuyerCommentPic() {
		return buyerCommentPic;
	}
	public void setBuyerCommentPic(byte[] buyerCommentPic) {
		this.buyerCommentPic = buyerCommentPic;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getOrderDetailID() {
		return orderDetailID;
	}
	public void setOrderDetailID(Integer orderDetailID) {
		this.orderDetailID = orderDetailID;
	}
	public Integer getOrderID() {
		return orderID;
	}
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Integer subTotal) {
		this.subTotal = subTotal;
	}
	public Integer getShopReview() {
		return shopReview;
	}
	public void setShopReview(Integer shopReview) {
		this.shopReview = shopReview;
	}
	public String getShopComment() {
		return shopComment;
	}
	public void setShopComment(String shopComment) {
		this.shopComment = shopComment;
	}
	public Integer getBuyerReview() {
		return buyerReview;
	}
	public void setBuyerReview(Integer buyerReview) {
		this.buyerReview = buyerReview;
	}
	public String getBuyerComment() {
		return buyerComment;
	}
	public void setBuyerComment(String buyerComment) {
		this.buyerComment = buyerComment;
	}
}
