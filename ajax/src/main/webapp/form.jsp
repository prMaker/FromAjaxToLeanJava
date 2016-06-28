<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/26
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-xs-4">
            <form id="regForm">
                <legend>注册表单</legend>
                <div class="form-actions">
                    <label>账号</label>
                    <input type="text" class="form-control" name="username">
                </div>
                <div class="form-actions">
                    <label>密码</label>
                    <input type="text" class="form-control" name="password">
                </div>
                <div class="form-actions">
                    <label>个人简介</label>
                    <input type="text" class="form-control" name="other">
                </div>
                <div class="form-actions">
                    <button class="btn btn-primary" id="subBtn" type="button">注册</button>
                </div>
            </form>
        </div>
    </div>
</div>


</body>
</html>
