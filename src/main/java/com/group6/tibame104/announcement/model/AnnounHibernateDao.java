package com.group6.tibame104.announcement.model;

import java.util.List;

import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class AnnounHibernateDao implements AnnouncementDAO_interface {
	@PersistenceContext
	private Session session;
	
	@Override
	public void insert(AnnouncementVO announcementVO) {
		session.persist(announcementVO);
	}

	@Override
	public void update(AnnouncementVO announcementVO) {
		final String hql = "update AnnouncementVO "
				+ "set administratorID = :administratorID, announcementTitle = :announcementTitle,"
				+ " announcementContent = :announcementContent, startDate = :startDate, endDate = :endDate,"
				+ " updateTime = now(), offLoadStatus = :offLoadStatus,showStatus = :showStatus "
				+ "where announcementSerialID = :announcementSerialID";

		session.createQuery(hql).setParameter("administratorID", announcementVO.getAdministratorID())
				.setParameter("announcementTitle", announcementVO.getAnnouncementTitle())
				.setParameter("announcementContent", announcementVO.getAnnouncementContent())
				.setParameter("startDate", announcementVO.getStartDate())
				.setParameter("endDate", announcementVO.getEndDate())
				.setParameter("offLoadStatus", announcementVO.getOffLoadStatus())
				.setParameter("showStatus", announcementVO.getShowStatus())
				.setParameter("announcementSerialID", announcementVO.getAnnouncementSerialID()).executeUpdate();
	}
	
	@Override
	public void delete(Integer announcementSerialID) {
		final AnnouncementVO announcementVO = session.get(AnnouncementVO.class, announcementSerialID);
		session.remove(announcementVO);
	}
	
	@Override
	public List<AnnouncementVO> findByPK(Integer announcementSerialID) {
		final String hql = "FROM AnnouncementVO WHERE announcementSerialID = :announcementSerialID";
		return session.createQuery(hql, AnnouncementVO.class).setParameter("announcementSerialID", announcementSerialID).list();
	}
	
	@Override
	public List<AnnouncementVO> findByTitle(String announcementTitle) {
		final String hql = "FROM AnnouncementVO WHERE announcementTitle = :announcementTitle";
		return session.createQuery(hql, AnnouncementVO.class).setParameter("announcementTitle", announcementTitle).list();
	}
	
	@Override
	public List<AnnouncementVO> findByOffLoadStatus(Boolean offLoadStatus) {
		final String hql = "FROM AnnouncementVO WHERE offLoadStatus = :offLoadStatus";
		return session.createQuery(hql, AnnouncementVO.class).setParameter("offLoadStatus", offLoadStatus).list();
	}
	
	@Override
	public List<AnnouncementVO> findByShowStatus(Boolean showStatus) {
		final String hql = "FROM AnnouncementVO WHERE showStatus = :showStatus";
		return session.createQuery(hql, AnnouncementVO.class).setParameter("showStatus", showStatus).list();
	}
	
	@Override
	public List<AnnouncementVO> findIndexNews() {
		final String hql = "FROM AnnouncementVO WHERE (offLoadStatus = 1 AND showStatus = 1) ORDER BY announcementSerialID DESC";
		return session.createQuery(hql, AnnouncementVO.class).list();
	}
	
	@Override
	public List<AnnouncementVO> findAll() {
		final String hql = "FROM AnnouncementVO ORDER BY announcementSerialID";
		return session.createQuery(hql, AnnouncementVO.class).list();
	}
	
//	// 新增公告
//	private static final String Insert = "INSERT INTO announcement (administratorID, announcementTitle, announcementContent, startDate, endDate, updateTime, offLoadStatus, showStatus) VALUES(?, ?, ?, ?, ?, now(), ?, ?)";
//	// 修改公告
//	private static final String Update = "UPDATE announcement SET administratorID=?, announcementTitle=?, announcementContent=?, startDate=?, endDate=?,updateTime=now(), offLoadStatus=?, showStatus=? WHERE announcementSerialID=?";
//	// 刪除公告
//	private static final String Delete = "DELETE FROM announcement WHERE announcementSerialID=?";
//	// 依照公告Title做查詢
//	private static final String GetByTitle = "SELECT announcementSerialID, administratorID, announcementTitle, announcementContent, startDate, endDate, updateTime, offLoadStatus, showStatus FROM announcement WHERE announcementTitle=?";
//	// 依照公告ID做查詢
//	private static final String GetByPK = "SELECT announcementSerialID, administratorID, announcementTitle, announcementContent, startDate, endDate, updateTime, offLoadStatus, showStatus FROM announcement WHERE announcementSerialID=?";
//	// 依照公告上架狀態做查詢
//	private static final String GetByOffLoadStatus = "SELECT announcementSerialID, administratorID, announcementTitle, announcementContent, startDate, endDate, updateTime, offLoadStatus, showStatus FROM announcement WHERE offLoadStatus=?";
//	// 依照公告顯示位置做查詢
//	private static final String GetByShowStatus = "SELECT announcementSerialID, administratorID, announcementTitle, announcementContent, startDate, endDate, updateTime, offLoadStatus, showStatus FROM announcement WHERE showStatus=?";
//	// 查詢全部公告
//	private static final String GetAll = "SELECT announcementSerialID, administratorID, announcementTitle, announcementContent, startDate, endDate, updateTime, offLoadStatus, showStatus FROM announcement ORDER BY announcementSerialID";
//	// 查詢上架中的最新消息
//	private static final String GetIndexNews = "SELECT announcementContent FROM announcement WHERE (offLoadStatus=1 and showStatus=1)";
////	// 依照公告Title做查詢
////	private static final String GetShopNews = "SELECT announcementSerialID, administratorID, announcementTitle, announcementContent, startDate, endDate, updateTime, offLoadStatus, showStatus FROM announcement WHERE announcementTitle=?";
//	@Override
//	public void insert(AnnouncementVO announcementVO) {
//		try (Connection con = dataSource.getConnection();
//				PreparedStatement pstmt = con.prepareStatement(Insert);) {
//			pstmt.setInt(1, announcementVO.getAdministratorID());
//			pstmt.setString(2, announcementVO.getAnnouncementTitle());
//			pstmt.setString(3, announcementVO.getAnnouncementContent());
//			pstmt.setDate(4, announcementVO.getStartDate());
//			pstmt.setDate(5, announcementVO.getEndDate());
//			pstmt.setBoolean(6, announcementVO.getOffLoadStatus());
//			pstmt.setBoolean(7, announcementVO.getShowStatus());
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void update(AnnouncementVO announcementVO) {
//		try (Connection con = dataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(Update);) {
//			pstmt.setInt(8, announcementVO.getAnnouncementSerialID());
//			pstmt.setInt(1, announcementVO.getAdministratorID());
//			pstmt.setString(2, announcementVO.getAnnouncementTitle());
//			pstmt.setString(3, announcementVO.getAnnouncementContent());
//			pstmt.setDate(4, announcementVO.getStartDate());
//			pstmt.setDate(5, announcementVO.getEndDate());
//			pstmt.setBoolean(6, announcementVO.getOffLoadStatus());
//			pstmt.setBoolean(7, announcementVO.getShowStatus());
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void delete(Integer announcementSerialID) {
//		try (
//			Connection con = dataSource.getConnection();
//			PreparedStatement pstmt = con.prepareStatement(Delete);
//		) {
//			pstmt.setInt(1, announcementSerialID);
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public List<AnnouncementVO> findByPK(Integer announcementSerialID) {
//		try (Connection con = dataSource.getConnection();
//				PreparedStatement pstmt = con.prepareStatement(GetByPK);) {
//			pstmt.setInt(1, announcementSerialID);
//			try (ResultSet rs = pstmt.executeQuery();) {
//				List<AnnouncementVO> list = new ArrayList<AnnouncementVO>();
//				while (rs.next()) {
//					AnnouncementVO announcementVO = new AnnouncementVO();
//					announcementVO.setAnnouncementSerialID(rs.getInt("announcementSerialID"));
//					announcementVO.setAdministratorID(rs.getInt("administratorID"));
//					announcementVO.setAnnouncementTitle(rs.getString("announcementTitle"));
//					announcementVO.setAnnouncementContent(rs.getString("announcementContent"));
//					announcementVO.setStartDate(rs.getDate("startDate"));
//					announcementVO.setEndDate(rs.getDate("endDate"));
//					announcementVO.setUpdateTime(rs.getTimestamp("updateTime"));
//					announcementVO.setOffLoadStatus(rs.getBoolean("offLoadStatus"));
//					announcementVO.setShowStatus(rs.getBoolean("showStatus"));
//					list.add(announcementVO);
//				}
//				return list;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public List<AnnouncementVO> findByTitle(String announcementTitle) {
//		try (Connection con = dataSource.getConnection();
//				PreparedStatement pstmt = con.prepareStatement(GetByTitle);) {
//			pstmt.setString(1, announcementTitle);
//			try (ResultSet rs = pstmt.executeQuery();) {
//				List<AnnouncementVO> list = new ArrayList<AnnouncementVO>();
//				while (rs.next()) {
//					AnnouncementVO announcementVO = new AnnouncementVO();
//					announcementVO.setAnnouncementSerialID(rs.getInt("announcementSerialID"));
//					announcementVO.setAdministratorID(rs.getInt("administratorID"));
//					announcementVO.setAnnouncementTitle(rs.getString("announcementTitle"));
//					announcementVO.setAnnouncementContent(rs.getString("announcementContent"));
//					announcementVO.setStartDate(rs.getDate("startDate"));
//					announcementVO.setEndDate(rs.getDate("endDate"));
//					announcementVO.setUpdateTime(rs.getTimestamp("updateTime"));
//					announcementVO.setOffLoadStatus(rs.getBoolean("offLoadStatus"));
//					announcementVO.setShowStatus(rs.getBoolean("showStatus"));
//					list.add(announcementVO);
//				}
//				return list;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	@Override
//	public List<AnnouncementVO> findByOffLoadStatus(Boolean offLoadStatus) {
//		try (Connection con = dataSource.getConnection();
//				PreparedStatement pstmt = con.prepareStatement(GetByOffLoadStatus);) {
//			pstmt.setBoolean(1, offLoadStatus);
//			try (ResultSet rs = pstmt.executeQuery();) {
//				List<AnnouncementVO> list = new ArrayList<AnnouncementVO>();
//				while (rs.next()) {
//					AnnouncementVO announcementVO = new AnnouncementVO();
//					announcementVO.setAnnouncementSerialID(rs.getInt("announcementSerialID"));
//					announcementVO.setAdministratorID(rs.getInt("administratorID"));
//					announcementVO.setAnnouncementTitle(rs.getString("announcementTitle"));
//					announcementVO.setAnnouncementContent(rs.getString("announcementContent"));
//					announcementVO.setStartDate(rs.getDate("startDate"));
//					announcementVO.setEndDate(rs.getDate("endDate"));
//					announcementVO.setUpdateTime(rs.getTimestamp("updateTime"));
//					announcementVO.setOffLoadStatus(rs.getBoolean("offLoadStatus"));
//					announcementVO.setShowStatus(rs.getBoolean("showStatus"));
//					list.add(announcementVO);
//				}
//				return list;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	@Override
//	public List<AnnouncementVO> findByShowStatus(Boolean showStatus) {
//		try (Connection con = dataSource.getConnection();
//				PreparedStatement pstmt = con.prepareStatement(GetByShowStatus);) {
//			pstmt.setBoolean(1, showStatus);
//			try (ResultSet rs = pstmt.executeQuery();) {
//				List<AnnouncementVO> list = new ArrayList<AnnouncementVO>();
//				while (rs.next()) {
//					AnnouncementVO announcementVO = new AnnouncementVO();
//					announcementVO.setAnnouncementSerialID(rs.getInt("announcementSerialID"));
//					announcementVO.setAdministratorID(rs.getInt("administratorID"));
//					announcementVO.setAnnouncementTitle(rs.getString("announcementTitle"));
//					announcementVO.setAnnouncementContent(rs.getString("announcementContent"));
//					announcementVO.setStartDate(rs.getDate("startDate"));
//					announcementVO.setEndDate(rs.getDate("endDate"));
//					announcementVO.setUpdateTime(rs.getTimestamp("updateTime"));
//					announcementVO.setOffLoadStatus(rs.getBoolean("offLoadStatus"));
//					announcementVO.setShowStatus(rs.getBoolean("showStatus"));
//					list.add(announcementVO);
//				}
//				return list;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public List<AnnouncementVO> findAll() {
//		try (Connection con = dataSource.getConnection();
//				PreparedStatement pstmt = con.prepareStatement(GetAll);) {
//			try (ResultSet rs = pstmt.executeQuery();) {
//				List<AnnouncementVO> list = new ArrayList<AnnouncementVO>();
//				while (rs.next()) {
//					AnnouncementVO announcementVO = new AnnouncementVO();
//					announcementVO.setAnnouncementSerialID(rs.getInt("announcementSerialID"));
//					announcementVO.setAdministratorID(rs.getInt("administratorID"));
//					announcementVO.setAnnouncementTitle(rs.getString("announcementTitle"));
//					announcementVO.setAnnouncementContent(rs.getString("announcementContent"));
//					announcementVO.setStartDate(rs.getDate("startDate"));
//					announcementVO.setEndDate(rs.getDate("endDate"));
//					announcementVO.setUpdateTime(rs.getTimestamp("updateTime"));
//					announcementVO.setOffLoadStatus(rs.getBoolean("offLoadStatus"));
//					announcementVO.setShowStatus(rs.getBoolean("showStatus"));
//					list.add(announcementVO);
//				}
//				return list;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	
//	@Override
//	public List<AnnouncementVO> findIndexNews(){
//		try (Connection con = dataSource.getConnection();
//				PreparedStatement pstmt = con.prepareStatement(GetIndexNews);) {
//			try (ResultSet rs = pstmt.executeQuery();) {
//				List<AnnouncementVO> list = new ArrayList<AnnouncementVO>();
//				while (rs.next()) {
//					AnnouncementVO announcementVO = new AnnouncementVO();
//					announcementVO.setAnnouncementContent(rs.getString("announcementContent"));
//					list.add(announcementVO);
//				}
//				return list;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	
	


////  測試
//	public static void main(String[] args) {
//
//		AnnouncementJDBCDAO dao = new AnnouncementJDBCDAO();
//
//					
//		// 新增 OK!
//		AnnouncementVO announVO1 = new AnnouncementVO();
//		announVO1.setAdministratorID(1);
//		announVO1.setAnnouncementTitle("最新消息");
//		announVO1.setAnnouncementContent("內容XXXXXXXXX");
//		announVO1.setStartDate(java.sql.Date.valueOf("2022-11-10"));
//		announVO1.setEndDate(java.sql.Date.valueOf("2022-11-20"));
//		announVO1.setUpdateTime(null);
//		announVO1.setOffLoadStatus(true);
//		announVO1.setShowStatus(false);
//		dao.insert(announVO1);
//		
//		
//
//		 //修改 OK!
//		AnnouncementVO announVO2 = new AnnouncementVO();
//		announVO2.setAdministratorID(1);
//		announVO2.setAnnouncementTitle("最新消息");
//		announVO2.setAnnouncementContent("內容XXXXXXXXX");
//		announVO2.setStartDate(java.sql.Date.valueOf("2022-12-10"));
//		announVO2.setEndDate(java.sql.Date.valueOf("2022-12-20"));
//		announVO2.setOffLoadStatus(true);
//		announVO2.setShowStatus(1);
//		announVO2.setAnnouncementSerialID(1);
//		
//		dao.update(announVO2);
//		
//
//
//		// 查詢 OK!
//		AnnouncementVO announVO3 = dao.findByAnnTitle("賣場公告");
//		System.out.print(announVO3.getAnnouncementSerialID() + ",");
//		System.out.print(announVO3.getAdministratorID() + ",");
//		System.out.print(announVO3.getAnnouncementTitle() + ",");
//		System.out.print(announVO3.getAnnouncementContent() + ",");
//		System.out.print(announVO3.getStartDate() + ",");
//		System.out.print(announVO3.getEndDate() + ",");
//		System.out.print(announVO3.getUpdateTime() + ",");
//		System.out.println(announVO3.getOffLoadStatus());
//		System.out.println(announVO3.getShowStatus());
//		System.out.println("---------------------");
//	// 查詢 OK!
//	AnnouncementVO announVO3 = dao.findByPrimaryKey(1);
//	System.out.print(announVO3.getAnnouncementSerialID() + ",");
//	System.out.print(announVO3.getAdministratorID() + ",");
//	System.out.print(announVO3.getAnnouncementTitle() + ",");
//	System.out.print(announVO3.getAnnouncementContent() + ",");
//	System.out.print(announVO3.getStartDate() + ",");
//	System.out.print(announVO3.getEndDate() + ",");
//	System.out.print(announVO3.getUpdateTime() + ",");
//	System.out.println(announVO3.getOffLoadStatus());
//	System.out.println(announVO3.getShowStatus());
//	System.out.println("---------------------");
//
//		// 查詢 OK!
//		List<AnnouncementVO> list = dao.getAll();
//		for (AnnouncementVO aAnnoun : list) {
//			System.out.print(aAnnoun.getAnnouncementSerialID() + ",");
//			System.out.print(aAnnoun.getAdministratorID() + ",");
//			System.out.print(aAnnoun.getAnnouncementTitle() + ",");
//			System.out.print(aAnnoun.getAnnouncementContent() + ",");
//			System.out.print(aAnnoun.getStartDate() + ",");
//			System.out.print(aAnnoun.getEndDate() + ",");
//			System.out.print(aAnnoun.getUpdateTime() + ",");
//			System.out.println(aAnnoun.getOffLoadStatus());
//			System.out.println(aAnnoun.getShowStatus());
//			System.out.println();
//		}
//	}

}
