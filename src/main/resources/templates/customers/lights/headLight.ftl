<!DOCTYPE html>
<html>

<head>
    <#include "/templates/layout/meta.ftl">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="/static/css/style.css" rel="stylesheet">
    <link href="/static/css/plugins/easyUpload/easy-upload.css" rel="stylesheet">
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
                <h2>客户管理</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="/main">Home</a>
                    </li>
                    <li class="active">
                        <strong>headLight</strong>
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
                                <h5>头灯</h5>
                            </div>
                            <div class="ibox-content">
                                <div id="easyContainer"></div>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    <#include "/templates/layout/footer.ftl">
    </div>
</div>

<#include "/templates/layout/commonjs.ftl">
<script src="/static/js/plugins/easyUpload/vendor/jquery.cookie-1.4.1.min.js"></script>
<script src="/static/js/plugins/easyUpload/easyUpload.js"></script>

<script>
    $('#easyContainer').easyUpload({
        allowFileTypes:'*.jpg;*.jpeg;*.png',//允许上传文件类型，格式';*.doc;*.pdf'
        allowFileSize: 100000,//允许上传文件大小(KB)
        selectText: '选择文件',//选择文件按钮文案
        multi: true,//是否允许多文件上传
        multiNum: 20,//多文件上传时允许的文件数
        showNote: true,//是否展示文件上传说明
        note: '提示：最多上传20个文件，支持格式为doc、pdf、jpg 且文件名不能重复',//文件上传说明
        showPreview: true,//是否显示文件预览
        url: '/backstageApi/customers/headLight/uploadFiles',//上传文件地址
        fileName: 'file',//文件filename配置参数
        timeout: 30000,//请求超时时间
        okCode: 0,//与后端返回数据code值一致时执行成功回调，不配置默认200
        callbackImg: "${headLight}",
        successFunc: function(res) {
            console.log('成功回调', res);
        },//上传成功回调函数
        errorFunc: function(res) {
            console.log('失败回调', res);
        },//上传失败回调函数
        deleteFunc: function(filename) {
            console.log('删除回调', filename);
            $.ajax({
                url:"/backstageApi/customers/headLight/deleteFile?filename="+filename,
                type: 'GET',
                contentType: "application/json",
                success:function (r) {
                }
            })
        }//删除文件回调函数
    });
</script>
</body>
</html>
