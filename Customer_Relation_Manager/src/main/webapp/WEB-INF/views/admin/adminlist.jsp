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
    <title>AdminLTE 2 | Starter</title>
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

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户管理
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box box-primary">

                <div class="box-header">
                    <h3>用户列表</h3>
                        <div class="box-tools pull-right">
                            <a href="javascript:;" id="newUser" class="btn btn-xs btn-primary">新增用户</a>
                        </div>
                </div>
                <div class="box-body">
                    <table class="table table-bordered table-hover" id="userListTable">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>账号</th>
                                <th>员工姓名</th>
                                <th>职位</th>
                                <th>创建时间</th>
                                <th>微信号</th>
                                <th>状态</th>
                                <th>#</th>
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


<div class="modal fade" id="newuserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">新增用户</h4>
            </div>
            <div class="modal-body">

                <form id="newForm">
                    <div class="form-group">
                        <label>账号（用于系统登录）</label>
                        <input type="text" class="form-control" name="username">
                    </div>
                    <div class="form-group">
                        <label>员工姓名（真实姓名）</label>
                        <input type="text" class="form-control" name="realname">
                    </div>
                    <div class="form-group">
                        <label>密码（默认000000）</label>
                        <input type="text" class="form-control" name="password" value="000000">
                    </div>
                    <div class="form-group">
                        <label>微信号</label>
                        <input type="text" class="form-control" name="weixin">
                    </div>
                    <div class="form-group">
                        <label>角色</label>
                        <select class="form-control" name="roleid">
                            <c:forEach items="${roleList}" var="role">
                                <option value="${role.id}">${role.rolename}</option>
                            </c:forEach>
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


<div class="modal fade" id="editUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">编辑用户</h4>
            </div>
            <div class="modal-body">

                <form id="editUserForm">
                    <input type="hidden" id="id" name="id">
                    <div class="form-group">
                        <label>账号（用于系统登录）</label>
                        <input type="text" class="form-control" disabled name="username" id="username">
                    </div>
                    <div class="form-group">
                        <label>员工姓名（真实姓名）</label>
                        <input type="text" class="form-control" name="realname" id="realname">
                    </div>
                    <div class="form-group">
                        <label>微信号</label>
                        <input type="text" class="form-control" name="weixin" id="weixin">
                    </div>
                    <div class="form-group">
                        <label>状态</label>
                        <select class="form-control" name="enable" id="enable">
                            <option value="true">正常</option>
                            <option value="false">禁用</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>角色</label>
                        <select class="form-control" name="roleid" id="roleid">
                            <c:forEach items="${roleList}" var="role">
                                <option value="${role.id}">${role.rolename}</option>
                            </c:forEach>
                        </select>
                    </div>
                </form>


            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" id="editBtn" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>



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
<script>
    $(function () {

//        新增用户列表验证
        $("#newForm").validate({
            errorElement:"span",
            errorClass:"text-danger",
            rules:{
                username:{
                    required:true,
                    rangelength:[3,18],
                    remote:"/admin/username"
                },
                realname:{
                    required:true,
                    rangelength:[2,18]
                },
                password:{
                    required:true,
                    rangelength:[3,18]
                },
                weixin:{
                    required:true
                }
            },
            messages:{
                username:{
                    required:"请输入用户名",
                    rangelength:"用户名长度为3~18位",
                    remote:"该用户名已被占用"
                },
                realname:{
                    required:"请输入真实姓名",
                    rangelength:"真实姓名长度2~18位"
                },
                password:{
                    required:"请输入密码",
                    rangelength:"密码长度为6~18位"
                },
                weixin:{
                    required:"请输入微信号"
                }
            },
            submitHandler: function (form) {
                $.post("/admin/save",$(form).serialize()).done(function (data) {
                    if(data == "success"){
                        $("#newuserModal").modal("hide");
                        $dataTable.ajax.reload();
                    }
                }).fail(function () {
                    alert("请求服务器异常！");
                });
            }
        });

//        保存新用户
        $("#saveBtn").click(function () {
            $("#newForm").submit();
        });
        $("#newUser").click(function () {
            $("#newForm")[0].reset();
            $("#newuserModal").modal({
                "show":true,
                "backdrop":'static',
                "keyboard":false
            })
        });

//        POST方式编辑用户

//        $(document).delegate(".editUser","click", function () {
//            var id = $(this).attr("rel");
//            $("#editUserForm")[0].reset();
//            $.post("/admin/users/edit.json", {"id":id}).done(function (result) {
//                if(result.state == "success"){
//                    $("#id").val(result.data.id);
//                    $("#username").val(result.data.username);
//                    $("#realname").val(result.data.realname);
//                    $("#weixin").val(result.data.weixin);
//                    $("#role").val(result.data.roleid);
//                }
//            }).fail(function () {
//                alert("请求服务器异常！");
//            });
//            $("#editUserModal").modal({
//                show:true,
//                backdrop:'static',
//                keyboard:true
//            });
//        })

//        GET方式编辑用户
        $(document).delegate(".editUser","click", function () {
            var id = $(this).attr("rel");
            console.log(id);
            $.get("/admin/users/edit/"+id+".json").done(function (result) {
                if(result.state == "success"){
                    $("#id").val(result.data.id);
                    $("#username").val(result.data.username);
                    $("#realname").val(result.data.realname);
                    $("#weixin").val(result.data.weixin);
                    $("#roleid").val(result.data.roleid);
                    $("#enable").val(result.data.enable.toString());
                    $("#editUserModal").modal({
                        show:true,
                        backdrop:'static',
                        keyboard:false
                    });
                }
            }).fail(function () {
                alert("请求服务器异常");
            });
        });
        $("#editBtn").click(function () {
            $("#editUserForm").submit();
        });
        $("#editUserForm").validate({
            errorElement:"span",
            errorClass:"text-danger",
            rules:{
                username:{
                    required:true,
                    rangelength:[3,18],
                    remote:"/admin/username"
                },
                realname:{
                    required:true,
                    rangelength:[2,18]
                },
                weixin:{
                    required:true
                }
            },
            messages:{
                username:{
                    required:"请输入用户名",
                    rangelength:"用户名长度为3~18位",
                    remote:"该用户名已被占用"
                },
                realname:{
                    required:"请输入真实姓名",
                    rangelength:"真实姓名长度2~18位"
                },
                weixin:{
                    required:"请输入微信号"
                }
            },
            submitHandler: function (form) {
                $.post("/admin/users/edit",$(form).serialize()).done(function (data) {
                    if(data == "success"){
                        $("#editUserModal").modal("hide");
                        $dataTable.ajax.reload();
                    }
                }).fail(function () {
                    alert("请求服务器异常！");
                });
            }
        });


//        密码重置验证
        $(document).delegate(".resetPassword","click", function () {
            if(confirm("确认将密码重置为000000")){
                var id = $(this).attr("rel");
                $.post("/admin/resetpassword",{"id":id}).done(function (data) {
                    if(data=='success'){
                        alert("密码重置成功！");
                    }
                }).fail(function () {
                    alert("请求服务器异常！");
                });
            }
        })

//        用户列表显示
        var $dataTable = $("#userListTable").DataTable({
            serverSide:true,
            ajax:"/admin/usermanager/data",
            autoWidth:false,
            lengthMenu:[5,10,25,50,100],
            columns:[
                    {"data":"id"},
                    {"data":"username"},
                    {"data":"realname"},
                    {"data":"role.rolename"},
                    {"data": function (row) {
                        var day = moment(row.createtime);
                        return day.format("YYYY-MM-DD HH-mm-ss")
                    }},
                    {"data":"weixin"},
                    {"data": function (row) {
                        if(row.enable){
                            return "<span><label class='label label-success'>正常</label></span>"
                        }else{
                            return "<span><label class='label label-warning'>禁用</label></span>";
                        }
                    }},
                    {"data": function (row) {
                        if(row.username == 'admin'){
                            return "";
                        }else{
                            return "<a href='javascript:;' class='resetPassword' rel='" + row.id + "'>重置密码</a>&nbsp;&nbsp;" +
                                    "<a href='javascript:;' class='editUser' rel='" + row.id + "'>编辑</a>";
                        }
                    }}
                ],
                columnDefs:[
                    {targets:[0],visible:false}
                ],
                ordering:false,
                    "language":{ //定义中文
                    "search": "请输入账户名称或真实姓名:",
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

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when using the
     fixed layout. -->
</body>
</html>
