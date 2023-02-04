<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.group6.tibame104.shoppingGoldRecord.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
ShoppingGoldRecordVO shoppingGoldRecordVO = (ShoppingGoldRecordVO) request.getAttribute("shoppingGoldRecordVO"); //EmpServlet.java(Concroller), 存入req的couponVO物件
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

</head>
<body bgcolor='white'>

	<h4>此頁暫練習採用 Script 的寫法取值:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>員工資料 - ListOneEmp.jsp</h3>
				<h4>
					<a
						href="<%=request.getContextPath()%>/front-end/shoppingGoldRecord/select_page.jsp"><img
						src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>購物金歷程</th>
			<th>會員ID</th>
			<th>日期</th>
			<th>購物金異動金額</th>
			<th>購物金使用/獲得</th>
		</tr>

	<c:forEach var="shoppingGoldRecordVO" items="${list}" >
		
		<tr>
			<td>${shoppingGoldRecordVO.shoppingGoldRecordID}</td>
			<td>${shoppingGoldRecordVO.memberID}</td>
			<td>${shoppingGoldRecordVO.useDate}</td>
			<td>${shoppingGoldRecordVO.obtainShoppingCoin}</td>
			<td>${shoppingGoldRecordVO.plusOrMinus}</td>
		</tr>
	</c:forEach>
</table>


</body>
</html>