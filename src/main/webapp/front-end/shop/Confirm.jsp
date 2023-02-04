<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      body {
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        flex-direction: column;
      }

      h2 {
        font-family: Helvetica;
        font-size: 36px;
        margin-top: 40px;
        color: #333;
        opacity: 0;
      }

      input[type="checkbox"]:checked ~ h2 {
        animation: 0.6s title ease-in-out;
        animation-delay: 1.2s;
        animation-fill-mode: forwards;
      }

      .circle {
        stroke-dasharray: 1194;
        stroke-dashoffset: 1194;
      }

      input[type="checkbox"]:checked + svg .circle {
        animation: circle 1s ease-in-out;
        animation-fill-mode: forwards;
      }

      .tick {
        stroke-dasharray: 350;
        stroke-dashoffset: 350;
      }

      input[type="checkbox"]:checked + svg .tick {
        animation: tick 0.8s ease-out;
        animation-fill-mode: forwards;
        animation-delay: 0.95s;
      }

      @keyframes circle {
        from {
          stroke-dashoffset: 1194;
        }
        to {
          stroke-dashoffset: 2388;
        }
      }

      @keyframes tick {
        from {
          stroke-dashoffset: 350;
        }
        to {
          stroke-dashoffset: 0;
        }
      }

      @keyframes title {
        from {
          opacity: 0;
        }
        to {
          opacity: 1;
        }
      }

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

      body {
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        flex-direction: column;
      }

      h2 {
        font-family: Helvetica;
        font-size: 36px;
        margin-top: 40px;
        color: #333;
        opacity: 0;
      }

      input[type="checkbox"]:checked ~ h2 {
        animation: 0.6s title ease-in-out;
        animation-delay: 1.2s;
        animation-fill-mode: forwards;
      }

      .circle {
        stroke-dasharray: 1194;
        stroke-dashoffset: 1194;
      }

      input[type="checkbox"]:checked + svg .circle {
        animation: circle 1s ease-in-out;
        animation-fill-mode: forwards;
      }

      .tick {
        stroke-dasharray: 350;
        stroke-dashoffset: 350;
      }

      input[type="checkbox"]:checked + svg .tick {
        animation: tick 0.8s ease-out;
        animation-fill-mode: forwards;
        animation-delay: 0.95s;
      }

      @keyframes circle {
        from {
          stroke-dashoffset: 1194;
        }
        to {
          stroke-dashoffset: 2388;
        }
      }

      @keyframes tick {
        from {
          stroke-dashoffset: 350;
        }
        to {
          stroke-dashoffset: 0;
        }
      }

      @keyframes title {
        from {
          opacity: 0;
        }
        to {
          opacity: 1;
        }
      }
    </style>
  </head>
  <body>
  <form name="form1" action="${pageContext.request.contextPath}/front-end/order/select_Order" method="post"> </form> 
    <div
      class="spinner"
      id="spinner"
      style="text-align: center; line-height: 50px"
    >
      <div class="bounce1"></div>
      <div class="bounce2"></div>
      <div class="bounce3"></div>
    </div>
    <div class="voc">
      <h1 id="card" style="text-align: center">信用卡交易中, 請稍候</h1>
    </div>
    <input type="checkbox" id="checking" style="display: none" />
    <svg id="good" width="400" height="400" style="display: none">
      <circle
        fill="none"
        stroke="#68E534"
        stroke-width="15"
        cx="200"
        cy="200"
        r="110"
        class="circle"
        stroke-linecap="round"
        transform="rotate(-90 200 200) "
      />
      <polyline
        fill="none"
        stroke="#68E534"
        stroke-width="20"
        points="138,214 183,254 264,158"
        stroke-linecap="round"
        stroke-linejoin="round"
        class="tick"
      ></polyline>
    </svg>

    <script>
      var card = document.getElementById("card");
      window.setTimeout(function () {
        document.getElementsByClassName("spinner")[0].style.display = "none";
        document.getElementsByClassName("voc")[0].style.display = "none";
        document.getElementById("good").style.display = "inline";
        document.getElementById("checking").checked = "true";
        submit();
      }, 5000);
      
      function submit(){
    	  window.setTimeout(function () {
    	    
    	        document.form1.submit() ;
    	        
    	      }, 3000);
      }

      $(".loader-inner").loaders();
    </script>

    <h2>刷卡完成</h2>
  </body>
</html>
