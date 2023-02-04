$('input[type="radio"][name="custom_name"]').on("change", function () {
  //   console.log($(this).val());
  switch ($(this).val()) {
    case "1":
      $("#shop_input_text").show();
      //   console.log("1");
      break;
    case "2":
      $("#shop_input_text").hide();
      //   console.log("2");
      break;
  }
});

$(document).ready(function () {
  $("#shop_input_text").hide();
});

$("input#userPhoto").on("change", function (e) {
  console.log("rrr");
  const file = this.files[0]; //將上傳檔案轉換為base64字串

  const fr = new FileReader(); //建立FileReader物件
  fr.onload = function (e) {
    $("img.user_img").attr("src", e.target.result); //读取的结果放入圖片
  };

  // 使用 readAsDataURL 將圖片轉成 Base64
  fr.readAsDataURL(file);
});






