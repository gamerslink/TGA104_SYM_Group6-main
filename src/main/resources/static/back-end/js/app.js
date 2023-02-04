
/**圖片預覽 */
var preview_el = document.getElementById("preview");
var p_file_el = document.getElementById("p_file");
var btn_submit_el = document.getElementById("btn_submit");
var p_name_el = document.getElementById("p_name");


// =========================== 透過 File 取得預覽圖 ========================= //
var preview_img = function(file) {

	var reader = new FileReader(); // 用來讀取檔案
	reader.readAsDataURL(file); // 讀取檔案
	reader.addEventListener("load", function() {


		let img_str = '<img src="' + reader.result + '" class="preview_img">';
		preview_el.innerHTML = img_str;
	});
};


p_file_el.addEventListener("change", function(e) {
	if (this.files.length > 0) {
		preview_img(this.files[0]);
	} else {
		preview_el.innerHTML = '<span class="text">預覽圖</span>';
	}
});


/** 動畫 */
const text = document.querySelectorAll(".thePaths");

for (let i = 0; i < text.length; i++) {
  console.log(`text number ${i} length is ${text[i].getTotalLength()}`);
}

const lastWord = document.querySelector("#eighth");
const animation = document.querySelector("div.animation");
lastWord.addEventListener("animationend", () => {
  animation.style =
    "transition: all 2s ease; opacity: 0; pointer-events: none;";
});
