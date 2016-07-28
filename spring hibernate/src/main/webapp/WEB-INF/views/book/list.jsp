<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/7/28
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="page-header">
        <h3>书籍列表</h3>
    </div>
    <a href="/book/new" class="btn btn-primary btn-xs pull-right">添加书籍</a>
    <table class="table">
        <thead>
            <tr>
                <th>书名</th>
                <th>价格</th>
                <th>作者</th>
                <th>数量</th>
                <th>出版社</th>
                <th>类型</th>
                <th>#</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${bookList}" var="book">
                <tr>
                    <td>${book.bookname}</td>
                    <td>${book.bookprice}</td>
                    <td>${book.bookauthor}</td>
                    <td>${book.booknum}</td>
                    <td>${book.publisher.pubname}</td>
                    <td>${book.bookType.booktype}</td>
                    <td>
                        <a href="/book/${book.id}/edit">编辑</a>
                        <a href="/book/${book.id}/del">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>



    </table>




</div>

</body>
</html>
