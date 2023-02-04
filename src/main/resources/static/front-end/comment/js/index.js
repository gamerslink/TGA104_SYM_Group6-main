var user_id = "teacher";

function init(){
  //$("ul.task_list").html('<li style="text-align: center;"><i class="fas fa-spinner fa-spin fa-3x"></i></li>');

  $.ajax({
    url: "https://notes.webmix.cc/ajax/teach/api/list.php",           // 資料請求的網址
    //url: "https://ajax_teach.webmix.cc/ajax/teach/api/list.php",
    type: "GET",                  // GET | POST | PUT | DELETE | PATCH
    data: {"user_id": user_id},                  // 傳送資料到指定的 url
    dataType: "json",             // 預期會接收到回傳資料的格式： json | xml | html
    beforeSend: function(){       // 在 request 發送之前執行
      $("ul.task_list").html('<li style="text-align: center;"><i class="fas fa-spinner fa-spin fa-3x"></i></li>');
    },
    success: function(data){      // request 成功取得回應後執行

      console.log(data);

      let list_html = '';
      // [{}, {}]
      $.each(data, function(index, item){


        list_html += '<li data-id="' + item.item_id + '" data-star="' + item.star + '" data-sort="' + item.sort + '">';
        list_html +=   '<div class="item_flex">';
        list_html +=     '<div class="left_block">';
        list_html +=       '<div class="btn_flex">';
        list_html +=         '<button type="button" class="btn_up">往上</button>';
        list_html +=         '<button type="button" class="btn_down">往下</button>';
        list_html +=       '</div>';
        list_html +=     '</div>';
        list_html +=     '<div class="middle_block">';
        list_html +=       '<div class="star_block">';
        list_html +=         '<span class="star' + (item.star >= 1 ? " -on" : "") + '" data-star="1"><i class="fas fa-star"></i></span>';
        list_html +=         '<span class="star' + (item.star >= 2 ? " -on" : "") + '" data-star="2"><i class="fas fa-star"></i></span>';
        list_html +=         '<span class="star' + (item.star >= 3 ? " -on" : "") + '" data-star="3"><i class="fas fa-star"></i></span>';
        list_html +=         '<span class="star' + (item.star >= 4 ? " -on" : "") + '" data-star="4"><i class="fas fa-star"></i></span>';
        list_html +=         '<span class="star' + (item.star >= 5 ? " -on" : "") + '" data-star="5"><i class="fas fa-star"></i></span>';
        list_html +=       '</div>';
        list_html +=       '<p class="para">' + item.name + '</p>';
        list_html +=       '<input type="text" class="task_name_update -none" placeholder="更新待辦事項…" value="' + item.name + '">';
        list_html +=     '</div>';
        list_html +=     '<div class="right_block">';
        list_html +=       '<div class="btn_flex">';
        list_html +=         '<button type="button" class="btn_update">更新</button>';
        list_html +=         '<button type="button" class="btn_delete">移除</button>';
        list_html +=       '</div>';
        list_html +=     '</div>';
        list_html +=   '</div>';
        list_html += '</li>';

      });

      $("ul.task_list").html(list_html);
    },
    error: function(xhr, textStatus, errorThrown){         // request 發生錯誤的話執行
      console.log("error");
      console.log(xhr);
      //console.log(textStatus);
      //console.log(errorThrown);
    }
  });

}

// 更新整體的排序
