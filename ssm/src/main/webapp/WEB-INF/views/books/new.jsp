<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/7/5
  Time: 16:33
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
            <h2>添加新书</h2>
        </div>


        <form method="post" >
            <div class="col-xs-6">
                <div class="form-group">
                    <label>书名：</label>
                    <input type="text" class="form-control" name="bookname">
                </div>

                <div class="form-group">
                    <label>价格：</label>
                    <input type="text" class="form-control" name="bookprice">
                </div>

                <div class="form-group">
                    <label>作者：</label>
                    <input type="text" class="form-control" name="bookauthor">
                </div>

                <div class="form-group">
                    <label>数量：</label>
                    <input type="text" class="form-control" name="booknum">
                </div>

                <div class="form-group">
                    <label>书籍类型：</label>
                    <select name="typeid" class="form-control" >
                        <c:forEach items="${bookTypeList}" var="type">
                            <option value="${type.id}">${type.booktype}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label>出版社：</label>
                    <select name="pubid" class="form-control">
                        <c:forEach items="${publisherList}" var="pub">
                            <option value="${pub.id}">${pub.pubname}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <button class="btn btn-primary">保存</button>
                </div>
            </div>
        </form>
    </div>

</body>
</html>
