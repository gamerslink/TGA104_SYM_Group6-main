window.addEventListener("load", function (e) {
  // =========================== 元素 ========================= //

  var p_file_el = document.getElementById("p_file");

  // =========================== 透過 File 取得預覽圖 ========================= //
  var preview_img = function (file) {
    var reader = new FileReader(); // 用來讀取檔案
    reader.readAsDataURL(file); // 讀取檔案
    reader.addEventListener("load", function () {
      //console.log(reader.result);
      /*
      let img_node = document.createElement("img"); // <img>
      img_node.setAttribute("src", reader.result); // <img src="base64">
      img_node.setAttribute("class", "preview_img"); // <img src="base64" class="preview_img">
      preview_el.innerHTML = '';
      preview_el.append(img_node);
      */

      let img_str = '<img src="' + reader.result + '" class="preview_img">';
      preview_el.innerHTML = img_str;
    });
  };

//  p_file_el.addEventListener("change", function (e) {
//    if (this.files.length > 0) {
//      preview_img(this.files[0]);
//    } else {
//      preview_el.innerHTML = '<span class="text">預覽圖</span>';
//    }
//  });
});
