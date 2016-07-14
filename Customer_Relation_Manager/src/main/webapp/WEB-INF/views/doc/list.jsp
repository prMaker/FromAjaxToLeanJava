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
    <title>凯盛CRM|文档管理</title>
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
    <link rel="stylesheet" href="/static/plugins/webuploader/webuploader.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <%@include file="../include/mainHeader.jsp"%>
    <%@include file="../include/leftSide.jsp"%>
    <jsp:include page="../include/leftSide.jsp">
        <jsp:param name="menu" value="doc"/>
    </jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                文档管理
            </h1>
            <ol class="breadcrumb">

                <c:forEach items="${fidList}" var="fid">
                    <li><a href="/doc/upper/${fid}"><i class="fa fa-dashboard"></i>返回上一层</a></li>
                </c:forEach>

                <c:if test="${fid != 0}">
                    <li><a id="upperStory" href="/doc/upper/${fid}"><i class="fa fa-dashboard"></i>返回上一层</a></li>
                </c:if>
            </ol>
        </section>


        <!-- Main content -->
        <section class="content">

            <div class="box box-primary">

                <div class="box-header with-border">
                    <h3 class="box-title">文档列表-${fid}</h3>

                    <button class="btn btn-bitbucket btn-xs pull-right" id="newFolder"><i class="fa fa-folder"></i> 新建文件夹</button>
                    <div id="uploadBtn" class="pull-right"><span><i class="fa fa-upload"></i> 文件上传</span></div>

                </div>
                    <table class="table table-bordered table-hover" id="noticeList">
                        <thead>
                            <tr>
                                <th>文件类型</th>
                                <th>文件名</th>
                                <th>分享人</th>
                                <th>文件大小</th>
                                <th>分享日期</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${documentList}" var="document">
                                <tr>

                                        <c:choose>
                                            <c:when test="${document.type == 'dir'}">
                                                <td><i class="fa fa-folder-o"></i></td>
                                                <td><a href="/doc?fid=${document.id}">${document.filename}</a></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><i class="fa fa-file-o"></i></td>
                                                <td><a href="/doc/download/${document.id}">${document.filename}</a></td>
                                            </c:otherwise>
                                        </c:choose>

                                    <td>${document.createuser}</td>
                                    <td>${document.size}</td>
                                    <td>${document.createtime}</td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>

            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->


<div class="modal fade" id="newFolderModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">创建新文件夹</h4>
            </div>

            <div class="modal-body">
                <form id="newForm" action="/doc/dir/new" method="post">
                    <input type="hidden" name="fid" value="${fid}">
                    <div class="form-group">
                        <label>文件名</label>
                        <input type="text" class="form-control" name="folderName" id="dirName">
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
<script src="/static/plugins/webuploader/webuploader.min.js"></script>

<script>

    $(function () {

//        文件上传百度WebUpload
        var upload = WebUploader.create({
            swf:"/static/plugins/webuploader/Uploader.swf",
            pick:"#uploadBtn",
            server:"/doc/file/upload",
            fileVal:"file",
            formData:{
                "fid":${fid}
            },
            auto:true
        });
        upload.on("startUpload", function () {
            $("#uploadBtn span").html("上传中...");
        });
        upload.on("uploadSuccess", function (file,data) {
            console.log(data);
            if(data._raw == "success"){
                window.history.go(0);
            }
        });
        upload.on("uploadError", function (file) {
            alert("上传失败");
        });
        upload.on("uploadComplete", function (file) {
            $("#uploadBtn span").html('<i class="fa fa-upload"></i> 文件上传');
        });
        
//        创建文件夹
        $("#newFolder").click(function () {
            $("#newForm")[0].reset();
            $("#newFolderModal").modal({
                show:true,
                backdrop:'static',
                keyboard:false
            });
        });
        $("#saveBtn").click(function () {
            if(!$("#dirName").val()){
                $("#dirName").focus();
                return;
            }
            $("#newForm").submit();
        });

        <%--$("#upperStory").click(function () {--%>
            <%--var fid = ${documentList};--%>
            <%--if(fid > 0){--%>
                <%--window.location.href = "/doc?fid="+(fid-1);--%>
            <%--}--%>
        <%--});--%>

    });

</script>



</body>
</html>
