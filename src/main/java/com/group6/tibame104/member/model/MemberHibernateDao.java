package com.group6.tibame104.member.model;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class MemberHibernateDao implements MemberDAO_interface {
	@PersistenceContext
	private Session session;

	@Override
	public void insert(MemberVO memberVO) {
		session.persist(memberVO);
	}

	@Override
	public void update(MemberVO memberVO) {
		final String hql = "UPDATE MemberVO "
				+ "set gender = :gender, birthday = :birthday, userPhoto = :userPhoto, mailCertification = :mailCertification, idNumber = :idNumber, address = :address,sellerAuditApprovalState = :sellerAuditApprovalState,currentShoppingCoin = :currentShoppingCoin "
				+ "where memberID = :memberID";

		session.createQuery(hql).setParameter("gender", memberVO.getGender())
				.setParameter("birthday", memberVO.getBirthday()).setParameter("userPhoto", memberVO.getUserPhoto())
				.setParameter("mailCertification", memberVO.getMailCertification())
				.setParameter("idNumber", memberVO.getIdNumber()).setParameter("address", memberVO.getAddress())
				.setParameter("sellerAuditApprovalState", memberVO.getSellerAuditApprovalState())
				.setParameter("currentShoppingCoin", memberVO.getCurrentShoppingCoin())
				.setParameter("memberID", memberVO.getMemberID()).executeUpdate();
	}

	@Override
	public void updateOne(MemberVO memberVO) {
		final String hql = "UPDATE MemberVO "
				+ "set userName = :userName, userAccount = :userAccount, phone = :phone, mail = :mail, userPhoto = coalesce(:userPhoto, userPhoto), idNumber = :idNumber, address = :address "
				+ "where memberID = :memberID";
		session.createQuery(hql).setParameter("userName", memberVO.getUserName())
				.setParameter("userAccount", memberVO.getUserAccount()).setParameter("phone", memberVO.getPhone())
				.setParameter("mail", memberVO.getMail()).setParameter("userPhoto", memberVO.getUserPhoto())
				.setParameter("idNumber", memberVO.getIdNumber()).setParameter("address", memberVO.getAddress())
				.setParameter("memberID", memberVO.getMemberID()).executeUpdate();
	}

	@Override
	public void updateOnePasswoed(MemberVO memberVO) {
		final String hql = "UPDATE MemberVO set userPassword = :userPassword where memberID = :memberID";
		session.createQuery(hql).setParameter("userPassword", memberVO.getUserPassword())
				.setParameter("memberID", memberVO.getMemberID()).executeUpdate();
	}

	@Override
	public void delete(Integer memberID) {
		final MemberVO memberVO = session.get(MemberVO.class, memberID);
		session.remove(memberVO);
	}

	@Override
	public MemberVO getByPrimaryKey(Integer memberID) {
		return session.get(MemberVO.class, memberID);
	}

	@Override
	public MemberVO getOneMemberByMail(String mail) {
		final String hql = "FROM MemberVO WHERE mail = :mail";
		return session.createQuery(hql, MemberVO.class).setParameter("mail", mail).uniqueResult();
	}

	@Override
	public Integer selectLastMemberID() {
		String hql = "select max(m.memberID) from MemberVO m";
		Integer maxMemberID = (Integer) session.createQuery(hql).uniqueResult();
		return maxMemberID;

	}

	@Override
	public List<MemberVO> getAll() {
		final String hql = "FROM MemberVO ORDER BY memberID";
		return session.createQuery(hql, MemberVO.class).list();
	}

	@Override
	public Boolean findOneMemberForLogin(String mail, String userPassword) {
		final String hql = "FROM MemberVO WHERE mail = :mail  AND userPassword = :userPassword";
		return session.createQuery(hql).setParameter("mail", mail).setParameter("userPassword", userPassword)
				.uniqueResult() != null;
	}

	@Override
	public Boolean findMemberByMail(String mail) {
		final String hql = "FROM MemberVO WHERE mail = :mail";
		return session.createQuery(hql).setParameter("mail", mail).uniqueResult() != null;
	}

}
