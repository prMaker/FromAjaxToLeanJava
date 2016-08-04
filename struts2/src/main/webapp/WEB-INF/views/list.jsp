<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/3
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>

<div class="container">

    <h2>HomeList</h2>

    <c:if test="${param.code == '10002'}">
        <div class="text-danger">添加错误
        </div>
    </c:if>
    <c:forEach items="${names}" var="name">
        <div>${name}</div>
    </c:forEach>

    <a href="/user/tonew">新增</a>

</div>


</body>
</html>
