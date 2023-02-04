<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.group6.tibame104.groupdiscount.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>
<%@ include file="/back-end/group/header.jsp"%>


			<!-- Table Start -->

			<!-- Recent Sales Start -->
			<div class="container-fluid pt-4 px-4">
				<!-- Content Header (Page header) -->
				<div class="content-header">
					<div class="container-fluid">
						<div class="row mb-2">
							<div class="col-sm-6">
								<h2 class="m-0 sym-dark-font">團購管理 / 折扣設定</h2>
							</div>
							<!-- /.col -->
							<div class="col-sm-6 flex-direction">
								<ol class="breadcrumb float-sm-right">
									<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Home</a></li>
									<li class="breadcrumb-item active">新增 / 修改折扣</li>
								</ol>
							</div>
							<!-- /.col -->
						</div>
						<!-- /.row -->
					</div>
					<!-- /.container-fluid -->
				</div>
				<!-- /.content-header -->
				<div class="sym-yellow-bk text-center rounded p-4">
					<div class="d-flex align-items-center justify-content-between mb-4">
						<a
							class="btn btn-sm card-header sym-darkpurple sym-yellow-font font-m btn_style"
							href="${pageContext.request.contextPath}/Groupdiscount/getAll">查詢所有折扣</a>
							<a
							class="btn btn-sm card-header sym-darkpurple sym-yellow-font font-m btn_style"
							href="${pageContext.request.contextPath}/back-end/groupdiscount/addGroupDiscount.jsp">新增折扣</a>
					</div>
					
					<div class="table-responsive">
					            <input type="text" class="form-control border-1" id="reserve_search" type="search" placeholder="輸入欲查詢的團購編號" onkeyup="searchFunction()">
						<br>
						<div class="card card-primary">
							<table
								class="table text-start align-middle table-bordered table-hover mb-0"
								id="reserver_detail">
								<thead>
									<tr class="text-dark">
										<th scope="col">折扣編號</th>
										<th scope="col">團購編號</th>
										<th scope="col">團購人數</th>
										<th scope="col">折扣數</th>
										<th scope="col">修改</th>
										<th scope="col">刪除</th>
									</tr>
								</thead>
								<tbody>
								
									<c:forEach var="list" items="${list}">

										<tr>
											<td>${list.countTableID}</td>
											<FORM method="post"
													action="${pageContext.request.contextPath}/Groupdiscount/update"
													style="margin-bottom: 0px;">
											<td><input type="text" name="groupBuyID" value="${list.groupBuyID}"></td>
											<td><input type="text" name="groupBuyProductOrderTotal" value="${list.groupBuyProductOrderTotal}"></td>
											<td><input type="text" name="groupBuyCount" value="${list.groupBuyCount}"></td>
											<td><input type="submit" class="btn sym-darkpurple sym-yellow-font btn_style" value="修改"> 
												<input type="hidden" name="countTableID"
														value="${list.countTableID}"> 
												</FORM>
											</td>
											<td>
												<FORM method="post"
													action="${pageContext.request.contextPath}/Groupdiscount/delete"
													style="margin-bottom: 0px;">
													<input type="submit" class="btn sym-darkpurple sym-yellow-font btn_style" value="刪除" > <input
														type="hidden" name="countTableID"
														value="${list.countTableID}"> 
													<input type="hidden" name="action" value="delete">
												</FORM>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- Recent Sales End -->
			<!-- Table End -->
			<!--content end-->

			<!--session start-->
			<div class="col-sm-12 col-md-7">
				<div class="dataTables_paginate paging_simple_numbers"
					id="example2_paginate"></div>
			</div>
			<!--session ends-->

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
		</div>

		<!-- Back to Top -->
		<a href="#"
			class="btn btn-lg sym-darkpurple sym-yellow-font btn-lg-square back-to-top btn_style"><i
			class="bi bi-arrow-up"></i></a>
	</div>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupdiscount/lib/chart/chart.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupdiscount/lib/easing/easing.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupdiscount/lib/waypoints/waypoints.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupdiscount/lib/owlcarousel/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupdiscount/lib/tempusdominus/js/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupdiscount/lib/tempusdominus/js/moment-timezone.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupdiscount/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

	<!-- Template Javascript -->
	<script
		src="${pageContext.request.contextPath}/back-end/groupdiscount/js/main.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupdiscount/js/admin.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupdiscount/js/search.js"></script>
		
		
</body>

</html>