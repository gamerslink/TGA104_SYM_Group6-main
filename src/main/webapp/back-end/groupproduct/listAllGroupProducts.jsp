<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.group6.tibame104.groupproduct.model.*"%>

<%@ include file="/back-end/group/header.jsp"%>

      <div class="container-fluid pt-4 px-4">
        <!-- Content Header (Page header) -->
        <div class="content-header">
          <div class="container-fluid">
            <div class="row mb-2">
              <div class="col-sm-6">
                <h2 class="m-0 sym-dark-font">團購管理 / 團購商品</h2>
              </div>
              <!-- /.col -->
              <div class="col-sm-6 flex-direction">
                <ol class="breadcrumb float-sm-right">
                  <li class="breadcrumb-item">
                    <a href="#">Home</a>
                  </li>
                  <li class="breadcrumb-item active">團購管理 / 團購商品</li>
                </ol>
              </div>
              <!-- /.col -->
            </div>
            <!-- /.row -->
          </div>
          <!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->
        <div class="sym-yellow-bk text-center rounded p-4">
          <div class="d-flex align-items-center justify-content-between mb-4">
            <a class="btn btn-sm card-header sym-darkpurple sym-yellow-font font-m btn_style" href="${pageContext.request.contextPath}/back-end/groupproduct/groupProductAdd.jsp">新增團購商品</a>
          </div>
          <div class="table-responsive">
            <div class="card card-primary">
              <table class="table text-start align-middle table-bordered table-hover mb-0" id="reserver_detail">
                <thead>
                  <tr class="text-dark">
                    <th scope="col">團購商品編號</th>
                    <th scope="col">商品價格</th>
                    <th scope="col">商品圖片</th>
                    <th scope="col">商品描述</th>

                  </tr>
                </thead>
                <tbody>
                 <c:forEach var="groupproductVO" items="${groupproductVOs}" >
		<tr>
			<td>No.${groupproductVO.groupBuyProductID}</td>
			<td>${groupproductVO.groupBuyProductPrice} $</td>
			<td><img src="${pageContext.request.contextPath}/back-end/groupproduct/DBJPGReader?groupBuyProductID=${groupproductVO.groupBuyProductID}"style="width: 80px ""text-align: middle"></td>
			<td>${groupproductVO.groupBuyProductDescrip}</td>
	
			
			<td>
			  <FORM METHOD="post" ACTION="${pageContext.request.contextPath}/back-end/groupproduct/getOneForUpdate" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="groupBuyProductID"  value="${groupproductVO.groupBuyProductID}">
			     </FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="${pageContext.request.contextPath}/back-end/groupproduct/delete" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="groupBuyProductID"  value="${groupproductVO.groupBuyProductID}">
			     </FORM>
			</td>
		</tr>
	</c:forEach>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
      <!-- Recent Sales End -->
      <!-- Table End -->
      <!--content end-->

      <!--session start-->
      <div class="col-sm-12 col-md-7">
        <div class="dataTables_paginate paging_simple_numbers" id="example2_paginate"></div>
      </div>
      <!--session ends-->

      <!-- Footer Start -->
      <div class="container-fluid pt-4 px-4">
        <div class="bg-light rounded-top p-4">
          <div class="row">
            <div class="col-12 col-sm-6 text-center text-sm-start">
              &copy; <a href="#">Tibame TGA104 第六組 SYM</a>, All Right
              Reserved.
            </div>
            <div class="col-12 col-sm-6 text-center text-sm-end">
              <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
              Designed By <a href="https://htmlcodex.com">HTML Codex</a>
            </div>
          </div>
        </div>
      </div>
      <!-- Footer End -->
    </div>

    <!-- Back to Top -->
    <a href="#" class="btn btn-lg sym-darkpurple sym-yellow-font btn-lg-square back-to-top btn_style"><i
        class="bi bi-arrow-up"></i></a>
  </div>

  <!-- JavaScript Libraries -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/back-end/groupproduct/lib/chart/chart.min.js"></script>
  <script src="${pageContext.request.contextPath}/back-end/groupproduct/lib/easing/easing.min.js"></script>
  <script src="${pageContext.request.contextPath}/back-end/groupproduct/lib/waypoints/waypoints.min.js"></script>
  <script src="${pageContext.request.contextPath}/back-end/groupproduct/lib/owlcarousel/owl.carousel.min.js"></script>
  <script src="${pageContext.request.contextPath}/back-end/groupproduct/lib/tempusdominus/js/moment.min.js"></script>
  <script src="${pageContext.request.contextPath}/back-end/groupproduct/lib/tempusdominus/js/moment-timezone.min.js"></script>
  <script src="${pageContext.request.contextPath}/back-end/groupproduct/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

  <!-- Template Javascript -->
  <script src="${pageContext.request.contextPath}/back-end/groupproduct/js/main.js"></script>
  <script src="${pageContext.request.contextPath}/back-end/groupproduct/js/search.js"></script>
</body>

</html>