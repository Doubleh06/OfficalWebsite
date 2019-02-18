<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">

<head>
<#include "/templates/layout/meta.ftl">
    <link href="/static/css/style.css" rel="stylesheet">
</head>

<body>
<div id="wrapper">
<#include "/templates/layout/left.ftl">
    <div id="page-wrapper" class="gray-bg">
    <#include "/templates/layout/header.ftl">

        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>招聘页面管理</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="/main">Home</a>
                    </li>
                    <li class="active">
                        <strong>recruitment</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">

            </div>
        </div>


        <div class="wrapper wrapper-content">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox ">
                        <#--<div class="ibox-title">-->
                            <#--<h5>banner栏</h5>-->
                        <#--</div>-->
                        <#--<div class="ibox-content">-->
                            <#--<form class="form-horizontal"  id="create-form" enctype="multipart/form-data" method="post" >-->
                                <#--<div class="form-group">-->
                                    <#--<label class="col-sm-2 control-label">banner图片</label>-->
                                    <#--<div class="col-sm-10">-->
                                        <#--<div class="uploadPic" title="1920 x 400的图片,大小不超过100k">-->
                                            <#--<div class="upload pic_img">-->
                                                <#--<img  class="file-pic-img" src="${imgUrl!}"-->
                                                      <#--id="previewImgUrl" name="previewImgUrl" width="100%" height="100%"/>-->
                                                <#--<i class="icon icon_img mt30 mb10"></i>-->
                                                <#--<p>1920 x 400的图片,大小不超过100k-->
                                                <#--</p>-->
                                            <#--</div>-->
                                            <#--<div class="uploadPic_btn_box">-->
                                                <#--<input type="file"  name="imgUrl" id="imgUrl" data-file_type="image/jpg|image/png|image/jpeg" style="display: none" data-max_size="2024000">-->
                                                <#--<div class="btn_upload uploadPicBtn uploadpic">重新上传</div><div class="btn_upload uploadPicBtn_del delpic0">删除</div>-->
                                            <#--</div>-->
                                        <#--</div>-->
                                    <#--</div>-->
                                <#--</div>-->
                            <#--</form>-->
                            <#--<button type="button" class="btn btn-sm btn-primary" onclick="Recruitment.updateImg()">确定提交banner图片</button>-->
                            <#--</br>-->
                            <#--</br>-->
                        <#--</div>-->
                        <#--<div class="ibox-title">-->
                            <#--<h5>表格栏</h5>-->
                        <#--</div>-->
                        <div class="ibox-content">
                            <div class="bar search-bar">
                                <div class="form-inline">
                                    <div class="form-group" id="dataRange">
                                        <label>标题</label>
                                        <input type="text" class="form-control" id="jobTitle" style="width: 150px;">
                                        &nbsp&nbsp&nbsp
                                        <label>语言</label>
                                        <select class="form-control" id="locales">
                                            <option value="zh-CN" >中文</option>
                                            <option value="zh-TW" >繁体</option>
                                            <option value="en-US">English</option>
                                        </select>
                                    </div>

                                    &nbsp&nbsp&nbsp

                                    <button class="btn btn-success"  id="search" type="button" onclick="Recruitment.search()">搜索</button>&nbsp
                                    <button class="btn btn-success" type="button" onclick="Recruitment.resetSearch()">重置</button>&nbsp
                                    <button class="btn btn-primary" type="button" onclick="Recruitment.create()">新增</button>
                                </div>

                            </div>
                        </div>
                        <div class="jqGrid_wrapper">
                        <#--jqgrid 表格栏-->
                            <table id="grid-table"></table>
                        <#--jqgrid 分页栏-->
                            <div id="grid-pager"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <#include "/templates/layout/footer.ftl">
    </div>
</div>


<#--分配角色弹框-->
<#include "/templates/layout/commonjs.ftl">

<script src="/static/modular/career/recruitment/recruitment.js"></script>

<script type="text/javascript">
    $(document).ready(function(){
        fileplugin.change('#imgUrl', '#previewImgUrl', null, $('#previewImgUrl').prop('src'));

        //上传图片控件上新增的上传和删除功能按钮展示

        $(".uploadPic").bind({
            mouseenter: function () {
                $(this).find(".uploadPic_btn_box").show();
            }, mouseleave: function () {
                $(this).find(".uploadPic_btn_box").hide();
            }
        });
        $('.uploadPicBtn_del').click(function () {
            $(this).parent().parent().find('img').attr("src", "/static/img/point.gif");
            $(this).parent().find(':file').val('');
        });

        $(".uploadPicBtn").click(function () {
            $(this).parent().find('input').click();
        });
    });
</script>
</body>
</html>
