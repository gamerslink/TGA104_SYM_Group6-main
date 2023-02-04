<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.group6.tibame104.order.model.*, java.util.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>


<%

OrderVO orderVO_orderID = (OrderVO)request.getAttribute("orderVO_orderID");

//EmpServlet.java(Controller), 存入req的empVO物件

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
	href="${pageContext.request.contextPath}/front-end/order/img/logoSYM.jpg"
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
	href="${pageContext.request.contextPath}/front-end/order/lib/slick/slick.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/order/lib/slick/slick-theme.css"
	rel="stylesheet" />

<!-- Template Stylesheet -->

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/front-end/order/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/front-end/order/css/woody.css" />

<script src="https://kit.fontawesome.com/bc79e44e11.js"
	crossorigin="anonymous"></script>
</head>

<body>
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

						<a href="my-account.html" class="nav-link dropdown-toggle"
							data-toggle="dropdown"> <img class="rounded-circle "
							src="${pageContext.request.contextPath}/back-end/order/img/account.jpg"
							alt="" style="width: 40px; height: 40px" /> 帳號名稱
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
							src="${pageContext.request.contextPath}/back-end/order/img/logo.png"
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
						<a href="cart.html" class="btn cart"> <i
							class="fa fa-shopping-cart"></i> <span>(0)</span>
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
							<table class="table table-bordered">
								<thead class="thead-dark">
	
									<form action="<%=request.getContextPath()%>/front-end/comment/OrderlistServlet">
										
									
										<input type="hidden" name="orderID" value="${orderID}" />
										<input type="hidden" name="action" value="do_buyercomment" />
										<input type="submit" value="給予評價" />
									</form>

									<form action="<%=request.getContextPath()%>/front-end/comment/OrderlistServlet">
										<input type="hidden" name="action" value="check_buyercomment" />
										<input type="submit" value="查看評價" />
									</form>
									<br><br>


									<FORM METHOD="post" ACTION="OrderServlet">
										<b>輸入訂單編號: </b> <input type="text" name="orderID"> <input
											type="hidden" name="action" value="select_by_OrderID">
										<input type="submit" value="送出">
									</FORM>
									<br>
									<br>
									<tr>
										<th>訂單編號</th>
										<th>賣場編號</th>
										<th>賣場名稱</th>
										<th>會員ID</th>
										<th>訂單日期</th>
										<th>訂單狀態</th>
										<th>收件人</th>
										<th>電話</th>
										<th>信用卡號碼</th>
										<th>收件地址</th>
										<th>付款方式</th>
										<th>優惠券ID</th>
										<th>原總價</th>
										<th>購物金折抵金額</th>
										<th>優惠券折抵金額</th>
										<th>最終總金額</th>
									</tr>
									
									<tr>

										<td>${orderID} </td>
										<td><%=orderVO_orderID.getStoreID()%></td>
										<td><%=orderVO_orderID.getStoreName()%></td>
										<td><%=orderVO_orderID.getMemberID()%></td>
										<td><%=orderVO_orderID.getOrderDate()%></td>
										<td><%=orderVO_orderID.getOrderStatus()%></td>
										<td><%=orderVO_orderID.getReceiver()%></td>
										<td><%=orderVO_orderID.getPhone()%></td>
										<td><%=orderVO_orderID.getCreditcardNumber()%></td>
										<td><%=orderVO_orderID.getAddress()%></td>
										<td><%=orderVO_orderID.getPayType()%></td>
										<td><%=orderVO_orderID.getCouponID()%></td>
										<td><%=orderVO_orderID.getOriginalTotal()%></td>
										<td><%=orderVO_orderID.getUseShoppingGold()%></td>
										<td><%=orderVO_orderID.getUseCouponGold()%></td>
										<td><%=orderVO_orderID.getFinalTotal()%></td>
								


									</tr>
									
									
									
								<!--   <tbody>
                    <tr>
                      <td>1</td>
                      <td>Product Name</td>
                      <td>01 Jan 2020</td>
                      <td>$99</td>
                      <td>Approved</td>
                      <td><button class="btn">View</button></td>
                    </tr>
                    <tr>
                      <td>2</td>
                      <td>Product Name</td>
                      <td>01 Jan 2020</td>
                      <td>$99</td>
                      <td>Approved</td>
                      <td><button class="btn">View</button></td>
                    </tr>
                    <tr>
                      <td>3</td>
                      <td>Product Name</td>
                      <td>01 Jan 2020</td>
                      <td>$99</td>
                      <td>Approved</td>
                      <td><button class="btn">View</button></td>
                    </tr>
                  </tbody> -->
							</table>
						</div>
					</div>

				</div>
			</div>







			<hr>

		</div>

	</div>
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
</body>

</html>