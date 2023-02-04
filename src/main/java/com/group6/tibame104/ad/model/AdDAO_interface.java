package com.group6.tibame104.ad.model;

import java.util.List;

public interface AdDAO_interface {
	public void insert(AdVO adVO);
	public void update(AdVO adVO);
	public void delete(Integer adSerialID);
	public AdVO findByPrimaryKey(Integer adSerialID);
	public List<AdVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//	public List<AdvVO> getAll(Map<String, String[]> map);
}
