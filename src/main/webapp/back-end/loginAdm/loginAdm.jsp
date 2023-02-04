<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>


<% String path = request.getContextPath();%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="keywords" />
    <meta content="" name="description" />

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon" />

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap"
      rel="stylesheet"
    />

    <!-- Icon Font Stylesheet -->
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
      rel="stylesheet"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
      rel="stylesheet"
    />

    <!-- Libraries Stylesheet -->
    <link href="../lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet" />
    <link
      href="../lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css"
      rel="stylesheet"
    />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="../css/bootstrap.min.css" rel="stylesheet" />

    <!-- Template Stylesheet -->
    <link href="../css/style.css" rel="stylesheet" />

    <!--Thema-->
    <link rel="stylesheet" href="../css/admin.css" />
    <link rel="stylesheet" href="../css/login.css" />
</head>
<body>


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <!-- Navbar Start -->
    <nav class="navbar navbar-expand sym-skin sticky-top px-4 py-0">
      <a href="index.html" class="navbar-brand d-flex d-lg-none me-4">
        <h2 class="text-primary mb-0"></h2>
      </a>
<!--       <a href="#" class="sidebar-toggler flex-shrink-0"> -->
      <!--   <img src="../img/logoSYM.jpg" alt="SYM logo" width="125px" /> -->
<!--       </a> -->

      <div class="navbar-nav align-items-center ms-auto">
        <div class="nav-item dropdown">
<!--           <a -->
<!--             href="#" -->
<!--             class="nav-link dropdown-toggle" -->
<!--             data-bs-toggle="dropdown" -->
<!--           > -->
<!--             <img -->
<!--               class="rounded-circle me-lg-2" -->
<!--               src="../img/logoSYM3.jpg" -->
<!--               alt="" -->
<!--               style="width: 40px; height: 40px" -->
<!--             /> -->
<!--             <span class="d-none d-lg-inline-flex sym-dark-font ">請登入</span> -->
<!--           </a> -->
          </div>
        </div>
    </nav>
    <!-- Navbar End -->

    <div class="container">
      <!-- Spinner Start -->
      <div
        id="spinner"
        class="show position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center"
      >
        <div
          class="spinner-border text-primary"
          style="width: 3rem; height: 3rem"
          role="status"
        >
          <span class="sr-only">Loading...</span>
        </div>
      </div>
      <!-- Spinner End -->

      <div class="card card-container">
        <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
        <img
          id="profile-img"
          class="profile-img-card"
          src="../img/logoSYM3.jpg"
        />
        <br />
        <h2 class="d-flex-space-around sym-purple-font">管理員 登入</h2>
        <p id="profile-name" class="profile-name-card"></p>
        <form method="post" id="form" class="form-signin" action="<%=path%>/back-end/administrator/LoginServlet">
        
        
	
	
          <span id="reauth-email" class="reauth-email"></span>
          <input
            type="text"
            name="username"
            id="username"
            class="form-control"
            placeholder="請輸入帳號"
            value="${username}"
            required=""
            pattern="^[t]{1}[i]{1}[b]{1}[a]{1}[0-9]{3}$"
            autofocus
          />
          <input
            type="password"
            name="password"
            id="password"
            class="form-control"
            placeholder="請輸入密碼"
            required=""
            pattern="^[A-Za-z]{1}[1-2]{1}[0-9]{8}$"
          />
<!-- <!-- 在网页中添加一个 canvas 元素，用于显示验证码图片 -->
<!-- <canvas id="captchaCanvas" width="200" height="60"></canvas> -->

<!-- <!-- 登录表单 --> 
<!--   <label>验证码：<input type="text" name="captcha"></label> -->
<!--           <br /> -->
<!--           <div id="remember" class="checkbox"></div> -->
<br />
          
          <button
            class="btn btn-lg btn-primary btn-block btn-signin "
            type="button"
            name="loginButton"
            onclick="loginVer();"
          >
            登入
          </button>
          
          
        </form>
      </div>
      <!-- /card-container -->
    </div>
    <!-- /container -->

 <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../lib/chart/chart.min.js"></script>
    <script src="../lib/easing/easing.min.js"></script>
    <script src="../lib/waypoints/waypoints.min.js"></script>
    <script src="../lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="../lib/tempusdominus/js/moment.min.js"></script>
    <script src="../lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="../lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="../js/main.js"></script>
    <script src="../js/login.js"></script>
    
<script>
   	function loginVer() {
   		var username = document.getElementById("username").value;
   		var password = document.getElementById("password").value;
   		
   		
   	//驗證規格
		var id = new RegExp(/[0-9]{18}/);//匹配数字18次，用於身分證匹配
		var password = new RegExp(/\w{6,16}/);//字母6到16次，用於密碼匹配
		var chinese = new RegExp(/[^\u4e00-\u9fa5]|^$/);//匹配中文以外的字符，用于真实姓名验证
		var email = new RegExp(/\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/);//用于邮箱格式验证
   		
   		
   		
   		if (username == '') {
   			alert('編號不能為空，請重新輸入!');
   			return;
   		}
   		
   		if (password == '') {
   			alert('密碼不能為空，請重新輸入!');
   			return;
   		}
   		
   		/*調用後端 Servlet */
   		document.getElementById("form").submit();
   	}
    
</script>
    
    
</body>
</html>