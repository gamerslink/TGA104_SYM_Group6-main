<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.group6.tibame104.coupon.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    CouponService couponSvc = new CouponService();
    List<CouponVO> list = couponSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有優惠券資料 - listAllCoupon.jsp</title>

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

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>所有優惠券資料 - listAllEmp.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/front-end/coupon/select_page.jsp"><img src="images/tomcat.png" width="100" height="32" border="0">回首頁</a></h4>
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
		<th>狀態</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="couponVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
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
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/coupon/Coupon.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="couponID"  value="${couponVO.couponID}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			
		</tr>
		
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>