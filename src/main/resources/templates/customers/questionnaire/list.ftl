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
                <h2>客户页面管理</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="/main">Home</a>
                    </li>
                    <li class="active">
                        <strong>questionnaire</strong>
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
                        <div class="ibox-content">
                            <div class="bar search-bar">
                                <div class="form-inline">
                                    <div class="form-group" id="dataRange">
                                        <label>标题</label>
                                        <input type="text" class="form-control" id="name" style="width: 150px;">
                                        &nbsp&nbsp&nbsp
                                        <label>语言</label>
                                        <select class="form-control" id="locales">
                                            <option value="zh-CN" >中文</option>
                                            <option value="zh-TW" >繁体</option>
                                            <option value="en-US">English</option>
                                        </select>
                                    </div>

                                    &nbsp&nbsp&nbsp

                                    <button class="btn btn-success"  id="search" type="button" onclick="Questionnaire.search()">搜索</button>&nbsp
                                    <button class="btn btn-success" type="button" onclick="Questionnaire.resetSearch()">重置</button>&nbsp
                                    <button class="btn btn-primary" type="button" onclick="Questionnaire.create()">新增</button>
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

<#--新增弹框-->
<div class="modal fade" id="createModal" tabindex="-1"  role="dialog" aria-labelledby="modalTitle" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalTitle">新增调查问卷</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="create-form">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">调查问卷名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="name">
                        </div>

                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">语言</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="locales" id="locales">
                                <option value="zh-CN" selected>中文</option>
                                <option value="zh-TW">繁体中文</option>
                                <option value="en-US">English</option>
                            </select>
                        </div>
                    </div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-sm btn-primary" onclick="Questionnaire.insert()">确定</button>
                <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<#--分配角色弹框-->
<#include "/templates/layout/commonjs.ftl">

<script src="/static/modular/customers/questionnaire/questionnaire.js"></script>

<script type="text/javascript">
    $(document).ready(function(){

    });
</script>
</body>
</html>
