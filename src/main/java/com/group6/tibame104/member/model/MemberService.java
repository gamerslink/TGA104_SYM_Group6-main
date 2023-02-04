package com.group6.tibame104.member.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberDAO_interface dao;

	public MemberVO addMember(String userAccount, String userPassword, String userName, String phone, String mail,
			Timestamp registrationTime, Boolean mailCertification, Boolean sellerAuditApprovalState,
			Integer currentShoppingCoin) {
		MemberVO memberVO = new MemberVO();

		memberVO.setUserAccount(userAccount);
		memberVO.setUserPassword(userPassword);
		memberVO.setUserName(userName);
		memberVO.setPhone(phone);
		memberVO.setMail(mail);
		memberVO.setRegistrationTime(registrationTime);
		memberVO.setMailCertification(mailCertification);
		memberVO.setSellerAuditApprovalState(sellerAuditApprovalState);
		memberVO.setCurrentShoppingCoin(currentShoppingCoin);
		dao.insert(memberVO);

		return memberVO;
	}

	public MemberVO updateMember(Integer memberID, String gender, Date birthday, byte[] userPhoto,
			Boolean mailCertification, String idNumber, String address, Boolean sellerAuditApprovalState,
			Integer currentShoppingCoin) {
		MemberVO memberVO = new MemberVO();

		memberVO.setMemberID(memberID);
		memberVO.setGender(gender);
		memberVO.setBirthday(birthday);
		memberVO.setUserPhoto(userPhoto);
		memberVO.setMailCertification(mailCertification);
		memberVO.setIdNumber(idNumber);
		memberVO.setAddress(address);
		memberVO.setSellerAuditApprovalState(sellerAuditApprovalState);
		memberVO.setCurrentShoppingCoin(currentShoppingCoin);
		dao.update(memberVO);

		return memberVO;
	}

	public MemberVO updateOneMember(Integer memberID, String userName, String userAccount, String phone, String mail,
			byte[] userPhoto, String idNumber, String address) {
		MemberVO memberVO = new MemberVO();

		memberVO.setMemberID(memberID);
		memberVO.setUserName(userName);
		memberVO.setUserAccount(userAccount);
		memberVO.setPhone(phone);
		memberVO.setMail(mail);
		memberVO.setUserPhoto(userPhoto);
		memberVO.setIdNumber(idNumber);
		memberVO.setAddress(address);
		dao.updateOne(memberVO);

		return memberVO;
	}

	public MemberVO updateMemberPassword(Integer memberID, String userPassword) {
		MemberVO memberVO = new MemberVO();

		memberVO.setMemberID(memberID);
		memberVO.setUserPassword(userPassword);
		dao.updateOnePasswoed(memberVO);

		return memberVO;
	}

	public void deleteMember(Integer memberID) {
		dao.delete(memberID);
	}

	public MemberVO getOneMem(Integer memberID) {
		return dao.getByPrimaryKey(memberID);
	}

	public MemberVO loginOneMem(String mail) {
		return dao.getOneMemberByMail(mail);
	}

	public Integer getOne() {
		return dao.selectLastMemberID();
	}

	public Boolean getOneForLogin(String mail, String userPassword) {
		return dao.findOneMemberForLogin(mail, userPassword);
	}

	public List<MemberVO> getAll() {
		return dao.getAll();
	}

	public boolean findMemberByMail(String mail) {
		return dao.findMemberByMail(mail);
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
