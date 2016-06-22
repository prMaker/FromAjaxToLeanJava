<%--
  Created by IntelliJ IDEA.
  User: promaker
  Date: 2016/6/22
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>

    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>

    <div class="container">

        <input type="text" class="input-medium" id="username" style="margin: 50px;padding: 10px">
        <p id="patchca"></p>

    </div>

    <script>

        function createXmlHttp(){
            var xmlHttp = null;
            if(window.ActiveXObject){
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }else{
                xmlHttp = new XMLHttpRequest();
            }
            return xmlHttp;
        }

        document.querySelector("#username").onchange = function () {
            var xmlHttp = createXmlHttp();
            var username = this.value;
            xmlHttp.open("get","/register?username="+encodeURIComponent(username),true);

            xmlHttp.onreadystatechange = function () {
                document.querySelector("#patchca").innerHTML = "";
                if(xmlHttp.readyState == 4){
                    if(xmlHttp.status == 200){
                        var result = xmlHttp.responseText;
                        if(result == 'yes'){
                            document.querySelector("#patchca").appendChild(document.createTextNode("该用户名可以使用"));
                        }else{
                            document.querySelector("#patchca").appendChild(document.createTextNode("该用户已存在，请重新输入"));
                        }
                    }else{
                        alert("请求服务器异常");
                    }
                }
            }
            xmlHttp.send();
        }

    </script>
</body>
</html>
