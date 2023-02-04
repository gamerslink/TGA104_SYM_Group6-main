package com.group6.tibame104.orderlist.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class OrderlistDAO implements OrderlistDAO_interface {
	@Autowired
	private DataSource dataSource;
	
	private static final String INSERT_STMT = "INSERT INTO orderDetail (orderID, productID, productName, userAccount, orderDate,"
			+ "			quantity ,price ,subTotal, shopComment, buyerComment, buyerCommentPic)"
			+ "			VALUES (?, ?, ?, ?, NOW(), ?, ?, ?, ?, ?, ?)";
	private static final String GET_ONE_STMT = 
		"SELECT orderDetailID, orderID, productID, productName, userAccount, orderDate, quantity ,price ,"
		     + "subTotal, shopReview,shopComment, buyerReview, buyerComment, buyerCommentPic"
		     + " FROM orderDetail where orderDetailID = ?";
	private static final String GET_ALL_STMT = "SELECT orderDetailID, orderID, productID, productName, userAccount, orderDate,quantity ,price ,"
			+ "			subTotal, shopReview,shopComment, buyerReview, buyerComment, buyerCommentPic "
			+ "				FROM orderDetail where orderID = ?";
	private static final String UPDATE = 
		"UPDATE orderDetail set buyerReview=?, buyerComment=?, buyerCommentPic=?, orderDate=NOW() where orderDetailID = ?";
	
	private static final String GET_ONE_STMT_PRODUCT = "SELECT orderDetailID, orderID, productID, userAccount, orderDate,buyerReview, buyerComment, buyerCommentPic"
		     + " FROM orderDetail where productID = ?";
	
	private static final String GET_QUANTITY = "select sum(quantity) from orderDetail where productID = ?";

	public List<OrderlistVO> findByOrderID(Integer orderID) {
		List<OrderlistVO> list = new ArrayList<OrderlistVO>();
		OrderlistVO orderlistVO = null;
		

		try (Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT);) {

			pstmt.setInt(1, orderID);
		
			try (ResultSet rs = pstmt.executeQuery();){

			while (rs.next()) {
				// orderlistVo 也稱為 Domain objects
				orderlistVO = new OrderlistVO();
				orderlistVO.setOrderDetailID(rs.getInt("orderDetailID"));
				orderlistVO.setOrderID(rs.getInt("orderID"));			
				orderlistVO.setProductID(rs.getInt("productID"));
				orderlistVO.setProductName(rs.getString("productName"));			
				orderlistVO.setOrderDate(rs.getTimestamp("orderDate"));			
				orderlistVO.setUserAccount(rs.getString("userAccount"));			
				orderlistVO.setQuantity(rs.getInt("quantity"));
				orderlistVO.setPrice(rs.getInt("price"));
				orderlistVO.setSubTotal(rs.getInt("subTotal"));
				orderlistVO.setShopReview(rs.getInt("shopReview"));
				orderlistVO.setShopComment(rs.getString("shopComment"));
				orderlistVO.setBuyerReview(rs.getInt("buyerReview"));
				orderlistVO.setBuyerComment(rs.getString("buyerComment"));
				orderlistVO.setBuyerCommentPic(rs.getBytes("buyerCommentPic"));
				list.add(orderlistVO);

			}
			}
			// Handle any driver errors
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
				

				
	}
	
	@Override
	public void insert(OrderlistVO orderlistVO) {
	

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_STMT)){
			pstmt.setInt(1,orderlistVO.getOrderID());
			pstmt.setInt(2, orderlistVO.getProductID());
			pstmt.setString(3, orderlistVO.getProductName());
			pstmt.setString(4, orderlistVO.getUserAccount());
			pstmt.setInt(5, orderlistVO.getQuantity());
			pstmt.setInt(6, orderlistVO.getPrice());
			pstmt.setInt(7, orderlistVO.getSubTotal());
			
			pstmt.setString(8, orderlistVO.getShopComment());
			
			pstmt.setString(9, orderlistVO.getBuyerComment());
			pstmt.setBytes(10, orderlistVO.getBuyerCommentPic());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void update(Integer orderDetailID, Integer buyerReview, String buyerComment, byte[] pic) {
		
		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt =  con.prepareStatement(UPDATE);){
			pstmt.setInt(1, buyerReview);
			pstmt.setString(2, buyerComment);
			pstmt.setBytes(3, pic);			
			pstmt.setInt(4, orderDetailID);

			pstmt.executeUpdate();
			System.out.println(buyerReview);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public OrderlistVO findByOrderlistID(Integer orderlistID) {
		
		OrderlistVO orderlistVO = null;

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT); ){
			pstmt.setInt(1, orderlistID);

			
			try (ResultSet rs = pstmt.executeQuery();){
				while (rs.next()) {
				// orderlistVo 也稱為 Domain objects
				orderlistVO = new OrderlistVO();
				orderlistVO.setOrderDetailID(rs.getInt("orderDetailID"));
				orderlistVO.setOrderID(rs.getInt("orderID"));			
				orderlistVO.setProductName(rs.getString("productName"));
				orderlistVO.setUserAccount(rs.getString("userAccount"));
				orderlistVO.setOrderDate(rs.getTimestamp("orderDate"));	
				orderlistVO.setProductID(rs.getInt("productID"));
				orderlistVO.setQuantity(rs.getInt("quantity"));
				orderlistVO.setPrice(rs.getInt("price"));
				orderlistVO.setSubTotal(rs.getInt("subTotal"));
				orderlistVO.setShopReview(rs.getInt("shopReview"));
				orderlistVO.setShopComment(rs.getString("shopComment"));
				orderlistVO.setBuyerReview(rs.getInt("buyerReview"));
				orderlistVO.setBuyerComment(rs.getString("buyerComment"));
				orderlistVO.setBuyerCommentPic(rs.getBytes("buyerCommentPic"));
	 }
			
				
	}
			} catch (Exception e) {
				e.printStackTrace();
		} 
		return orderlistVO;
				
	}

	@Override
	public List<OrderlistVO> findByProductID(Integer productID, Boolean all) {
		
		OrderlistVO orderlistVO = null;
		List<OrderlistVO> list = new ArrayList<OrderlistVO>();
	
		
		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT_PRODUCT); ){
			pstmt.setInt(1, productID);

			try (ResultSet rs = pstmt.executeQuery();){
				while (rs.next()) {
				// orderlistVo 也稱為 Domain objects
				orderlistVO = new OrderlistVO();
					
							
				orderlistVO.setOrderDetailID(rs.getInt("orderDetailID"));
				orderlistVO.setOrderID(rs.getInt("orderID"));
				orderlistVO.setProductID(rs.getInt("productID"));
				orderlistVO.setUserAccount(rs.getString("userAccount"));
				orderlistVO.setOrderDate(rs.getTimestamp("orderDate"));	
				orderlistVO.setBuyerReview(rs.getInt("buyerReview"));
				orderlistVO.setBuyerComment(rs.getString("buyerComment"));
				orderlistVO.setBuyerCommentPic(rs.getBytes("buyerCommentPic"));
				if(all == true) {
					list.add(orderlistVO);
				} else if(all == false) {
					if(orderlistVO.getBuyerComment() != null && orderlistVO.getBuyerReview() != null )
						list.add(orderlistVO);
				}
			}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}

	@Override
	public int findquantityByProductID(Integer productID) {
		
		int quantity = 0 ;
	
		
		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_QUANTITY); ){
			pstmt.setInt(1, productID);

			try (ResultSet rs = pstmt.executeQuery();){
				while (rs.next()) {
						
				quantity = rs.getInt("sum(quantity)");
		
			}
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return quantity ;
	}







	
//	public static void main(String[] args) {
//		OrderlistDAO dao = new OrderlistDAO();
//		List<OrderlistVO> list = dao.findByOrderID(12);
//		for (OrderlistVO orderlistVO : list) {
//			System.out.print(orderlistVO.getOrderDetailID() + ",");
//			System.out.print(orderlistVO.getOrderID() + ",");
//			System.out.print(orderlistVO.getProductID() + ",");
//			System.out.print(orderlistVO.getQuantity() + ",");
//			System.out.print(orderlistVO.getPrice() + ",");
//			System.out.print(orderlistVO.getSubTotal() + ",");
//			System.out.print(orderlistVO.getShopReview() + ",");
//			System.out.print(orderlistVO.getShopComment()+ ",");
//			System.out.print(orderlistVO.getBuyerReview()+ ",");
//			System.out.print(orderlistVO.getBuyerComment()+ ",");
//			System.out.println();
//			
//			
//			
//		}
	

	}
	

