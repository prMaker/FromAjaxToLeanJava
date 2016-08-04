<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/3
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>

<div class="container">

    <h2>Login View</h2>

    <c:if test="${param.code == '10001'}">
        请登录后再试
    </c:if>
    <c:if test="${param.code == '10004'}">
        密码错误，请重试
    </c:if>

    <form action="/login" method="post">

        <input type="text" name="username" autofocus>
        <input type="text" name="password">
        <button>Login</button>

    </form>


</div>

</body>
</html>
