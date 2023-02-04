<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page
	import="java.util.* ,com.group6.tibame104.orderlist.model.OrderlistVO, com.group6.tibame104.order.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Mode II 範例程式 - Checkout.jsp</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/front-end/shop/css/ShoppingCart.css">

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
</head>
<body>
	<font size="+2">訂單完成</font>
	<hr>
	<p>





		<%
		@SuppressWarnings("unchecked")

		Map<OrderVO, List<OrderlistVO>> orderVO_list = (Map<OrderVO, List<OrderlistVO>>) session.getAttribute("orderVO_list");
		%>
		<%
		Set<OrderVO> set = orderVO_list.keySet();
		Iterator<OrderVO> it = set.iterator();
		while (it.hasNext()) {
			OrderVO ordervo = it.next();
			List<OrderlistVO> orderlist = orderVO_list.get(ordervo);
		%>
	
	<table id="table-1">
		<tr>
			<th width="200">商品名稱</th>
			<th width="155">商品圖片</th>
			<th width="100">價格</th>
			<th width="100">數量</th>
			<th width="120">總價</th>
		</tr>
	</table>
	<table>
	<c:forEach var="orderlistVO" items="<%=orderlist%>">
		<tr>
			<td width="200">${orderlistVO.productName}</td>
			<td width="200"><img
				src="${pageContext.request.contextPath}/product/picServlet?productID=${orderlistVO.productID}"
				style="width: 140px; height: 120px" alt="Product Image"></td>
			<td width="100">${orderlistVO.price}</td>
			<td width="100">${orderlistVO.quantity}</td>
			<td width="120">${orderlistVO.subTotal}</td>
		</tr>

	</c:forEach>
	
		<tr>
			<td colspan="3" style="text-align: right"></td>
			<td colspan="5" style="text-align: right">總金額:<%=ordervo.getOriginalTotal()%></td>
		</tr>
	
	
	</table>

	<p>
		訂單編號:<%=ordervo.getOrderID()%></p>
	<p>
		賣場編號:<%=ordervo.getStoreID()%></p>
	<p>
		賣場名稱:<%=ordervo.getStoreName()%></p>
	<p>
		會員編號:<%=ordervo.getMemberID()%></p>
	<p>
		訂單日期:<%=ordervo.getOrderDate().toString().substring(0, 19)%></p>
	<p>
		訂單狀態:<%=ordervo.getOrderStatus()%></p>
	<p>
		收件者:<%=ordervo.getReceiver()%></p>
	<p>
		電話號碼:<%=ordervo.getPhone()%></p>
	<p>
		信用卡號:<%=ordervo.getCreditcardNumber()%></p>
	<p>
		收件地址:<%=ordervo.getAddress()%></p>
	<p>
		付款方式:<%=ordervo.getPayType()%></p>
	<p>
		優惠券ID:<%=ordervo.getCouponID()%></p>
	<p>
		原價:<%=ordervo.getOriginalTotal()%></p>
	<p>
		使用購物金:<%=ordervo.getUseShoppingGold()%></p>
	<p>
		使用優惠券:<%=ordervo.getUseCouponGold()%></p>
	<p>運費:60</p>
	<p>
		總價:<%=ordervo.getFinalTotal()%></p>
	<%
	}
	%>
	<p>
		<a href="${pageContext.request.contextPath}/"><font size="+1">  繼 續 購 物</font></a>
</body>
</html>