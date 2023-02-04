package com.group6.tibame104.group.model;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class GroupHibernate implements GroupDAO_interface {
	@PersistenceContext
	private Session session;

	@Override
	public void insert(GroupVO groupVO) {
		session.persist(groupVO);
	}

	@Override
	public void update(GroupVO groupVO) {
		session.update(groupVO);
	}

	@Override
	public void updateGroupQua(GroupVO groupVO) {
		final String hql = "UPDATE GroupVO "
		+"set groupBuyProductOrderTotal = :groupBuyProductOrderTotal "
		+"WHERE groupBuyID = :groupBuyID ";
		session.createQuery(hql).setParameter("groupBuyProductOrderTotal", groupVO.getGroupBuyProductOrderTotal())
		.setParameter("groupBuyID", groupVO.getGroupBuyID())
		.executeUpdate();

	}

	@Override
	public void delete(Integer grouporderID) {
		final GroupVO groupVO = session.get(GroupVO.class, grouporderID);
		session.remove(groupVO);
	}

	@Override
	public GroupVO findByPrimaryKey(Integer groupBuyID) {
		
		return session.get(GroupVO.class, groupBuyID);
	}

	@Override
	public List<GroupVO> getAll() {
		final String hql = "FROM GroupVO ORDER BY groupBuyID ";
		return session.createQuery(hql, GroupVO.class).list();
	}
	@Override
	public List<GroupVO> getAllDesc() {
		final String hql = "FROM GroupVO ORDER BY groupBuyID DESC";
		return session.createQuery(hql, GroupVO.class).list();
	}

	@Override
	public List<GroupVO> orderBy() {
		final String hql = "FROM GroupVO ORDER BY groupBuyProductOrderTotal DESC";
		return session.createQuery(hql, GroupVO.class).list();
	}
	
	public List<Object> getJoinAll() {
		final String hql = "FROM GroupVO b "
				+ "	INNER join GroupproductVO p"
				+ "	on b.groupBuyProductID = p.groupBuyProductID"
				+ "	INNER join GroupdiscountVO d"
				+ "	on d.groupBuyID = b.groupBuyID";
		return session.createQuery(hql, Object.class).list();
	}




}
