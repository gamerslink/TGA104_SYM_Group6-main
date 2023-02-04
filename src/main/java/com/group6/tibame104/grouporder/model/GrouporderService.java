package com.group6.tibame104.grouporder.model;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class GrouporderService {
@Autowired
	private GrouporderDAO_interface dao;


//新增
	public GrouporderVO addGrouporder(Integer groupBuyID, Integer groupBuyProductID,Integer memberID,
			Integer groupBuyQuantity, Integer groupBuyTotal, Timestamp orderTime, String paymentTerm,
			Integer paymentState, Integer giftVoucher, String contactNumber, String shippingLocation) {

		GrouporderVO grouporderVO = new GrouporderVO();

		grouporderVO.setGroupBuyID(groupBuyID);
		grouporderVO.setGroupBuyProductID(groupBuyProductID);
		grouporderVO.setMemberID(memberID);
		grouporderVO.setGroupBuyQuantity(groupBuyQuantity);
		grouporderVO.setGroupBuyTotal(groupBuyTotal);
		grouporderVO.setOrderTime(orderTime);
		grouporderVO.setPaymentTerm(paymentTerm);
		grouporderVO.setPaymentState(paymentState);
		grouporderVO.setGiftVoucher(giftVoucher);
		grouporderVO.setContactNumber(contactNumber);
		grouporderVO.setShippingLocation(shippingLocation);
		dao.insert(grouporderVO);

		return grouporderVO;
	}

//修改
	public GrouporderVO updateGrouporder(Integer groupBuyOrderID, Integer groupBuyID, Integer memberID,
			Integer groupBuyProductID, Integer groupBuyQuantity, Integer groupBuyTotal, Timestamp orderTime, String paymentTerm,
			Integer paymentState, Integer giftVoucher, String contactNumber, String shippingLocation) {

		GrouporderVO grouporderVO = new GrouporderVO();

		grouporderVO.setGroupBuyOrderID(groupBuyOrderID);
		grouporderVO.setGroupBuyID(groupBuyID);
		grouporderVO.setMemberID(memberID);
		grouporderVO.setGroupBuyProductID(groupBuyProductID);
		grouporderVO.setGroupBuyQuantity(groupBuyQuantity);
		grouporderVO.setGroupBuyTotal(groupBuyTotal);
		grouporderVO.setOrderTime(orderTime);
		grouporderVO.setPaymentTerm(paymentTerm);
		grouporderVO.setPaymentState(paymentState);
		grouporderVO.setGiftVoucher(giftVoucher);
		grouporderVO.setContactNumber(contactNumber);
		grouporderVO.setShippingLocation(shippingLocation);

		dao.update(grouporderVO);
		return grouporderVO;
	}

//單一查詢
	public GrouporderVO getOneGrouporder(Integer groupBuyOrderID) {
		return dao.findByPrimaryKey(groupBuyOrderID);
	}
//查詢全部
	public List<GrouporderVO> getAll() {
		return dao.getAll();
	}
//用會員編號查詢全部訂單	
	public List<GrouporderVO> getAllByMemID(Integer memberID){
		return dao.getAllByMemID(memberID);
	}
	public void deleteGrouporder(Integer groupBuyOrderID) {
		dao.delete(groupBuyOrderID);
	}
}
