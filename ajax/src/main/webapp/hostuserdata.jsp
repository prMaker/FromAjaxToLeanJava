<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/22
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hostuserdata</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>

    <div class="container">

        用户名：<input type="text" class="input-large" id="username">
        地址：<input type="text" class="input-large" id="address">

    </div>

    <script>

        (function () {

            function createXmlHttp (){
                var xmlHttp = null;
                if(window.ActiveXObject){
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }else{
                    xmlHttp = new XMLHttpRequest();
                }
                return xmlHttp;
            }

            function createParams(isPost,paramsObject){
                var params = "";
                if(!isPost){
                    params = "?";
                }
                for(var key in paramsObject){
                    params += key+"="+paramsObject[key]+"&";
                }
                if(isPost){
                    if(params.lastIndexOf("&") == params.length-1){
                        params = params.substring(0,params.lastIndexOf("&"));
                    }
                }else{
                    params += new Date().getTime();
                }
                return params;
            }

            document.querySelector("#address").onchange = function () {

                var username = document.querySelector("#username").value;
                var address = document.querySelector("#address").value;
                console.log(username+":"+address);
                var xmlHttp = createXmlHttp();
                xmlHttp.open("post","/hostuserdata",true);
                xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

                xmlHttp.send(createParams(true,{username:username,address:address}));

            }

        })();

    </script>
</body>
</html>
