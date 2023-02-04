package com.group6.tibame104.productSec.model;

public class ProductSecVO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer productSecID;
	private Integer productMainID;
	private String productSecName;

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

	public String getProductSecName() {
		return productSecName;
	}

	public void setProductSecName(String productSecName) {
		this.productSecName = productSecName;
	}

	@Override
	public String toString() {
		return "ProductSecVO [productSecID=" + productSecID + ", productMainID=" + productMainID + ", productSecName="
				+ productSecName + "]";
	}

}
