<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.group6.tibame104.coupon.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<html>
<head>
<!-- Favicon -->
<link
	href="${pageContext.request.contextPath}/front-end/member/img/logoSYM.jpg"
	rel="icon" />

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
	href="${pageContext.request.contextPath}/front-end/member/lib/slick/slick.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/lib/slick/slick-theme.css"
	rel="stylesheet" />

<!-- Template Stylesheet -->
<link
	href="${pageContext.request.contextPath}/front-end/member/css/style.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/css/woody.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/css/coupon.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/css/table.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/css/signupDay.css"
	rel="stylesheet" />
<script src="https://kit.fontawesome.com/bc79e44e11.js"
	crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/JQ/jquery-3.6.1.min.js"></script>


</head>
<body bgcolor='white'>
<h2>優惠券查詢</h2>



<table class="table-outbox">
	<tr>
		<th>優惠券ID</th>
		<th>優惠券名稱</th>
		<th>有效期起</th>
		<th>有效期止</th>
		<th>優惠折數</th>
		<th>折抵金額</th>
		<th>折抵條件金額</th>
		<th>搶券時間起</th>
		<th>搶券時間止</th>
		<th>已兌換數量</th>
		<th>優惠券描述</th>
	</tr>
	<tr>
		<td>${couponVO.couponID}</td>
		<td>${couponVO.couponName}</td>
		<td>${couponVO.startDate}</td>
		<td>${couponVO.endDate}</td>
		<td>${couponVO.discount}</td>
		<td>${couponVO.discountAmount}</td>
		<td>${couponVO.fullCondition}</td>
		<td>${couponVO.couponTimeBegins}</td>
		<td>${couponVO.couponTimeEnd}</td>
		<td>${couponVO.exchangeAmount}</td>
		<td>${couponVO.couponDescription}</td>
	</tr>
</table>

</body>
</html>