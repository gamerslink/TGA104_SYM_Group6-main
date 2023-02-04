package com.group6.tibame104.memberBlockList.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "memberBlockList")
public class MemberBlockListVO implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "blockListID")
	private Integer blockListID;
	@Column(name = "memberID")
	private Integer memberID;
	@Column(name = "storeID")
	private Integer storeID;

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

	public Integer getStoreID() {
		return storeID;
	}

	public void setStoreID(Integer storeID) {
		this.storeID = storeID;
	}

}
