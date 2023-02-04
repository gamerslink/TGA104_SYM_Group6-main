<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.group6.tibame104.member.model.*"%>
<%@ page import="com.group6.tibame104.creditCard.model.*"%>
<%@ page import="com.group6.tibame104.memberBlockList.model.*"%>
<%@ page import="com.group6.tibame104.store.model.*"%>
<%@ page import="com.group6.tibame104.shoppingGoldRecord.model.*"%>
<%@ page import="com.group6.tibame104.couponUsageHistory.model.*"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>SYM</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="eCommerce HTML Template Free Download" name="keywords" />
<meta content="eCommerce HTML Template Free Download" name="description" />

<!-- Favicon -->
<link
	href="${pageContext.request.contextPath}/front-end/member/img/logoSYM.jpg"
	rel="icon" />

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap"
	rel="stylesheet" />

<!-- CSS Libraries -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/lib/slick/slick.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/lib/slick/slick-theme.css"
	rel="stylesheet" />

<!-- Template Stylesheet -->
<link
	href="${pageContext.request.contextPath}/front-end/member/css/style.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/css/woody.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/css/coupon.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/css/table.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/css/signupDay.css"
	rel="stylesheet" />
<script src="https://kit.fontawesome.com/bc79e44e11.js"
	crossorigin="anonymous"></script>

</head>

<body>

	<!-- Top bar Start -->
	<!-- <div class="top-bar">
      <div class="container-fluid">
        <div class="row">
          <div class="col-sm-6">
            <i class="fa fa-envelope"></i>
            support@email.com
          </div>
          <div class="col-sm-6">
            <i class="fa fa-phone-alt"></i>
            +012-345-6789
          </div>
        </div>
      </div>
    </div> -->
	<!-- Top bar End -->

	<!-- Nav Bar Start -->
	<div class="nav">
		<div class="container-fluid">
			<nav class="navbar navbar-expand-md bg-dark navbar-dark">
				<!-- <a href="#" class="navbar-brand">MENU</a> -->
				<button type="button" class="navbar-toggler" data-toggle="collapse"
					data-target="#navbarCollapse">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse justify-content-between"
					id="navbarCollapse">
					<div class="navbar-nav mr-auto">
						<a href="${pageContext.request.contextPath}/"
							class="nav-item nav-link">首頁</a> <a
							href="${pageContext.request.contextPath}/front-end/store/myStore.jsp"
							class="nav-item nav-link">我的賣場</a>

						<div class="nav-item dropdown">
							<a href="#" class="nav-link " data-toggle="dropdown">客服中心</a>


						</div>
					</div>
				</div>
				<div class="navbar-nav ml-auto">
					<div class="nav-item dropdown">

						<a href="my-account.jsp" class="nav-link dropdown-toggle"
							data-toggle="dropdown"> <img class="rounded-circle "
							src="${pageContext.request.contextPath}/member/DBGifReader?memberID=${memVO.memberID}"
							alt="" style="width: 40px; height: 40px; object-fit: cover" onerror="this.src='${pageContext.request.contextPath}/front-end/member/img/account.jpg'"/> ${memVO.userAccount}
						</a>
						<div class="dropdown-menu">
							<a
								href="${pageContext.request.contextPath}/front-end/member/my-account.jsp"
								class="dropdown-item">我的帳號</a>
							<FORM METHOD="post"
								ACTION="${pageContext.request.contextPath}/front-end/member/getOneForLogOut">
								<input class="dropdown-item" type="submit" name="action"
									value="登出"></a>
							</FORM>

						</div>
					</div>
				</div>
			</nav>
		</div>
	</div>
	<!-- Nav Bar End -->

	<!-- Bottom Bar Start -->
	<div class="bottom-bar">
		<div class="container-fluid">
			<div class="row align-items-center">
				<div class="col-md-3">
					<div class="logo">
						<a href="${pageContext.request.contextPath}/"> <img
							src="${pageContext.request.contextPath}/front-end/member/img/logo.png"
							alt="Logo" />
						</a>
					</div>
				</div>
				<div class="col-md-6">
					<div class="search">
						<input type="text" placeholder="商品搜尋" />
						<button>
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
				<div class="col-md-3">
					<div class="user">
						<!-- <a href="wishlist.html" class="btn wishlist">
                <i class="fa fa-heart"></i>
                <span>(0)</span>
              </a> -->
						<a href="cart.html" class="btn cart"> <i
							class="fa fa-shopping-cart"></i> <span>(0)</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Bottom Bar End -->

	<!-- Breadcrumb Start -->
	<div class="breadcrumb-wrap">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Home</a></li>
				<li class="breadcrumb-item"><a href="#">Products</a></li>
				<li class="breadcrumb-item active">My Account</li>
			</ul>
		</div>
	</div>
	<!-- Breadcrumb End -->

	<!-- My Account Start -->
	<div class="my-account">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-3">
					<div class="nav flex-column nav-pills" role="tablist"
						aria-orientation="vertical">
						<a class="nav-link active" id="account-nav" data-toggle="pill"
							href="#account-tab" role="tab" aria-selected="true"><i
							class="fa fa-user"></i>我的帳戶</a> <a class="nav-link" id="password-nav"
							data-toggle="pill" href="#password-tab" role="tab"><i
							class="fa-solid fa-lock-open"></i>修改密碼</a> <a class="nav-link"
							id="orders-nav" data-toggle="pill" href="#orders-tab" role="tab"
							aria-selected="true"><i class="fa fa-shopping-bag"></i>訂單管理</a> <a
							class="nav-link" id="cards-nav" data-toggle="pill"
							href="#cards-tab" role="tab"><i
							class="fa-solid fa-credit-card"></i>信用卡管理</a> <a class="nav-link"
							id="payment-nav" data-toggle="pill" href="#payment-tab"
							role="tab"><i class="fa-solid fa-coins"></i>我的購物金</a> <a
							class="nav-link" id="address-nav" data-toggle="pill"
							href="#coupon-tab" role="tab"><i class="fa-solid fa-ticket"></i></i>我的優惠券</a>


						<a class="nav-link" id="blocklist-nav" data-toggle="pill"
							href="#blocklist-tab" role="tab"><i
							class="fa-solid fa-user-xmark"></i>封鎖名單</a>
						<!-- <a class="nav-link" href="index.html"
                ><i class="fa fa-sign-out-alt"></i>登出</a
              > -->
					</div>
				</div>
				<div class="col-md-9">
					<div class="tab-content">



						<div class="tab-pane fade" id="orders-tab" role="tabpanel"
							aria-labelledby="orders-nav">
							<div class="table-responsive">
								<table class="table table-bordered">
									<thead class="thead-dark">
										<ul>
											<li>
												<FORM METHOD="post"
													ACTION="${pageContext.request.contextPath}/front-end/order/select_Order">
													<b>輸入訂單編號: </b> <input type="text" name="orderID"
														style="width: 100px; height: 25px"> 
													<input type="submit" value="送出">
												</FORM>
												<br><br><br>
											</li>
											<li>
												<FORM METHOD="post"
													ACTION="${pageContext.request.contextPath}/front-end/order/select_Order">

													<b>輸入訂單日期:</b> <input name="fromdate" id="f_date1"
														type="text" style="width: 100px; height: 25px"> <b>至</b>
													<input name="todate" id="f_date2" type="text"
														style="width: 100px; height: 25px"> <br> <br>
													<b>選擇訂單狀態:</b> <select name="status"
														style="width: 80px; height: 25px">

														<option value="-1">全部</option>
														<option value="0">待付款</option>
														<option value="1">待出貨</option>
														<option value="2">已出貨</option>													
														<option value="3">訂單完成</option>

													</select> <br> <br> 
													<input type="hidden" name="memberID" value="${memVO.memberID}"> 
													
													<input type="submit" value="送出">
												</FORM>


											</li>
										</ul>
									</thead>
								</table>
							</div>
						</div>
						<div class="tab-pane fade" id="cards-tab" role="tabpanel"
							aria-labelledby="cards-nav">
							<div class="table-responsive">

								<table class="table table-bordered">
									<div class="col-md py-1">




										<FORM METHOD="post"
											ACTION="${pageContext.request.contextPath}/front-end/cerditCard/insert"
											style="margin-bottom: 0px;">

											<div class="row">
												<div class="col-md py-1">
													<label>信用卡卡號</label><input class="form-control" type="text"
														name="creditCardNumber" placeholder="信用卡卡號" />
												</div>

											</div>
											<div class="row">
												<div class="col-md py-1">
													<label for="birthday">到期日</label> <input
														class="form-control" name="exDate" type="date" />
												</div>
												<div class="col-md py-1">
													<label>安全碼</label><input class="form-control" type="text"
														name="securityCode" placeholder="安全碼" />
												</div>
											</div>

											<input type="hidden" name="memberID"
												value="${memVO.memberID}"> <input
												class="btn" type="submit" value="新增信用卡"> <br /> <br />
										</FORM>
										<hr>
										<thead class="thead-dark">
											<tr>

												<th>信用卡卡號</th>
												<th>安全碼</th>
												<th>到期日</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>

											
											<c:forEach var="cardVO" items="${cardVO}">
												<tr>

													<td>${cardVO.creditCardNumber}</td>
													<td>${cardVO.securityCode}</td>
													<td>${cardVO.exDate}</td>

													<td>
														<FORM METHOD="post"
															ACTION="${pageContext.request.contextPath}/front-end/cerditCard/delete"
															style="margin-bottom: 0px;">
															<input type="hidden" name="creditCardID"
																value="${cardVO.creditCardID}"> <input
																type="hidden" name="memberID"
																value="${memVO.memberID}"> <input
																class="btn" type="submit" value="刪除">
														</FORM>
													</td>
												</tr>
											</c:forEach>
										</tbody>
								</table>


							</div>
						</div>

						<div class="tab-pane fade" id="payment-tab" role="tabpanel"
							aria-labelledby="payment-nav">
							<div
								style="display: flex; flex-direction: column; align-items: center;">
								<div style="display: flex;">
									<div>我的購物金:</div>
									<div id="shoppingGold">50</div>
									<div>元</div>
								</div>
							</div>

							<div class="daysContainer">
								<div>購物金簽到</div>
								<div class="dayRow">
									<div class="dayBlock">Day1</div>
									<div class="dayBlock">Day2</div>
									<div class="dayBlock">Day3</div>
									<div class="dayBlock">Day4</div>
									<div class="dayBlock">Day5</div>
									<div class="dayBlock">Day6</div>
									<div class="dayBlock">Day7</div>
								</div>
								<div>完成實名認證即可領取購物金</div>
							</div>
							<div class="table-outbox">
								<table>
									<thead>
										<tr>
											<th>購物金歷程ID</th>
											<th>會員ID</th>
											<th>日期</th>
											<th>購物金異動金額</th>
											<th>使用/獲得</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="ShoppingGoldRecordVO" items="${shoppingGoldRecordVO}">
											<tr>

												<td>${ShoppingGoldRecordVO.shoppingGoldRecordID}</td>
												<td>${ShoppingGoldRecordVO.memberID}</td>
												<td>${ShoppingGoldRecordVO.useDate}</td>
												<td>${ShoppingGoldRecordVO.obtainShoppingCoin}</td>
												<td>${ShoppingGoldRecordVO.plusOrMinus}</td>

											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<div class="tab-pane fade" id="blocklist-tab" role="tabpanel"
							aria-labelledby="blocklist-nav">
							<div class="table-responsive">
								<table class="table table-bordered">
									<thead class="thead-dark">
										<tr>
											<!-- <th>No</th> -->
											<th>賣場名稱</th>

											<th>操作</th>
										</tr>
									</thead>
									<tbody>
									
										<c:forEach var="memblVO" items="${memblVO}">
											<tr>
												
												<td>${memblVO.storeName}</td>

												<td>
													<FORM METHOD="post"
														ACTION="${pageContext.request.contextPath}/front-end/memberBlockList/delete"
														style="margin-bottom: 0px;">
														<input type="hidden" name="blockListID"
															value="${memblVO.blockListID}"> <input type="hidden" name="memberID"
													value="${memVO.memberID}"> <input
															class="btn" type="submit" value="刪除">
													</FORM>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<div class="tab-pane fade" id="coupon-tab" role="tabpanel"
							aria-labelledby="coupon-nav">
							<div class="quan" v-for="(item,i) in couponList" : key="i">
								<div class="quanInfo">
									<text class="couponMpoey">$200元<text
										class="couponMpoeyInfo"> 滿1500元折抵200元</text></text>
									<text class="couponName">全館滿額折抵200</text>
									<text class="couponTime">2022-11-14~2022-11-25</text>
								</div>
								<div class="receiveBtn">
									<div>
										<button class="receive">使用</button>
									</div>
								</div>
							</div>
							<div class="quan" v-for="(item,i) in couponList" : key="i">
								<div class="quanInfo">
									<text class="couponMpoey">85折<text
										class="couponMpoeyInfo"> 不限購買金額</text></text>
									<text class="couponName">全館優惠85折</text>
									<text class="couponTime">2022-11-11~2022-11-22</text>
								</div>
								<div class="receiveBtn">
									<div>
										<button class="receive">使用</button>
									</div>
								</div>
							</div>
							<div class="quan" v-for="(item,i) in couponList" : key="i">
								<div class="quanInfo">
									<text class="couponMpoey">$100元<text
										class="couponMpoeyInfo"> 滿1000元折抵100元</text></text>
									<text class="couponName">全館滿額折抵100</text>
									<text class="couponTime">2022-11-13~2022-11-24</text>
								</div>
								<div class="receiveBtn">
									<div>
										<button class="receive">使用</button>
									</div>
								</div>
							</div>
							<div class="table-outbox">
								<table>
									<thead>
										<tr>
											<th>會員ID</th>
											<th>優惠券ID</th>
											<th>使用紀錄</th>
											<th>使用日期</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="couponUsageHistoryVO" items="${couponUsageHistoryVO}">
											<tr>

												<td>${couponUsageHistoryVO.memberID}</td>
												<td>${couponUsageHistoryVO.couponID}</td>
												<td>${couponUsageHistoryVO.usageRecord}</td>
												<td>${couponUsageHistoryVO.useDate}</td>

											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<div class="tab-pane fade active show" id="account-tab"
							role="tabpanel" aria-labelledby="account-nav">
							<FORM METHOD="post"
								ACTION="${pageContext.request.contextPath}/front-end/member/updateOne"
								enctype="multipart/form-data" name="form1">
								<h4>帳戶明細</h4>
								<%-- 錯誤表列 --%>
								<c:if test="${not empty errorMsgsForupdate}">
									<font style="color: red">請修正以下錯誤:</font>
									<ul>
										<c:forEach var="message" items="${errorMsgsForupdate}">
											<li style="color: red">${message}</li>
										</c:forEach>
									</ul>
								</c:if>
								<div class="row">
									<div class="col">
										<div class="row">
											<div class="col-md py-1">
												<label>姓名</label> <input class="form-control" type="text"
													name="userName" placeholder="姓名"
													value="${(memVO.userName == null) ? '' : memVO.userName}" />
											</div>
											<div class="col-md py-1">
												<label>帳號</label> <input class="form-control" type="text"
													name="userAccount" placeholder="帳號"
													value="${(memVO.userAccount == null) ? '' : memVO.userAccount}" />
											</div>
										</div>
										<div class="row">
											<div class="col-md py-1">
												<label>手機號碼</label> <input class="form-control" type="text"
													name="phone" placeholder="手機號碼"
													value="${(memVO.phone == null) ? '' : memVO.phone}" />
											</div>
											<div class="col-md py-1">
												<label>電子信箱</label> <input class="form-control" type="text"
													name="mail" placeholder="電子信箱"
													value="${(memVO.mail == null) ? '' : memVO.mail}" />
											</div>
										</div>
										<div class="row">
											<div class="col-md py-1">
												<label>身分證號</label> <input class="form-control" type="text"
													name="idNumber" placeholder="身分證號"
													value="${(memVO.idNumber == null) ? '' : memVO.idNumber}" />
											</div>
											<div class="col-md py-1">
												<label>地址</label> <input class="form-control" type="text"
													name="address" placeholder="地址"
													value="${(memVO.address == null) ? '' : memVO.address}" />
											</div>
										</div>




										<br> <br> <br> <br> <br>
										<div class="row">
											<div class="col-md py-1">
												<input type="hidden" name="memberID"
													value="${memVO.memberID}">
												<input class="btn" type="submit" value="更新資料"> <br />
												<br />
											</div>
										</div>
									</div>



									<div class="col">
										<div class="row justify-content-center">
											<div
												class="col-6 p-1 align-self-center d-flex justify-content-center">
												<img class="rounded-circle user_img"
													src="${pageContext.request.contextPath}/member/DBGifReader?memberID=${memVO.memberID}"
													alt="" style="width: 160px; height: 160px; object-fit: cover" onerror="this.src='${pageContext.request.contextPath}/front-end/member/img/account.jpg'" />
											</div>
											<div class="w-100"></div>
											<br>

											<div
												class="col-6 py-1 align-self-center d-flex justify-content-center">
												<input id="userPhoto" type="file" name="userPhoto"
													class="btn" value="選擇圖片"> <br /> <br />
											</div>
										</div>

									</div>
								</div>
							</FORM>

						</div>
						<div class="tab-pane fade" id="password-tab" role="tabpanel"
							aria-labelledby="password-nav">


							<h4>變更密碼</h4>
							<FORM id="passwordForm" METHOD="post"
								ACTION="${pageContext.request.contextPath}/front-end/member/updateOnePassword"
								style="margin-bottom: 0px;">

								<div class="row">
									<%-- 錯誤表列 --%>
									<c:if test="${not empty errorMsgs}">
										<font style="color: red">請修正以下錯誤:</font>
										<ul>
											<c:forEach var="message" items="${errorMsgs}">
												<li style="color: red">${message}</li>
											</c:forEach>
										</ul>
									</c:if>
									<div class="col-md-12">
										<input id="oldpassword" class="form-control" type="password"
											name="oldPassword" placeholder="請輸入舊密碼" />
									</div>
									<div class="col-md-6">
										<input id="newpassword" class="form-control" type="password"
											name="userPassword" placeholder="請輸入新密碼" />
									</div>
									<div class="col-md-6">
										<input id="repassword" class="form-control" type="password"
											placeholder="請再輸入一次新密碼" />
									</div>
									<div class="col-md-12">
										<input type="hidden" name="memberID"
											value="${memVO.memberID}"> <input class="btn"
											type="submit" value="送出">
									</div>
								</div>
							</FORM>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- My Account End -->

	<!-- Footer Start -->
	<div class="footer">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-3 col-md-6">
					<div class="footer-widget">
						<h5>網站介紹</h5>
						<ul>
							<li><a href="#">關於SYM</a></li>
							<li><a href="#">SYM團隊成員介紹</a></li>
							<!-- <li><a href="#">Terms & Condition</a></li> -->
						</ul>
					</div>
				</div>

				<div class="col-lg-3 col-md-6">
					<div class="footer-widget">
						<h5>聯絡我們</h5>
						<div class="contact-info">
							<p>
								<i class="fa fa-map-marker"></i>台北商業大學
							</p>
							<!-- <p><i class="fa fa-envelope"></i>email@example.com</p>
                <p><i class="fa fa-phone"></i>+123-456-7890</p> -->
						</div>
					</div>
				</div>

				<!-- <div class="col-lg-3 col-md-6">
            <div class="footer-widget">
              <h2>Follow Us</h2>
              <div class="contact-info">
                <div class="social">
                  <a href=""><i class="fab fa-twitter"></i></a>
                  <a href=""><i class="fab fa-facebook-f"></i></a>
                  <a href=""><i class="fab fa-linkedin-in"></i></a>
                  <a href=""><i class="fab fa-instagram"></i></a>
                  <a href=""><i class="fab fa-youtube"></i></a>
                </div>
              </div>
            </div>
          </div> -->

				<div class="col-lg-3 col-md-6">
					<div class="footer-widget">
						<h5>常見問題</h5>
						<ul>
							<li><a href="#">前往客服中心</a></li>
							<!-- <li><a href="#">Shipping Policy</a></li>
                <li><a href="#">Return Policy</a></li> -->
						</ul>
					</div>
				</div>
			</div>

			<!-- <div class="row payment align-items-center">
          <div class="col-md-6">
            <div class="payment-method">
              <h2>We Accept:</h2>
              <img src="img/payment-method.png" alt="Payment Method" />
            </div>
          </div>
          <div class="col-md-6">
            <div class="payment-security">
              <h2>Secured By:</h2>
              <img src="img/godaddy.svg" alt="Payment Security" />
              <img src="img/norton.svg" alt="Payment Security" />
              <img src="img/ssl.svg" alt="Payment Security" />
            </div>
          </div>
        </div> -->
		</div>
	</div>
	<!-- Footer End -->

	<!-- Footer Bottom Start -->
	<div class="footer-bottom">
		<div class="container">
			<div class="row">
				<div class="col-md-6 copyright">
					<p>
						Copyright &copy; <a href="#">SYM</a>. All Rights Reserved
					</p>
				</div>

				<div class="col-md-6 template-by">
					<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
					<!-- <p>Designed By <a href="https://htmlcodex.com">HTML Codex</a></p> -->
				</div>
			</div>
		</div>
	</div>
	<!-- Footer End -->

	<!-- Back to Top -->
	<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/front-end/member/lib/easing/easing.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/front-end/member/lib/slick/slick.min.js"></script>

	<!-- Template Javascript -->
	<script
		src="${pageContext.request.contextPath}/front-end/member/js/main.js"></script>
	<script
		src="${pageContext.request.contextPath}/front-end/member/js/woody.js"></script>

	<script>
		let cpasswordInput = document.getElementById('newpassword');
		let cretypeInput = document.getElementById('repassword');
		let coldpasswordInput = document.getElementById('oldpassword');//oldpassword
		// 添加事件侦听器，在用戶點擊提交按鈕時檢查密碼是否一致
		let passwordForm = document.getElementById('passwordForm');
		passwordForm.addEventListener('submit', function(event) {
			let password = cpasswordInput.value;
			let retype = cretypeInput.value;
			let oldpassword = coldpasswordInput.value;

			if (oldpassword === "") {
				alert('請輸入舊密碼');
			}

			// 檢查密碼是否一致
			if (password !== retype) {
				// 顯示錯誤消息
				alert('兩次輸入的密碼不一致，請重新輸入');

				// 阻止表單提交
				event.preventDefault();
			}
		});
	</script>

	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/front-end/order/datetimepicker/jquery.datetimepicker.css" />
	<script
		src="${pageContext.request.contextPath}/front-end/order/datetimepicker/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath}/front-end/order/datetimepicker/jquery.datetimepicker.full.js"></script>
	<script>
		$.datetimepicker.setLocale('zh');
		$('#f_date1').datetimepicker({
			theme : '', //theme: 'dark',
			timepicker : false, //timepicker:true,
			step : 1, //step: 60 (這是timepicker的預設間隔60分鐘)
			format : 'Y-m-d', //format:'Y-m-d H:i:s',
			value : '', // value:   new Date(),
		//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
		//startDate:	            '2017/07/10',  // 起始日
		//minDate:               '-1970-01-01', // 去除今日(不含)之前
		//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
		});
		$('#f_date2').datetimepicker({
			theme : '', //theme: 'dark',
			timepicker : false, //timepicker:true,
			step : 1, //step: 60 (這是timepicker的預設間隔60分鐘)
			format : 'Y-m-d', //format:'Y-m-d H:i:s',
			value : '', // value:   new Date(),
		//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
		//startDate:	            '2017/07/10',  // 起始日
		//minDate:               '-1970-01-01', // 去除今日(不含)之前
		//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
		});
	</script>

</body>

</html>