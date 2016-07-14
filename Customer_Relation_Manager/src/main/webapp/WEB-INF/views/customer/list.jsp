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
    <title>凯盛CRM|客户管理</title>
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
                    <h3 class="box-title">客户列表</h3>
                    <a href="javascript:;" id="newCustomerBtn" class="btn btn-success btn-xs pull-right"><i class="fa fa-play-circle"></i>添加客户</a>

                    <%--<shiro:hasRole name="经理" >--%>
                        <%--<a href="/notice/new" class="btn btn-success btn-xs pull-right"><i class="fa fa-pencil"></i>发表公告</a>--%>
                    <%--</shiro:hasRole>--%>
                </div>

                <div class="box-body">

                    <table class="table table-bordered table-hover" id="noticeList">

                        <thead>
                            <tr>
                                <th>类型</th>
                                <th>客户姓名</th>
                                <th>电话</th>
                                <th>地址</th>
                                <th>等级</th>
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


<div class="modal fade" id="newCustomerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">新增客户</h4>
            </div>
            <div class="modal-body">

                <form id="newCustomerForm">
                    <div class="form-group">
                        <span>个人</span>
                        <input type="radio" checked name="type" value="person" id="person"/>
                        <span>公司</span>
                        <input type="radio" name="type" value="company" id="company"/>
                    </div>

                    <div class="form-group">
                        <label>客户名</label>
                        <input type="text" class="form-control" name="name">
                    </div>
                    <div class="form-group">
                        <label>电话</label>
                        <input type="text" class="form-control" name="tel">
                    </div>
                    <div class="form-group">
                        <label>微信号</label>
                        <input type="text" class="form-control" name="weixin">
                    </div>
                    <div class="form-group">
                        <label>邮箱地址</label>
                        <input type="text" class="form-control" name="email">
                    </div>
                    <div class="form-group">
                        <label>地址</label>
                        <input type="text" class="form-control" name="address">
                    </div>
                    <div class="form-group">
                        <label>等级</label>
                        <select class="form-control" name="level">
                            <option value=""></option>
                            <option value="★">★</option>
                            <option value="★★">★★</option>
                            <option value="★★★">★★★</option>
                            <option value="★★★★">★★★★</option>
                            <option value="★★★★★">★★★★★</option>
                        </select>
                    </div>

                    <div class="form-group" id="companyshow">
                        <label>所属公司</label>
                        <select class="form-control" name="companyid" id="companyid">
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




<div class="modal fade" id="editCustomerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改客户</h4>
            </div>
            <div class="modal-body">

                <form id="editCustomerForm" method="post">
                    <input type="hidden" id="edit_id" name="id">
                    <input type="hidden" id="edit_userid" name="userid">
                    <div class="form-group">
                        <span>个人</span>
                        <input type="radio" checked name="type" value="person" id="edit_person"/>
                        <span>公司</span>
                        <input type="radio" name="type" value="company" id="edit_company"/>
                    </div>

                    <div class="form-group">
                        <label>客户名</label>
                        <input type="text" class="form-control" name="name" id="edit_name">
                    </div>
                    <div class="form-group">
                        <label>电话</label>
                        <input type="text" class="form-control" name="tel" id="edit_tel">
                    </div>
                    <div class="form-group">
                        <label>微信号</label>
                        <input type="text" class="form-control" name="weixin" id="edit_weixin">
                    </div>
                    <div class="form-group">
                        <label>邮箱地址</label>
                        <input type="text" class="form-control" name="email" id="edit_email">
                    </div>
                    <div class="form-group">
                        <label>地址</label>
                        <input type="text" class="form-control" name="address" id="edit_address">
                    </div>
                    <div class="form-group">
                        <label>等级</label>
                        <select class="form-control" name="level" id="edit_level">
                            <option value=""></option>
                            <option value="★">★</option>
                            <option value="★★">★★</option>
                            <option value="★★★">★★★</option>
                            <option value="★★★★">★★★★</option>
                            <option value="★★★★★">★★★★★</option>
                        </select>
                    </div>

                    <div class="form-group" id="edit_companyshow">
                        <label>所属公司</label>
                        <select class="form-control" name="companyid" id="edit_companyid">
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

<script>

    $(function () {


//      新建客户表单提交
        $("#newCustomerBtn").click(function () {
//        Ajax获取公司数据数据
            $.get("/customer/companyList/load").done(function (data) {
                if(data.state == "success"){
                    $("#companyshow select").html("");
                    $("#companyshow select").append("<option></option>");
                    var customerList = data.data;
                    for(var i = 0;i<customerList.length;i++){
                        $("#companyshow select").append("<option value='"+customerList[i].id+"'>"+customerList[i].name+"</option>");
                    }
                }
            }).fail(function () {
                alert("请求服务器异常");
            });

            $("#newCustomerForm")[0].reset();
            $("#companyshow").show();
            $("#newCustomerModal").modal({
                show:true,
                backdrop:'static',
                keyboard:false
            });
        });
        $("#saveBtn").click(function () {
            $("#newCustomerForm").submit();
        });
//        表单公司选项选择
        $("#person").click(function () {
            if($("#person")[0].checked){
                $("#companyshow").show();
            }
        });
        $("#company").click(function () {
            if($("#company")[0].checked){
                $("#companyshow").hide();
            }
        });

        $("#newCustomerForm").validate({
            errorElement:"span",
            errorClass:"text-danger",
            rules:{
                name:{
                    required:true
                },
                tel:{
                    required:true
                }
            },
            messages:{
                name:{
                    required:"请输入客户姓名"
                },
                tel:{
                    required:"请输入客户电话"
                }

            },
            submitHandler: function (form) {
                $.post("/customer/new",$(form).serialize()).done(function (data) {
                    if(data == "success"){
                        $dataTable.ajax.reload();
                        $("#newCustomerModal").modal("hide");
                    }
                }).fail(function () {
                    alert("请求服务器错误！");
                });
            }
        });


//        删除客户
        <shiro:hasRole name="经理">
            $(document).delegate(".del","click", function () {
                if(confirm("删除该条数据将会删除所有关联子项目，及代办事项，是否确认删除？")){
                    var id = $(this).attr("rel");
                    $.get("/customer/del/"+id).done(function (data) {
                        if(data == "success"){
                            $dataTable.ajax.reload();
                        }
                    }).fail(function () {
                        alert("请求服务器错误，删除失败");
                    });
                }
            });
        </shiro:hasRole>

//        修改用户
//        modal框的显示
        $(document).delegate(".edit","click", function () {
            var id = $(this).attr("rel");
            $.get("/customer/edit/load/"+id).done(function (data) {
                if(data.state == "success"){
                    $("#edit_companyshow select").html("");
                    $("#edit_companyshow select").append("<option></option>");
                    var customerList = data.data.customerList;
                    for(var i = 0;i<customerList.length;i++){
                        $("#edit_companyshow select").append("<option value='"+customerList[i].id+"'>"+customerList[i].name+"</option>");
                    }
                    $("#editCustomerForm")[0].reset();
                    var customer = data.data.customer;
                    if(customer.type != "company"){
                        $("#edit_companyshow").show();
                    }else{
                        $("#edit_companyshow").hide();
                    }
                    $("#edit_id").val(customer.id);
                    $("#edit_userid").val(customer.userid);
                    $("#edit_name").val(customer.name);
                    $("#edit_tel").val(customer.tel);
                    $("#edit_email").val(customer.email);
                    $("#edit_weixin").val(customer.weixin);
                    $("#edit_address").val(customer.address);
                    $("#edit_companyid").val(customer.companyid);
                    $("#edit_level").val(customer.level);
//TODO 公司和个人单选框怎么选择

                    $("#editCustomerModal").modal({
                        show:true,
                        backdrop:'static',
                        keyboard:false
                    });
                }
            }).fail(function () {
                alert("请求服务器失败");
            });
        });
//        修改提交
        $("#editBtn").click(function () {
            $("#editCustomerForm").submit();
        });
        $("#editCustomerForm").validate({
            errorElement:"span",
            errorClass:"text-danger",
            rules:{
                name:{
                    required:true
                },
                tel:{
                    required:true
                }
            },
            messages:{
                name:{
                    required:"请输入客户姓名"
                },
                tel:{
                    required:"请输入客户电话"
                }

            },
            submitHandler: function (form) {
                $.post("/customer/edit",$(form).serialize()).done(function (data) {
                    if(data == "success"){
                        $dataTable.ajax.reload();
                        $("#editCustomerModal").modal("hide");
                    }
                }).fail(function () {
                    alert("请求服务器错误！");
                });
            }
        });

//        dataTables数据获取
        var $dataTable = $("#noticeList").DataTable({
            serverSide:true,
            ajax:"/customer/load",
            ordering:false,
            autoWidth:false,
            columns:[
                {"data": function (row) {
                    return row.type == "company" ? "<i class='fa fa-bank'></i>" : "<i class='fa fa-user'></i>"
                }},
                {"data": function (row) {
                        return row.type == "person" && row.companyname != null ? row.name+"-"+row.companyname : row.name
                }},
                {"data":"tel"},
                {"data":"address"},
                {"data":"level"},
                {"data": function (row) {
                    return <shiro:hasRole name="经理">"<a href='javascript:;' class='del' rel='"+row.id+"'>删除  </a>" +</shiro:hasRole>"<a href='javascript:;' class='edit' rel='"+row.id+"' >编辑</a> ";
                }}
            ],
            "language":{ //定义中文
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
