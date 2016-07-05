<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/7/5
  Time: 15:58
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
        <h2>图书列表</h2>
    </div>

    <c:if test="${not empty message}">
        <div class="alert alert-danger">${message}</div>
    </c:if>

    <div class="well well-sm">
        <form action="" method="get" class="form-inline">
            <div class="form-group">
                <input type="text" placeholder="书籍名称" name="bookname" value="${bookname}"
                       class="form-control"/>
            </div>
                <select name="type" class="form-control">
                        <option value="">请选择类型</option>
                    <c:forEach items="${types}" var="type">
                        <option value="${type.id}" ${typeid == type.id ? 'selected' : ''}>${type.booktype}</option>
                    </c:forEach>
                </select>

            <%--下拉菜单为在select中选择--%>


                <select name="pub" class="form-control">
                    <option value="">请选择出版社</option>
                    <c:forEach items="${publishers}" var="publisher">
                        <option value="${publisher.id}" ${pubid == publisher.id ? 'selected' : ''}>${publisher.pubname}</option>
                    </c:forEach>
                </select>

            <button class="btn btn-primary">搜索</button>

        </form>


    </div>
    
    <a href="/books/new" class="btn btn-success">添加新书</a>
    <table class="table">
        <thead>
            <tr>
                <th>书名</th>
                <th>价格</th>
                <th>作者</th>
                <th>数量</th>
                <th>类型</th>
                <th>出版社</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${bookPage.items}" var="book">
            <tr>
                <td>${book.bookname}</td>
                <td>${book.bookprice}</td>
                <td>${book.bookauthor}</td>
                <td>${book.booknum}</td>
                <td>${book.bookType.booktype}</td>
                <td>${book.publisher.pubname}</td>
                <td>
                    <a href="javascript:;" class="del btn btn-danger" rel="${book.id}" id="del">删除</a>
                    <a href="/books/${book.id}/edit" class="btn btn-success">修改</a>
                </td>
            </tr>
        </tbody>
        </c:forEach>
    </table>
    <c:if test="${empty bookPage.items}">
        <div class="alert-info"><h3>没有找到相关信息</h3></div>
    </c:if>
    <ul class="pagination" id="page"></ul>
</div>

<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/jquery.twbsPagination.min.js"></script>
<script>

    $(function () {
        $("#del").click(function () {
            var id = $(this).attr("rel");
            if(confirm("确定删除该书籍")){
                window.location.href="/books/"+id+"/del";
            }
        });

        $("#page").twbsPagination({
            totalPages:${bookPage.totalPages},
            visiblePages:5,
            first:'首页',
            prev:'上一页',
            next:'下一页',
            last:'末页',
            href:'?p={{number}}'
        });
    });


</script>
</body>
</html>
