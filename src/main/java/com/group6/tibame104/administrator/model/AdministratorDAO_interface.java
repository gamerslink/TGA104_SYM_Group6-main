package com.group6.tibame104.administrator.model;

import java.util.List;

import com.group6.tibame104.store.model.StoreVO;


public interface AdministratorDAO_interface {

	public void insert(AdministratorVO administratorVO);
	public void update(AdministratorVO administratorVO);
	public void delete(Integer administratorID);
	public Integer countMember();
	public Integer countStore();
	public Integer countStatusY();
	public Integer countStatusN();
	public AdministratorVO findOneAdmin(Integer administratorID);
	public List<StoreVO> findAllByAudit1();
	public List<AdministratorVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//	public List<AdministratorVO> getAll(Map<String, String[]> map);
}
