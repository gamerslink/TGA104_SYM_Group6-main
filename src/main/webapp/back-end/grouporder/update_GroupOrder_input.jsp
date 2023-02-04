<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.group6.tibame104.grouporder.model.*"%>

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
									<h2 class="m-0 sym-dark-font">團購設定 - 編輯團購</h2>
								</div>
								<!-- /.col -->
								<div class="col-sm-6 flex-direction">
									<ol class="breadcrumb float-sm-right">
										<li class="breadcrumb-item"><a href="#">Home</a></li>
										<li class="breadcrumb-item active">編輯團購</li>
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
											<h3 class="card-title sym-yellow-font">團購設定 - 編輯團購</h3>
										</div>
										<!-- /.card-header -->
										<%-- 錯誤表列 --%>
										<c:if test="${not empty errorMsgs}">
											<font style="color: red">請修正以下錯誤:</font>
											<ul>
												<c:forEach var="message" items="${errorMsgs}">
													<li style="color: red">${message}</li>
												</c:forEach>
											</ul>
										</c:if>
										<!-- form start -->
										<form METHOD="post" ACTION="${pageContext.request.contextPath}/back-end/grouporder/update" name="form1">
											<div class="card-body">
												<div class="form-group">
													<div class="row">
														<div class="col-sm-4 mg-bottom-2">
															<label class="sym-dark-font sym-dark-font font-m"></label>
															<h5>團購訂單編號</h5>
															</label>
															<td>${grouporderVO.groupBuyOrderID}</td>
														</div>
														<div class="row" style="padding-bottom: 20px;">
															<div class="col-sm-4">
																<div class="form-group">
																	<label class="sym-dark-font">
																		<h5>訂單日期</h5>
																	</label> <input type="text" class="form-control"
																		name="orderTime" id="f_date1" placeholder="訂單日期"
																		style="margin-bottom: 30px" readonly unselectable="on" />
																</div>
															</div>
															<div class="row">
																<div class="col-sm-4">
																	<div class="form-group">
																		<label for="memberID" class="sym-dark-font">
																			<h5>會員編號</h5>
																		</label> <input type="text" class="form-control"
																			name="memberID" id="memberID" placeholder="會員編號"
																			value="${grouporderVO.memberID}" /> <br>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col-sm-4">
																	<label for="groupBuyID" class="sym-dark-font">
																		<h5>團購編號</h5>
																	</label> <input type="text" class="form-control mb-2rem"
																		id="groupBuyID" name="groupBuyID" placeholder="團購編號"
																		value="${grouporderVO.groupBuyID}" />
																</div>
																<div class="col-sm-4">
																	<label for="groupBuyProductID" class="sym-dark-font">
																		<h5>團購商品ID</h5>
																	</label> <input type="text" class="form-control mb-2rem"
																		id="groupBuyProductID" name="groupBuyProductID"
																		placeholder="團購商品ID"
																		value="${grouporderVO.groupBuyProductID}" />
																</div>
															</div>
															<div class="row">
																<div class="col-sm-4">
																	<div class="form-group">
																		<label for="groupBuyQuantity" class="sym-dark-font">
																			<h5>團購數量</h5>
																		</label> <input type="text" class="form-control"
																			id="groupBuyQuantity" name="groupBuyQuantity"
																			placeholder="請輸入團購數量"
																			value="${grouporderVO.groupBuyQuantity}" />
																	</div>
																</div>
																<div class="col-sm-4">
																	<div class="form-group">
																		<label for="groupBuyTotal" class="sym-dark-font">
																			<h5>總金額</h5>
																		</label> <input type="text" class="form-control"
																			id="groupBuyTotal" name="groupBuyTotal"
																			placeholder="請輸入總金額"
																			value="${grouporderVO.groupBuyTotal}" />
																	</div>
																</div>
																<div class="row">
																	<div class="col-sm-4">
																		<br>
																		<div class="form-group">
																			<label for="paymentTerm" class="sym-dark-font">
																				<h5>付款方式</h5>
																			</label> <input type="text" class="form-control"
																				id="paymentTerm" name="paymentTerm"
																				placeholder="請輸入付款方式"
																				value="${grouporderVO.paymentTerm}" />
																		</div>
																	</div>
																	<div class="col-sm-4">
																		<br>
																		<div class="form-group">
																			<label for="paymentState" class="sym-dark-font">
																				<h5>付款狀態</h5>
																			</label> <input type="text" class="form-control"
																				id="paymentState" name="paymentState"
																				placeholder="請輸入付款狀態"
																				value="${grouporderVO.paymentState}" />
																		</div>
																	</div>
																	<div class="col-sm-4">
																		<br>
																		<div class="form-group">
																			<label for="giftVoucher" class="sym-dark-font">
																				<h5>購物金</h5>
																			</label> <input type="text" class="form-control"
																				id="giftVoucher" name="giftVoucher"
																				placeholder="購物金"
																				value="${grouporderVO.giftVoucher}" />
																		</div>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col-sm-4">
																	<br>
																	<div class="form-group">
																		<label for="contactNumber" class="sym-dark-font">
																			<h5>連絡電話</h5>
																		</label> <input type="text" class="form-control"
																			id="contactNumber" name="contactNumber"
																			placeholder="請輸入連絡電話"
																			value="${grouporderVO.contactNumber}" />
																	</div>
																</div>
																<div class="col-sm-4">
																	<br>
																	<div class="form-group">
																		<label for="shippingLocation" class="sym-dark-font">
																			<h5>寄送地址</h5>
																		</label> 
																		<select id = "city" name="city">
																		    <option value = "">請選擇</option>
																		</select>
<!-- 																		第二層選單(先隱藏，選完第一層後再出現) -->
																		<select id = "area" name="area" style="display:none;">
																		    <option value = "">請選擇</option>
																		</select>
																		<input type="text" class="form-control"
																			id="shippingLocation" name="shippingLocation"
																			placeholder="寄送地址"
																			value="${grouporderVO.shippingLocation}" /> <br>
																	</div>
																</div>
															</div>

															<!-- /.card-body -->
															<div class="card-footer">
																<div class="row">


																	<div class="col-sm-9"></div>
																	<div class="col-sm-3">
																		<input type="hidden" name="action" value="update">
																		<input type="hidden" name="groupBuyOrderID"
																			value="${grouporderVO.groupBuyOrderID}">

																		<button
																			class="btn sym-darkpurple sym-yellow-font btn_style">送出編輯</button>
																		<!-- <button class="btn btn-primary">
                                                    儲存並下架
                                                </button>
                                                <button class="btn btn-primary">
                                                    儲存並上架
                                                </button> -->
																		<!-- <button
                                                    class="btn btn-default float-right"
                                                >
                                                    取消
                                                </button> -->
																	</div>
																</div>
															</div>
														</div>
														<!-- /.card -->
													</div>
												</div>
												<!-- /.row -->
											</div>
										</form>
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
											&copy; <a href="#">Tibame TGA104 第六組 SYM</a>, All Right
											Reserved.
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
					<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
						src="${pageContext.request.contextPath}/back-end/grouporder/js/address.js"></script>
					<link rel="stylesheet" type="text/css"
						href="${pageContext.request.contextPath}/back-end/grouporder/datetimepicker/jquery.datetimepicker.css" />
					<script
						src="${pageContext.request.contextPath}/back-end/grouporder/datetimepicker/jquery.js"></script>
					<script
						src="${pageContext.request.contextPath}/back-end/grouporder/datetimepicker/jquery.datetimepicker.full.js"></script>
						



					<script>
        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
           theme: '',              //theme: 'dark',
 	       timepicker:true,       //timepicker:true,
 	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
 	       format:'Y-m-d H:i:s',         //format:'Y-m-d H:i:s',
 		   value: '${grouporderVO.orderTime}',
						// value:   new Date(),
						//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
						//startDate:	            '2017/07/10',  // 起始日
						//minDate:               '-1970-01-01', // 去除今日(不含)之前
						//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
						});

						// ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

						//      1.以下為某一天之前的日期無法選擇
						//      var somedate1 = new Date('2017-06-15');
						//      $('#f_date1').datetimepicker({
						//          beforeShowDay: function(date) {
						//        	  if (  date.getYear() <  somedate1.getYear() || 
						//		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
						//		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
						//              ) {
						//                   return [false, ""]
						//              }
						//              return [true, ""];
						//      }});

						//      2.以下為某一天之後的日期無法選擇
						//      var somedate2 = new Date('2017-06-15');
						//      $('#f_date1').datetimepicker({
						//          beforeShowDay: function(date) {
						//        	  if (  date.getYear() >  somedate2.getYear() || 
						//		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
						//		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
						//              ) {
						//                   return [false, ""]
						//              }
						//              return [true, ""];
						//      }});

						//      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)
						//      var somedate1 = new Date('2017-06-15');
						//      var somedate2 = new Date('2017-06-25');
						//      $('#f_date1').datetimepicker({
						//          beforeShowDay: function(date) {
						//        	  if (  date.getYear() <  somedate1.getYear() || 
						//		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
						//		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
						//		             ||
						//		            date.getYear() >  somedate2.getYear() || 
						//		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
						//		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
						//              ) {
						//                   return [false, ""]
						//              }
						//              return [true, ""];
						//      }});
						
					</script>
</body>

</html>