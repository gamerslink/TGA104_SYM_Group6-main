package com.group6.tibame104.groupproduct.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="groupBuyProduct")
public class GroupproductVO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="groupbuyProductID")
	private Integer groupBuyProductID;
	@Column(name="groupbuyProductPrice")
	private Integer groupBuyProductPrice;
	@Column(name="groupbuyProductPicture", columnDefinition = "longblob")
	private byte[] groupBuyProductPicture;
	@Column(name="groupbuyProductDescrip")
	private String groupBuyProductDescrip;
	
	@Override
	public String toString() {
		return "GroupproductVO [groupBuyProductID=" + groupBuyProductID + ", groupBuyProductPrice="
				+ groupBuyProductPrice + ", groupBuyProductPicture=" + Arrays.toString(groupBuyProductPicture)
				+ ", groupBuyProductDescrip=" + groupBuyProductDescrip + "]";
	}
	public Integer getGroupBuyProductID() {
		return groupBuyProductID;
	}
	public void setGroupBuyProductID(Integer groupBuyProductID) {
		this.groupBuyProductID = groupBuyProductID;
	}
	public Integer getGroupBuyProductPrice() {
		return groupBuyProductPrice;
	}
	public void setGroupBuyProductPrice(Integer groupBuyProductPrice) {
		this.groupBuyProductPrice = groupBuyProductPrice;
	}
	public byte[] getGroupBuyProductPicture() {
		return groupBuyProductPicture;
	}
	public void setGroupBuyProductPicture(byte[] groupBuyProductPicture) {
		this.groupBuyProductPicture = groupBuyProductPicture;
	}
	public String getGroupBuyProductDescrip() {
		return groupBuyProductDescrip;
	}
	public void setGroupBuyProductDescrip(String groupBuyProductDescrip) {
		this.groupBuyProductDescrip = groupBuyProductDescrip;
	}

	
}
