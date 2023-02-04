package com.group6.tibame104.shoppingGoldRecord.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingGoldRecordDAO implements ShoppingGoldRecordDAO_interface {

	@Autowired
	private DataSource dataSource;

	private static final String INSERT_STMT = "INSERT INTO shoppingGoldRecord (memberID, useDate, obtainShoppingCoin, plusOrMinus) VALUES (?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT shoppingGoldRecordID, memberID, useDate, obtainShoppingCoin, plusOrMinus FROM shoppinggoldrecord order by shoppingGoldRecordID;";
	private static final String GET_ONE_STMT = "SELECT shoppingGoldRecordID, memberID, useDate, obtainShoppingCoin, plusOrMinus FROM shoppinggoldrecord where memberID = ?";
	private static final String UPDATE = "UPDATE shoppingGoldRecordID set shoppingGoldRecordID = ?, memberID = ?, useDate = ?, obtainShoppingCoin = ?, plusOrMinus = ? where shoppingGoldRecordID = ?";

	@Override
	public void insert(ShoppingGoldRecordVO shoppingGoldRecordVO) {

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_STMT);) {

			pstmt.setInt(1, shoppingGoldRecordVO.getMemberID());
			pstmt.setTimestamp(2, shoppingGoldRecordVO.getUseDate());
			pstmt.setInt(3, shoppingGoldRecordVO.getObtainShoppingCoin());
			pstmt.setInt(4, shoppingGoldRecordVO.getPlusOrMinus());

			pstmt.executeUpdate();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(ShoppingGoldRecordVO shoppingGoldRecordVO) {

		try (Connection con = dataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(UPDATE);) {

			pstmt.setInt(1, shoppingGoldRecordVO.getShoppingGoldRecordID());
			pstmt.setInt(2, shoppingGoldRecordVO.getMemberID());
			pstmt.setTimestamp(3, shoppingGoldRecordVO.getUseDate());
			pstmt.setInt(4, shoppingGoldRecordVO.getObtainShoppingCoin());
			pstmt.setInt(5, shoppingGoldRecordVO.getPlusOrMinus());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ShoppingGoldRecordVO findByPrimaryKey(Integer ShoppingGoldRecordID) {

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT);) {
			pstmt.setInt(1, ShoppingGoldRecordID);
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					ShoppingGoldRecordVO shoppingGoldRecordVO = null;
					shoppingGoldRecordVO = new ShoppingGoldRecordVO();
					shoppingGoldRecordVO.setShoppingGoldRecordID(rs.getInt("shoppingGoldRecordID"));
					shoppingGoldRecordVO.setMemberID(rs.getInt("memberID"));
					shoppingGoldRecordVO.setUseDate(rs.getTimestamp("useDate"));
					shoppingGoldRecordVO.setObtainShoppingCoin(rs.getInt("obtainShoppingCoin"));
					shoppingGoldRecordVO.setPlusOrMinus(rs.getInt("plusOrMinus"));
					return shoppingGoldRecordVO;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ShoppingGoldRecordVO> getAll() {

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT);) {
			try (ResultSet rs = pstmt.executeQuery();) {

				List<ShoppingGoldRecordVO> list = new ArrayList<ShoppingGoldRecordVO>();
				while (rs.next()) {
					ShoppingGoldRecordVO shoppingGoldRecordVO = new ShoppingGoldRecordVO();
					shoppingGoldRecordVO.setShoppingGoldRecordID(rs.getInt("shoppingGoldRecordID"));
					shoppingGoldRecordVO.setMemberID(rs.getInt("memberID"));
					shoppingGoldRecordVO.setUseDate(rs.getTimestamp("useDate"));
					shoppingGoldRecordVO.setObtainShoppingCoin(rs.getInt("obtainShoppingCoin"));
					shoppingGoldRecordVO.setPlusOrMinus(rs.getInt("plusOrMinus"));
					list.add(shoppingGoldRecordVO); // Store the row in the list
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ShoppingGoldRecordVO> getAllShoppingGoldRecord(Integer memberID) {

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT);) {
			pstmt.setInt(1, memberID);
			try (ResultSet rs = pstmt.executeQuery();) {

				List<ShoppingGoldRecordVO> list = new ArrayList<ShoppingGoldRecordVO>();
				while (rs.next()) {
					ShoppingGoldRecordVO shoppingGoldRecordVO = new ShoppingGoldRecordVO();
					shoppingGoldRecordVO.setShoppingGoldRecordID(rs.getInt("shoppingGoldRecordID"));
					shoppingGoldRecordVO.setMemberID(rs.getInt("memberID"));
					shoppingGoldRecordVO.setUseDate(rs.getTimestamp("useDate"));
					shoppingGoldRecordVO.setObtainShoppingCoin(rs.getInt("obtainShoppingCoin"));
					shoppingGoldRecordVO.setPlusOrMinus(rs.getInt("plusOrMinus"));
					list.add(shoppingGoldRecordVO); // Store the row in the list
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//	public static void main(String[] args) {
//
//		EmpJDBCDAO dao = new EmpJDBCDAO();
//
//		// �s�W
//		EmpVO empVO1 = new EmpVO();
//		empVO1.setEname("�d�ç�1");
//		empVO1.setJob("MANAGER");
//		empVO1.setHiredate(java.sql.Date.valueOf("2005-01-01"));
//		empVO1.setSal(new Double(50000));
//		empVO1.setComm(new Double(500));
//		empVO1.setDeptno(10);
//		dao.insert(empVO1);
//
//		// �ק�
//		EmpVO empVO2 = new EmpVO();
//		empVO2.setEmpno(7001);
//		empVO2.setEname("�d�ç�2");
//		empVO2.setJob("MANAGER2");
//		empVO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
//		empVO2.setSal(new Double(20000));
//		empVO2.setComm(new Double(200));
//		empVO2.setDeptno(20);
//		dao.update(empVO2);
//
//		// �R��
//		dao.delete(7014);
//
//		// �d��
//		EmpVO empVO3 = dao.findByPrimaryKey(7001);
//		System.out.print(empVO3.getEmpno() + ",");
//		System.out.print(empVO3.getEname() + ",");
//		System.out.print(empVO3.getJob() + ",");
//		System.out.print(empVO3.getHiredate() + ",");
//		System.out.print(empVO3.getSal() + ",");
//		System.out.print(empVO3.getComm() + ",");
//		System.out.println(empVO3.getDeptno());
//		System.out.println("---------------------");
//
//		// �d��
//		List<EmpVO> list = dao.getAll();
//		for (EmpVO aEmp : list) {
//			System.out.print(aEmp.getEmpno() + ",");
//			System.out.print(aEmp.getEname() + ",");
//			System.out.print(aEmp.getJob() + ",");
//			System.out.print(aEmp.getHiredate() + ",");
//			System.out.print(aEmp.getSal() + ",");
//			System.out.print(aEmp.getComm() + ",");
//			System.out.print(aEmp.getDeptno());
//			System.out.println();
//		}
//	}
}
