package com.group6.tibame104.group.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository
public class GroupJDBCDAO implements GroupDAO_interface {
//	@Autowired
	private DataSource dataSource;

	private static final String UPDATE = "UPDATE groupBuying set groupBuyProductID=?,administratorID=?,groupBuyProductOrderTotal=?,groupBuyingState=?,groupBuyingOnLoadDate=?,groupBuyingOffLoadDate=?,updateTime= ? WHERE groupBuyID = ?";
	private static final String DELETE = "DELETE FROM groupBuying where groupBuyID = ?";
	private static final String GET_ONE_STMT = "SELECT groupBuyID,groupBuyProductID,administratorID,groupBuyProductOrderTotal,groupBuyingState,groupBuyingOnLoadDate,groupBuyingOffLoadDate,updateTime FROM groupBuying where groupBuyID = ?";
	private static final String GET_ALL_STMT = "SELECT groupBuyID,groupBuyProductID,administratorID,groupBuyProductOrderTotal,groupBuyingState,groupBuyingOnLoadDate,groupBuyingOffLoadDate,updateTime FROM groupBuying";
	private static final String UPDATE_ONE_QUA = "UPDATE groupBuying set groupBuyProductOrderTotal=? WHERE groupBuyID = ?";

	private static final String INSERT_STMT = "INSERT INTO groupBuying (groupBuyProductID,administratorID,groupBuyProductOrderTotal,groupBuyingState,groupBuyingOnLoadDate,groupBuyingOffLoadDate,updateTime) VALUES(?,?,?,?,?,?,?)";
	@Override
	public void insert(GroupVO groupVO) {

		try (Connection con = dataSource.getConnection(); 
			 PreparedStatement pstmt = con.prepareStatement(INSERT_STMT)) {

			pstmt.setInt(1, groupVO.getGroupBuyProductID());
			pstmt.setInt(2, groupVO.getAdministratorID());
			pstmt.setInt(3, groupVO.getGroupBuyProductOrderTotal());
			pstmt.setBoolean(4, groupVO.getGroupBuyingState());
			pstmt.setTimestamp(5, groupVO.getGroupBuyingOnLoadDate());
			pstmt.setTimestamp(6, groupVO.getGroupBuyingOffLoadDate());
			pstmt.setTimestamp(7, groupVO.getUpdateTime());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 更新
	@Override
	public void update(GroupVO groupVO) {

		try (Connection con = dataSource.getConnection(); 
			 PreparedStatement pstmt = con.prepareStatement(UPDATE)) {

			pstmt.setInt(1, groupVO.getGroupBuyProductID());
			pstmt.setInt(2, groupVO.getAdministratorID());
			pstmt.setInt(3, groupVO.getGroupBuyProductOrderTotal());
			pstmt.setBoolean(4, groupVO.getGroupBuyingState());
			pstmt.setTimestamp(5, groupVO.getGroupBuyingOnLoadDate());
			pstmt.setTimestamp(6, groupVO.getGroupBuyingOffLoadDate());
			pstmt.setTimestamp(7, groupVO.getUpdateTime());
			pstmt.setInt(8, groupVO.getGroupBuyID());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 購買後更新團購總數
	@Override
	public void updateGroupQua(GroupVO groupVO) {

		try (Connection con = dataSource.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(UPDATE_ONE_QUA)) {

			pstmt.setInt(1, groupVO.getGroupBuyProductOrderTotal());
			pstmt.setInt(2, groupVO.getGroupBuyID());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 刪除
	@Override
	public void delete(Integer grouporderID) {

		try (Connection con = dataSource.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(DELETE);) {

			pstmt.setInt(1, grouporderID);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 查詢單一
	@Override
	public GroupVO findByPrimaryKey(Integer groupBuyID) {

		try (Connection con = dataSource.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT);) {

			pstmt.setInt(1, groupBuyID);
			try (ResultSet rs = pstmt.executeQuery()) {

				if (rs.next()) {
					// empVo 也稱為 Domain objects
					GroupVO groupVO = new GroupVO();

					groupVO.setGroupBuyID(rs.getInt("groupBuyID"));
					groupVO.setGroupBuyProductID(rs.getInt("groupBuyProductID"));
					groupVO.setAdministratorID(rs.getInt("administratorID"));
					groupVO.setGroupBuyProductOrderTotal(rs.getInt("groupBuyProductOrderTotal"));
					groupVO.setGroupBuyingState(rs.getBoolean("groupBuyingState"));
					groupVO.setGroupBuyingOnLoadDate(rs.getTimestamp("groupBuyingOnLoadDate"));
					groupVO.setGroupBuyingOffLoadDate(rs.getTimestamp("groupBuyingOffLoadDate"));
					groupVO.setUpdateTime(rs.getTimestamp("updateTime"));
					return groupVO;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<GroupVO> getAll() {

		try (Connection con = dataSource.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT);) {

			try (ResultSet rs = pstmt.executeQuery()) {
				
				List<GroupVO> list = new ArrayList<GroupVO>();

				while (rs.next()) {
					GroupVO groupVO = new GroupVO();

					groupVO.setGroupBuyID(rs.getInt("groupBuyID"));
					groupVO.setGroupBuyProductID(rs.getInt("groupBuyProductID"));
					groupVO.setAdministratorID(rs.getInt("AdministratorID"));
					groupVO.setGroupBuyProductOrderTotal(rs.getInt("groupBuyProductOrderTotal"));
					groupVO.setGroupBuyingState(rs.getBoolean("groupBuyingState"));
					groupVO.setGroupBuyingOnLoadDate(rs.getTimestamp("groupBuyingOnLoadDate"));
					groupVO.setGroupBuyingOffLoadDate(rs.getTimestamp("groupBuyingOffLoadDate"));
					groupVO.setUpdateTime(rs.getTimestamp("updateTime"));

					list.add(groupVO);
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private static final String ORDERBY = "SELECT groupBuyID,groupBuyProductID,administratorID,groupBuyProductOrderTotal,groupBuyingState,groupBuyingOnLoadDate,groupBuyingOffLoadDate,updateTime FROM groupBuying order by groupBuyProductOrderTotal desc";
	public List<GroupVO> orderBy() {

		try (Connection con = dataSource.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(ORDERBY);) {

			try (ResultSet rs = pstmt.executeQuery()) {
				
				List<GroupVO> list = new ArrayList<GroupVO>();

				while (rs.next()) {
					GroupVO groupVO = new GroupVO();

					groupVO.setGroupBuyID(rs.getInt("groupBuyID"));
					groupVO.setGroupBuyProductID(rs.getInt("groupBuyProductID"));
					groupVO.setAdministratorID(rs.getInt("AdministratorID"));
					groupVO.setGroupBuyProductOrderTotal(rs.getInt("groupBuyProductOrderTotal"));
					groupVO.setGroupBuyingState(rs.getBoolean("groupBuyingState"));
					groupVO.setGroupBuyingOnLoadDate(rs.getTimestamp("groupBuyingOnLoadDate"));
					groupVO.setGroupBuyingOffLoadDate(rs.getTimestamp("groupBuyingOffLoadDate"));
					groupVO.setUpdateTime(rs.getTimestamp("updateTime"));

					list.add(groupVO);
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Object> getJoinAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GroupVO> getAllDesc() {
		// TODO Auto-generated method stub
		return null;
	}

}
