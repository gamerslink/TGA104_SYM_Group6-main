package com.group6.tibame104.productMain.model;

import java.util.*;
import java.sql.*;

public class ProductMainJDBCDAO implements ProductMainDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db06_sym?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String GET_ALL_STMT = "SELECT productMainID , productMainName FROM productMain order by productMainID";

	@Override
	public List<ProductMainVO> getAll() {
		List<ProductMainVO> list = new ArrayList<ProductMainVO>();
		ProductMainVO productMainVO = null;

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
				productMainVO = new ProductMainVO();
				productMainVO.setProductMainID(rs.getInt("productMainID"));
				productMainVO.setProductMainName(rs.getString("productMainName"));
				list.add(productMainVO); // Store the row in the list
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

		ProductMainJDBCDAO dao = new ProductMainJDBCDAO();

		// �d��
		List<ProductMainVO> list = dao.getAll();
		for (ProductMainVO pdmVO : list) {
			System.out.print(pdmVO.getProductMainID() + ",");
			System.out.print(pdmVO.getProductMainName() + ",");
			System.out.println();
		}
	}
}