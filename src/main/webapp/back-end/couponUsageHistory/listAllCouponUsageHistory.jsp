<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.group6.tibame104.couponUsageHistory.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
CouponUsageHistoryService couponUsageHistorySvc = new CouponUsageHistoryService();
    List<CouponUsageHistoryVO> list = couponUsageHistorySvc.getAll2();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>優惠券紀錄資料</title>
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

<style>
  table#table-1 {
	background-color: #FFA9A9;
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
	width: 800px;
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

</head>
<body bgcolor='white'>


<table id="table-1">
	<tr><td>
		 <h3>優惠券紀錄資料</h3>
	</td></tr>
</table>

<table>
	<tr>
		<th>會員ID</th>
		<th>優惠券ID</th>
		<th>使用紀錄</th>
		<th>使用日期</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="couponUsageHistoryVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${couponUsageHistoryVO.memberID}</td>
			<td>${couponUsageHistoryVO.couponID}</td>
			<td>${couponUsageHistoryVO.usageRecord}</td>
			<td>${couponUsageHistoryVO.useDate}</td>
			
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>