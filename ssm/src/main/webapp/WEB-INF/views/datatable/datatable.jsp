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

    <div class="page-header"><h2>书籍列表</h2></div>

    <a href="javascript:;" id="newBookBtn" class="btn btn-primary" style="margin-bottom: 20px">新增书籍</a>

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
                <td>

                </td>
            </tr>
            </c:forEach>
    </tbody>
    </table>
</div>

<!-- Modal -->
<div class="modal fade" id="newBookModel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">新增书籍</h4>
            </div>
            <div class="modal-body">


                <form id="newBookForm" >
                    <div >
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
                            <input type="text" class="form-control" name="booknum" >
                        </div>

                        <div class="form-group">
                            <label>书籍类型：</label>
                            <select name="typeid" class="form-control" >
                                <c:forEach items="${types}" var="type">
                                    <option value="${type.id}">${type.booktype}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>出版社：</label>
                            <select name="pubid" class="form-control" >
                                <c:forEach items="${pubs}" var="pub">
                                    <option value="${pub.id}">${pub.pubname}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </form>


            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="saveBtn">保存</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="editBookModel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改书籍</h4>
            </div>
            <div class="modal-body">


                <form id="editBookForm" >
                    <div >
                        <div class="form-group">
                            <label>书名：</label>
                            <input type="text" class="form-control" name="bookname" id="bookname">
                        </div>

                        <div class="form-group">
                            <label>价格：</label>
                            <input type="text" class="form-control" name="bookprice" id="bookprice">
                        </div>

                        <div class="form-group">
                            <label>作者：</label>
                            <input type="text" class="form-control" name="bookauthor" id="bookauthor">
                        </div>

                        <div class="form-group">
                            <label>数量：</label>
                            <input type="text" class="form-control" name="booknum" id="booknum">
                        </div>

                        <div class="form-group">
                            <label>书籍类型：</label>
                            <select name="typeid" class="form-control" id="typeid">
                                <c:forEach items="${types}" var="type">
                                    <option value="${type.id}">${type.booktype}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>出版社：</label>
                            <select name="pubid" class="form-control" id="pubid">
                                <c:forEach items="${pubs}" var="pub">
                                    <option value="${pub.id}">${pub.pubname}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </form>


            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="editBookBtn">修改</button>
            </div>
        </div>
    </div>
</div>


<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/datatables/js/jquery.dataTables.min.js"></script>
<script src="/static/js/datatables/js/dataTables.bootstrap.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/jquery.validate.min.js"></script>
<script>
    $(function () {

        $("#newBookForm").validate({
            errorElement:'span',
            errorClass:'text-danger',
            rules:{
                bookname:{
                    required:true
                },
                bookprice:{
                    required:true,
                    number:true
                },
                bookauthor:{
                    required:true
                },
                booknum:{
                    required:true,
                    digits:true
                },
                typid:{
                    required:true
                },
                pubid:{
                    required:true
                }
            },
            messages:{
                bookname:{
                    required:"请输入书籍名称"
                },
                bookprice:{
                    required:"请输入价格"
                },
                bookauthor:{
                    required:"请输入作者"
                },
                booknum:{
                    required:"请输入数量"
                }
            },
            submitHandler: function (form) {
                $.post("/datatable/new",$(form).serialize())
                        .done(function (data) {
                            if(data=="success"){
                                $("#newBookModel").modal('hide');
                                $dataTable.ajax.reload();
                            }
                        })
                        .fail(function () {
                    alert("请求服务器错误");
                });
            }
        });

        $("#newBookBtn").click(function () {
            $("#newBookForm")[0].reset();

            $("#newBookModel").modal({
                show:true,
                backdrop:'static',
                keyboard:false
            });
        });

        $("#saveBtn").click(function () {
            $("#newBookForm").submit();
        });

        $("document").delegate("#editBtn","click", function () {
            var id = $(this).attr("rel");
            $.get("/datatable/edit/"+id)
                    .done(function (data) {
                        $("#bookname").val(data.id);
                        $("#bookprice").val(data.bookprice);
                        $("#bookauthor").val(data.bookauthor);
                        $("#booknum").val(data.booknum);
                        $("#typeid").val(data.type.id);
                        $("#pubid").val(data.pubid);
                    })
                    .fail(function () {
                        alert("请求服务器错误");
                    });
        });

        $("document").delegate("#delBtn","click", function () {
            var id = $(this).val();
            $.get("/del/"+id)
                    .done(function (data) {
                        if(data == "success"){
                            $dataTable.ajax.reload();
                        }
                    })
                    .fail(function () {

                    });
        });

        var $dataTable = $("#datatable").DataTable({
            "serverSide":true,
            "ajax":"/datatable/data.json",
            "lengthMenu":[5,10,25,50],
            "order":[0,"desc"],
            "columns":[
                {"data":"id","name":"id"},
                {"data":"bookname"},
                {"data":"bookprice"},
                {"data":"bookauthor","name":"bookprice"},
                {"data":"booknum","name":"booknum"},
                {"data":"publisher.pubname"},
                {"data":"bookType.booktype","name":"typeid"},
                {"data":function(row){
                    return "<a href='javascript:;' id='editBtn' rel='"+"${book.id}"+"'>修改</a>"+
                            "&nbsp;&nbsp;<a href='javascript:;' id='delBtn' rel='"+"${book.id}"+"'>删除</a>";
                }}
            ],
            "columnDefs":[ //定义列的特征
                {targets: [0], visible: false},
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
