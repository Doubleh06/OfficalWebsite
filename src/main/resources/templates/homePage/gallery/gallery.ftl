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
                <h2>主页管理</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="/main">Home</a>
                    </li>
                    <li class="active">
                        <strong>gallery</strong>
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
                                <h5>照片墙</h5>
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



                                    <#list galleries as gallery>
                                        <div class="ibox-title">
                                        </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">图片</label>
                                        <div class="col-sm-10">
                                            <div class="uploadPic" title="1920 x 400的图片,大小不超过100k">
                                                <div class="upload pic_img">
                                                    <img  class="file-pic-img" src="${gallery.img!}"
                                                          id="previewImgUrl${gallery_index}" name="previewImgUrl${gallery_index}" width="100%" height="100%"/>
                                                    <i class="icon icon_img mt30 mb10"></i>
                                                    <p>暂时未定大小
                                                    </p>
                                                </div>
                                                <div class="uploadPic_btn_box">
                                                    <input type="file"  name="imgUrl${gallery_index}" id="imgUrl${gallery_index}" data-file_type="image/jpg|image/png|image/jpeg" style="display: none" data-max_size="2024000">
                                                    <div class="btn_upload uploadPicBtn uploadpic">重新上传</div><div class="btn_upload uploadPicBtn_del delpic0">删除</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">标题</label>
                                        <div class="col-sm-4">
                                            <input id="id${gallery_index}" type="hidden" name="id${gallery_index}" value="${gallery.id}">
                                            <input id="title${gallery_index}" name="title${gallery_index}" type="text" class="form-control"  value="${gallery.h3!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">内容</label>
                                        <div class="col-sm-10">
                                            <textarea id="content${gallery_index}" name="content${gallery_index}"  style="width: 100%;height: 100px">${gallery.h4!}</textarea>
                                        </div>
                                    </div>
                                   <div class="form-group">
                                       <label class="col-sm-2 control-label">按钮内容</label>
                                       <div class="col-sm-4">
                                           <input id="label${gallery_index}" name="label${gallery_index}" type="text" class="form-control"  value="${gallery.label!}">
                                       </div>
                                   </div>
                                    </#list>


                                </form>
                                <br/>
                                <button type="button" class="btn btn-sm btn-primary" onclick="Gallery.update()">确定提交</button>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    <#include "/templates/layout/footer.ftl">
    </div>
</div>

<#include "/templates/layout/commonjs.ftl">

<script src="/static/modular/homePage/gallery/gallery.js"></script>

<script type="text/javascript">

    $(document).ready(function(){
        $("#locales").change(function () {
            $.ajax({
                url:"/backstageApi/home/gallery/changeLocales?locales="+$("#locales").val(),
                type: 'GET',
                contentType: "application/json",
                success:function (r) {
                    var data = r.obj;
                    for(var i=0;i<data.length;i++){
                        $("#"+"id"+i).val(data[i].id);
                        $("#"+"title"+i).val(data[i].h3);
                        $("#"+"content"+i).val(data[i].h4);
                        $("#"+"aLabel"+i).val(data[i].aLabel);
                        $("#"+"previewImgUrl"+i).attr("src",data[i].img);
                    }

                }
            })
        });
        fileplugin.change('#imgUrl0', '#previewImgUrl0', null, $('#previewImgUrl0').prop('src'));
        fileplugin.change('#imgUrl1', '#previewImgUrl1', null, $('#previewImgUrl1').prop('src'));
        fileplugin.change('#imgUrl2', '#previewImgUrl2', null, $('#previewImgUrl2').prop('src'));

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
