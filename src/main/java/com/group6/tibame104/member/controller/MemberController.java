package com.group6.tibame104.member.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.group6.tibame104.couponUsageHistory.model.CouponUsageHistoryService;
import com.group6.tibame104.couponUsageHistory.model.CouponUsageHistoryVO;
import com.group6.tibame104.creditCard.model.CreditCardService;
import com.group6.tibame104.creditCard.model.CreditCardVO;
import com.group6.tibame104.member.model.MailService;
import com.group6.tibame104.member.model.MemberService;
import com.group6.tibame104.member.model.MemberVO;
import com.group6.tibame104.memberBlockList.model.MemberBlockListService;
import com.group6.tibame104.memberBlockList.model.ViewMemberBlockListVO;
import com.group6.tibame104.shoppingGoldRecord.model.ShoppingGoldRecordService;
import com.group6.tibame104.shoppingGoldRecord.model.ShoppingGoldRecordVO;
import com.group6.tibame104.store.model.StoreJDBCDAO;
import com.group6.tibame104.store.model.StoreVO;

import redis.clients.jedis.Jedis;

@Controller
@RequestMapping("/front-end/member")
@MultipartConfig(fileSizeThreshold = 100 * 1024 * 1024, maxFileSize = 1000 * 1024 * 1024, maxRequestSize = 100 * 100
		* 1024 * 1024)
public class MemberController {
	@Autowired
	private MemberService memSvc;
	@Autowired
	private MailService mailSvc;
	@Autowired
	private CreditCardService cardSvc;
	@Autowired
	private MemberBlockListService blockSvc;
	@Autowired
	private CouponUsageHistoryService couponUsageHistorySvc;
	@Autowired
	private ShoppingGoldRecordService shoppingGoldRecordSvc;
	private Integer memberID;
	
	@PostMapping("/getOneForDisplay")
	public String getOneForDisplay(Model model, @RequestParam("memberID") Integer memberID) {

		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		model.addAttribute("errorMsgs", errorMsgs);

		MemberVO memVO = memSvc.getOneMem(memberID);

		model.addAttribute("memVO", memVO); // 資料庫取出的empVO物件,存入req
		return "/back-end/member/listAllMember";

	}

	@PostMapping("/getOneForUpdate")
	public String getOneForUpdate(Model model, @RequestParam("memberID") Integer memberID) {
		MemberVO memVO = memSvc.getOneMem(memberID);
		model.addAttribute("memVO", memVO); // 資料庫取出的empVO物件,存入req
		return "/member/update_member_input";
	}

	@PostMapping("/updateOne")
	public String updateOne(HttpSession session, Model model, @RequestParam("userName") String userName,
			@RequestParam("userAccount") String userAccount, @RequestParam("phone") String phone,
			@RequestParam("mail") String mail, @RequestParam("userPhoto") Part userPhoto,
			@RequestParam("idNumber") String idNumber, @RequestParam("address") String address,
			@RequestParam("memberID") Integer memberID) throws IOException {
		List<String> errorMsgsForupdate = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		model.addAttribute("errorMsgs", errorMsgsForupdate);

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		String userNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
		if (userName == null || userName.trim().length() == 0) {
			errorMsgsForupdate.add("使用者姓名: 請勿空白");
		} else if (!userName.trim().matches(userNameReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgsForupdate.add("使用者姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
		}

		String userAccountReg = "^[(a-zA-Z0-9_)]{5,10}$";
		if (userAccount == null || userAccount.trim().length() == 0) {
			errorMsgsForupdate.add("使用者帳號: 請勿空白");
		} else if (!userAccount.trim().matches(userAccountReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgsForupdate.add("使用者帳號: 只能是英文字母、數字和_ , 且長度必需在5到10之間");
		}

		String phoneReg = "^09\\d{8}$";
		if (phone == null || phone.trim().length() == 0) {
			phone = "";
		} else if (!phone.trim().matches(phoneReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgsForupdate.add("請輸入正確的手機號碼");
		}

		String mailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
		if (mail == null || mail.trim().length() == 0) {
			errorMsgsForupdate.add("使用者信箱: 請勿空白");
		} else if (!mail.trim().matches(mailReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgsForupdate.add("請輸入正確的信箱格式！");
		}
		// 圖片相關
		byte[] userPhoto1 = null;
		if (userPhoto.getSize() == 0) {
			userPhoto = null;
		} else {
			InputStream in = userPhoto.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(in);
			userPhoto1 = new byte[bis.available()];
			bis.read(userPhoto1);
			bis.close();
			in.close();
		}

		String idNumberReg = "^[A-Z]\\d{9}$";
		if (idNumber == null || idNumber.trim().length() == 0) {
			idNumber = "";
		} else if (!idNumber.trim().matches(idNumberReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgsForupdate.add("請輸入正確的身分證字號");
		}

		MemberVO memVO = new MemberVO();
		memVO.setUserName(userName);
		memVO.setUserAccount(userAccount);
		memVO.setPhone(phone);
		memVO.setMail(mail);
		memVO.setUserPhoto(userPhoto1);
		memVO.setIdNumber(idNumber);
		memVO.setAddress(address);
		memVO.setMemberID(memberID);

		// Send the use back to the form, if there were errors
		if (!errorMsgsForupdate.isEmpty()) {
			session.setAttribute("memVO", memVO);// 含有輸入格式錯誤的empVO物件,也存入req
			return "/front-end/member/my-account"; // 程式中斷
		}

		/*************************** 2.開始修改資料 *****************************************/

		memSvc.updateOneMember(memberID, userName, userAccount, phone, mail, userPhoto1, idNumber, address);
		memVO = memSvc.loginOneMem(mail);
		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		session.setAttribute("memVO", memVO); // 資料庫update成功後,正確的的memVO物件,存入req
		return "/front-end/member/my-account";

	}

	@PostMapping("/updateOnePassword")
	public String updateOnePassword(Model model, @RequestParam("memberID") Integer memberID,
			@RequestParam("userPassword") String userPassword, @RequestParam("oldPassword") String oldPassword) {

		List<String> errorMsgs = new LinkedList<String>();
		model.addAttribute("errorMsgs", errorMsgs);

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		MemberVO memVO = new MemberVO();
		memVO = memSvc.getOneMem(memberID);

		String userPasswordReg = "^[(a-zA-Z0-9)]{2,10}$";
		if (userPassword == null || userPassword.trim().length() == 0) {
			errorMsgs.add("使用者密碼: 請勿空白");
		} else if (!userPassword.trim().matches(userPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("使用者密碼: 只能是英文字母和數字 , 且長度必需在2到10之間");
		}

		if (!(memVO.getUserPassword()).equals(oldPassword)) {
			errorMsgs.add("舊密碼輸入錯誤!!!!");
		}

		if (!errorMsgs.isEmpty()) {
			return "/front-end/member/my-account"; // 程式中斷
		}

		/*************************** 2.開始修改資料 *****************************************/

		memSvc.updateMemberPassword(memberID,
				userPassword);/*************************** 3.修改完成,準備轉交(Send the Success view) *************/

		return "/front-end/member/my-account";

	}

	@PostMapping("/insert")
	public String insert(HttpSession session, Model model, @RequestParam("userAccount") String userAccount,
			@RequestParam("userPassword") String userPassword, @RequestParam("userName") String userName,
			@RequestParam("phone") String phone, @RequestParam("mail") String mail) {

		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		model.addAttribute("errorMsgs", errorMsgs);

		/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
		String userAccountReg = "^[(a-zA-Z0-9_)]{5,10}$";
		if (userAccount == null || userAccount.trim().length() == 0) {
			errorMsgs.add("使用者帳號: 請勿空白");
		} else if (!userAccount.trim().matches(userAccountReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("使用者帳號: 只能是英文字母、數字和_ , 且長度必需在5到10之間");
		}

		String userPasswordReg = "^[(a-zA-Z0-9)]{2,10}$";
		if (userPassword == null || userPassword.trim().length() == 0) {
			errorMsgs.add("使用者密碼: 請勿空白");
		} else if (!userPassword.trim().matches(userPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("使用者密碼: 只能是英文字母和數字 , 且長度必需在2到10之間");
		}

		String userNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
		if (userName == null || userName.trim().length() == 0) {
			errorMsgs.add("使用者姓名: 請勿空白");
		} else if (!userName.trim().matches(userNameReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("使用者姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
		}

		String phoneReg = "^09\\d{8}$";
		if (phone == null || phone.trim().length() == 0) {
			phone = "";
		} else if (!phone.trim().matches(phoneReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("請輸入正確的手機號碼");
		}

		String mailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
		if (mail == null || mail.trim().length() == 0) {
			errorMsgs.add("使用者信箱: 請勿空白");
		} else if (!mail.trim().matches(mailReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("請輸入正確的信箱格式！");
		}

		// 獲得時間戳記
		Timestamp registrationTime = new Timestamp(System.currentTimeMillis());// 獲取系統當前時間
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeStr = df.format(registrationTime);
		registrationTime = Timestamp.valueOf(timeStr);

		Boolean mailCertification = false;
		Boolean sellerAuditApprovalState = false;
		Integer currentShoppingCoin = 0;

		MemberVO memVO = new MemberVO();
		memVO.setUserAccount(userAccount);
		memVO.setUserPassword(userPassword);
		memVO.setUserName(userName);
		memVO.setPhone(phone);
		memVO.setMail(mail);
		memVO.setRegistrationTime(registrationTime);
		memVO.setMailCertification(mailCertification);
		memVO.setSellerAuditApprovalState(sellerAuditApprovalState);
		memVO.setCurrentShoppingCoin(currentShoppingCoin);
		// Send the use back to the form, if there were errors

		if ((memSvc.findMemberByMail(mail))) { // 【信箱無效時】
			errorMsgs.add("此信箱已有人使用");

		}

		if (!errorMsgs.isEmpty()) {
			model.addAttribute("memVO", memVO); // 含有輸入格式錯誤的empVO物件,也存入req
			return "/front-end/member/login"; // 程式中斷
		}

		// 產生亂數密碼
		// 建立一個新的Random物件
		Random rand = new Random();

		// 生成一個8位的亂數碼
		String passRandom = "";
		for (int i = 0; i < 8; i++) {
			int randomNumber = rand.nextInt(36);
			if (randomNumber < 10) {
				// 生成一個0-9的數字
				passRandom += randomNumber;
			} else {
				// 生成一個A-Z的英文字母
				passRandom += (char) (randomNumber + 55);
			}
		}

		// 傳送訊息通知使用者
		String subject = "SYM驗證碼";

		String messageText = "Hello! " + mail + " 此次驗證碼: " + passRandom + "\n" + "請使用此驗證碼進行註冊流程" + "\n" + "此驗證碼只保留五分鐘";

		mailSvc.sendMail(mail, subject, messageText);

		// 存進Redis裏
		Jedis jedis = new Jedis("localhost", 6379);
		jedis.set("passRandom", passRandom);
		jedis.expire("passRandom", 60 * 5);

		jedis.close();

		/*************************** 2.開始新增資料 ***************************************/
		session.setAttribute("memVO", memVO);

		return "/front-end/member/register";

	}

	@PostMapping("/mailVerification")
	public void mailVerification(HttpServletResponse res, HttpSession session, Model model,
			@RequestParam("vCode") String vCode) throws IOException {
		res.setCharacterEncoding("UTF-8");

		Map<String, String> msg = new HashMap<String, String>();

		Gson gson = new Gson();

		PrintWriter writer = res.getWriter();

		/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

		// 假設會員輸入驗證碼
		Jedis jedis = new Jedis("localhost", 6379);

		String passRandom = jedis.get("passRandom");

		if (passRandom == null) {
			msg.put("errorMsg", "連結信已逾時，請重新申請");
			String json = gson.toJson(msg);
			writer.write(json);
			return;
		} else if (!(vCode.equals(passRandom))) {
			msg.put("errorMsg", "驗證有誤，請重新輸入");
			String json = gson.toJson(msg);
			writer.write(json);
			return;
		} else if (vCode.equals(passRandom))
			jedis.close();

		MemberVO memVO = (MemberVO) session.getAttribute("memVO");
		String userAccount = memVO.getUserAccount();
		String userPassword = memVO.getUserPassword();
		String userName = memVO.getUserName();
		String phone = memVO.getPhone();
		String mail = memVO.getMail();
		Timestamp registrationTime = memVO.getRegistrationTime();
		Boolean mailCertification = memVO.getMailCertification();
		Boolean sellerAuditApprovalState = memVO.getSellerAuditApprovalState();
		Integer currentShoppingCoin = memVO.getCurrentShoppingCoin();

		/*************************** 2.開始新增資料 ***************************************/
		memVO = memSvc.addMember(userAccount, userPassword, userName, phone, mail, registrationTime, mailCertification,
				sellerAuditApprovalState, currentShoppingCoin);

		memVO = memSvc.loginOneMem(mail);

		mailCertification = true;// 驗證成功
		session.setAttribute("memVO", memVO);

		msg.put("succsess", mail);

		String json = gson.toJson(msg);
		writer.write(json);

	}

	@PostMapping("/update")
	public String update(HttpSession session, Model model, @RequestParam("gender") String gender,
			@RequestParam("birthday") java.sql.Date birthday, @RequestParam("userPhoto") Part userPhoto,
			@RequestParam("idNumber") String idNumber, @RequestParam("address") String address,
			@RequestParam("mail") String mail) throws IOException {

		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		model.addAttribute("errorMsgs", errorMsgs);

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/

		Boolean mailCertification = true;

		String idNumberReg = "^[A-Z]\\d{9}$";
		if (idNumber == null || idNumber.trim().length() == 0) {
			idNumber = "";
		} else if (!idNumber.trim().matches(idNumberReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("請輸入正確的身分證字號");
		}

//		java.sql.Date birthday1 = null;
//
//		try {
//			birthday1 = java.sql.Date.valueOf(birthday);
//		} catch (Exception e) {
//			birthday1 = null;
//			errorMsgs.add("請選擇生日！");
//		}

		Boolean sellerAuditApprovalState = false;

		Integer currentShoppingCoin = 0;

		// 圖片相關
		byte[] userPhoto1 = null;
		if (userPhoto.getSize() == 0) {
			userPhoto = null;
		} else {
			InputStream in = userPhoto.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(in);
			userPhoto1 = new byte[bis.available()];
			bis.read(userPhoto1);
			bis.close();
			in.close();
		}

		Integer memberID = memSvc.getOne();

		MemberVO memVO = new MemberVO();
		memVO.setGender(gender);
		memVO.setBirthday(birthday);
		memVO.setUserPhoto(userPhoto1);
		memVO.setMailCertification(mailCertification);
		memVO.setIdNumber(idNumber);
		memVO.setAddress(address);
		memVO.setSellerAuditApprovalState(sellerAuditApprovalState);
		memVO.setCurrentShoppingCoin(currentShoppingCoin);
		memVO.setMemberID(memberID);

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			model.addAttribute("memVO", memVO); // 含有輸入格式錯誤的empVO物件,也存入req
			return "/front-end/member/register2"; // 程式中斷
		}

		/*************************** 2.開始修改資料 *****************************************/

		memSvc.updateMember(memberID, gender, birthday, userPhoto1, mailCertification, idNumber, address,
				sellerAuditApprovalState, currentShoppingCoin);

		memVO = memSvc.loginOneMem(mail);

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		session.setAttribute("mail", mail);
		session.setAttribute("memVO", memVO); // 資料庫update成功後,正確的的memVO物件,存入req

		return "/front-end/member/my-account";
	}

	@PostMapping("/delete")
	public String delete(HttpSession session, Model model, @RequestParam("memberID") Integer memberID) {

		memSvc.deleteMember(memberID);

		return "/member/listAllMember";

	}

	@PostMapping("/getOneForLogin")
	public String getOneForLogin(HttpSession session, Model model, @RequestParam("mail") String mail,
			@RequestParam("userPassword") String userPassword) {
		List<String> errorMsgs1 = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		model.addAttribute("errorMsgs1", errorMsgs1);

		/*************************** 1.接收請求參數 ****************************************/
		String mailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
		if (mail == null || mail.trim().length() == 0) {
			errorMsgs1.add("使用者信箱: 請勿空白");
		} else if (!mail.trim().matches(mailReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs1.add("請輸入正確的信箱格式！");
		}

		String userPasswordReg = "^[(a-zA-Z0-9)]{2,10}$";
		if (userPassword == null || userPassword.trim().length() == 0) {
			errorMsgs1.add("使用者密碼: 請勿空白");
		} else if (!userPassword.trim().matches(userPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs1.add("使用者密碼: 只能是英文字母和數字 , 且長度必需在2到10之間");
		}

		MemberVO memVO = new MemberVO();
		memVO.setMail(mail);
		memVO.setUserPassword(userPassword);

		// Send the use back to the form, if there were errors
		if (!errorMsgs1.isEmpty()) {
			model.addAttribute("memVO2", memVO); // 含有輸入格式錯誤的empVO物件,也存入req
			return "/front-end/member/login"; // 程式中斷
		}

		if (!(memSvc.getOneForLogin(mail, userPassword))) { // 【帳號 , 密碼無效時】

			errorMsgs1.add("使用者帳號或密碼錯誤");
			if (!errorMsgs1.isEmpty()) {
				model.addAttribute("memVO", memVO); // 含有輸入格式錯誤的empVO物件,也存入req
				return "/front-end/member/login"; // 程式中斷
			}

		} else { // 【帳號 , 密碼有效時, 才做以下工作】
			session.setAttribute("mail", mail); // *工作1: 才在session內做已經登入過的標識

			try {

				memVO = memSvc.loginOneMem(mail);
				session.setAttribute("memVO", memVO); // 資料庫取出的empVO物件,存入req

				List<ViewMemberBlockListVO> memblVO = blockSvc.getAll(memVO.getMemberID());
				List<CreditCardVO> cardVO = cardSvc.getAll(memVO.getMemberID());
				session.setAttribute("cardVO", cardVO);// 資料庫取出的storeVO物件,存入req
				session.setAttribute("memblVO", memblVO);// 資料庫取出的storeVO物件,存入req
				StoreJDBCDAO storeJDBCDAO = new StoreJDBCDAO();
				StoreVO storeVO2 = storeJDBCDAO.findByPrimaryKey(memVO.getMemberID());
				List<CouponUsageHistoryVO> couponUsageHistoryVO = couponUsageHistorySvc.getAll2();
				session.setAttribute("couponUsageHistoryVO", couponUsageHistoryVO);
				List<ShoppingGoldRecordVO> shoppingGoldRecordVO = shoppingGoldRecordSvc.getAll();
				session.setAttribute("shoppingGoldRecordVO", shoppingGoldRecordVO);
				
				// 有賣場名稱才執行
				if (storeVO2 != null && storeVO2.getStoreName() != null) {
					String storeName = storeVO2.getStoreName();
//					System.out.println("storeName = " + storeName);
					session.setAttribute("storeName", storeName);
					session.setAttribute("storeVO2", storeVO2);
				}
				String location = (String) session.getAttribute("location");
				if (location != null) {
					session.removeAttribute("location");
					return "redirect:" + location;
				}
			} catch (Exception e) {
			}

		}
		return "/index"; // *工作3:
		// (-->如無來源網頁:則重導至login_success)
	}

	@PostMapping("/getOneForLogOut")
	public String getOneForLogOut(HttpSession session) {

		// 登出操作，清除用戶的登入狀態
		session.removeAttribute("mail");
		session.removeAttribute("storeName");
		session.removeAttribute("memVO");
		// 重定向到登入頁面
		return "/front-end/member/login";

	}

	@PostMapping("/forgetPassword")
	public void forgetPassword(HttpServletResponse res, Model model, @RequestParam("mail") String mail)
			throws IOException {
		res.setCharacterEncoding("UTF-8");

		Map<String, String> msg = new HashMap<String, String>();

		Gson gson = new Gson();

		PrintWriter writer = res.getWriter();

		MemberVO memVO = new MemberVO();
		/*************************** 1.接收請求參數 ****************************************/
		String mailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
		if (mail == null || mail.trim().length() == 0) {

			msg.put("errorMsg", "使用者信箱: 請勿空白");
			String json = gson.toJson(msg);

			writer.write(json);
			return;
		} else if (!mail.trim().matches(mailReg)) { // 以下練習正則(規)表示式(regular-expression)

			msg.put("errorMsg", "請輸入正確的信箱格式！");
			String json = gson.toJson(msg);
			writer.write(json);
			return;
		} else if (!(memSvc.findMemberByMail(mail))) { // 【帳號 , 密碼無效時】

			msg.put("errorMsg", "使用者信箱錯誤或查無此信箱");
			String json = gson.toJson(msg);
			writer.write(json);
			return;

		}

		// 產生亂數密碼
		// 建立一個新的Random物件
		Random rand = new Random();

		// 生成一個8位的亂數碼
		String passRandom = "";
		for (int i = 0; i < 8; i++) {
			int randomNumber = rand.nextInt(36);
			if (randomNumber < 10) {
				// 生成一個0-9的數字
				passRandom += randomNumber;
			} else {
				// 生成一個A-Z的英文字母
				passRandom += (char) (randomNumber + 55);
			}
		}

		// 取得該會員所有資料
		memVO = memSvc.loginOneMem(mail);

		// 把該會員的亂數密碼在資料庫做更新
		Integer memberID = memVO.getMemberID();
		memSvc.updateMemberPassword(memberID, passRandom);

		// 傳送訊息通知使用者
		String subject = "SYM密碼更新通知!";

		String username = memVO.getUserName();

		String messageText = "Hello! " + username + " 請謹記此密碼: " + passRandom + "\n" + " (已經啟用)" + "\n"
				+ "請使用此密碼進行登入及修改密碼";

		mailSvc.sendMail(mail, subject, messageText);

		msg.put("succsess", mail);

		String json = gson.toJson(msg);
		writer.write(json);

	}

	@PostMapping("/registerForShop")
	public String registerForShop(HttpSession session, Model model, @RequestParam("memberID") Integer memberID,
			@RequestParam("storeDelBankCode") String storeDelBankCode, @RequestParam("taxID") String taxID,
			@RequestParam("phoneNumber") String phoneNumber, @RequestParam("storeBankAccount") String storeBankAccount,
			@RequestParam("storeName") String storeName, @RequestParam("storeAddress") String storeAddress) {

		StoreVO storeVO = new StoreVO();
		StoreJDBCDAO dao = new StoreJDBCDAO();

		storeVO.setMemberID(memberID);
		storeVO.setStoreDelBankCode(storeDelBankCode);
		storeVO.setTaxID(taxID);
		storeVO.setPhoneNumber(phoneNumber);
		storeVO.setStoreBankAccount(storeBankAccount);
		storeVO.setStoreName(storeName);
		storeVO.setStoreAddress(storeAddress);

		// Send the use back to the form, if there were errors
		/*************************** 2.開始修改資料 *****************************************/

		dao.insert(storeVO);

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		session.setAttribute("storeName", storeName);
		session.setAttribute("storeVO", storeVO); // 資料庫update成功後,正確的的memVO物件,存入req
		return "front-end/store/myStore";

	}

}
