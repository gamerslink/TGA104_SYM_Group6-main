<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.group6.tibame104.ad.model.*"%>

<%
AdVO adVO = (AdVO) request.getAttribute("adVO"); //EmpServlet.java (Concroller) 存入req的advVO物件 (包括幫忙取出的advVO, 也包括輸入資料錯誤時的advVO物件)
%>

<html>
<head>
<title>廣告單筆資料 - listOneAd2.jsp</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="keywords" />
<meta content="" name="description" />
</head>
<body>
	<%@ include file="styles.jsp"%>
	<!-- Sidebar Start -->
	<%@ include file="sidebar.jsp"%>
	<!-- Sidebar ends -->

	<!-- Content Start -->
	<div class="content sym-yellow-bk">
		<!-- Navbar Start -->
		<%@ include file="navbar.jsp"%>
		<!-- Navbar ends -->

		<!-- Content starts-->
		<div class="wrapper">
			<div class="content-wrapper">
				<!-- Content header starts-->
				<div class="content-header">
					<div class="container-fluid">
						<div class="row mb-2">
							<div class="col-sm-6">
								<h2 class="m-0 sym-dark-font">廣告單筆資料</h2>
							</div>
							<div class="col-sm-6 flex-direction">
								<ol class="breadcrumb float-sm-right">
									<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/back-end/ad/select_page2.jsp">Home</a></li>
									<li class="breadcrumb-item active">廣告查詢</li>
								</ol>
							</div>
						</div>
					</div>
				</div>
				<!-- Content header ends -->



				<!-- Main content -->
				<div class="">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-12">
								<div class="card card-primary">
									<div class="card-header sym-darkpurple">
										<h3 class="card-title sym-yellow-font">單筆新增結果</h3>
									</div>
									<!-- /.card-header -->
									<div class="col-md-12">
										<div class="card card-primary">

											<!-- /.card-header -->
											<div class="card-body">
												<table id="memberTable"
													class="table table-bordered table-hover">
													<thead>
														<tr>
															<th>廣告編號</th>
															<th>廣告標題</th>
															<th>廣告描述</th>
															<th>廣告圖片</th>
															<th>上架日期</th>
															<th>下架日期</th>
															<th>更新日期</th>
														</tr>
													</thead>
													<tr>
														<td>${adVO.adSerialID}</td>
														<td>${adVO.adTitle}</td>
														<td>${adVO.adDescribe}</td>
														<td><img
															src="${pageContext.request.contextPath}/back-end/ad/ad2.do?adSerialID=${adVO.adSerialID}"
															height="150" width="300"></td>
														<td>${adVO.adStartDate}</td>
														<td>${adVO.adEndDate}</td>
														<td>${adVO.updateTime}</td>
													</tr>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Footer Start -->
		<%@ include file="footer.jsp"%>
		<!-- Footer End -->
	</div>
	<!-- Content End -->

	<!-- Template Javascript -->
	<script src="../js/main.js"></script>
</body>
</html>