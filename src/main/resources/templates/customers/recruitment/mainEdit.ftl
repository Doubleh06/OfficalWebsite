<!DOCTYPE html>
<html>

<head>
    <#include "/templates/layout/meta.ftl">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="/static/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
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
                <h2>招聘页面管理</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="/main">Home</a>
                    </li>
                    <li>
                        <a href="/backstageApi/career/recruitment">recruitment</a>
                    </li>
                    <li class="active">
                        <strong>edit</strong>
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
                                <h5>人才招聘明细</h5>
                            </div>
                            <div class="ibox-content">
                                <form class="form-horizontal"  id="create-form" enctype="multipart/form-data" method="post" >

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">语言</label>
                                        <div class="col-sm-4">
                                            <select class="form-control" name="locales" id="locales">
                                                <#if (recruitment.locales)??>
                                                    <option value="zh-CN" <#if recruitment.locales == "zh-CN">selected</#if> >中文</option>
                                                    <option value="zh-TW" <#if recruitment.locales == "zh-TW">selected</#if>>繁体中文</option>
                                                    <option value="en-US" <#if recruitment.locales == "en-US">selected</#if>>English</option>
                                                <#else >
                                                   <option value="zh-CN">中文</option>
                                                    <option value="zh-TW">繁体中文</option>
                                                    <option value="en-US">English</option>
                                                </#if>

                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">组ID</label>
                                        <div class="col-sm-4">
                                            <input id="groupId" name="groupId" type="text" class="form-control"  value="${recruitment.groupId!}">
                                        </div>
                                    </div>
                                    <#--<div class="ibox-title">-->
                                        <#--<h5</h5>-->
                                    <#--</div>-->
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">职位名称</label>
                                        <div class="col-sm-4">
                                            <input id="id" type="hidden" name="id" value="${recruitment.id!}">
                                            <input id="jobTitle" name="jobTitle" type="text" class="form-control"  value="${recruitment.jobTitle!}">
                                        </div>
                                        <label class="col-sm-2 control-label">工作年限</label>
                                        <div class="col-sm-4">
                                            <input id="workLife" name="workLife" type="text" class="form-control"  value="${recruitment.workLife!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">招聘人数</label>
                                        <div class="col-sm-4">
                                            <input id="recruitNum" name="recruitNum" type="text" class="form-control"  value="${recruitment.recruitNum!}">
                                        </div>
                                        <label class="col-sm-2 control-label">工作地区</label>
                                        <div class="col-sm-4">
                                            <input id="workDistinct" name="workDistinct" type="text" class="form-control"  value="${recruitment.workDistinct!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">发布日期</label>
                                        <div class="col-sm-4">
                                            <div class="input-group date">
                                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input id="releaseTime" name="releaseTime" type="text" class="form-control" value="${recruitment.releaseTime!}">
                                            </div>
                                        </div>
                                        <label class="col-sm-2 control-label">工作性质</label>
                                        <div class="col-sm-4">
                                            <input id="workNature" name="workNature" type="text" class="form-control"  value="${recruitment.workNature!}">
                                        </div>
                                    </div>


                                </form>
                                <br/>
                                <button type="button" class="btn btn-sm btn-primary" onclick="MainEdit.update()">确定提交</button>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    <#include "/templates/layout/footer.ftl">
    </div>
</div>

<#include "/templates/layout/commonjs.ftl">
<script src="/static/js/plugins/datapicker/bootstrap-datepicker.js"></script>
<script src="/static/modular/career/recruitment/mainEdit.js"></script>

<script type="text/javascript">

    $(document).ready(function(){
        $('#releaseTime').datepicker({
            todayBtn: "linked",
            keyboardNavigation: false,
            forceParse: false,
            calendarWeeks: true,
            autoclose: true,
            format: "yyyy-mm-dd"
        });


    })
</script>
</body>
</html>
