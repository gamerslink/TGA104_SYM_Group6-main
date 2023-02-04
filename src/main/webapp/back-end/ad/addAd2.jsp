<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.group6.tibame104.ad.model.*"%>

<%
AdVO adVO = (AdVO) request.getAttribute("adVO");
%>

<%-- --<%=adVO == null%>--${adVO.groupBuyID()}-- --%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>廣告新增 - addAd.jsp</title>


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

			<!-- Content starts-->
			<FORM METHOD="post" enctype="multipart/form-data"
				ACTION="${pageContext.request.contextPath}/back-end/ad/adServlet"
				name="form1">


				<!-- Content Header (Page header) -->
				<div class="content-header">
					<div class="container-fluid">
						<div class="row mb-2">
							<div class="col-sm-6">
								<h2 class="m-0 sym-dark-font">廣告設定 - 新增廣告</h2>
							</div>
							<div class="col-sm-6 flex-direction">
								<ol class="breadcrumb float-sm-right">
									<li class="breadcrumb-item"><a href="select_page2.jsp">廣告設定</a>
									</li>
									<li class="breadcrumb-item active">新增廣告</li>
								</ol>
							</div>
						</div>
					</div>
				</div>
				<!-- /.content-header -->

				<!-- Main content -->
				<div class="container-fluid">
					<div class="col-md-12">
						<div class="card card-primary">
							<div class="card-header sym-darkpurple">
								<h3 class="card-title sym-yellow-font">廣告設定 - 新增廣告</h3>
							</div>
							<!-- /.card-header -->
							<div class="card-body">
								<div class="form-group">
									<div class="display-flex mg-bottom-2">
										<div class="col-sm-4">
											<div class="form-group">
												<h5>管理員編號:</h5>
																								<div class="mg-bottom-2"><input type="TEXT" name="administratorID" size="45" 
																									 value="<%=(adVO==null)? "1" : adVO.getAdministratorID()%>" />
																								</div>
<%-- 												<jsp:useBean id="adSvc" scope="page" --%>
<%-- 													class="com.group6.tibame104.ad.model.AdService" /> --%>
<!-- 												<select  size="1" name="administratorID"> -->
<%-- 													<c:forEach var="adVO" items="${list}"> --%>
<%-- 														<option value="${adVO.administratorID}" --%>
<%-- 															${(adVO.administratorID==adVO.administratorID)? 'selected':'' }>${adVO.administratorID} --%>
<%-- 													</c:forEach> --%>
<!-- 												</select> -->
											</div>
											<div class="col-sm-4">
												<%-- 												<jsp:useBean id="adSvc" scope="page" class="com.ad.model.AdService" /> --%>
												<h5>
													廣告類別:<font color=red><b>*</b></font>
												</h5>
												<input type="text" name="AdType" class="mb-2rem"
													id="proName" placeholder=""
													value="<%=(adVO == null) ? "團購相關" : adVO.getAdType()%>" />
<!-- 												<select  size="1" name="adType"> -->
<%-- 													<c:forEach var="adVO" items="${adSvc.all}"> --%>
<%-- 														<option value="${adVO.adType}" --%>
<%-- 															${(adVO.adType==adVO.adType)? 'selected':'' }>${adVO.adType} --%>
<%-- 													</c:forEach> --%>
<!-- 												</select> -->
											</div>
										</div>
									</div>
									<div class="display-flex mg-bottom-2">
										<div class="col-sm-4">
											<div class="form-group">
												<h5 class="sym-dark-font">開始日期</h5>
												<input type="date" name="adStartDate" id="start_date"
													class="form-control" id="proBrand" placeholder="開始日期" />
											</div>
										</div>
										<div class="col-sm-4 margin-left-1">
											<div class="form-group">
												<h5 class="sym-dark-font">結束日期</h5>
												<input type="date" name="adEndDate" id="end_date"
													class="form-control" id="proSpecs" placeholder="結束日期" />
											</div>
										</div>
									</div>

									<h5 class="sym-dark-font">廣告標題:</h5>
									<input type="text" name="adTitle" class="form-control mb-2rem"
										id="proName" placeholder="請輸入標題內容"
										value="<%=(adVO == null) ? "請輸入標題內容" : adVO.getAdTitle()%>" />
								</div>

								<div class="row">
									<div class="col-sm-4">
										<div class="form-group">
											<h5 class="sym-dark-font">廣告描述</h5>
											<input type="text" class="form-control" name="adDescribe"
												id="proBrand" placeholder=""
												value="<%=(adVO == null) ? "請輸入廣告描述" : adVO.getAdDescribe()%>" />
										</div>
									</div>

									<div class="col-sm-4">
										<div class="form-group">
											<h5 class="sym-dark-font">團購編號</h5>
											<input type="text" name="groupBuyID" class="form-control"
												id="proBrand" placeholder="請輸入團購編號"
												value="<%=(adVO == null) ? "1" : adVO.getGroupBuyID()%>" />
										</div>
									</div>
								</div>

							</div>
							<!-- /.card-body -->
							<div class="card-footer">
								<input type="hidden" name="action" value="insert"> <input
									type="submit"
									class="btn sym-darkpurple sym-yellow-font btn_style"
									id="addProduct" value="送出新增">
							</div>

							<div class="mg-bottom-2">
								<label>圖片：</label> <input type="file" name="pho" id="p_file">
								<div id="preview" style="width: 300px">
									<span class="text">預覽圖</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</FORM>
			<!-- Footer Start -->
			<%@ include file="footer.jsp"%>
			<!-- Footer End -->
		</div>
	</div>
</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->


<%
java.sql.Date adStartDate = null;
try {
	adStartDate = adVO.getAdStartDate();
} catch (Exception e) {
	adStartDate = new java.sql.Date(System.currentTimeMillis());
}

java.sql.Date adEndDate = null;
try {
	adEndDate = adVO.getAdEndDate();
} catch (Exception e) {
	adStartDate = new java.sql.Date(System.currentTimeMillis());
}
%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/datetimepicker/jquery.datetimepicker.css" />
<script
	src="${pageContext.request.contextPath}/datetimepicker/jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/datetimepicker/jquery.datetimepicker.full.js"></script>



<!-- Template Javascript -->
<script src="../js/main.js"></script>
<script src="../js/app.js"></script>



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