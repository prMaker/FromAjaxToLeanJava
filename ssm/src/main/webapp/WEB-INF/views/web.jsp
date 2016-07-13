<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/7/13
  Time: 7:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>web</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/js/webupload/webuploader.css">
</head>
<body>
<div class="container">
    <input type="file">

    <div id="picker">选择文件</div>
    <ul id="fileList"></ul>
</div>

<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/webupload/webuploader.min.js"></script>
<script>

    $(function () {

        var upload = WebUploader.create({
            swf: "/static/js/webupload/Uploader.swf",
            server: "",
            pick: "#picker",
            fileVal: "file"
        });

        upload.on("fileQueued", function (file) {
            console.log(file.id + ":" + file.name);
            var html = "<li id=" + file.id + ">" + file.name + "</li>";
            $("#fileList").append(html);
        });

        upload.on("uploadProgress", function (file,percentage) {
            var $li =

        });
    });

</script>
</body>
</html>
