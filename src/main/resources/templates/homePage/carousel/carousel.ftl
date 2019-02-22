<!DOCTYPE html>
<html>

<head>
    <#include "/templates/layout/meta.ftl">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="/static/css/plugins/dropzone/dropzone.css" rel="stylesheet">
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
                                <form class="form-horizontal"  id="create-form" enctype="multipart/form-data" method="post" >
                                    <input type="hidden" class="form-control"  id="uuid" name="uuid"  value="${uuid}" >
                                </form>
                                <form action="#" class="dropzone" id="dropzoneForm">
                                    <div class="fallback">
                                        <input name="file" type="file" multiple />
                                    </div>
                                </form>
                                <br/>
                                <button type="button" class="btn btn-sm btn-primary" onclick="Carousel.insert()">确定提交</button>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    <#include "/templates/layout/footer.ftl">
    </div>
</div>

<#include "/templates/layout/commonjs.ftl">
<script src="/static/js/plugins/dropzone/dropzone.js"></script>

<script src="/static/modular/homePage/carousel/carousel.js"></script>
<#--<script src="/static/modular/homePage/carousel/carousel.js"></script>-->

<script type="text/javascript">
    Dropzone.autoDiscover = false;
    var myDropzone ;
    $("#dropzoneForm").dropzone({
        url: "/backstageApi/home/uploadFile?uuid=${uuid}", //必须填写
        method: "post",  //也可用put
        paramName: "files", //默认为file
        maxFiles: 5,//一次性上传的文件数量上限
        maxFilesize: 50, //MB
        acceptedFiles: ".jpg,.png,.jpeg", //上传的类型
        parallelUploads: 3,
        addRemoveLinks: true,
        uploadMultiple:true,//是否在一个请求中发送多个文件
        dictMaxFilesExceeded: "您最多只能上传10个文件！",
        dictResponseError: '文件上传失败!',
        dictRemoveFile:'移除',
        dictInvalidFileType: "你不能上传该类型文件,文件类型只能是*.jpg,*.png,*.jpeg",
        dictFallbackMessage: "浏览器不受支持",
        dictFileTooBig: "文件过大上传文件最大支持.",
        dictDefaultMessage: "<strong>点击此处上传图片 上传图片最大不能超过5M</strong>",
        init: function () {
            myDropzone=this;

            // this.emit("initimage", "/picture/20190128-142030796~c.png,/picture/20190128-142030796~c.png"); //初始化图片

            this.on("addedfile", function (file) {
                //上传时触发的方法
            });
            this.on("queuecomplete", function (file) {
                //上传完成后触发的方法
            });
            this.on("removedfile", function (file) {
                //删除文件时触发的方法
                // alert(file.name);
                $.get("/backstageApi/home/deleteFile?imgSourceName=" + file.name+"&uuid=${uuid}", function () {
                    success("图片删除成功");
                });
            });
        },
        success: function(file, data) {
            // console.log(file.name);
            $("#subImgs").val(data.obj);
        }

    });

    $(document).ready(function(){
        <#--"${imgPaths}";-->
        var carousels = "/picture/home/b.jpg";
        console.log(carousels);
        if(carousels!=null&&""!=carousels){
            var carousel = carousels.split(",");
            for(var i=0;i<carousel.length;i++){
                var mockFile = {
                    name : carousel[i],
                    size:10240,
                    height:150,
                    width:150,
                    type: '.gif,.jpg,.png,.jpeg'};
                myDropzone.options.addedfile.call(myDropzone,mockFile);
                myDropzone.options.thumbnail.call(myDropzone,mockFile,carousel[i]);
            }
        }
    })
</script>
</body>
</html>
