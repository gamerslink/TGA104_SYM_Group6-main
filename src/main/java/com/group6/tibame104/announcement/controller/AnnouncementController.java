package com.group6.tibame104.announcement.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group6.tibame104.announcement.model.AnnouncementService;
import com.group6.tibame104.announcement.model.AnnouncementVO;

@Controller
@RequestMapping("/Announcement")
public class AnnouncementController {
	@Autowired
	private AnnouncementService announSvc;
	
	//新增
	@PostMapping("/insert")
	public String insert(Model model,
			@RequestParam("administratorID") Integer administratorID,
			@RequestParam("announcementTitle") String announcementTitle,
			@RequestParam("announcementContent") String announcementContent,
			@RequestParam("startDate") Date startDate,
			@RequestParam("endDate") Date endDate,
			@RequestParam("offLoadStatus") Boolean offLoadStatus,
			@RequestParam("showStatus") Boolean showStatus) {
//		List<String> errorMsgs = new LinkedList<String>();
//		model.addAttribute("errorMsgs", errorMsgs);
		
		//未檢查請求參數
		
		announSvc.insertAnnoun(administratorID, announcementTitle, announcementContent, startDate, endDate, offLoadStatus, showStatus);
		
		//		// 獲得時間戳記(JDBC方法已改已不需要)
//		Timestamp updateTime = new Timestamp(System.currentTimeMillis());// 獲取系統當前時間
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String strUpdateTime = df.format(updateTime);
//		updateTime = Timestamp.valueOf(strUpdateTime);
		List<AnnouncementVO> list = announSvc.getAllAnnoun();
		model.addAttribute("list",list);	
		return "/back-end/announcement/announcementSearch";	
	}
	
	
	//修改
	@PostMapping("/update")
	public String update(HttpSession session, Model model,
			@RequestParam("announcementSerialID") Integer announcementSerialID,
			@RequestParam("administratorID") Integer administratorID,
			@RequestParam("announcementTitle") String announcementTitle,
			@RequestParam("announcementContent") String announcementContent,
			@RequestParam("startDate") Date startDate,
			@RequestParam("endDate") Date endDate,
			@RequestParam("offLoadStatus") Boolean offLoadStatus,
			@RequestParam("showStatus") Boolean showStatus) {
		
//		List<String> errorMsgs = new LinkedList<String>();
//		session.setAttribute("errorMsgs", errorMsgs);	
		
		announSvc.updateAnnoun(
				announcementSerialID,
				administratorID,
				announcementTitle,
				announcementContent,
				startDate,
				endDate,
				offLoadStatus,
				showStatus);
		List<AnnouncementVO> list = announSvc.getAllAnnoun();
		session.setAttribute("list", list);
		return "/back-end/announcement/announcementSearch";	
	}
	
	//刪除
	@PostMapping("/delete")
	public String delete(Model model, @RequestParam("announcementSerialID") Integer announcementSerialID) {

		announSvc.deleteAnnoun(announcementSerialID);
		List<AnnouncementVO> list = announSvc.getAllAnnoun();
		model.addAttribute("list", list);
		return "/back-end/announcement/announcementSearch";

	}
	
	//=============================================================================================================//
	
	@PostMapping("/search")
	public String search(Model model,
			@RequestParam("searchID") String searchID, 
			@RequestParam("searchValue") String searchValue) {
		List<AnnouncementVO> list = null;
		// 根據 searchID 和 searchValue 進行查詢
	
		switch (searchID) {
		case "1":
			// 查詢By公告編號
			list = announSvc.getAnnounByPK(Integer.valueOf(searchValue));
			model.addAttribute("list", list);
//			System.out.println("1:"+list);
			break;
		case "2":
			// 查詢By公告標題
			list = announSvc.getAnnounByTitle(searchValue);
			model.addAttribute("list", list);
//			System.out.println("2:"+list);
			break;
		case "3":
			// 查詢By公告狀態
			list = announSvc.getAnnounByOffLoadStatus(Boolean.valueOf(searchValue));
			model.addAttribute("list", list);
//			System.out.println("3:"+list);
			break;
		case "4":
			// 查詢By公告位置
			list = announSvc.getAnnounByShowStatus(Boolean.parseBoolean(searchValue));
			model.addAttribute("list", list);
//			System.out.println("4:"+list);
			break;
		case "5":
			// 查詢By公告位置
			list = announSvc.getAllAnnoun();
			model.addAttribute("list", list);
//			System.out.println("5:"+list);
			break;
		}
			// 返回查詢結果
			return "/back-end/announcement/announcementSearch";
		}
	
	//查詢全部公告
	@GetMapping("/getAll")
	public String getAll(HttpSession session, Model model) {
		List<AnnouncementVO> list = announSvc.getAllAnnoun();
		session.setAttribute("list", list);
		return "back-end/announcement/announcementSearch";
	}
	
	//查詢首頁公告
		@PostMapping("/getIndexNews")
		public String getIndexNews(Model model) {
			List<AnnouncementVO> list2 = announSvc.getIndexNews();
			model.addAttribute("list2", list2);
			return "back-end/announcement/announcementSearch";
		}
	//查詢所有首頁公告
		@GetMapping("/getIndexNews2")
		public String getIndexNews2(Model model) {
			List<AnnouncementVO> list3 = announSvc.getIndexNews();
			model.addAttribute("list3", list3);
			return "front-end/announcement/listAllAnnoun";
		}
	
//	//PK查詢
//	@GetMapping("/getPK4Display")
//	public String getPK4Display(Model model, @RequestParam("announcementSerialID") Integer announcementSerialID) {
//			
//		AnnouncementVO announcementVO = announSvc.getAnnounByPK(announcementSerialID);
//		model.addAttribute("announcementVO", announcementVO);
//		return "/back-end/announcement/announcementSearch";	
//		}
//	
//
//
//	//Title查詢
//	@GetMapping("/getTitle4Display")
//	public String getTitle4Display(Model model, @RequestParam("announcementTitle") String announcementTitle ) {
//		
//		List<AnnouncementVO> announcementVOs = announSvc.getAnnounByTitle(announcementTitle );
//		model.addAttribute("announcementVOs", announcementVOs);
//		return "/back-end/announcement/announcementSearch";	
//		}
//	
//	//OffLoadStatus查詢
//	@GetMapping("/getOffLoadStatus4Display")
//	public String getOffLoadStatus4Display(Model model, @RequestParam("offLoadStatus") Boolean offLoadStatus ) {
//		
//		List<AnnouncementVO> announcementVOs = announSvc.getAnnounByOffLoadStatus(offLoadStatus );
//		model.addAttribute("announcementVOs", announcementVOs);
//		return "/back-end/announcement/announcementSearch";	
//		}
//	
//	//ShowStatus查詢
//	@GetMapping("/getShowStatus4Display")
//	public String getShowStatus4Display(Model model, @RequestParam("showStatus") Boolean showStatus ) {
//		
//		List<AnnouncementVO> announcementVOs = announSvc.getAnnounByShowStatus(showStatus );
//		model.addAttribute("announcementVOs", announcementVOs);
//		return "/back-end/announcement/announcementSearch";	
//		}
	
	
	
	
	
//	String searchID = request.getParameter("searchID");
//
//	// Use the selected option value in your controller logic
//	if (searchID.equals("option1")) {
//	  // Do something
//	} else if (searchID.equals("option2")) {
//	  // Do something else
//	}
	
}
