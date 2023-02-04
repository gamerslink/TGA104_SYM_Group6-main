package com.group6.tibame104.creditCard.model;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class CreditCardHibernateDao implements CreditCardDAO_interface {

	@PersistenceContext
	private Session session;

	@Override
	public void insert(CreditCardVO creditCardVO) {
		session.persist(creditCardVO);
	}

	@Override
	public void update(CreditCardVO creditCardVO) {
		session.update(creditCardVO);
	}

	@Override
	public void delete(Integer creditCardNumber) {
		final CreditCardVO cardVO = session.get(CreditCardVO.class, creditCardNumber);
		session.remove(cardVO);
	}

	@Override
	public CreditCardVO findByPrimaryKey(Integer creditCardID) {
		return session.get(CreditCardVO.class, creditCardID);
	}

	@Override
	public List<CreditCardVO> getAll(Integer memberID) {
		final String hql = "FROM CreditCardVO WHERE memberID = :memberID";
		return session.createQuery(hql, CreditCardVO.class).setParameter("memberID", memberID).list();
	}

}
