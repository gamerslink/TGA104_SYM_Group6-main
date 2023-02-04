package com.group6.tibame104.category.model;

import java.sql.Timestamp;

public class CategoryVO {
	
	private Integer productID;
	private Integer storeID;	
	private String productName;
	private Integer productStock;
	private Integer productPrice;
	private String productDesc;
	private String source;
	private byte[] productImg;
	private byte[] productImg2;
	private byte[] productImg3;
	private Timestamp insertTime;
	private Boolean productStatus;
	private Integer commentTotal;
	private Double commentAvgStar;
	private String storeName;
    private String storeAddress;
    private String phoneNumber;
    private Integer productSecID;
    private String productSecName;
    private Integer productMainID;
    private String productMainName;
    
	public String getProductSecName() {
		return productSecName;
	}
	public void setProductSecName(String string) {
		this.productSecName = string;
	}
	public String getProductMainName() {
		return productMainName;
	}
	public void setProductMainName(String productMainName) {
		this.productMainName = productMainName;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Integer getStoreID() {
		return storeID;
	}
	public void setStoreID(Integer storeID) {
		this.storeID = storeID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductStock() {
		return productStock;
	}
	public void setProductStock(Integer productStock) {
		this.productStock = productStock;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public byte[] getProductImg() {
		return productImg;
	}
	public void setProductImg(byte[] productImg) {
		this.productImg = productImg;
	}
	public byte[] getProductImg2() {
		return productImg2;
	}
	public void setProductImg2(byte[] productImg2) {
		this.productImg2 = productImg2;
	}
	public byte[] getProductImg3() {
		return productImg3;
	}
	public void setProductImg3(byte[] productImg3) {
		this.productImg3 = productImg3;
	}
	public Timestamp getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}
	public Boolean getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(Boolean productStatus) {
		this.productStatus = productStatus;
	}
	public Integer getCommentTotal() {
		return commentTotal;
	}
	public void setCommentTotal(Integer commentTotal) {
		this.commentTotal = commentTotal;
	}
	public Double getCommentAvgStar() {
		return commentAvgStar;
	}
	public void setCommentAvgStar(Double commentAvgStar) {
		this.commentAvgStar = commentAvgStar;
	}
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public Integer getProductSecID() {
		return productSecID;
	}
	public void setProductSecID(Integer productSecID) {
		this.productSecID = productSecID;
	}
	public Integer getProductMainID() {
		return productMainID;
	}
	public void setProductMainID(Integer productMainID) {
		this.productMainID = productMainID;
	}
}
