package com.group6.tibame104.category.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	@Autowired
	CategoryDAO_interface dao;

	public List<CategoryVO> getbyProductName(String productName, Boolean correct){
		return dao.getbyProductName(productName, correct);
		
	}

	public CategoryVO getbyProductID(Integer productID) {
		return dao.getbyProductID(productID);
		
	}
	public List<CategoryVO> getbyStoreID(Integer storeID) {
		return dao.getbyStoreID(storeID);
		
	}

	public List<CategoryVO> getbyProductSecID(Integer productSecID) {
		return dao.getbyProductSecID(productSecID);
	}

	public List<CategoryVO> getbyProductMainID(Integer productMainID, Boolean correct) {
		return dao.getbyProductMainID(productMainID, correct);
	}
	
	public List<CategoryVO> getAll(){
		return dao.getAll();		
	}
	
	public List<String> getAllCategory(){
		return dao.getAllCategory();
		
	}
	
	public void updateStar(Integer productID){
		dao.updateStar(productID);
	}
}
