package com.group6.tibame104.category.model;

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
import com.group6.tibame104.product.model.ProductVO;

@Repository
public class CategoryDAO implements CategoryDAO_interface {

	@Autowired
	private DataSource dataSource;

	
	private static final String GET_NAME = "SELECT * FROM category where productName like ? ";
	private static final String GET_NOT_NAME = "SELECT * FROM category where productName not like ? ";
	private static final String GET_PRODUCTID = "SELECT * FROM category where productID= ? ";
	private static final String GET_SEC = "SELECT * FROM category where productSecID= ? ";
	private static final String GET_MAIN = "SELECT * FROM category where productMainID= ? ";
	private static final String GET_NOT_MAIN = "SELECT * FROM category where productMainID != ? ";
	private static final String GET_STOREID = "SELECT * FROM category where storeID= ? ";
	private static final String GET_ALL = "SELECT * FROM category ";
	private static final String GET_ALL_CATEGORY = "select distinct productMainName from category";
	private static final String UPDATE = "update category "
			                     + "	set commentAvgStar =(SELECT avg(buyerReview) FROM orderDetail "
			                      + "	where productID = ?) where  productID = ?";

	
	@Override
	public List<CategoryVO> getbyProductName(String productName, Boolean correct){
		List<CategoryVO> list = new ArrayList<CategoryVO>();
		CategoryVO categoryVO = null;
		
		String sql=null;
		if(correct==true) {
			sql=GET_NAME;
		}
		else {
			sql=GET_NOT_NAME;
		}
		
		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, "%" + productName + "%");

			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					
					categoryVO = new CategoryVO();
					categoryVO.setProductID(rs.getInt("productID"));
					categoryVO.setStoreID(rs.getInt("storeID"));				
					categoryVO.setProductName(rs.getString("productName"));
					categoryVO.setProductStock(rs.getInt("productStock"));
					categoryVO.setProductPrice(rs.getInt("productPrice"));
					categoryVO.setProductDesc(rs.getString("productDesc"));
					categoryVO.setSource(rs.getString("source"));
					categoryVO.setProductImg(rs.getBytes("productImg"));
					categoryVO.setProductImg2(rs.getBytes("productImg2"));
					categoryVO.setProductImg3(rs.getBytes("productImg3"));
					categoryVO.setInsertTime(rs.getTimestamp("insertTime"));
					categoryVO.setProductStatus(rs.getBoolean("productStatus"));
					categoryVO.setCommentTotal(rs.getInt("commentTotal"));
					categoryVO.setCommentAvgStar(rs.getDouble("commentAvgStar"));	
					categoryVO.setStoreName(rs.getString("storeName"));
					categoryVO.setStoreAddress(rs.getString("storeAddress"));
					categoryVO.setPhoneNumber(rs.getString("phoneNumber"));
					categoryVO.setProductSecID(rs.getInt("productSecID"));
					categoryVO.setProductSecName(rs.getString("productSecName"));
					categoryVO.setProductMainID(rs.getInt("productMainID"));
					categoryVO.setProductMainName(rs.getString("productMainName"));
					list.add(categoryVO);
			
					
				}
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

			return list;
	
	}
	
	@Override
	public CategoryVO getbyProductID(Integer productID) {
		
		CategoryVO categoryVO = null;

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_PRODUCTID);) {

			pstmt.setInt(1, productID);

			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {

					categoryVO = new CategoryVO();
					categoryVO.setProductID(rs.getInt("productID"));
					categoryVO.setStoreID(rs.getInt("storeID"));				
					categoryVO.setProductName(rs.getString("productName"));
					categoryVO.setProductStock(rs.getInt("productStock"));
					categoryVO.setProductPrice(rs.getInt("productPrice"));
					categoryVO.setProductDesc(rs.getString("productDesc"));
					categoryVO.setSource(rs.getString("source"));
					categoryVO.setProductImg(rs.getBytes("productImg"));
					categoryVO.setProductImg2(rs.getBytes("productImg2"));
					categoryVO.setProductImg3(rs.getBytes("productImg3"));
					categoryVO.setInsertTime(rs.getTimestamp("insertTime"));
					categoryVO.setProductStatus(rs.getBoolean("productStatus"));
					categoryVO.setCommentTotal(rs.getInt("commentTotal"));
					categoryVO.setCommentAvgStar(rs.getDouble("commentAvgStar"));	
					categoryVO.setStoreName(rs.getString("storeName"));
					categoryVO.setStoreAddress(rs.getString("storeAddress"));
					categoryVO.setPhoneNumber(rs.getString("phoneNumber"));
					categoryVO.setProductSecID(rs.getInt("productSecID"));
					categoryVO.setProductSecName(rs.getString("productSecName"));
					categoryVO.setProductMainID(rs.getInt("productMainID"));
					categoryVO.setProductMainName(rs.getString("productMainName"));
					
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryVO;

	}
	
	
	@Override
	public List<CategoryVO> getbyProductSecID(Integer productSecID) {
		List<CategoryVO> list = new ArrayList<CategoryVO>();
		CategoryVO categoryVO = null;

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_SEC);) {

			pstmt.setInt(1, productSecID);

			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {

					categoryVO = new CategoryVO();
					categoryVO.setProductID(rs.getInt("productID"));
					categoryVO.setStoreID(rs.getInt("storeID"));				
					categoryVO.setProductName(rs.getString("productName"));
					categoryVO.setProductStock(rs.getInt("productStock"));
					categoryVO.setProductPrice(rs.getInt("productPrice"));
					categoryVO.setProductDesc(rs.getString("productDesc"));
					categoryVO.setSource(rs.getString("source"));
					categoryVO.setProductImg(rs.getBytes("productImg"));
					categoryVO.setProductImg2(rs.getBytes("productImg2"));
					categoryVO.setProductImg3(rs.getBytes("productImg3"));
					categoryVO.setInsertTime(rs.getTimestamp("insertTime"));
					categoryVO.setProductStatus(rs.getBoolean("productStatus"));
					categoryVO.setCommentTotal(rs.getInt("commentTotal"));
					categoryVO.setCommentAvgStar(rs.getDouble("commentAvgStar"));	
					categoryVO.setStoreName(rs.getString("storeName"));
					categoryVO.setStoreAddress(rs.getString("storeAddress"));
					categoryVO.setPhoneNumber(rs.getString("phoneNumber"));
					categoryVO.setProductSecID(rs.getInt("productSecID"));
					categoryVO.setProductSecName(rs.getString("productSecName"));
					categoryVO.setProductMainID(rs.getInt("productMainID"));
					categoryVO.setProductMainName(rs.getString("productMainName"));
					list.add(categoryVO);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}


	@Override
	public List<CategoryVO> getbyProductMainID(Integer productMainID, Boolean correct) {
		List<CategoryVO> list = new ArrayList<CategoryVO>();
		CategoryVO categoryVO = null;
		
		String sql=null;
		if(correct == true)
			sql = GET_MAIN;
		else
			sql = GET_NOT_MAIN;

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setInt(1, productMainID);

			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {

					categoryVO = new CategoryVO();
					categoryVO.setProductID(rs.getInt("productID"));
					categoryVO.setStoreID(rs.getInt("storeID"));				
					categoryVO.setProductName(rs.getString("productName"));
					categoryVO.setProductStock(rs.getInt("productStock"));
					categoryVO.setProductPrice(rs.getInt("productPrice"));
					categoryVO.setProductDesc(rs.getString("productDesc"));
					categoryVO.setSource(rs.getString("source"));
					categoryVO.setProductImg(rs.getBytes("productImg"));
					categoryVO.setProductImg2(rs.getBytes("productImg2"));
					categoryVO.setProductImg3(rs.getBytes("productImg3"));
					categoryVO.setInsertTime(rs.getTimestamp("insertTime"));
					categoryVO.setProductStatus(rs.getBoolean("productStatus"));
					categoryVO.setCommentTotal(rs.getInt("commentTotal"));
					categoryVO.setCommentAvgStar(rs.getDouble("commentAvgStar"));	
					categoryVO.setStoreName(rs.getString("storeName"));
					categoryVO.setStoreAddress(rs.getString("storeAddress"));
					categoryVO.setPhoneNumber(rs.getString("phoneNumber"));
					categoryVO.setProductSecID(rs.getInt("productSecID"));
					categoryVO.setProductSecName(rs.getString("productSecName"));
					categoryVO.setProductMainID(rs.getInt("productMainID"));
					categoryVO.setProductMainName(rs.getString("productMainName"));
					list.add(categoryVO);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<CategoryVO> getAll() {
		List<CategoryVO> list = new ArrayList<CategoryVO>();
		CategoryVO categoryVO = null;

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ALL);) {

			

			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {

					categoryVO = new CategoryVO();
					categoryVO.setProductID(rs.getInt("productID"));
					categoryVO.setStoreID(rs.getInt("storeID"));				
					categoryVO.setProductName(rs.getString("productName"));
					categoryVO.setProductStock(rs.getInt("productStock"));
					categoryVO.setProductPrice(rs.getInt("productPrice"));
					categoryVO.setProductDesc(rs.getString("productDesc"));
					categoryVO.setSource(rs.getString("source"));
					categoryVO.setProductImg(rs.getBytes("productImg"));
					categoryVO.setProductImg2(rs.getBytes("productImg2"));
					categoryVO.setProductImg3(rs.getBytes("productImg3"));
					categoryVO.setInsertTime(rs.getTimestamp("insertTime"));
					categoryVO.setProductStatus(rs.getBoolean("productStatus"));
					categoryVO.setCommentTotal(rs.getInt("commentTotal"));
					categoryVO.setCommentAvgStar(rs.getDouble("commentAvgStar"));	
					categoryVO.setStoreName(rs.getString("storeName"));
					categoryVO.setStoreAddress(rs.getString("storeAddress"));
					categoryVO.setPhoneNumber(rs.getString("phoneNumber"));
					categoryVO.setProductSecID(rs.getInt("productSecID"));
					categoryVO.setProductSecName(rs.getString("productSecName"));
					categoryVO.setProductMainID(rs.getInt("productMainID"));
					categoryVO.setProductMainName(rs.getString("productMainName"));
					list.add(categoryVO);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<String> getAllCategory() {
		List<String> list = new ArrayList<String>();
		

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ALL_CATEGORY);) {

			

			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {

					String mainName ;
					
					mainName = rs.getString("productMainName");
					list.add(mainName);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateStar(Integer productID) {
		

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(UPDATE);) {

			pstmt.setInt(1, productID);
			pstmt.setInt(2, productID);

			pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<CategoryVO> getbyStoreID(Integer storeID) {
		List<CategoryVO> list = new ArrayList<CategoryVO>();
		CategoryVO categoryVO = null;

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_STOREID);) {

			pstmt.setInt(1, storeID);

			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {

					categoryVO = new CategoryVO();
					categoryVO.setProductID(rs.getInt("productID"));
					categoryVO.setStoreID(rs.getInt("storeID"));				
					categoryVO.setProductName(rs.getString("productName"));
					categoryVO.setProductStock(rs.getInt("productStock"));
					categoryVO.setProductPrice(rs.getInt("productPrice"));
					categoryVO.setProductDesc(rs.getString("productDesc"));
					categoryVO.setSource(rs.getString("source"));
					categoryVO.setProductImg(rs.getBytes("productImg"));
					categoryVO.setProductImg2(rs.getBytes("productImg2"));
					categoryVO.setProductImg3(rs.getBytes("productImg3"));
					categoryVO.setInsertTime(rs.getTimestamp("insertTime"));
					categoryVO.setProductStatus(rs.getBoolean("productStatus"));
					categoryVO.setCommentTotal(rs.getInt("commentTotal"));
					categoryVO.setCommentAvgStar(rs.getDouble("commentAvgStar"));	
					categoryVO.setStoreName(rs.getString("storeName"));
					categoryVO.setStoreAddress(rs.getString("storeAddress"));
					categoryVO.setPhoneNumber(rs.getString("phoneNumber"));
					categoryVO.setProductSecID(rs.getInt("productSecID"));
					categoryVO.setProductSecName(rs.getString("productSecName"));
					categoryVO.setProductMainID(rs.getInt("productMainID"));
					categoryVO.setProductMainName(rs.getString("productMainName"));
					list.add(categoryVO);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
