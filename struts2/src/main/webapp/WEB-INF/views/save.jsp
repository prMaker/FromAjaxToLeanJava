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

    <h2>Save View</h2>

    <form action="/user/new" method="post">

        <input type="text" name="name" autofocus>
        <input type="text" name="pwd">
        <button>Save</button>

    </form>


</div>

</body>
</html>
