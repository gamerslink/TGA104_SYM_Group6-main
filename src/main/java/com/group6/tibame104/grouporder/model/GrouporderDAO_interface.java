package com.group6.tibame104.grouporder.model;

import java.util.List;


public interface GrouporderDAO_interface {
	
	public void insert(GrouporderVO grouporderVO);

	public void update(GrouporderVO grouporderVO);

	public void delete(Integer grouporderID);

	public GrouporderVO findByPrimaryKey(Integer groupBuyOrderID);

	public List<GrouporderVO> getAll();
	
	public List<GrouporderVO> getAllByMemID(Integer memberID);
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//   public List<(GroupproductVO> getAll(Map<String, String[]> map); 
}
