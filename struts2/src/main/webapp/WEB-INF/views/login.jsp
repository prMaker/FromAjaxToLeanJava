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

    <form action="/home/login" method="post">

        <input type="text" name="username">
        <input type="text" name="password">
        <button>Login</button>

    </form>


</div>

</body>
</html>
