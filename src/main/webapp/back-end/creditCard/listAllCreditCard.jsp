<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.group6.tibame104.creditCard.model.*"%>
<!DOCTYPE html>
<%
CreditCardService cardSvc = new CreditCardService();
    List<CreditCardVO> list = cardSvc.getAll(28);
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有信用卡資料 - listAllCard.jsp</title>

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

<!-- <h4>此頁練習採用 EL 的寫法取值:</h4> -->
<!-- <table id="table-1"> -->
<!-- 	<tr><td> -->
<!-- 		 <h3>所有信用卡資料 - listAllCard.jsp</h3> -->
<!-- 		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4> -->
<!-- 	</td></tr> -->
<!-- </table> -->

<!-- <table> -->
<!-- 	<tr> -->
<!-- 		<th>信用卡編號</th> -->
<!-- 		<th>會員編號</th> -->
<!-- 		<th>信用卡卡號</th> -->
<!-- 		<th>安全碼</th> -->
<!-- 		<th>到期日</th> -->
		
<!-- 	</tr> -->
<%-- <%-- 	<%@ include file="page1.file" %>  --%> --%>
<%-- <%-- 	<c:forEach var="cardVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>"> --%> --%>
		
<!-- 		<tr> -->
<%-- 			<td>${cardVO.creditCardId}</td> --%>
<%-- 			<td>${cardVO.memberId}</td> --%>
<%-- 			<td>${cardVO.creditCardNumber}</td> --%>
<%-- 			<td>${cardVO.securityCode}</td> --%>
<%-- 			<td>${cardVO.exDate}</td> --%>
			
<!-- 			<td> -->
<%-- 			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member/MemberServlet" style="margin-bottom: 0px;"> --%>
<!-- 			     <input type="submit" value="修改"> -->
<%-- 			     <input type="hidden" name="memberId"  value="${memVO.memberId}"> --%>
<!-- 			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM> -->
<!-- 			</td> -->
<!-- 			<td> -->
<%-- 			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member/MemberServlet" style="margin-bottom: 0px;"> --%>
<!-- 			     <input type="submit" value="刪除"> -->
<%-- 			     <input type="hidden" name="memberId"  value="${memVO.memberId}"> --%>
<!-- 			     <input type="hidden" name="action" value="delete"></FORM> -->
<!-- 			</td> -->
<!-- 		</tr> -->
<%-- 	</c:forEach> --%>
</table>
<%-- <%@ include file="page2.file" %> --%>

</body>
</html>