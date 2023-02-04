<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.group6.tibame104.announcement.model.*"%>





<html>
<head>
<meta charset="utf-8">
<title>E Store - eCommerce HTML Template</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="eCommerce HTML Template Free Download" name="keywords">
<meta content="eCommerce HTML Template Free Download" name="description">

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap"
	rel="stylesheet">

<!-- CSS Libraries -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/front-end/group/lib/slick/slick.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/front-end/group/lib/slick/slick-theme.css"
	rel="stylesheet">

<!-- Template Stylesheet -->
<link
	href="${pageContext.request.contextPath}/front-end/group/css/style.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/front-end/group/css/stylenew.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/front-end/group/css/woody.css"
	rel="stylesheet" />
<style type="text/css">
</style>

</head>

<body>
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
						<a href="${pageContext.request.contextPath}/" class="nav-item nav-link">首頁</a> <a
							href="product-list.html" class="nav-item nav-link">我的賣場</a>

						<div class="nav-item dropdown">
							<a href="#" class="nav-link " data-toggle="dropdown">客服中心</a>


						</div>
					</div>
				</div>
				<div class="navbar-nav ml-auto">
					<div class="nav-item dropdown">
						<!-- 登入前 -->
						<a href="#" class="nav-link dropdown-toggle"
							data-toggle="dropdown"> 登入/註冊</a>
						<div class="dropdown-menu">
							<a href="#" class="dropdown-item">登入</a> <a href="#"
								class="dropdown-item">註冊</a>
						</div>
						<!-- 登入後 -->
						<!-- <a
                href="#"
                class="nav-link dropdown-toggle"
                data-toggle="dropdown"
                >
                <img
                    class="rounded-circle "
                    src="img/account.jpg"
                    alt=""
                    style="width: 40px; height: 40px"
                  />
                帳號名稱</a
              >
              <div class="dropdown-menu">
                <a href="#" class="dropdown-item">我的帳號</a>
                <a href="#" class="dropdown-item">註冊</a>
              </div> -->
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
						<a href="index.html"> <img
							src="${pageContext.request.contextPath}/front-end/group/img/logoSYM.jpg"
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
				<li class="breadcrumb-item">
				<a href="${pageContext.request.contextPath}/">首頁</a></li>
				<li class="breadcrumb-item active">公告</li>

			</ul>
		</div>
	</div>
	<!-- Breadcrumb End -->
	<div class="featured-product product">
		<div class="container-fluid">
			<div class="section-header">
				<c:forEach var="list" items="${list3}">
   						<div div class="centered" style="font-weight: bold; font-size: larger;">最新消息：${list.announcementContent}</div>
				</c:forEach>
			</div>
		</div>
	</div>
			
	
	<!-- Brand End -->

	
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

	<!-- Footer Bottom Start -->
	<div class="footer-bottom">
		<div class="container">
			<div class="row">
				<div class="col-md-6 copyright">
					<p>
						Copyright &copy; <a href="#">Your Site Name</a>. All Rights
						Reserved
					</p>
				</div>

				<div class="col-md-6 template-by">
					<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
					<p>
						Designed By <a href="https://htmlcodex.com">HTML Codex</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer Bottom End -->

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
	<script>
	$(document).ready(function() {
		  // DOM 載入完成之後
		  
		  $(".btn").on(
				"click",
				function(e) {
// 					e.preventDefault();
					var progressbar = $(this).prev()
					//    console.log(a)
					//    console.log($(a).find("li"))
					//      console.log($(a).find("li[class='active']:last"))
					var currentDiscount = $(progressbar).find(
							"li[class='active']:last").find("i").text()
					//    console.log(currentDiscount)
					var countTable = $(this).next()
					//    console.log(countTable)
					if (currentDiscount == "") {
// 						console.log("123");
						countTable.val("1");
					} else {
					countTable.val(currentDiscount*0.1)
					};
// 					console.log(currentDiscount);
				})
				$("#search").on("click",function(e){
					e.preventDefault();			
					$.ajax({
						  url: "${pageContext.request.contextPath}/back-end/groupproduct/GroupproductSearch",           // 資料請求的網址
						  type: "POST",                  // GET | POST | PUT | DELETE | PATCH
						  data: $("#form").serialize(),           // 將物件資料(不用雙引號) 傳送到指定的 url
						  dataType: "json",             // 預期會接收到回傳資料的格式： json | xml | html
						  success: function(data){      // request 成功取得回應後執行
// 							  console.log(data);
// 						  console.log(JSON.stringify(data))
							 var str = "";
							for(var i = 0; i < data.length; i++){
								var  str1 = `
									  <div class="col-md-4">
										<form id="msform" METHOD="post" class="col-md-12"
											style="border: 0px"
											ACTION="${pageContext.request.contextPath}/back-end/groupproduct/getOneForDisplay">
											<div class="col-md-4">
												<div class="product-item">
													<div class="product-title">
														<a>商品編號 : \${data[i].groupBuyProductID}</a>
													</div>
													<div class="product-image">
														<a> <img
															src="${pageContext.request.contextPath}/back-end/groupproduct/DBJPGReader?groupBuyProductID=\${data[i].groupBuyProductID}"
															style="width: 100%" alt="product-image">
															</td>
														</a>
													</div>
													<div class="product-price">
														<h3>
															<span>原價$</span>\${data[i].groupBuyProductPrice}</h3>
														<input type="hidden" name="groupBuyProductID"
															value="\${data[i].groupBuyProductID}">
														<button class="btn fa fa-search" type="submit">查看商品
														</button>
													</div>
												</div>
											</div>
										</form>
									</div>
									  `;
									  
									  str = str + str1;
									  
							}
							console.log(str);
						  $("#listAll").html(str);
						  
						  
						  
						  
						  
						  
						  
						  
						  },
						  error: function(xhr){         // request 發生錯誤的話執行
						    console.log(xhr);
						  },
						});
				})
		});
		
				
				
	</script>

</body>

</html>