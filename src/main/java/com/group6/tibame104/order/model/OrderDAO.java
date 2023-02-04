package com.group6.tibame104.order.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group6.tibame104.orderlist.model.OrderlistDAO;
import com.group6.tibame104.orderlist.model.OrderlistDAO_interface;
import com.group6.tibame104.orderlist.model.OrderlistVO;

@Repository
public class OrderDAO implements OrderDAO_interface {

	@Autowired
	private DataSource dataSource;
	@Autowired
	OrderlistDAO_interface dao;

	private static final String INSERT_STMT = "INSERT INTO `order` (storeID, storeName, memberID,"
			+ "orderDate ,orderStatus,receiver, phone,creditcardNumber,"
			+ "address, payType, couponID, originalTotal, useShoppingGold, useCouponGold, finalTotal) "
			+ "VALUES (?, ?, ?, NOW(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
	private static final String GET_ONE_STMT = "SELECT orderID, storeID, storeName, memberID, orderDate ,orderStatus,receiver, phone,"
			+ "	creditcardNumber, address, payType, couponID, originalTotal, useShoppingGold,"
			+ "	useCouponGold, finalTotal FROM `order` where orderID = ? ";
	private static final String GET_ALL = "SELECT orderID, storeID, storeName, memberID, orderDate ,orderStatus,receiver, phone,"
			+ "	creditcardNumber, address, payType, couponID, originalTotal, useShoppingGold,"
			+ "	useCouponGold, finalTotal FROM `order`";
	private static final String UPDATE = "update `order` set orderStatus=? where orderID = ?";
	@Override
	public int insert(OrderVO orderVO, List<OrderlistVO> buylist) {
		Integer next_deptno = 0;
		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_STMT, Statement.RETURN_GENERATED_KEYS);) {

			pstmt.setInt(1, orderVO.getStoreID());
			pstmt.setString(2, orderVO.getStoreName());
			pstmt.setInt(3, orderVO.getMemberID());
			pstmt.setInt(4, orderVO.getOrderStatus());
			pstmt.setString(5, orderVO.getReceiver());
			pstmt.setString(6, orderVO.getPhone());
			pstmt.setString(7, orderVO.getCreditcardNumber());
			pstmt.setString(8, orderVO.getAddress());
			pstmt.setString(9, orderVO.getPayType());
			pstmt.setInt(10, orderVO.getCouponID());
			pstmt.setInt(11, orderVO.getOriginalTotal());
			pstmt.setInt(12, orderVO.getUseShoppingGold());
			pstmt.setInt(13, orderVO.getUseCouponGold());
			pstmt.setInt(14, orderVO.getFinalTotal());
			pstmt.executeUpdate();
		

			// 掘取對應的自增主鍵值
			
			try(ResultSet rs = pstmt.getGeneratedKeys();){
				if (rs.next()) {
				next_deptno = rs.getInt(1);
				System.out.println("自增主鍵值= " + next_deptno + "(剛新增成功的部門編號)");
			} else {
				System.out.println("未取得自增主鍵值");
			}
			rs.close();

			orderVO.setOrderID(next_deptno);

			
//			System.out.println("list.size()-A="+list.size());
			for (OrderlistVO orderlist : buylist) {
				orderlist.setOrderID(new Integer(next_deptno));
				dao.insert(orderlist);
			}

//			con.commit();
//			con.setAutoCommit(true)
			}
			
			

			// Handle any driver errors
		} catch (Exception e) {
			e.printStackTrace();
		}
		return next_deptno;
	}

	@Override
	public OrderVO getbyOrderID(Integer orderID) {
		OrderVO orderVO = null;

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT);) {

			pstmt.setInt(1, orderID);

			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {

					orderVO = new OrderVO();
					orderVO.setOrderID(rs.getInt("orderID"));
					orderVO.setStoreID(rs.getInt("storeID"));
					orderVO.setStoreName(rs.getString("storeName"));
					orderVO.setMemberID(rs.getInt("memberID"));
					orderVO.setOrderDate(rs.getTimestamp("orderDate"));
					orderVO.setOrderStatus(rs.getInt("orderStatus"));
					orderVO.setReceiver(rs.getString("receiver"));
					orderVO.setPhone(rs.getString("phone"));
					orderVO.setCreditcardNumber(rs.getString("creditcardNumber"));
					orderVO.setAddress(rs.getString("address"));
					orderVO.setPayType(rs.getString("payType"));
					orderVO.setCouponID(rs.getInt("couponID"));
					orderVO.setOriginalTotal(rs.getInt("originalTotal"));
					orderVO.setUseShoppingGold(rs.getInt("useShoppingGold"));
					orderVO.setUseCouponGold(rs.getInt("useCouponGold"));
					orderVO.setFinalTotal(rs.getInt("finalTotal"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderVO;

	}

	@Override
	public List<OrderVO> getAll() {
		List<OrderVO> list = new ArrayList<OrderVO>();
		OrderVO orderVO = null;

		try (Connection con = dataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_ALL);) {

			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {

					orderVO = new OrderVO();
					orderVO.setOrderID(rs.getInt("orderID"));
					orderVO.setStoreID(rs.getInt("storeID"));
					orderVO.setStoreName(rs.getString("storeName"));
					orderVO.setMemberID(rs.getInt("memberID"));
					orderVO.setOrderDate(rs.getTimestamp("orderDate"));
					orderVO.setOrderStatus(rs.getInt("orderStatus"));
					orderVO.setReceiver(rs.getString("receiver"));
					orderVO.setPhone(rs.getString("phone"));
					orderVO.setCreditcardNumber(rs.getString("creditcardNumber"));
					orderVO.setAddress(rs.getString("address"));
					orderVO.setPayType(rs.getString("payType"));
					orderVO.setCouponID(rs.getInt("couponID"));
					orderVO.setOriginalTotal(rs.getInt("originalTotal"));
					orderVO.setUseShoppingGold(rs.getInt("useShoppingGold"));
					orderVO.setUseCouponGold(rs.getInt("useCouponGold"));
					orderVO.setFinalTotal(rs.getInt("finalTotal"));
					list.add(orderVO);
				}
			}

			// Handle any driver errors
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OrderVO> getAllByComposite(Map<String, String> map) {
		List<OrderVO> list = new ArrayList<OrderVO>();
		OrderVO orderVO = null;
		String finalSQL = "select * from `order` " + jdbcUtil_CompositeQuery_Emp2.get_WhereCondition(map) ;

		try (Connection con = dataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(finalSQL);) {

			System.out.println(finalSQL);

			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					orderVO = new OrderVO();
					orderVO.setOrderID(rs.getInt("orderID"));
					orderVO.setStoreID(rs.getInt("storeID"));
					orderVO.setStoreName(rs.getString("storeName"));
					orderVO.setMemberID(rs.getInt("memberID"));
					orderVO.setOrderDate(rs.getTimestamp("orderDate"));
					orderVO.setOrderStatus(rs.getInt("orderStatus"));
					orderVO.setReceiver(rs.getString("receiver"));
					orderVO.setPhone(rs.getString("phone"));
					orderVO.setCreditcardNumber(rs.getString("creditcardNumber"));
					orderVO.setAddress(rs.getString("address"));
					orderVO.setPayType(rs.getString("payType"));
					orderVO.setCouponID(rs.getInt("couponID"));
					orderVO.setOriginalTotal(rs.getInt("originalTotal"));
					orderVO.setUseShoppingGold(rs.getInt("useShoppingGold"));
					orderVO.setUseCouponGold(rs.getInt("useCouponGold"));
					orderVO.setFinalTotal(rs.getInt("finalTotal"));
					list.add(orderVO);
				}
			}

			// Handle any SQL errors
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public void updateOrder(Integer orderID, Integer orderStatus) {
		
		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(UPDATE);) {

			pstmt.setInt(1, orderStatus);
			pstmt.setInt(2, orderID);
		
			pstmt.executeUpdate();
		

			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
