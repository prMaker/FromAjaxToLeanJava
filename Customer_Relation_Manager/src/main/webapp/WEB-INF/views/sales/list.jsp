<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
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
    <title>凯盛CRM|销售机会</title>
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
    <link rel="stylesheet" href="/static/plugins/dateRangePicker/daterangepicker.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <%@include file="../include/mainHeader.jsp"%>
    <%@include file="../include/leftSide.jsp"%>
    <jsp:include page="../include/leftSide.jsp">
        <jsp:param name="menu" value="sales"/>
    </jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">




        <section class="content-header" >

            <%--面包屑导航--%>
            <h2 style="display: inline-block;"><p>     </p></h2>
            <div class="pull-right">
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> 面包屑导航</a></li>
                    <li class="active">目录</li>
                </ol>
            </div>

                <%--搜索--%>
            <div class="box box-primary collapsed-box">
                <div class="box-header with-border">
                    <h2 class="box-title">搜索</h2>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                    </div>
                </div>
                <div class="box-body">
                    <form class="form-group" id="searchForm" method="get">
                        <input type="hidden" name="search_starttime" id="search_starttime"/>
                        <input type="hidden" name="search_endtime" id="search_endtime">
                        <input type="text" style="display: inline; width: 200px;" class="form-control" name="name" id="search_name" placeholder="机会名称">
                        <select name="progress" style="display: inline; width: 200px;" id="search_progress" name="progress" id="search_progress" class="form-control">
                            <option value="">当前进度</option>
                            <option value="初次接触">初次接触</option>
                            <option value="确认意向">确认意向</option>
                            <option value="提供合同">提供合同</option>
                            <option value="完成交易">完成交易</option>
                            <option value="交易搁置">交易搁置</option>
                        </select>
                        <input type="text" id="datepicker" class="form-control" placeholder="跟进时间" name="time" style="display: inline; width: 200px;">
                        <button type="button" id="searchBtn" class="btn btn-primary">搜索</button>
                    </form>
                </div>
            </div>

        </section>

        <!-- Main content -->
        <section class="content">

            <div class="box box-primary">

                <div class="box-header with-border">
                    <h2 class="box-title">销售机会列表</h2>
                    <a href="javascript:;" id="newSales" class="btn btn-success btn-xs pull-right"><i class="fa fa-play-circle"></i>添加机会</a>

                    <%--<shiro:hasRole name="经理" >--%>
                        <%--<a href="/notice/new" class="btn btn-success btn-xs pull-right"><i class="fa fa-pencil"></i>发表公告</a>--%>
                    <%--</shiro:hasRole>--%>
                </div>

                <div class="box-body">
                    <table class="table table-bordered table-hover" id="salesDataTable">

                        <thead>
                            <tr>
                                <th class="col-xs-2">机会名称</th>
                                <th class="col-xs-3">关联客户</th>
                                <th class="col-xs-1">价值</th>
                                <th class="col-xs-1">当前进度</th>
                                <th class="col-xs-2">最后跟进时间</th>
                                <th class="col-xs-1">所属员工</th>
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



<div class="modal fade" id="newSalesModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">新增机会</h4>
            </div>
            <div class="modal-body">

                <form id="newSalesForm" method="post">

                    <div class="form-group">
                        <label>机会名称</label>
                        <input type="text" class="form-control" name="name">
                    </div>
                    <div class="form-group">
                        <label>价值</label>
                        <input type="text" class="form-control" name="price">
                    </div>
                    <div class="form-group">
                        <label>关联客户</label>
                        <select class="form-control" name="customerid">
                            <option value=""></option>
                            <c:forEach items="${customerList}" var="customer">
                                <option value="${customer.id}">${customer.name} </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>当前进度</label>
                        <select name="progress" id="progress" class="form-control">
                        <option value="初次接触">初次接触</option>
                        <option value="确认意向">确认意向</option>
                        <option value="提供合同">提供合同</option>
                        <option value="完成交易">完成交易</option>
                        <option value="交易搁置">交易搁置</option>
                    </select>
                    </div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" id="saveBtn" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>


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
<script src="/static/plugins/validate/jquery.validate.min.js"></script>
<script src="/static/plugins/dateRangePicker/moment.min.js"></script>
<script src="/static/plugins/dateRangePicker/daterangepicker.js"></script>

<script>

    $(function () {

//        datapicker格式化
        $('#datepicker').daterangepicker({
            format:"YYYY-MM-DD",
            separator:"~",
            locale:{
                "applyLabel":"选择",
                "cancelLabel":"取消",
                "fromLabel":"从",
                "toLabel":"到",
                "customRangeLabel":"自定义",
                "weekLabel":"周",
                "daysOfWeek":[
                        "一","二","三","四","五","六","日"
                ],
                "monthNames":[
                        "一月","二月","三月","四月","五月","六月",
                        "七月","八月","九月","十月","十一月","十二月"
                ],
                "firstDay":1
            },
            "ranges": {
                "今天":[moment(),moment()],
                "昨天":[moment().subtract("1","days"),moment().subtract("1","days")],
                "最近7天":[moment().subtract("6","days"),moment()],
                "最近30天":[moment().subtract("29","days"),moment()],
                "本月":[moment().startOf("month"),moment().endOf("month")],
                "上个月":[moment().subtract("1","month").startOf("month"),moment().subtract("1","month").endOf("month")],
            },
            "startDate": "07/09/2016",
            "endDate": "07/15/2016"
        }, function(start, end, label) {
            console.log("New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')");
            var startTime = moment(start).format("YYYY-MM-DD");
            var endTime = moment(end).format("YYYY-MM-DD");
            $("#search_starttime").val(startTime);
            $("#search_endtime").val(endTime);
        });

//        添加机会
        $("#newSales").click(function () {
            console.log("121323123");
            $("#newSalesForm")[0].reset();
            $("#newSalesModal").modal({
                show:true,
                backdrop:'static',
                keyboard:false
            })
        });
        $("#saveBtn").click(function () {
            $("#newSalesForm").submit();
        });
        $("#newSalesForm").validate({
            errorElement:"span",
            errorClass:"text-danger",
            rules:{
                name:"required",
                price:{
                    number:true,
                    required:true
                },
                customerid:"required"
            },
            messages:{
                name:"请输入销售机会名称",
                price:{
                    number:"请输入正确的价格",
                    required:"请输入价格"
                },
                customerid:"请选择销售客户"
            },
            submitHandler: function (form) {
                $.post("/sales/new",$(form).serialize()).done(function (data) {
                    if(data=="success"){
                        $dataTable.ajax.reload();
                        $("#newSalesModal").modal("hide");
                    }
                }).fail(function () {
                    alert("请求服务器异常");
                });
            }
        });

        $("#searchBtn").click(function () {
            $dataTable.ajax.reload();
        });

//        datatable资料获取
        var $dataTable = $("#salesDataTable").DataTable({
            serverSide:true,
            ajax:{
                url:"/sales/data/load",
                data: function (dataSource) {
                    dataSource.name=$("#search_name").val();
                    dataSource.progress=$("#search_progress").val();
                    dataSource.startTime=$("#search_starttime").val();
                    dataSource.endTime=$("#search_endtime").val();
                }
            },
            searching:false,
            ordering:false,
            columns:[
                {"data": function (row) {
                    return "<a href='/sales/"+row.id+"'>"+row.name+"</a>";
                }},
                {"data": function (row) {
                    return "<a href='/customer/"+row.customerid+"'>"+row.customername+"</a>"
                }},
                {"data":"price"},
                {"data": function (row) {
//                    "progress"
                    if(row.progress == "完成交易"){
                        return "<div class='btn btn-success btn-xs' href='javascript:;'>"+row.progress+"</div>";
                    }
                    return row.progress == "交易搁置" ? "<div class='btn btn-danger btn-xs' href='javascript:;'>"+row.progress+"</div>" : row.progress
                }},
                {"data": function (row) {
                    return row.lasttime;
                }},
                {"data":"username"}
            ],
            language:{ //定义中文
                "search": "请输入客户姓名或电话号码:",
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
