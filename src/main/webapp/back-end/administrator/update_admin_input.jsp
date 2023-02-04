<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.group6.tibame104.administrator.model.*"%>

<%
AdministratorVO administratorVO = (AdministratorVO) request.getAttribute("administratorVO");
%>
<%-- --<%= administratorVO==null %>--${administratorVO.groupBuyID()}-- --%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>管理員修改 - update_admin_input2.jsp</title>
</head>
<body>
	<%@ include file="styles.jsp"%>

	<div class="container-fluid position-relative bg-white d-flex p-0">
		<!-- Spinner Start -->
		<div id="spinner"
			class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
			<div class="spinner-border text-primary"
				style="width: 3rem; height: 3rem" role="status">
				<span class="sr-only">Loading...</span>
			</div>
		</div>
		<!-- Spinner End -->

		<!-- Sidebar Start -->
		<div class="sidebar pe-4 pb-3 sym-skin">
			<nav class="navbar sym-skin navbar-light">
				<a href="index.html" class="navbar-brand mx-4 mb-3">
					<h3 class="text-primary">
						<img src="../img/logoSYM.jpg" alt="logo" width="100%" />
					</h3>
				</a>
				<div class="d-flex align-items-center ms-4 mb-4">
					<div class="position-relative">
						<img class="rounded-circle" src="../img/logoSYM3.jpg" alt=""
							style="width: 40px; height: 40px" />
						<div
							class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
					</div>
					<div class="ms-3">
						<!-- <h4 class="mb-0">歡迎您~</h4> -->
						<span><h5>Admin</h5></span>
					</div>
				</div>
				<div class="navbar-nav w-100">

					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown"><i
							class="fa fa-tachometer-alt me-2"></i>公告管理</a>
						<div class="dropdown-menu bg-transparent border-0">
							<a href="typography.html" class="dropdown-item">公告消息管理</a>
						</div>
					</div>

					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown"><i class="fa fa-laptop me-2"></i>商家管理</a>
						<div class="dropdown-menu bg-transparent border-0">
							<a href="button.html" class="dropdown-item">商家審核</a> <a
								href="typography.html" class="dropdown-item">商家查詢</a>
						</div>
					</div>

					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown"><i class="fa fa-th me-2"></i>活動管理</a>
						<div class="dropdown-menu bg-transparent border-0">
							<a href="button.html" class="dropdown-item">廣告設定</a> <a
								href="typography.html" class="dropdown-item">優惠券設定</a>
						</div>
					</div>

					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown"><i class="fa fa-keyboard me-2"></i>會員管理</a>
						<div class="dropdown-menu bg-transparent border-0">
							<a href="button.html" class="dropdown-item">會員查詢</a>
						</div>
					</div>

					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown"><i class="fa fa-table me-2"></i>團購管理</a>
						<div class="dropdown-menu bg-transparent border-0">
							<a href="button.html" class="dropdown-item">團購訂單</a> <a
								href="button.html" class="dropdown-item">商品管理</a>
						</div>
					</div>

					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown"><i class="fa fa-chart-bar me-2"></i>客服中心</a>
						<div class="dropdown-menu bg-transparent border-0">
							<a href="button.html" class="dropdown-item">平台幫助中心</a>
						</div>
					</div>
				</div>
			</nav>
		</div>
		<!-- Sidebar End -->


		<!-- Content Start -->
		<div class="content sym-yellow-bk">
			<!-- Navbar Start -->
			<nav
				class="navbar navbar-expand sym-skin sticky-top px-4 py-0 mb-2rem">
				<a href="index.html" class="navbar-brand d-flex d-lg-none me-4">
					<h2 class="text-primary mb-0">
						<i class="fa fa-hashtag"></i>
					</h2>
				</a> <a href="#" class="sidebar-toggler flex-shrink-0"> <i
					class="fa fa-bars"></i>
				</a>

				<div class="navbar-nav align-items-center ms-auto">
					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown"> <i class="fa fa-envelope me-lg-2"></i>
							<span class="d-none d-lg-inline-flex">聊聊</span>
						</a>
						<div
							class="dropdown-menu dropdown-menu-end border-0 rounded-0 rounded-bottom m-0">
<!-- 							<a href="#" class="dropdown-item"> -->
<!-- 								<div class="d-flex align-items-center"> -->
<!-- 									<img class="rounded-circle" src="../img/logoSYM3.jpg" alt="" -->
<!-- 										style="width: 40px; height: 40px" /> -->
<!-- 									<div class="ms-2"> -->
<!-- 										<h6 class="fw-normal mb-0">message</h6> -->
<!-- 										<small>15 minutes ago</small> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</a> -->
							<a href="#" class="dropdown-item">
								<div class="d-flex align-items-center">
									<img class="rounded-circle" src="../img/logoSYM3.jpg" alt=""
										style="width: 40px; height: 40px" />
									<div class="ms-2">
										<h6 class="fw-normal mb-0">message</h6>
										<small>15 minutes ago</small>
									</div>
								</div>
							</a>
							<hr class="dropdown-divider" />
							<a href="#" class="dropdown-item">
								<div class="d-flex align-items-center">
									<img class="rounded-circle" src="../img/logoSYM3.jpg" alt=""
										style="width: 40px; height: 40px" />
									<div class="ms-2">
										<h6 class="fw-normal mb-0">message</h6>
										<small>15 minutes ago</small>
									</div>
								</div>
							</a>
							<hr class="dropdown-divider" />
							<a href="#" class="dropdown-item text-center">所有消息</a>
						</div>
					</div>
					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown"> <img
							class="rounded-circle me-lg-2" src="../img/logoSYM3.jpg" alt=""
							style="width: 40px; height: 40px" /> <span
							class="d-none d-lg-inline-flex">歡迎您~ Admin</span>
						</a>
						<div
							class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
							<a href="#" class="dropdown-item">個人中心</a> <a href="#"
								class="dropdown-item">設定</a> <a href="#" class="dropdown-item">登出</a>
						</div>
					</div>
				</div>
			</nav>
			<!-- Navbar End -->
</div>
			<!-- Content starts-->
			<div class="wrapper">
				<header id="header"></header>
				<!-- Main Sidebar Container 主側邊欄-->
				<aside id="sidebar"
					class="main-sidebar sidebar-dark-primary elevation-4"></aside>
				<!-- Content Wrapper. Contains page content 主頁面欄位-->
				<div class="content-wrapper">
					<!-- Content Header (Page header) -->
					<div class="content-header">
						<div class="container-fluid">
							<div class="row mb-2">
								<div class="col-sm-6">
									<h2 class="m-0 sym-dark-font">管理員資料修改</h2>
								</div>
								<!-- /.col -->
								<div class="col-sm-6 flex-direction">
									<ol class="breadcrumb float-sm-right">
										<li class="breadcrumb-item"><a
											href="<%=request.getContextPath()%>/back-end/administrator/LoginServlet">home</a>
										</li>
										<li class="breadcrumb-item active">管理員資料修改</li>
									</ol>
								</div>
								<!-- /.col -->
							</div>
							<!-- /.row -->
						</div>
						<!-- /.container-fluid -->
					</div>
					<!-- /.content-header -->

					<!-- Main content -->
					<div class="">
						<div class="container-fluid">
							<div class="row">
								<!-- left column -->
								<div class="col-md-12">
									<!-- general form elements -->
									<div class="card card-primary">
										<div class="card-header sym-darkpurple">
											<h3 class="card-title sym-yellow-font">管理員資料修改</h3>
										</div>
										<!-- /.card-header -->
										<!-- form start -->




<FORM METHOD="post"
	ACTION="<%=request.getContextPath()%>/back-end/administrator/administratorServlet">
<!-- name="form1">  -->

<div class="row">
	<div class="col-sm-4">
		<div class="form-group">
			<label class="sym-dark-font"><h5>管理員名稱 :</h5></label> <input
				type="TEXT" name="administratorName" class="form-control mb-2rem"
				id="proName" placeholder=""
				value="<%=administratorVO.getAdministratorName()%>" />
		</div>
	</div>
</div>
<br /> <label for="productNameInput" class="sym-dark-font"><h5>帳號
		:</h5></label> <input type="TEXT" name="administratorAccount"
	class="form-control mb-2rem" id="proName"
	placeholder="請輸入帳號"
	value="<%=administratorVO.getAdministratorAccount()%>" />

<div class="row">
	<div class="col-sm-4">
		<div class="form-group">
			<label for="proPrice" class="sym-dark-font"><h5>密碼
					:</h5></label> <input type="TEXT" name="administratorPassword"
				class="form-control" id="proPrice" placeholder="請輸入密碼"
				value="<%=administratorVO.getAdministratorPassword()%>" />
			<br />
		</div>
	</div>
</div>
</FORM>
<div class="card-footer">
	<button class="btn sym-darkpurple sym-yellow-font btn_style"
		type="hidden" name="action" value="update">送出修改</button>
	<input type="hidden" name="administratorID"
		value="<%=administratorVO.getAdministratorID()%>"
				id="addProduct"> <input type="submit" value="送出修改">
		</div>
</div>

<!-- /.card -->
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
<font style="color: red">請修正以下錯誤:</font>
<ul>
	<c:forEach var="message" items="${errorMsgs}">
<li style="color: red">${message}</li>
</c:forEach>
</ul>
</c:if>
	</div>
</div>

<!-- /.row -->
</div>
<!-- /.container-fluid -->
</div>
<!-- /.content -->
</div>


				<!-- Footer Start -->
				<div class="container-fluid pt-4 px-4">
					<div class="bg-light rounded-top p-4">
						<div class="row">
							<div class="col-12 col-sm-6 text-center text-sm-start">
								&copy; <a href="#">Tibame TGA104 第六組 SYM</a>, All Right
								Reserved.
							</div>
							<div class="col-12 col-sm-6 text-center text-sm-end">
								<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
								Designed By <a href="https://htmlcodex.com">HTML Codex</a>
							</div>
						</div>
					</div>
				</div>
				<!-- Footer End -->
</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>


<!-- JavaScript Libraries -->

<script>
	$.datetimepicker.setLocale('zh'); // kr ko ja en
	$(function() {
		$('#start_date').datetimepicker(
				{
					format : 'Y-m-d',
					onShow : function() {
						this.setOptions({
							maxDate : $('#end_date').val() ? $('#end_date')
									.val() : false
						})
					},
					timepicker : false
				});

		$('#end_date').datetimepicker(
				{
					format : 'Y-m-d',
					onShow : function() {
						this.setOptions({
							minDate : $('#start_date').val() ? $('#start_date')
									.val() : false
						})
					},
					timepicker : false
				});
	});
</script>


</html>