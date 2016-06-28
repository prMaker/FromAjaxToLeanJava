<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/22
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div class="container">

    <h2>RSS</h2>
    <input type="text" id="url" class="input-large">
    <div id="linkhome">
        <p><a href="http://blog.sina.com.cn/shanzhiqiang">单之蔷的BLOG</a></p>
    </div>

</div>

<script>
    function createLi(title, link) {
        var p = document.createElement("p");
        var a = document.createElement("a");
        var text = document.createTextNode(title);
        a.appendChild(text);
        a.setAttribute("href",link);
        a.setAttribute("target","_blank");
        var div = document.querySelector("#linkhome");
        p.appendChild(a);
        div.appendChild(p);
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
    document.querySelector("#url").onkeyup = function (event) {
        if (event.keyCode == 13) {

            var url = this.value;
            var xmlHttp = createXmlHttp();
            xmlHttp.open("get", "/rss.xml?url=" + encodeURIComponent(url), true);
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4) {
                    if (xmlHttp.status == 200) {
                        var xmlText = xmlHttp.responseXML;
                        var itemsArray = xmlText.getElementsByTagName("item");
                        for (var i = 0; i < itemsArray.length; i++) {
                            var title = itemsArray[i].getElementsByTagName("title")[0].childNodes[0].nodeValue;
                            var link = itemsArray[i].getElementsByTagName("link")[0].childNodes[0].nodeValue;
                            console.log(title +":"+ link);
                            createLi(title,link);
                        }
                    }
                }
            }
            xmlHttp.send();
        }

    }


</script>

</body>
<head>
    <title>ThirdPartyServiceRss</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
</html>
