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
    <link rel="stylesheet" href="/repo/css/bootstrap.min.css">
</head>
<body>

<div class="container">

    <div class="page-header">
        <h2>新增图书</h2>
    </div>

    <form action="/book/editsave" method="post">

        <input type="hidden" name="book.id" value="${book.id}">

        <div  class="form-group">
            <h3>书名：</h3><input type="text" value="${book.bookname}" class="form-control" name="book.bookname">
        </div>
        <div class="form-group">
            <h3>价格：</h3><input type="text" value="${book.bookprice}" class="form-control" name="book.bookprice">
        </div>
        <div class="form-group" >
            <h3>作者：</h3><input type="text" value="${book.bookauthor}" class="form-control" name="book.bookauthor">
        </div>
        <div class="form-group">
            <h3>数量：</h3><input type="text" value="${book.booknum}" class="form-control" name="book.booknum">
        </div>
        <div class="form-group">
            <h3>类型：</h3>
            <select name="book.bookType.id" class="form-control">
                <c:forEach items="${bookTypeList}" var="bookType">
                    <option ${book.bookType.id==bookType.id ? 'selected' : ''} value="${bookType.id}">${bookType.booktype}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <h3>出版社：</h3>
            <select name="book.publisher.id" class="form-control">
            <c:forEach items="${publisherList}" var="publisher">
                <option ${book.publisher.id==publisher.id ? 'selected' : ''} value="${publisher.id}">${publisher.pubname}</option>
            </c:forEach>
            </select>
        </div>

        <button class="btn btn-success">提交保存</button>




    </form>




</div>

</body>
</html>
