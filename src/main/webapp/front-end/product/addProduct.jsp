<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>員工資料新增 - addEmp.jsp</title>

<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}
</style>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>商品資料新增 - addProduct.jsp</h3>
			</td>
			<td>刪掉</td>
		</tr>
	</table>

	<h1>商品新增:</h1>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post"
		ACTION="${pageContext.request.contextPath}/product/productServlet"
		enctype="multipart/form-data">
		<div>
			<label>商店ID：</label> <input type="text" id="p_name"
				class="form-control" name="storeID" value="1" />
		</div>
		<div>
			<label>商品名稱：</label> <input type="text" id="p_name"
				class="form-control" name="productName" />
		</div>
		<div>
			商品次分類： <select class="form-select mb-3"
				aria-label="Default select example" name="productSec">
				<option selected>請選擇</option>
				<c:forEach var="productSecVO" items="${ProductSec}">
					<option value="${productSecVO.productSecID}">${productSecVO.productSecName}</option>
				</c:forEach>
			</select>
		</div>

		<div>
			<label>商品數量：</label> <input type="text" min="1" max="100" value="1"
				id="p_count" class="form-control" name="productStock" /> <span
				id="p_count_value"></span>
		</div>
		<div>
			<label>商品價格：</label> <input type="text" value="1" id="p_count"
				class="form-control" name="productPrice" /> <span
				id="p_count_value"></span>
		</div>
		<div>
			<label>商品圖片1:</label> <input type="file" id="p_file"
				class="btn btn-secondary m-2" name="upfile1" /> <br /> <label>商品圖片2：</label>
			<input type="file" id="p_file2" class="btn btn-secondary m-2"
				name="upfile2" /> <br /> <label>商品圖片3：</label> <input type="file"
				id="p_file3" class="btn btn-secondary m-2" name="upfile3" /> <br />
		</div>
		<div class="input-group">
			<span class="input-group-text">商品描述：</span>
			<textarea class="form-control" aria-label="With textarea"
				name="productDesc"></textarea>
		</div>
		<div>
			<label>出貨地</label> <input type="text" id="p_source"
				class="form-control" name="source" />
		</div>
		<div>
			商品狀態 <select class="form-select mb-3"
				aria-label="Default select example" name="productStatus">
				<option selected>請選擇</option>
				<option value="1">已上架</option>
				<option value="0">未上架</option>
			</select>
		</div>

		<input type="hidden" name="action" value="insert"> <input
			type="submit" value="送出新增">
	</FORM>
	-----------------------------------------
	<h1>商品修改</h1>
	<FORM METHOD="post"
		ACTION="${pageContext.request.contextPath}/product/productServlet"
		enctype="multipart/form-data">
		<div>
			<label>商品ID：</label> <input type="text" id="p_ID"
				class="form-control" name="productID" />
		</div>
		<div>
			<label>商品名稱：</label> <input type="text" id="p_name"
				class="form-control" name="productName" />
		</div>
		<div>
			商品次分類： <select class="form-select mb-3"
				aria-label="Default select example" name="productSec">
				<option selected>請選擇</option>
				<c:forEach var="productSecVO" items="${ProductSec}">
					<option value="${productSecVO.productSecID}">${productSecVO.productSecName}</option>
				</c:forEach>
			</select>
		</div>

		<div>
			<label>商品數量：</label> <input type="text" min="1" max="100" value="1"
				id="p_count" class="form-control" name="productStock" /> <span
				id="p_count_value"></span>
		</div>
		<div>
			<label>商品價格：</label> <input type="text" value="1" id="p_count"
				class="form-control" name="productPrice" /> <span
				id="p_count_value"></span>
		</div>
		<div>
			<label>商品圖片1:</label> <input type="file" id="p_file"
				class="btn btn-secondary m-2" name="upfile1" /> <br /> <label>商品圖片2：</label>
			<input type="file" id="p_file2" class="btn btn-secondary m-2"
				name="upfile2" /> <br /> <label>商品圖片3：</label> <input type="file"
				id="p_file3" class="btn btn-secondary m-2" name="upfile3" /> <br />
		</div>
		<div class="input-group">
			<span class="input-group-text">商品描述：</span>
			<textarea class="form-control" aria-label="With textarea"
				name="productDesc"></textarea>
		</div>
		<div>
			<label>出貨地</label> <input type="text" id="p_source"
				class="form-control" name="source" />
		</div>
		<div>
			商品狀態 <select class="form-select mb-3"
				aria-label="Default select example" name="productStatus">
				<option selected>請選擇</option>
				<option value="1">已上架</option>
				<option value="0">未上架</option>
			</select>
		</div>

		<input type="hidden" name="action" value="update"> <input
			type="submit" value="送出修改">
	</FORM>
	-----------------------------------------
	<h1>單一查詢</h1>
	<FORM METHOD="post"
		ACTION="${pageContext.request.contextPath}/product/productServlet"
		" enctype="multipart/form-data">
		productID<input type="text" name="productID" value="9"> <input
			type="hidden" name="action" value="getOne_For_Display"> <input
			type="submit" value="送出查詢">
	</FORM>
	------------------------------------------
	<h1>很多查詢</h1>
	<FORM METHOD="post"
		ACTION="${pageContext.request.contextPath}/product/productServlet"
		" enctype="multipart/form-data">
		<input type="text" name="productName" value="請輸入productName">
		<input type="hidden" name="action" value="getAll_For_Display">
		<input type="submit" value="送出查詢">
	</FORM>
	------------------------------------------
	<h1>更多查詢</h1>
	<FORM METHOD="post"
		ACTION="${pageContext.request.contextPath}/product/productServlet"
		" enctype="multipart/form-data">
		<div>
			<label>商店ID：</label> <input type="text" id="p_name"
				class="form-control" name="storeID" value="1" />
		</div>
		<div>
			<label>商品ID：</label> <input type="text" id="p_ID"
				class="form-control" name="productID" />到 <input type="text"
				name="productID2" />
		</div>
		<div>
			<label>商品名稱：</label> <input type="text" id="p_name"
				class="form-control" name="productName" />
		</div>
		<div>
			商品次分類： <select class="form-select mb-3"
				aria-label="Default select example" name="productSecID">
				<option selected value="selected">請選擇</option>
				<c:forEach var="productSecVO" items="${ProductSec}">
					<option value="${productSecVO.productSecID}">${productSecVO.productSecName}</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<label>商品數量：</label> <input type="text" min="1" max="100" value="1"
				id="p_count" class="form-control" name="productStock" /> <span
				id="p_count_value"></span>到 <input type="text" name="productStock2" />
		</div>
		<div>
			<label>商品價格：</label> <input type="text" value="1" id="p_count"
				class="form-control" name="productPrice" /> <span
				id="p_count_value"></span>到 <input type="text" name="productPrice2" />
		</div>
		<div>
			商品狀態 <select class="form-select mb-3"
				aria-label="Default select example" name="productStatus">
				<option selected value="selected">請選擇</option>
				<option value="1">已上架</option>
				<option value="0">未上架</option>
			</select>
		</div>
		<input type="hidden" name="action" value="getAll_For_More_Display">
		<input type="submit" value="送出查詢">
	</FORM>
</body>



</html>