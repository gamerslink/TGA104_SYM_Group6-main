$(document).ready(function () {
  // DOM ready

  // Test data
  /*
   * To test the script you should discomment the function
   * testLocalStorageData and refresh the page. The function
   * will load some test data and the loadProfile
   * will do the changes in the UI
   */
  // testLocalStorageData();
  // Load profile if it exits
  loadProfile();
});

/**
 * Function that gets the data of the profile in case
 * thar it has already saved in localstorage. Only the
 * UI will be update in case that all data is available
 *
 * A not existing key in localstorage return null
 *
 */
function getLocalProfile(callback) {
  var profileImgSrc = localStorage.getItem("PROFILE_IMG_SRC");
  var profileName = localStorage.getItem("PROFILE_NAME");
  var profileReAuthEmail = localStorage.getItem("PROFILE_REAUTH_EMAIL");

  if (
    profileName !== null &&
    profileReAuthEmail !== null &&
    profileImgSrc !== null
  ) {
    callback(profileImgSrc, profileName, profileReAuthEmail);
  }
}

/**
 * Main function that load the profile if exists
 * in localstorage
 */
function loadProfile() {
  if (!supportsHTML5Storage()) {
    return false;
  }
  // we have to provide to the callback the basic
  // information to set the profile
  getLocalProfile(function (profileImgSrc, profileName, profileReAuthEmail) {
    //changes in the UI
    $("#profile-img").attr("src", profileImgSrc);
    $("#profile-name").html(profileName);
    $("#reauth-email").html(profileReAuthEmail);
    $("#inputEmail").hide();
    $("#remember").hide();
  });
}

/**
 * function that checks if the browser supports HTML5
 * local storage
 *
 * @returns {boolean}
 */
function supportsHTML5Storage() {
  try {
    return "localStorage" in window && window["localStorage"] !== null;
  } catch (e) {
    return false;
  }
}

/**
 * Test data. This data will be safe by the web app
 * in the first successful login of a auth user.
 * To Test the scripts, delete the localstorage data
 * and comment this call.
 *
 * @returns {boolean}
 */
function testLocalStorageData() {
  if (!supportsHTML5Storage()) {
    return false;
  }
  localStorage.setItem(
    "PROFILE_IMG_SRC",
    "//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120"
  );
  localStorage.setItem("PROFILE_NAME", "César Izquierdo Tello");
  localStorage.setItem("PROFILE_REAUTH_EMAIL", "oneaccount@gmail.com");
}


// 使用 JavaScript 生成验证码图片
  // 获取 canvas 元素
  var canvas = document.getElementById('captchaCanvas');

  // 获取 canvas 的上下文
  var ctx = canvas.getContext('2d');

  // 生成随机验证码
  var captcha = '';
  for (var i = 0; i < 4; i++) {
    captcha += Math.floor(Math.random() * 10);
  }

  // 将验证码保存到 sessionStorage 中
  sessionStorage.setItem('captcha', captcha);

  // 在 canvas 上绘制验证码
  ctx.font = '30px sans-serif';
  ctx.fillText(captcha, 10, 30);
