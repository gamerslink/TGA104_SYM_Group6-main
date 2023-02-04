<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 企鵝開始 -->
<script src="${pageContext.request.contextPath}/JQ/jquery-3.6.1.min.js"></script>
<script>
	$(function() {
		var template = 
		`<table class="table table-striped col-sm-12">
			<tr>
			<th>會員帳號</th>
			<th>賣場名稱</th>
			<th>賣場地址</th>
			<th>連絡電話</th>
			<th>創建日期</th>
			<th>更新日期</th>
			<th>統一編號</th>
			<th>審核狀態</th>
			<th>審核</th>
		</tr>
		`;
		
		var str=``;
		function bbb(data){
			str=``;
			let status ='';
			for(let i=0;i<data.length;i++){
				let templateList =   `
					<tr>
						<td>`+data[i].memberID+`</td>
						<td>`+data[i].storeName+`</td>
						<td>`+data[i].storeAddress+`</td>
						<td>`+data[i].phoneNumber+`</td>
						<th>`+data[i].createDate+`</th>
						<td>`+data[i].updateDate+`</td>
						<td>`+data[i].taxID+`</td>
						<td>通過</td>
						<th><a href="${pageContext.request.contextPath}/product/productGetOne?productID=`+data[i].productID+`"><button>修改</button></a></th>
					</tr>
				`;
				str = str + templateList;
			}
		}
		var str2=`</table>`;

		$("#btnSearchSellerPass")
				.click(
						function() {
							$
									.ajax({
										url : "${pageContext.request.contextPath}/back-end/administrator/administratorServlet",
										// 資料請求的網址
										type : "GET", // GET | POST | PUT | DELETE | PATCH
										dataType : "json", // 預期會接收到回傳資料的格式： json | xml | html
										success : function(data) {
											// request 成功取得回應後執行
											console.log(data);
											bbb(data);
											//console.log(str);
											//console.log(data[0].productID+"哭啊");
											console.log(data.length);
											$("#searchSeller").html("<h2>搜尋結果總共有"+data.length+"筆</h2>"+template+str+str2);
										},
										error : function(XMLHttpRequest) {
											if (XMLHttpRequest.status >= 400) {
												alert("出現錯誤");
											}
										}
									});
						});
	});
</script>
<!-- 企鵝結束 -->
</head>
<body>
<button id="btnSearchSellerPass">test</button>
<div id="searchSeller"></div>




</body>
</html>