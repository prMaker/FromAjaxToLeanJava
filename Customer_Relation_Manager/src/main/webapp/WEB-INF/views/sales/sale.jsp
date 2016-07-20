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
    <link rel="stylesheet" href="/static/plugins/simditor/styles/simditor.css">
    <link rel="stylesheet" href="/static/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="/static/plugins/colorpicker/bootstrap-colorpicker.min.css">
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

                <%--销售机会基本信息--%>
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h2 class="box-title">${sales.name}</h2>
                    <shiro:hasRole name="经理">
                        <a href="javascript:;" id="deleteBtn" class="btn btn-danger btn-xs pull-right"><i class="fa fa-remove"></i> 删除</a>
                    </shiro:hasRole>
                </div>
                <div class="box-body">

                    <table class="table table-bordered table_hover">
                        <tr>
                            <td>关联客户</td>
                            <td><a href="/customer/${sales.customerid}">${sales.customername}</a></td>
                            <td>价值</td>
                            <td>${sales.price}</td>
                        </tr>
                        <tr>
                            <td>当前进度</td>
                            <td>${sales.progress}<a href="javascript:;" id="editBtn">修改</a></td>
                            <td>最后跟进时间</td>
                            <td>${sales.lasttime}</td>
                        </tr>
                    </table>

                </div>
            </div>

        </section>

        <section class="content container" style="position: relative">
            <%--跟进记录显示--%>
            <div class="box box-primary" style="width: 66%;float:left;">
                <div class="box-header with-border">
                    <h2 class="box-title" style="margin: 0px 30px"><i class="fa fa-list"></i> 跟进记录</h2>
                    <a href="javascript:;" style="margin: 0px 30px" id="newLogBtn" class="btn btn-success btn-xs pull-right"><i class="fa fa-plus"></i>新增记录</a>
                </div>
                <div class="box-body">
                    <ul class="timeline">

                        <%--TODO 查看老师时间线写法--%>

                        <c:forEach items="${salesLogList}" var="salesLog">
                            <c:choose>
                                <c:when test="${salesLog.type == 'auto'}">

                                    <li>
                                        <i class="fa fa-arrow-up bg-yellow-active"></i>
                                        <div class="timeline-item">

                                            <div class="timeline-body times-ago">
                                                ${salesLog.context}
                                                    ${salesLog.createtime}
                                            </div>
                                        </div>
                                    </li>

                                </c:when>
                                <c:otherwise>
                                    <li>
                                        <i class="fa fa-comments bg-blue-active"></i>
                                        <div class="timeline-item">

                                            <div class="timeline-body times-ago">
                                                    ${salesLog.context}
                                                <span class="timeago" title="${salesLog.createtime}"></span>
                                            </div>
                                        </div>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>

                    </ul>
                </div>
            </div>

            <%--相关资料显示--%>
            <div class="box box-primary" style="width: 31%;position: relative;float:right;">
                <div class="box-header with-border">
                    <h2 class="box-title"  style="margin: 0px 30px"><i class="fa fa-qrcode"></i> 相关资料</h2>

                    <a href="javascript:;" class="btn btn-primary btn-xs pull-right" style="margin: 0px 30px"><i class="fa fa-upload"></i></a>

                </div>
                <div class="box-body" style="text-align: center">

                    <%--TODO 文件上传--%>

                </div>
            </div>

            <%--待办事项显示--%>
            <div class="box box-primary" style="width: 31%;position: relative;float:right;">
                <div class="box-header with-border">
                    <h2 class="box-title" style="margin: 0px 30px"><i class="fa fa-pencil-square-o"></i> 代办任务</h2>
                    <a href="javascript:;" style="margin: 0px 30px" id="newTaskBtn" class="btn btn-success btn-xs pull-right"><i class="fa fa-plus"></i>新增待办任务</a>
                </div>
                <div class="box-body">
                    <c:forEach items="${taskList}" var="task">
                        <div class="text-center form-group"><a href="javascript:;" class="taskManager" rel="${task.id}">${task.title}</a></div>
                    </c:forEach>
                </div>
            </div>
        </section>

    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->



<div class="modal fade" id="editSalesModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改进度</h4>
            </div>
            <div class="modal-body">

                <form id="editSalesForm" method="post" action="/sales/progress/edit">
                    <input type="hidden" name="id" value="${sales.id}">
                    <div class="form-group">
                        <label>当前进度</label>
                        <select id="progress" name="progress" class="form-control">
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
                <button type="button" id="editFormBtn" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="newSalesLogModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改进度</h4>
            </div>
            <div class="modal-body">

                <form id="newSalesLogForm" method="post" action="/sales/log/new">

                    <input type="hidden" name="salesid" value="${sales.id}">
                    <div class="form-group">
                        <textarea id="newSalesLog"></textarea>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="submit" id="newSalesLogFormBtn" class="btn btn-primary">保存</button>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="eventModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">查看待办事项</h4>
            </div>
            <div class="modal-body">

                <form id="eventForm" method="post">
                    <input type="hidden" id="event_id">
                    <div class="form-group">
                        <label>待办内容</label>
                        <div class="form-control" id="event_title"></div>
                    </div>
                    <div class="form-group">
                        <label>开始日期</label>
                        <div><span id="event_start"></span> ~ <span id="event_end"></span></div>
                    </div>
                    <div class="form-group">
                        <label>提醒时间</label>

                        <%--TODO 查看提醒时间如何添加DIV如何添加--%>

                        <div class="event_remindtime" id="event_remindtime"></div>
                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button class="btn btn-danger" id="delBtn" type="button"><i class="fa fa-trash"></i> 删除</button>
                <button type="button" id="doneBtn" class="btn btn-primary">标记已完成</button>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="newTaskModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">新增待办事项</h4>
            </div>
            <div class="modal-body">

                <form id="newTaskForm" method="post">

                    <div class="form-group">
                        <label>代办内容</label>
                        <input type="text" class="form-control" name="title" id="task_title">
                    </div>
                    <div class="form-group">
                        <label>开始日期</label>
                        <input type="text" class="form-control" name="start" id="start_time">
                    </div>
                    <div class="form-group">
                        <label>结束日期</label>
                        <input type="text" class="form-control" name="end" id="end_time">
                    </div>
                    <div class="form-group">
                        <label>提醒时间</label>
                        <div>
                            <select name="hour" style="width: 100px">
                                <option value=""></option>
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                                <option value="13">13</option>
                                <option value="14">14</option>
                                <option value="15">15</option>
                                <option value="16">16</option>
                                <option value="17">17</option>
                                <option value="18">18</option>
                                <option value="19">19</option>
                                <option value="20">20</option>
                                <option value="21">21</option>
                                <option value="22">22</option>
                                <option value="23">23</option>
                            </select>
                            :
                            <select name="min" style="width: 100px">
                                <option value=""></option>
                                <option value="0">0</option>
                                <option value="5">5</option>
                                <option value="10">10</option>
                                <option value="15">15</option>
                                <option value="20">20</option>
                                <option value="25">25</option>
                                <option value="30">30</option>
                                <option value="35">35</option>
                                <option value="40">40</option>
                                <option value="45">45</option>
                                <option value="50">50</option>
                                <option value="55">55</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label>显示颜色</label>
                        <input type="text" name="color" id="color" value="#61a5e8" class="form-control">
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
<script src="/static/plugins/timeago/timeago.js"></script>
<script src="/static/plugins/simditor/scripts/module.min.js"></script>
<script src="/static/plugins/simditor/scripts/hotkeys.min.js"></script>
<script src="/static/plugins/simditor/scripts/uploader.min.js"></script>
<script src="/static/plugins/simditor/scripts/simditor.min.js"></script>
<script src="/static/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="/static/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>

<script>


    $(function () {

//        修改状态
        $("#editBtn").click(function () {
            $("#editSalesForm")[0].reset();
            $("#progress").val("${sales.progress}");
            $("#editSalesModal").modal({
                show:true,
                backdrop:'static',
                keyboard:false
            });
        });
        $("#editFormBtn").click(function () {
            $("#editSalesForm").submit();
        });

//        删除销售机会
        $("#deleteBtn").click(function () {
            if(confirm("删除该销售消息将删除相关资料，待办任务及跟进记录，确认删除么？")){
                $.get("/sales/del/"+${sales.id}).done(function (form) {
                    window.location.href="/sales";
                }).fail(function () {
                    alert("请求服务器失败");
                });
            };
        });

//        新增销售记录
        $("#newLogBtn").click(function () {
            $("#newSalesLogForm")[0].reset();
            $("#newSalesLogModal").modal({
                show:true,
                backdrop:'static',
                keyboard:false
            });
        });

        var simditor = new Simditor({
            textarea:"#newSalesLog",
//            TODO 查看老师代码
            placeholder:"亲输入日志",
            toolbar:false
        });

//        新增代办添加
        $("#newTaskBtn").click(function () {
            $("#newTaskForm")[0].reset();
            $("#newTaskModal").modal({
                show:true,
                backdrop:'static'
            });
        });

//        保存新待办事项
        $("#saveBtn").click(function () {
            if ($("#task_title").val()) {
//                TODO 上午的focus为控件的focus
                $("#task_title").focus();
            }
//            TODO 查看老师所写的momen库中的意思
            if (moment($("#start_time").val()).isAfter(moment($("#end_time").val()))) {
                alert("结束时间大于开始时间");
                return;
            }
            var id = ${sales.id};
            $.post("/task/new?id="+id, $("#newTaskForm").serialize()).done(function (data) {
                if (data.status == "success") {
                    $("#newTaskModal").modal("hide");
                    window.history.go(0);
                }
            }).fail(function () {
                alert("请求服务器错误！");
            });
        });
        $("#start_time,#end_time").datepicker();
        $("#color").colorpicker({
            color:"#61a5e8"
        });

        $(document).delegate(".taskManager","click", function () {
            var id = $(this).attr("rel");
            $.get("/sales/task/"+id).done(function (data) {
                if(data.state == "success"){
                    $("#event_id").text(data.data.id);
                    $("#event_remindtime").text(data.data.remindertime);
                    $("#event_title").text(data.data.title);
                    $("#event_end").text(data.data.end);
                    $("#event_start").text(data.data.start);

                    $("#eventModal").modal({
                        show:true,
                        backdrop:'static',
                        keyboard:false
                    });
                }
            }).fail(function () {
                alert("请求服务器异常");
            });
        });

// TODO 查看timeago的制作
        <%--+<script src="/static/plugins/timeago/timeago.js"></script>--%>
<%--+<script src="/static/plugins/timeago/timeago_zh_cn.js"></script>--%>

        $(".timeago").timeago();

// TODO 未完成事项未完成
//        删除事项
        $("#delBtn").click(function () {
            if (confirm("确认删除该条待办事项？")) {
                var id = $("#event_id").text();
                $.get("/task/del/" + id).done(function (data) {
                    if (data == "success") {
                        $("#eventModal").modal("hide");
                    }
                }).fail(function () {
                    alert("请求服务器错误");
                });
            }
        });

//        完成事项
        $("#doneBtn").click(function () {
            var id = _event.id;
            $.get("/task/done/"+id).done(function (data) {
                if(data == "success"){
                    $calendar.fullCalendar("updateEvent",_event);
                    $("#eventModal").modal("hide");
                }
            }).fail(function () {
                alert("请求服务器异常");
            });
        });

    });

</script>



</body>
</html>
