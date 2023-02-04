<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.group6.tibame104.member.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
MemberVO memVO = (MemberVO) request.getAttribute("memVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>員工資料 - listOneMember.jsp</title>

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
	<tr><td>
		 <h3>員工資料 - ListOneMember.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>會員編號</th>
		<th>會員帳號</th>
		<th>會員密碼</th>
		<th>會員姓名</th>
		<th>電話</th>
		<th>電子信箱</th>
		<th>性別</th>
		<th>生日</th>
		<th>身分證號</th>
		<th>地址</th>
	</tr>
	<tr>
		
		<td><%=memVO.getMemberID()%></td>
		<td><%=memVO.getUserAccount()%></td>
		<td><%=memVO.getUserPassword()%></td>
		<td><%=memVO.getUserName()%></td>
		<td><%=memVO.getPhone()%></td>
		<td><%=memVO.getMail()%></td>
		<td><%=memVO.getGender()%></td>
		<td><%=memVO.getBirthday()%></td>
		<td><%=memVO.getIdNumber()%></td>
		<td><%=memVO.getAddress()%></td>
	
	</tr>
</table>

</body>
</html>