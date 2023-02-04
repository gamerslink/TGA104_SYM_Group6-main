<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.group6.tibame104.administrator.model.*"%>

<html>
<head>
<title>商家審核 - listAllAd2.jsp</title>
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
			<div class="wrapper">
				<div class="content-wrapper">
					<!-- Content Header (Page header) -->
					<div class="content-header">
						<div class="container-fluid">
							<div class="row mb-2">
								<div class="col-sm-6">
									<h1 class="m-0 sym-dark-font">賣場申請</h1>
								</div>
								<!-- /.col -->
								<div class="col-sm-6 flex-direction">
									<ol class="breadcrumb float-sm-right">
										<li class="breadcrumb-item"><a href="#">Home</a></li>
										<li class="breadcrumb-item active">會員賣場申請</li>
									</ol>
								</div>
							</div>
						</div>
					</div>
					<!-- /.content-header -->

					<!-- main start -->

					<!-- Main content -->
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-12">
								<div class="card card-primary">
									<div class="card-header sym-darkpurple">
										<h3 class="card-title sym-yellow-font">搜尋列表</h3>
									</div>
									<!-- /.card-header -->

									<!-- form start -->
									<form id="memberSearch" METHOD="post"
										ACTION="${pageContext.request.contextPath}/back-end/administrator/administratorServlet">
										<div class="card-body">
											<div class="form-group">
												<div class="col-sm-4">
													<div class="form-group">
														<div class="col-6 mb-2rem">
															<h5 class="sym-dark-font">帳號狀態 :</h5>
															<br> 
															<select id="selectSearch" name="cars" class="form-control mb-2rem">
																<option value="volvo">待審核</option>
																<option value="saab">審核</option>
															</select> 
															<input id="btnSearchSeller"
																class="btn sym-darkpurple sym-yellow-font btn_style"
																value="送出">

														</div>
													</div>
												</div>
											</div>
										</div>
										<!-- /.card-body -->
									</form>

									<div class="col-md-12">
										<div class="card card-primary">
											<div class="card-header sym-darkpurple">
												<h3 class="card-title sym-yellow-font">查詢結果</h3>
											</div>
											<!-- /.card-header -->
											<div class="card-body">
												<table id="searchSeller"
													class="table table-bordered table-hover">
													<thead>
														<tr>
															<!-- 																<th>會員帳號</th> -->
															<!-- 																<th>賣場名稱</th> -->
															<!-- 																<th>賣場地址</th> -->
															<!-- 																<th>連絡電話</th> -->
															<!-- 																<th>創建日期</th> -->
															<!-- 																<th>更新日期</th> -->
															<!-- 																<th>統一編號</th> -->
															<!-- 																<th>審核狀態</th> -->
															<!-- 																<th>審核</th> -->
														</tr>
													</thead>
													<tr>

														<!-- 														<td> -->
														<!-- 																															<FORM METHOD="post" enctype="multipart/form-data" -->
														<%-- 																																ACTION="<%=request.getContextPath()%>/member/MemberServlet" --%>
														<!-- 																																style="margin-bottom: 0px;"> -->
														<!-- 															<button onclick="popupWindow()" -->
														<!-- 																class="btn sym-darkpurple sym-yellow-font btn_style">審核</button> -->

														<!-- 																															</FORM> -->
														<!-- 														</td> -->
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
				<!-- Footer Start -->
				<%@ include file="footer.jsp"%>
				<!-- Footer End -->
			</div>
		</div>
	</div>









	<!-- Template Javascript -->
	<script src="../js/main.js"></script>
	<script src="../js/app.js"></script>
	<script type="text/javascript" src="script.js"></script>
	<script src="${pageContext.request.contextPath}/JQ/jquery-3.6.1.min.js"></script>
<!-- 	<script> -->
// 		function popupWindow() {
// 		    window.open("popup.jsp", "Popup Window", "width=500,height=500,modal=yes");
// 		}

<!-- 		</script> -->

	<script>
	$(function() {
		var template = 
		`<table class="table table-striped col-sm-12">
			<tr>
			<th>會員帳號</th>
			<th>賣場名稱</th>
			<th>賣場地址</th>
			<th>連絡電話</th>
			<th>創建日期</th>
			<th>更新日期</th>
			<th>統一編號</th>
			<th>審核狀態</th>
			<th>審核</th>
		</tr>
		`;
		
		var str=``;
		function bbb(data){
			str=``;
			let status ='';
			let status2 = '';
			for(let i=0;i<data.length;i++){
				if(data[i].storeAuditStatus == 0){
					status2 = '待審核';
				}else{
					status2 = '通過';
				}
				let templateList =   `
					<tr>
						<td>`+data[i].memberID+`</td>
						<td>`+data[i].storeName+`</td>
						<td>`+data[i].storeAddress+`</td>
						<td>`+data[i].phoneNumber+`</td>
						<th>`+data[i].createDate+`</th>
						<td>`+data[i].updateDate+`</td>
						<td>`+data[i].taxID+`</td>
						<td>`+status2+`</td>
						<th><a href="${pageContext.request.contextPath}/back-end/administrator/AdminMailServlet?memberID=`+data[i].memberID+`"><button class="btn sym-darkpurple sym-yellow-font btn_style">√</button></a></th>
					</tr>
				`;
				str = str + templateList;
			}
		}
		var str2=`</table>`;
		// **待審核**/
		$("#btnSearchSeller")
				.click(
						function() {
							let variable1 ='';
							if($("#selectSearch option:selected").val()=='volvo'){
								variable1 = '${pageContext.request.contextPath}/back-end/administrator/administratorServlet';
							}else{
								variable1 = '${pageContext.request.contextPath}/back-end/administrator/StorePassServlet';
							}
							$
									.ajax({
										url : variable1,
										// 資料請求的網址
										type : "GET", // GET | POST | PUT | DELETE | PATCH
										dataType : "json", // 預期會接收到回傳資料的格式： json | xml | html
										success : function(data) {
											// request 成功取得回應後執行
											console.log(data);
											bbb(data);
											//console.log(str);
											//console.log(data[0].productID+"哭啊");
											console.log(data.length);
											$("#searchSeller").html("<h2>搜尋結果總共有"+data.length+"筆</h2>"+template+str+str2);
										},
										error : function(XMLHttpRequest) {
											if (XMLHttpRequest.status >= 400) {
												alert("出現錯誤");
											}
										}
									});
						});
	});
</script>
</body>
</html>