package com.group6.tibame104.groupdiscount.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GroupdiscountService {
	@Autowired
	private GroupdiscountDAO_interface dao;
	
	// 新增
	public GroupdiscountVO addGroupdiscount(Integer groupBuyID, Integer groupBuyProductOrderTotal,
			Double groupBuyCount) {
		
		GroupdiscountVO groupdiscountVO = new GroupdiscountVO();
		groupdiscountVO.setGroupBuyID(groupBuyID);
		groupdiscountVO.setGroupBuyProductOrderTotal(groupBuyProductOrderTotal);
		groupdiscountVO.setGroupBuyCount(groupBuyCount);

		dao.insert(groupdiscountVO);

		return groupdiscountVO;
	}

	
	
	// 修改
	public GroupdiscountVO updateGroupdiscount(Integer countTableID, Integer groupBuyID, Integer groupBuyProductOrderTotal,
			Double groupBuyCount) {
		
		GroupdiscountVO groupdiscountVO = new GroupdiscountVO();
		groupdiscountVO.setCountTableID(countTableID);
		groupdiscountVO.setGroupBuyID(groupBuyID);
		groupdiscountVO.setGroupBuyProductOrderTotal(groupBuyProductOrderTotal);
		groupdiscountVO.setGroupBuyCount(groupBuyCount);

		dao.update(groupdiscountVO);
		return groupdiscountVO;
	}
	
	
	
	//刪除
	public void deleteGroupdiscount(Integer countTableID) {
		dao.delete(countTableID);
	}

	
	
	// 單一查詢
	public GroupdiscountVO getByPK(Integer countTableID) {
		return dao.findByPK(countTableID);
	}
	
	
	
	// 依CountTableID查詢
	public List<GroupdiscountVO> getAllByGroupBuyID(Integer groupBuyID) {
		return dao.findAllByGroupBuyID(groupBuyID);
		}

	
	
	// 查詢全部
	public List<GroupdiscountVO> getAll() {
		return dao.findAll();
	}
//	//只找groupID不重複
//	public List<GroupdiscountVO> getGroupBuyID() {
//		return dao.getAllByGroupBuyID();
//	}
	
//	public List<GroupdiscountVO> getAllByCountTableID(Integer groupBuyID) {
//		return dao.getAllByCountTableID(groupBuyID);
//	}

}