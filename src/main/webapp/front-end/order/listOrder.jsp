<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page
	import="com.group6.tibame104.order.model.*,com.group6.tibame104.orderlist.model.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>


<%
Map<OrderVO, List<OrderlistVO>> map_list = (Map<OrderVO, List<OrderlistVO>>) request.getAttribute("map_list");
%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>SYM</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="eCommerce HTML Template Free Download" name="keywords" />
<meta content="eCommerce HTML Template Free Download" name="description" />

<!-- Favicon -->
<link
	href="${pageContext.request.contextPath}/front-end/member/img/logoSYM.jpg"
	rel="icon" />

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap"
	rel="stylesheet" />

<!-- CSS Libraries -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/lib/slick/slick.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/lib/slick/slick-theme.css"
	rel="stylesheet" />

<!-- Template Stylesheet -->
<link
	href="${pageContext.request.contextPath}/front-end/member/css/style.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/css/woody.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/css/coupon.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/order/css/table.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/css/signupDay.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/order/css/bar.css"
	rel="stylesheet" />
<script src="https://kit.fontawesome.com/bc79e44e11.js"
	crossorigin="anonymous"></script>
</head>

<body translate="no">
	<!-- Top bar Start -->
	<!-- <div class="top-bar">
      <div class="container-fluid">
        <div class="row">
          <div class="col-sm-6">
            <i class="fa fa-envelope"></i>
            support@email.com
          </div>
          <div class="col-sm-6">
            <i class="fa fa-phone-alt"></i>
            +012-345-6789
          </div>
        </div>
      </div>
    </div> -->
	<!-- Top bar End -->

	<!-- Nav Bar Start -->
	<div class="nav">
		<div class="container-fluid">
			<nav class="navbar navbar-expand-md bg-dark navbar-dark">
				<!-- <a href="#" class="navbar-brand">MENU</a> -->
				<button type="button" class="navbar-toggler" data-toggle="collapse"
					data-target="#navbarCollapse">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse justify-content-between"
					id="navbarCollapse">
					<div class="navbar-nav mr-auto">
						<a href="index.html" class="nav-item nav-link">首頁</a> <a
							href="product-list.html" class="nav-item nav-link">我的賣場</a>

						<div class="nav-item dropdown">
							<a href="#" class="nav-link " data-toggle="dropdown">客服中心</a>


						</div>
					</div>
				</div>
				<div class="navbar-nav ml-auto">
					<div class="nav-item dropdown">

						<a href="my-account.jsp" class="nav-link dropdown-toggle"
							data-toggle="dropdown"> <img class="rounded-circle "
							src="${pageContext.request.contextPath}/member/DBGifReader?memberID=${memVO.memberID}"
							alt="" style="width: 40px; height: 40px; object-fit: cover" onerror="this.src='${pageContext.request.contextPath}/front-end/member/img/account.jpg'"/> ${memVO.userAccount}
						</a>
						<div class="dropdown-menu">
							<a href="my-account.html" class="dropdown-item">我的帳號</a> <a
								href="index.html" class="dropdown-item">登出</a>

						</div>
					</div>
				</div>
			</nav>
		</div>
	</div>
	<!-- Nav Bar End -->

	<!-- Bottom Bar Start -->
	<div class="bottom-bar">
		<div class="container-fluid">
			<div class="row align-items-center">
				<div class="col-md-3">
					<div class="logo">
						<a href="index.html"> <img
							src="${pageContext.request.contextPath}/front-end/member/img/logo.png"
							alt="Logo" />
						</a>
					</div>
				</div>
				<div class="col-md-6">
					<div class="search">
						<input type="text" placeholder="商品搜尋
              " />
						<button>
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
				<div class="col-md-3">
					<div class="user">
						<!-- <a href="wishlist.html" class="btn wishlist">
                <i class="fa fa-heart"></i>
                <span>(0)</span>
              </a> -->
						<a href="${pageContext.request.contextPath}/front-end/shop/Cart_new.jsp" class="btn cart"> <i
							class="fa fa-shopping-cart"></i> <span>(${count_num == null ? "0" : count_num})</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Bottom Bar End -->

	<!-- Breadcrumb Start -->
	<div class="breadcrumb-wrap">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Home</a></li>
				<li class="breadcrumb-item"><a href="#">Products</a></li>
				<li class="breadcrumb-item active">My Account</li>
			</ul>
		</div>
	</div>
	<!-- Breadcrumb End -->

	<!-- My Account Start -->
	<div class="my-account">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-3">
					<div class="nav flex-column nav-pills" role="tablist"
						aria-orientation="vertical">
						<a class="nav-link" id="account-nav" data-toggle="pill"
							href="#account-tab" role="tab"><i class="fa fa-user"></i>我的帳戶</a>
						<a class="nav-link" id="password-nav" data-toggle="pill"
							href="#password-tab" role="tab"><i
							class="fa-solid fa-lock-open"></i>修改密碼</a> <a class="nav-link active"
							id="orders-nav" data-toggle="pill" href="#orders-tab" role="tab"
							aria-selected="true"><i class="fa fa-shopping-bag"></i>訂單管理</a> <a
							class="nav-link" id="payment-nav" data-toggle="pill"
							href="#payment-tab" role="tab"><i class="fa-solid fa-coins"></i>我的購物金</a>
						<a class="nav-link" id="address-nav" data-toggle="pill"
							href="#address-tab" role="tab"><i class="fa-solid fa-ticket"></i></i>我的優惠券</a>
						<a class="nav-link" id="blocklist-nav" data-toggle="pill"
							href="#blocklist-tab" role="tab"><i
							class="fa-solid fa-user-xmark"></i>封鎖名單</a>
						<!-- <a class="nav-link" href="index.html"
                ><i class="fa fa-sign-out-alt"></i>登出</a
              > -->
					</div>
				</div>
				<div class="col-md-9">

					<div class="tab-pane fade active show" id="orders-tab"
						role="tabpanel" aria-labelledby="orders-nav">
						<div class="table-responsive">

							<div id='search'>
							
								 <div id='search1'>
									<ul >
										<li>
											<FORM METHOD="post"
												ACTION="${pageContext.request.contextPath}/front-end/order/select_Order">
												<b>輸入訂單編號: </b> 
												<input type="text" id="orderID" name="orderID"
													style="width: 100px; height: 25px"> 
												<br><br>
												<input type="submit" value="送出">
											</FORM> <br>
										<br>
										</li>
									</ul>
								</div>
								<div id='search2'>
									<ul>
										<li>
											<FORM METHOD="post"
												ACTION="${pageContext.request.contextPath}/front-end/order/select_Order">

												<b>輸入訂單日期:</b> <input name="fromdate" id="f_date1"
													type="text" style="width: 100px; height: 25px"> <b>至</b>
												<input name="todate" id="f_date2" type="text"
													style="width: 100px; height: 25px"> <br> <br>
												<b>選擇訂單狀態:</b> <select name="status"
													style="width: 90px; height: 25px">

													<option id='-1' value="-1">全部</option>
													<option id='0' value="0">待繳款</option>
													<option id='1' value="1">待出貨</option>
													<option id='2' value="2">待收貨</option>
													<option id='3' value="3">訂單完成</option>

												</select> <br> <br> <input type="hidden" name="memberID"
													value="${memVO.memberID}"> <input type="submit"
													value="送出">
											</FORM>


										</li>
									</ul>
								</div>
							</div>
								<br><br><br>
						<c:if test="${orderID != null}">
							<script type="text/javascript">
								document.getElementById('orderID').value = '${orderID}';
							</script>						
						</c:if>
						<c:if test="${status != null}">
							<script type="text/javascript">
							if(${status} == '-1'){
								document.getElementById('-1').selected = true;
							}else if(${status} == '0'){
								document.getElementById('0').selected = true;
							}else if(${status} == '1'){
								document.getElementById('1').selected = true;
							}else if(${status} == '2'){
								document.getElementById('2').selected = true;
							}else if(${status} == '3'){
								document.getElementById('3').selected = true;
							}
							</script>						
						</c:if>
						<c:if test="${fromdate != null && todate != null}">
							<script type="text/javascript">
								document.getElementById('f_date1').value = '${fromdate}';
								document.getElementById('f_date2').value = '${todate}';
							</script>						
						</c:if>
							

							<%
							Set<OrderVO> set = map_list.keySet();
							Iterator<OrderVO> it = set.iterator();
							while (it.hasNext()) {
								OrderVO orderVO = it.next();
								List<OrderlistVO> list = map_list.get(orderVO);
							%>

							<b>
								訂單日期:<%=orderVO.getOrderDate().toString().substring(0, 19)%>
								&emsp;&emsp;&emsp;&emsp;賣場:<%=orderVO.getStoreName()%>
							</b>
							<br><br>



							<table id="table-1" class="table" border="0" >

								<tr id="my-car-tr">
									<th width="155">商品名稱</th>
									<th width="155">商品圖片</th>
									<th width="125">價格</th>

									<th width="105">數量</th>
									<th width="130">小計</th>
									<th width="130" Class='rate<%=orderVO.getOrderID()%>'>評價</th>

								</tr>

								<c:forEach var="orderlistVO" items="<%=list%>">

									<tr id="my-car-tr">
										<td width="155">${orderlistVO.productName}</td>
										<td width="155"><img
											src="${pageContext.request.contextPath}/product/picServlet?productID=${orderlistVO.productID}"
											style="width: 200px; height: 160px" alt="Product Image">
										</td>
										<td width="125">${orderlistVO.price}</td>

										<td width="105">${orderlistVO.quantity}</td>
										<td width="130">${orderlistVO.subTotal}</td>
										<td width="130" class='rate<%=orderVO.getOrderID()%>'>
											<form
												action="<%=request.getContextPath()%>/front-end/comment/OrderlistServlet">


												<input type="hidden" name="orderlistID"
													value="${orderlistVO.orderDetailID}" /> <input
													type="hidden" name="action" value="do_buyercomment" /> <input
													type="submit" value="給予評價"
													style='height:40px; width:90px;  ' />
											</form>
											<br>

											<form
												action="<%=request.getContextPath()%>/front-end/comment/OrderlistServlet">
												<input type="hidden" name="orderlistID"
													value="${orderlistVO.orderDetailID}" /> <input
													type="hidden" name="action" value="check_buyercomment" />
												
											</form>
										</td>


									</tr>
									
									
								</c:forEach>
									<tr id="my-car-tr">
										<td colspan="3" style="text-align: right"></td>
										<td colspan="5" style="text-align: right">
											<b id='paytotal<%=orderVO.getOrderID()%>' style='font-size: 20px;'>訂單總金額:</b>&nbsp;&nbsp;
											
											<b style='font-size: 20px;'>$<%=orderVO.getFinalTotal() %></b>
										</td>
									
									</tr>
							</table>
							<br>
							<b>訂單狀態:</b>	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						<form method="post" action="${pageContext.request.contextPath}/front-end/order/complete">
							<input type="submit" value="完成訂單" class="button<%=orderVO.getOrderID()%>"
								style='display:none; height:40px; width:90px; background-color: #FFA9A9;
								 border: 0px; font-weight: bold; float:right '>
							
							<input type="hidden" name="orderID" value="<%=orderVO.getOrderID() %>">
						</form>			
						    <input type="submit" value="查看付款資訊" class="check<%=orderVO.getOrderID()%>"
								style='display:none; height:40px; width:110px; background-color: #FFA9A9;
								 border: 0px; font-weight: bold; float:right '>
							<br><br>
							
							<b>待繳款&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;
							   待出貨&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&emsp;
							   待收貨&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;
							   訂單完成
							   </b>
							  <br><br>

							<p class="status" style="display:none">
								<%=orderVO.getOrderStatus()%>
							</p>
							
							<div class="container">
								<div class="progress">
									<div class="percent"></div>
								</div>
								
								<div class="steps">
									<div class="step" id="0"></div>
									<div class="step" id="1"></div>
									<div class="step" id="2"></div>
									<div class="step" id="3"></div>

								</div>
							</div>
							<br>
							

							<br> <br> <br> <br>
							<hr>


							<br> <br> <br> 
<script type="text/javascript">
	var rate = document.getElementsByClassName('rate<%=orderVO.getOrderID()%>');
	for(var sub of rate){
		if(<%=orderVO.getOrderStatus()%> != '3'){
			sub.style.display = 'none';	
		}
		
	}
	
	var button = document.getElementsByClassName('button<%=orderVO.getOrderID()%>')[0];
	if(<%=orderVO.getOrderStatus()%> == '2'){
		button.style.display = 'inline';	
	}
	
	var check = document.getElementsByClassName('check<%=orderVO.getOrderID()%>')[0];
	var paytotal = document.getElementById('paytotal<%=orderVO.getOrderID()%>');
	if(<%=orderVO.getOrderStatus()%> == '0'){
		check.style.display = 'inline';	
		paytotal.innerHTML = '付款總金額:';	
	}
	

</script>
							<%
							}
							%>

<p id="size" style="display:none"><%=map_list.keySet().size()%></p>

						</div>



					</div>

				</div>
			</div>







			<hr>

		</div>

	</div>


	<!-- My Account End -->

	<!-- Footer Start -->
	<div class="footer">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-3 col-md-6">
					<div class="footer-widget">
						<h5>網站介紹</h5>
						<ul>
							<li><a href="#">關於SYM</a></li>
							<li><a href="#">SYM團隊成員介紹</a></li>
							<!-- <li><a href="#">Terms & Condition</a></li> -->
						</ul>
					</div>
				</div>

				<div class="col-lg-3 col-md-6">
					<div class="footer-widget">
						<h5>聯絡我們</h5>
						<div class="contact-info">
							<p>
								<i class="fa fa-map-marker"></i>台北商業大學
							</p>
							<!-- <p><i class="fa fa-envelope"></i>email@example.com</p>
                <p><i class="fa fa-phone"></i>+123-456-7890</p> -->
						</div>
					</div>
				</div>


				<div class="col-lg-3 col-md-6">
					<div class="footer-widget">
						<h5>常見問題</h5>
						<ul>
							<li><a href="#">前往客服中心</a></li>
							<!-- <li><a href="#">Shipping Policy</a></li>
                <li><a href="#">Return Policy</a></li> -->
						</ul>
					</div>
				</div>
			</div>


		</div>
	</div>
	<!-- Footer End -->

	<!-- Footer Bottom Start -->
	<div class="footer-bottom">
		<div class="container">
			<div class="row">
				<div class="col-md-6 copyright">
					<p>
						Copyright &copy; <a href="#">SYM</a>. All Rights Reserved
					</p>
				</div>

				<div class="col-md-6 template-by">
					<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
					<!-- <p>Designed By <a href="https://htmlcodex.com">HTML Codex</a></p> -->
				</div>
			</div>
		</div>
	</div>
	<!-- Footer End -->

	<!-- Back to Top -->
	<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/slick/slick.min.js"></script>

	<!-- Template Javascript -->
	<script src="js/main.js"></script>
	<script src="js/woody.js"></script>
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/front-end/order/datetimepicker/jquery.datetimepicker.css" />
	<script
		src="${pageContext.request.contextPath}/front-end/order/datetimepicker/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath}/front-end/order/datetimepicker/jquery.datetimepicker.full.js"></script>
	<script
		src="${pageContext.request.contextPath}/front-end/order/js/bar.js"></script>
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

</body>

</html>