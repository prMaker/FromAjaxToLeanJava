<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/7/6
  Time: 17:11
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
            <th>ID</th>
            <th>书名</th>
            <th>价格</th>
            <th>作者</th>
            <th>数量</th>
            <th>出版社</th>
            <th>类型</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${bookList}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.bookname}</td>
                <td>${book.bookprice}</td>
                <td>${book.bookauthor}</td>
                <td>${book.booknum}</td>
                <td>${book.bookType.booktype}</td>
                <td>${book.publisher.pubname}</td>
                <td>#</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/datatables/js/jquery.dataTables.min.js"></script>
<script src="/static/js/datatables/js/dataTables.bootstrap.min.js"></script>
<script>
    $(function () {
        $("#datatable").DataTable({
            "serverSide":true,
            "ajax":"/datatable/data.json",
            "lengthMenu":[5,10,25,50],
            "columns":[
                {"data":"id","name":"id"},
                {"data":"bookname"},
                {"data":"bookprice"},
                {"data":"bookauthor","name":"bookprice"},
                {"data":"booknum","name":"booknum"},
                {"data":"publisher.pubname"},
                {"data":"bookType.booktype","name":"typeid"},
                {"data":function(row){
                    return "#";
                }}
            ],
            "columnDefs":[ //定义列的特征
                {targets: [0], visible: true},
                {targets:[1,2,5,7],orderable:false}
            ],
            "language":{ //定义中文
                "search": "请输入书籍名称:",
                "zeroRecords":    "没有匹配的数据",
                "lengthMenu":     "显示 _MENU_ 条数据",
                "info":           "显示从 _START_ 到 _END_ 条数据 共 _TOTAL_ 条数据",
                "infoFiltered":   "(从 _MAX_ 条数据中过滤得来)",
                "loadingRecords": "加载中...",
                "processing":     "处理中...",
                "paginate": {
                    "first":      "首页",
                    "last":       "末页",
                    "next":       "下一页",
                    "previous":   "上一页"
                },
            }
        });



    });
</script>

</body>
</html>
