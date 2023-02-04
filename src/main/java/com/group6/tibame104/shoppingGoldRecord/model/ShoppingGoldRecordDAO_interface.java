package com.group6.tibame104.shoppingGoldRecord.model;

import java.util.List;

public interface ShoppingGoldRecordDAO_interface {
    public void insert(ShoppingGoldRecordVO shoppingGoldRecordVO);
    public void update(ShoppingGoldRecordVO shoppingGoldRecordVO);
    public ShoppingGoldRecordVO findByPrimaryKey(Integer shoppingGoldRecordVO);
    public List<ShoppingGoldRecordVO> getAll();
   
    //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
    public List<ShoppingGoldRecordVO> getAllShoppingGoldRecord(Integer memberID);
}
