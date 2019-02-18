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
                <h2>人才招聘页面管理</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="/main">Home</a>
                    </li>
                    <li class="active">
                        <strong>faq</strong>
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
                                <h5>联系我们</h5>
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

                                    <#list faqs as faq>
                                        <div class="ibox-title">
                                        </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">问题</label>
                                        <div class="col-sm-4">
                                            <input id="id${faq_index}" type="hidden" name="id${faq_index}" value="${faq.id}">
                                            <input id="question${faq_index}" name="question${faq_index}" type="text" class="form-control"  value="${faq.question}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">答案</label>
                                        <div class="col-sm-10">
                                            <textarea id="answer${faq_index}" name="answer${faq_index}"  style="width: 100%;height: 100px">${faq.answer}</textarea>
                                        </div>
                                    </div>
                                    </#list>


                                </form>
                                <br/>
                                <button type="button" class="btn btn-sm btn-primary" onclick="Faq.update()">确定提交</button>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    <#include "/templates/layout/footer.ftl">
    </div>
</div>

<#include "/templates/layout/commonjs.ftl">

<script src="/static/modular/career/faq/faq.js"></script>

<script type="text/javascript">

    $(document).ready(function(){
        $("#locales").change(function () {
            $.ajax({
                url:"/backstageApi/career/faq/changeLocales?locales="+$("#locales").val(),
                type: 'GET',
                contentType: "application/json",
                success:function (r) {
                    var data = r.obj;
                    for(var i=0;i<data.length;i++){
                        $("#"+"id"+i).val(data[i].id);
                        $("#"+"question"+i).val(data[i].question);
                        $("#"+"answer"+i).val(data[i].answer);
                    }

                }
            })
        });
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


    })
</script>
</body>
</html>
