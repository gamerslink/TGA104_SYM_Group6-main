<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	href="${pageContext.request.contextPath}/front-end/member/css/table.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/css/signupDay.css"
	rel="stylesheet" />
<script src="https://kit.fontawesome.com/bc79e44e11.js"
	crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/JQ/jquery-3.6.1.min.js"></script>
<script>
$(function(){
	var template = 
		
		`<table class="table table-striped col-sm-12 table-outbox">
			<tr>
				<th>優惠券ID</th>
				<th>優惠券名稱</th>
				<th>開始日期</th>
				<th>結束日期</th>
				<th>打折數</th>
				<th>滿額折抵金額</th>
				<th>折抵金額條件</th>
				<th>搶券期起</th>
				<th>搶券期止</th>
				<th>已兌換數量</th>
				<th>優惠券描述</th>
				<th>修改</th>
			</tr>	
		`;
		
		var str=``;
		function aaa(data){
			str=``;
			for(let i=0;i<data.length;i++){
				let templateList =   `
					<tr>
						<td>`+data[i].couponID+`</td>
						<td>`+data[i].couponName+`</td>
						<td>`+data[i].startDate+`</td>
						<td>`+data[i].endDate+`</td>
						<td>`+data[i].discount+`</td>
						<th>`+data[i].discountAmount+`</th>
						<td>`+data[i].fullCondition+`</td>
						<td>`+data[i].couponTimeBegins+`</td>
						<td>`+data[i].couponTimeEnd+`</td>
						<td>`+data[i].exchangeAmount+`</td>
						<td>`+data[i].couponDescription+`</td>
						<th><a href="${pageContext.request.contextPath}/CouponUpdate?couponID=`+data[i].couponID+`"><button>修改</button></a></th>
					</tr>
				`;
				str = str + templateList;
			}
		}
		var str2=`</table>`;
		$("#btn_coupon2")
				.click(
						function() {
							$
									.ajax({
										url : "${pageContext.request.contextPath}/CouponAll", // 資料請求的網址
										type : "GET", // GET | POST | PUT | DELETE | PATCH
										// data: 物件資料,             // 將物件資料(不用雙引號) 傳送到指定的 url
										dataType : "json", // 預期會接收到回傳資料的格式： json | xml | html
										contentType : 'application/json; charset=UTF-8',
										success : function(data) {
											console.log(data);
											aaa(data);
											console.log(data.length);
											$("#result").html("<h2>搜尋結果總共有"+data.length+"筆</h2>"+template+str+str2);
										},
										error : function() {
											alert("出現錯誤");
										}
									});
						});
})
</script>
</head>
<body>
	<h2>優惠券查詢</h2>
	<button id="btn_coupon2">按鈕</button>
	<div id="result"></div>
</body>
</html>