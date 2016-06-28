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
    <button id="register">注册</button>
    <hr>
    <h2>Ajax UserData Display</h2>
    <button id="read">READ</button>
    <div id="userdata">
    </div>

</div>
<script src="/static/jquery/jquery-1.11.3.min.js"></script>

<script>

    $(function () {

//        function$("#username").change(function () {
//            var username = $(this).val();
//            $.get("/jsonuser.json", {username: username})
//                    .done(function (result) {
//                        if (result == "yes") {
//                            $("#checkuser").text("该用户名可以使用");
//                            alert("注册成功！");
//                        } else {
//                            $("#checkuser").text("该用户名已存在");
//                        }
//                    })
//                    .fail(function () {
//                        alert("请求服务器异常！");
//                    })
//                    .always(function () {
//                        console.log("祝你使用愉快");
//                    });
//        });

        $("#username").change(function () {

            var username = $(this).val();
            $.ajax({
                url: "/jsonuser.json",
                type: "get",
                data: {"username": username},
                timeout: 3000,
                success: function (result) {
                    $("#checkuser").html("");
                    console.log(result);
                    if ("yes" == result) {
                        $("#checkuser").append("<h4>该用户名可以使用<h4>");
                    } else {
                        $("#checkuser").append("<h4>该用户名已存在，请重新输入<h4>");
                    }

                    console.log(11111111111111111111111111111);
                },
                error: function () {
                    alert("请求");
                },
                complete: function () {
                    $("#register").text("注册").removeAttr("disabled");
                    console.log("succeed");
                },
                beforeSend: function () {
                    $("#register").text("注册中...").attr("disabled","disabled");
                }

            });

        });


        // post方式获取xml文件值
//        $("#read").click(function () {
//
//            $.post("/jsonuser.xml",function (result) {
//                $(result).find("user").each(function () {
//                    var id = $(this).attr("id");
//                    var name = $(this).find("username").text();
//                    var address = $(this).find("address").text();
//                    var userage = $(this).find("userage").text();
//                    console.log(id +" -> "+name+" -> "+address+" -> "+userage);
//                    $("#userdata").append("<div><h3>"+id+"</h3><p><h2>"+name+"<small>"+userage+"</small></h2></p><p><h2>"+address+"</h2></p></div>");
//                });
//            });
//        });

        // post方式添加userdata资料 原始Json解析
        $("#read").click(function () {
            var $userdata = $("#userdata");
            $("#userdata").html("");
            $.post("/jsonuser.json", function (result) {
                        if (result) {
                            var userList = JSON.parse(result);
                            for (var i = 0; i < userList.length; i++) {
                                var user = userList[i];
                                $userdata.append("<div><p><h2>" + user.name + " <small>" + user.address + "</small></h2></p> <p>" + user.score + "</p></div>");
                            }
                        }
                    })
                    .done(function () {
                        console.log("011321315");
                    })
                    .fail(function () {
                        alert("请求服务器异常！");
                    })
                    .always(function () {
                        console.log("...");
                    });
        });


    });


    //    $(document).ready(function () {
    //
    //    });

</script>
</body>
</html>
