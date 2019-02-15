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
                <h2>关于我们页面管理</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="/main">Home</a>
                    </li>
                    <li>
                        <a href="/backstageApi/aboutUs/companyDynamics">companyDynamics</a>
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
                                <h5>公司介绍</h5>
                            </div>
                            <div class="ibox-content">
                                <form class="form-horizontal"  id="create-form" enctype="multipart/form-data" method="post" >

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">语言</label>
                                        <div class="col-sm-4">
                                            <select class="form-control" name="locales" id="locales">
                                                <#if (companyDynamics.locales)??>
                                                    <option value="zh-CN" <#if companyDynamics.locales == "zh-CN">selected</#if> >中文</option>
                                                    <option value="zh-TW" <#if companyDynamics.locales == "zh-TW">selected</#if>>繁体中文</option>
                                                    <option value="en-US" <#if companyDynamics.locales == "en-US">selected</#if>>English</option>
                                                <#else >
                                                   <option value="zh-CN">中文</option>
                                                    <option value="zh-TW">繁体中文</option>
                                                    <option value="en-US">English</option>
                                                </#if>

                                            </select>
                                        </div>
                                    </div>

                                    <div class="ibox-title">
                                        <h5>公司介绍</h5>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">公司介绍标题</label>
                                        <div class="col-sm-4">
                                            <input id="id" type="hidden" name="id" value="${companyDynamics.id!}">
                                            <input id="title" type="text" class="form-control" name="title" value="${companyDynamics.title!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">大致内容</label>
                                        <div class="col-sm-10">
                                            <input id="content" type="text" class="form-control" name="content" value="${companyDynamics.content!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">内容</label>
                                        <div class="col-sm-10">
                                            <textarea id="contentDetail" name="contentDetail"  style="width: 100%;height: 100px">${companyDynamics.contentDetail!}</textarea>
                                        </div>
                                    </div>

                                </form>
                                <br/>
                                <button type="button" class="btn btn-sm btn-primary" onclick="CompanyDynamicsEdit.update()">确定提交</button>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    <#include "/templates/layout/footer.ftl">
    </div>
</div>

<#include "/templates/layout/commonjs.ftl">

<script src="/static/modular/aboutUs/companyDynamics/edit.js"></script>

<script type="text/javascript">

    $(document).ready(function(){
        // $("#locales").change(function () {
        //     $.ajax({
        //         url:"/backstageApi/aboutUs/companyIntroduce/changeLocales?locales="+$("#locales").val(),
        //         type: 'GET',
        //         contentType: "application/json",
        //         success:function (r) {
        //             var data = r.obj;
        //             console.log(data);
        //             $("#id").val(data.id);
        //             $("#companyLabel").val(data.companyLabel);
        //             $("#introduce").val(data.introduce);
        //             $("#companyLabel").val(data.companyLabel);
        //             $("#czCompanyLabel").val(data.czCompanyLabel);
        //             $("#czCompany").val(data.czCompany);
        //             $("#cqCompanyLabel").val(data.cqCompanyLabel);
        //             $("#cqCompany").val(data.cqCompany);
        //
        //
        //
        //         }
        //     })
        // });
        fileplugin.change('#imgUrl', '#previewImgUrl', null, $('#previewImgUrl').prop('src'));
        fileplugin.change('#czImgUrl', '#czPreviewImgUrl', null, $('#czPreviewImgUrl').prop('src'));
        fileplugin.change('#cqImgUrl', '#cqPreviewImgUrl', null, $('#cqPreviewImgUrl').prop('src'));

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


    })
</script>
</body>
</html>
