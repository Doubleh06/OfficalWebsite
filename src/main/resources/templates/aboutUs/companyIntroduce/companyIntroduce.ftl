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
                    <li class="active">
                        <strong>companyIntroduce</strong>
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
                                                <option value="zh-CN" selected>中文</option>
                                                <option value="zh-TW">繁体中文</option>
                                                <option value="en-US">English</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">banner图片</label>
                                        <div class="col-sm-10">
                                            <div class="uploadPic" title="1920 x 400的图片,大小不超过100k">
                                                <div class="upload pic_img">
                                                    <img  class="file-pic-img" src="${imgUrl!}"
                                                          id="previewImgUrl" name="previewImgUrl" width="100%" height="100%"/>
                                                    <i class="icon icon_img mt30 mb10"></i>
                                                    <p>1920 x 400的图片,大小不超过100k
                                                    </p>
                                                </div>
                                                <div class="uploadPic_btn_box">
                                                    <input type="file"  name="imgUrl" id="imgUrl" data-file_type="image/jpg|image/png|image/jpeg" style="display: none" data-max_size="2024000">
                                                    <div class="btn_upload uploadPicBtn uploadpic">重新上传</div><div class="btn_upload uploadPicBtn_del delpic0">删除</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="ibox-title">
                                        <h5>公司介绍</h5>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">公司介绍标题</label>
                                        <div class="col-sm-4">
                                            <input id="id" type="hidden" name="id" value="${companyIntroduce.id}">
                                            <input id="companyLabel" type="text" class="form-control" name="companyLabel" value="${companyIntroduce.companyLabel}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">公司介绍</label>
                                        <div class="col-sm-10">
                                            <textarea id="introduce" name="introduce"  style="width: 100%;height: 100px">${companyIntroduce.introduce}</textarea>
                                        </div>
                                    </div>

                                    <div class="ibox-title">
                                        <h5>常州工厂</h5>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">常州公司介绍标题</label>
                                        <div class="col-sm-4">
                                            <input id="czCompanyLabel" type="text" class="form-control" name="czCompanyLabel" value="${companyIntroduce.czCompanyLabel}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">常州公司介绍</label>
                                        <div class="col-sm-10">
                                            <textarea id="czCompany" name="czCompany"  style="width: 100%;height: 100px">${companyIntroduce.czCompany}</textarea>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">常州工厂图片</label>
                                        <div class="col-sm-10">
                                            <div class="uploadPic" title="1920 x 400的图片,大小不超过100k">
                                                <div class="upload pic_img">
                                                    <img  class="file-pic-img" src="${companyIntroduce.czImg}"
                                                          id="czPreviewImgUrl" name="czPreviewImgUrl" width="100%" height="100%"/>
                                                    <i class="icon icon_img mt30 mb10"></i>
                                                    <p>暂时随意，不要太大
                                                        <#--1920 x 400的图片,大小不超过100k-->
                                                    </p>
                                                </div>
                                                <div class="uploadPic_btn_box">
                                                    <input type="file"  name="czImgUrl" id="czImgUrl" data-file_type="image/jpg|image/png|image/jpeg" style="display: none" data-max_size="2024000">
                                                    <div class="btn_upload uploadPicBtn uploadpic">重新上传</div><div class="btn_upload uploadPicBtn_del delpic0">删除</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="ibox-title">
                                        <h5>重庆工厂</h5>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">重庆公司介绍标题</label>
                                        <div class="col-sm-4">
                                            <input id="cqCompanyLabel" type="text" class="form-control" name="cqCompanyLabel" value="${companyIntroduce.cqCompanyLabel}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">公司介绍</label>
                                        <div class="col-sm-10">
                                            <textarea id="cqCompany" name="cqCompany"  style="width: 100%;height: 100px">${companyIntroduce.cqCompany}</textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">重庆工厂图片</label>
                                        <div class="col-sm-10">
                                            <div class="uploadPic" title="1920 x 400的图片,大小不超过100k">
                                                <div class="upload pic_img">
                                                    <img  class="file-pic-img" src="${companyIntroduce.cqImg}"
                                                          id="cqPreviewImgUrl" name="cqPreviewImgUrl" width="100%" height="100%"/>
                                                    <i class="icon icon_img mt30 mb10"></i>
                                                    <p>暂时随意，不要太大
                                                        <#--1920 x 400的图片,大小不超过100k-->
                                                    </p>
                                                </div>
                                                <div class="uploadPic_btn_box">
                                                    <input type="file"  name="cqImgUrl" id="cqImgUrl" data-file_type="image/jpg|image/png|image/jpeg" style="display: none" data-max_size="2024000">
                                                    <div class="btn_upload uploadPicBtn uploadpic">重新上传</div><div class="btn_upload uploadPicBtn_del delpic0">删除</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                                <br/>
                                <button type="button" class="btn btn-sm btn-primary" onclick="CompanyIntroduce.update()">确定提交</button>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    <#include "/templates/layout/footer.ftl">
    </div>
</div>

<#include "/templates/layout/commonjs.ftl">

<script src="/static/modular/aboutUs/companyIntroduce/companyIntroduce.js"></script>

<script type="text/javascript">

    $(document).ready(function(){
        $("#locales").change(function () {
            $.ajax({
                url:"/backstageApi/aboutUs/companyIntroduce/changeLocales?locales="+$("#locales").val(),
                type: 'GET',
                contentType: "application/json",
                success:function (r) {
                    var data = r.obj;
                    console.log(data);
                    $("#id").val(data.id);
                    $("#companyLabel").val(data.companyLabel);
                    $("#introduce").val(data.introduce);
                    $("#companyLabel").val(data.companyLabel);
                    $("#czCompanyLabel").val(data.czCompanyLabel);
                    $("#czCompany").val(data.czCompany);
                    $("#cqCompanyLabel").val(data.cqCompanyLabel);
                    $("#cqCompany").val(data.cqCompany);



                }
            })
        });
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
