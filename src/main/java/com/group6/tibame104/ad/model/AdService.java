package com.group6.tibame104.ad.model;

import java.sql.Date;
import java.util.List;


public class AdService {

	private AdDAO_interface dao;

	public AdService() {
		dao = new AdJDBCDAO();
	}

	public AdVO addAd(Integer administratorID, Integer groupBuyID, String adTitle, String adType, String adDescribe,
			Date adStartDate, Date adEndDate, byte[] adPhoto) {

		AdVO adVO = new AdVO();	

		adVO.setAdministratorID(administratorID);
		adVO.setGroupBuyID(groupBuyID);
		adVO.setAdTitle(adTitle);
		adVO.setAdType(adType);
		adVO.setAdDescribe(adDescribe);
		adVO.setAdStartDate(adStartDate);
		adVO.setAdEndDate(adEndDate);
		adVO.setAdPhoto(adPhoto);
//		adVO.setUpdateTime(updateTime);

		dao.insert(adVO);
		return adVO;
	}

	public AdVO updateAd(Integer adSerialID, String adTitle, String adType, String adDescribe, byte[] adPhoto,
			Date adStartDate, Date adEndDate) {

		AdVO adVO = new AdVO();

		// 圖片上傳
		

		adVO.setAdSerialID(adSerialID);
//		adVO.setGroupBuyID(groupBuyID);
		adVO.setAdTitle(adTitle);
		adVO.setAdType(adType);
		adVO.setAdDescribe(adDescribe);
		adVO.setAdPhoto(adPhoto);
		adVO.setAdStartDate(adStartDate);
		adVO.setAdEndDate(adEndDate);
//		adVO.setUpdateTime(updateTime);

		dao.update(adVO);

		return adVO;
	}

	public void deleteAd(Integer adSerialID) {
		dao.delete(adSerialID);
	}

	public AdVO getOneAd(Integer adSerialID) {
		return dao.findByPrimaryKey(adSerialID);
	}

	public List<AdVO> getAll() {
		return dao.getAll();
	}
}
