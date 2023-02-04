package com.group6.tibame104.shoppingGoldRecord.model;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShoppingGoldRecordService {

	@Autowired
	private ShoppingGoldRecordDAO_interface dao;

	public ShoppingGoldRecordVO addShoppingGoldRecord(Integer memberID, Timestamp useDate, Integer obtainShoppingCoin,
			Integer plusOrMinus) {

		ShoppingGoldRecordVO shoppingGoldRecordVO = new ShoppingGoldRecordVO();

		shoppingGoldRecordVO.setMemberID(memberID);
		shoppingGoldRecordVO.setUseDate(useDate);
		shoppingGoldRecordVO.setObtainShoppingCoin(obtainShoppingCoin);
		shoppingGoldRecordVO.setPlusOrMinus(plusOrMinus);

		dao.insert(shoppingGoldRecordVO);

		return shoppingGoldRecordVO;
	}

	public ShoppingGoldRecordVO updateShoppingGoldRecord(Integer shoppingGoldRecordID, Integer memberID,
			Timestamp useDate, Integer obtainShoppingCoin, Integer plusOrMinus) {

		ShoppingGoldRecordVO shoppingGoldRecordVO = new ShoppingGoldRecordVO();

		shoppingGoldRecordVO.setShoppingGoldRecordID(shoppingGoldRecordID);
		shoppingGoldRecordVO.setMemberID(memberID);
		shoppingGoldRecordVO.setUseDate(useDate);
		shoppingGoldRecordVO.setObtainShoppingCoin(obtainShoppingCoin);
		shoppingGoldRecordVO.setPlusOrMinus(plusOrMinus);

		dao.update(shoppingGoldRecordVO);

		return shoppingGoldRecordVO;
	}

	public List<ShoppingGoldRecordVO> getOneShoppingGoldRecord(Integer memberID) {
		return dao.getAllShoppingGoldRecord(memberID);
	}
//	
//	public ShoppingGoldRecordVO getOneShoppingGoldRecord(Integer memberID) {
//		return dao.findByPrimaryKey(memberID);
//	}

	public List<ShoppingGoldRecordVO> getAll() {
		return dao.getAll();
	}
}
