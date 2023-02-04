<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*, *::before, *::after {
	box-sizing: border-box;
}

li {
	width: 380px;
	background: #ffffff 0% 0% no-repeat padding-box;
	-webkit-box-shadow: 0px 2px 10px #00000014;
	box-shadow: 0px 2px 10px #00000014;
	border-radius: 12px;
	padding: 32px 32px 0px 32px;
	margin-top: 80px;
	margin-right: 10px;
	list-style-type: none;
}

.position-relative {
	position: relative !important;
}

img {
	top: -60px;
	left: 10px;
}

.position-absolute {
	position: absolute;
}

img, svg {
	vertical-align: middle;
}

.pb-3 {
	padding-bottom: 1rem !important;
}

.mb-3 {
	margin-bottom: 1rem !important;
}

.border-2 {
	border-width: 2px !important;
}

.border-bottom {
	border-bottom: 1px solid #dee2e6 !important;
}


</style>
</head>
<body>
		<%@ include file="styles.jsp"%>
	<!-- 	<Form> -->
	<!-- 		<div class="display-flex"> -->
	<!-- 			<div class=""> -->
	<!-- 				<ul id="" class="table table-bordered table-hover " -->
	<!-- 					style="list-style-type: none"> -->
	<!-- 					<li class=""> -->
	<!-- 						<div class="class="display-flex"> -->
	<!-- 							<div> -->
	<!-- 								<h4 class="sym-purple-font"> -->
	<!-- 																		照片 : <b class="margin-left-1"> -->
	<!-- 									<img class="mg-bottom-1" src="../img/logoPink.jpg" alt="logo" -->
	<!-- 										width="65%" /> -->
	<!-- 																		</b> -->
	<!-- 								</h4> -->
	<!-- 							</div> -->
	<!-- 						</div> -->


	<!-- 						<div class="class="display-flex"> -->
	<!-- 							<div> -->
	<!-- 								<h4 class="sym-purple-font"> -->
	<!-- 									會員帳號 : <b class="margin-left-1">A123456789</b> -->
	<!-- 								</h4> -->
	<!-- 							</div> -->
	<!-- 						</div> -->

	<!-- 						<div class="class="display-flex"> -->
	<!-- 							<div> -->
	<!-- 								<h4 class="sym-purple-font"> -->
	<!-- 									賣場名稱 : <b class="margin-left-1">企鵝賣場</b> -->
	<!-- 								</h4> -->
	<!-- 							</div> -->
	<!-- 						</div> -->

	<!-- 						<div class="class="display-flex"> -->
	<!-- 							<div> -->
	<!-- 								<h4 class="sym-purple-font"> -->
	<!-- 									連絡電話 : <b class="margin-left-1">0920113149</b> -->
	<!-- 								</h4> -->
	<!-- 							</div> -->
	<!-- 						</div> -->

	<!-- 						<div class="class="display-flex"> -->
	<!-- 							<div> -->
	<!-- 								<h4 class="sym-purple-font"> -->
	<!-- 									創建日期 : <b class="margin-left-1">2022-12-07</b> -->
	<!-- 								</h4> -->
	<!-- 							</div> -->
	<!-- 						</div> 						<div class="class="display-flex"> 							<div> -->
	<!-- 														<h4 class="sym-purple-font"> 									更新日期 : <b class="margin-left-1">2022-12-07</b> -->
	<!-- 														</h4> 							</div> 						</div> -->

	<!-- 						<div class="class="display-flex"> -->
	<!-- 							<div> -->
	<!-- 								<h4 class="sym-purple-font"> -->
	<!-- 									統一編號 : <b class="margin-left-1">OX123456</b> -->
	<!-- 								</h4> -->
	<!-- 							</div> -->
	<!-- 						</div> -->

	<!-- 						<div class="display-flex"> -->
	<!-- 							<div> -->
	<!-- 								<h4 class="sym-purple-font"> -->
	<!-- 									帳號狀態 : <b class="margin-left-1">待審核</b> -->
	<!-- 								</h4> -->
	<!-- 							</div> -->
	<!-- 						</div> -->
	<!-- 							<button onclick="popupWindow()" -->
	<!-- 								class="btn sym-darkpurple sym-yellow-font btn_style mg-bottom-2 margin-left-2">不通過</button> -->

	<!-- 							<button onclick="popupWindow()" -->
	<!-- 								class="btn sym-darkpurple sym-yellow-font btn_style mg-bottom-2 margin-left-2">通過</button> -->

	<!-- 					</li> -->
	<!-- 				</ul> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	<!-- 	</Form> -->
	<ul>
		<li class="position-relative"><img class="position-absolute"
			src="../img/logoPink.jpg" alt="" width="80" height="80">
			<h3 class="mb-3">請確認是否審核通過?</h3>
			<div class="d-flex justify-content-between ">
				<div>
<!-- 					<p class="sym-dark-font">企鵝 執行長</p> -->
				</div>
				<button onclick="popupWindow()"
					class="btn sym-darkpurple sym-yellow-font btn_style mg-bottom-2">通過</button>

			</div></li>
	</ul>
</body>
</html>