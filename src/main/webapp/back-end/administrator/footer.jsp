<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
	<!-- Footer Start -->
	<div class="container-fluid pt-4 px-4">
		<div class="bg-light rounded-top p-4">
			<div class="row">
				<div class="col-12 col-sm-6 text-center text-sm-start">
					&copy; <a href="#">Tibame TGA104 第六組 SYM</a>, All Right Reserved.
				</div>
				<div class="col-12 col-sm-6 text-center text-sm-end">
					<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
					Designed By <a href="https://htmlcodex.com">HTML Codex</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer End -->
</body>
</html>