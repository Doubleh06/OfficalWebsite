<!DOCTYPE html>
<html>

<head>
    <#include "/templates/layout/meta.ftl">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/static/css/plugins/upload/jquery.filer.css">
    <link rel="stylesheet" type="text/css" href="/static/css/plugins/upload/jquery.filer-dragdropbox-theme.css">
    <!--<link rel="stylesheet" type="text/css" href="css/tomorrow.css">-->
    <link rel="stylesheet" type="text/css" href="/static/css/plugins/upload/custom.css">
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
                        <strong>carousel</strong>
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
                                <h5>首页走马灯</h5>
                            </div>
                            <div class="ibox-content">
                                <div role="tabpanel"  id="demo-dragdrop">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <input type="file" name="files[]" id="demo-fileInput-6" multiple>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    <#include "/templates/layout/footer.ftl">
    </div>
</div>

<#include "/templates/layout/commonjs.ftl">
<script src="/static/js/plugins/upload/jquery.filer.min.js" type="text/javascript"></script>
<script src="/static/js/plugins/upload/prettify.js" type="text/javascript"></script>
<script src="/static/js/plugins/upload/custom.js" type="text/javascript"></script>
<#--<script src="/static/modular/homePage/carousel/carousel.js"></script>-->

<script>

</script>
</body>
</html>
