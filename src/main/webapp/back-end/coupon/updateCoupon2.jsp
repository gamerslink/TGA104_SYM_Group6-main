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
	})
</script>
</head>
<body bgcolor='white'>

	<div style="text-align:center;">
		<FORM METHOD="post"
			ACTION="${pageContext.request.contextPath}/front-end/coupon/Coupon.do">
			<div>
				<h1>修改優惠券<h1>
			</div>
			<div>
				<label>優惠券ID : </label> <input type="text" name="couponID"
					class="btn btn-secondary m-2" value="${couponVO.couponID}" readonly/>
			</div>
			<div>
				<label>請輸入優惠券名稱 : </label> <input type="text" name="couponName"
					class="btn btn-secondary m-2" value="${couponVO.couponName}" />
			</div>

			<div>
				<label>開始日期：</label> <input type="text"
					value="${couponVO.startDate}" id="p_count" class="btn btn-secondary m-2"
					name="startDate" /> <span id="p_count_value"></span>
			</div>
			<div>
				<label>結束日期：</label> <input type="text"
					value="${couponVO.endDate}" id="p_count" class="btn btn-secondary m-2"
					name="endDate" /> <span id="p_count_value"></span>
			</div>
	        <div>
				<label>打折數：</label> <input type="text"
					value="${couponVO.discount}" id="p_count" class="btn btn-secondary m-2"
					name="discount" /> <span id="p_count_value"></span>
			</div>
			<div>
				<label>滿額折抵金額：</label> <input type="text"
					value="${couponVO.discountAmount}" id="p_count" class="btn btn-secondary m-2"
					name="discountAmount" /> <span id="p_count_value"></span>
			</div>
			<div>
				<label>滿額折抵條件：</label> <input type="text"
					value="${couponVO.fullCondition}" id="p_count" class="btn btn-secondary m-2"
					name="fullCondition" /> <span id="p_count_value"></span>
			</div>
			<div>
				<label>搶券期起：</label> <input type="text"
					value="${couponVO.couponTimeBegins}" id="p_count" class="btn btn-secondary m-2"
					name="couponTimeBegins" /> <span id="p_count_value"></span>
			</div>
			<div>
				<label>搶券期止：</label> <input type="text"
					value="${couponVO.couponTimeEnd}" id="p_count" class="btn btn-secondary m-2"
					name="couponTimeEnd" /> <span id="p_count_value"></span>
			</div>
			<div>
				<label>已兌換數量：</label> <input type="text"
					value="${couponVO.exchangeAmount}" id="p_count" class="btn btn-secondary m-2"
					name="exchangeAmount" /> <span id="p_count_value"></span>
			</div>
			<div>
				<label>優惠券描述：</label> <input type="text"
					value="${couponVO.couponDescription}" id="p_count" class="btn btn-secondary m-2"
					name="couponDescription" /> <span id="p_count_value"></span>
			</div>

			<input type="hidden" name="action" value="update"> <input
				type="submit" value="送出修改">
		</FORM>
	</div>


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