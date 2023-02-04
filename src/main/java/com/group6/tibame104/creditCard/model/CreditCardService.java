package com.group6.tibame104.creditCard.model;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreditCardService {

	@Autowired
	private CreditCardDAO_interface dao;

	public CreditCardVO addCreditCard(Integer memberID, String creditCardNumber, String securityCode, Date exDate) {

		CreditCardVO creditCardVO = new CreditCardVO();

		creditCardVO.setMemberID(memberID);
		creditCardVO.setCreditCardNumber(creditCardNumber);
		creditCardVO.setSecurityCode(securityCode);
		creditCardVO.setExDate(exDate);
		dao.insert(creditCardVO);

		return creditCardVO;
	}

	public CreditCardVO updateCreditCard(String creditCardNumber, String securityCode, Date exDate,
			Integer creditCardID) {
		CreditCardVO creditCardVO = new CreditCardVO();

		creditCardVO.setCreditCardNumber(creditCardNumber);
		creditCardVO.setSecurityCode(securityCode);
		creditCardVO.setExDate(exDate);
		creditCardVO.setMemberID(creditCardID);

		dao.update(creditCardVO);

		return creditCardVO;
	}

	public void deletecreditCard(Integer creditCardID) {
		dao.delete(creditCardID);
	}

	public List<CreditCardVO> getAll(Integer memberID) {
		return dao.getAll(memberID);
	}

//	public static void main(String[] args) {
//		CreditCardService creditCardService = new CreditCardService();
//
//		creditCardService.addCreditCard(2, "hh", "hh", java.sql.Date.valueOf("1993-01-02"));

//	}

}
