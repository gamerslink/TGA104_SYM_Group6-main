<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>E Store - eCommerce HTML Template</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="eCommerce HTML Template Free Download" name="keywords" />
<meta content="eCommerce HTML Template Free Download" name="description" />

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon" />

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
	href="${pageContext.request.contextPath}/front-end/store/lib/slick/slick.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/store/lib/slick/slick-theme.css"
	rel="stylesheet" />

<!-- Template Stylesheet -->
<link
	href="${pageContext.request.contextPath}/front-end/store/css/style.css"
	rel="stylesheet" />
<script src="${pageContext.request.contextPath}/JQ/jquery-3.6.1.min.js"></script>


<!-- 企鵝開始 -->
<script src="${pageContext.request.contextPath}/JQ/jquery-3.6.1.min.js"></script>
<script>
	$(function() {
		var template = 
		`	<!-- Product List Start -->
        <div class="product-view">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="row">
                            
		`;
		
		var str=``;
		function aaa(data){
			str=``;
			for(let i=0;i<data.length;i++){
				let templateList =   `
					<div class="col-md-4">
                    <div class="product-item">
                        <div class="product-title">
                            <a href="#">`+data[i].productName+`</a>
                            <div class="ratting">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                        </div>
                        <div class="product-image">
                            <a href="product-detail.html">
                            <img src="${pageContext.request.contextPath}/product/picServlet?productID=`+data[i].productID+`"
        						alt="沒有圖片" width="100" height="100">
                            </a>
                            <div class="product-action">
                                <a href="#"><i class="fa fa-cart-plus"></i></a>
                                <a href="#"><i class="fa fa-heart"></i></a>
                                <a href="#"><i class="fa fa-search"></i></a>
                            </div>
                        </div>
                        <div class="product-price">
                            <h3>`+data[i].productPrice+`</h3>
                            <a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy Now</a>
                        </div>
                    </div>
                </div>
				`;
				str = str + templateList;
			}
		}
		var str2=`</div>`;
		
		let functionx = function() {
			$
			.ajax({
				url : "${pageContext.request.contextPath}/product/productSearchProduct/getAll_By_Cond?storeID="+$("#psStoreID").val()+"&productStatus=1", // 資料請求的網址
				type : "GET", // GET | POST | PUT | DELETE | PATCH
				dataType : "json", // 預期會接收到回傳資料的格式： json | xml | html
				success : function(data) {
					// request 成功取得回應後執行
					//console.log(data);
					aaa(data);
					//console.log(str);
					//console.log(data[0].productID+"哭啊");
					console.log(data.length);
					$("#searchRes").html(template+str+str2);
				},
				error : function(XMLHttpRequest) {
					if (XMLHttpRequest.status >= 400) {
						alert("出現錯誤");
					}
				}
			});
		}
		functionx();
		$("#btnSearchAll").click(functionx);
	});
</script>
<!-- 企鵝結束 -->
</head>

<body>
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
							href="${pageContext.request.contextPath}/front-end/member/my-account.jsp"
							class="nav-item nav-link">買家中心</a>

						<div class="nav-item dropdown">
							<a href="#" class="nav-link " data-toggle="dropdown">客服中心</a>
						</div>
					</div>
				</div>
				<div class="navbar-nav ml-auto">
					<div class="nav-item dropdown">

						<a href="my-account.html" class="nav-link dropdown-toggle"
							data-toggle="dropdown"> <img class="rounded-circle "
							src="${pageContext.request.contextPath}/member/DBGifReader?memberID=${memVO.memberID}"
							alt="" style="width: 40px; height: 40px" /> ${memVO.userName}
						</a>
						<div class="dropdown-menu">
							<a
								href="${pageContext.request.contextPath}/front-end/member/my-account.jsp"
								class="dropdown-item">我的帳號</a>
							<FORM METHOD="post"
								ACTION="<%=request.getContextPath()%>/member/MemberServlet">
								<input type="hidden" name="action" value="getOne_For_LogOut">
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
						<a href="index.html"> <img src="./img/logoSYM.jpg" alt="Logo" />
						</a>
					</div>
				</div>
				<div class="col-md-6">
					<div class="search">
						<input id="btnSearchAll" type="text" placeholder="商品搜尋" />
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
	<input type="hidden" id="psStoreID" value="${storeVO.storeID}">
	<!-- Contact Start -->
	<div class="contact">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-6">
					<div class="contact-info">
						<h2>${storeVO.storeName}</h2>
						<h2><img src="${pageContext.request.contextPath}/store/storePic?storeID=${storeVO.storeID}"
        						alt="沒有圖片" width="400" height="200"></h2>
					</div>
				</div>
				<div class="col-lg-6	">
					<div class="contact-info">
						<h2>賣場資訊</h2>
						<h3>
							<i class="fa fa-map-marker"></i>${storeVO.storeAddress}
						</h3>
						<h3>
							<i class="fa fa-phone"></i>${storeVO.phoneNumber}
						</h3>
						<h3>加入時間: ${storeVO.createDate}</h3>
						<div class="social">
							<a href=""><i class="fab fa-twitter"></i></a> <a href=""><i
								class="fab fa-facebook-f"></i></a> <a href=""><i
								class="fab fa-linkedin-in"></i></a> <a href=""><i
								class="fab fa-instagram"></i></a> <a href=""><i
								class="fab fa-youtube"></i></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Contact End -->
	<div id="searchRes"></div>


	<%@ include file="Footer.jsp"%>

	<!-- Back to Top -->
	<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/front-end/store/lib/easing/easing.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/front-end/store/lib/slick/slick.min.js"></script>

	<!-- Template Javascript -->
	<script
		src="${pageContext.request.contextPath}/front-end/store/js/main.js"></script>
</body>
</html>