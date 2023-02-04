package com.group6.tibame104.announcement.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AnnouncementService {
	@Autowired
	private AnnouncementDAO_interface dao;

	public AnnouncementVO insertAnnoun(
			Integer administratorID,
			String announcementTitle,
			String announcementContent,
			Date startDate, 
			Date endDate,
			Boolean offLoadStatus,
			Boolean showStatus) {
		
		AnnouncementVO announcementVO = new AnnouncementVO();
		
		announcementVO.setAdministratorID(administratorID);
		announcementVO.setAnnouncementTitle(announcementTitle);
		announcementVO.setAnnouncementContent(announcementContent);
		announcementVO.setStartDate(startDate);
		announcementVO.setEndDate(endDate);
		announcementVO.setOffLoadStatus(offLoadStatus);
		announcementVO.setShowStatus(showStatus);
		dao.insert(announcementVO);

		return announcementVO;
	}

	public AnnouncementVO updateAnnoun(
			Integer announcementSerialID,
			Integer administratorID, 
			String announcementTitle, 
			String announcementContent, 
			Date startDate,
			Date endDate,
			Boolean offLoadStatus, 
			Boolean showStatus) {
		AnnouncementVO announcementVO = new AnnouncementVO();
		announcementVO.setAnnouncementSerialID(announcementSerialID);
		announcementVO.setAdministratorID(administratorID);
		announcementVO.setAnnouncementTitle(announcementTitle);
		announcementVO.setAnnouncementContent(announcementContent);
		announcementVO.setStartDate(startDate);
		announcementVO.setEndDate(endDate);
		announcementVO.setOffLoadStatus(offLoadStatus);
		announcementVO.setShowStatus(showStatus);
		dao.update(announcementVO);

		return announcementVO;
	}
	
	public void deleteAnnoun(Integer announcementSerialID) {
		dao.delete(announcementSerialID);
	}

	public List<AnnouncementVO> getAnnounByPK(Integer announcementSerialID) {
		return dao.findByPK(announcementSerialID);
	}
	
	public List<AnnouncementVO> getAnnounByTitle(String announcementTitle) {
		return dao.findByTitle(announcementTitle);
	}
	
	public List<AnnouncementVO> getAnnounByOffLoadStatus(Boolean offLoadStatus) {
		return dao.findByOffLoadStatus(offLoadStatus);
	}
	
	public List<AnnouncementVO> getAnnounByShowStatus(Boolean showStatus) {
		return dao.findByShowStatus(showStatus);
	}
	
	public List<AnnouncementVO> getAllAnnoun() {
		return dao.findAll();
	}

	public List<AnnouncementVO> getIndexNews() {
		return dao.findIndexNews();
	}


//	public static void main(String[] args) {
//
//		MemberService memberservice = new MemberService();
//
//		Integer a = memberservice.getOne();
//		System.out.println(a);
//
//		byte[] userPhoto = new byte[3];
//
//		// 獲得時間戳記
//		Timestamp time = new Timestamp(System.currentTimeMillis());// 獲取系統當前時間
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String timeStr = df.format(time);
//		time = Timestamp.valueOf(timeStr);
//
//		Boolean mailCertification = true;
//		Boolean sellerAuditApprovalState = true;
//
//		memberservice.addMember("a22222222", "ccccccccc", "林茶陶巴巴", "0988888888", "a2633333@gmail.com", "M",
//				java.sql.Date.valueOf("1993-01-02"), userPhoto, time, mailCertification, "F128888888", "台北市ＸＸ區ＸＸ路",
//				sellerAuditApprovalState, 100);
//
//	}
}
