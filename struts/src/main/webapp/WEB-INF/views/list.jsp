<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/1
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

List Jsp

<a href="/user/newData">新建</a>
<ul>
    <c:forEach items="${names}" var="name">
        <li>${name}</li>
    </c:forEach>
</ul>

</body>
</html>
