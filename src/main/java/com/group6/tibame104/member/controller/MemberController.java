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

		model.addAttribute("memVO", memVO); // ??????????????????empVO??????,??????req
		return "/back-end/member/listAllMember";

	}

	@PostMapping("/getOneForUpdate")
	public String getOneForUpdate(Model model, @RequestParam("memberID") Integer memberID) {
		MemberVO memVO = memSvc.getOneMem(memberID);
		model.addAttribute("memVO", memVO); // ??????????????????empVO??????,??????req
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

		/*************************** 1.?????????????????? - ??????????????????????????? **********************/
		String userNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
		if (userName == null || userName.trim().length() == 0) {
			errorMsgsForupdate.add("???????????????: ????????????");
		} else if (!userName.trim().matches(userNameReg)) { // ??????????????????(???)?????????(regular-expression)
			errorMsgsForupdate.add("???????????????: ???????????????????????????????????????_ , ??????????????????2???10??????");
		}

		String userAccountReg = "^[(a-zA-Z0-9_)]{5,10}$";
		if (userAccount == null || userAccount.trim().length() == 0) {
			errorMsgsForupdate.add("???????????????: ????????????");
		} else if (!userAccount.trim().matches(userAccountReg)) { // ??????????????????(???)?????????(regular-expression)
			errorMsgsForupdate.add("???????????????: ?????????????????????????????????_ , ??????????????????5???10??????");
		}

		String phoneReg = "^09\\d{8}$";
		if (phone == null || phone.trim().length() == 0) {
			phone = "";
		} else if (!phone.trim().matches(phoneReg)) { // ??????????????????(???)?????????(regular-expression)
			errorMsgsForupdate.add("??????????????????????????????");
		}

		String mailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
		if (mail == null || mail.trim().length() == 0) {
			errorMsgsForupdate.add("???????????????: ????????????");
		} else if (!mail.trim().matches(mailReg)) { // ??????????????????(???)?????????(regular-expression)
			errorMsgsForupdate.add("?????????????????????????????????");
		}
		// ????????????
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
		} else if (!idNumber.trim().matches(idNumberReg)) { // ??????????????????(???)?????????(regular-expression)
			errorMsgsForupdate.add("?????????????????????????????????");
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
			session.setAttribute("memVO", memVO);// ???????????????????????????empVO??????,?????????req
			return "/front-end/member/my-account"; // ????????????
		}

		/*************************** 2.?????????????????? *****************************************/

		memSvc.updateOneMember(memberID, userName, userAccount, phone, mail, userPhoto1, idNumber, address);
		memVO = memSvc.loginOneMem(mail);
		/*************************** 3.????????????,????????????(Send the Success view) *************/
		session.setAttribute("memVO", memVO); // ?????????update?????????,????????????memVO??????,??????req
		return "/front-end/member/my-account";

	}

	@PostMapping("/updateOnePassword")
	public String updateOnePassword(Model model, @RequestParam("memberID") Integer memberID,
			@RequestParam("userPassword") String userPassword, @RequestParam("oldPassword") String oldPassword) {

		List<String> errorMsgs = new LinkedList<String>();
		model.addAttribute("errorMsgs", errorMsgs);

		/*************************** 1.?????????????????? - ??????????????????????????? **********************/
		MemberVO memVO = new MemberVO();
		memVO = memSvc.getOneMem(memberID);

		String userPasswordReg = "^[(a-zA-Z0-9)]{2,10}$";
		if (userPassword == null || userPassword.trim().length() == 0) {
			errorMsgs.add("???????????????: ????????????");
		} else if (!userPassword.trim().matches(userPasswordReg)) { // ??????????????????(???)?????????(regular-expression)
			errorMsgs.add("???????????????: ?????????????????????????????? , ??????????????????2???10??????");
		}

		if (!(memVO.getUserPassword()).equals(oldPassword)) {
			errorMsgs.add("?????????????????????!!!!");
		}

		if (!errorMsgs.isEmpty()) {
			return "/front-end/member/my-account"; // ????????????
		}

		/*************************** 2.?????????????????? *****************************************/

		memSvc.updateMemberPassword(memberID,
				userPassword);/*************************** 3.????????????,????????????(Send the Success view) *************/

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

		/*********************** 1.?????????????????? - ??????????????????????????? *************************/
		String userAccountReg = "^[(a-zA-Z0-9_)]{5,10}$";
		if (userAccount == null || userAccount.trim().length() == 0) {
			errorMsgs.add("???????????????: ????????????");
		} else if (!userAccount.trim().matches(userAccountReg)) { // ??????????????????(???)?????????(regular-expression)
			errorMsgs.add("???????????????: ?????????????????????????????????_ , ??????????????????5???10??????");
		}

		String userPasswordReg = "^[(a-zA-Z0-9)]{2,10}$";
		if (userPassword == null || userPassword.trim().length() == 0) {
			errorMsgs.add("???????????????: ????????????");
		} else if (!userPassword.trim().matches(userPasswordReg)) { // ??????????????????(???)?????????(regular-expression)
			errorMsgs.add("???????????????: ?????????????????????????????? , ??????????????????2???10??????");
		}

		String userNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
		if (userName == null || userName.trim().length() == 0) {
			errorMsgs.add("???????????????: ????????????");
		} else if (!userName.trim().matches(userNameReg)) { // ??????????????????(???)?????????(regular-expression)
			errorMsgs.add("???????????????: ???????????????????????????????????????_ , ??????????????????2???10??????");
		}

		String phoneReg = "^09\\d{8}$";
		if (phone == null || phone.trim().length() == 0) {
			phone = "";
		} else if (!phone.trim().matches(phoneReg)) { // ??????????????????(???)?????????(regular-expression)
			errorMsgs.add("??????????????????????????????");
		}

		String mailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
		if (mail == null || mail.trim().length() == 0) {
			errorMsgs.add("???????????????: ????????????");
		} else if (!mail.trim().matches(mailReg)) { // ??????????????????(???)?????????(regular-expression)
			errorMsgs.add("?????????????????????????????????");
		}

		// ??????????????????
		Timestamp registrationTime = new Timestamp(System.currentTimeMillis());// ????????????????????????
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

		if ((memSvc.findMemberByMail(mail))) { // ?????????????????????
			errorMsgs.add("????????????????????????");

		}

		if (!errorMsgs.isEmpty()) {
			model.addAttribute("memVO", memVO); // ???????????????????????????empVO??????,?????????req
			return "/front-end/member/login"; // ????????????
		}

		// ??????????????????
		// ??????????????????Random??????
		Random rand = new Random();

		// ????????????8???????????????
		String passRandom = "";
		for (int i = 0; i < 8; i++) {
			int randomNumber = rand.nextInt(36);
			if (randomNumber < 10) {
				// ????????????0-9?????????
				passRandom += randomNumber;
			} else {
				// ????????????A-Z???????????????
				passRandom += (char) (randomNumber + 55);
			}
		}

		// ???????????????????????????
		String subject = "SYM?????????";

		String messageText = "Hello! " + mail + " ???????????????: " + passRandom + "\n" + "???????????????????????????????????????" + "\n" + "??????????????????????????????";

		mailSvc.sendMail(mail, subject, messageText);

		// ??????Redis???
		Jedis jedis = new Jedis("localhost", 6379);
		jedis.set("passRandom", passRandom);
		jedis.expire("passRandom", 60 * 5);

		jedis.close();

		/*************************** 2.?????????????????? ***************************************/
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

		/*********************** 1.?????????????????? - ??????????????????????????? *************************/

		// ???????????????????????????
		Jedis jedis = new Jedis("localhost", 6379);

		String passRandom = jedis.get("passRandom");

		if (passRandom == null) {
			msg.put("errorMsg", "????????????????????????????????????");
			String json = gson.toJson(msg);
			writer.write(json);
			return;
		} else if (!(vCode.equals(passRandom))) {
			msg.put("errorMsg", "??????????????????????????????");
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

		/*************************** 2.?????????????????? ***************************************/
		memVO = memSvc.addMember(userAccount, userPassword, userName, phone, mail, registrationTime, mailCertification,
				sellerAuditApprovalState, currentShoppingCoin);

		memVO = memSvc.loginOneMem(mail);

		mailCertification = true;// ????????????
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

		/*************************** 1.?????????????????? - ??????????????????????????? **********************/

		Boolean mailCertification = true;

		String idNumberReg = "^[A-Z]\\d{9}$";
		if (idNumber == null || idNumber.trim().length() == 0) {
			idNumber = "";
		} else if (!idNumber.trim().matches(idNumberReg)) { // ??????????????????(???)?????????(regular-expression)
			errorMsgs.add("?????????????????????????????????");
		}

//		java.sql.Date birthday1 = null;
//
//		try {
//			birthday1 = java.sql.Date.valueOf(birthday);
//		} catch (Exception e) {
//			birthday1 = null;
//			errorMsgs.add("??????????????????");
//		}

		Boolean sellerAuditApprovalState = false;

		Integer currentShoppingCoin = 0;

		// ????????????
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
			model.addAttribute("memVO", memVO); // ???????????????????????????empVO??????,?????????req
			return "/front-end/member/register2"; // ????????????
		}

		/*************************** 2.?????????????????? *****************************************/

		memSvc.updateMember(memberID, gender, birthday, userPhoto1, mailCertification, idNumber, address,
				sellerAuditApprovalState, currentShoppingCoin);

		memVO = memSvc.loginOneMem(mail);

		/*************************** 3.????????????,????????????(Send the Success view) *************/
		session.setAttribute("mail", mail);
		session.setAttribute("memVO", memVO); // ?????????update?????????,????????????memVO??????,??????req

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

		/*************************** 1.?????????????????? ****************************************/
		String mailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
		if (mail == null || mail.trim().length() == 0) {
			errorMsgs1.add("???????????????: ????????????");
		} else if (!mail.trim().matches(mailReg)) { // ??????????????????(???)?????????(regular-expression)
			errorMsgs1.add("?????????????????????????????????");
		}

		String userPasswordReg = "^[(a-zA-Z0-9)]{2,10}$";
		if (userPassword == null || userPassword.trim().length() == 0) {
			errorMsgs1.add("???????????????: ????????????");
		} else if (!userPassword.trim().matches(userPasswordReg)) { // ??????????????????(???)?????????(regular-expression)
			errorMsgs1.add("???????????????: ?????????????????????????????? , ??????????????????2???10??????");
		}

		MemberVO memVO = new MemberVO();
		memVO.setMail(mail);
		memVO.setUserPassword(userPassword);

		// Send the use back to the form, if there were errors
		if (!errorMsgs1.isEmpty()) {
			model.addAttribute("memVO2", memVO); // ???????????????????????????empVO??????,?????????req
			return "/front-end/member/login"; // ????????????
		}

		if (!(memSvc.getOneForLogin(mail, userPassword))) { // ????????? , ??????????????????

			errorMsgs1.add("??????????????????????????????");
			if (!errorMsgs1.isEmpty()) {
				model.addAttribute("memVO", memVO); // ???????????????????????????empVO??????,?????????req
				return "/front-end/member/login"; // ????????????
			}

		} else { // ????????? , ???????????????, ?????????????????????
			session.setAttribute("mail", mail); // *??????1: ??????session??????????????????????????????

			try {

				memVO = memSvc.loginOneMem(mail);
				session.setAttribute("memVO", memVO); // ??????????????????empVO??????,??????req

				List<ViewMemberBlockListVO> memblVO = blockSvc.getAll(memVO.getMemberID());
				List<CreditCardVO> cardVO = cardSvc.getAll(memVO.getMemberID());
				session.setAttribute("cardVO", cardVO);// ??????????????????storeVO??????,??????req
				session.setAttribute("memblVO", memblVO);// ??????????????????storeVO??????,??????req
				StoreJDBCDAO storeJDBCDAO = new StoreJDBCDAO();
				StoreVO storeVO2 = storeJDBCDAO.findByPrimaryKey(memVO.getMemberID());
				List<CouponUsageHistoryVO> couponUsageHistoryVO = couponUsageHistorySvc.getAll2();
				session.setAttribute("couponUsageHistoryVO", couponUsageHistoryVO);
				List<ShoppingGoldRecordVO> shoppingGoldRecordVO = shoppingGoldRecordSvc.getAll();
				session.setAttribute("shoppingGoldRecordVO", shoppingGoldRecordVO);
				
				// ????????????????????????
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
		return "/index"; // *??????3:
		// (-->??????????????????:????????????login_success)
	}

	@PostMapping("/getOneForLogOut")
	public String getOneForLogOut(HttpSession session) {

		// ??????????????????????????????????????????
		session.removeAttribute("mail");
		session.removeAttribute("storeName");
		session.removeAttribute("memVO");
		// ????????????????????????
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
		/*************************** 1.?????????????????? ****************************************/
		String mailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
		if (mail == null || mail.trim().length() == 0) {

			msg.put("errorMsg", "???????????????: ????????????");
			String json = gson.toJson(msg);

			writer.write(json);
			return;
		} else if (!mail.trim().matches(mailReg)) { // ??????????????????(???)?????????(regular-expression)

			msg.put("errorMsg", "?????????????????????????????????");
			String json = gson.toJson(msg);
			writer.write(json);
			return;
		} else if (!(memSvc.findMemberByMail(mail))) { // ????????? , ??????????????????

			msg.put("errorMsg", "???????????????????????????????????????");
			String json = gson.toJson(msg);
			writer.write(json);
			return;

		}

		// ??????????????????
		// ??????????????????Random??????
		Random rand = new Random();

		// ????????????8???????????????
		String passRandom = "";
		for (int i = 0; i < 8; i++) {
			int randomNumber = rand.nextInt(36);
			if (randomNumber < 10) {
				// ????????????0-9?????????
				passRandom += randomNumber;
			} else {
				// ????????????A-Z???????????????
				passRandom += (char) (randomNumber + 55);
			}
		}

		// ???????????????????????????
		memVO = memSvc.loginOneMem(mail);

		// ????????????????????????????????????????????????
		Integer memberID = memVO.getMemberID();
		memSvc.updateMemberPassword(memberID, passRandom);

		// ???????????????????????????
		String subject = "SYM??????????????????!";

		String username = memVO.getUserName();

		String messageText = "Hello! " + username + " ??????????????????: " + passRandom + "\n" + " (????????????)" + "\n"
				+ "?????????????????????????????????????????????";

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
		/*************************** 2.?????????????????? *****************************************/

		dao.insert(storeVO);

		/*************************** 3.????????????,????????????(Send the Success view) *************/
		session.setAttribute("storeName", storeName);
		session.setAttribute("storeVO", storeVO); // ?????????update?????????,????????????memVO??????,??????req
		return "front-end/store/myStore";

	}

}
