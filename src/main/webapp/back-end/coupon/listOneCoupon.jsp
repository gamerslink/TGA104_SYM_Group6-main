<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.group6.tibame104.coupon.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<html>
<head>
<title>員工資料 - listOneCoupon.jsp</title>

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
	width: 1500px;
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

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>員工資料 - ListOneCoupon.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/front-end/coupon/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
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