<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/7/4
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h2>NewUser</h2>
    <form method="post">
        <h3>您是第${curr_user}位注册的人</h3>
        用户名：<input type="text" name="username">
        地址：<input type="text" name="address">
        <button>保存</button>
    </form>

</body>
</html>
