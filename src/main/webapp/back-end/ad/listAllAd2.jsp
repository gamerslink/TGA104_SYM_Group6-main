<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.group6.tibame104.ad.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
AdService adSvc = new AdService();
List<AdVO> list = adSvc.getAll();
pageContext.setAttribute("list", list);
%>


<html>
<head>
<title>所有廣告 - listAllAd2.jsp</title>
</head>
<body>
	<%@ include file="styles.jsp"%>
	<div class="container-fluid position-relative bg-white d-flex p-0">
		<!-- Sidebar Start -->
		<%@ include file="sidebar.jsp"%>
		<!-- Sidebar ends -->

		<!-- Content Start -->
		<div class="content sym-yellow-bk">
			<!-- Navbar Start -->
			<%@ include file="navbar.jsp"%>
			<!-- Navbar ends -->

			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h2 class="m-0 sym-dark-font">廣告設定 - 所有廣告</h2>
						</div>
						<div class="col-sm-6 flex-direction">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a
									href="${pageContext.request.contextPath}/back-end/ad/select_page2.jsp">廣告設定</a>
								</li>
								<li class="breadcrumb-item active">所有廣告</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
			<!-- /.content-header -->

			<!-- Main content -->
			<div class="container-fluid">
				<!-- left column -->
				<div class="col-md-12">
					<!-- general form elements -->
					<div class="card card-primary">
						<div class="card-header sym-darkpurple">
							<h3 class="card-title sym-yellow-font">搜尋結果 	 <%@ include file="page1.file"%></h3>
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
												<!-- 									<th>管理員編號</th> -->
												<th>團購編號</th>
												<th>廣告標題</th>
												<!-- 									<th>廣告類別</th> -->
												<th>廣告描述</th>
												<th>廣告圖片</th>
												<th>上架日期</th>
												<th>下架日期</th>
												<th>更新日期</th>
												<th>修改</th>
												<th>刪除</th>
											</tr>
										</thead>

										<c:forEach var="adVO" items="${list}" begin="<%=pageIndex%>"
											end="<%=pageIndex+rowsPerPage-1%>">
											<tr>
												<td>${adVO.adSerialID}</td>
												<%-- 		<td>${adVO.administratorID}</td> --%>
												<td>${adVO.groupBuyID}</td>
												<td>${adVO.adTitle}</td>
												<%-- 		<td>${adVO.adType}</td>		 --%>
												<td>${adVO.adDescribe}</td>
												<td class="imgTable"><img
													src="${pageContext.request.contextPath}/back-end/ad/ad2.do?adSerialID=${adVO.adSerialID}"
													height="150" width="300"></td>
												<td>${adVO.adStartDate}</td>
												<td>${adVO.adEndDate}</td>
												<td>${adVO.updateTime}</td>
												<td>
													<FORM METHOD="post" enctype="multipart/form-data"
														ACTION="${pageContext.request.contextPath}/back-end/ad/adServlet"
														style="margin-bottom: 0px;">
														<input
															class="btn sym-darkpurple sym-yellow-font btn_style"
															type="submit" value="修改"> <input type="hidden"
															name="adSerialID" value="${adVO.adSerialID}"> <input
															type="hidden" name="action" value="getOne_For_Update">
													</FORM>
												</td>
												<td>
													<FORM METHOD="post"
														ACTION="${pageContext.request.contextPath}/back-end/ad/adServlet"
														style="margin-bottom: 0px;">
														<input
															class="btn sym-darkpurple sym-yellow-font btn_style"
															type="submit" value="刪除"> <input type="hidden"
															name="adSerialID" value="${adVO.adSerialID}"> <input
															type="hidden" name="action" value="delete">
													</FORM>
												</td>
											</tr>
										</c:forEach>

									</table>
								</div>
								<!-- /.card-body -->
							</div>
						</div>
						<!-- /.card-body -->
						<div class="card-footer mb-2rem">
							<!-- /.card-body -->
							<%@ include file="page2.file"%>
						</div>
					</div>
					<!-- Footer Start -->
					<%@ include file="footer.jsp"%>
					<!-- Footer End -->
				</div>
			</div>

		</div>
	</div>
	<!-- Template Javascript -->
	<script src="../js/main.js"></script>
</body>
</html>