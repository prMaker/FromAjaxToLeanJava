<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/1
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/login" method="post">

    <c:if test="${param.code == 10002}">
        <div><h3>请登录后再试</h3></div>
    </c:if>
    <c:if test="${param.code == 10009}">
        <div><h3>用户名或密码错误，请登录后再试</h3></div>
    </c:if>

    <div>账号：<input type="text" name="username"></div>
    <div>密码：<input type="text" name="password"></div>
    <button>登录</button>

</form>
</body>
</html>
