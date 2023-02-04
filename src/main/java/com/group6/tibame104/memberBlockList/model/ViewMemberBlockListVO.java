package com.group6.tibame104.memberBlockList.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_memberblocklist")
public class ViewMemberBlockListVO implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "storeName")
	private String storeName;
	@Id
	@Column(name = "blockListID")
	private Integer blockListID;
	@Column(name = "memberID")
	private Integer memberID;

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Integer getBlockListID() {
		return blockListID;
	}

	public void setBlockListID(Integer blockListID) {
		this.blockListID = blockListID;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

}
