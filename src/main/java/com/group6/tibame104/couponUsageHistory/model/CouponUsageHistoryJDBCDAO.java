package com.group6.tibame104.couponUsageHistory.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group6.tibame104.shoppingGoldRecord.model.ShoppingGoldRecordVO;

@Repository
public class CouponUsageHistoryJDBCDAO implements CouponUsageHistoryDAO_interface{
	@Autowired
	private DataSource dataSource;
	
	
	private static final String INSERT_STMT = "INSERT INTO couponUsageHistory (memberID, couponID, usageRecord, useDate) VALUES (?, ?, ?, ?);";
	private static final String GET_ALL_STMT = "SELECT memberID,couponID,usageRecord,useDate FROM couponUsageHistory;";
	private static final String GET_ONE_STMT = "SELECT memberID, couponID, usageRecord, useDate FROM couponUsageHistory where memberID=?;";
	
	@Override
	public void insert(CouponUsageHistoryVO couponUsageHistoryVO) {
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT_STMT);
		) {
			pstmt.setInt(1, couponUsageHistoryVO.getMemberID());
			pstmt.setInt(2, couponUsageHistoryVO.getCouponID());
			pstmt.setInt(3, couponUsageHistoryVO.getUsageRecord());
			pstmt.setTimestamp(4, couponUsageHistoryVO.getUseDate());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
	

	@Override
	public List<CouponUsageHistoryVO> getAllCouponUsageHistoryVO(Integer memberID) {	
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT);
		) {
			pstmt.setInt(1, memberID);
			try (ResultSet rs = pstmt.executeQuery();){
				List<CouponUsageHistoryVO> list = new ArrayList<CouponUsageHistoryVO>();
				while (rs.next()) {
					CouponUsageHistoryVO couponUsageHistoryVO = null;
					couponUsageHistoryVO = new CouponUsageHistoryVO();
					couponUsageHistoryVO.setMemberID(rs.getInt("memberID"));
					couponUsageHistoryVO.setCouponID(rs.getInt("couponID"));
					couponUsageHistoryVO.setUsageRecord(rs.getInt("usageRecord"));
					couponUsageHistoryVO.setUseDate(rs.getTimestamp("useDate"));	
					list.add(couponUsageHistoryVO);
				}				
				return list;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<CouponUsageHistoryVO> getAll(Integer memberID) {
		List<CouponUsageHistoryVO> list = new ArrayList<CouponUsageHistoryVO>();
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT);
		) {
			pstmt.setInt(1, memberID);
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					CouponUsageHistoryVO couponUsageHistoryVO = null;
					couponUsageHistoryVO = new CouponUsageHistoryVO();
					couponUsageHistoryVO.setMemberID(rs.getInt("memberID"));
					couponUsageHistoryVO.setCouponID(rs.getInt("couponID"));
					couponUsageHistoryVO.setUsageRecord(rs.getInt("usageRecord"));
					couponUsageHistoryVO.setUseDate(rs.getTimestamp("useDate"));			
					list.add(couponUsageHistoryVO); // Store the row in the list
					
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<CouponUsageHistoryVO> getAll2() {
		List<CouponUsageHistoryVO> list = new ArrayList<CouponUsageHistoryVO>();
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT);	
		) {
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					CouponUsageHistoryVO couponUsageHistoryVO = null;
					couponUsageHistoryVO = new CouponUsageHistoryVO();
					couponUsageHistoryVO.setMemberID(rs.getInt("memberID"));
					couponUsageHistoryVO.setCouponID(rs.getInt("couponID"));
					couponUsageHistoryVO.setUsageRecord(rs.getInt("usageRecord"));
					couponUsageHistoryVO.setUseDate(rs.getTimestamp("useDate"));			
					list.add(couponUsageHistoryVO); // Store the row in the list
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
//	public static void main(String[] args) {
//		CouponUsageHistoryJDBCDAO test = new CouponUsageHistoryJDBCDAO();
//		List<CouponUsageHistoryVO> list = test.getAll(1);
//		
//		for(CouponUsageHistoryVO vo : list) {
//			System.out.println(vo.getCouponID());
//			System.out.println(vo.getMemberID());
//		}
//		
//		CouponUsageHistoryVO couponUsageHistoryVO = new CouponUsageHistoryVO();
//		couponUsageHistoryVO.setMemberID(1);
//		couponUsageHistoryVO.setCouponID(5);
//		couponUsageHistoryVO.setUsageRecord(1);
//		couponUsageHistoryVO.setUseDate(java.sql.Timestamp.valueOf("1999-11-11 11:11:11"));
//		
		
//		dao.insert(couponUsageHistoryVO);
//	}

}
