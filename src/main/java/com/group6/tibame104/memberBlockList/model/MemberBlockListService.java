package com.group6.tibame104.memberBlockList.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberBlockListService {
	@Autowired
	private MemberBlockListDAO_interface dao;

	public MemberBlockListVO addBlock(Integer memberID, Integer storeID) {

		MemberBlockListVO memberBlockListVO = new MemberBlockListVO();

		memberBlockListVO.setMemberID(memberID);
		memberBlockListVO.setStoreID(storeID);
		dao.insert(memberBlockListVO);

		return memberBlockListVO;
	}

	public void delete(Integer blockListID) {
		dao.delete(blockListID);
	}

	public List<ViewMemberBlockListVO> getAll(Integer memberID) {
		return dao.getAll(memberID);
	}

//	public static void main(String[] args) {
//		MemberBlockListService memberBlockListService = new MemberBlockListService();
//
//		memberBlockListService.addBlock(3, 2);
//
//	}

}
