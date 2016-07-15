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
    <title>凯盛CRM|客户|${customer.name}</title>
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
    <div class="content-wrapper" style="position: relative;">

            <%--客户信息显示--%>
            <section class="content">

                <div class="box box-primary">

                    <div class="box-header with-border">
                        <h2 class="box-title">
                            <c:choose>
                                <c:when test="${customer.type == 'company'}">
                                    <i class="fa fa-bank"></i>
                                </c:when>
                                <c:otherwise>
                                    <i class="fa fa-user"></i>
                                </c:otherwise>
                            </c:choose>

                             ${customer.name}</h2>
                        <a href="javascript:;" id="openCustomerBtn" class="btn btn-warning btn-xs pull-right" style="margin:0px 5px"><i class="fa fa-user-plus"></i>公开客户</a>
                        <a href="javascript:;" id="moveCustomerBtn" class="btn btn-primary btn-xs pull-right"><i class="fa fa-user-md"></i>转移客户</a>

                        <%--<shiro:hasRole name="经理" >--%>
                            <%--<a href="/notice/new" class="btn btn-success btn-xs pull-right"><i class="fa fa-pencil"></i>发表公告</a>--%>
                        <%--</shiro:hasRole>--%>
                    </div>

                    <div class="box-body">

                        <table class="table table-bordered" id="noticeList">

                            <tbody>
                                <tr>
                                    <td>联系电话</td>
                                    <td>${customer.tel}</td>
                                    <td>微信</td>
                                    <td>${customer.weixin}</td>
                                    <td>电子邮件</td>
                                    <td>${customer.email}</td>
                                </tr>
                                <tr>
                                    <td>等级</td>
                                    <td style="color: #ecd73d;">${customer.level}</td>
                                    <td>地址</td>
                                    <td>${customer.address}</td>
                                    <td></td>
                                    <td></td>
                                </tr>

                                    <c:choose>
                                        <c:when test="${customer.type == 'person' and customer.companyname != null}">
                                            <tr>
                                                <td>公司</td>
                                                <td><a href="/customer/${customer.companyid}">${customer.companyname}</a></td>
                                            </tr>
                                        </c:when>

                                        <c:when test="${customer.type == 'company'}">
                                            <tr>
                                                <td>所属员工</td>
                                                <td colspan="5">
                                                    <c:forEach items="${customerList}" var="customer">
                                                        <a href="/customer/${customer.id}">${customer.name}&nbsp;&nbsp;</a>
                                                    </c:forEach>
                                                </td>
                                            </tr>
                                        </c:when>
                                    </c:choose>

                            </tbody>

                        </table>
                    </div>
                </div>
            </section>

            <%--客户相关活动管理--%>
                <section class="content container" style="position: relative">
                    <%--项目管理显示--%>
                    <div class="box box-primary" style="width: 66%;float:left;">
                        <div class="box-header with-border">
                            <h2 class="box-title"><i class="fa fa-list"></i> 项目管理</h2>
                        </div>
                        <div class="box-body">
                            <h4>暂无项目管理</h4>
                        </div>
                    </div>

                    <%--二维码显示--%>
                    <div class="box box-primary" style="width: 31%;position: relative;float:right;">
                         <div class="box-header with-border">
                             <h2 class="box-title"><i class="fa fa-qrcode"></i> 二维码显示客户信息</h2>
                         </div>
                         <div class="box-body" style="text-align: center">
                             <img src="/customer/qrcode/${customer.id}.png" alt="">
                         </div>
                    </div>

                    <%--待办事项显示--%>
                    <div class="box box-primary" style="width: 31%;position: relative;float:right;clear: both;">
                        <div class="box-header with-border">
                            <h2 class="box-title"><i class="fa fa-pencil-square-o"></i> 待办事项</h2>
                        </div>
                        <div class="box-body">
                            <h4>暂无代办事项</h4>
                        </div>
                    </div>
                </section>

    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->


<div class="modal fade" id="moveCustomerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">转移客户</h4>
            </div>
            <div class="modal-body">

                <form id="moveCustomerForm" method="post">
                    <input type="hidden" name="id" value="${customer.id}" id="id">
                    <div class="form-group" id="user">
                        <label>员工列表</label>
                        <select class="form-control" name="userid" id="userid">
                            <option></option>
                            <c:forEach items="${userList}" var="user">
                                <option value="${user.id}">${user.realname}</option>
                            </c:forEach>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" id="moveCustomerFormBtn" class="btn btn-primary">确认转移该客户</button>
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

//        转移客户摸态框出
        $("#moveCustomerBtn").click(function () {
            if(confirm("确认转移该客户？")){
                $("#moveCustomerForm")[0].reset();
                $("#moveCustomerModal").modal({
                    show:true,
                    backdrop:'static',
                    keyboard:false
                });
            }
        });

//        转移客户提交
        $("#moveCustomerFormBtn").click(function () {
            $("#moveCustomerForm").submit();
        });
        $("#moveCustomerForm").validate({
            errorElement:"span",
            errorClass:"text-danger",
            rules:{
                userid:"required"
            },
            messages:{
                userid:"请选择将要转移的员工"
            },
            submitHandler: function (form) {
                $.post("/customer/move",{"id":$("#id").val(),"userid":$("#userid").val()}).done(function (data) {
                    if(data == "success"){
                        window.location.href="/customer";
                    }
                }).fail(function () {
                    alert("请求服务器错误");
                });
            }
        });

//        OPEN客户
        $("#openCustomerBtn").click(function () {
            if(confirm("确认要公开此客户么，公开后将不受控制，同时公开该客户的所有代办事项和项目")){
                var id = ${customer.id};
                $.get("/customer/open/"+id).done(function (data) {
                    if(data == "success"){
                        window.location.href = "/customer";
                    }
                }).fail(function () {
                    alert("请求服务器异常");
                });
            }
        });
    });

</script>



</body>
</html>
