<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>搜尋廣告</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="keywords" />
<meta content="" name="description" />

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


			<div class="wrapper">
				<div class="content-wrapper">
					<!-- Content header starts-->
					<div class="content-header">
						<div class="container-fluid">
							<div class="row mb-2">
								<div class="col-sm-6">
									<h2 class="m-0 sym-dark-font">廣告設定</h2>
								</div>
								<div class="col-sm-6 flex-direction">
									<ol class="breadcrumb float-sm-right">
										<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/back-end/loginAdm/indexAdmin.jsp">Home</a></li>
										<li class="breadcrumb-item active">廣告查詢</li>
									</ol>
								</div>
							</div>
						</div>
					</div>
					<!-- Content header ends -->
					<!-- Main content -->
					<div class="container-fluid">
						<div class="col-md-12">
							<div class="card card-primary mg-bottom-2">
								<div class="card-header sym-darkpurple">
									<h3 class="card-title sym-yellow-font">搜尋條件</h3>
								</div>

								<jsp:useBean id="adSvc" scope="page"
									class="com.group6.tibame104.ad.model.AdService" />

								<%
								com.group6.tibame104.ad.model.AdJDBCDAO dao = new com.group6.tibame104.ad.model.AdJDBCDAO();
								pageContext.setAttribute("dao", dao);
								%>

								<!-- form start -->
								<FORM METHOD="post"
									ACTION="<%=request.getContextPath()%>/back-end/ad/adServlet">
									<div class="card-body">
										<div class="row">
											<div class="col-sm-12">
												<div class="form-group">
													<div class="row">
														<div class="col-6 mb-2rem">
															<h5 class="sym-dark-font">選擇廣告編號:</h5>
															<select id="adSerialID" name="adSerialID"
																class="form-control">
																<c:forEach var="adVO" items="${adSvc.all}">
																	<option value="${adVO.adSerialID}">${adVO.adSerialID}
																</c:forEach>
															</select>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>

									<!-- card-body -->
									<div class="card-footer">
										<button type="submit"
											class="btn sym-darkpurple sym-yellow-font mb-2rem btn_style">
											<i class="fa fa-search"></i> 編號搜尋
										</button>
									</div>

									<input type="hidden" name="action" value="getOne_For_Display">
								</form>
								<!-- form ends -->
								<div class="col-md-12 margin-left-1">
									<!-- form start -->
									<FORM METHOD="post"
										ACTION="<%=request.getContextPath()%>/back-end/ad/adServlet">
										<h5>輸入廣告編號 :</h5>
										<input type="text" name="adSerialID"> <input
											type="hidden" name="action" value="getOne_For_Display">
										<input type="submit"
											class="btn sym-darkpurple sym-yellow-font btn_style margin-left-1"
											value="送出">
									</FORM>
									<!-- form ends -->
								</div>

								<div class="card-footer mb-2rem">

									<button class="btn sym-darkpurple sym-yellow-font btn_style"
										id="addAd2">
										<a style="color: white" href='addAd2.jsp'>新增廣告</a>
									</button>

									<button
										class="btn sym-darkpurple sym-yellow-font btn_style margin-left-1"
										id="listAllAd2">
										<a style="color: white" href='listAllAd2.jsp'>所有廣告</a>
									</button>

								</div>
								<!-- card-ends -->
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
					</div>
				</div>

			</div>
			<!-- Footer Start -->
			<%@ include file="footer.jsp"%>
			<!-- Footer End -->
		</div>
	</div>
	<!-- Template Javascript -->
	<script src="../js/main.js"></script>
</body>
</html>