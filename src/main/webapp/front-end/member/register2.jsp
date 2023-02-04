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
<link href="./img/logoSYM.jpg" rel="icon" />

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
<script src="https://kit.fontawesome.com/bc79e44e11.js"
	crossorigin="anonymous"></script>
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
						<a href="index.html" class="nav-item nav-link">首頁</a> <a
							href="product-list.html" class="nav-item nav-link">我的賣場</a>

						<div class="nav-item dropdown">
							<a href="#" class="nav-link" data-toggle="dropdown">客服中心</a>
						</div>
					</div>
				</div>
				<div class="navbar-nav ml-auto">
					<div class="nav-item dropdown">
						<a href="login.jsp" class="nav-link">登入/註冊</a>
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

	<!-- Login Start -->
	<div class="login" role="tabpanel">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg">
					<div class="register-form">
						<h4>請繼續填寫以下資料</h4>
						<br />
						<FORM METHOD="post"
							ACTION="
							${pageContext.request.contextPath}/front-end/member/update"
							enctype="multipart/form-data" name="form3">
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
								<div class="col-6">

									<div class="col">
										<label>性別</label> <select name="gender" class="form-control">
											<option value="M" selected>男</option>
											<option value="W">女</option>
											<option value="O">其他</option>
										</select>
									</div>
								</div>

								<div class="col-6">
									<div class="col">
										<label for="birthday">生日</label> <input class="form-control"
											name="birthday" type="date" />
									</div>
								</div>
								<div class="col-6">
									<div class="col">
										<label>身分證號</label> <input class="form-control shop_text"
											type="text" name="idNumber" placeholder="身分證號" />
									</div>
								</div>
								<div class="col-6">
									<div class="col">
										<select id="city" name="city">
											<option value="">請選擇</option>
										</select> <select id="area" name="area" style="display: none;">
											<option value="">請選擇</option>
										</select> <label>地址</label> <input id = "address" class="form-control shop_text"
											type="text" name="address" placeholder="地址" />
									</div>
								</div>
								<div class="col-12">
									<hr />
								</div>

								<div class="col">
									<div class="row">
										<div class="col-md-4">是否開通賣家功能</div>
										<div class="col-md-4">
											<input type="radio" name="custom_name" value="1" />是
										</div>
										<div class="col-md-4">
											<input type="radio" name="custom_name" value="2" checked />
											否
										</div>
									</div>
									<br />

									<div id="shop_input_text">

										<div class="col">
											<label>賣場名稱</label> <input class="form-control shop_text"
												type="text" placeholder="賣場名稱" />
										</div>
										<div class="col">
											<label>銀行帳號</label> <input class="form-control shop_text"
												type="text" placeholder="銀行帳號" />
										</div>

									</div>

									<br /> <br />
									<div class="col-md">
										 <input
											type="hidden" name="memberID" value="${memVO.getMemberID()}">
										<input type="hidden" name="mail" value="${memVO.getMail()}">
										<input class="btn" type="submit" value="註冊">


									</div>
								</div>
								<div class="col">
									<div class="col-12">
										<br /> <br /> <br /> <br />
									</div>
									<div class="row justify-content-center">
										<div
											class="col-6 p-1 align-self-center d-flex justify-content-center">
											<img class="rounded-circle user_img"
												src="${pageContext.request.contextPath}/front-end/member/img/account.jpg"
												alt="" style="width: 200px; height: 200px; object-fit: cover" />
										</div>
										<div class="w-100"></div>
										<br />
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
		<script>

		$(document).ready(function(){

			//第一層選單
		    $.ajax({
		        url: 'https://raw.githubusercontent.com/donma/TaiwanAddressCityAreaRoadChineseEnglishJSON/master/CityCountyData.json',              
		        type: "get",
				dataType: "json",
		        success: function (data) {
					console.log(data);
					$.each(data,function(key,value){
						console.log(key,value)
						$('#city').append('<option value="'+key+'">'+data[key].CityName+'</option>')
					})
				},
		        error: function (data) {
		            alert("fail");
		        }
		    });
				
			//第二層選單
			$("#city").change(function(){
				cityvalue=$("#city").val();  //取值
				$("#area").empty(); //清空上次的值
				$("#area").css("display","inline"); //顯現
				$.ajax({
					url:'https://raw.githubusercontent.com/donma/TaiwanAddressCityAreaRoadChineseEnglishJSON/master/CityCountyData.json',
					type:"get",
					dataType:"json",
					success:function(data){
					
						eachval=data[cityvalue].AreaList; //鄉鎮
						
						$.each(eachval,function(key,value){
							$('#area').append('<option value="'+key+'">'+eachval[key].AreaName+'</option>')
						});
					},
					error:function(){
						alert("fail");
					}
					
				});
			});
		});
		//選完後跳出選擇值
			$("#area").change(function(){
				cityvalue=$("#city").val();  //縣市
				areavalue=$("#area").val();  //鄉鎮
				$.ajax({
					url:'https://raw.githubusercontent.com/donma/TaiwanAddressCityAreaRoadChineseEnglishJSON/master/CityCountyData.json',
					type:"get",
					dataType:"json",
					success:function(data){
						$("#address").val(data[cityvalue].CityName+data[cityvalue].AreaList[areavalue].AreaName);
					},
					error:function(){
						alert("fail");
					}
					
				});
				
			})
		
		
		</script>
</body>
</html>
