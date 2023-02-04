package com.group6.tibame104.groupdiscount.model;

import java.util.List;

import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class GroupdiscountHibernate implements GroupdiscountDAO_interface{
	@PersistenceContext
	private Session session;
	@Override
	public void insert(GroupdiscountVO groupdiscountVO) {
		session.persist(groupdiscountVO);
	}

	@Override
	public void update(GroupdiscountVO groupdiscountVO) {
		final String hql = "update GroupdiscountVO "
				+ "set groupBuyID = :groupBuyID,"
				+ "groupBuyProductOrderTotal = :groupBuyProductOrderTotal,"
				+ "groupBuyCount = :groupBuyCount where countTableID = :countTableID";

		session.createQuery(hql).setParameter("groupBuyID", groupdiscountVO.getGroupBuyID())
				.setParameter("groupBuyProductOrderTotal", groupdiscountVO.getGroupBuyProductOrderTotal())
				.setParameter("groupBuyCount", groupdiscountVO.getGroupBuyCount())
				.setParameter("countTableID", groupdiscountVO.getCountTableID()).executeUpdate();
	}	
	
	@Override
	public void delete(Integer countTableID) {
		final GroupdiscountVO groupdiscountVO = session.get(GroupdiscountVO.class, countTableID);
		session.remove(groupdiscountVO);
	}

	@Override
	public GroupdiscountVO findByPK(Integer countTableID) {
		final String hql = "FROM GroupdiscountVO WHERE countTableID = :countTableID";
		return session.createQuery(hql, GroupdiscountVO.class).setParameter("countTableID", countTableID).uniqueResult();
	}

	@Override
	public List<GroupdiscountVO> findAllByGroupBuyID(Integer groupBuyID) {
		final String hql = "FROM GroupdiscountVO WHERE groupBuyID = :groupBuyID";
		return session.createQuery(hql, GroupdiscountVO.class).list();
	}

	@Override
	public List<GroupdiscountVO> findAll() {
		final String hql = "FROM GroupdiscountVO ORDER BY countTableID";
		return session.createQuery(hql, GroupdiscountVO.class).list();
	}
	
}
