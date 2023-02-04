package com.group6.tibame104.ad.model;

import java.util.*;

import javax.imageio.stream.FileImageInputStream;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.sql.*;


public class AdJDBCDAO implements AdDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db06_sym?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	
	private static final String INSERT_STMT = 
			"INSERT INTO advertise (administratorID, groupBuyID, adTitle, adType, adDescribe, adStartDate, adEndDate, adPhoto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT adSerialID, administratorID, groupBuyID, adTitle, adType, adDescribe, adStartDate, adEndDate, adPhoto, updateTime FROM advertise order by adSerialID";
		private static final String GET_ONE_STMT = 
			"SELECT adSerialID, administratorID, groupBuyID, adTitle, adType, adDescribe, adStartDate, adEndDate, adPhoto, updateTime FROM advertise where adSerialID = ?";
		private static final String DELETE = 
			"DELETE FROM advertise where adSerialID = ?";
		private static final String UPDATE = 
			"UPDATE advertise set adTitle=?,  adType=?, adDescribe=?, adPhoto=?, adStartDate=?, adEndDate=?, updateTime=now() where adSerialID= ?";
		
		
		@Override
		public void insert(AdVO adVO) {
			
			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(INSERT_STMT);
				pstmt.setInt(1, adVO.getAdministratorID());
				pstmt.setInt(2, adVO.getGroupBuyID());
				pstmt.setString(3, adVO.getAdTitle());
				pstmt.setString(4, adVO.getAdType());
				pstmt.setString(5, adVO.getAdDescribe());
				pstmt.setDate(6, adVO.getAdStartDate());
				pstmt.setDate(7, adVO.getAdEndDate());
				pstmt.setBytes(8, adVO.getAdPhoto());
//				pstmt.setTimestamp(6, advVO.getUpdateTime());

				pstmt.executeUpdate();

				// Handle any driver errors
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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
		public void update(AdVO adVO) {
			
			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(UPDATE);

				pstmt.setString(1, adVO.getAdTitle());
				pstmt.setString(2, adVO.getAdType());
				pstmt.setString(3, adVO.getAdDescribe());
				pstmt.setBytes(4, adVO.getAdPhoto());
				pstmt.setDate(5, adVO.getAdStartDate());
				pstmt.setDate(6, adVO.getAdEndDate());
				pstmt.setInt(7, adVO.getAdSerialID());
//				pstmt.setTimestamp(8, adVO.getUpdateTime());

				pstmt.executeUpdate();
				
				// Handle any driver errors
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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
		public void delete(Integer adSerialID) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(DELETE);

				pstmt.setInt(1, adSerialID);

				pstmt.executeUpdate();

				// Handle any driver errors
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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
		public AdVO findByPrimaryKey(Integer adSerialID) {

			AdVO adVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setInt(1, adSerialID);
				
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					adVO = new AdVO();
					adVO.setAdSerialID(rs.getInt("adSerialID"));
					adVO.setAdministratorID(rs.getInt("administratorID"));
					adVO.setGroupBuyID(rs.getInt("groupBuyID"));
					adVO.setAdTitle(rs.getString("adTitle"));
					adVO.setAdType(rs.getString("adType"));
					adVO.setAdDescribe(rs.getString("adDescribe"));
					adVO.setAdPhoto(rs.getBytes("adPhoto"));
					adVO.setAdStartDate(rs.getDate("adStartDate"));
					adVO.setAdEndDate(rs.getDate("adEndDate"));
					adVO.setUpdateTime(rs.getTimestamp("updateTime"));
				}

				// Handle any driver errors
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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
			return adVO;
		}

		
		
		
		@Override
		public List<AdVO> getAll() {
			List<AdVO> list = new ArrayList<AdVO>();
			AdVO adVO = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					// adVO也稱為 Domain objects
					adVO = new AdVO();
					adVO.setAdSerialID(rs.getInt("adSerialID"));
					adVO.setAdministratorID(rs.getInt("administratorID"));
					adVO.setGroupBuyID(rs.getInt("groupBuyID"));
					adVO.setAdTitle(rs.getString("adTitle"));
					adVO.setAdType(rs.getString("adType"));
					adVO.setAdDescribe(rs.getString("adDescribe"));
					adVO.setAdPhoto(rs.getBytes("adPhoto"));
					adVO.setAdStartDate(rs.getDate("adStartDate"));
					adVO.setAdEndDate(rs.getDate("adEndDate"));
					adVO.setUpdateTime(new Timestamp(Calendar.getInstance().getTime().getTime()));
					list.add(adVO); // Store the row in the list
				}

				// Handle any driver errors
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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

			AdJDBCDAO dao = new AdJDBCDAO();
			// 圖片上傳
//			byte[] data = null;
//			FileImageInputStream input = null;
//			try {
//				input = new FileImageInputStream(new File("C:\\Users\\Tibame_T14\\Desktop\\001.jpg"));
//				ByteArrayOutputStream output = new ByteArrayOutputStream();
//				byte[] buf = new byte[1024];
//				int numBytesRead = 0;
//				while ((numBytesRead = input.read(buf)) != -1) {
//					output.write(buf, 0, numBytesRead);
//				}
//				data = output.toByteArray();
//				output.close();
//				input.close();
//			} catch (Exception ex1) {
//				ex1.printStackTrace();
//			}

			
			// 新增
//			 AdVO AdVO1 = new AdVO();
//			 AdVO1.setAdSerialID(1);
//			 AdVO1.setAdministratorID(2);
//			 AdVO1.setGroupBuyID(1);
//			 AdVO1.setAdTitle("最新消息");
//			 AdVO1.setAdType("團購相關");
//			 AdVO1.setAdDescribe("雙11團購優惠開跑");
////			 AdVO1.setAdPhoto(data);
//			 AdVO1.setAdStartDate(java.sql.Date.valueOf("2005-01-01"));
//			 AdVO1.setAdEndDate(java.sql.Date.valueOf("2005-01-20"));
//			 AdVO1.setUpdateTime(new Timestamp(Calendar.getInstance().getTime().getTime()));
//			  
//			 dao.insert(AdVO1);
			 
			 
			
						
//			// 修改
//			 AdVO AdVO2 = new  AdVO();
//			 AdVO2.setAdSerialID(1);
//			 AdVO2.setAdTitle("最新消息");
//			 AdVO2.setAdType("團購相關");
//			 AdVO2.setAdDescribe("雙11團購優惠開跑");
//			 AdVO2.setAdPhoto(data);
//			 AdVO2.setAdStartDate(java.sql.Date.valueOf("2022-01-01"));
//			 AdVO2.setAdEndDate(java.sql.Date.valueOf("2022-11-30"));
////			 AdVO2.setUpdateTime(new Timestamp(Calendar.getInstance().getTime().getTime()));
//			 dao.update(AdVO2);

//			// 刪除
//			dao.delete(1);
			
			

			// 查詢
//			AdVO adVO3 = dao.findByPrimaryKey("adSerialID");
//			System.out.print(adVO3.getAdSerialID() + ",");
//			System.out.print(adVO3.getAdministratorID() + ",");
//			System.out.print(adVO3.getGroupBuyID() + ",");
//			System.out.print(adVO3.getAdTitle() + ",");
//			System.out.print(adVO3.getAdType() + ",");
//			System.out.print(adVO3.getAdDescribe() + ",");
//			System.out.print(adVO3.getAdPhoto() + ",");
//			System.out.print(adVO3.getAdStartDate());
//			System.out.print(adVO3.getAdEndDate());
//			System.out.print(adVO3.getUpdateTime());
//			System.out.println("---------------------");

						
//			// 查詢
//			List<AdVO> list = dao.getAll();
//			for (AdVO aAdver : list) {
//				System.out.print(aAdver.getAdSerialID() + ",");
//				System.out.print(aAdver.getAdministratorID() + ",");
//				System.out.print(aAdver.getGroupBuyID() + ",");
//				System.out.print(aAdver.getAdTitle() + ",");
//				System.out.print(aAdver.getAdType() + ",");
//				System.out.print(aAdver.getAdDescribe() + ",");
//				System.out.print(aAdver.getAdPhoto() + ",");
//				System.out.print(aAdver.getAdStartDate());
//				System.out.print(aAdver.getAdEndDate());
//				System.out.print(aAdver.getUpdateTime());
//				System.out.println();
//			}

			
		}



}
