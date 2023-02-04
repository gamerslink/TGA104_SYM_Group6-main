package com.group6.tibame104.product.model;

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

@Repository
public class ProductJDBCDAO implements ProductDAO_interface {

	@Autowired
	private DataSource dataSource;

	private static final String INSERT_STMT = "INSERT INTO product (storeID,productSecID,productName,productStock,productPrice,productDesc,source,productImg"
			+ ",productImg2,productImg3,insertTime,productStatus,commentTotal,commentAvgStar) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), ?, 0, 0)";

	private static final String GET_ALL_STMT = "SELECT productID , storeID , productSecID,productName,productStock,productPrice,productDesc,source,productImg"
			+ ",productImg2,productImg3,productStatus,commentTotal,commentAvgStar FROM product";

	private static final String GET_ALL_STMT_BY_PRODUCT_NAME = "SELECT productID , storeID , productSecID,productName,productStock,productPrice,productDesc,source,productImg"
			+ ",productImg2,productImg3,productStatus,commentTotal,commentAvgStar FROM product where productName like ?";

	private static final String GET_ONE_STMT = "SELECT productID , storeID , productSecID,productName,productStock,productPrice,productDesc,source,productImg"
			+ ",productImg2,productImg3,productStatus,commentTotal,commentAvgStar FROM product where productID = ?";

	private static final String UPDATE = "UPDATE product set productSecID=?, productName=?, productStock=?, productPrice=?, productDesc=?, source=?, productImg=?,"
			+ "productImg2=?,productImg3=? where productID = ?";

	private static final String GET_MAX_ID = "select max(productID) as productID from product";

	private static final String UPDATE_PUT_ON = "UPDATE product set productStatus= 1 where productID = ?";

	private static final String UPDATE_PUT_OFF = "UPDATE product set productStatus= 0 where productID = ?";

	@Override
	public void insert(ProductVO productVO) {

		try (Connection con = dataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(INSERT_STMT)) {

			pstmt.setInt(1, productVO.getStoreID());
			pstmt.setInt(2, productVO.getProductSecID());
			pstmt.setString(3, productVO.getProductName());
			pstmt.setInt(4, productVO.getProductStock());
			pstmt.setInt(5, productVO.getProductPrice());
			pstmt.setString(6, productVO.getProductDesc());
			pstmt.setString(7, productVO.getSource());
			pstmt.setBytes(8, productVO.getProductImg());
			pstmt.setBytes(9, productVO.getProductImg2());
			pstmt.setBytes(10, productVO.getProductImg3());
			pstmt.setBoolean(11, productVO.getProductStatus());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(ProductVO productVO) {

		try (Connection con = dataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(UPDATE)) {

			pstmt.setInt(1, productVO.getProductSecID());
			pstmt.setString(2, productVO.getProductName());
			pstmt.setInt(3, productVO.getProductStock());
			pstmt.setInt(4, productVO.getProductPrice());
			pstmt.setString(5, productVO.getProductDesc());
			pstmt.setString(6, productVO.getSource());
			pstmt.setBytes(7, productVO.getProductImg());
			pstmt.setBytes(8, productVO.getProductImg2());
			pstmt.setBytes(9, productVO.getProductImg3());
			pstmt.setInt(10, productVO.getProductID());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ProductVO findByPrimaryKey(Integer ProductID) {

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT)) {

			pstmt.setInt(1, ProductID);

			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					ProductVO productVO = new ProductVO();
					productVO.setProductID(rs.getInt("productID"));
					productVO.setStoreID(rs.getInt("storeID"));
					productVO.setProductSecID(rs.getInt("productSecID"));
					productVO.setProductName(rs.getString("productName"));
					productVO.setProductStock(rs.getInt("productStock"));
					productVO.setProductPrice(rs.getInt("productPrice"));
					productVO.setProductDesc(rs.getString("productDesc"));
					productVO.setSource(rs.getString("source"));
					productVO.setProductImg(rs.getBytes("productImg"));
					productVO.setProductImg2(rs.getBytes("productImg2"));
					productVO.setProductImg3(rs.getBytes("productImg3"));
					productVO.setProductStatus(rs.getBoolean("productStatus"));
					productVO.setCommentTotal(rs.getInt("commentTotal"));
					productVO.setCommentAvgStar(rs.getDouble("commentTotal"));
					return productVO;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProductVO> getAll() {

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT)) {

			try (ResultSet rs = pstmt.executeQuery()) {
				List<ProductVO> list = new ArrayList<ProductVO>();
				while (rs.next()) {
					// empVO 嚙稽嚙誶穿蕭 Domain objects

					ProductVO productVO = new ProductVO();
					productVO.setProductID(rs.getInt("productID"));
					productVO.setStoreID(rs.getInt("storeID"));
					productVO.setProductSecID(rs.getInt("productSecID"));
					productVO.setProductName(rs.getString("productName"));
					productVO.setProductStock(rs.getInt("productStock"));
					productVO.setProductPrice(rs.getInt("productPrice"));
					productVO.setProductDesc(rs.getString("productDesc"));
					productVO.setSource(rs.getString("source"));
					productVO.setProductImg(rs.getBytes("productImg"));
					productVO.setProductImg2(rs.getBytes("productImg2"));
					productVO.setProductImg3(rs.getBytes("productImg3"));
					productVO.setProductStatus(rs.getBoolean("productStatus"));
					productVO.setCommentTotal(rs.getInt("commentTotal"));
					productVO.setCommentAvgStar(rs.getDouble("commentTotal"));
					list.add(productVO); // Store the row in the list
				}
				return list;
			}
			// Handle any driver errors
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProductVO> getAll(String productName) {

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT_BY_PRODUCT_NAME)) {

			pstmt.setString(1, "%" + productName + "%");
			try (ResultSet rs = pstmt.executeQuery()) {
				List<ProductVO> list = new ArrayList<ProductVO>();
				while (rs.next()) {
					// empVO 嚙稽嚙誶穿蕭 Domain objects
					ProductVO productVO = new ProductVO();
					productVO.setProductID(rs.getInt("productID"));
					productVO.setStoreID(rs.getInt("storeID"));
					productVO.setProductSecID(rs.getInt("productSecID"));
					productVO.setProductName(rs.getString("productName"));
					productVO.setProductStock(rs.getInt("productStock"));
					productVO.setProductPrice(rs.getInt("productPrice"));
					productVO.setProductDesc(rs.getString("productDesc"));
					productVO.setSource(rs.getString("source"));
					productVO.setProductImg(rs.getBytes("productImg"));
					productVO.setProductImg2(rs.getBytes("productImg2"));
					productVO.setProductImg3(rs.getBytes("productImg3"));
					productVO.setProductStatus(rs.getBoolean("productStatus"));
					productVO.setCommentTotal(rs.getInt("commentTotal"));
					productVO.setCommentAvgStar(rs.getDouble("commentTotal"));
					list.add(productVO); // Store the row in the list
				}
				return list;
			}
			// Handle any driver errors
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer findMaxID() {

		try (Connection con = dataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_MAX_ID)) {

			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					Integer productID = rs.getInt("productID");
					return productID;
				}

				// Handle any driver errors
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProductVO> getAllByCond(String quryString) {

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT + quryString);) {

			try (ResultSet rs = pstmt.executeQuery()) {
				List<ProductVO> list = new ArrayList<ProductVO>();
				while (rs.next()) {
					// empVO 嚙稽嚙誶穿蕭 Domain objects
					ProductVO productVO = new ProductVO();
					productVO.setProductID(rs.getInt("productID"));
					productVO.setStoreID(rs.getInt("storeID"));
					productVO.setProductSecID(rs.getInt("productSecID"));
					productVO.setProductName(rs.getString("productName"));
					productVO.setProductStock(rs.getInt("productStock"));
					productVO.setProductPrice(rs.getInt("productPrice"));
					productVO.setProductDesc(rs.getString("productDesc"));
					productVO.setSource(rs.getString("source"));
					productVO.setProductImg(rs.getBytes("productImg"));
					productVO.setProductImg2(rs.getBytes("productImg2"));
					productVO.setProductImg3(rs.getBytes("productImg3"));
					productVO.setProductStatus(rs.getBoolean("productStatus"));
					productVO.setCommentTotal(rs.getInt("commentTotal"));
					productVO.setCommentAvgStar(rs.getDouble("commentTotal"));
					list.add(productVO); // Store the row in the list
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void putOn(Integer productID) {
		ProductVO productVO = null;

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(UPDATE_PUT_ON)) {

			pstmt.setInt(1, productID);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void putOff(Integer productID) {
		ProductVO productVO = null;

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(UPDATE_PUT_OFF)) {
			pstmt.setInt(1, productID);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}