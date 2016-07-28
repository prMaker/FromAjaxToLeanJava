<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/7/6
  Time: 13:32
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

    <div class="page-header">
        <h2>新增图书</h2>
    </div>

    <form action="" method="post">
        <div  class="form-group">
            <h3>书名：</h3><input type="text" class="form-control" name="bookname">
        </div>
        <div class="form-group">
            <h3>价格：</h3><input type="text" class="form-control" name="bookprice">
        </div>
        <div class="form-group" >
            <h3>作者：</h3><input type="text" class="form-control" name="bookauthor">
        </div>
        <div class="form-group">
            <h3>数量：</h3><input type="text" class="form-control" name="booknum">
        </div>
        <div class="form-group">
            <h3>类型：</h3>
            <select name="bookType.id" class="form-control">
                <c:forEach items="${bookTypeList}" var="bookType">
                    <option value="${bookType.id}">${bookType.booktype}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <h3>出版社：</h3>
            <select name="publisher.id" class="form-control">
            <c:forEach items="${publisherList}" var="publisher">
                <option value="${publisher.id}">${publisher.pubname}</option>
            </c:forEach>
            </select>
        </div>

        <button class="btn btn-success">提交保存</button>




    </form>




</div>

</body>
</html>
