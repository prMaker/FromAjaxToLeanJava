<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/22
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dict</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>

<div class="container pagination-centered">

    <h2>有道汉英互译</h2>
    <input type="text" class="input-large" id="word">
    <div class="pagination-centered" id="explain">
        <p></p>
    </div>
</div>

<script>

    function createP(paraphrase) {
        var explain = document.querySelector("#explain");
        var p = document.createElement("p");
        var text = document.createTextNode(paraphrase);
        p.appendChild(text);
        p.setAttribute("style","color:blue;");
        explain.appendChild(p);
    }
    (function () {

        function createXmlHttp(){

            var xmlHttp = null;

            if(window.ActiveXObject){
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }else{
                xmlHttp = new XMLHttpRequest();
            }
            return xmlHttp;
        }

        document.querySelector("#word").onkeyup = function (event) {
            if(event.keyCode == 13){
                var div = document.querySelector("#explain");
                div.innerHTML = "";
                var word = this.value;
                var xmlHttp = createXmlHttp();
                xmlHttp.open("get","/dict?word="+encodeURIComponent(word),true);

                xmlHttp.onreadystatechange = function () {
                    if(xmlHttp.readyState == 4){
                        if(xmlHttp.status == 200){
                            var xmlText = xmlHttp.responseXML;
                            var basic = xmlText.getElementsByTagName("basic")[0];
                            var explains = basic.getElementsByTagName("explains")[0];
                            var exs = explains.getElementsByTagName("ex");
                            for(var i = 0;i<exs.length;i++){
                                var paraphrase = exs[i].childNodes[0].nodeValue;
                                console.log(paraphrase);
                                createP(paraphrase);
                            }

                        }else{
                            alert("请求服务器异常!");
                        }
                    }
                }

                xmlHttp.send();

            }

        }




    })();

</script>
</body>
</html>
