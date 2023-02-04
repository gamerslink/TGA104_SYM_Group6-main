<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.group6.tibame104.group.model.*"%>

<%@ include file="header.jsp"%>

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
											<h3 class="card-title sym-yellow-font">團購設定 - 編輯團購</h3>
										</div>
										<!-- /.card-header -->
										<!-- form start -->
										<form METHOD="post"
		ACTION="${pageContext.request.contextPath}/front-end/group/update"
		name="form1">
											<div class="card-body">
												<div class="form-group">
													<div class="display-flex mg-bottom-2">
														<div class="col-sm-4">
															<div class="form-group">
																<label class="sym-dark-font">
																	<h5>開始日期</h5>
																</label> <input type="text" name="groupBuyingOnLoadDate" class="form-control" id="f_date1"
																	placeholder="開始日期" readonly />
															</div>
														</div>
														<div class="col-sm-4 margin-left-1">
															<div class="form-group">
																<label class="sym-dark-font">
																	<h5>結束日期</h5>
																</label> <input type="text" name="groupBuyingOffLoadDate" class="form-control" id="f_date2"
																	placeholder="結束日期" />
															</div>
														</div>
														<div class="col-sm-3 margin-left-1">
															<label class="sym-dark-font">
																<h5>管理員編號</h5>
															</label> <input type="text"
																value="${groupVO.administratorID}"
																class="form-control" id="administratorID" readonly />
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-4">
														<div class="form-group">
														<h5>團購商品編號</h5>
															<select class="form-select mb-3" name="groupBuyProductID" id="groupBuyProductID">
																<c:forEach var="groupproductVO"
																	items="${groupproductVOs}">
																	<option value="${groupproductVO.groupBuyProductID}">${groupproductVO.groupBuyProductID}
																</c:forEach>
															</select>
														</div>
													</div>
													<div class="col-sm-4">
														<h5>團購狀態</h5>
														<p></p>
														<input type="radio" name="groupBuyingState" value="true"
															ID="Choice1" checked /> <label for="Choice1">上架&emsp;</label>
														<input type="radio" name="groupBuyingState" value="false"
															ID="Choice2" /> <label for="Choice2">下架&emsp;</label>
														</td>
													</div>

													<div class="col-sm-4">
														<label class="sym-dark-font">
															<h5>團購編號</h5>
														</label> <input type="text" value="${groupVO.groupBuyID}"
															class="form-control" id="groupBuyID" readonly />
													</div>
												</div>
												<br>
												<div class="col-sm-4">
													<label class="sym-dark-font">
														<h5>更新日期</h5>
													</label> <input type="text" class="form-control" id="f_date3"
														placeholder="更新日期" readonly />
												</div>
												<br>
												<div class="card-footer">
													<div class="row">
														<div class="col-sm-9"></div>
														<div class="col-sm-3">
															<input type="hidden" name="action" value="update">
															<input type="hidden" name="groupBuyID"
																value="${groupVO.groupBuyID}"> <input
																type="hidden" name="groupBuyProductOrderTotal"
																value="${groupVO.groupBuyProductOrderTotal}">
															<input	type="hidden" name="administratorID"
																value="${groupVO.administratorID}"> 

															<button
																class="btn sym-darkpurple sym-yellow-font btn_style"
																id="addProduct">送出修改</button>
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
	<script src="${pageContext.request.contextPath}/back-end/group/js/main.js"></script>
	<script>

  </script>
</body>

</html>
<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/back-end/group/datetimepicker/jquery.datetimepicker.css" />
<script
	src="${pageContext.request.contextPath}/back-end/group/datetimepicker/jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/back-end/group/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>

<script>
$(document).ready(function () {
	
if(${groupVO.groupBuyingState}){
	document.querySelector('input[ID="Choice1"]').checked = true;
}else{
	document.querySelector('input[ID="Choice2"]').checked = true;
};


// if($("#groupBuyProductID").find("option").val() == ${groupVO.groupBuyProductID}){
// 	console.log("123")
// }else{
// 	console.log("333")
// }

$("option:contains('${groupVO.groupBuyProductID}')").map(function(){if($(this).text() == ${groupVO.groupBuyProductID}){
	
// 	console.log(this)
	$(this).prop("selected",true);
		
}})
	
	
})
// console.log($('option:contains("${groupVO.groupBuyProductID}")'))
// console.log(${groupVO.groupBuyProductID})
$.datetimepicker.setLocale('zh');
$('#f_date1').datetimepicker({
   theme: '',              //theme: 'dark',
    timepicker:false,       //timepicker:true,
    step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
    format:'Y-m-d H:i:s',        //format:'Y-m-d H:i:s',
	   value:'${groupVO.groupBuyingOnLoadDate}',
// value:   new Date(),
//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
//startDate:	            '2017/07/10',  // 起始日
//minDate:               '-1970-01-01', // 去除今日(不含)之前
//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
});
$.datetimepicker.setLocale('zh');
$('#f_date2').datetimepicker({
   theme: '',              //theme: 'dark',
    timepicker:false,       //timepicker:true,
    step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
    format:'Y-m-d H:i:s',         //format:'Y-m-d H:i:s',
	   value: '${groupVO.groupBuyingOffLoadDate}',
// value:   new Date(),
//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
//startDate:	            '2017/07/10',  // 起始日
//minDate:               '-1970-01-01', // 去除今日(不含)之前
//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
});
$.datetimepicker.setLocale('zh');
$('#f_date3').datetimepicker({
   theme: '',              //theme: 'dark',
    timepicker:false,       //timepicker:true,
    step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
    format:'Y-m-d H:i:s',         //format:'Y-m-d H:i:s',
	   value: '${groupVO.updateTime}	',
	// value:   new Date(),
	//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
	//startDate:	            '2017/07/10',  // 起始日
	//minDate:               '-1970-01-01', // 去除今日(不含)之前
	//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
	});

	// ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

	// //      1.以下為某一天之前的日期無法選擇
	//      var somedate1 =  $('#f_date2')
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() <  somedate1.getYear() || 
	// 		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
	// 		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});
  $('#f_date2').datetimepicker({
	  format:'Y-m-d 00:00:00',
	  onShow:function(){
	   this.setOptions({
	    minDate:$('#f_date1').val()?$('#f_date1').val():false
	   })
	  },
	  timepicker:false
	 });
	// //      2.以下為某一天之後的日期無法選擇
	//      var somedate2 = new Date('2017-06-15');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() >  somedate2.getYear() || 
	// 		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
	// 		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
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

</html>