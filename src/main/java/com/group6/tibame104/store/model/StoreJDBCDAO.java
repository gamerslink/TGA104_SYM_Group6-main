package com.group6.tibame104.store.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreJDBCDAO implements StoreDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db06_sym?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String GET_ONE_STMT = "SELECT storeID,storeName,storeDelBankCode,storeBankAccount,storeAddress,phoneNumber,createDate"
			+ ",taxID,storeAuditStatus FROM store where memberID = ?";
	private static final String UPDATE = "UPDATE store set memberID=?, storeName=?, storeDelBankCode=?, storeBankAccount=?, storeAddress=?, phoneNumber=?,"
			+ "updateDate=now(),taxID=? where storeID = ?";
	private static final String INSERT_STMT = "INSERT INTO store (memberID,storeName,storeDelBankCode,storeBankAccount,storeAddress,phoneNumber,createDate,updateDate,taxID,storeAuditStatus) "
			+ "VALUES (?, ?, ?, ?, ?, ?, now(), now(), ?, 0)";
	private static final String UPDATE_STATUS = "UPDATE store set storeAuditStatus =1 where memberID = ?";

	private static final String GET_All_STMT_BY_AUDI_0 = "SELECT memberID,storeName,storeAddress,phoneNumber,createDate,updateDate,taxID,storeAuditStatus FROM store where storeAuditStatus = 0";

	private static final String GET_STORE_MEMBERID = "SELECT memberID FROM store where storeID = ?";

	@Override
	public void update(StoreVO storeVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, storeVO.getMemberID());
			pstmt.setString(2, storeVO.getStoreName());
			pstmt.setString(3, storeVO.getStoreDelBankCode());
			pstmt.setString(4, storeVO.getStoreBankAccount());
			pstmt.setString(5, storeVO.getStoreAddress());
			pstmt.setString(6, storeVO.getPhoneNumber());
			pstmt.setString(7, storeVO.getTaxID());
			pstmt.setInt(8, storeVO.getMemberID());
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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

	}

	@Override
	public StoreVO findByPrimaryKey(Integer memberID) {

		StoreVO storeVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, memberID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				storeVO = new StoreVO();
				storeVO.setStoreID(rs.getInt("storeID"));
				storeVO.setStoreName(rs.getString("storeName"));
				storeVO.setStoreDelBankCode(rs.getString("storeDelBankCode"));
				storeVO.setStoreBankAccount(rs.getString("storeBankAccount"));
				storeVO.setStoreAddress(rs.getString("storeAddress"));
				storeVO.setPhoneNumber(rs.getString("phoneNumber"));
				storeVO.setCreateDate(rs.getTimestamp("createDate"));
				storeVO.setTaxID(rs.getString("taxID"));
				storeVO.setStoreAuditStatus(rs.getInt("storeAuditStatus"));
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
		return storeVO;
	}

	@Override
	public void insert(StoreVO storeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

//			private static final String INSERT_STMT = "INSERT INTO store 
//			(memberID,storeName,storeDelBankCode,storeBankAccount,storeAddress,
//			phoneNumber,createDate,updateDate,taxID,storeAuditStatus) "
//					+ "VALUES (?, ?, ?, ?, ?, ?, now(), now(), ?, 0)";
			pstmt.setInt(1, storeVO.getMemberID());
			pstmt.setString(2, storeVO.getStoreName());
			pstmt.setString(3, storeVO.getStoreDelBankCode());
			pstmt.setString(4, storeVO.getStoreBankAccount());
			pstmt.setString(5, storeVO.getStoreAddress());
			pstmt.setString(6, storeVO.getPhoneNumber());
			pstmt.setString(7, storeVO.getTaxID());

			pstmt.executeUpdate();

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
	}

	@Override
	public void pass(Integer memberID) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STATUS);

			pstmt.setInt(1, memberID);
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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

	}

	@Override
	public List<StoreVO> findAllByAudit0() {
		Connection con = null;
		PreparedStatement pstmt = null;
		List<StoreVO> all = new ArrayList<StoreVO>();
		;
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_All_STMT_BY_AUDI_0);

			ResultSet rs = pstmt.executeQuery();
			StoreVO storeVO = null;

			while (rs.next()) {
				storeVO = new StoreVO();
				storeVO.setMemberID(rs.getInt("memberID"));
				storeVO.setStoreName(rs.getString("storeName"));
				storeVO.setStoreAddress(rs.getString("storeAddress"));
				storeVO.setPhoneNumber(rs.getString("phoneNumber"));
				storeVO.setCreateDate(rs.getTimestamp("createDate"));
				storeVO.setUpdateDate(rs.getTimestamp("updateDate"));
				storeVO.setTaxID(rs.getString("taxID"));
				storeVO.setStoreAuditStatus(rs.getInt("storeAuditStatus"));
				all.add(storeVO);
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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
		return all;

	}

	@Override
	public Integer findMemberID(Integer storeID) {
		try (Connection con = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement pstmt = con.prepareStatement(GET_STORE_MEMBERID)) {

			pstmt.setInt(1, storeID);
			try (ResultSet rs = pstmt.executeQuery()) {
				Integer memberID = null;
				while (rs.next()) {
					memberID = rs.getInt("memberID");
				}
				return memberID;
			}

			// Handle any driver errors
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void main(String[] args) {

//		StoreJDBCDAO dao = new StoreJDBCDAO();

		// insert

//		StoreVO storeVO = new StoreVO();
//		storeVO.setMemberID(4);
//		storeVO.setStoreName("語決賣場-3");
//		storeVO.setStoreDelBankCode("Q123456789-2");
//		storeVO.setStoreBankAccount("W123456789-2");
//		storeVO.setStoreAddress("西門町-3");
//		storeVO.setPhoneNumber("234567891");
//		storeVO.setTaxID("OX123456-2");
//		dao.insert(storeVO);
//
//		System.out.println("123");
//		dao.pass(4);
		// update

//		StoreVO storeVO = new StoreVO();
//		storeVO.setStoreID(1);
//		storeVO.setMemberID(1);
//		storeVO.setStoreName("語決賣場-2");
//		storeVO.setStoreDelBankCode("Q123456789-2");
//		storeVO.setStoreBankAccount("W123456789-2");
//		storeVO.setStoreAddress("西門町-2");
//		storeVO.setPhoneNumber("234567891");
//		storeVO.setTaxID("OX123456-2");
//		storeVO.setStoreAuditStatus(1);
//		dao.update(storeVO);

		// findByPrimaryKey

//		StoreVO storeVO2 = dao.findByPrimaryKey(1);
//		System.out.print(storeVO2.getStoreID() + ",");
//		System.out.print(storeVO2.getStoreName() + ",");
//		System.out.print(storeVO2.getStoreDelBankCode() + ",");
//		System.out.print(storeVO2.getStoreBankAccount() + ",");
//		System.out.print(storeVO2.getStoreAddress() + ",");
//		System.out.print(storeVO2.getPhoneNumber() + ",");
//		System.out.print(storeVO2.getTaxID() + ",");
//		System.out.print(storeVO2.getStoreAuditStatus() + ",");
//		System.out.println();
//		System.out.println("---------------------");

//		List<StoreVO> a = dao.findAllByAudit0();
//		for(StoreVO b : a) {
//			System.out.println(b.getStoreID());
//		}

	}
}