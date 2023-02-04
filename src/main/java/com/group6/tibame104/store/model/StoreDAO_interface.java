package com.group6.tibame104.store.model;

import java.util.List;

public interface StoreDAO_interface {
	/*
	 * 前台 
	 * 1.修改商場 
	 * 2.List 1
	 *
	 */

	public void update(StoreVO storeVO);

	public StoreVO findByPrimaryKey(Integer storeVO);
	
	public void insert(StoreVO storeVO);
	
	public void pass(Integer memberID);

	public List<StoreVO> findAllByAudit0();

	public Integer findMemberID(Integer storeID);
}
