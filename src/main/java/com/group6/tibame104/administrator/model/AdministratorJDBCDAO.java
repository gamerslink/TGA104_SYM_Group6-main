package com.group6.tibame104.administrator.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.group6.tibame104.store.model.StoreVO;

public class AdministratorJDBCDAO implements AdministratorDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db06_sym?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT_STMT = "INSERT INTO administrator(administratorName, administratorAccount, administratorPassword) VALUES (?, ?, ?)";
	private static final String GET_ALL_MEMBER = "SELECT administratorID, administratorName, administratorAccount, administratorPassword FROM administrator order by administratorID";
	private static final String GET_ONE_STMT = "SELECT administratorID, administratorName, administratorAccount, administratorPassword FROM administrator where administratorID = ?";
	private static final String UPDATE = "UPDATE administrator set administratorName=?, administratorAccount=?,  administratorPassword=? where administratorID = ?";
	private static final String DELETE = "DELETE FROM administrator where administratorID = ?";
	private static final String GET_TOTAL_MEMBER = "select count(*) as memberTotal from member";
	private static final String GET_TOTAL_STORE = "select count(*) as storeTotal from store";
	private static final String GET_TOTAL_STORE_STMT_0 = "select count(*) as storeTotalN from store where storeAuditStatus = 0";
	private static final String GET_TOTAL_STORE_STMT_1 = "select count(*) as storeTotalY from store where storeAuditStatus = 1";
	private static final String GET_All_STMT_BY_AUDI_1 = "SELECT memberID,storeName,storeAddress,phoneNumber,createDate,updateDate,taxID,storeAuditStatus FROM store where storeAuditStatus = 1";
	
	
	
	@Override
	public void insert(AdministratorVO administratorVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, administratorVO.getAdministratorName());
			pstmt.setString(2, administratorVO.getAdministratorAccount());
			pstmt.setString(3, administratorVO.getAdministratorPassword());

			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void update(AdministratorVO administratorVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, administratorVO.getAdministratorName());
			pstmt.setString(2, administratorVO.getAdministratorAccount());
			pstmt.setString(3, administratorVO.getAdministratorPassword());
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public List<AdministratorVO> getAll() {

		List<AdministratorVO> list = new ArrayList<AdministratorVO>();
		AdministratorVO administratorVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_MEMBER);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				administratorVO = new AdministratorVO();
				administratorVO.setAdministratorName(rs.getString("administratorName"));
				administratorVO.setAdministratorAccount(rs.getString("administratorAccount"));
				administratorVO.setAdministratorPassword(rs.getString("administratorPassword"));

				list.add(administratorVO); // Store the row in the list
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

	@Override
	public void delete(Integer administratorID) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, administratorID);

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
	public AdministratorVO findOneAdmin(Integer administratorID) {
		AdministratorVO administratorVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, administratorID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				administratorVO = new AdministratorVO();
				administratorVO.setAdministratorID(rs.getInt("administratorID"));
				administratorVO.setAdministratorName(rs.getString("administratorName"));
				administratorVO.setAdministratorAccount(rs.getString("administratorAccount"));
				administratorVO.setAdministratorPassword(rs.getString("administratorPassword"));
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return administratorVO;
	}

	@Override
	public Integer countMember() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Integer memberTotal = 0;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_TOTAL_MEMBER);
			rs = pstmt.executeQuery();
			rs.next();
			memberTotal = rs.getInt("memberTotal");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberTotal;
	}

	@Override
	public Integer countStore() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int storeTotal = 0;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_TOTAL_STORE);
			rs = pstmt.executeQuery();
			rs.next();
			storeTotal = rs.getInt("storeTotal");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return storeTotal;
	}

	@Override
	public Integer countStatusN() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int statusTotalN = 0;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_TOTAL_STORE_STMT_0);
			rs = pstmt.executeQuery();
			rs.next();
			statusTotalN = rs.getInt("storeTotalN");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statusTotalN;
	}

	@Override
	public Integer countStatusY() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int statusTotalY = 0;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_TOTAL_STORE_STMT_1);
			rs = pstmt.executeQuery();
			rs.next();
			statusTotalY = rs.getInt("storeTotalY");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statusTotalY;
	}
	
	
	@Override
	public List<StoreVO> findAllByAudit1() {
		Connection con = null;
		PreparedStatement pstmt = null;
		List<StoreVO> all2 = new ArrayList<StoreVO>();;
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_All_STMT_BY_AUDI_1);

			ResultSet rs = pstmt.executeQuery();
			StoreVO storeVO=null;
			
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
				all2.add(storeVO);
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
		return all2;

	}

}
