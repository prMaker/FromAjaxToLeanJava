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

    <%--TODO 保留搜索文字--%>
    <div class="well well-sm">
        <form method="get" class="form-inline">
            <div class="form-group">
                <input type="text" placeholder="书籍名称" value="${pathVar.q_like_bookname}" name="q_like_bookname" class="form-control">
            </div>
            <div class="form-group">
                <input type="text" placeholder="最低价格" value="${pathVar.q_ge_bookprice}" name="q_ge_bookprice" class="form-control">
            </div>
            <div class="form-group">
                <input type="text" placeholder="最高价格" value="${pathVar.q_le_bookprice}" name="q_le_bookprice" class="form-control">
            </div>
            <button class="btn btn-default">搜索</button>
        </form>
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
            <c:forEach items="${bookPage.items}" var="book">
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
    <ul class="pagination pull-right" id="page"></ul>

</div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/jquery.twbsPagination.min.js"></script>
<script>

    $(function () {
        $("#page").twbsPagination({
            totalPages:${bookPage.totalPages},
            visiblePages:10,
            first:'首页',
            prev:'上一页',
            next:'下一页',
            last:'末页',
            href:'?q_like_bookname=${pathVar.q_like_bookname}&q_ge_bookprice=${pathVar.q_ge_bookprice}&q_ge_bookprice=${pathVar.q_le_bookprice}&p={{number}}'
        });
    });


</script>
</body>
</html>
