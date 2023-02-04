package com.group6.tibame104.group.model;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GroupService {
	@Autowired
	private GroupDAO_interface dao;

//新增
	public GroupVO addGroup(Integer groupBuyProductID, Integer administratorID, Integer groupBuyProductOrderTotal,
			Boolean groupBuyingState, Timestamp groupBuyingOnLoadDate, Timestamp groupBuyingOffLoadDate,
			Timestamp updateTime) {

		GroupVO groupVO = new GroupVO();

		groupVO.setGroupBuyProductID(groupBuyProductID);
		groupVO.setAdministratorID(administratorID);
		groupVO.setGroupBuyProductOrderTotal(groupBuyProductOrderTotal);
		groupVO.setGroupBuyingState(groupBuyingState);
		groupVO.setGroupBuyingOnLoadDate(groupBuyingOnLoadDate);
		groupVO.setGroupBuyingOffLoadDate(groupBuyingOffLoadDate);
		groupVO.setUpdateTime(updateTime);

		dao.insert(groupVO);

		return groupVO;
	}

//修改
	public GroupVO updateGroup(Integer groupBuyProductID, Integer administratorID, Integer groupBuyProductOrderTotal,
			Boolean groupBuyingState, Timestamp groupBuyingOnLoadDate, Timestamp groupBuyingOffLoadDate,
			Timestamp updateTime, Integer groupBuyID) {

		GroupVO groupVO = new GroupVO();

		groupVO.setGroupBuyProductID(groupBuyProductID);
		groupVO.setAdministratorID(administratorID);
		groupVO.setGroupBuyProductOrderTotal(groupBuyProductOrderTotal);
		groupVO.setGroupBuyingState(groupBuyingState);
		groupVO.setGroupBuyingOnLoadDate(groupBuyingOnLoadDate);
		groupVO.setGroupBuyingOffLoadDate(groupBuyingOffLoadDate);
		groupVO.setUpdateTime(updateTime);
		groupVO.setGroupBuyID(groupBuyID);

		dao.update(groupVO);
		return groupVO;

	}

	// 新增訂單後 修改團購總數量
	public GroupVO updateGroupQua(Integer groupBuyProductOrderTotal, Integer groupBuyID) {

		GroupVO groupVO = new GroupVO();

		groupVO.setGroupBuyProductOrderTotal(groupBuyProductOrderTotal);
		groupVO.setGroupBuyID(groupBuyID);

		dao.updateGroupQua(groupVO);
		return groupVO;

	}

	// 單一查詢
	public GroupVO getOneGroup(Integer groupBuyID) {
		return dao.findByPrimaryKey(groupBuyID);
	}

	public void deleteGroup(Integer groupBuyID) {
		dao.delete(groupBuyID);
	}

	// 查詢全部
	public List<GroupVO> getAll() {
		return dao.getAll();
	}
	// 查詢全部
		public List<GroupVO> getAllDesc() {
			return dao.getAllDesc();
		}

	// 查詢按照團購數
	public List<GroupVO> orderBy() {
		return dao.orderBy();
	}
	//Hibernate join用
	public List<Object> getJoinAll(){
		return dao.getJoinAll();
	}
	
}
