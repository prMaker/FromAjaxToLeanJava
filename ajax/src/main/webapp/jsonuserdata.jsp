<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/23
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>

<div class="container" style="padding: 50px;">

    <input type="text" class="input-large" id="username">
    <p id="checkuser"></p>
    <hr>
    <h2>Ajax UserData Display</h2>
    <button id="read">READ</button>
    <div id="userdata">
        <div><h3>1</h3><p><h2>Tom <small>18</small></h2></p>
        <p><h2>China</h2></p>
        </div>
    </div>

</div>
<script src="/static/jquery/jquery-1.11.3.min.js"></script>

<script>

    $(function () {
        $("#username").change(function () {
            var username = $(this).val();
            $.get("/jsonuser", {username: username}, function (result) {
                if (result == "yes") {
                    $("#checkuser").text("该用户名可以使用");
                } else {
                    $("#checkuser").text("该用户名已存在");
                }
            });
        });


        // post方式获取xml文件值
        $("#read").click(function () {

            $.post("/jsonuser.xml",function (result) {
                $(result).find("user").each(function () {
                    var id = $(this).attr("id");
                    var name = $(this).find("username").text();
                    var address = $(this).find("address").text();
                    var userage = $(this).find("userage").text();
                    console.log(id +" -> "+name+" -> "+address+" -> "+userage);
                    $("#userdata").append("<div><h3>"+id+"</h3><p><h2>"+name+"<small>"+userage+"</small></h2></p><p><h2>"+address+"</h2></p></div>");
                });
            });
        });

        // post方式添加userdata资料
//        $("#read").click(function () {
//            var $userdata = $("#userdata");
//            $("#userdata").html("");
//            $.post("/jsonuser.json", function (result) {
//                if(result){
//                    var userList = JSON.parse(result);
//                    for(var i = 0;i<userList.length;i++){
//                        var user = userList[i];
//                        $userdata.append("<div><p><h2>"+user.name+" <small>"+user.address+"</small></h2></p> <p>"+user.score+"</p></div>");
//                    }
//                }
//            });
//        });


    });


    //    $(document).ready(function () {
    //
    //    });

</script>
</body>
</html>
