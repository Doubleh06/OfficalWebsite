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
                        <strong>contactUs</strong>
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

                                    <div class="ibox-title">
                                        <h5>常州</h5>
                                    </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">标题</label>
                                            <div class="col-sm-4">
                                                <input id="id1" type="hidden" name="id1" value="${contactUs1.id}">
                                                <input id="title1" type="text" class="form-control" name="title1" value="${contactUs1.title}">
                                            </div>
                                        </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">热线电话名称</label>
                                        <div class="col-sm-4">
                                            <input id="hotLineDesc1" type="text" class="form-control" name="hotLineDesc1" value="${contactUs1.hotLineDesc}">
                                        </div>
                                        <label class="col-sm-2 control-label">热线电话</label>
                                        <div class="col-sm-4">
                                            <input id="hotLine1" type="text" class="form-control" name="hotLine1" value="${contactUs1.hotLine}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">热线邮箱名称</label>
                                        <div class="col-sm-4">
                                            <input id="hotEmailDesc1" type="text" class="form-control" name="hotEmailDesc1" value="${contactUs1.hotEmailDesc}">
                                        </div>
                                        <label class="col-sm-2 control-label">热线邮箱</label>
                                        <div class="col-sm-4">
                                            <input id="hotEmail1" type="text" class="form-control" name="hotEmail1" value="${contactUs1.hotEmail}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">采购邮箱名称</label>
                                        <div class="col-sm-4">
                                            <input id="purchaseEmailDesc1" type="text" class="form-control" name="purchaseEmailDesc1" value="${contactUs1.purchaseEmailDesc}">
                                        </div>
                                        <label class="col-sm-2 control-label">采购邮箱</label>
                                        <div class="col-sm-4">
                                            <input id="purchaseEmail1" type="text" class="form-control" name="purchaseEmail1" value="${contactUs1.purchaseEmail}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">销售邮箱名称</label>
                                        <div class="col-sm-4">
                                            <input id="saleEmailDesc1" type="text" class="form-control" name="saleEmailDesc1" value="${contactUs1.saleEmailDesc}">
                                        </div>
                                        <label class="col-sm-2 control-label">销售邮箱</label>
                                        <div class="col-sm-4">
                                            <input id="saleEmail1" type="text" class="form-control" name="saleEmail1" value="${contactUs1.saleEmail}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">地址名称</label>
                                        <div class="col-sm-4">
                                            <input id="addressDesc1" type="text" class="form-control" name="addressDesc1" value="${contactUs1.addressDesc}">
                                        </div>
                                        <label class="col-sm-2 control-label">地址</label>
                                        <div class="col-sm-4">
                                            <input id="address1" type="text" class="form-control" name="address1" value="${contactUs1.address}">
                                        </div>
                                    </div>
                                    <div class="ibox-title">
                                        <h5>重庆</h5>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">标题</label>
                                        <div class="col-sm-4">
                                            <input id="id2" type="hidden" name="id2" value="${contactUs2.id}">
                                            <input id="title2" type="text" class="form-control" name="title2" value="${contactUs2.title}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">热线电话名称</label>
                                        <div class="col-sm-4">
                                            <input id="hotLineDesc2" type="text" class="form-control" name="hotLineDesc2" value="${contactUs2.hotLineDesc}">
                                        </div>
                                        <label class="col-sm-2 control-label">热线电话</label>
                                        <div class="col-sm-4">
                                            <input id="hotLine2" type="text" class="form-control" name="hotLine2" value="${contactUs2.hotLine}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">热线邮箱名称</label>
                                        <div class="col-sm-4">
                                            <input id="hotEmailDesc2" type="text" class="form-control" name="hotEmailDesc2" value="${contactUs2.hotEmailDesc}">
                                        </div>
                                        <label class="col-sm-2 control-label">热线邮箱</label>
                                        <div class="col-sm-4">
                                            <input id="hotEmail2" type="text" class="form-control" name="hotEmail2" value="${contactUs2.hotEmail!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">采购邮箱名称</label>
                                        <div class="col-sm-4">
                                            <input id="purchaseEmailDesc2" type="text" class="form-control" name="purchaseEmailDesc2" value="${contactUs2.purchaseEmailDesc}">
                                        </div>
                                        <label class="col-sm-2 control-label">采购邮箱</label>
                                        <div class="col-sm-4">
                                            <input id="purchaseEmail2" type="text" class="form-control" name="purchaseEmail2" value="${contactUs2.purchaseEmail}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">销售邮箱名称</label>
                                        <div class="col-sm-4">
                                            <input id="saleEmailDesc2" type="text" class="form-control" name="saleEmailDesc2" value="${contactUs2.saleEmailDesc}">
                                        </div>
                                        <label class="col-sm-2 control-label">销售邮箱</label>
                                        <div class="col-sm-4">
                                            <input id="saleEmail2" type="text" class="form-control" name="saleEmail2" value="${contactUs2.saleEmail}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">地址名称</label>
                                        <div class="col-sm-4">
                                            <input id="addressDesc2" type="text" class="form-control" name="addressDesc2" value="${contactUs2.addressDesc}">
                                        </div>
                                        <label class="col-sm-2 control-label">地址</label>
                                        <div class="col-sm-4">
                                            <input id="address2" type="text" class="form-control" name="address2" value="${contactUs2.address}">
                                        </div>
                                    </div>
                                </form>
                                <br/>
                                <button type="button" class="btn btn-sm btn-primary" onclick="ContactUs.update()">确定提交</button>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    <#include "/templates/layout/footer.ftl">
    </div>
</div>

<#include "/templates/layout/commonjs.ftl">

<script src="/static/modular/aboutUs/contactUs/contactUs.js"></script>

<script type="text/javascript">

    $(document).ready(function(){
        $("#locales").change(function () {
            $.ajax({
                url:"/backstageApi/aboutUs/contactUs/changeLocales?locales="+$("#locales").val(),
                type: 'GET',
                contentType: "application/json",
                success:function (r) {
                    var data = r.obj;
                    $("#id1").val(data[0].id);
                    $("#title1").val(data[0].title);
                    $("#hotLineDesc1").val(data[0].hotLineDesc);
                    $("#hotLine1").val(data[0].hotLine);
                    $("#hotEmailDesc1").val(data[0].hotEmailDesc);
                    $("#hotEmail1").val(data[0].hotEmail);
                    $("#purchaseEmailDesc1").val(data[0].purchaseEmailDesc);
                    $("#purchaseEmail1").val(data[0].purchaseEmail);
                    $("#saleEmailDesc1").val(data[0].saleEmailDesc);
                    $("#saleEmail1").val(data[0].saleEmail);
                    $("#addressDesc1").val(data[0].addressDesc);
                    $("#address1").val(data[0].address);

                    $("#id2").val(data[1].id);
                    $("#title2").val(data[1].title);
                    $("#hotLineDesc2").val(data[1].hotLineDesc);
                    $("#hotLine2").val(data[1].hotLine);
                    $("#hotEmailDesc2").val(data[1].hotEmailDesc);
                    $("#hotEmail2").val(data[1].hotEmail);
                    $("#purchaseEmailDesc2").val(data[1].purchaseEmailDesc);
                    $("#purchaseEmail2").val(data[1].purchaseEmail);
                    $("#saleEmailDesc2").val(data[1].saleEmailDesc);
                    $("#saleEmail2").val(data[1].saleEmail);
                    $("#addressDesc2").val(data[1].addressDesc);
                    $("#address2").val(data[1].address);

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
