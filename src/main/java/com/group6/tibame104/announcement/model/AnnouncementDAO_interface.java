package com.group6.tibame104.announcement.model;

import java.util.List;


public interface AnnouncementDAO_interface {
	//新增公告
	 public void insert(AnnouncementVO announcementVO);
	 
	 //修改公告
    public void update(AnnouncementVO announcementVO);
    
    //刪除公告
    public void delete(Integer announcementSerialID);
    
    //使用流水編號查詢
    public List<AnnouncementVO> findByPK(Integer announcementSerialID); 
    
    //使用公告標題查詢
    public List<AnnouncementVO> findByTitle(String announcementTitle);
    
    //使用上架狀態查詢
    public List<AnnouncementVO> findByOffLoadStatus(Boolean offLoadStatus);
    
    //使用公告位置查詢
    public List<AnnouncementVO> findByShowStatus(Boolean showStatus);
    
    //查詢首頁上架公告
    public List<AnnouncementVO> findIndexNews();
    
    //查詢所有公告
    public List<AnnouncementVO> findAll();

    



    
    
//    //使用管理員編號查詢
//    public AnnouncementVO findByAdminID(Integer administratorID);
//    
   
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<AnnouncementVO> getAll(Map<String, String[]> map); 
}
