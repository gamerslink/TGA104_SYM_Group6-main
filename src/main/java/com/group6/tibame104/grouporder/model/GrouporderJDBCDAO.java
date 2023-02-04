package com.group6.tibame104.grouporder.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository
public class GrouporderJDBCDAO implements GrouporderDAO_interface {
//	@Autowired
	private DataSource dataSource;

	private static final String INSERT_STMT = "INSERT INTO groupBuyOrder (groupBuyID,groupBuyProductID,memberID,groupBuyQuantity,groupBuyTotal,orderTime,paymentTerm,paymentState,giftVoucher,contactNumber,shippingLocation) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT = "SELECT groupBuyOrderID,groupBuyID,memberID,groupBuyProductID,groupBuyQuantity,groupBuyTotal,orderTime,paymentTerm,paymentState,giftVoucher,contactNumber,shippingLocation FROM groupBuyOrder";
	private static final String GET_ONE_STMT = "SELECT groupBuyOrderID,groupBuyID,memberID,groupBuyProductID,groupBuyQuantity,groupBuyTotal,orderTime,paymentTerm,paymentState,giftVoucher,contactNumber,shippingLocation FROM groupBuyOrder where groupBuyOrderID = ?";
	private static final String GET_BY_MEMID = "SELECT groupBuyOrderID,groupBuyID,memberID,groupBuyProductID,groupBuyQuantity,groupBuyTotal,orderTime,paymentTerm,paymentState,giftVoucher,contactNumber,shippingLocation FROM groupBuyOrder where memberID = ?";
	private static final String UPDATE = "UPDATE groupBuyOrder set groupBuyID=? ,memberID=? ,groupBuyProductID=? ,groupBuyQuantity=? ,groupBuyTotal=? ,orderTime=?,paymentTerm=? ,paymentState=? ,giftVoucher=? ,contactNumber=? ,shippingLocation=?  where groupBuyOrderID = ?";
	private static final String DELETE = "DELETE FROM groupBuyOrder where groupBuyOrderID = ?";

//新增
	@Override
	public void insert(GrouporderVO grouporderVO) {

		try (Connection con = dataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(INSERT_STMT)) {

			pstmt.setInt(1, grouporderVO.getGroupBuyID());
			pstmt.setInt(2, grouporderVO.getGroupBuyProductID());
			pstmt.setInt(3, grouporderVO.getMemberID());
			pstmt.setInt(4, grouporderVO.getGroupBuyQuantity());
			pstmt.setInt(5, grouporderVO.getGroupBuyTotal());
			pstmt.setTimestamp(6, grouporderVO.getOrderTime());
			pstmt.setString(7, grouporderVO.getPaymentTerm());
			pstmt.setInt(8, grouporderVO.getPaymentState());
			pstmt.setInt(9, grouporderVO.getGiftVoucher());
			pstmt.setString(10, grouporderVO.getContactNumber());
			pstmt.setString(11, grouporderVO.getShippingLocation());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//更新
	@Override
	public void update(GrouporderVO grouporderVO) {

		try (Connection con = dataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(UPDATE)) {

			pstmt.setInt(1, grouporderVO.getGroupBuyID());
			pstmt.setInt(2, grouporderVO.getMemberID());
			pstmt.setInt(3, grouporderVO.getGroupBuyProductID());
			pstmt.setInt(4, grouporderVO.getGroupBuyQuantity());
			pstmt.setInt(5, grouporderVO.getGroupBuyTotal());
			pstmt.setTimestamp(6, grouporderVO.getOrderTime());
			pstmt.setString(7, grouporderVO.getPaymentTerm());
			pstmt.setInt(8, grouporderVO.getPaymentState());
			pstmt.setInt(9, grouporderVO.getGiftVoucher());
			pstmt.setString(10, grouporderVO.getContactNumber());
			pstmt.setString(11, grouporderVO.getShippingLocation());
			pstmt.setInt(12, grouporderVO.getGroupBuyOrderID());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//刪除
	@Override
	public void delete(Integer grouporderID) {

		try (Connection con = dataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(DELETE)) {

			pstmt.setInt(1, grouporderID);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//查詢單一團購訂單
	@Override
	public GrouporderVO findByPrimaryKey(Integer groupBuyOrderID) {

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT)) {
			pstmt.setInt(1, groupBuyOrderID);
			try (ResultSet rs = pstmt.executeQuery()) {

				if (rs.next()) {
					GrouporderVO grouporderVO = new GrouporderVO();

					grouporderVO.setGroupBuyOrderID(rs.getInt("groupBuyOrderID"));
					grouporderVO.setGroupBuyID(rs.getInt("groupBuyID"));
					grouporderVO.setMemberID(rs.getInt("memberID"));
					grouporderVO.setGroupBuyProductID(rs.getInt("groupBuyProductID"));
					grouporderVO.setGroupBuyQuantity(rs.getInt("groupBuyQuantity"));
					grouporderVO.setGroupBuyTotal(rs.getInt("groupBuyTotal"));
					grouporderVO.setOrderTime(rs.getTimestamp("orderTime"));
					grouporderVO.setPaymentTerm(rs.getString("paymentTerm"));
					grouporderVO.setPaymentState(rs.getInt("paymentState"));
					grouporderVO.setGiftVoucher(rs.getInt("giftVoucher"));
					grouporderVO.setContactNumber(rs.getString("contactNumber"));
					grouporderVO.setShippingLocation(rs.getString("shippingLocation"));
					return grouporderVO;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	// 用會員編號查詢所有訂單
	public List<GrouporderVO> getAllByMemID(Integer memberID) {

		List<GrouporderVO> list = new ArrayList<GrouporderVO>();

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_BY_MEMID)) {
			pstmt.setInt(1, memberID);
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					// empVO 也稱為 Domain objects

					GrouporderVO grouporderVO = new GrouporderVO();

					grouporderVO.setGroupBuyOrderID(rs.getInt("groupBuyOrderID"));
					grouporderVO.setGroupBuyID(rs.getInt("groupBuyID"));
					grouporderVO.setMemberID(rs.getInt("memberID"));
					grouporderVO.setGroupBuyProductID(rs.getInt("groupBuyProductID"));
					grouporderVO.setGroupBuyQuantity(rs.getInt("groupBuyQuantity"));
					grouporderVO.setGroupBuyTotal(rs.getInt("groupBuyTotal"));
					grouporderVO.setOrderTime(rs.getTimestamp("orderTime"));
					grouporderVO.setPaymentTerm(rs.getString("paymentTerm"));
					grouporderVO.setPaymentState(rs.getInt("paymentState"));
					grouporderVO.setGiftVoucher(rs.getInt("giftVoucher"));
					grouporderVO.setContactNumber(rs.getString("contactNumber"));
					grouporderVO.setShippingLocation(rs.getString("shippingLocation"));

					list.add(grouporderVO); // Store the row in the list
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
// 查詢ALL

	public List<GrouporderVO> getAll() {
		List<GrouporderVO> list = new ArrayList<GrouporderVO>();

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT)) {
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					// empVO 也稱為 Domain objects

					GrouporderVO grouporderVO = new GrouporderVO();

					grouporderVO.setGroupBuyOrderID(rs.getInt("groupBuyOrderID"));
					grouporderVO.setGroupBuyID(rs.getInt("groupBuyID"));
					grouporderVO.setMemberID(rs.getInt("memberID"));
					grouporderVO.setGroupBuyProductID(rs.getInt("groupBuyProductID"));
					grouporderVO.setGroupBuyQuantity(rs.getInt("groupBuyQuantity"));
					grouporderVO.setGroupBuyTotal(rs.getInt("groupBuyTotal"));
					grouporderVO.setOrderTime(rs.getTimestamp("orderTime"));
					grouporderVO.setPaymentTerm(rs.getString("paymentTerm"));
					grouporderVO.setPaymentState(rs.getInt("paymentState"));
					grouporderVO.setGiftVoucher(rs.getInt("giftVoucher"));
					grouporderVO.setContactNumber(rs.getString("contactNumber"));
					grouporderVO.setShippingLocation(rs.getString("shippingLocation"));

					list.add(grouporderVO);
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
