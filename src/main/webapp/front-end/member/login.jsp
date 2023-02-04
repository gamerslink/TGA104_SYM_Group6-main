<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.group6.tibame104.member.model.*"%>

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
<link href="lib/slick/slick.css" rel="stylesheet" />
<link href="lib/slick/slick-theme.css" rel="stylesheet" />

<!-- Template Stylesheet -->
<link
	href="${pageContext.request.contextPath}/front-end/member/css/style.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/css/woody.css"
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
				<a href="#" class="navbar-brand">MENU</a>
				<button type="button" class="navbar-toggler" data-toggle="collapse"
					data-target="#navbarCollapse">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse justify-content-between"
					id="navbarCollapse">
					<div class="navbar-nav mr-auto">
						<a href="index.jsp" class="nav-item nav-link">首頁</a> <a
							href="${pageContext.request.contextPath}/front-end/store/myStore.jsp" class="nav-item nav-link">我的賣場</a>

						<div class="nav-item dropdown">
							<a href="#" class="nav-link" data-toggle="dropdown">客服中心</a>
						</div>
					</div>
				</div>
				<div class="navbar-nav ml-auto">
					<div class="nav-item dropdown">
						<a href="${pageContext.request.contextPath}/front-end/member/login.jsp" class="nav-link">登入/註冊</a>
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
						<a href="${pageContext.request.contextPath}/index.jsp"> <img
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
	<div class="login">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-6">
					<FORM id="loginForm" METHOD="post"
						ACTION="${pageContext.request.contextPath}/front-end/member/insert"
						name="form1">
						<div class="register-form">
							<%-- 錯誤表列 --%>
							<c:if test="${not empty errorMsgs}">
								<font style="color: red">請修正以下錯誤:</font>
								<ul>
									<c:forEach var="message" items="${errorMsgs}">
										<li style="color: red">${message}</li>
									</c:forEach>
								</ul>
							</c:if>
							<div class="row">
								<div class="col-md-6">
									<label>姓名</label> <input class="form-control" type="text"
										name="userName" placeholder="姓名"
										value="" />
								</div>
								<div class="col-md-6">
									<label>帳號</label> <input class="form-control" type="text"
										name="userAccount" placeholder="帳號"
										value="" />
								</div>
								<div class="col-md-6">
									<label>電子信箱</label> <input class="form-control" type="text"
										name="mail" placeholder="電子信箱"
										value="" />
								</div>
								<div class="col-md-6">
									<label>行動電話</label> <input class="form-control" type="text"
										name="phone" placeholder="行動電話"
										value="" />
								</div>
								<div class="col-md-6">
									<label>密碼</label> <input id="password" class="form-control"
										type="password" name="userPassword" placeholder="密碼" />
								</div>
								<div class="col-md-6">
									<label>再輸入一次密碼</label> <input id="retype-password"
										class="form-control" type="password" placeholder="密碼" />
								</div>
								<div class="col-md-12">
									<input class="btn" type="submit" value="註冊">
								</div>
							</div>
						</div>
					</FORM>
				</div>
				<div class="col-lg-6">
					<FORM METHOD="post"
						ACTION="${pageContext.request.contextPath}/front-end/member/getOneForLogin"
						name="form2">
						<div class="login-form">
							<%-- 錯誤表列 --%>
							<c:if test="${not empty errorMsgs1}">
								<font style="color: red">請修正以下錯誤:</font>
								<ul>
									<c:forEach var="message" items="${errorMsgs1}">
										<li style="color: red">${message}</li>
									</c:forEach>
								</ul>
							</c:if>
							<div class="row">
								<div class="col-md-6">
									<label>電子信箱</label> <input class="form-control" type="text"
										name="mail" placeholder="電子信箱"
										value="" />
								</div>
								<div class="col-md-6">
									<label>密碼</label> <input class="form-control" type="password"
										name="userPassword" placeholder="密碼" />
								</div>
								<div class="col-md-12">
									<div class="custom-control custom-checkbox">
										<input type="checkbox" class="custom-control-input"
											id="newaccount" /> <label class="custom-control-label"
											for="newaccount">保持登入</label>
									</div>
								</div>
								<div class="col-md-6">
									<input class="btn" type="submit" value="登入">
								</div>
								<div class="col-md-6">
									<a href="${pageContext.request.contextPath}/front-end/member/forgetPassword.jsp" class="navbar-brand"><input class="btn"
										type="button" value="忘記密碼"></a>

								</div>
								<div class="col-md-12">
									<hr />
								</div>
								<div class="col-md-12">
									<label>或是使用</label>
								</div>
								<div class="col-md-6 login_btn">
									<a href="register_fbgo.html">
										<button class="btn login_btn">
											<i class="fa-brands fa-facebook-f"></i> Facebook
										</button>
									</a>
								</div>
								<div class="col-md-6 login_btn">
									<a href="register_fbgo.html">
										<button class="btn login_btn2">
											<i class="fa-brands fa-google"></i> Google
										</button>
									</a>
								</div>
							</div>
						</div>
					</FORM>
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
	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/slick/slick.min.js"></script>

	<!-- Template Javascript -->
	<script
		src="${pageContext.request.contextPath}/front-end/member/js/main.js"></script>
	<script
		src="${pageContext.request.contextPath}/front-end/member/js/woody.js"></script>
		
		<script
		src="${pageContext.request.contextPath}/front-end/member/js/woody.js"></script>
		
		<script>
		// 獲取輸入框的引用
		let passwordInput = document.getElementById('password');
		let retypeInput = document.getElementById('retype-password');

		// 添加事件侦听器，在用戶點擊提交按鈕時檢查密碼是否一致
		let form = document.getElementById('loginForm');
		form.addEventListener('submit', function(event) {
		  let password = passwordInput.value;
		  let retype = retypeInput.value;

		  // 檢查密碼是否一致
		  if (password !== retype) {
		    // 顯示錯誤消息
		    alert('兩次輸入的密碼不一致，請重新輸入');

		    // 阻止表單提交
		    event.preventDefault();
		  }
		});

		</script>
</body>
</html>
