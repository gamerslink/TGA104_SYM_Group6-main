$('input[type=radio][name="custom_name"]').on("change", function () {
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
