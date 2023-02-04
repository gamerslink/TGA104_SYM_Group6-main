<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 企鵝開始 -->
<script src="${pageContext.request.contextPath}/JQ/jquery-3.6.1.min.js"></script>

<!-- 企鵝結束 -->
</head>
<body>
	<!-- <button id="btnSearchSeller">test</button> -->
	<!-- <div id="searchSeller"></div> -->
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
						<td>`+data[i].storeAuditStatus+`</td>
						<th><a href="${pageContext.request.contextPath}/back-end/administrator/AdminMailServlet?memberID=`+data[i].memberID+`"><button class="btn sym-darkpurple sym-yellow-font btn_style">送出</button></a></th>
					</tr>
				`;
				str = str + templateList;
			}
		}
		var str2=`</table>`;
		
		console.log("123456");
		console.log($("#selectSearch option:selected").val());

		var statusPass = '通過';
		var statusN = '待審核';
		// **待審核**/
		$("#btnSearchSeller")
				.click(
						function() {
							let variable1 ='';
							if($("#selectSearch option:selected").val()=='volvo'){
								variable1 = '${pageContext.request.contextPath}/back-end/administrator/administratorServlet';
								
							}else{
								variable1 = '${pageContext.request.contextPath}/back-end/administrator/StorePassServlet';
							}
							$
									.ajax({
										url : variable1,
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

	<h5 class="sym-dark-font">帳號狀態 :</h5>
	<br>
	<select id="selectSearch" name="cars" class="form-control mb-2rem">
		<option value="volvo">待審核</option>
		<option value="saab" selected="selected" >審核</option>
	</select>
	
	<button id="btnSearchSeller"
		class="btn sym-darkpurple sym-yellow-font btn_style" value="送出">送出
	</button>

</body>
</html>