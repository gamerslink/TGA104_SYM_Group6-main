<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.* ,com.group6.tibame104.orderlist.model.Product"%>
<html>
<head>
<title>Mode II  - Cart.jsp</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/ShoppingCart.css">
</head>
<body>

	<br>
	<%
	@SuppressWarnings("unchecked")
	
	Map<Integer, List<Product>> check = (Map<Integer, List<Product>>) session.getAttribute("check");
	%>

	<img src="images/tomcat.gif">
	<font size="+3"></font>





	<%
	if (!check.isEmpty() && (check.size() > 0)) {
	%>




<form name="checkoutForm" action="ShopServlet" method="POST">
	<%
	Set<Integer> set = check.keySet();
	Iterator<Integer> it = set.iterator();
	int count =0;
	while (it.hasNext()) {
	%>

	<table id="table-1">
		<tr>
			<td width="140">商品名稱</td>
			<td width="120">價格</td>
			<td width="95">賣場名稱</td>
			<td width="110">數量</td>
			<td width="110">價格</td>
			<td width="120"><img src="images/view-cart.png"></td>
		</tr>
	</table>
	<%
	Integer storeID = it.next();
	List<Product> buylist = check.get(storeID);
	%>

	<%
	for (int index = 0; index < buylist.size(); index++) {
		Product order = buylist.get(index);
	%>
	<table>
		<tr id="my-car-tr">
			<td width="140"><%=order.getName()%></td>
			<td width="110"><%=order.getPrice()%></td>
			<td width="110"><%=order.getStoreName()%></td>

			<td id="minus"><input type="button"
				onclick="minuser<%=index + 1 + count%>()" value="-" /></td>
			<td id="<%=index + 1 + count%>"><%=order.getQuantity()%></td>
			<td id="plus"><input type="button"
				onclick="adder<%=index + 1 + count%>()" value="+" /></td>

			<td class="my-car-td" width="120" align="center" valign="middle"
				id="<%=-index - 1 - count%>"><%=order.getPrice() * order.getQuantity()%></td>
		</tr>
	</table>



	<script src="./jquery/jquery-3.6.1.min.js"></script>
	<script>
		
		function adder<%=index + 1 + count%>() {
			var count = document.getElementById("<%=index + 1 + count%>").innerHTML;
			var sum = document.getElementById("<%=-index - 1 - count%>").innerHTML;
			count = parseInt(count) + 1;
			sum = <%=order.getPrice()%> * count;
			document.getElementById("<%=index + 1 + count%>").innerHTML = count;
			document.getElementById("<%=-index - 1 - count%>").innerHTML = sum;
			
		}
		function minuser<%=index + 1 + count%>() {
			var count = document.getElementById("<%=index + 1 + count%>").innerHTML;
			var sum = document.getElementById("<%=-index - 1 - count%>").innerHTML;
			if (count <= 0) {
				count = 0;
				sum = 0;
			} else {
				count = parseInt(count) - 1;
				sum = <%=order.getPrice()%> * count;
			}

			
			document.getElementById("<%=index + 1 + count%>").innerHTML = count;
			document.getElementById("<%=-index - 1 - count%>").innerHTML = sum;
		}
		
		document.getElementById("total").innerHTML = total;
		
		if (document.getElementById("<%=index + 1 + count%>").innerHTML == 0){
			 $("tr").remove();
		}
	</script>






	<%
	count = count +10000;
	}
	%>

	

		
		<input type="hidden" name="storeID<%=storeID%>" value="<%=storeID%>"> 
		<input type="hidden" name="storeName<%=storeID%>" value="<%=buylist.get(0).getStoreName()%>">
		<input type="checkbox" name="member<%=storeID%>" value="12">
		<b>收件者: </b><input type="text" name="receiver<%=storeID%>"> <br> 
		<b>電話號碼:</b><input type="text" name="phone<%=storeID%>"> <br>  
		<b>收件地址:</b><input type="text" name="address<%=storeID%>"> <br> 
	    <b>付款方式: </b> 
	         <input type="radio" name="paytype<%=storeID%>" value="信用卡">信用卡 
			<input type="radio" name="paytype<%=storeID%>" value="atm轉帳">atm轉帳 
			<input type="radio" name="paytype<%=storeID%>" value="貨到付款">貨到付款 <br> 
		<b>使用購物金:</b> <input type=text name="useShoppingGold<%=storeID%>"> <br> 
		<b>使用優惠券:</b> 
		   <select name="couponID<%=storeID%>">
			<option value="0.85">85折</option>
			<option value="0.75">75折</option>
		   </select>
		    <br> 
		
		


	<script type="text/javascript">
				
const count = document.querySelector('#count')
// 
const carList = document.querySelectorAll('.my-car-td')
// init total
let total = 0;



<script>
var count1 = document.querySelector("#count");

var total = 0;

function addTotal() {
 

  total += parseInt(
    document.querySelectorAll(".my-car-td")[i].textContent,
    10
  );

  // result
  count1.innerhtml = total;
}

addTotal();

</script>
	<%
	}
	%>


<input type="hidden" name="action" value="CHECKOUT">
<input type="submit" value="送出" class="button">
	</form>


	<%
	}
	%>






	<td id="total" colspan="6" style="text-align: right;"><font
		size="+2"><h4 id="count"></h4> </font></td>


</body>
</html>