package com.group6.tibame104.productMain.model;

public class ProductMainVO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer productMainID;
	private String productMainName;

	public Integer getProductMainID() {
		return productMainID;
	}

	public void setProductMainID(Integer productMainID) {
		this.productMainID = productMainID;
	}

	public String getProductMainName() {
		return productMainName;
	}

	public void setProductMainName(String productMainName) {
		this.productMainName = productMainName;
	}

	@Override
	public String toString() {
		return "ProductMainVO [productMainID=" + productMainID + ", productMainName=" + productMainName + "]";
	}

}
