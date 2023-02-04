<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.group6.tibame104.product.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>


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
<script>
	$(function() {
		var id = $("#id").val();
		$("#btn_putOn")
				.click(
						function() {
							$
									.ajax({
										url : "${pageContext.request.contextPath}/product/productPutOn/on?productID="
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
										url : "${pageContext.request.contextPath}/product/productPutOff/off?productID="
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
	})
</script>
</head>
<body bgcolor='white'>
<%@ include file="/front-end/store/Header.jsp"%>
	
	
	<div style="text-align:center;">
		<FORM METHOD="post"
			ACTION="${pageContext.request.contextPath}/product/productServlet/update"
			enctype="multipart/form-data">
			<div>
				<h1>修改商品資料<h1>
			</div>
			<div>
				<label>商品ID : </label> <input type="text" name="productID"
					class="btn btn-secondary m-2" value="${productVO.productID}" disabled="disabled" />
					<input type="hidden" name="productID2" value="${productVO.productID}" />
			</div>
			<div>
				<label>商品次分類 : </label> <select class="form-select mb-3"
					aria-label="Default select example" name="productSec"
					id="productSec">
					<option selected value="${productVO.productSecID}">${ProductSec[productVO.productSecID-1].productSecName}</option>
					<c:forEach var="productSecVO" items="${ProductSec}">
						<option value="${productSecVO.productSecID}">${productSecVO.productSecName}</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<label>請輸入商品名稱 : </label> <input type="text" name="productName"
					class="btn btn-secondary m-2" value="${productVO.productName}" />
			</div>

			<div>
				<label>商品數量：</label> <input type="text"
					value="${productVO.productStock}" id="p_count" class="btn btn-secondary m-2"
					name="productStock" /> <span id="p_count_value"></span>
			</div>
			<div>
				<label>商品價格：</label> <input type="text"
					value="${productVO.productPrice}" id="p_count" class="btn btn-secondary m-2"
					name="productPrice" /> <span id="p_count_value"></span>
			</div>
			<div>
				<label>商品圖片1:</label> <input type="file" id="p_file"
					class="btn btn-secondary m-2" name="upfile1" /> <br /> <label>商品圖片2：</label>
				<input type="file" id="p_file2" class="btn btn-secondary m-2"
					name="upfile2" /> <br /> <label>商品圖片3：</label> <input type="file"
					id="p_file3" class="btn btn-secondary m-2" name="upfile3" /> <br />
			</div>
			<div>
				<label>商品描述：</label>
				<textarea class="btn btn-secondary m-2" aria-label="With textarea"
					name="productDesc" height="200">${productVO.productDesc}</textarea>
			</div>
			<div>
				<label>出貨地</label> <input type="text" id="p_source"
					class="btn btn-secondary m-2" name="source" value="${productVO.source}" />
			</div>
			<div>
				<label>商品狀態 :</label>
				<c:if test="${productVO.productStatus==true}">已上架</c:if>
				<c:if test="${productVO.productStatus==false}">未上架</c:if>
				<input type="button" id="btn_putOn" value="上架" /> <input
					type="button" id="btn_putOff" value="下架" /> <input type="hidden"
					id="id" value="${productVO.productID}" />
			</div>
			<input type="hidden" name="action" value="update"> <input
				type="submit" value="送出修改">
		</FORM>
	</div>
<%@ include file="/front-end/store/Footer.jsp"%>

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