<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</style>
<script src="${pageContext.request.contextPath}/JQ/jquery-3.6.1.min.js"></script>
<script>
$(function(){
	var template = 
		`<table class="table table-striped col-sm-12">
			<tr>
				<th>會員ID</th>
				<th>用戶帳號</th>
				<th>用戶名稱</th>
				<th>優惠券ID</th>
				<th>優惠券使否使用</th>
				<th>優惠券名稱</th>
				<th>discount</th>
				<th>discountAmount</th>
				<th>fullCondition</th>
				<th>couponDescription</th>
			</tr>	
		`;
		
		var str=``;
		function aaa(data){
			str=``;
			for(let i=0;i<data.length;i++){
				let templateList =   `
					<tr>
						<td>`+data[i].memberID+`</td>
						<td>`+data[i].userAccount+`</td>
						<td>`+data[i].userName+`</td>
						<td>`+data[i].couponID+`</td>
						<td>已使用</td>
						<td>`+data[i].couponName+`</td>
						<td>`+data[i].discount+`</td>
						<th>`+data[i].discountAmount+`</th>
						<td>`+data[i].fullCondition+`</td>
						<td>`+data[i].couponDescription+`</td>
					</tr>
				`;
				str = str + templateList;
			}
		}
		var str2=`</table>`;
		$("#btn_couponUsage")
				.click(
						function() {
							$
									.ajax({
										url : "${pageContext.request.contextPath}/CouponUsage", // 資料請求的網址
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
	<h2>優惠券使用紀錄查詢</h2>
	<button id="btn_couponUsage">按鈕</button>
	<div id="result"></div>
</body>
</html>