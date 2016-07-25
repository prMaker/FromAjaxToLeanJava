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
    <title>凯盛CRM|待办事项</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/static/plugins/fontawesome/css/font-awesome.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="/static/dist/css/skins/skin-blue.min.css">
    <link rel="stylesheet" href="/static/plugins/fullcalendar/fullcalendar.min.css">
    <link rel="stylesheet" href="/static/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="/static/plugins/colorpicker/bootstrap-colorpicker.min.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <%@include file="../include/mainHeader.jsp" %>
    <%@include file="../include/leftSide.jsp" %>
    <jsp:include page="../include/leftSide.jsp">
        <jsp:param name="menu" value="tack"/>
    </jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">


        <section class="content-header">
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">

                <div class="col-md-8">
                    <div class="box box-solid">
                        <div class="box-body">
                            <div id="calendar" style="column-span: 8"></div>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="box box-danger">

                        <div class="box-header with-border">
                            <h3 class="box-title">已经延期的事项</h3>
                        </div>

                        <div class="box-body">
                            <ul class="todo-list">
                                <c:forEach items="${taskList}" var="task">
                                    <li>
                                        <input type="checkbox">
                                        <span class="text">${task.title}</span>
                                        <div class="tools">
                                            <i class="fa fa-trash-o"></i>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>

                    </div>
                </div>

            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->


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

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.2.0 -->
<script src="/static/plugins/jQuery/jQuery-2.2.0.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="/static/dist/js/app.min.js"></script>
<script src="/static/plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="/static/plugins/datatables/js/dataTables.jqueryui.min.js"></script>
<script src="/static/plugins/datatables/js/dataTables.bootstrap.min.js"></script>
<script src="/static/plugins/moment/moment.min.js"></script>
<script src="/static/plugins/validate/jquery.validate.min.js"></script>
<script src="/static/plugins/fullcalendar/fullcalendar.min.js"></script>
<script src="/static/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="/static/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script>

    $(function () {

        var _event = null;
        var $calendar = $("#calendar");
//       新建待办事项
        $calendar.fullCalendar({
            lang: 'zh-CN',
            buttonText: {
                today: '今天'
            },
            events: "task/load",
//            TODO 完成信息load


// TODO 听老师讲解funcition中的参数解释
            dayClick: function (date, jsEvent, view) {
                $("#newTaskForm")[0].reset();
                $("#start_time").val(date.format());
                $("#end_time").val(date.format());
                $("#newTaskModal").modal({
                    show: true,
                    backdrop: 'static'
                });
            },
            eventClick: function (calEvent, jsEvent, view) {
                _event = calEvent;
                $("#event_id").val(calEvent.id);
                $("#event_start").text(moment(calEvent.start).format("YYYY-MM-DD"));
                $("#event_end").text(moment(calEvent.end).format("YYYY-MM-DD"));
                $("#event_title").text(calEvent.title);
                if (calEvent.remindertime) {
                    $("#event_remindtime").text(calEvent.remindertime);
                } else {
                    $("#event_remindtime").text("无");
                }
                $("#eventModal").modal({
                    show: true,
                    backdrop: 'static'
                });
            }
        });


        $("#color").colorpicker({
            color: "#61a5e8"
        });
        $("#start_time,#end_time").datepicker({
            format: 'yyyy-mm-dd',
            autoclose: true,
            language: 'zh-CN',
            todayHilghlight: true
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
            $.post("/task/new", $("#newTaskForm").serialize()).done(function (data) {
                if (data.status == "success") {
//                    将返回的数据体现在calendar控件上
//                    TODO 不隐藏modal
                    $("#newTaskModal").modal("hide");
                    $calendar.fullCalendar("renderEvent", result.data);
                }
            }).fail(function () {
                alert("请求服务器错误！");
            });
        });

//        删除事项
        $("#delBtn").click(function () {
            if (confirm("确认删除该条待办事项？")) {
                var id = _event.id;
                $.get("/task/del/" + id).done(function (data) {
                    if (data == "success") {
                        $calendar.fullCalendar("removeEvents",id);
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

//        删除未完成事项
        $(document).delegate(".fa-trash-o",click, function () {

        });

    });

</script>


</body>
</html>
