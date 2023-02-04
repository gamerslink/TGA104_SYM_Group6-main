<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.group6.tibame104.groupproduct.model.*"%>

<%@ include file="/back-end/group/header.jsp"%>

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
									<h2 class="m-0 sym-dark-font">團購設定 - 新增團購商品</h2>
								</div>
								<!-- /.col -->
								<div class="col-sm-6 flex-direction">
									<ol class="breadcrumb float-sm-right">
										<li class="breadcrumb-item"><a href="#">Home</a></li>
										<li class="breadcrumb-item active">團購設定</li>
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
										<div class="card-header sym-darkpurple">
											<h3 class="card-title sym-yellow-font">團購設定 - 新增團購商品</h3>
										</div>
										<!-- /.card-header -->
										<!-- form start -->
										<FORM METHOD="post"
											ACTION="${pageContext.request.contextPath}/back-end/groupproduct/insert"
											name="form1" enctype="multipart/form-data">
											<div class="card-body">
												<div class="row">
													<div class="col-sm-4">
														<div class="form-group">
															<label for="proPrice" class="sym-dark-font">
																<h5>商品定價</h5>
															</label> <input type="TEXT" class="form-control"
																name="groupBuyProductPrice" size="45"
																value="${(groupproductVO == null) ? '0' : groupproductVO.groupBuyProductPrice}" />
														</div>
													</div>
													<div class="row">
														<div class="col-sm-6">
															<br />
															<div class="form-group">
																<label for="proPicture" class="sym-dark-font">
																	<h5>團購圖片</h5>
																</label>
																<div class="bg-light color-palette"
																	style="border: 1px dashed; height: 180px; text-align: center; line-height: 180px;"
																	id="picPreview">預覽圖</div>
																<br>
																<div class="input-group">
																	<div class="custom-file">
																		<input type="file" class="custom-file-input"
																			name="groupBuyProductPicture" id="p_file"
																			accept="image/*" /> <br> <label
																			class="custom-file-label" for="proPicture"></label>
																	</div>
																	<div class="input-group-append sym-darkpurple"></div>
																</div>
															</div>
									</div>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-sm-12">
									<div class="form-floating">
										<textarea class="form-control" placeholder="請輸入商品描述"
											id="floatingTextarea" name="groupBuyProductDescrip"
											value="${(groupproductVO == null) ? '請輸入商品描述' : groupproductVO.groupBuyProductDescrip}"
											style="height: 150px;"></textarea>
										<label for="floatingTextarea">商品描述</label>
									</div>
								</div>
							</div>
						</div>
						<!-- /.card-body -->
						<div class="card-footer">
							<div class="row">
								<div class="col-sm-9"></div>
								<div class="col-sm-3">
									<button type="submit"
										class="btn sym-darkpurple sym-yellow-font btn_style"
										id="addProduct">送出新增</button>
						</form>
					</div>
				</div>
			</div>
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
	</div>
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
	<a href="#"
		class="btn btn-lg sym-darkpurple sym-yellow-font btn-lg-square back-to-top btn_style"><i
		class="bi bi-arrow-up"></i></a>
	</div>
	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupproduct/lib/chart/chart.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupproduct/lib/easing/easing.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupproduct/lib/waypoints/waypoints.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupproduct/lib/owlcarousel/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupproduct/lib/tempusdominus/js/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupproduct/lib/tempusdominus/js/moment-timezone.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupproduct/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>
	<!-- Template Javascript -->
	<script
		src="${pageContext.request.contextPath}/back-end/groupproduct/js/main.js"></script>
	<script>
		window
				.addEventListener(
						"load",
						function(e) {
							var preview_el = document
									.getElementById("picPreview");
							var p_file_el = document.getElementById("p_file");

							var preview_img = function(file) {
								var reader = new FileReader();
								reader.readAsDataURL(file);
								reader
										.addEventListener(
												"load",
												function() {

													let img_str = '<img src="' + reader.result + '" class="picPreview_img" style="height:150px">';
													// console.log(reader.result);
													preview_el.innerHTML = img_str;
												});
							};
							p_file_el
									.addEventListener(
											"change",
											function(e) {

												//console.log(this.files);
												if (this.files.length > 0) {
													preview_img(this.files[0]);
												} else {
													preview_el.innerHTML = '<span class="text">預覽圖</span></div>';
												}
												;
											});

						});
	</script>
</body>

</html>