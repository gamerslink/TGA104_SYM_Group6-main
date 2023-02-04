<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page
	import="java.util.* ,com.group6.tibame104.orderlist.model.Product, com.group6.tibame104.member.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>


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

	<link rel="stylesheet" type="text/css"
		href="<%=request.getContextPath()%>/front-end/shop/css/ShoppingCart.css">
	<%
	@SuppressWarnings("unchecked")

	Map<Integer, List<Product>> check = (Map<Integer, List<Product>>) session.getAttribute("check");
	%>


	<%
	if (!check.isEmpty() && (check.size() > 0)) {
	%>

	

	
	<form id="checkoutForm" action="ShopServlet" method="POST">
		<%
	Set<Integer> set = check.keySet();
	Iterator<Integer> it = set.iterator();
	int count =0;
	while (it.hasNext()) {

	Integer storeID = it.next();
	List<Product> buylist = check.get(storeID);
	%>
		<p id='size<%=storeID%>' style='visibility: hidden'><%=buylist.size()%></p>
		
	
		<table id="table-1" class="table<%=storeID%>" border="1">
			<tr>
				<td width="140" colspan="6"><font size="4">賣場: <%=buylist.get(0).getStoreName()%></font></td>

			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td ></td>
			</tr>
			<tr>
				<td ></td>
			</tr>
			<tr>
				<td ></td>
			</tr>
			<tr>
				<td width="95">全選<input type="checkbox" class="checkcount"
					id="checktotal<%=storeID%>" /></td>
				<td width="155">商品名稱</td>
				<td width="165">商品圖片</td>
				<td width="125">價格</td>

				<td width="105">數量</td>
				<td width="130">小計</td>

			</tr>
		</table>

		<table class="table<%=storeID%>">
			<%
	for (int index = 0; index < buylist.size(); index++) {
		Product order = buylist.get(index);
	%>

			<tr class="my-car-tr<%=1 + count%>">
				<td width="125"><input type="checkbox" name="check<%=storeID%><%=index%>" value='0' class="checksub<%=storeID%>"/></td>
				<td width="160"><%=order.getName()%></td>
				<td width="120"><img
					src="${pageContext.request.contextPath}/product/picServlet?productID=<%=order.getProductID()%>"
					style="width: 140px; height: 120px" alt="Product Image"></td>
				<td width="135"><%=order.getPrice()%></td>


				<td id="minus"><input id="minus1" type="button" name='clickbutton'
					onclick="minuser<%=1 + count%>()" value="-"
					style="width: 25px; height: 29px;" /></td>

				<td id="<%=1 + count%>" width="30"><%=order.getQuantity()%></td>
				<input type="hidden"
					id="product<%=order.getStoreName() %><%=index%>"
					name="product<%=order.getStoreID() %><%=index%>"
					value="<%=order.getQuantity()%>" />

				<td id="plus"><input id="plus1" type="button" name='clickbutton'
					onclick="adder<%=1 + count%>()" value="+"
					style="width: 25px; height: 29px;" /></td>

				<td class="my-car-td<%=storeID%>" width="130" align="center"
					valign="middle" id="<%=- 1 - count%>"><%=order.getPrice() * order.getQuantity()%></td>
			</tr>



			<script src="./jquery/jquery-3.6.1.min.js"></script>
<script>
	   
		
		function adder<%=1 + count%>() {
			var count = document.getElementById("<%=1 + count%>").innerHTML;
			var sum = document.getElementById("<%=- 1 - count%>").innerHTML;
			count = parseInt(count) + 1;
			sum = <%=order.getPrice()%> * count;
			document.getElementById("<%=1 + count%>").innerHTML = count;
			document.getElementById("<%=- 1 - count%>").innerHTML = sum;
			
			add<%=storeID%>();
			
			
			
			
		}
		
		var size<%=storeID%> = document.getElementById('size<%=storeID%>');
		var sizecount<%=storeID%> = <%=buylist.size()%>;
		var table<%=storeID%> =	document.getElementsByClassName('table<%=storeID%>');
		
		function minuser<%=1 + count%>() {
			var count = document.getElementById("<%=1 + count%>").innerHTML;
			var sum = document.getElementById("<%=-1 - count%>").innerHTML;
			if (count <= 1 && confirm("確認要刪除此商品嗎?")==true) {
				
				document.getElementsByName("check<%=storeID%><%=index%>")[0].value = '0';
				document.getElementsByName("check<%=storeID%><%=index%>")[0].checked = '';
					document.getElementsByClassName("my-car-tr<%=1 + count%>")[0].style.display='none';
					
					
				
				sizecount<%=storeID%> -= 1 ;
				size<%=storeID%>.innerHTML = sizecount<%=storeID%>;
					if(size<%=storeID%>.innerHTML == '0'){
						table<%=storeID%>[0].style.display='none';
						table<%=storeID%>[1].style.display='none';
					document.getElementsByClassName('my-car-total<%=storeID%>')[0].style.display= 'none';
					document.getElementsByClassName('my-car-total<%=storeID%>')[0].innerHTML= '0';
					size<%=storeID%>.remove();
						
					}
					

			} else if(count>1) {
				count = parseInt(count) - 1;
				sum = <%=order.getPrice()%> * count;
				document.getElementById("<%=1 + count%>").innerHTML = count;
			    document.getElementById("<%=- 1 - count%>").innerHTML = sum;
				
			}
		
			add<%=storeID%>();
		

		}
	
	</script>






			<%
	count = count +10000;
	}
	%>
<tr class="my-car-total<%=storeID%>">
			<td colspan="3" style="text-align: right"></td>
			<td colspan="5" style="text-align: right">總金額:<b
				class = 'countingmoney' id="count<%=storeID%>">0</b></td>
	
</tr>

		</table>


		<script>
			
function add<%=storeID%>(){
			var count = document.querySelector('#count<%=storeID%>');
			let total = 0;
			var mount = document.querySelectorAll('.my-car-td<%=storeID%>').length;
			var test<%=storeID%> = 0;
			
			for(var i=0 ; i<mount ; i++){ 
				if(document.getElementsByName('check<%=storeID%>'+ i)[0].checked ) {
					total += parseInt(document.querySelectorAll('.my-car-td<%=storeID%>')[i].textContent,10);
					test<%=storeID%>++;
					
				} 
					count.innerHTML =  total;
			}
			
	
			
			
			if(test<%=storeID%> == 0){
				count.innerHTML = '0';
			}
			
			
			
			
				
		};
		
		

		
	
		
		add<%=storeID%>();
		
		
		
		var checktotal<%=storeID%> = document.getElementById('checktotal<%=storeID%>');
		
		var check<%=storeID%> = document.getElementsByClassName('checksub<%=storeID%>');
		var counting<%=storeID%>=0;
		
		checktotal<%=storeID%>.addEventListener('change', (event) => {
		
		        if (event.currentTarget.checked) {
		        	
		        	checktotal<%=storeID%>.value = "1";
		        	
		        	for( var i=0 ; i < check<%=storeID%>.length ; i++){
		        		document.getElementsByName('check<%=storeID%>'+i)[0].checked="true";
		        		document.getElementsByName('check<%=storeID%>'+i)[0].value="1";
		        		
		        	}
		          
		        } else {
		        	
					checktotal<%=storeID%>.value = "0";
		        	
					for( var i=0 ; i < check<%=storeID%>.length ; i++){
						document.getElementsByName('check<%=storeID%>'+i)[0].checked="";
						document.getElementsByName('check<%=storeID%>'+i)[0].value="0";
		        	}
	
		        }
		        add<%=storeID%>();
		    
		});
		
	for( var i=0 ; i < check<%=storeID%>.length ; i++){
		(function(i){
			document.getElementsByName('check<%=storeID%>'+i)[0].addEventListener('change', (event) => {
				 if (event.currentTarget.checked) {
			        		
					 document.getElementsByName('check<%=storeID%>'+i)[0].value="1";
			        counting<%=storeID%>++;
			        		
			      } else {

			    	  document.getElementsByName('check<%=storeID%>'+i)[0].value="0";
							counting<%=storeID%>--;
							
			        }
				  
				 if(counting<%=storeID%> == check<%=storeID%>.length ){
					 checktotal<%=storeID%>.value = "1";
					 checktotal<%=storeID%>.checked = "true";
				 } else{
					 checktotal<%=storeID%>.value = "0";
					 checktotal<%=storeID%>.checked = "";
				 }
				 add<%=storeID%>();
			});
		})(i);
		
		
	}
	
	

		
		
	</script>




		<%
		}
		%>
		<table>
			<tr>
				<td colspan="6" style="text-align: right ; background-color: #FFFBE3">
			 		 <b style='font-size: 20px;'>訂單總金額 :</b> &emsp;<b id='ordertotal' style='font-size: 20px;'>0</b>
					&emsp; 
			 		<input type="hidden" name="action" value="CHECK"> <input
					type="hidden" name="memberID" value="${memVO.memberID}"> <input
					type="hidden" name="userAccount" value="${memVO.userAccount}">
					<input type="submit" value="送出" class="button" style='background-color: #FFA9A9 ; border:0px ; font-weight:bold'>
			
			    </td>
		
		</table>
		
  <br>


		
	</form>


	<%
	}
	%>

<script>
var node_list = document.getElementsByTagName('input');

for (var i = 0; i < node_list.length; i++) {
    var node = node_list[i];
 
    if (node.getAttribute('type') == 'checkbox'  ) {
        countsum(node, 'change');
    }  else if(node.getAttribute('type') == 'button'){
    	countsum(node, 'click');
    }
} 
	
	var clickbutton = document.getElementsByName('clickbutton');
	var checkcount = document.getElementsByClassName('checkcount');
	

	
	function countsum(a, event){
	
		a.addEventListener(event, function(){
			var countingmoney = document.getElementsByClassName('countingmoney');
			var ordertotal = document.getElementById('ordertotal');
			var countingtotal = 0;
			
			for(var i=0 ; i < countingmoney.length ; i++ ){
				countingtotal += Number(countingmoney[i].innerHTML);
	       }
			
			ordertotal.innerHTML = countingtotal;
		})
	}
	
	


</script>








	<!-- Bottom Bar Start -->


	<!-- Bottom Bar End -->

	<!-- Breadcrumb Start -->

	<!-- Breadcrumb End -->

	<!-- My Account Start -->



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



	<link rel="stylesheet" type="text/css"
		href="<%=request.getContextPath()%>/front-end/order/datetimepicker/jquery.datetimepicker.css" />
	<script
		src="<%=request.getContextPath()%>/front-end/order/datetimepicker/jquery.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/order/datetimepicker/jquery.datetimepicker.full.js"></script>

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