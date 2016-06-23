<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/22
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USERDATA</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h2>XML AJAX userdata</h2>
    <button id="read">READ</button>
    <div id="userhome">
    </div>
</div>

<script>
    (function () {

        function createDiv(username, address, userage) {
            var div = document.createElement("div");
            div.setAttribute("id", username);
            var p = document.createElement("p");
            var nameh3 = document.createElement("h3");
            nameh3.appendChild(document.createTextNode(username + "  "));
            nameh3.appendChild(document.createElement("small").appendChild(document.createTextNode(userage)))
            p.appendChild(nameh3);
            p.appendChild(document.createElement("h3").appendChild(document.createTextNode(address)));
            div.appendChild(p);
            var dv = document.querySelector("#userhome");
            dv.appendChild(div);
        }

        function createXmlHttp() {
            var xmlHttp = null;

            if (window.ActiveXObject) {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            } else {
                xmlHttp = new XMLHttpRequest();
            }
            return xmlHttp;
        }

        document.querySelector("#read").onclick = function () {
            var dv = document.querySelector("#userhome");
            dv.innerHTML = "";
            var xmlHttp = createXmlHttp();
            xmlHttp.open("get", "/userdata.xml", true);
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4) {
                    if (xmlHttp.status == 200) {
                        var xmlText = xmlHttp.responseXML;
                        console.log(xmlText);
                        var elements = xmlText.getElementsByTagName("user");
                        for (var i = 0;i<elements.length;i++) {
                            var username = elements[i].getElementsByTagName("username")[0].childNodes[0].nodeValue;
                            var address = elements[i].getElementsByTagName("address")[0].childNodes[0].nodeValue;
                            var userage = elements[i].getElementsByTagName("userage")[0].childNodes[0].nodeValue;
                            createDiv(username, address, userage);
                        }
                    } else {
                        alert("请求服务器异常！");
                    }
                }

            }
            xmlHttp.send();

        }


    })
    ();


</script>
</body>
</html>
