<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/back-end/group/header.jsp"%>
			<!-- Navbar End -->

			<!-- Content starts-->
			<div class="wrapper">
				<header id="header"></header>
				<!-- Main Sidebar Container 主側邊欄-->
				<aside id="sidebar"
					class="main-sidebar sidebar-dark-primary elevation-4"></aside>
				<!-- Content Wrapper. Contains page content 主頁面欄位-->
				<div class="content-wrapper">
					<!-- Content Header (Page header) -->
					<div class="content-header">
						<div class="container-fluid">
							<div class="row mb-2">
								<div class="col-sm-6">
									<h1 class="m-0 sym-dark-font">新增公告</h1>
								</div>
								<!-- /.col -->
								<div class="col-sm-6 flex-direction">
									<ol class="breadcrumb float-sm-right">
										<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Home</a></li>
										<li class="breadcrumb-item active">新增公告</li>
									</ol>
								</div>
								<!-- /.col -->
							</div>
							<!-- /.row -->
						</div>
						<!-- /.container-fluid -->
					</div>
					<!-- /.content-header -->

					<!-- Main content -->
					<div class="">
						<div class="container-fluid">
							<div class="row">
								<!-- left column -->
								<div class="col-md-12">
									<!-- general form elements -->
									<div class="card card-primary">

										<div class="col-md-12">
											<div class="card card-primary">
												<div class="card-header sym-darkpurple">
													<h3 class="card-title sym-yellow-font">新增公告</h3>
												</div>
												<!-- /.card-header -->
												<div class="card-body">
												<form METHOD="post"
																ACTION="${pageContext.request.contextPath}/Announcement/insert"
																style="margin-bottom: 0px">
													<table id="memberTable"
														class="table table-bordered table-hover">
														<thead>
															<tr>
																<th>編號</th>
																<th>管理員編號</th>
																<th>標題</th>
																<th>描述</th>
																<th>上架日期</th>
																<th>下架日期</th>
																<th>更新日期</th>
																<th>上架狀態</th>
																<th>首頁/賣場</th>
																<th></th>
															</tr>
														</thead>
														<tbody id="announList">
															<!-- javascript render memberlist -->
															
														<tr>
															<td style="width: 30px">${announcementVO.announcementSerialID}</td>
															<td><input type="text" name="administratorID"
																value="${announcementVO.administratorID}"
																style="width: 30px"></td>
															<td><input type="text" name="announcementTitle"
																value="${announcementVO.announcementTitle}"
																style="width: 100px"></td>
															<td><input type="text" name="announcementContent"
																value="${announcementVO.announcementContent}"
																style="width: 120px"></td>
															<td><input id="f_date1" type="text" name="startDate" autocomplete="off"
																value="${announcementVO.startDate}" style="width: 100px">
															</td>
															<td><input id="f_date2" type="text" name="endDate" autocomplete="off"
																value="${announcementVO.endDate}" style="width: 100px">
															</td>
															<td style="width: 100px">${announcementVO.updateTime}</td>
															<td><input type="radio" name="offLoadStatus" value="true">上架
																<input type="radio" name="offLoadStatus" value="false">下架</td>
															
															<td><input type="radio" name="showStatus" value="true">首頁
																<input type="radio" name="showStatus" value="false">賣場</td>
															<td>
																<button
																	type="submit"
																	class="btn sym-darkpurple sym-yellow-font btn_style"
																	id="addProduct">新增
																</button>
															</td>
														</tr>
															

														</tbody>
													</table>
													</form>
												</div>
												<!-- /.card-body -->
											</div>
										</div>
										<!-- /.card-body -->
<!-- 										<div class="card-footer mb-2rem"> -->
<!-- 											<button class="btn sym-darkpurple sym-yellow-font btn_style" -->
<!-- 												id="addAnnouncement">重置</button> -->
<!-- 											<button class="btn sym-purple sym-yellow-font"> -->
<!--                                                 儲存並下架 -->
<!--                                             </button> -->
<!--                                             <button class="btn sym-purple sym-yellow-font"> -->
<!--                                                 儲存並上架 -->
<!--                                             </button>  -->
<!-- 											<button -->
<!--                                                 class="btn btn-default float-right" -->
<!--                                             > -->
<!--                                                 取消 -->
<!--                                             </button> -->
										</div>
										<button
																	type="submit"
																	class="btn sym-darkpurple sym-yellow-font btn_style"
																	onclick="window.location.href='${pageContext.request.contextPath}/Announcement/getAll'"
																	id="addProduct">回上一頁
																</button>
									</div>
									<!-- /.card -->
								</div>
							</div>
							<!-- /.row -->
						</div>
						<!-- /.container-fluid -->
					</div>
					<!-- /.content -->
				</div>
				<!-- ============ Footer段落 ============ -->
				<footer id="footer" class="main-footer"></footer>
				<!-- Control Sidebar -->
				<aside class="control-sidebar control-sidebar-dark">
					<!-- Control sidebar content goes here -->
				</aside>
				<!-- /.control-sidebar -->
				<!-- ============ Footer段落 ============ -->
				<!-- /.content-wrapper -->
			
			<!-- Content ends-->

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
		<!-- Content End -->

		<!-- Back to Top -->
		<div>
		<a href="#"
			class="btn btn-lg sym-darkpurple sym-yellow-font btn-lg-square back-to-top btn_style"><i
			class="bi bi-arrow-up"></i></a>
	</div>

	<!-- JavaScript Libraries -->
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/front-end/order/datetimepicker/jquery.datetimepicker.css" />
	<script
		src="${pageContext.request.contextPath}/front-end/order/datetimepicker/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath}/front-end/order/datetimepicker/jquery.datetimepicker.full.js"></script>
	<script>
		$.datetimepicker.setLocale('zh');
		$('#f_date1').datetimepicker({
			theme : '', //theme: 'dark',
			timepicker : false, //timepicker:true,
			step : 1, //step: 60 (這是timepicker的預設間隔60分鐘)
			format : 'Y-m-d', //format:'Y-m-d H:i:s',
			value : '', // value:   new Date(),
		//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
		//startDate:	            '2017/07/10',  // 起始日
		//minDate:               '-1970-01-01', // 去除今日(不含)之前
		//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
		});
		$('#f_date2').datetimepicker({
			theme : '', //theme: 'dark',
			timepicker : false, //timepicker:true,
			step : 1, //step: 60 (這是timepicker的預設間隔60分鐘)
			format : 'Y-m-d', //format:'Y-m-d H:i:s',
			value : '', // value:   new Date(),
		//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
		//startDate:	            '2017/07/10',  // 起始日
		//minDate:               '-1970-01-01', // 去除今日(不含)之前
		//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
		});
	</script>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/group/lib/chart/chart.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/group/lib/easing/easing.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/group/lib/waypoints/waypoints.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/group/lib/owlcarousel/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/group/lib/tempusdominus/js/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/group/lib/tempusdominus/js/moment-timezone.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/group/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

	<!-- Template Javascript -->
	<script
		src="${pageContext.request.contextPath}/back-end/group/js/main.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/group/js/admin.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/announcement/js/search.js"></script>
</body>
</html>