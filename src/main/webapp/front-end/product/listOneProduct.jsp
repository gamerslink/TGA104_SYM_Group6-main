<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.group6.tibame104.product.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
//ProductVO productVO = (ProductVO) request.getAttribute("productVO"); 
//EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>員工資料 - listOneEmp.jsp</title>

<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
}

</style>
<script src="${pageContext.request.contextPath}/JQ/jquery-3.6.1.min.js"></script>
<script>
	$(function() {
		var id = $("#id").val();
		$("#btn_putOn")
				.click(
						function() {
							$
									.ajax({
										url : "${pageContext.request.contextPath}/product/productPutOn?productID="
												+ id, // 資料請求的網址
										type : "POST", // GET | POST | PUT | DELETE | PATCH
										// data: 物件資料,             // 將物件資料(不用雙引號) 傳送到指定的 url
										dataType : "json", // 預期會接收到回傳資料的格式： json | xml | html
										contentType : 'application/json; charset=UTF-8',
										success : function(data) {
											// request 成功取得回應後執行
											location.reload();
										},
										error : function() {
											alert("出現錯誤");
										}
									});
						});
		$("#btn_putOff")
				.click(
						function() {
							$
									.ajax({
										url : "${pageContext.request.contextPath}/product/productPutOff?productID="
												+ id, // 資料請求的網址
										type : "POST", // GET | POST | PUT | DELETE | PATCH
										// data: 物件資料,             // 將物件資料(不用雙引號) 傳送到指定的 url
										dataType : "json", // 預期會接收到回傳資料的格式： json | xml | html
										contentType : 'application/json; charset=UTF-8',
										success : function(data) {
											// request 成功取得回應後執行
											location.reload();
										},
										error : function() {
											alert("出現錯誤");
										}
									});
						});
		$("#btn_putOff")
		.click(
				function() {
					$
							.ajax({
								url : "${pageContext.request.contextPath}/product/productPutOff?productID="
										+ id, // 資料請求的網址
								type : "POST", // GET | POST | PUT | DELETE | PATCH
								// data: 物件資料,             // 將物件資料(不用雙引號) 傳送到指定的 url
								dataType : "json", // 預期會接收到回傳資料的格式： json | xml | html
								contentType : 'application/json; charset=UTF-8',
								success : function(data) {
									// request 成功取得回應後執行
									location.reload();
								},
								error : function() {
									alert("出現錯誤");
								}
							});
				});
		$("#btn_update").click(function(){
			location.href="${pageContext.request.contextPath}/product/productGetOne?productID="
				+ id;
		});
	});
</script>
</head>
<body bgcolor='white'>

	<h4>此頁暫練習採用 Script 的寫法取值:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>顯示一個產品資料 - ListOneProdict.jsp</h3>
				<h4>
					<a
						href="${pageContext.request.contextPath}/front-end/product/addProduct.jsp"><img
						src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<th>商品ID</th>
			<th>賣場ID</th>
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
		<tr>
			<td>${productVO.productID}</td>
			<td>${productVO.storeID}</td>
			<td>${ProductSec[productVO.productSecID-1].productSecName}</td>
			<td>${productVO.productName}</td>
			<td><img
				src="${pageContext.request.contextPath}/product/picServlet?productID=${productVO.productID}"
				alt="沒有圖片" width="100" height="100"></td>
			<td><img
				src="${pageContext.request.contextPath}/product/picServlet2?productID=${productVO.productID}"
				alt="沒有圖片" width="100" height="100"></td>
			<td><img
				src="${pageContext.request.contextPath}/product/picServlet3?productID=${productVO.productID}"
				alt="沒有圖片" width="100" height="100"></td>
			<td>${productVO.productStock}</td>
			<th>${productVO.productPrice}</th>
			<td>${productVO.productDesc}</td>
			<td>${productVO.source}</td>
			<th><c:if test="${productVO.productStatus==true}">已上架</c:if> <c:if
					test="${productVO.productStatus==false}">未上架</c:if></th>
			<th><input type="button" id="btn_putOn" value="上架"> <input
				type="button" id="btn_putOff" value="下架"><input
				type="button" id="btn_update" value="修改"></th>
			<input type="hidden" id="id" value="${productVO.productID}" />
		</tr>
	</table>

	<h2>-------------------------------------------------------</h2>
	<h2>商品大分類 使用 load-on-startup 丟進pageContext</h2>
	<table>
		<c:forEach var="productMainVO" items="${ProductMain}">
			<tr>
				<td>${productMainVO.productMainID}</td>
				<td>${productMainVO.productMainName}</td>
			</tr>
		</c:forEach>
	</table>
	<h2>-------------------------------------------------------</h2>
	<h2>商品中分類 使用 load-on-startup 丟進pageContext</h2>
	<table>
		<c:forEach var="productSecVO" items="${ProductSec}">
			<tr>
				<td>${productSecVO.productSecID}</td>
				<td>${productSecVO.productSecName}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>