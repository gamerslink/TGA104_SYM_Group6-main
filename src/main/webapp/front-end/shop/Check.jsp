<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page
	import="java.util.* ,com.group6.tibame104.orderlist.model.Product, com.group6.tibame104.member.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	Map<Integer, List<Product>> check_new = (Map<Integer, List<Product>>) session.getAttribute("check_new");
	%>


	<%
	if (!check_new.isEmpty() && (check_new.size() > 0)) {
	%>



	<br>
	<br>
	<form id="checkoutForm" action="ShopServlet" method="POST">
		<%
		Set<Integer> set = check_new.keySet();
		Iterator<Integer> it = set.iterator();
		int count = 0;
		while (it.hasNext()) {

			Integer storeID = it.next();
			List<Product> buylist = check_new.get(storeID);
		%>

		<table id="table-1" class="table<%=storeID%>" border="1">
			<tr>
				<td width="140" colspan="6"><font size="4">賣場: <%=buylist.get(0).getStoreName()%></font></td>

			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>

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
				Product product = buylist.get(index);
			%>

			<tr id="my-car-tr">

				<td width="160"><%=product.getName()%></td>
				<td width="120"><img
					src="${pageContext.request.contextPath}/product/picServlet?productID=<%=product.getProductID()%>"
					style="width: 140px; height: 120px" alt="Product Image"></td>
				<td width="135"><%=product.getPrice()%></td>




				<td width="30"><%=product.getQuantity()%></td>




				<td class="my-car-td<%=storeID%>" width="130" align="center"
					valign="middle"><%=product.getPrice() * product.getQuantity()%></td>
			</tr>



			<script src="./jquery/jquery-3.6.1.min.js"></script>







			<%
			}
			%>

			<td colspan="3" style="text-align: right"></td>
			<td colspan="5" style="text-align: right">總金額:<b
				class='countingmoney' id="count<%=storeID%>">0</b></td>
		</table>

		<div class="table<%=storeID%>">
			<br> <input type="hidden" name="storeID<%=storeID%>"
				value="<%=storeID%>"> <input type="hidden"
				name="storeName<%=storeID%>"
				value="<%=buylist.get(0).getStoreName()%>"> <input
				type="checkbox" id="member<%=storeID%>" name="member<%=storeID%>">
			<b>選用會員資料</b> <br> <br> <b>收件者: </b> <input type="text"
				name="receiver<%=storeID%>" id="receiver<%=storeID%>"
				style="width: 100px; height: 26px"> <br> <br> 
				<b>電話號碼:</b>
			<input type="text" name="phone<%=storeID%>" id="phone<%=storeID%>"
				style="width: 140px; height: 26px"> <br> <br> 
				<b>收件地址:</b>
			<select id="city" name="city">
				<option value="">請選擇</option>
			</select>
			<!-- 																		第二層選單(先隱藏，選完第一層後再出現) -->
			<select id="area" name="area">
				<option value="">請選擇</option>
			</select> <input name="address<%=storeID%>" type="text"
				style="width: 380px; height: 26px" />

			<!-- 	<b>收件地址:</b>
			<input type="text" name="address<%=storeID%>"
				id="address<%=storeID%>" style="width: 300px; height: 26px">
			<br> <br>  -->

		</div>

		<script
			src="${pageContext.request.contextPath}/back-end/grouporder/js/address.js"></script>

		<script>

var total = document.getElementsByClassName('my-car-td<%=storeID%>');
var count = 0;

for(var sub of total){
	count += Number(sub.innerHTML) ;
}

document.getElementById('count<%=storeID%>').innerHTML = count ;



var checkbox<%=storeID%> = document.getElementById('member<%=storeID%>');
var receiver<%=storeID%> = document.getElementById('receiver<%=storeID%>');
var phone<%=storeID%> = document.getElementById('phone<%=storeID%>');
var address<%=storeID%> = document.getElementById('address<%=storeID%>');

checkbox<%=storeID%>.addEventListener('change', (event) => {
  if (event.currentTarget.checked) {			
	  receiver<%=storeID%>.value ="${memVO.userName}";
	  phone<%=storeID%>.value = "${memVO.phone}";
	  address<%=storeID%>.value = "${memVO.address}";
  } else {
	  receiver<%=storeID%>.value = "";
	  phone<%=storeID%>.value = "";
	  address<%=storeID%>.value = "";
  }
  add<%=storeID%>();
})


</script>


		<br> <br>


		<%
		}
		%>

<hr width=610px align="left">
<br> 
		<table>

			<tr>

				<td colspan="6" style="text-align: right; background-color: #FFFBE3">
					<b>使用購物金:</b> 
					<input type="text" name="useShoppingGold" id="old" style="width: 60px; height: 26px"  > 
					
					<p id="lert" style='visibility: hidden ; color:red;'></p>
				    <b>使用優惠券:
				</b> <select name="couponID" id='couponID'>
						<option value="0.85">85折</option>
						<option value="0.75">75折</option>
				</select> <br> <br> 
				<b></b>
				<b>總運費:</b><b id='fee'></b> 
				
				<br><br>
				<b>付款方式: </b>



					<div class="container card mt-3">
						<div class="form-group mt-3 mb-3">
							<label class="radio"> <input type="radio" name='type'
								value='credit' id="pay-by-domestic-credit"> 信用卡
							</label> <label class="radio"> <input type="radio" name='type'
								value='atm' id="pay-by-aboard-credit"> ATM 轉帳
							</label> <label class="radio"> <input type="radio" name='type'
								value='after' id="pay-by-atm"> 貨到付款
							</label>
						</div>

						<div id='domestic-credit-form' style="display: none;" class="form">
							<c:forEach var="creditVO" items="${credit}">
								<input type="radio" name='creditinfo' style="float: left;"
									value='member'>
								<b style="float: left;">&nbsp; *********${creditVO.creditCardNumber.toString().substring(9)}</b>
							</c:forEach>
							<br> <br> <input type="radio" name='creditinfo'
								style="float: left;" value='other'> <b
								style="float: left">&nbsp; 使用其他信用卡</b> <br> <br>

							<div class="text-center" style="display: none;">
								<h3>輸入信用卡資訊</h3>
							</div>
							<div class="input-group mb-3" id='detail-1'
								style="display: none;">
								<div class="input-group-prepend" style='height:35px'>
									<span class="input-group-text">信用卡卡號</span>
								</div>
								<input type="text" class="form-control" id="domestic-card-no"
									style="display: none;">
							</div>
							<div class="input-group mb-3" id='detail-2'
								style="display: none;">
								<div class="input-group-prepend" style='height:35px; background-color: #FFA9A9'>
									<span class="input-group-text">月</span>
								</div>
								<input type="text" class="form-control" id="domestic-card-month"
									placeholder="輸入月份">
								<div class="input-group-prepend" style='height:35px; background-color: #FFA9A9'>
									<span class="input-group-text">年</span>
								</div>
								<input type="text" class="form-control" id="domestic-card-year"
									placeholder="輸入年">
								<div class="input-group-prepend" style='height:35px; background-color: #FFA9A9'>
									<label class="input-group-text">末三碼</label>
								</div>
								<input type="text" class="form-control" id="domestic-card-csv"
									placeholder="輸入末三碼">
							</div>
							<div class="form-group">
								<span style="color: #fc3762;" id="domestic-card-error"
									style="display: none;"></span>
							</div>
							<div class="form-group">
								<button type="button" id="domestic-submmit"
									class="btn btn-primary" style="display: none;">確認送出</button>
							</div>
						</div>


						<div class="form-group">
							<button type="button" id="resetForm" class="btn btn-warning"
								style="display: none;">重設</button>
						</div>
					</div> <br> <br> <b style='font-size: 20px;'>訂單總金額 :</b> &emsp;
					<b id='ordertotal' style='font-size: 20px;'>0</b> &emsp; <input
					type="hidden" name="action" value="CHECKOUT"> <input
					type="hidden" name="memberID" value="${memVO.memberID}"> <input
					type="hidden" name="userAccount" value="${memVO.userAccount}">

					<input type="submit" value="送出" class="button"
					style='background-color: #FFA9A9; border: 0px; font-weight: bold'>

				</td>
		</table>

		<br>



	</form>
<script>
	var fee = document.getElementById('fee');
	fee.innerHTML = 60*<%=set.size()%>;
</script>

	<%
	}
	%>

	<script>

	$(function(){
		$('#couponID').change(function(){
			
			total();
		});		
	});
	
	$(function(){
		$('#lert').click(function(){
			
			total();
		});		
	});
	var old = document.getElementById('old');
	var lert = document.getElementById('lert');
	
	
	old.addEventListener('keyup', function(){
		if(old.value > 30){
			 old.value = 30;
			 lert.style.visibility = ' visible';
		     lert.innerHTML = "已達您的購物金上限";
		     event.preventDefault();
    } else{
   	 lert.innerHTML = "";
    }
		total();
		
	})
	
	
	window.addEventListener("load", (event) => {
		  	total();
		});


	
	function total(){
	
		var couponID = document.getElementById('couponID');
		var index = couponID.selectedIndex;
		var coupon = Number(couponID.options[index].value);
	    var ordersum = 0 ;
		
	var countingmoney = document.getElementsByClassName('countingmoney');
	var feenum = document.getElementById('fee');
	
		for(var sub of countingmoney){
			ordersum += Number(sub.innerHTML);
		}
	
		document.getElementById('ordertotal').innerHTML = 
			coupon * ordersum + Number(feenum.innerHTML)-Number(old.value);
		
	}
	
	
	
	
	var creditcard = document.getElementById('creditcard');
	

		creditcard.addEventListener('change', function(event){
			if(creditcard.checked == true){
				document.getElementById('credit').style.display = 'inline';	
			} else if(creditcard.checked == false){
				document.getElementById('credit').style.display = 'none';	
			}
				
		
			
		});

		
	
		
	
	
	
	

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
	<script type="text/javascript">
	
	$('input[type=radio][name="type"]').on('change', function() {
		  switch($(this).val()) {
		    case 'credit':
		      $("#domestic-credit-form").show()
		      $("#aboard-credit-form").hide()
		      $("#atm-form").hide()
		      break
		    case 'atm':
		      $("#domestic-credit-form").hide()
		      $("#aboard-credit-form").show()
		      $("#atm-form").hide()
		      break
		    case 'after':
		      $("#domestic-credit-form").hide()
		      $("#aboard-credit-form").hide()
		      $("#atm-form").show()
		      break
		  }      
		})
		
		$('input[type=radio][name="creditinfo"]').on('change', function() {
		  switch($(this).val()) {
		 
	
		    case 'member':
		      $("#detail-1").hide()
		      $("#detail-2").hide()
		      $("#domestic-card-no").hide()
		      $("#domestic-card-csv").hide()
		      $("#domestic-card-error").hide()
		      $("#domestic-submmit").hide()		  
		      $("#resetForm").hide()		  
		      $(".text-center").hide()
		      break
		    
		    case 'other':
			      $("#detail-1").show()
			      $("#detail-2").show()
			      $("#domestic-card-no").show()
			      $("#domestic-card-csv").show()
		     	  $("#domestic-card-error").show()
		          $("#domestic-submmit").show()
		          $("#resetForm").show()	
			      $(".text-center").show()
			      break

		  }      
		})

		$('#domestic-submmit').on('click', function(event) {
		  event.preventDefault()
		  
		  let cardNo = $("#domestic-card-no").val()
		  let cardMonth = $("#domestic-card-month").val()
		  let cardYear = $("#domestic-card-year").val()
		  let cardCSV = $("#domestic-card-csv").val()
		  
		  let errors = validateForm(cardNo, cardMonth, cardYear, cardCSV)
		  if(errors.length) {
		    $("#domestic-card-error").text(errors.join(','))
		    return
		  }
		  
		  blockForm('domestic', true)
		  
		  // ajax event
		  // submitForm(cardNo, cardMonth, cardYear, cardCSV)
		})

		$('#aboard-submmit').on('click', function(event) {
		  event.preventDefault()
		  
		  let cardNo = $("#aboard-card-no").val()
		  let cardMonth = $("#aboard-card-month").val()
		  let cardYear = $("#aboard-card-year").val()
		  let cardCSV = $("#aboard-card-csv").val()
		  
		  let errors = validateForm(cardNo, cardMonth, cardYear, cardCSV)
		  if(errors.length) {
		    $("#aboard-card-error").text(errors.join(', '))
		    return
		  }
		  
		  blockForm('aboard', true)
		  
		  // ajax event
		  // submitForm(cardNo, cardMonth, cardYear, cardCSV)
		  
		})

		$('#resetForm').on('click', function(event) {
		  event.preventDefault()
		  blockForm('domestic', false)
		  blockForm('aboard', false)
		})

		function validateForm(no, month, year, csv) {
		  let errors = []
		  
		  if(no.split('').length !== 12)  errors.push('invalid card number')
		  if(month.split('').length !== 2)  errors.push('invalid card month')
		  if(year.split('').length !== 2)  errors.push('invalid card year')
		  if(csv.split('').length !== 3)  errors.push('invalid card csv')
		  
		  return errors
		}

		function blockForm(formType, isBlocking) {
		  $('input[type=radio][name="type"]:not(:checked)').attr("disabled", isBlocking)
		  $(`#${formType}-card-no`).prop('readonly', isBlocking)
		  $(`#${formType}-card-month`).prop('readonly', isBlocking)
		  $(`#${formType}-card-year`).prop('readonly', isBlocking)
		  $(`#${formType}-card-csv`).prop('readonly', isBlocking)
		  $(`#${formType}-card-error`).text('')
		}

		function submitForm(no, month, year, csv) {
		  // $('input[type=radio][name="type"]':not(:checked)').attr("disabled", true)
		}
	
	</script>


</body>

</html>