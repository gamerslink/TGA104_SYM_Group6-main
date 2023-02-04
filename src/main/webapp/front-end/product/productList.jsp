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
        <link href="<%=request.getContextPath()%>/front-end/product/img/logoSYM.jpg" rel="icon" />

    <!-- Google Fonts -->
    <link
      href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap"
      rel="stylesheet"
    />

    <!-- CSS Libraries -->
    <link
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
      rel="stylesheet"
    />
    <link href="<%=request.getContextPath()%>/front-end/product/lib/slick/slick.css" rel="stylesheet" />
    <link href="<%=request.getContextPath()%>/front-end/product/lib/slick/slick-theme.css" rel="stylesheet" />

    <!-- Template Stylesheet -->
    <link href="<%=request.getContextPath()%>/front-end/product/css/style.css" rel="stylesheet" />
    <link href="<%=request.getContextPath()%>/front-end/product/css/woody.css" rel="stylesheet" />
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
        <div class="
        ">
          <nav class="navbar navbar-expand-md bg-dark navbar-dark">
            <a href="#" class="navbar-brand">MENU</a>
            <button
              type="button"
              class="navbar-toggler"
              data-toggle="collapse"
              data-target="#navbarCollapse"
            >
              <span class="navbar-toggler-icon"></span>
            </button>
  
            <div
              class="collapse navbar-collapse justify-content-between"
              id="navbarCollapse"
            >
            <div class="navbar-nav mr-auto">
              <a href="<%=request.getContextPath()%>/front-end/product/index.html" class="nav-item nav-link">首頁</a>
              <a href="<%=request.getContextPath()%>/front-end/product/product-list.html" class="nav-item nav-link">我的賣場</a>
              
              <div class="nav-item dropdown">
                <a
                  href="#"
                  class="nav-link "
                  data-toggle="dropdown"
                  >客服中心</a
                >
                
                   
                </div>
              </div>
            </div>
              <div class="navbar-nav ml-auto">
                <div class="nav-item dropdown">
                  <!-- 登入前 -->
                  <a
                    href="#"
                    class="nav-link dropdown-toggle"
                    data-toggle="dropdown"
                    >
                    登入/註冊</a
                  >
                  <div class="dropdown-menu">
                    <a href="#" class="dropdown-item">登入</a>
                    <a href="#" class="dropdown-item">註冊</a>
                  </div>
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
                    <a href="<%=request.getContextPath()%>/front-end/product/index.html">
                      <img src="<%=request.getContextPath()%>/front-end/product/img/logoSYM.jpg" alt="Logo" />
                    </a>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="search">
                    <input type="text" id="PLiuQS" placeholder="商品搜尋" />
                    <button id="PliuBtn"><i class="fa fa-search"></i></button>
                  </div>
                </div>
                <div class="col-md-3">
                  <div class="user">
                    <!-- <a href="wishlist.html" class="btn wishlist">
                      <i class="fa fa-heart"></i>
                      <span>(0)</span>
                    </a> -->
                    <a href="<%=request.getContextPath()%>/front-end/product/cart.html" class="btn cart">
                      <i class="fa fa-shopping-cart"></i>
                      <span>(0)</span>
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
                        <!-- JS插入HTML -->
                     <div id="PLiuView" class="row"></div>
                        
                        <!-- Pagination Start -->
                        <div class="col-md-12">
                            <nav aria-label="Page navigation example">
                                <ul class="pagination justify-content-center">
                                    <li class="page-item disabled">
                                        <a class="page-link" href="#" tabindex="-1">上一頁</a>
                                    </li>
                                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                    <li class="page-item">
                                        <a class="page-link" href="#">下一頁</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                        <!-- Pagination Start -->
                    </div>           
                    
                    <!-- Side Bar Start -->
                    <div class="col-lg-4 sidebar">
                        <div class="sidebar-widget 類別">
                            <h2 class="title">類別</h2>
                            <nav class="navbar bg-light">
                                <ul class="navbar-nav">
                                    <li class="nav-item">
                                        <a class="nav-link" href="#"><i class="fa fa-female"></i>時尚與美容</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#"><i class="fa fa-child"></i>兒童與嬰兒服裝</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#"><i class="fa fa-tshirt"></i>男女裝</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#"><i class="fa fa-mobile-alt"></i>小工具和配件</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#"><i class="fa fa-microchip"></i>電子產品及配件</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                        
                        <div class="sidebar-widget widget-slider">
                            <div class="sidebar-slider normal-slider">
                                <div class="product-item">
                                    <div class="product-title">
                                        <a href="#">商品名稱</a>
                                        <div class="ratting">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="商品圖片">
                                        <a href="<%=request.getContextPath()%>/front-end/product/product-detail.html">
                                            <img src="<%=request.getContextPath()%>/front-end/product/img/product-10.jpg" alt="商品圖片">
                                        </a>
                                        <div class="product-action">
                                            <a href="#"><i class="fa fa-加入購物車"></i></a>
                                            <a href="#"><i class="fa fa-我的最愛"></i></a>
                                            <a href="#"><i class="fa fa-搜尋"></i></a>
                                        </div>
                                    </div>
                                    <div class="商品價格">
                                        <h3><span>$</span>99</h3>
                                        <a class="btn" href=""><i class="fa fa-購物車"></i>直接購買</a>
                                    </div>
                                </div>
                                <div class="product-item">
                                    <div class="product-title">
                                        <a href="#">商品名稱</a>
                                        <div class="ratting">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="商品圖片">
                                        <a href="<%=request.getContextPath()%>/front-end/product/product-detail.html">
                                            <img src="<%=request.getContextPath()%>/front-end/product/img/product-9.jpg" alt="商品圖片">
                                        </a>
                                        <div class="product-action">
                                            <a href="#"><i class="fa fa-加入購物車"></i></a>
                                            <a href="#"><i class="fa fa-我的最愛"></i></a>
                                            <a href="#"><i class="fa fa-搜尋"></i></a>
                                        </div>
                                    </div>
                                    <div class="商品價格">
                                        <h3><span>$</span>99</h3>
                                        <a class="btn" href=""><i class="fa fa-購物車"></i>直接購買</a>
                                    </div>
                                </div>
                                <div class="product-item">
                                    <div class="product-title">
                                        <a href="#">商品名稱</a>
                                        <div class="ratting">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="商品圖片">
                                        <a href="<%=request.getContextPath()%>/front-end/product/product-detail.html">
                                            <img src="<%=request.getContextPath()%>/front-end/product/img/product-8.jpg" alt="商品圖片">
                                        </a>
                                        <div class="product-action">
                                            <a href="#"><i class="fa fa-加入購物車"></i></a>
                                            <a href="#"><i class="fa fa-我的最愛"></i></a>
                                            <a href="#"><i class="fa fa-搜尋"></i></a>
                                        </div>
                                    </div>
                                    <div class="商品價格">
                                        <h3><span>$</span>99</h3>
                                        <a class="btn" href=""><i class="fa fa-購物車"></i>直接購買</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="sidebar-widget tag">
                            <h2 class="title">標籤</h2>
                            <a href="#">手機</a>
                            <a href="#">褲子</a>
                            <a href="#">電動</a>
                            <a href="#">3C</a>
                            <a href="#">生活用品</a>
                            <a href="#">兒童</a>
                            <a href="#">公仔</a>
                            <a href="#">滑鼠</a>
                            <a href="#">鞋子</a>
                            <a href="#">籃球</a>
                            <a href="#">顯示卡</a>
                            <a href="#">泡麵</a>
                        </div>
                    </div>
                    <!-- Side Bar End -->
                </div>
            </div>
        </div>
        <!-- Product List End -->  
        
        <!-- Brand Start -->
        <div class="brand">
            <div class="container-fluid">
                <div class="brand-slider">
                    <div class="brand-item"><img src="<%=request.getContextPath()%>/front-end/product/img/brand-1.png" alt=""></div>
                    <div class="brand-item"><img src="<%=request.getContextPath()%>/front-end/product/img/brand-2.png" alt=""></div>
                    <div class="brand-item"><img src="<%=request.getContextPath()%>/front-end/product/img/brand-3.png" alt=""></div>
                    <div class="brand-item"><img src="<%=request.getContextPath()%>/front-end/product/img/brand-4.png" alt=""></div>
                    <div class="brand-item"><img src="<%=request.getContextPath()%>/front-end/product/img/brand-5.png" alt=""></div>
                    <div class="brand-item"><img src="<%=request.getContextPath()%>/front-end/product/img/brand-6.png" alt=""></div>
                </div>
            </div>
        </div>
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
                      <p><i class="fa fa-map-marker"></i>台北商業大學</p>
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
                  <p>Copyright &copy; <a href="#">SYM</a>. All Rights Reserved</p>
                </div>
      
                <div class="col-md-6 template-by">
                  <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                  <!-- <p>Designed By <a href="https://htmlcodex.com">HTML Codex</a></p> -->
                </div>
              </div>
            </div>
        <!-- Footer Bottom End -->       
        
        <!-- Back to Top -->
        <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
        
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="<%=request.getContextPath()%>/front-end/product/lib/easing/easing.min.js"></script>
        <script src="<%=request.getContextPath()%>/front-end/product/lib/slick/slick.min.js"></script>
        
        <!-- Template Javascript -->
        <script src="<%=request.getContextPath()%>/front-end/product/js/main.js"></script>
        <script>
			let fakeData = [
				{
					productName: '低價位',
					price: 55
				},
				{
					productName: '中間價位',
					price: 80
				},
				{
					productName: '較高價位',
					price: 100
				}
			]

			// 根據價格由高到低來排列 fakeData
			let sortDataByPriceDescend = function(){
				// 參考: https://developer.mozilla.org/zh-TW/docs/Web/JavaScript/Reference/Global_Objects/Array/sort
				fakeData.sort(
					function(elem_a,elem_b){
						if(elem_a.price > elem_b.price){
							// a 比 b 還要大, 所以我們要 a 在前面, return -1
							return -1;
						}else if (elem_a.price < elem_b.price){
							// b 比 a 還要大, 那我們要 b 在前面, return 1
							return 1;
						}else{
							return 0
						}
					}
				);
			}

			// 根據某種條件來過濾 fakeData
			let filterDataByPrice = function(){
				// 參考: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/filter
				fakeData = fakeData.filter(
					function(elem){
						if(elem.price >= 80){
							// 如果價格比80還要大, 我們就留著
							return true;
						}
					}
				);
			}

			// 根據fakeData中的資料建立html elemets, 然後插入頁面
			let l_insertData = function(){
				//找到正確的parent element
				let parentElement = document.getElementsByClassName('product-view')[0]
											.getElementsByClassName('container-fluid')[0]
											.getElementsByClassName('row')[0]
											.getElementsByClassName('col-lg-8')[0]
											.getElementsByClassName('row')[0];

				for(let i = 0 ; i < fakeData.length; i++){
					let pItem = l_createProductItem(fakeData[i]);
					parentElement.append(pItem);
				}
			}

			let l_clearProductData = function(){
				//找到正確的parent element
				let parentElement = document.getElementsByClassName('product-view')[0]
											.getElementsByClassName('container-fluid')[0]
											.getElementsByClassName('row')[0]
											.getElementsByClassName('col-lg-8')[0]
											.getElementsByClassName('row')[0];
				let productItems = parentElement.getElementsByClassName('col-md-4');
				for(let i = 0 ; i < productItems.length; ){
					productItems[i].remove();
				}
			}
			
			// 建立商品的element
			let l_createProductItem = function(data){
				// 以下代碼是根據原有的html建立出來的:
				// 範本:
					// 	<div class="col-md-4">
					// 	<div class="product-item">
					// 		<div class="product-title">
					// 			<a href="#">商品名稱</a>
					// 			<div class="ratting">
					// 				<i class="fa fa-star"></i> 
					// 				<i class="fa fa-star"></i> 
					// 				<i class="fa fa-star"></i> 
					// 				<i class="fa fa-star"></i> 
					// 				<i class="fa fa-star"></i>
					// 			</div>
					// 		</div>
					// 		<div class="商品圖片">
					// 			<a href="<%=request.getContextPath()%>/front-end/product/productDetail.jsp">
					// 				<img
					// 					src="<%=request.getContextPath()%>/front-end/product/img/product-1.jpg"
					// 					alt="商品圖片">
					// 			</a>
					// 			<div class="product-action">
					// 				<a href="#"><i class="fa fa-加入購物車"></i></a> 
					// 				<a href="#"><i class="fa fa-我的最愛"></i></a> 
					// 				<a href="#"><i class="fa fa-搜尋"></i></a>
					// 			</div>
					// 		</div>
					// 		<div class="商品價格">
					// 			<h3>
					// 				<span>$</span>99
					// 			</h3>
					// 			<a class="btn" href=""><i class="fa fa-購物車"></i>直接購買</a>
					// 		</div>
					// 	</div>
					// </div>

				let col_md_4 = document.createElement('div');
				col_md_4.className = 'col-md-4';

				let productItem = document.createElement('div');
				productItem.className = 'product-item';

				// 商品標題
				let productTitle = document.createElement('div');
				productTitle.className = 'product-title';

				let productName = document.createElement('a');
				productName.innerHTML =  data.productName;
				productName.href = '#';

				let ratting = document.createElement('div');
				ratting.className = 'ratting';

				for(let i = 0 ; i < 5 ; i ++){
					let star = document.createElement('i');
					star.className = 'fa fa-star';
					ratting.append(star)
				}

				productTitle.append(productName);
				productTitle.append(ratting);

				// 商品圖片
				let productImage = document.createElement('div');
				productImage.heigh='200px';
				productImage.className = 'product-image';

				let image_a = document.createElement('a');
				image_a.href = "<%=request.getContextPath()%>/front-end/product/productDetail.jsp";

				let imgTag = document.createElement('img');
				imgTag.src = "${pageContext.request.contextPath}/product/picServlet?productID="+data.productID;
				imgTag.alt = '商品圖片';
				imgTag.heigh='100%';
				imgTag.width='100%';
				image_a.append(imgTag);

				let productAction = document.createElement('product-action');
				productAction.class = 'product-action';

				let cart_a = document.createElement('a');
				cart_a.href = '#';
				let cart_i = document.createElement('i');
				cart_i.className='fa fa-加入購物車';
				cart_a.append(cart_i);

				let favorite_a = document.createElement('a');
				favorite_a.href = '#';
				let favorite_i = document.createElement('i');
				favorite_i.className='fa fa-我的最愛';
				favorite_a.append(favorite_i);

				let search_a = document.createElement('a');
				search_a.href = '#';
				let search_i = document.createElement('i');
				search_i.className='fa fa-搜尋';
				search_a.append(search_i);

				productAction.append(cart_a);
				productAction.append(favorite_a);
				productAction.append(search_a);

				productImage.append(image_a);
				productImage.append(productAction);

				// 商品價格
				let priceDiv = document.createElement('div');
				priceDiv.className = 'product-price';

				let price_h3 = document.createElement('h3');
				price_h3.innerHTML = '<span>$</span>' + data.productPrice;

				let btn_a = document.createElement('a');
				btn_a.className = 'btn';
				btn_a.href = '';

				let btn_i = document.createElement('i');
				btn_i.className = 'fa fa-購物車';

				btn_a.append(btn_i);
				btn_a.append('直接購買');
				

				priceDiv.append(price_h3);
				priceDiv.append(btn_a);

				// 最後組合
				productItem.append(productTitle);
				productItem.append(productImage);
				productItem.append(priceDiv);

				col_md_4.append(productItem);
				return col_md_4;
			}

            const init =  () => {
            	const qs = document.getElementById("PLiuQS");
            	const plView = document.getElementById("PLiuView");
            	console.log(qs.value);
            	console.log(plView);
                const URL = 'http://localhost:8080/TGA104_SYM_Group6/product/productSearchLiu?productName='+qs.value;
                fetch(URL).then((r)=>r.json()).then((data)=>{
                    fakeData = data
                    plView.innerHTML = '';
                    l_insertData()
                })
            }
            const qs = document.getElementById("PliuBtn");


            qs.onclick = init
		</script>
    </body>
</html>