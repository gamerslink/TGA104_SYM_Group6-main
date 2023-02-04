package com.group6.tibame104.memberBlockList.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group6.tibame104.memberBlockList.model.MemberBlockListService;
import com.group6.tibame104.memberBlockList.model.MemberBlockListVO;
import com.group6.tibame104.memberBlockList.model.ViewMemberBlockListVO;

@Controller
@RequestMapping("/front-end/memberBlockList")
public class MemberBlockListController {

	@Autowired
	private MemberBlockListService blockSvc;

	@PostMapping("/insert")
	public String insert(Model model, @RequestParam("memberID") Integer memberID,
			@RequestParam("storeID") Integer storeID) {

		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		model.addAttribute("errorMsgs", errorMsgs);

		/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

		MemberBlockListVO mblVO = new MemberBlockListVO();
		mblVO.setMemberID(memberID);
		mblVO.setStoreID(storeID);

		// Send the use back to the form, if there were errors
		model.addAttribute("mblVO", mblVO); // 含有輸入格式錯誤的empVO物件,也存入req
		if (!errorMsgs.isEmpty()) {
			return "/member/login.jsp";
		}
		/*************************** 2.開始新增資料 ***************************************/
//		System.out.println("memberID = " + memberID);
		mblVO = blockSvc.addBlock(memberID, storeID);

		model.addAttribute("mblVO", mblVO);
		/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/

		return "/front-end/member/my-account";
	}

	@PostMapping("/delete")
	public String delete(HttpSession session, @RequestParam("blockListID") Integer blockListID,
			@RequestParam("memberID") Integer memberID) {

		blockSvc.delete(blockListID);
		List<ViewMemberBlockListVO> memblVO = blockSvc.getAll(memberID);

		session.setAttribute("memblVO", memblVO);

		return "/front-end/member/my-account";

	}

}
