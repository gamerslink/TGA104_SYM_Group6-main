package com.group6.tibame104.groupdiscount.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group6.tibame104.groupdiscount.model.GroupdiscountService;
import com.group6.tibame104.groupdiscount.model.GroupdiscountVO;

@Controller
@RequestMapping("/Groupdiscount")
public class GroupdiscountController {
	@Autowired
	private GroupdiscountService groupdiscountSvc;
	
	//新增
	@PostMapping("/insert")
	public String insert(Model model, 
			@RequestParam("groupBuyID") String str1,
			@RequestParam("groupBuyProductOrderTotal") String str2, 
			@RequestParam("groupBuyCount") String str3) {
		List<String> errorMsgs = new LinkedList<String>();
		model.addAttribute("errorMsgs", errorMsgs);

		Integer groupBuyID = null;
		Integer groupBuyProductOrderTotal = null;
		Double groupBuyCount = null;
		try {
			groupBuyID = Integer.parseInt(str1);
		} catch (NumberFormatException e) {
			errorMsgs.add("Group buy ID 必須是整數");
		}

		try {
			groupBuyProductOrderTotal = Integer.parseInt(str2);
		} catch (NumberFormatException e) {
			errorMsgs.add("Group buy product order total 必須是整數");
		}

		try {
			groupBuyCount = Double.parseDouble(str3);
		} catch (NumberFormatException e) {
			errorMsgs.add("Group buy count 必須是數字");
		}
		GroupdiscountVO groupdiscountVO = new GroupdiscountVO();
		groupdiscountVO.setGroupBuyID(groupBuyID);
		groupdiscountVO.setGroupBuyProductOrderTotal(groupBuyProductOrderTotal);
		groupdiscountVO.setGroupBuyCount(groupBuyCount);

		if (!errorMsgs.isEmpty()) {
			model.addAttribute("groupdiscountVO", groupdiscountVO);
			return "/back-end/groupdiscount/listAllGroupDiscount";
		}

		groupdiscountSvc.addGroupdiscount(groupBuyID, groupBuyProductOrderTotal, groupBuyCount);
		List<GroupdiscountVO> list = groupdiscountSvc.getAll();
		model.addAttribute("list", list);
		return "/back-end/groupdiscount/listAllGroupDiscount";
	}
	
	//修改
	@PostMapping("/update")
	public String update(Model model, 
			@RequestParam("countTableID") Integer countTableID,
			@RequestParam("groupBuyID") Integer groupBuyID,
			@RequestParam("groupBuyProductOrderTotal") Integer groupBuyProductOrderTotal,
			@RequestParam("groupBuyCount") Double groupBuyCount) {

		groupdiscountSvc.updateGroupdiscount(countTableID, groupBuyID, groupBuyProductOrderTotal, groupBuyCount);

		List<GroupdiscountVO> list = groupdiscountSvc.getAll();
		model.addAttribute("list", list);
		return "/back-end/groupdiscount/listAllGroupDiscount";
	}
	
	
	//刪除
	@PostMapping("/delete")
	public String delete(Model model, @RequestParam("countTableID") String str) {
		List<String> errorMsgs = new LinkedList<String>();
		model.addAttribute("errorMsgs", errorMsgs);

		Integer countTableID = null;

		try {
			countTableID = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			errorMsgs.add("輸入的參數格式不正確");
		}

		if (!errorMsgs.isEmpty()) {
			return "/back-end/groupdiscount/listAllGroupDiscount";
		}

		groupdiscountSvc.deleteGroupdiscount(countTableID);
		List<GroupdiscountVO> list = groupdiscountSvc.getAll();
		model.addAttribute("list", list);
		return "/back-end/groupdiscount/listAllGroupDiscount";

	}
	
	//查詢全部
	@GetMapping("/getAll")
	public String getAll(HttpSession session, Model model) {
		List<GroupdiscountVO> list = groupdiscountSvc.getAll();
		model.addAttribute("list", list);
		return "back-end/groupdiscount/listAllGroupDiscount";
	}
	
//	//PK查詢
//	@GetMapping("/getPK4Display")
//	public String getPK4Display(Model model, @RequestParam("countTableID") String str) {
//		List<String> errorMsgs = new LinkedList<String>();
//		model.addAttribute("errorMsgs", errorMsgs);
//
//		if (str == null || (str.trim()).length() == 0) {
//			errorMsgs.add("請輸入折扣表編號");
//		}
//		if (!errorMsgs.isEmpty()) {
//			return "/front-end/groupdiscount/select_page";
//		}
//
//		Integer countTableID = null;
//		try {
//			countTableID = Integer.valueOf(str);
//		} catch (Exception e) {
//			errorMsgs.add("折扣表格式不正確");
//		}
//
//		if (!errorMsgs.isEmpty()) {
//			return "/front-end/groupdiscount/select_page";
//		}
//
//		GroupdiscountVO groupdiscountVO = groupdiscountSvc.getByPK(countTableID);
//
//		if (groupdiscountVO == null) {
//			errorMsgs.add("查無資料");
//		}
//
//		if (!errorMsgs.isEmpty()) {
//			return "/front-end/groupdiscount/select_page";
//		}
//
//		model.addAttribute("groupdiscountVO", groupdiscountVO);
//		return "/front-end/groupdiscount/listOneEmp";
//	}
	
	
//	//GroupBuyID查詢
//	@GetMapping("/getAllGroupBuyID4Display")
//	public String getAllGroupBuyID4Display(Model model, @RequestParam("groupBuyID") String str) {
//		List<String> errorMsgs = new LinkedList<String>();
//		model.addAttribute("errorMsgs", errorMsgs);
//		if (str == null || (str.trim()).length() == 0) {
//			errorMsgs.add("請輸入折扣表編號");
//		}
//		if (!errorMsgs.isEmpty()) {
//			return "/back-end/groupdiscount/listAllGroup";
//		}
//		Integer groupBuyID = null;
//		try {
//			groupBuyID = Integer.valueOf(str);
//		} catch (Exception e) {
//			errorMsgs.add("折扣表格式不正確");
//		}
//		if (!errorMsgs.isEmpty()) {
//			return "/back-end/groupdiscount/listAllGroup";
//		}
//		List<GroupdiscountVO> list = groupdiscountSvc.getAllByGroupBuyID(groupBuyID);
//		if (list.isEmpty()) {
//			errorMsgs.add("查無資料");
//		}
//		if (!errorMsgs.isEmpty()) {
//			return "/front-end/grouporder/select_page";
//		}
//		model.addAttribute("list", list);
//		return "/back-end/groupdiscount/listAllGroup";
//	}
//
//	
//	//
//	@GetMapping("/getPK4Update")
//	public String getPK4Update(Model model, @RequestParam("countTableID") String str) {
//		List<String> errorMsgs = new LinkedList<String>();
//		model.addAttribute("errorMsgs", errorMsgs);
//
//		Integer countTableID = null;
//		try {
//			countTableID = Integer.parseInt(str);
//		} catch (NumberFormatException e) {
//			errorMsgs.add("輸入的參數格式不正確");
//			return "/back-end/groupdiscount/update_discount";
//		}
//		GroupdiscountVO groupdiscountVO = groupdiscountSvc.getByPK(countTableID);
//
//		model.addAttribute("groupdiscountVO", groupdiscountVO);
//		return "/back-end/groupdiscount/addGroupDiscount";
//	}

	
}