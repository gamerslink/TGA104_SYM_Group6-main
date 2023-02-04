package com.group6.tibame104.groupproduct.model;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.group6.tibame104.creditCard.model.CreditCardVO;
import com.group6.tibame104.member.model.MemberVO;
//@Repository
public class GroupproductHibernate implements GroupproductDAO_interface {
//	@PersistenceContext
	private Session session;

	@Override
	public void insert(GroupproductVO groupproductVO) {
		session.persist(groupproductVO);
	}

	@Override
	public void update(GroupproductVO groupproductVO) {
		final String hql = "UPDATE GroupproductVO "
				+ "set groupbuyProductPrice = :groupbuyProductPrice, groupbuyProductPicture = coalesce(:groupbuyProductPicture, groupbuyProductPicture), groupbuyProductDescrip = :groupbuyProductDescrip "
				+ "where groupbuyProductID = :groupbuyProductID";
		session.createQuery(hql).setParameter("groupbuyProductPrice", groupproductVO.getGroupBuyProductPrice())
				.setParameter("groupbuyProductPicture", groupproductVO.getGroupBuyProductPicture())
				.setParameter("groupbuyProductDescrip", groupproductVO.getGroupBuyProductDescrip())
				.setParameter("groupbuyProductID", groupproductVO.getGroupBuyProductID())
				.executeUpdate();
	}

	@Override
	public void delete(Integer groupbuyProductID) {
		final GroupproductVO groupproductVO = session.get(GroupproductVO.class,groupbuyProductID);
		session.remove(groupproductVO);
	}

	@Override
	public GroupproductVO findByPrimaryKey(Integer groupbuyProductID) {

		
		return session.get(GroupproductVO.class,groupbuyProductID);
	}

	@Override
	public List<GroupproductVO> getAll() {
		
		final String hql = "FROM GroupproductVO ORDER BY groupbuyProductID";
		return session.createQuery(hql, GroupproductVO.class).list();
	}

	@Override
	public List<GroupproductVO> getAllBySearch(String queryString) {
		System.out.println(queryString);
		final String hql = "FROM GroupproductVO WHERE queryString = :queryString";
		System.out.println(hql);
		return session.createQuery(hql, GroupproductVO.class).setParameter("queryString", queryString).list();
		
	}

	
}
