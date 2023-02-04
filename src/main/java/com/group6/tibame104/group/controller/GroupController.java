package com.group6.tibame104.group.controller;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group6.tibame104.group.model.GroupService;
import com.group6.tibame104.group.model.GroupVO;
import com.group6.tibame104.groupdiscount.model.GroupdiscountService;
import com.group6.tibame104.groupdiscount.model.GroupdiscountVO;
import com.group6.tibame104.groupproduct.model.GroupproductService;
import com.group6.tibame104.groupproduct.model.GroupproductVO;

@Controller
@RequestMapping("/front-end/group")
public class GroupController {
    @Autowired
    private GroupService groupSvc;
    @Autowired
    private GroupproductService groupproductSvc;
    @Autowired
    private GroupdiscountService groupdiscountSvc;

    @PostMapping("/getOne_For_Display")
    public String getOneForDisplay(Model model, @RequestParam("groupBuyID") String str) {
        List<String> errorMsgs = new LinkedList<String>();
        model.addAttribute("errorMsgs", errorMsgs);
        if (str == null || (str.trim()).length() == 0) {
            errorMsgs.add("請輸入折扣表編號");
        }
        if (!errorMsgs.isEmpty()) {
            return "front-end/groupdiscount/select_page";
        }

        Integer groupBuyID = null;
        try {
            groupBuyID = Integer.valueOf(str);
        } catch (Exception e) {
            errorMsgs.add("折扣表格式不正確");
        }
        if (!errorMsgs.isEmpty()) {
            return "front-end/groupdiscount/select_page";
        }
        
        GroupVO groupVO = groupSvc.getOneGroup(groupBuyID);
        if (groupVO == null) {
            errorMsgs.add("查無資料");
        }
        if (!errorMsgs.isEmpty()) {
            return "front-end/grouporder/select_page";
        }

        model.addAttribute("groupVO", groupVO);
        return "back-end/group/listOneEmp";
    }
    
    @PostMapping("/addOrder")
    public String addOrder(
            HttpSession session,
            Model model,
            @RequestParam("groupBuyID") String str,
            @RequestParam("groupBuyProductID") String str2,
            @RequestParam("groupBuyCount") String str3,
            HttpServletRequest req,
            HttpServletRequest res
        ) {
        List<String> errorMsgs = new LinkedList<String>();
        model.addAttribute("errorMsgs", errorMsgs);
        if (str == null || (str.trim()).length() == 0) {
            errorMsgs.add("請輸入折扣表編號");
        }
        if (!errorMsgs.isEmpty()) {
            return "front-end/groupdiscount/select_page";
        }

        Integer groupBuyID = null;
        try {
            groupBuyID = Integer.valueOf(str);
        } catch (Exception e) {
            errorMsgs.add("折扣表格式不正確1");
        }
        if (!errorMsgs.isEmpty()) {
            return "front-end/groupdiscount/select_page";
        }
       
        
        Integer groupBuyProductID = null;
        try {
            groupBuyProductID = Integer.valueOf(str2);
        } catch (Exception e) {
            errorMsgs.add("團購編號錯了");
        }
        // Send the use back to the form, if there were errors
        if (!errorMsgs.isEmpty()) {
            return "front-end/groupdiscount/select_page";
        }
        
        Double groupBuyCount = null;
        try {
            groupBuyCount = Double.valueOf(str3);
        } catch (Exception e) {
            errorMsgs.add("折扣表格不正確");
        }
        // Send the use back to the form, if there were errors
        if (!errorMsgs.isEmpty()) {
            return "front-end/groupdiscount/select_page";// 程式中斷
        }

        GroupVO groupVO = groupSvc.getOneGroup(groupBuyID);
        GroupproductVO groupproductVO = groupproductSvc.getOneGroupproduct(groupBuyProductID);

        if (groupVO == null) {
            errorMsgs.add("查無資料");
        }
        if (!errorMsgs.isEmpty()) {
            return "front-end/grouporder/select_page";}// 程式中斷
            /*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
            session.setAttribute("groupVO", groupVO); // 資料庫取出的empVO物件,存入req
            session.setAttribute("groupBuyCount", groupBuyCount);
            session.setAttribute("groupproductVO", groupproductVO);
            
            
//        Object account = session.getAttribute("mail");
//        if (account == null) {
//         session.setAttribute("location", req.getServletPath());
//         GroupVO groupVO = groupSvc.getOneGroup(groupBuyID);
//         GroupproductVO groupproductVO = groupproductSvc.getOneGroupproduct(groupBuyProductID);
//         session.setAttribute("groupVO", groupVO); 
//         session.setAttribute("groupproductVO", groupproductVO);
//         session.setAttribute("groupBuyCount", groupBuyCount);
//         return "/front-end/member/login";
//        }
//        if(groupBuyID != null) {
//        	
//        GroupVO groupVO1 = groupSvc.getOneGroup(groupBuyID);
//        GroupproductVO groupproductVO1 = groupproductSvc.getOneGroupproduct(groupBuyProductID);
//        model.addAttribute("groupVO", groupVO1); 
//        model.addAttribute("groupproductVO", groupproductVO1);
//        model.addAttribute("groupBuyCount", groupBuyCount);
//       
//        }
        
        return "front-end/group/addOrder";
        
    }
    @PostMapping("/getOneForUpdate")
    public String getOneForUpdate(
    		Model model,
    		@RequestParam("groupBuyID") Integer groupBuyID
    		) {
    	List<String> errorMsgs = new LinkedList<String>();
    	model.addAttribute("errorMsgs", errorMsgs);

		GroupVO groupVO = groupSvc.getOneGroup(groupBuyID);
		 List<GroupproductVO> groupproductVOs = groupproductSvc.getAll();
		/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
		model.addAttribute("groupVO", groupVO); // 資料庫取出的empVO物件,存入req
		model.addAttribute("groupproductVOs",groupproductVOs);
		return "back-end/group/updateGroup";
    }
   @PostMapping("/update")
   public String update(
		   Model model,
		   @RequestParam("groupBuyID") Integer groupBuyID,
		   @RequestParam("groupBuyProductID") Integer groupBuyProductID,
		   @RequestParam("administratorID") Integer administratorID,
		   @RequestParam("groupBuyProductOrderTotal") Integer groupBuyProductOrderTotal,
		   @RequestParam("groupBuyingState") Boolean groupBuyingState,
		   @RequestParam("groupBuyingOnLoadDate") Timestamp groupBuyingOnLoadDate,
		   @RequestParam("groupBuyingOffLoadDate") Timestamp groupBuyingOffLoadDate
		   
		   ) {
		List<String> errorMsgs = new LinkedList<String>();
		model.addAttribute("errorMsgs", errorMsgs);
//時間處理
		
		Timestamp updateTime = new Timestamp(System.currentTimeMillis());// 獲取系統當前時間

		GroupVO groupVO = new GroupVO();

		groupVO.setGroupBuyProductID(groupBuyProductID);
		groupVO.setAdministratorID(administratorID);
		groupVO.setGroupBuyProductOrderTotal(groupBuyProductOrderTotal);
		groupVO.setGroupBuyingState(groupBuyingState);
		groupVO.setGroupBuyingOnLoadDate(groupBuyingOnLoadDate);
		groupVO.setGroupBuyingOffLoadDate(groupBuyingOffLoadDate);
		groupVO.setUpdateTime(updateTime);
		groupVO.setGroupBuyID(groupBuyID);

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			model.addAttribute("groupVO", groupVO); // 含有輸入格式錯誤的empVO物件,也存入req
			return "/emp/update_emp_input.jsp"; // 程式中斷
		}

		/*************************** 2.開始修改資料 *****************************************/
		groupVO = groupSvc.updateGroup(groupBuyProductID, administratorID, groupBuyProductOrderTotal,
				groupBuyingState, groupBuyingOnLoadDate, groupBuyingOffLoadDate, updateTime, groupBuyID);

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		model.addAttribute("groupVO", groupVO); // 資料庫update成功後,正確的的empVO物件,存入req
	   return getAll(model);
   }
   @PostMapping("/insert")
   public String insert(
		   Model model,
		   @RequestParam("groupBuyProductID") Integer groupBuyProductID,
		   @RequestParam("administratorID") Integer administratorID,
		   @RequestParam("groupBuyProductOrderTotal") Integer groupBuyProductOrderTotal,
		   @RequestParam("groupBuyingState") Boolean groupBuyingState,
		   @RequestParam("groupBuyingOnLoadDate") Timestamp groupBuyingOnLoadDate,
		   @RequestParam("groupBuyingOffLoadDate") Timestamp groupBuyingOffLoadDate
		   ) {
	   
	   List<String> errorMsgs = new LinkedList<String>();
		model.addAttribute("errorMsgs", errorMsgs);

		/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

		// 獲得時間戳記
		Timestamp updateTime = new Timestamp(System.currentTimeMillis());// 獲取系統當前時間

		GroupVO groupVO = new GroupVO();

		groupVO.setGroupBuyProductID(groupBuyProductID);
		groupVO.setAdministratorID(administratorID);
		groupVO.setGroupBuyProductOrderTotal(groupBuyProductOrderTotal);
		groupVO.setGroupBuyingState(groupBuyingState);
		groupVO.setGroupBuyingOnLoadDate(groupBuyingOnLoadDate);
		groupVO.setGroupBuyingOffLoadDate(groupBuyingOffLoadDate);
		groupVO.setUpdateTime(updateTime);

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			model.addAttribute("groupVO", groupVO); // 含有輸入格式錯誤的empVO物件,也存入req
			return "/back-end/group/addEmp";
		}

		/*************************** 2.開始新增資料 ***************************************/
		groupVO = groupSvc.addGroup(groupBuyProductID, administratorID, groupBuyProductOrderTotal, groupBuyingState,
				groupBuyingOnLoadDate, groupBuyingOffLoadDate, updateTime);

		/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
		return getAll(model);
   }
	   @PostMapping("/delete")
	   public String delete(
			   Model model,
			   @RequestParam("groupBuyID") Integer groupBuyID
			   ) {
		   
		   List<String> errorMsgs = new LinkedList<String>();
			model.addAttribute("errorMsgs", errorMsgs);

			/*************************** 2.開始刪除資料 ***************************************/
			groupSvc.deleteGroup(groupBuyID);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			return getAll(model);
	   }
	   //團購主頁
	   @GetMapping("/allGroup")
	   public String allGroup(
			   Model model
			   ) {
		   
		  List<GroupproductVO> groupproductVOs = groupproductSvc.getAll();
		  List<GroupVO> groupVOs = groupSvc.getAll();
		  List<GroupdiscountVO> groupdiscountVOs = groupdiscountSvc.getAll();
		  
		  
//		  List<GroupVO> list = new ArrayList<GroupVO>();
//		  List<GroupproductVO> list2 = new ArrayList<GroupproductVO>();
//		  
//		 for(int i = 0; i < groupVOs.size();i++) {
//			 for(int j = 0; j< groupproductVOs.size(); j++ ) {
//				 
//				 if(groupVOs.get(i).getGroupBuyProductID() == groupproductVOs.get(j).getGroupBuyProductID()) {
//					
//					 System.out.println(i);
//					 list.add(groupVOs.get(i));
//					 System.out.println(j);
//					 list2.add(groupproductVOs.get(j));
//				 }
//			 }
//		 }
		  model.addAttribute("groupproductVOs",groupproductVOs);
		  model.addAttribute("groupVOs",groupVOs);
		  model.addAttribute("groupdiscountVOs",groupdiscountVOs);
		  
		   return "front-end/group/listAllGroup";
	   }
	   //團購主頁
	   @GetMapping("/getAllDesc")
	   public String getAllDesc(
			   Model model
			   ) {
		   
		  List<GroupproductVO> groupproductVOs = groupproductSvc.getAll();
		  List<GroupVO> groupVOs = groupSvc.getAllDesc();
		  List<GroupdiscountVO> groupdiscountVOs = groupdiscountSvc.getAll();

		  model.addAttribute("groupproductVOs",groupproductVOs);
		  model.addAttribute("groupVOs",groupVOs);
		  model.addAttribute("groupdiscountVOs",groupdiscountVOs);
		  
		   return "front-end/group/listAllGroup";
	   }
	   //團購主頁 數量排序
	   @GetMapping("/orderBy")
	   public String orderBy(
			   Model model
			   ) {
		   
		  List<GroupproductVO> groupproductVOs = groupproductSvc.getAll();
		  List<GroupVO> groupVOs = groupSvc.orderBy();
		  List<GroupdiscountVO> groupdiscountVOs = groupdiscountSvc.getAll();
		  model.addAttribute("groupproductVOs",groupproductVOs);
		  model.addAttribute("groupVOs",groupVOs);
		  model.addAttribute("groupdiscountVOs",groupdiscountVOs);
		   return "front-end/group/listAllGroup";
	   }
	   
	   //後台團購主頁用
	   @GetMapping("/getAll")
	   public String getAll(
			   Model model
			   ) {
		   List<GroupVO> groupVOs = groupSvc.getAll();
		   model.addAttribute("groupVOs",groupVOs);
		   List<GroupproductVO> groupproductVOs = groupproductSvc.getAll();
		   model.addAttribute("groupproductVOs",groupproductVOs);
		   return "back-end/group/listAllGroup";
	   }
	 //首頁測試用
	   @GetMapping("/index1")
	   public String index(
			   Model model
			   ) {
		   List<GroupVO> groupVOs = groupSvc.getAll();
		   model.addAttribute("groupVOs",groupVOs);
		   List<GroupproductVO> groupproductVOs = groupproductSvc.getAll();
		   model.addAttribute("groupproductVOs",groupproductVOs);
		   return "front-end/group/index";
	   }
	   //取得全部團購商品 for新增
	   @GetMapping("/getGroupproduct")
	   public String getGroupproduct(
			   Model model) {
		   
		   List<GroupproductVO> groupproductVOs = groupproductSvc.getAll();
		   model.addAttribute("groupproductVOs",groupproductVOs);
		   
		   return"back-end/group/addGroup";
	   }
	   //取得全部團購商品 for修改
	   @GetMapping("/getGroupproduct2")
	   public String getGroupproduct2(
			   Model model) {
		   
		   List<GroupproductVO> groupproductVOs = groupproductSvc.getAll();
		   model.addAttribute("groupproductVOs",groupproductVOs);
		   
		   return"back-end/group/updateGroup";
	   }
	   @GetMapping("/getJoinAll")
	   public String getJoinAll(
			   Model model) {
		   List<Object> groupVOs = groupSvc.getJoinAll();
		   model.addAttribute("groupVOs",groupVOs);
		   System.out.println("123");
		   return "front-end/group/listAllGroup";
	   }
}