<%@page import="org.hibernate.internal.build.AllowSysOut"%>
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
<link
	href="${pageContext.request.contextPath}/front-end/member/css/register.css"
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
						<a href="index.html" class="nav-item nav-link">首頁</a> <a
							href="product-list.html" class="nav-item nav-link">我的賣場</a>

						<div class="nav-item dropdown">
							<a href="#" class="nav-link" data-toggle="dropdown">客服中心</a>
						</div>
					</div>
				</div>
				<div class="navbar-nav ml-auto">
					<div class="nav-item dropdown">
						<a
							href="${pageContext.request.contextPath}/front-end/member/login.jsp"
							class="nav-link">登入/註冊</a>
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
						<a href="index.html"> <img
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



	<!-- register Start -->
	<form id="msform" name="form1">
		<!-- progressbar -->
		<ul id="progressbar">
			<li class="active">信箱驗證</li>

			<li>完成</li>
		</ul>
		<!-- fieldsets -->
		<fieldset id="register1">
			<h1 class="fs-title">請輸入信箱驗證碼</h1>
			<br />
			<h3 class="fs-subtitle">您的驗證碼已透過E-mail傳送至</h3>
			<h4 class="fs-subtitle">${memVO.mail}</h4>
			
			<input type="text" name="vCode" placeholder="輸入驗證碼" />
			<h3 class="fs-subtitle">沒有收到驗證碼嗎？</h3>
			<h3 class="fs-subtitle">重新傳送</h3>

			
			<input id="continue" class="next action-button" name="next" type="button"
				value="驗證">

		</fieldset>
		<fieldset id="register2">
			<h2 class="fs-title">驗證完成</h2>
			<h2 class="fs-title circle-check">
				<br /> <br /> <i class="fa-solid fa-circle-check"></i> <br /> <br />
				<br />
			</h2>
			<h3 class="fs-subtitle text_t1">已使用電子信箱<div id="email"></div></h3>
			<h3 class="fs-subtitle">驗證註冊成功</h3>
			<h3 class="fs-subtitle">請點選完成繼續註冊流程</h3>
			<a
				href="${pageContext.request.contextPath}/front-end/member/register2.jsp">
				<input type="button" class="action-button" value="完成" />
			</a>
		</fieldset>
	</form>
	<br />
	<br />
	<br />
	<br />

	<!-- register End -->

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
	<script src="${pageContext.request.contextPath}/front-end/member/js/main.js"></script>
	<script src="${pageContext.request.contextPath}/front-end/member/js/woody.js"></script>
	<script src="${pageContext.request.contextPath}/front-end/member/js/register.js"></script>
	
	<script>
  // 全域變數
  var animating = false;
  var current_fs;
  var next_fs;

  // 觸發頁面切換的動畫
  function triggerAnimation() {
    if (animating) {
      return false;
    }
    animating = true;
    current_fs = document.querySelector("#register1");
    next_fs = document.querySelector("#register2");
    document.querySelector("#progressbar li:nth-of-type(2)").classList.add("active");
    next_fs.style.display = "block";

    current_fs.animate(
    		{ opacity: 0 },
    		{
    		step: function(b, a) {
    		scale = 1 - (1 - b) * 0.2;
    		left = b * 50 + "%";
    		opacity = 1 - b;
    		current_fs.style.transform = "scale(" + scale + ")";
    		next_fs.style.left = left;
    		next_fs.style.opacity = opacity;
    		},
    		duration: 800,
    		complete: function() {
    		current_fs.style.display = "none";
    		animating = false;
    		},
    		easing: "cubic-bezier(0.68, -0.55, 0.265, 1.55)"
    		}
    		);



  }

  // 當按下驗證按鈕時
 

   $("#continue").click(function() {
  $.ajax({
    url: "${pageContext.request.contextPath}/front-end/member/mailVerification", // 資料請求的網址
    type: "POST", // GET | POST | PUT | DELETE | PATCH
    data: $("#msform").serialize(),
    dataType: "json", // 預期會接收到回傳資料的格式： json | xml | html
    beforeSend: function() {
      // 顯示讀取中的動畫
      $("#continue").addClass("loading");
      // 禁用按鈕
      $("#continue").attr("disabled", true);
    },
    success: function(data) {
      if ("errorMsg" in data) {
        alert(data.errorMsg); // 顯示訊息	 
      } else {
        $("#email").text(data.succsess);
       /*  alert("修改成功！");  */
        triggerAnimation(); // 觸發頁面切換的動畫
      }
    },
    complete: function() {
      // 隱藏讀取中的動畫
      $("#continue").removeClass("loading");
      // 啟用按鈕
      $("#continue").attr("disabled", false);
    }
  });
});

	</script>
</body>
</html>
