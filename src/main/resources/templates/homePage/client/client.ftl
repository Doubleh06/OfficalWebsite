<!DOCTYPE html>
<html>

<head>
    <#include "/templates/layout/meta.ftl">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="/static/css/style.css" rel="stylesheet">
    <style>
    </style>

</head>

<body>
<div id="wrapper">
<#include "/templates/layout/left.ftl">
    <div id="page-wrapper" class="gray-bg">
    <#include "/templates/layout/header.ftl">

        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>主页管理</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="/main">Home</a>
                    </li>
                    <li class="active">
                        <strong>client</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>

        <div class="wrapper wrapper-content">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox">
                            <div class="ibox-title">
                                <h5>首页客户端</h5>
                            </div>
                            <div class="ibox-content">
                                <form class="form-horizontal"  id="create-form" enctype="multipart/form-data" method="post" >
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">语言</label>
                                        <div class="col-sm-4">
                                            <select class="form-control" name="locales" id="locales">
                                                <option value="zh-CN" selected>中文</option>
                                                <option value="zh-TW">繁体中文</option>
                                                <option value="en-US">English</option>
                                            </select>
                                        </div>
                                    </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">绿色标题</label>
                                            <div class="col-sm-4">
                                                <input id="id1" type="hidden" name="id1" value="${client1.id}">
                                                <input id="greenTitle1" type="text" class="form-control" name="greenTitle1" value="${client1.h3}">
                                            </div>
                                            <label class="col-sm-2 control-label">白色标题</label>
                                            <div class="col-sm-4">
                                                <input id="whiteTitle1" type="text" class="form-control" name="whiteTitle1" value="${client1.span}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">内容</label>
                                            <div class="col-sm-10">
                                                <textarea id="content1" name="content1" style="width: 100%;height: 100px"> ${client1.p}</textarea>
                                            </div>
                                        </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">绿色标题</label>
                                        <div class="col-sm-4">
                                            <input id="id2" type="hidden" name="id2" value="${client2.id}">
                                            <input id="greenTitle2" type="text" class="form-control" name="greenTitle2" value="${client2.h3}">
                                        </div>
                                        <label class="col-sm-2 control-label">白色标题</label>
                                        <div class="col-sm-4">
                                            <input id="whiteTitle2" type="text" class="form-control" name="whiteTitle2" value="${client2.span}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">内容</label>
                                        <div class="col-sm-10">
                                            <textarea id="content2" name="content2" style="width: 100%;height: 100px"> ${client2.p}</textarea>
                                        </div>
                                    </div>

                                </form>
                                <br/>
                                <button type="button" class="btn btn-sm btn-primary" onclick="Client.update()">确定提交</button>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    <#include "/templates/layout/footer.ftl">
    </div>
</div>

<#include "/templates/layout/commonjs.ftl">

<script src="/static/modular/homePage/client/client.js"></script>

<script type="text/javascript">

    $(document).ready(function(){
        $("#locales").change(function () {
            $.ajax({
                url:"/backstageApi/home/client/changeLocales?locales="+$("#locales").val(),
                type: 'GET',
                contentType: "application/json",
                success:function (r) {
                    var clients = r.obj;
                    $("#id1").val(clients[0].id);
                    $("#greenTitle1").val(clients[0].h3);
                    $("#whiteTitle1").val(clients[0].span);
                    $("#content1").val(clients[0].p);
                    $("#id2").val(clients[1].id);
                    $("#greenTitle2").val(clients[1].h3);
                    $("#whiteTitle2").val(clients[1].span);
                    $("#content2").val(clients[1].p);
                }
            })
        });
    })
</script>
</body>
</html>
