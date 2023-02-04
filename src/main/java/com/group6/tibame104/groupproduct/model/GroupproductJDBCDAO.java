package com.group6.tibame104.groupproduct.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GroupproductJDBCDAO implements GroupproductDAO_interface {

	@Autowired
	private DataSource dataSource;
	
	private static final String INSERT_STMT = "INSERT INTO groupBuyProduct(groupBuyProductPrice,groupBuyProductPicture,groupBuyProductDescrip) VALUES (?, ?, ?)";
	private static final String UPDATE = "UPDATE groupBuyProduct set groupBuyProductPrice=?,groupBuyProductPicture = Coalesce (?,groupBuyProductPicture),groupBuyProductDescrip= ? WHERE groupBuyProductID=?";
	private static final String DELETE = "DELETE FROM groupBuyProduct where groupbuyProductID = ?;";
	private static final String GET_ONE_STMT = "SELECT groupBuyProductID ,groupBuyProductPrice ,groupBuyProductPicture ,groupBuyProductDescrip FROM groupBuyProduct WHERE groupBuyProductID = ?;";
	private static final String GET_ALL_STMT = "SELECT groupBuyProductID ,groupBuyProductPrice ,groupBuyProductPicture ,groupBuyProductDescrip FROM groupBuyProduct";

	@Override
	public void insert(GroupproductVO groupproductVO) {

		try(Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT_STMT);
			){
			pstmt.setInt(1, groupproductVO.getGroupBuyProductPrice());
			pstmt.setBytes(2, groupproductVO.getGroupBuyProductPicture());
			pstmt.setString(3, groupproductVO.getGroupBuyProductDescrip());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 更新
	@Override
	public void update(GroupproductVO groupproductVO) {

		try(Connection con = dataSource.getConnection();
			PreparedStatement pstmt = 	con.prepareStatement(UPDATE);
			){

			pstmt.setInt(1, groupproductVO.getGroupBuyProductPrice());
			pstmt.setBytes(2, groupproductVO.getGroupBuyProductPicture());
			pstmt.setString(3, groupproductVO.getGroupBuyProductDescrip());
			pstmt.setInt(4, groupproductVO.getGroupBuyProductID());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

	// 刪除
	@Override
	public void delete(Integer groupBuyProductID) {

		try(
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(DELETE);
			){
			
			pstmt.setInt(1, groupBuyProductID);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 查詢單一
	@Override
	public GroupproductVO findByPrimaryKey(Integer groupBuyProductID) {

		try(
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT);
			){
			pstmt.setInt(1, groupBuyProductID);

			try(ResultSet rs = pstmt.executeQuery()){
				
				if (rs.next()) {
					// empVo 也稱為 Domain objects
					GroupproductVO groupproductVO = new GroupproductVO();
					
					groupproductVO.setGroupBuyProductID(rs.getInt("groupBuyProductID"));
					groupproductVO.setGroupBuyProductPrice(rs.getInt("groupbuyProductPrice"));
					groupproductVO.setGroupBuyProductPicture(rs.getBytes("groupbuyProductPicture"));
					groupproductVO.setGroupBuyProductDescrip(rs.getString("groupbuyProductDescrip"));
					return groupproductVO;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// 查詢ALL

	public List<GroupproductVO> getAll() {

		try(
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT);
			){
			
			try(ResultSet rs = pstmt.executeQuery()){
				List<GroupproductVO> list = new ArrayList<GroupproductVO>();
				while (rs.next()) {
					GroupproductVO groupproductVO = new GroupproductVO();
					
					groupproductVO.setGroupBuyProductID(rs.getInt("groupBuyProductID"));
					groupproductVO.setGroupBuyProductPrice(rs.getInt("groupBuyProductPrice"));
					groupproductVO.setGroupBuyProductPicture(rs.getBytes("groupBuyProductPicture"));
					groupproductVO.setGroupBuyProductDescrip(rs.getString("groupBuyProductDescrip"));
					
					list.add(groupproductVO); 
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return null;
			}
	
	public List<GroupproductVO> getAllBySearch(String queryString) {

		try(
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT + queryString);
			){
			
			try(ResultSet rs = pstmt.executeQuery()){
				List<GroupproductVO> list = new ArrayList<GroupproductVO>();
				while (rs.next()) {
					GroupproductVO groupproductVO = new GroupproductVO();
					
					groupproductVO.setGroupBuyProductID(rs.getInt("groupBuyProductID"));
					groupproductVO.setGroupBuyProductPrice(rs.getInt("groupBuyProductPrice"));
					groupproductVO.setGroupBuyProductPicture(rs.getBytes("groupBuyProductPicture"));
					groupproductVO.setGroupBuyProductDescrip(rs.getString("groupBuyProductDescrip"));
					
					list.add(groupproductVO); 
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return null;
			}
//	public static void main(String[] args) {
////		單一查詢
//		GroupproductJDBCDAO dao = new GroupproductJDBCDAO();
//		GroupproductVO groupproductVO3 = dao.findByPrimaryKey(1);
//		
//		System.out.print(groupproductVO3.getGroupBuyProductID() + ",");
//		System.out.print(groupproductVO3.getGroupBuyProductPrice() + ",");
//		System.out.print(groupproductVO3.getGroupBuyProductPicture()+ ",");
//		System.out.println(groupproductVO3.getGroupBuyProductDescrip());
//		System.out.println("---------------------");
//	}
}
