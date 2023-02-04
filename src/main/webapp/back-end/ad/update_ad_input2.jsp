<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.group6.tibame104.ad.model.*"%>

<%
AdVO adVO = (AdVO) request.getAttribute("adVO"); //EmpServlet.java (Concroller) 存入req的advVO物件 (包括幫忙取出的advVO, 也包括輸入資料錯誤時的advVO物件)
%>
<%-- --<%= adVO==null %>--${adVO.groupBuyID()}-- --%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>廣告資料修改 - update_ad_input2.jsp</title>
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
							<h2 class="m-0 sym-dark-font">廣告設定 - 修改廣告</h2>
						</div>
						<!-- /.col -->
						<div class="col-sm-6 flex-direction">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="select_page2.jsp">Home</a>
								</li>
								<li class="breadcrumb-item active">廣告設定</li>
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
									<h3 class="card-title sym-yellow-font">廣告設定 - 修改廣告</h3>
								</div>
								<!-- /.card-header -->
								<!-- form start -->

								<FORM METHOD="post" enctype="multipart/form-data"
									ACTION="${pageContext.request.contextPath}/back-end/ad/adServlet"
									name="form1">

									<div class="card-body">
										<div class="form-group">
											<div class="col-sm-4 mg-bottom-2">
												<h5 class="sym-dark-font sym-dark-font font-m">廣告編號</h5>
												<select class="form-control" id="proCategory">
													<option value="廣告編號"><%=adVO.getAdSerialID()%></option>

												</select>
											</div>


											<%--             <jsp:useBean id="adSvc" scope="page" class="com.ad.model.AdService" /> --%>
											<!-- 			<tr> -->
											<!-- 				<td>廣告類別:<font color=red><b>*</b></font></td> -->
											<!-- 				<td><select size="1" name="adType"> -->
											<%-- 						<c:forEach var="adVO" items="${adSvc.all}"> --%>
											<%-- 							<option value="${adVO.adType}" --%>
											<%-- 								${(adVO.adSerialID==adVO.adSerialID)?'selected':'' }>${adVO.adType} --%>
											<%-- 						</c:forEach> --%>
											<!-- 				</select></td> -->
											<!-- 			</tr> -->

											<div class="row">
												<div class="col-sm-4">
													<div class="form-group">
														<h5 class="sym-dark-font">團購編號</h5>
														<select class="form-control" id="proCategory">
															<option value="團購編號">1</option>
														</select>
													</div>
												</div>
											</div>
											<br />



											<div class="form-group">
												<div class="display-flex mg-bottom-2">
													<div class="col-sm-4">
														<div class="form-group">
															<h5 class="sym-dark-font">開始日期</h5>
															<input name="adStartDate" type="date"
																class="form-control" id="start_date" placeholder="開始日期" />
														</div>
													</div>
													<div class="col-sm-4 margin-left-1">
														<div class="form-group">
															<h5 class="sym-dark-font">結束日期:</h5>
															<input name="adEndDate" type="date" class="form-control"
																id="end_date" placeholder="結束日期" />
														</div>
													</div>
												</div>

												<h5 class="sym-dark-font">廣告標題</h5>
												<input type="TEXT" name="adTitle"
													class="form-control mb-2rem" id="proName"
													placeholder="請輸入標題內容" value="<%=adVO.getAdTitle()%>" />

												<div class="row">
													<div class="col-sm-4">
														<div class="form-group">
															<h5 class="sym-dark-font">廣告描述:</h5>
															<input type="TEXT" name="adDescribe" class="form-control"
																id="proPrice" placeholder="請輸入廣告描述"
																value="<%=adVO.getAdDescribe()%>" /> <br />

															<div>
																<label>圖片：</label> <input type="file" id="p_file" name="pho">
																<div id="preview" style="width: 300px">
																	<span class="text">預覽圖</span>
																</div>
															</div>
														</div>
													</div>
												</div>
												<!-- /.card-body -->
												<div class="card-footer">
													<button
														class="btn sym-darkpurple sym-yellow-font btn_style"
														name="action" value="update">送出修改</button>
													<input type="hidden" name="adSerialID"
														value="<%=adVO.getAdSerialID()%>" id="addProduct">
													<!-- 		<input type="submit" value="送出修改"> -->
												</div>
											</div>
										</div>
									</div>
								</FORM>
							</div>
						</div>

					</div>

					<!-- Footer Start -->
					<%@ include file="footer.jsp"%>
					<!-- Footer End -->
				</div>
			</div>
			<!-- Footer End -->

		</div>
	</div>
</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

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
        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
           theme: '',              //theme: 'dark',
 	       timepicker:false,       //timepicker:true,
 	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
 	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
 		   value: '<%=adVO.getUpdateTime()%>
	', // value:   new Date(),
	//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
	//startDate:	            '2017/07/10',  // 起始日
	//minDate:               '-1970-01-01', // 去除今日(不含)之前
	//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
	});

</script>
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