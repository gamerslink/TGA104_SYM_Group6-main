package com.group6.tibame104.productSec.model;

import java.util.*;
import java.sql.*;

public class ProductSecJDBCDAO implements ProductSecDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db06_sym?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String GET_ALL_STMT = "SELECT productSecID , productMainID, productSecName FROM productSec order by productSecID";

	@Override
	public List<ProductSecVO> getAll() {
		List<ProductSecVO> list = new ArrayList<ProductSecVO>();
		ProductSecVO productSecVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
				productSecVO = new ProductSecVO();
				productSecVO.setProductSecID(rs.getInt("productSecID"));
				productSecVO.setProductMainID(rs.getInt("productMainID"));
				productSecVO.setProductSecName(rs.getString("productSecName"));
				list.add(productSecVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {

		ProductSecJDBCDAO dao = new ProductSecJDBCDAO();

		// �d��
		List<ProductSecVO> list = dao.getAll();
		for (ProductSecVO pdsVO : list) {
			System.out.print(pdsVO.getProductSecID() + ",");
			System.out.print(pdsVO.getProductMainID() + ",");
			System.out.print(pdsVO.getProductSecName() + ",");
			System.out.println();
		}
	}
}