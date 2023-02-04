package com.group6.tibame104.member.model;

import java.util.List;

public interface MemberDAO_interface {
	public void insert(MemberVO memberVO);

	public void update(MemberVO memberVO);

	public void updateOne(MemberVO memberVO);

	public void updateOnePasswoed(MemberVO memberVO);

	public void delete(Integer memberID);

	public MemberVO getByPrimaryKey(Integer memberID);

	public MemberVO getOneMemberByMail(String mail);

	public Integer selectLastMemberID();

	public List<MemberVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 

	public Boolean findOneMemberForLogin(String mail, String userPassword);

	public Boolean findMemberByMail(String mail);

}
