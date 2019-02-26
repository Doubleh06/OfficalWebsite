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
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">图片1</label>
                                            <div class="col-sm-10">
                                                <div class="uploadPic" title="1920 x 400的图片,大小不超过100k">
                                                    <div class="upload pic_img">
                                                        <img  class="file-pic-img" src="${img1!}"
                                                              id="previewImgUrl1" name="previewImgUrl1" width="100%" height="100%"/>
                                                        <i class="icon icon_img mt30 mb10"></i>
                                                        <p>暂时未定大小
                                                        </p>
                                                    </div>
                                                    <div class="uploadPic_btn_box">
                                                        <input type="file"  name="imgUrl1" id="imgUrl1" data-file_type="image/jpg|image/png|image/jpeg" style="display: none" data-max_size="2024000">
                                                        <div class="btn_upload uploadPicBtn uploadpic">重新上传</div><div class="btn_upload uploadPicBtn_del delpic0">删除</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">图片2</label>
                                        <div class="col-sm-10">
                                            <div class="uploadPic" title="1920 x 400的图片,大小不超过100k">
                                                <div class="upload pic_img">
                                                    <img  class="file-pic-img" src="${img2!}"
                                                          id="previewImgUrl2" name="previewImgUrl2" width="100%" height="100%"/>
                                                    <i class="icon icon_img mt30 mb10"></i>
                                                    <p>暂时未定大小
                                                    </p>
                                                </div>
                                                <div class="uploadPic_btn_box">
                                                    <input type="file"  name="imgUrl2" id="imgUrl2" data-file_type="image/jpg|image/png|image/jpeg" style="display: none" data-max_size="2024000">
                                                    <div class="btn_upload uploadPicBtn uploadpic">重新上传</div><div class="btn_upload uploadPicBtn_del delpic0">删除</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">图片3</label>
                                        <div class="col-sm-10">
                                            <div class="uploadPic" title="1920 x 400的图片,大小不超过100k">
                                                <div class="upload pic_img">
                                                    <img  class="file-pic-img" src="${img3!}"
                                                          id="previewImgUrl3" name="previewImgUrl3" width="100%" height="100%"/>
                                                    <i class="icon icon_img mt30 mb10"></i>
                                                    <p>暂时未定大小
                                                    </p>
                                                </div>
                                                <div class="uploadPic_btn_box">
                                                    <input type="file"  name="imgUrl3" id="imgUrl3" data-file_type="image/jpg|image/png|image/jpeg" style="display: none" data-max_size="2024000">
                                                    <div class="btn_upload uploadPicBtn uploadpic">重新上传</div><div class="btn_upload uploadPicBtn_del delpic0">删除</div>
                                                </div>
                                            </div>
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

        fileplugin.change('#imgUrl1', '#previewImgUrl1', null, $('#previewImgUrl1').prop('src'));
        fileplugin.change('#imgUrl2', '#previewImgUrl2', null, $('#previewImgUrl2').prop('src'));
        fileplugin.change('#imgUrl3', '#previewImgUrl3', null, $('#previewImgUrl3').prop('src'));

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
