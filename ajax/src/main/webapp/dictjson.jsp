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
    <input type="text" class="input-xlarge" name="keyword" id="keyword">
    <button id="key"></button>
</div>

<script src="/static/jquery/jquery-1.11.3.min.js"></script>
<script>

    $("#keyword").keyup(function (event) {
        var keyword = $("#keyword").val();
        if (event.keyCode == 13) {
            $.get("/dictjson.json", {"keyword":keyword})
                    .done(function (result) {
                        console.log($(result).length);
                    })
                    .error(function () {
                        alert("请求服务器异常！");
                    })
                    .always(function () {
                        console.log("查询"+keyword);
                    });
        }
    });


</script>
</body>
</html>
