<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">

<style>
      .spinner {
        margin: 100px auto 0;
        width: 70px;
        text-align: center;
      }

      .spinner > div {
        width: 18px;
        height: 18px;
        background-color: rgb(164, 36, 111);

        border-radius: 100%;
        display: inline-block;
        -webkit-animation: sk-bouncedelay 1.4s infinite ease-in-out both;
        animation: sk-bouncedelay 1.4s infinite ease-in-out both;
      }

      .spinner .bounce1 {
        -webkit-animation-delay: -0.32s;
        animation-delay: -0.32s;
      }

      .spinner .bounce2 {
        -webkit-animation-delay: -0.16s;
        animation-delay: -0.16s;
      }

      @-webkit-keyframes sk-bouncedelay {
        0%,
        80%,
        100% {
          -webkit-transform: scale(0);
        }
        40% {
          -webkit-transform: scale(1);
        }
      }

      @keyframes sk-bouncedelay {
        0%,
        80%,
        100% {
          -webkit-transform: scale(0);
          transform: scale(0);
        }
        40% {
          -webkit-transform: scale(1);
          transform: scale(1);
        }
      }
    </style>
</head>
<body>
	  <br /><br /><br /><br />
    <div
      class="spinner"
      id="spinner"
      style="text-align: center; line-height: 50px"
    >
      <div class="bounce1"></div>
      <div class="bounce2"></div>
      <div class="bounce3"></div>
    </div>
    <div>
      <h2 id="card" style="text-align: center; line-height: 300px">
        信用卡交易中, 請稍候
      </h2>
      <input type="submit" id="check" name="action" style="display: none" />
    </div>
    
    <form name="form1" action="${pageContext.request.contextPath}/front-end/order/select_Order" method="post"> </form> 


    <script>
      var card = document.getElementById("card");
      window.setTimeout(function () {
        card.innerHTML = "交易完成";
        document.getElementById("check").style.display = "inline";
        document.getElementById("spinner").style.display = "none";
        submit();
      }, 5000);
      
      function submit(){
    	  window.setTimeout(function () {
    	    
    	        document.form1.submit() ;
    	        
    	      }, 2000);
      }
      
      $(".loader-inner").loaders();
    </script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  </body>
	 
</body>
</html>