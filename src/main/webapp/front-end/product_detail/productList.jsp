<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>SYM商品頁</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="eCommerce HTML Template Free Download" name="keywords">
<meta content="eCommerce HTML Template Free Download" name="description">

<!-- Favicon -->
<link href="./img/logoSYM.jpg" rel="icon" />

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
<link href="${pageContext.request.contextPath}/front-end/product_detail/css/style.css" rel="stylesheet" />
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
						<a href="${pageContext.request.contextPath}/"> <img src="./img/logoSYM.jpg" alt="Logo" />
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

	<!-- Breadcrumb Start -->
	<div class="breadcrumb-wrap">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">首頁</a></li>
				<li class="breadcrumb-item"><a href="#">商品</a></li>
				<li class="breadcrumb-item active">商品瀏覽</li>
			</ul>
		</div>
	</div>
	<!-- Breadcrumb End -->

	<!-- Product List Start -->
	<div class="product-view">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-8">
					<div class="row">
						<div class="col-md-12">
							<div class="product-view-top">
								<div class="row">

									<div class="col-md-4">
										<div class="商品順序">
											<div class="dropdown">
												<form>
													<div class="dropdown-toggle" data-toggle="dropdown">商品價格順序</div>
													<div class="dropdown-menu dropdown-menu-right">
														<a
															href="${pageContext.request.contextPath}/sortbyPrice?action=sort_price"
															class="dropdown-item">價格(由低至高)</a> <a
															href="${pageContext.request.contextPath}/sortbyPrice?action=sort_price_reverse"
															class="dropdown-item">價格(由高至低)</a>

													</div>
												</form>
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="商品價格範圍">
											<div class="dropdown">
												<div class="dropdown-toggle" data-toggle="dropdown">商品價格範圍</div>
												<div class="dropdown-menu dropdown-menu-right">
													<a
														href="${pageContext.request.contextPath}/sortbyPrice?action=sort_0"
														class="dropdown-item">全部</a> <a
														href="${pageContext.request.contextPath}/sortbyPrice?action=sort_0_1000"
														class="dropdown-item">$0 to $1000</a> <a
														href="${pageContext.request.contextPath}/sortbyPrice?action=sort_1000_5000"
														class="dropdown-item">$1000 to $5000</a> <a
														href="${pageContext.request.contextPath}/sortbyPrice?action=sort_5000_10000"
														class="dropdown-item">$5000 to $10000</a> <a
														href="${pageContext.request.contextPath}/sortbyPrice?action=sort_10000"
														class="dropdown-item">$10000以上</a>

												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<c:forEach var="categoryVO" items="${categoryVOall}">
							<div class="col-md-4">
								<div class="product-item">
									<div class="product-title" style="height:80px;" >
										<a href="#">${categoryVO.productName}</a>
									<div class="ratting">
										
									</div>
									</div>
									<div class="product-image">
										<a
											href="<%=request.getContextPath()%>/front-end/product/product-detail.html">
											<img
											src="${pageContext.request.contextPath}/product/picServlet?productID=${categoryVO.productID}"
											style="width: 230px; height: 200px" alt="Product Image">
										</a>
								<!-- 		<div class="product-action">
											<a href="#"><i class="fa fa-加入購物車"></i></a> <a href="#"><i
												class="fa fa-我的最愛"></i></a> <a href="#"><i class="fa fa-搜尋"></i></a>
										</div> -->
									</div>
									<div class="product-price">
										<h4 style="text-align:center">
											<span>$</span>${categoryVO.productPrice}</h4>
												
												<a class="btn" href="${pageContext.request.contextPath}
													/SearchServlet?action=getOne_For_Display&productID=${categoryVO.productID}
														&productMainID=${categoryVO.productMainID}&storeID=${categoryVO.storeID}">
												<i class="fa fa-shopping-cart"></i>查看</a>
								
									</div>
								</div>
							</div>
						</c:forEach>


					</div>

					<!-- Pagination Start -->
					<div class="col-md-12">
						<nav aria-label="Page navigation example">
							<ul class="pagination justify-content-center">
								<li class="page-item disabled"><a class="page-link"
									href="#" tabindex="-1">上一頁</a></li>
								<li class="page-item active"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#">下一頁</a>
								</li>
							</ul>
						</nav>
					</div>
					<!-- Pagination Start -->
				</div>

				<!-- Side Bar Start -->
				<div class="col-lg-4 sidebar">
					<div class="sidebar-widget category">
						<h2 class="title">類別</h2>
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
									class="fas fa-tshirt"></i>男/女衣著</a></li>
							<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/SearchServlet?productMainID=1&action=category"><i
									class="fas fa-mobile-alt"></i>3C與電腦</a></li>
							<li class="nav-item"><a class="nav-link" href="#"><i
									class="fa fa-microchip"></i>家電影音</a></li> 
							</ul>
						</nav>
					</div>
					<br>
					<div class="sidebar-widget widget-slider">
					<br>
					<h2 class="title">好物推薦</h2>
					<c:if test="${categoryOther==null}">
							<script type="text/javascript">
								document.getElementsByClassName('title')[1].style.display = 'none';
							
							</script>
						
						
						</c:if>
						<div class="sidebar-slider normal-slider">
							<c:forEach var="categoryVO" items="${categoryOther}">
					
								<div class="product-item">
									<div class="product-title">
										<a href="#">${categoryVO.productName}</a>
								<!-- 		<div class="ratting">
											<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i>
										</div> -->
									</div>
									<div class="商品圖片">
										<a
											href="<%=request.getContextPath()%>/front-end/product/product-detail.html">
											<img
											src="${pageContext.request.contextPath}/product/picServlet?productID=${categoryVO.productID}"
											style="width: 230px; height: 200px" alt="Product Image">
										</a>
										<div class="product-action">
											<a href="#"><i class="fa fa-加入購物車"></i></a> <a href="#"><i
												class="fa fa-我的最愛"></i></a> <a href="#"><i class="fa fa-搜尋"></i></a>
										</div>
									</div>
									<div class="商品價格">
										<h3>
											<span>$</span>${categoryVO.productPrice}</h3>
									<a class="btn"
												href="${pageContext.request.contextPath}
													/SearchServlet?action=getOne_For_Display&productID=${categoryVO.productID}
														&productMainID=${categoryVO.productMainID}&storeID=${categoryVO.storeID}"><i
												class="fa fa-shopping-cart"></i>查看</a>
		
									</div>
								</div>
							
						</c:forEach>
						</div>
					</div>
			

					<div class="sidebar-widget tag">
						<h2 class="title">標籤</h2>
						<a href="#">手機</a> <a href="#">褲子</a> <a href="#">電動</a> <a
							href="#">3C</a> <a href="#">生活用品</a> <a href="#">兒童</a> <a
							href="#">公仔</a> <a href="#">滑鼠</a> <a href="#">鞋子</a> <a href="#">籃球</a>
						<a href="#">顯示卡</a> <a href="#">泡麵</a>
					</div>
				</div>
				<!-- Side Bar End -->
			</div>
		</div>
	</div>
	<!-- Product List End -->

	<!-- Brand Start -->
	
	<!-- Brand End -->

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
		<!-- Footer Bottom End -->

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
		
		<script>
			
		
		var fa = document.getElementsByClassName("fa fa-star");
		var previewing = Number(document.getElementById('previewing').innerHTML);
		var fahalf = document.getElementsByClassName("fa fa-star-half-o");
		var faempty = document.getElementsByClassName("fa fa-star-o");
		
		document.addEventListener("DOMContentLoaded", function(){	
		for(var i=0 ; i < ${categoryVOall.size()} ; i++) {
	if(previewing == 0){				
		document.getElementById('previewing').innerHTML = '尚無評價';
		
    }else if(previewing >= 1 && previewing < 1.5){
		fa[i*5].style.display = 'inline';						
		faempty[i*5].style.display = 'inline';						
		faempty[i*5+1].style.display = 'inline';						
		faempty[i*5+2].style.display = 'inline';						
		faempty[i*5+3].style.display = 'inline';						
	} else if (previewing >= 1.5 && previewing < 2){
		fa[i*5].style.display = 'inline';
		fahalf[i*5].style.display = 'inline';
		faempty[i*5].style.display = 'inline';
		faempty[i*5+1].style.display = 'inline';
		faempty[i*5+2].style.display = 'inline';
		
	} else if(previewing >= 2 && previewing < 2.5){
		fa[i*5].style.display = 'inline';	
		fa[i*5+1].style.display = 'inline';	
		faempty[i*5].style.display = 'inline';	
		faempty[i*5+1].style.display = 'inline';	
		faempty[i*5+2].style.display = 'inline';	
	} else if(previewing >= 2.5 && previewing < 3){
		fa[i*5].style.display = 'inline';	
		fa[i*5+1].style.display = 'inline';	
		fahalf[i*5+1].style.display = 'inline';
		faempty[i*5].style.display = 'inline';
		faempty[i*5+1].style.display = 'inline';
	} else if(previewing >= 3 && previewing < 3.5){
		fa[i*5].style.display = 'inline';	
		fa[i*5+1].style.display = 'inline';	
		fa[i*5+2].style.display = 'inline';	
		faempty[i*5].style.display = 'inline';	
		faempty[i*5+1].style.display = 'inline';	
	} else if(previewing >= 3.5 && previewing < 4){
		fa[i*5].style.display = 'inline';	
		fa[i*5+1].style.display = 'inline';	
		fa[i*5+2].style.display = 'inline';	
		fahalf[i*5+2].style.display = 'inline';
		faempty[i*5].style.display = 'inline';
	} else if(previewing >= 4 && previewing <= 4.5){
		fa[i*5].style.display = 'inline';	
		fa[i*5+1].style.display = 'inline';	
		fa[i*5+2].style.display = 'inline';	
		fa[i*5+3].style.display = 'inline';	
		faempty[i*5].style.display = 'inline';	
	} else if(previewing >= 4.5 && previewing < 5){
		fa[i*5].style.display = 'inline';	
		fa[i*5+1].style.display = 'inline';	
		fa[i*5+2].style.display = 'inline';	
		fa[i*5+3].style.display = 'inline';	
		fahalf[i*5+3].style.display = 'inline';
	} else if(previewing == 5){
		fa[i*5].style.display = 'inline';	
		fa[i*5+1].style.display = 'inline';	
		fa[i*5+2].style.display = 'inline';	
		fa[i*5+3].style.display = 'inline';	
		fa[i*5+4].style.display = 'inline';	
	}
		}
		});
		
		
		</script>
</body>
</html>