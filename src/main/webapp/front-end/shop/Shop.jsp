<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.group6.tibame104.order.model.OrderVO" %>
<html>
<head>
 
 <title>Mode II 範例程式 - Eshop.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/front-end/shop/css/ShoppingCart.css">
</head>
<body>
<img src="images/tomcat.gif"> <font size="+3">網路書店：（EShop.jsp）</font>
<hr>
<table id="table-1">
  <tr> 
    <th width="200">商品名稱</th><th width="200">賣場名稱</th><th width="100">價格</th>
    <th width="120">數量</th><th width="120"><img src="images/shopping-cart.png" width="45px" height="35px"></th>
  </tr></table>
 
 <!--  
       第一種action寫法: <form name="shoppingForm" action="Shopping.html" method="POST">
       第二種action寫法: <form name="shoppingForm" action="/IBM_MVC/Shopping.html" method="POST">
       第三種action寫法: <form name="shoppingForm" action="<%=request.getContextPath()%>/Shopping.html" method="POST">
 -->
 <!-- 
       當某網頁可能成為被forward的網頁時, 此網頁內的所有html連結 , 如果採用相對路徑寫法時, 因為會被加上原先forward者的路徑
       在更複雜的MVC架構中, 上面第三種寫法, 先以request.getContextPath()方法, 先取得環境(Servlet Context)目錄路徑的寫法,u
       將是最佳解決方案
 -->
 


  <form name="shoppingForm" action="ShopServlet" method="POST">
    <table><tr> 
      <td width="200"><div align="center">不一樣的養生法</div></td>
      <td width="200"><div align="center">當鋪</div></td>

      <td width="100"><div align="center">600</div></td>
      <td width="120"><div align="center">數量：<input type="text" name="quantity" size="3" value=1></div></td>
      <td width="120"><div align="center">     <input type="submit" class="button" value="放入購物車"> </div></td>
    </tr></table>
      <input type="hidden" name="name" value="不一樣的養生法">
 
      <input type="hidden" name="price" value="600">
      <input type="hidden" name="action" value="ADD">
      <input type="hidden" name="productID" value="1">
      <input type="hidden" name="storeID" value="1">
      <input type="hidden" name="storeName" value="當鋪">
  </form>

  
  <form name="shoppingForm" action="ShopServlet" method="POST">
    <table><tr> 
      <td width="200"><div align="center">哈利波特-神秘的魔法石</div></td>
      <td width="200"><div align="center">寶可夢</div></td>

      <td width="100"><div align="center">200</div></td>
      <td width="120"><div align="center">數量：<input type="text" name="quantity" size="3" value=1></div></td>
      <td width="120"><div align="center">     <input type="submit" class="button" value="放入購物車"> </div></td>
    </tr></table>
      <input type="hidden" name="name" value="哈利波特-神秘的魔法石">
  
      <input type="hidden" name="price" value="200">
      <input type="hidden" name="action" value="ADD">
      <input type="hidden" name="productID" value="2">
      <input type="hidden" name="storeID" value="2">
      <input type="hidden" name="storeName" value="寶可夢">
  </form>
  
  <form name="shoppingForm" action="ShopServlet" method="POST">
    <table><tr> 
      <td width="200"><div align="center">麻辣女教師</div></td>
      <td width="200"><div align="center">寶可夢</div></td>

      <td width="100"><div align="center">190</div></td>
      <td width="120"><div align="center">數量：<input type="text" name="quantity" size="3" value=1></div></td>
      <td width="120"><div align="center">     <input type="submit" class="button" value="放入購物車"> </div></td>
    </tr></table>
      <input type="hidden" name="name" value="麻辣女教師">

      <input type="hidden" name="price" value="190">
      <input type="hidden" name="action" value="ADD">
      <input type="hidden" name="productID" value="1">
      <input type="hidden" name="storeID" value="2">
      <input type="hidden" name="storeName" value="寶可夢">

  </form>
  
  <form name="shoppingForm" action="ShopServlet" method="POST">
    <table><tr> 
      <td width="200"><div align="center">把話說到心窩</div></td>
      <td width="200"><div align="center">塔羅牌</div></td>
 
      <td width="100"><div align="center">180</div></td>
      <td width="120"><div align="center">數量：<input type="text" name="quantity" size="3" value=1></div></td>
      <td width="120"><div align="center">     <input type="submit" class="button" value="放入購物車"> </div></td>
    </tr></table>
      <input type="hidden" name="name" value="把話說到心窩">

      <input type="hidden" name="price" value="180">
      <input type="hidden" name="action" value="ADD">
      <input type="hidden" name="productID" value="1">
      <input type="hidden" name="storeID" value="3">
      <input type="hidden" name="storeName" value="塔羅牌">
  </form>
  
  <form name="shoppingForm" action="ShopServlet" method="POST">
    <table ><tr> 
      <td width="200"><div align="center">一個人聖經</div></td>
      <td width="200"><div align="center">塔羅牌</div></td>
  
      <td width="100"><div align="center">300</div></td>
      <td width="120"><div align="center">數量：<input type="text" name="quantity" size="3" value=1></div></td>
      <td width="120"><div align="center">     <input type="submit" class="button" value="放入購物車"> </div></td>
    </tr></table>
      <input type="hidden" name="name" value="一個人聖經">
 
      <input type="hidden" name="price" value="300">
      <input type="hidden" name="action" value="ADD">
      <input type="hidden" name="productID" value="2">
      <input type="hidden" name="storeID" value="3">
      <input type="hidden" name="storeName" value="塔羅牌">
  </form>


<p> 
 
</body>
</html>