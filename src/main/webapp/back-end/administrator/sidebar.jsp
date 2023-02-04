<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
		<nav class="navbar sym-skin navbar-light mb-2rem">
			<a href="index.html" class="navbar-brand mx-4 mb-3">
					<img src="../img/logoSYM.jpg" alt="logo" width="100%" />
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
					<h5>Admin</h5>
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
						data-bs-toggle="dropdown"><i
						class="fa fa-laptop me-2"></i>商家管理</a>
					<div class="dropdown-menu bg-transparent border-0">
						<a
							href="${pageContext.request.contextPath}/back-end/administrator/sellerVerify.jsp"
							class="dropdown-item">商家審核</a> <a
							href="${pageContext.request.contextPath}/back-end/administrator/sellerVerify.jsp"
							class="dropdown-item">商家查詢</a>
					</div>
				</div>

				<div class="nav-item dropdown">
					<a href="#" class="nav-link dropdown-toggle"
						data-bs-toggle="dropdown"><i
						class="fa fa-th me-2"></i>活動管理</a>
					<div class="dropdown-menu bg-transparent border-0">
						<a
							href="${pageContext.request.contextPath}/back-end/ad/select_page2.jsp"
							class="dropdown-item">廣告設定</a> <a
							href="${pageContext.request.contextPath}/back-end/ad/select_page2.jsp"
							class="dropdown-item">優惠券設定</a>
					</div>
				</div>

				<div class="nav-item dropdown">
					<a href="#" class="nav-link dropdown-toggle"
						data-bs-toggle="dropdown"><i
						class="fa fa-keyboard me-2"></i>會員管理</a>
					<div class="dropdown-menu bg-transparent border-0">
						<a href="button.html" class="dropdown-item">會員查詢</a>
					</div>
				</div>

				<div class="nav-item dropdown">
					<a href="#" class="nav-link dropdown-toggle"
						data-bs-toggle="dropdown"><i
						class="fa fa-table me-2"></i>團購管理</a>
					<div class="dropdown-menu bg-transparent border-0">
						<a href="button.html" class="dropdown-item">團購訂單</a> <a
							href="button.html" class="dropdown-item">商品管理</a>
					</div>
				</div>

				<div class="nav-item dropdown">
					<a href="#" class="nav-link dropdown-toggle"
						data-bs-toggle="dropdown"><i
						class="fa fa-chart-bar me-2"></i>客服中心</a>
					<div class="dropdown-menu bg-transparent border-0">
						<a href="button.html" class="dropdown-item">平台幫助中心</a>
					</div>
				</div>
			</div>
		</nav>
	</div>
	<!-- Sidebar End -->
</body>
</html>