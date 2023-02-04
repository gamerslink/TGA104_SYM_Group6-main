<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>E Store - eCommerce HTML Template</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="eCommerce HTML Template Free Download" name="keywords" />
<meta content="eCommerce HTML Template Free Download" name="description" />

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon" />

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
	href="${pageContext.request.contextPath}/front-end/store/lib/slick/slick.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/store/lib/slick/slick-theme.css"
	rel="stylesheet" />

<!-- Template Stylesheet -->
<link
	href="${pageContext.request.contextPath}/front-end/store/css/style.css"
	rel="stylesheet" />
<script src="${pageContext.request.contextPath}/JQ/jquery-3.6.1.min.js"></script>


<!-- 企鵝開始 -->
<script src="${pageContext.request.contextPath}/JQ/jquery-3.6.1.min.js"></script>
<script>
	$(function() {
		var template = 
		`<table class="table table-striped col-sm-12">
			<tr>
				<th>商品ID</th>
				<th>商品次分類</th>
				<th>商品名稱</th>
				<th>圖片</th>
				<th>圖片二</th>
				<th>圖片三</th>
				<th>庫存</th>
				<th>商品價格</th>
				<th>商品描述</th>
				<th>產地</th>
				<th>狀態</th>
				<th>按鈕</th>
			</tr>
		`;
		
		var str=``;
		function aaa(data){
			str=``;
			let status ='';
			for(let i=0;i<data.length;i++){
				if(data[i].productStatus==true){
					status = '已上架';
				}else{
					status = '已下架';
				}
				let templateList =   `
					<tr>
						<td>`+data[i].productID+`</td>
						<td>`+data[i].productSecID+`</td>
						<td>`+data[i].productName+`</td>
						<td><img src="${pageContext.request.contextPath}/product/picServlet?productID=`+data[i].productID+`"
						alt="沒有圖片" width="100" height="100"></td>
						<td><img
							src="${pageContext.request.contextPath}/product/picServlet2?productID=`+data[i].productID+`"
							alt="沒有圖片" width="100" height="100"></td>
						<td><img
							src="${pageContext.request.contextPath}/product/picServlet3?productID=`+data[i].productID+`"
							alt="沒有圖片" width="100" height="100"></td>
						<td>`+data[i].productStock+`</td>
						<th>`+data[i].productPrice+`</th>
						<td>`+data[i].productDesc+`</td>
						<td>`+data[i].source+`</td>
						<th>`+status+`</th>
						<th><a href="${pageContext.request.contextPath}/product/productGetOne/get?productID=`+data[i].productID+`"><button>修改</button></a></th>
					</tr>
				`;
				str = str + templateList;
			}
		}
		var str2=`</table>`;
		
		console.log($("#searchPID").val());
		console.log($("#searchPSID").val());
		console.log($("#searchPSTATUS").val());
		console.log($("#searchSID").val());
		
		$("#btnSearchAll")
				.click(
						function() {
							$
									.ajax({
										url : "${pageContext.request.contextPath}/product/productSearchProduct/getAll_By_Cond?storeID="
												+$("#searchSID").val()+"&productID="+$("#searchPID").val()
												+"&productSecID="+$("#searchPSID").val()+"&productStatus="+$("#searchPSTATUS").val(), // 資料請求的網址
										type : "GET", // GET | POST | PUT | DELETE | PATCH
										dataType : "json", // 預期會接收到回傳資料的格式： json | xml | html
										success : function(data) {
											// request 成功取得回應後執行
											//console.log(data);
											aaa(data);
											//console.log(str);
											//console.log(data[0].productID+"哭啊");
											console.log(data.length);
											$("#searchRes").html("<h2>搜尋結果總共有"+data.length+"筆</h2>"+template+str+str2);
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
<!-- 企鵝結束 -->
</head>

<body>
<%@ include file="Header.jsp"%>
	<!-- My Account Start -->
	<div class="my-account">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-3">
					<div class="nav flex-column nav-pills" role="tablist"
						aria-orientation="vertical">
						<a class="nav-link active"><i class="fa fa-tachometer-alt"></i>賣場管理Header</a>
						<a class="nav-link" id="orders-nav" data-toggle="pill"
							href="#storeReview" role="tab"><i class="fa fa-shopping-bag"></i>賣場評價</a>
						<a class="nav-link" id="orders-nav" data-toggle="pill"
							href="#storeintroduction" role="tab"><i
							class="fa fa-shopping-bag"></i>賣場介紹</a> <a class="nav-link"><i
							class="fa fa-credit-card"></i>商品管理Header</a> <a class="nav-link"
							id="address-nav" data-toggle="pill" href="#myProduct" role="tab"><i
							class="fa fa-map-marker-alt"></i>我的商品</a> <a class="nav-link"
							id="account-nav" data-toggle="pill" href="#addProduct" role="tab"><i
							class="fa fa-user"></i>新增商品</a> <a class="nav-link"><i
							class="fa fa-user"></i>財務管理Header</a> <a class="nav-link"
							id="account-nav" data-toggle="pill" href="#orderQuery" role="tab"><i
							class="fa fa-user"></i>查詢訂單</a> <a class="nav-link"><i
							class="fa fa-user"></i>客服中心Header</a> <a class="nav-link"
							id="account-nav" data-toggle="pill" href="#account-tab"
							role="tab"><i class="fa fa-user"></i>平台幫助中心</a> <a
							class="nav-link" href="index.html"><i
							class="fa fa-sign-out-alt"></i>Logout</a>
					</div>
				</div>
				<div class="col-md-9">
					<div class="tab-content">
						<div class="tab-pane fade" id="storeReview" role="tabpanel"
							aria-labelledby="address-nav">
							<div class="col-sm-12">
								<div>
									<label>搜尋條件</label>
								</div>
								<div>
									<label>商品名稱 : </label> <input type="text" name="productName"
										value="企鵝" />
									<button>查詢</button>
								</div>
								<div>
									<table class="table table-striped col-sm-12">
										<tbody>
											<tr>
												<td>星星個數</td>
												<td>商品名稱</td>
												<td>評價內容</td>
												<td>我的評價</td>
											</tr>
											<tr>
												<td>*****</td>
												<td>蘋果</td>
												<td>有夠好吃</td>
												<td>GOOD</td>
											</tr>
											<tr>
												<td>*****</td>
												<td>蘋果</td>
												<td>有夠好吃</td>
												<td>GOOD</td>
											</tr>
											<tr>
												<td>*****</td>
												<td>蘋果</td>
												<td>有夠好吃</td>
												<td>GOOD</td>
											</tr>
											<tr>
												<td>*****</td>
												<td>蘋果</td>
												<td>有夠好吃</td>
												<td>GOOD</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="tab-pane fade" id="storeintroduction" role="tabpanel"
							aria-labelledby="address-nav">
							<form
								action="${pageContext.request.contextPath}/store/storeServlet">
								<div class="col-sm-12">
									<div>
										<h2>賣場基本資料</h2>
									</div>
									<div>
										<label>請輸入賣場名稱 : </label> <input type="text" name="storeName"
											class="btn btn-secondary m-2" value="${storeVO2.storeName}" />
									</div>
									<div>
										<label>請輸入賣場銀行代碼 :</label> <input type="text"
											class="btn btn-secondary m-2" name="storeDelBank"
											value="${storeVO2.storeDelBankCode}" />
									</div>
									<div>
										<label>請輸入賣場銀行帳號 :</label> <input type="text"
											class="btn btn-secondary m-2" name="storeBankAccount"
											value="${storeVO2.storeBankAccount}" />
									</div>
									<div>
										<label>請輸入賣場地址 :</label> <input type="text"
											class="btn btn-secondary m-2" name="storeAddress"
											value="${storeVO2.storeAddress}" />
									</div>
									<div>
										<div>
											<label>請輸入賣場電話</label><input type="text"
												class="btn btn-secondary m-2" name="phoneNumber"
												value="${storeVO2.phoneNumber}" />
										</div>
									</div>
									<div>
										<div>
											<label>請輸入稅務代號</label><input type="text"
												class="btn btn-secondary m-2" name="taxID"
												value="${storeVO2.taxID}" />
										</div>
									</div>
									<div>
										<input type="submit" class="btn btn-secondary m-2" value="修改" />
										<input type="hidden" name="action" value="update">
									</div>
								</div>
							</form>
						</div>
						<div class="tab-pane fade" id="myProduct" role="tabpanel"
							aria-labelledby="address-nav">
							<div>
								請輸入商品ID <input type="text" id="searchPID" name="productID"
									value="" /> 請輸入商品次分類ID <input type="text" id="searchPSID"
									name="productSecID" value="" /> 請輸入商品狀態: <select
									class="form-select mb-3" aria-label="Default select example"
									name="productStatus" id="searchPSTATUS">
									<option selected value="true">已上架</option>
									<option value="false">已下架</option>
								</select> <input type="hidden" name=storeID id="searchSID"
									value="${storeVO2.storeID}" />
								<button id="btnSearchAll">商品查詢</button>
							</div>
							<br />
							<div>
								<h2 class="col-sm-12">商品查詢結果</h2>
								<div id="searchRes"></div>
							</div>
						</div>
						<div class="tab-pane fade" id="orderQuery" role="tabpanel"
							aria-labelledby="address-nav">
							<div>
								請輸入訂單ID: <input type="text" name="orderID" value="orderID" />
								請輸入會員ID: <input type="text" name="memberID" value="memberID" />
								請輸入訂單日期: <input type="text" name="orderDate" value="orderDate" />
								請輸入訂單狀態: <input type="text" name="orderStatus"
									value="orderStatus" />
								<button>訂單查詢</button>
							</div>
							<br />
							<div>
								<h2 class="col-sm-12">訂單查詢結果</h2>
								<table class="table table-striped col-sm-12">
									<tbody>
										<tr>
											<td>訂單ID</td>
											<td>會員ID</td>
											<td>訂單日期</td>
											<td>訂單狀態</td>
											<td>最後總金額</td>
										</tr>
										<tr>
											<td>001</td>
											<td>005</td>
											<td>2021/11/5</td>
											<td>已完成</td>
											<td>50000</td>
										</tr>
										<tr>
											<td>002</td>
											<td>005</td>
											<td>2021/11/5</td>
											<td>已完成</td>
											<td>50000</td>
										</tr>
										<tr>
											<td>003</td>
											<td>005</td>
											<td>2021/11/5</td>
											<td>已完成</td>
											<td>50000</td>
										</tr>
										<tr>
											<td>004</td>
											<td>005</td>
											<td>2021/11/5</td>
											<td>已完成</td>
											<td>50000</td>
										</tr>
										<tr>
											<td>005</td>
											<td>005</td>
											<td>2021/11/5</td>
											<td>已完成</td>
											<td>50000</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="tab-pane fade" id="addProduct" role="tabpanel"
							aria-labelledby="account-nav">
							<h4>新增商品</h4>
							<div class="row">
								<form
									action="${pageContext.request.contextPath}/product/productServlet/insert"
									method="post" id="the_form" enctype="multipart/form-data">
									<div>
										<label>商品名稱：</label> <input type="text" id="p_name"
											class="form-control" name="productName" />
									</div>
									<div>
										商品次分類： <select class="form-select mb-3"
											aria-label="Default select example" name="productSec">
											<option selected>請選擇</option>
											<c:forEach var="productSecVO" items="${ProductSec}">
												<option value="${productSecVO.productSecID}">${productSecVO.productSecName}</option>
											</c:forEach>
										</select>
									</div>

									<div>
										<label>商品數量：</label> <input type="text" min="1" max="100"
											value="1" id="p_count" class="form-control"
											name="productStock" /> <span id="p_count_value"></span>
									</div>
									<div>
										<label>商品價格：</label> <input type="text" value="1" id="p_count"
											class="form-control" name="productPrice" /> <span
											id="p_count_value"></span>
									</div>
									<div>
										<label>商品圖片1:</label> <input type="file" id="p_file"
											class="btn btn-secondary m-2" name="upfile1" /> <br /> <label>商品圖片2：</label>
										<input type="file" id="p_file2" class="btn btn-secondary m-2"
											name="upfile2" /> <br /> <label>商品圖片3：</label> <input
											type="file" id="p_file3" class="btn btn-secondary m-2"
											name="upfile3" /> <br />
									</div>
									<div class="input-group">
										<span class="input-group-text">商品描述：</span>
										<textarea class="form-control" aria-label="With textarea"
											name="productDesc"></textarea>
									</div>
									<div>
										<label>出貨地</label> <input type="text" id="p_source"
											class="form-control" name="source" />
									</div>
									<div>
										商品狀態 <select class="form-select mb-3"
											aria-label="Default select example" name="productStatus">
											<option selected>請選擇</option>
											<option value="1">已上架</option>
											<option value="0">未上架</option>
										</select>
									</div>

									<input type="hidden" name="action" value="insert"> <input
										type="submit" value="送出新增">
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- My Account End -->

	<%@ include file="Footer.jsp"%>

	<!-- Back to Top -->
	<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/front-end/store/lib/easing/easing.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/front-end/store/lib/slick/slick.min.js"></script>

	<!-- Template Javascript -->
	<script
		src="${pageContext.request.contextPath}/front-end/store/js/main.js"></script>
</body>
</html>