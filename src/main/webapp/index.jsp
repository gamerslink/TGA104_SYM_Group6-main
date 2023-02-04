<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.group6.tibame104.ad.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



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
	href="${pageContext.request.contextPath}/front-end/product_detail/img/logoSYM.jpg"
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
<link href="lib/slick/slick.css" rel="stylesheet" />
<link href="lib/slick/slick-theme.css" rel="stylesheet" />

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet" />
<link href="css/woody.css" rel="stylesheet" />

</head>

<body>
	<!-- Top bar Start -->
	<!-- <div class="top-bar">
      <div class="container-fluid">
        <div class="row">
          <div class="col-sm-6">
            <i class="fa fa-envelope"></i>
            support@email.comh
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
				<a href="#" class="navbar-brand">MENU</a>
				<button type="button" class="navbar-toggler" data-toggle="collapse"
					data-target="#navbarCollapse">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse justify-content-between"
					id="navbarCollapse">
					<div class="navbar-nav mr-auto">
						<a href="${pageContext.request.contextPath}/" class="nav-item nav-link">首頁</a> 
						<a href="${pageContext.request.contextPath}/front-end/store/myStore.jsp" class="nav-item nav-link">我的賣場</a>
						<div class="nav-item dropdown">
							<a href="#" class="nav-link " data-toggle="dropdown">客服中心</a>
						</div>
					</div>
				</div>
				<div class="navbar-nav ml-auto">
					<div class="nav-item dropdown">

						<c:choose>
							<c:when test="${memVO.userName == null}">
								<a href="${pageContext.request.contextPath}/front-end/member/my-account.jsp" class="nav-link"
									> 登入/註冊</a>
								
							</c:when>


							<c:otherwise>
								<a href="#" class="nav-link dropdown-toggle"
									data-toggle="dropdown"> <img class="rounded-circle "
									src="${pageContext.request.contextPath}/member/DBGifReader?memberID=${memVO.memberID}"
									alt="" style="width: 40px; height: 40px; object-fit: cover"
									onerror="this.src='${pageContext.request.contextPath}/front-end/member/img/account.jpg'" />
									${memVO.userAccount}
								</a>
								<div class="dropdown-menu">
									<a
										href="${pageContext.request.contextPath}/front-end/member/my-account.jsp"
										class="dropdown-item">會員中心</a>
									<FORM METHOD="post"
										ACTION="${pageContext.request.contextPath}/front-end/member/getOneForLogOut">
										<input class="dropdown-item" type="submit" name="action"
											value="登出"></a>
									</FORM>
								</div>
							</c:otherwise>
						</c:choose>

						<!-- 登入前 -->

						<!-- 登入後 -->
						<!-- <a
                  href="#"
                  class="nav-link dropdown-toggle"
                  data-toggle="dropdown"
                  >
                  <img
                      class="rounded-circle "
                      src="img/account.jpg"
                      alt=""
                      style="width: 40px; height: 40px"
                    />
                  帳號名稱</a
                >
                <div class="dropdown-menu">
                  <a href="#" class="dropdown-item">我的帳號</a>
                  <a href="#" class="dropdown-item">註冊</a>
                </div> -->
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
							src="${pageContext.request.contextPath}/front-end/product_detail/img/logoSYM.jpg"
							alt="Logo" />
						</a>
					</div>
				</div>
				<div class="col-md-6">
					<div class="search">
						<FORM METHOD="post"
							ACTION="${pageContext.request.contextPath}/SearchServlet">
							<input type="hidden" name="action" value="getAll_For_Display" />
							<input type="text" placeholder="商品搜尋" name="productName" />
							<button>
								<i class="fa fa-search"></i>
							</button>
						</FORM>
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

	<!-- Main Slider Start -->
	<div class="header">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-3">
					<nav class="navbar bg-light">
						<ul class="navbar-nav">
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/"><i
									class="fa fa-home"></i>居家生活</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/SearchServlet?productMainID=3&action=category"><i
									class="fa fa-shopping-bag"></i>包包/精品</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/SearchServlet?productMainID=2&action=category"><i
									class="fa fa-plus-square"></i>美妝保健</a></li>
							 	<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/"><i
									class="fa fa-female"></i>女生配件</a></li>
							<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/"><i
									class="fa fa-child"></i>嬰幼童與母親</a></li>
							<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/"><i
									class="fa fa-tshirt"></i>男/女衣著</a></li>
							<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/SearchServlet?productMainID=1&action=category"><i
									class="fa fa-mobile-alt"></i>3C與電腦</a></li>
							<li class="nav-item"><a class="nav-link" href="#"><i
									class="fa fa-microchip"></i>家電影音</a></li> 
						</ul>
					</nav>
				</div>
				<div class="col-md-6">
					<div class="header-slider normal-slider">
						<c:forEach var="adVO" items="${list}">
							<div class="header-slider-item">

								<img
									src="${pageContext.request.contextPath}/back-end/ad/ad2.do?adSerialID=${adVO.adSerialID}"
									height="100%" width="100%">

							</div>
						</c:forEach>
					</div>
				</div>
				<div class="col-md-3">
					<div class="header-img">
						<div class="img-item">
							<img src="img/category-1.jpg" /> <a class="img-text" href="">
								<p>Some text goes here that describes the image</p>
							</a>
						</div>
						<div class="img-item">
							<img src="img/category-2.jpg" /> <a class="img-text" href="">
								<p>Some text goes here that describes the image</p>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Main Slider End -->

	<!-- Brand Start -->
	<!-- <div class="brand">
      <div class="container-fluid">
        <div class="brand-slider">
          <div class="brand-item"><img src="img/brand-1.png" alt="" /></div>
          <div class="brand-item"><img src="img/brand-2.png" alt="" /></div>
          <div class="brand-item"><img src="img/brand-3.png" alt="" /></div>
          <div class="brand-item"><img src="img/brand-4.png" alt="" /></div>
          <div class="brand-item"><img src="img/brand-5.png" alt="" /></div>
          <div class="brand-item"><img src="img/brand-6.png" alt="" /></div>
        </div>
      </div>
    </div> -->
	<!-- Brand End -->

	<!-- Feature Start-->
	<div class="feature">
		<div class="container-fluid">
			<div class="row align-items-center">
				<div class="col-lg-3 col-md-6 feature-col">
					<div class="feature-content">
						<i class="fab fa-cc-mastercard"></i>
						<h2>Secure Payment</h2>
						<p>Lorem ipsum dolor sit amet consectetur elit</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 feature-col">
					<div class="feature-content">
						<i class="fa fa-truck"></i>
						<h2>Worldwide Delivery</h2>
						<p>Lorem ipsum dolor sit amet consectetur elit</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 feature-col">
					<div class="feature-content">
						<i class="fa fa-sync-alt"></i>
						<h2>90 Days Return</h2>
						<p>Lorem ipsum dolor sit amet consectetur elit</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 feature-col">
					<div class="feature-content">
						<i class="fa fa-comments"></i>
						<h2>24/7 Support</h2>
						<p>Lorem ipsum dolor sit amet consectetur elit</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Feature End-->

	<!-- Category Start-->

	<!-- Category End-->

	<!-- Call to Action Start -->

	<!-- Call to Action End -->
	<div class="featured-product product">
		<div class="container-fluid">
			<div class="section-header">
				<c:forEach var="list" items="${list1}" begin="1" end="2">
					<a
						href="${pageContext.request.contextPath}/Announcement/getIndexNews2">
						<div class="centered" style="font-weight: bold; font-size: larger">最新消息：
							${list.announcementContent}</div>
					</a>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- Featured Product Start -->
	<div class="featured-product product">
		<div class="container-fluid">
			<div class="section-header">
				<h1>團購專區</h1>
			</div>
			<div class="row align-items-center">
				<c:forEach var="groupVOs" items="${groupVOs}">
					<c:forEach var="groupproductVOs" items="${groupproductVOs}">
						<c:if
							test="${(groupVOs.groupBuyProductID == groupproductVOs.groupBuyProductID)}"
							var="cc">
							<div class="col-md-4">
								<form id="msform" METHOD="post" class="col-md-12"
									style="border: 0px"
									ACTION="${pageContext.request.contextPath}/back-end/groupproduct/getOneForDisplay">
									<div class="col-md-4" style="max-width: 100%">
										<div class="product-item">
											<div class="product-title">
												<a>團購編號 : ${groupVOs.groupBuyID}</a>
											</div>
											<div class="product-image">
												<a> <img
													src="${pageContext.request.contextPath}/back-end/groupproduct/DBJPGReader?groupBuyProductID=${groupproductVOs.groupBuyProductID}"
													style="width: 100%" alt="product-image">
													</td>
												</a>
											</div>
											<div class="product-price">
												<h3>
													<span>原價$</span>${groupproductVOs.groupBuyProductPrice}</h3>
												<input type="hidden" name="groupBuyProductID"
													value="${groupVOs.groupBuyID}">
												<button class="btn fa fa-search" type="submit">查看商品
												</button>
											</div>
										</div>
									</div>
								</form>
							</div>
						</c:if>
					</c:forEach>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- Featured Product End -->

	<!-- Newsletter Start -->
	<!-- <div class="newsletter">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-6">
            <h1>Subscribe Our Newsletter</h1>
          </div>
          <div class="col-md-6">
            <div class="form">
              <input type="email" value="Your email here" />
              <button>Submit</button>
            </div>
          </div>
        </div>
      </div>
    </div> -->
	<!-- Newsletter End -->

	<!-- Recent Product Start -->
	<div class="recent-product product">
		<div class="container-fluid">
			<div class="section-header">
				<h1>Recent Product</h1>
			</div>
			<div class="row align-items-center product-slider product-slider-4">
				<div class="col-lg-3">
					<div class="product-item">
						<div class="product-title">
							<a href="#">Product Name</a>
							<div class="ratting">
								<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i>
							</div>
						</div>
						<div class="product-image">
							<a href="product-detail.html"> <img src="img/product-6.jpg"
								alt="Product Image" />
							</a>
							<div class="product-action">
								<a href="#"><i class="fa fa-cart-plus"></i></a> <a href="#"><i
									class="fa fa-heart"></i></a> <a href="#"><i
									class="fa fa-search"></i></a>
							</div>
						</div>
						<div class="product-price">
							<h3>
								<span>$</span>99
							</h3>
							<a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy
								Now</a>
						</div>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="product-item">
						<div class="product-title">
							<a href="#">Product Name</a>
							<div class="ratting">
								<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i>
							</div>
						</div>
						<div class="product-image">
							<a href="product-detail.html"> <img src="img/product-7.jpg"
								alt="Product Image" />
							</a>
							<div class="product-action">
								<a href="#"><i class="fa fa-cart-plus"></i></a> <a href="#"><i
									class="fa fa-heart"></i></a> <a href="#"><i
									class="fa fa-search"></i></a>
							</div>
						</div>
						<div class="product-price">
							<h3>
								<span>$</span>99
							</h3>
							<a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy
								Now</a>
						</div>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="product-item">
						<div class="product-title">
							<a href="#">Product Name</a>
							<div class="ratting">
								<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i>
							</div>
						</div>
						<div class="product-image">
							<a href="product-detail.html"> <img src="img/product-8.jpg"
								alt="Product Image" />
							</a>
							<div class="product-action">
								<a href="#"><i class="fa fa-cart-plus"></i></a> <a href="#"><i
									class="fa fa-heart"></i></a> <a href="#"><i
									class="fa fa-search"></i></a>
							</div>
						</div>
						<div class="product-price">
							<h3>
								<span>$</span>99
							</h3>
							<a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy
								Now</a>
						</div>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="product-item">
						<div class="product-title">
							<a href="#">Product Name</a>
							<div class="ratting">
								<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i>
							</div>
						</div>
						<div class="product-image">
							<a href="product-detail.html"> <img src="img/product-9.jpg"
								alt="Product Image" />
							</a>
							<div class="product-action">
								<a href="#"><i class="fa fa-cart-plus"></i></a> <a href="#"><i
									class="fa fa-heart"></i></a> <a href="#"><i
									class="fa fa-search"></i></a>
							</div>
						</div>
						<div class="product-price">
							<h3>
								<span>$</span>99
							</h3>
							<a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy
								Now</a>
						</div>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="product-item">
						<div class="product-title">
							<a href="#">Product Name</a>
							<div class="ratting">
								<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i>
							</div>
						</div>
						<div class="product-image">
							<a href="product-detail.html"> <img src="img/product-10.jpg"
								alt="Product Image" />
							</a>
							<div class="product-action">
								<a href="#"><i class="fa fa-cart-plus"></i></a> <a href="#"><i
									class="fa fa-heart"></i></a> <a href="#"><i
									class="fa fa-search"></i></a>
							</div>
						</div>
						<div class="product-price">
							<h3>
								<span>$</span>99
							</h3>
							<a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy
								Now</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Recent Product End -->

	<!-- Review Start -->
	
	<!-- Review End -->

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

				<!-- <div class="col-lg-3 col-md-6">
            <div class="footer-widget">
              <h2>Follow Us</h2>
              <div class="contact-info">
                <div class="social">
                  <a href=""><i class="fab fa-twitter"></i></a>
                  <a href=""><i class="fab fa-facebook-f"></i></a>
                  <a href=""><i class="fab fa-linkedin-in"></i></a>
                  <a href=""><i class="fab fa-instagram"></i></a>
                  <a href=""><i class="fab fa-youtube"></i></a>
                </div>
              </div>
            </div>
          </div> -->

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

			<!-- <div class="row payment align-items-center">
          <div class="col-md-6">
            <div class="payment-method">
              <h2>We Accept:</h2>
              <img src="img/payment-method.png" alt="Payment Method" />
            </div>
          </div>
          <div class="col-md-6">
            <div class="payment-security">
              <h2>Secured By:</h2>
              <img src="img/godaddy.svg" alt="Payment Security" />
              <img src="img/norton.svg" alt="Payment Security" />
              <img src="img/ssl.svg" alt="Payment Security" />
            </div>
          </div>
        </div> -->
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
</body>
</html>
