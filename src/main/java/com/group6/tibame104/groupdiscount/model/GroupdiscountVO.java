package com.group6.tibame104.groupdiscount.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "groupBuyDiscount")
public class GroupdiscountVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "countTableID")
	private Integer countTableID;
	@Column(name = "groupBuyID")
	private Integer groupBuyID;
	@Column(name = "groupBuyProductOrderTotal")
	private Integer groupBuyProductOrderTotal;
	@Column(name = "groupBuyCount")
	private Double groupBuyCount;
	
	public Integer getCountTableID() {
		return countTableID;
	}
	public void setCountTableID(Integer countTableID) {
		this.countTableID = countTableID;
	}
	public Integer getGroupBuyID() {
		return groupBuyID;
	}
	public void setGroupBuyID(Integer groupBuyID) {
		this.groupBuyID = groupBuyID;
	}
	public Integer getGroupBuyProductOrderTotal() {
		return groupBuyProductOrderTotal;
	}
	public void setGroupBuyProductOrderTotal(Integer groupBuyProductOrderTotal) {
		this.groupBuyProductOrderTotal = groupBuyProductOrderTotal;
	}
	public Double getGroupBuyCount() {
		return groupBuyCount;
	}
	public void setGroupBuyCount(Double groupBuyCount) {
		this.groupBuyCount = groupBuyCount;
	}

	
}
