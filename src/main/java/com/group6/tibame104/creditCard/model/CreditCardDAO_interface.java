package com.group6.tibame104.creditCard.model;

import java.util.List;

public interface CreditCardDAO_interface {
	public void insert(CreditCardVO creditCardVO);

	public void update(CreditCardVO creditCardVO);

	public void delete(Integer creditCardNumber);

	public CreditCardVO findByPrimaryKey(Integer creditCardID);

	public List<CreditCardVO> getAll(Integer memberID);
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 

}
