<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>凯盛CRM|公告</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/static/plugins/fontawesome/css/font-awesome.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="/static/dist/css/skins/skin-blue.min.css">
    <link rel="stylesheet" href="/static/plugins/datatables/css/dataTables.bootstrap.min.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <%@include file="../include/mainHeader.jsp"%>
    <%@include file="../include/leftSide.jsp"%>
    <jsp:include page="../include/leftSide.jsp">
        <jsp:param name="menu" value="customer"/>
    </jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">

        <!-- Main content -->
        <section class="content">

            <div class="box box-primary">

                <div class="box-header with-border">
                    <h3 class="box-title">公告列表</h3>
                    <shiro:hasRole name="经理" >
                        <a href="/notice/new" class="btn btn-success btn-xs pull-right"><i class="fa fa-pencil"></i>发表公告</a>
                    </shiro:hasRole>
                </div>

                <div class="box-body">
                        <c:if test="${message.state == 'success'}">
                            <div class="alert alert-success">${message.message}</div>
                        </c:if>
                        <c:if test="${message.state == 'error'}">
                            <div class="alert alert-danger">${message.message}</div>
                        </c:if>

                    <table class="table table-bordered table-hover" id="noticeList">

                        <thead>
                            <tr>
                                <th>标题</th>
                                <th>作者</th>
                                <th>日期</th>
                            </tr>
                        </thead>

                        <tbody>

                        </tbody>

                    </table>

                    
                </div>

            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.2.0 -->
<script src="/static/plugins/jQuery/jQuery-2.2.0.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="/static/dist/js/app.min.js"></script>
<script src="/static/plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="/static/plugins/datatables/js/dataTables.bootstrap.min.js"></script>
<script src="/static/plugins/moment/moment.min.js"></script>

<script>

    $(function () {

        $("#noticeList").DataTable({
            serverSide:true,
            ajax:"/notice/load",
            ordering:false,
            autoWidth:false,
            columns:[
                {"data": function (row) {
                    return "<a href='/notice/"+row.id+"'>"+row.title+"</a>";
                }},
                {"data":"realname"},
                {"data": function (row) {
                    return moment(row.createtime).format("YYYY-MM-DD HH:mm:ss");
                }}
            ],
            "language":{ //定义中文
                "search": "请输入公告标题或公告经理:",
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
                }
            }
        });
    });

</script>



</body>
</html>
