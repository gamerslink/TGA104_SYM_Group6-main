package com.group6.tibame104.memberBlockList.model;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class MemberBlockListHibernateDAO implements MemberBlockListDAO_interface {

	@PersistenceContext
	private Session session;

	@Override
	public void insert(MemberBlockListVO memberBlockListVO) {
		session.persist(memberBlockListVO);
	}

	@Override
	public void delete(Integer blockListID) {
		final MemberBlockListVO mBlockListVO = session.get(MemberBlockListVO.class, blockListID);
		session.remove(mBlockListVO);
	}

	@Override
	public List<ViewMemberBlockListVO> getAll(Integer memberID) {
		final String hql = "FROM ViewMemberBlockListVO WHERE  memberID = :memberID";
		return session.createQuery(hql, ViewMemberBlockListVO.class).setParameter("memberID", memberID).list();
	}

}
