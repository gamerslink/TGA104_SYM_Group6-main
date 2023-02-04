<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.group6.tibame104.grouporder.model.*"%>

<%@ include file="/back-end/group/header.jsp"%>

			<div class="container-fluid pt-4 px-4">
				<!-- Content Header (Page header) -->
				<div class="content-header">
					<div class="container-fluid">
						<div class="row mb-2">
							<div class="col-sm-6">
								<h2 class="m-0 sym-dark-font">團購管理 / 團購訂單</h2>
							</div>
							<div class="mes-rut">
								<div class="dva rut-tit1">公告</div>
								<div class="dva rut-line"></div>
								<div class="dva rut-tit2 not-tit1">
									<div class="inner-container rut-tit3" v-html="noticeContent"></div>
								</div>
							</div>
							<!-- /.col -->
							<div class="col-sm-6 flex-direction">
								<ol class="breadcrumb float-sm-right">
									<li class="breadcrumb-item"><a href="#">Home</a></li>
									<li class="breadcrumb-item active">團購訂單</li>
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
					</div>
					<div class="table-responsive">
						<div class="card card-primary">
							
							<table>
								<tr>
									<th>團購訂單編號</th>
									<th>團購編號</th>
									<th>會員編號</th>
									<th>團購商品編號</th>
									<th>團購數量</th>
									<th>總金額</th>
									<th>訂單時間</th>
									<th>付款方式</th>
									<th>付款狀態</th>
									<th>購物金</th>
									<th>連絡電話</th>
									<th>運送地點</th>
								</tr>
								<tr>
									<td>${grouporderVO.groupBuyOrderID}</td>
									<td>${grouporderVO.groupBuyID}</td>
									<td>${grouporderVO.memberID}</td>
									<td>${grouporderVO.groupBuyProductID}</td>
									<td>${grouporderVO.groupBuyQuantity}</td>
									<td>${grouporderVO.groupBuyTotal}</td>
									<td>${grouporderVO.orderTime}</td>
									<td>${grouporderVO.paymentTerm}</td>
									<td>${grouporderVO.paymentState}</td>
									<td>${grouporderVO.giftVoucher}</td>
									<td>${grouporderVO.contactNumber}</td>
									<td>${grouporderVO.shippingLocation}</td>
								</tr>
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
		src="${pageContext.request.contextPath}/back-end/grouporder/lib/chart/chart.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/grouporder/lib/easing/easing.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/grouporder/lib/waypoints/waypoints.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/grouporder/lib/owlcarousel/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/grouporder/lib/tempusdominus/js/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/grouporder/lib/tempusdominus/js/moment-timezone.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/grouporder/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

	<!-- Template Javascript -->
	<script
		src="${pageContext.request.contextPath}/back-end/grouporder/js/main.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/grouporder/js/admin.js"></script>

</body>

</html>