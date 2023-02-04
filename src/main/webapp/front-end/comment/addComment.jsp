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

<link rel="stylesheet" href="./css/review.css" />
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

						<a href="my-account.jsp" class="nav-link dropdown-toggle"
							data-toggle="dropdown"> <img class="rounded-circle "
							src="${pageContext.request.contextPath}/member/DBGifReader?memberID=${memVO.memberID}"
							alt="" style="width: 40px; height: 40px; object-fit: cover" onerror="this.src='${pageContext.request.contextPath}/front-end/member/img/account.jpg'"/> ${memVO.userAccount}
						</a>
						<div class="dropdown-menu">
							<a
								href="${pageContext.request.contextPath}/front-end/member/my-account.jsp"
								class="dropdown-item">我的帳號</a>
							<FORM METHOD="post"
								ACTION="${pageContext.request.contextPath}/front-end/member/getOneForLogOut">
								<input class="dropdown-item" type="submit" name="action"
									value="登出"></a>
							</FORM>

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
	<div class="my-account" >
		<div class="container-fluid" >
			<div class="row" style='display: flex; justify-content: center;'>
				
				<div class="col-md-9" >

					<div class="tab-pane fade active show" id="orders-tab"
						role="tabpanel" aria-labelledby="orders-nav">
						<div class="table-reswponsive">





							<table id="table-1" class="table">

								<tr id="my-car-tr">
									<th width="155">商品名稱</th>
									<th width="155">商品圖片</th>
									<th width="125">價格</th>

									<th width="105">數量</th>
									<th width="130">小計</th>

								</tr>
								<tr>
									<td width="155">${orderlistVO.productName}</td>
									<td width="155"><img
										src="${pageContext.request.contextPath}/product/picServlet?productID=${orderlistVO.productID}"
										style="width: 230px; height: 200px" alt="Product Image"></td>
									<td width="125">${orderlistVO.price}</td>

									<td width="105">${orderlistVO.quantity}</td>
									<td width="130">${orderlistVO.subTotal}</td>
								</tr>
							</table>


						    <br>
							&nbsp; &nbsp; &nbsp; &ensp;&emsp;    <b>評價:</b> <br>
							<div class="star-mark">

								<ul class="star">
									<li></li>
									<li></li>
									<li></li>
									<li></li>
									<li></li>
								</ul>
								<div class="result">
									<span class="mark"></span><span class="detail"></span>
								</div>
								<div class="help-info">
									<span class="mark"></span>&nbsp;<span class="decri"></span><br />
									<span class="detail"></span>
								</div>
							</div> 
							<br>

							<FORM id="upload" METHOD="post" ACTION="OrderlistServlet"
								enctype="multipart/form-data">
							<div class='upload1'>
								<b>上傳圖片:</b> &emsp; 
								<input type="file" name="upfile" id="upfile"> <br><br>
			 					<img id="preview" style="width: 200px; height: 160px;" border="0" />
								<br><br>
							
							</div>	
							<div class='text'>
							   <b>留言:</b>
							</div>
							<div class='upload2'>
								 <br>
								<textarea type="TEXT" name="buyerComment" 
									style="width: 380px; height: 280px; "></textarea>


								<input type="hidden" name="productID" value="${orderlistVO.productID}"> <br><br>

								<input type="hidden" name="orderDetailID"
									value="${orderlistVO.orderDetailID}" size="45" /> <input
									type="hidden" name="buyerReview" id="buyerComment" value="" />
								<input type="hidden" name="action" value="update">
								 <input type="submit" value="送出新增" 
								 	style='height:40px; width:90px; background-color: #FFA9A9;
										 border: 0px; font-weight: bold; float:right '>
								<br><br><br>
							</div>	
								
							
							
							</FORM>
					
								

							








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



						</div>
					</div>

				</div>
			</div>








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

	<script src="./js/review.js"></script>
	<script src="./vendors/jquery/jquery-3.4.1.min.js"></script>
	 <script>
        // Get the form element
        const form = document.getElementById('upload');
      
        // Handle the form submission
        form.addEventListener('change', (e) => {
          e.preventDefault();
      
          // Get the selected file
          const file = document.getElementById('upfile').files[0];
      
          // Create a new FileReader object
          const reader = new FileReader();
      
          // Set the onload event to handle the image preview
          reader.onload = (event) => {
            // Get the image data
            const data = event.target.result;
      
            // Set the preview image source
            document.getElementById('preview').src = data;
          }
      
          // Read the selected file as a Data URL
          reader.readAsDataURL(file);
        });
      </script>
</body>

</html>