<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/24
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>YouDao</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>


<div class="container" style="padding: 100px">
    <h2>有道翻译</h2>
    <input type="text" class="input-xlarge" name="keyword" id="keyword">
    <div class="explains"></div>
</div>

<script src="/static/jquery/jquery-1.11.3.min.js"></script>
<script>

    $(function () {
        $("#keyword").keyup(function (event) {
            if(event.keyCode == 13){
                var $keyword = $(this).val();
                $.ajax({
                    url:"http://fanyi.youdao.com/openapi.do?keyfrom=kaishengit&key=1587754017&type=data&doctype=json&callback=?&version=1.1",
                    type:"get",
                    data:{"q":$keyword},
                    timeout:"3000",
                    success: function (data) {
                        var array = data.basic.explains;
                        var str = "";
                        for(var i = 0;i<array.length ; i++){
                            str+=array[i] +"</br>";
                        }
                        $(".explains").html(str);
                    },
                    error: function () {
                        console.log("获取解释失败");
                    },
                    complete: function () {
                        console.log("完成获取");
                    },
                    beforeSend: function () {
                        console.log("获取开始");
                    }
                    
                });
            }
        });
    });

    /*$(function () {
        $("#keyword").keyup(function (event) {
            if (event.keyCode == 13) {
                var $keyword = $(this).val();
                $.getJSON("http://fanyi.youdao.com/openapi.do?keyfrom=kaishengit&key=1587754017&type=data&doctype=jsonp&callback=?&version=1.1",
                        {"q": $keyword})
                        .done(function (data) {
                            var array = data.basic.explains;
                            console.log(array);
                            var explain = "";
                            for (var i = 0; i < array.length; i++) {
                                explain += array[i] + "</br>";
                            }
                            $(".explains").html(explain);
                        })
                        .fail(function () {
                            console.log("失败");
                        })
                        .always(function () {
                            console.log("OK");
                        })
            }
        });
    });*/
    



</script>
</body>
</html>
