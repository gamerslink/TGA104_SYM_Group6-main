<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.Timestamp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.group6.tibame104.group.model.*"%>
<%@ page import="com.group6.tibame104.groupproduct.model.*"%>
<%@ page import="com.group6.tibame104.grouporder.model.*"%>
<%@ page import="com.group6.tibame104.groupdiscount.model.*"%>
<%@ page import="com.group6.tibame104.member.model.*"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>SYM</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="eCommerce HTML Template Free Download" name="keywords" />
<meta content="eCommerce HTML Template Free Download" name="description" />

<!-- Favicon -->
<link
	href="${pageContext.request.contextPath}/front-end/group/img/logoSYM.jpg"
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
	href="${pageContext.request.contextPath}/front-end/group/lib/slick/slick.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/group/lib/slick/slick-theme.css"
	rel="stylesheet" />

<!-- Template Stylesheet -->
<link
	href="${pageContext.request.contextPath}/front-end/group/css/style.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/group/css/woody.css"
	rel="stylesheet" />
<script src="https://kit.fontawesome.com/bc79e44e11.js"
	crossorigin="anonymous"></script>
</head>

<body>

	<div class="nav">
		<div class="container-fluid">
			<nav class="navbar navbar-expand-md bg-dark navbar-dark">
				<a href="#" class="navbar-brand">MENU</a>
				<button type="button" class="navbar-toggler" data-toggle="collapse"
					data-target="#navbarCollapse">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse justify-content-between"
					id="navbarCollapse">
					<div class="navbar-nav mr-auto">
						<a href="index.html" class="nav-item nav-link">首頁</a> <a
							href="product-list.html" class="nav-item nav-link">我的賣場</a>

						<div class="nav-item dropdown">
							<a href="#" class="nav-link" data-toggle="dropdown">客服中心</a>
						</div>
					</div>
				</div>
				<div class="navbar-nav ml-auto">
					<div class="nav-item dropdown">
						<a href="my-account.html" class="nav-link dropdown-toggle"
							data-toggle="dropdown"> <img class="rounded-circle "
							src="${pageContext.request.contextPath}/member/DBGifReader?memberID=${memVO.memberID}"
							alt="" style="width: 40px; height: 40px" /> ${memVO.userName}
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
						<a href="index.html"> <img src="img/logoSYM.jpg" alt="Logo" />
						</a>
					</div>
				</div>
				<div class="col-md-6">
					<div class="search">
						<input type="text" placeholder="商品搜尋
                " />
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
	<!-- <div class="breadcrumb-wrap">
      <div class="container-fluid">
        <ul class="breadcrumb">
          <li class="breadcrumb-item"><a href="#">Home</a></li>
          <li class="breadcrumb-item"><a href="#">Products</a></li>
          <li class="breadcrumb-item active">Login & Register</li>
        </ul>
      </div>
    </div> -->
	<!-- Breadcrumb End -->

	<!-- Login Start -->
	<FORM METHOD="post"
		ACTION="${pageContext.request.contextPath}/back-end/grouporder/insert"
		name="form1">
		<div class="login">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg">
						<div class="register-form">
							<h4>請填寫訂單資訊</h4>
							<br />
							<div class="row">
								<div class="col-6">
									<div class="col">
										<label>會員名稱</label> <input class="form-control" type="text"
											placeholder="會員名稱" value="${memVO.userName}" readonly />
									</div>
									<div class="col">
										<label>團購編號</label> <input class="form-control" type="text"
											name="groupBuyID" value="${groupVO.groupBuyID}"
											placeholder="團購編號" readonly />
									</div>
									<div class="col">
										<label>聯絡電話</label>
										<div class="custom-control custom-checkbox">
											<input type="checkbox" class="custom-control-input"
												id="newaccount"> <label class="custom-control-label"
												for="newaccount">同會員資料</label>
										</div>
										<input class="form-control" type="text" id="contactNumber"
											name="contactNumber" value="" placeholder="聯絡電話" />
									</div>
								</div>

								<div class="col-6">
									<div class="col">
										<label>購買數量</label> <input id="qua" class="form-control"
											name="groupBuyQuantity" value="1" type="text"
											placeholder="購買數量" />
									</div>
									<div class="col">
										<label>付款方式</label> <select name="paymentTerm"
											class="form-control">
											<option value="信用卡">信用卡</option>
											<option value="貨到付款">貨到付款</option>
											<option value="ATM轉帳">ATM轉帳</option>
										</select>
									</div>
									<br>
									<div class="col">
										<label>寄送地址</label> <select id="city" name="city">
											<option value="">請選擇</option>
										</select>
										<!-- 																		第二層選單(先隱藏，選完第一層後再出現) -->
										<select id="area" name="area" style="display: none;">
											<option value="">請選擇</option>
										</select> <input id="shippingLocation" name="shippingLocation" value=""
											class="form-control" type="text" placeholder="寄送地址" />
									</div>
								</div>
								<br> <br>
								<div class="col-7"></div>
								<div class="col-3">
									<label>總金額</label> <input id="total" class="form-control"
										name="groupBuyTotal"
										value="${Math.round(groupproductVO.groupBuyProductPrice* groupBuyCount)}"
										type="text" placeholder="總金額" readonly /><input type="hidden"
										name="groupBuyID" value="${groupVO.groupBuyID}"> <input
										type="hidden" name="giftVoucher" value=0> <input
										type="hidden" name="groupBuyProductID"
										value="${groupVO.groupBuyProductID}"> <input
										type="hidden" name="administratorID"
										value="${groupVO.administratorID}"> <input
										type="hidden" name="paymentState" value="1"> <input
										type="hidden" name="memberID" value="${memVO.memberID}">
									<input type="hidden" name="orderTime"> <a href="#">
										<button class="btn">送出訂單</button>
									</a>
	</form>
	</div>
	</div>
	</div>
	</div>
	</div>
	</div>
	</div>
	<!-- Login End -->

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
		src="${pageContext.request.contextPath}/front-end/group/lib/easing/easing.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/front-end/group/lib/slick/slick.min.js"></script>

	<!-- Template Javascript -->
	<script
		src="${pageContext.request.contextPath}/front-end/group/js/main.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/grouporder/js/address.js"></script>

</body>
<script>
	$("#qua").bind(
			'input propertychange',
			function() {
				// console.log("123")
				//console.log($("#qua").val())
				
				$("#total").val(
						Math.ceil(${groupproductVO.groupBuyProductPrice} * $("#qua").val() *${groupBuyCount}));

			})
	$("#newaccount").click(function(){
		
// 		console.log(this)
		$("#newaccount").toggleClass("-on");
		
		if($("#newaccount").hasClass("-on")){
// 			console.log("123")
			$("#contactNumber").val("${memVO.phone}");
			$("#shippingLocation").val("${memVO.address}");
			
		}else{
			$("#contactNumber").val("");
			$("#shippingLocation").val("");
		}
	})
</script>

</html>