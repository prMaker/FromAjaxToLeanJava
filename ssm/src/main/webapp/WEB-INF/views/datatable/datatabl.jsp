<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/7/6
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/js/datatables/css/dataTables.bootstrap.min.css">
</head>
<body>

    <div class="container">

        <table class="table" id="datatable">
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
            <c:forEach items="${bookList}" var="book">
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

    </div>
    <script src="/static/js/jquery-1.11.3.min.js"></script>
    <script src="/static/js/datatables/js/jquery.dataTables.min.js"></script>
    <script src="/static/js/datatables/js/dataTables.bootstrap.min.js"></script>
    <script>

        $(function () {
            $("#datatable").DataTable({
                "serverSide":true,
                "ajax":"/datatable/data.json"
            });
        });

    </script>

</body>
</html>
