<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script src="${pageContext.request.contextPath}/JQ/jquery-3.6.1.min.js"></script>

	<img src="${pageContext.request.contextPath}/images/default.jpg"
		alt="Default image">
	<img src="${requestScope.imagePath}" alt="New image">


</body>
</html>