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
                                                <#if (recruitmentDetail.locales)??>
                                                    <option value="zh-CN" <#if recruitmentDetail.locales == "zh-CN">selected</#if> >中文</option>
                                                    <option value="zh-TW" <#if recruitmentDetail.locales == "zh-TW">selected</#if>>繁体中文</option>
                                                    <option value="en-US" <#if recruitmentDetail.locales == "en-US">selected</#if>>English</option>
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
                                            <input id="groupId" name="groupId" type="text" class="form-control"  value="${recruitmentDetail.groupId!}">
                                        </div>
                                    </div>
                                    <#--<div class="ibox-title">-->
                                        <#--<h5</h5>-->
                                    <#--</div>-->
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">职位类型名称</label>
                                        <div class="col-sm-4">
                                            <input id="id" type="hidden" name="id" value="${recruitmentDetail.id!}">
                                            <input id="recruitmentId" type="hidden" name="id" value="${recruitmentDetail.recruitmentId!}">
                                            <input id="workTypeDesc" name="workTypeDesc" type="text" class="form-control"  value="${recruitmentDetail.workTypeDesc!}">
                                        </div>
                                        <label class="col-sm-2 control-label">职位类型</label>
                                        <div class="col-sm-4">
                                            <input id="workType" name="workType" type="text" class="form-control"  value="${recruitmentDetail.workType!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">职位名称名称</label>
                                        <div class="col-sm-4">
                                            <input id="workTitleDesc" name="workTitleDesc" type="text" class="form-control"  value="${recruitmentDetail.workTitleDesc!}">
                                        </div>
                                        <label class="col-sm-2 control-label">职位名称</label>
                                        <div class="col-sm-4">
                                            <input id="workTitle" name="workTitle" type="text" class="form-control"  value="${recruitmentDetail.workTitle!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">招收人数名称</label>
                                        <div class="col-sm-4">
                                            <input id="recruitNumDesc" name="recruitNumDesc" type="text" class="form-control"  value="${recruitmentDetail.recruitNumDesc!}">
                                        </div>
                                        <label class="col-sm-2 control-label">招收人数</label>
                                        <div class="col-sm-4">
                                            <input id="recruitNum" name="recruitNum" type="text" class="form-control"  value="${recruitmentDetail.recruitNum!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">性别名称</label>
                                        <div class="col-sm-4">
                                            <input id="sexDesc" name="sexDesc" type="text" class="form-control"  value="${recruitmentDetail.sexDesc!}">
                                        </div>
                                        <label class="col-sm-2 control-label">性别</label>
                                        <div class="col-sm-4">
                                            <input id="sex" name="sex" type="text" class="form-control"  value="${recruitmentDetail.sex!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">工作性质名称</label>
                                        <div class="col-sm-4">
                                            <input id="workNatureDesc" name="workNatureDesc" type="text" class="form-control"  value="${recruitmentDetail.workNatureDesc!}">
                                        </div>
                                        <label class="col-sm-2 control-label">工作性质</label>
                                        <div class="col-sm-4">
                                            <input id="workNature" name="workNature" type="text" class="form-control"  value="${recruitmentDetail.workNature!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">工作性质名称</label>
                                        <div class="col-sm-4">
                                            <input id="workNatureDesc" name="workNatureDesc" type="text" class="form-control"  value="${recruitmentDetail.workNatureDesc!}">
                                        </div>
                                        <label class="col-sm-2 control-label">工作性质</label>
                                        <div class="col-sm-4">
                                            <input id="workNature" name="workNature" type="text" class="form-control"  value="${recruitmentDetail.workNature!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">薪水范围名称</label>
                                        <div class="col-sm-4">
                                            <input id="salaryDesc" name="salaryDesc" type="text" class="form-control"  value="${recruitmentDetail.salaryDesc!}">
                                        </div>
                                        <label class="col-sm-2 control-label">薪水范围</label>
                                        <div class="col-sm-4">
                                            <input id="salary" name="salary" type="text" class="form-control"  value="${recruitmentDetail.salary!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">学历要求名称</label>
                                        <div class="col-sm-4">
                                            <input id="educationRequiredDesc" name="educationRequiredDesc" type="text" class="form-control"  value="${recruitmentDetail.educationRequiredDesc!}">
                                        </div>
                                        <label class="col-sm-2 control-label">学历要求</label>
                                        <div class="col-sm-4">
                                            <input id="educationRequired" name="educationRequired" type="text" class="form-control"  value="${recruitmentDetail.educationRequired!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">工作地区名称</label>
                                        <div class="col-sm-4">
                                            <input id="workDistinctDesc" name="workDistinctDesc" type="text" class="form-control"  value="${recruitmentDetail.workDistinctDesc!}">
                                        </div>
                                        <label class="col-sm-2 control-label">工作地区</label>
                                        <div class="col-sm-4">
                                            <input id="workDistinct" name="workDistinct" type="text" class="form-control"  value="${recruitmentDetail.workDistinct!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">接受语言名称</label>
                                        <div class="col-sm-4">
                                            <input id="languageDesc" name="languageDesc" type="text" class="form-control"  value="${recruitmentDetail.languageDesc!}">
                                        </div>
                                        <label class="col-sm-2 control-label">接受语言</label>
                                        <div class="col-sm-4">
                                            <input id="language" name="language" type="text" class="form-control"  value="${recruitmentDetail.language!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">工作部门名称</label>
                                        <div class="col-sm-4">
                                            <input id="departmentDesc" name="departmentDesc" type="text" class="form-control"  value="${recruitmentDetail.departmentDesc!}">
                                        </div>
                                        <label class="col-sm-2 control-label">工作部门</label>
                                        <div class="col-sm-4">
                                            <input id="department" name="department" type="text" class="form-control"  value="${recruitmentDetail.department!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">工作年限名称</label>
                                        <div class="col-sm-4">
                                            <input id="workLifeDesc" name="workLifeDesc" type="text" class="form-control"  value="${recruitmentDetail.workLifeDesc!}">
                                        </div>
                                        <label class="col-sm-2 control-label">工作年限</label>
                                        <div class="col-sm-4">
                                            <input id="workLife" name="workLife" type="text" class="form-control"  value="${recruitmentDetail.workLife!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">年龄要求名称</label>
                                        <div class="col-sm-4">
                                            <input id="ageRequiredDesc" name="ageRequiredDesc" type="text" class="form-control"  value="${recruitmentDetail.ageRequiredDesc!}">
                                        </div>
                                        <label class="col-sm-2 control-label">年龄要求</label>
                                        <div class="col-sm-4">
                                            <input id="ageRequired" name="ageRequired" type="text" class="form-control"  value="${recruitmentDetail.ageRequired!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">发布日期名称</label>
                                        <div class="col-sm-4">
                                            <input id="releaseTimeDesc" name="releaseTimeDesc" type="text" class="form-control"  value="${recruitmentDetail.releaseTimeDesc!}">
                                        </div>
                                        <label class="col-sm-2 control-label">发布日期</label>
                                        <div class="col-sm-4">
                                            <div class="input-group date">
                                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input id="releaseTime" name="releaseTime" type="text" class="form-control" value="${recruitmentDetail.releaseTime!}">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">截止日期名称</label>
                                        <div class="col-sm-4">
                                            <input id="endTimeDesc" name="endTimeDesc" type="text" class="form-control"  value="${recruitmentDetail.endTimeDesc!}">
                                        </div>
                                        <label class="col-sm-2 control-label">截止日期</label>
                                        <div class="col-sm-4">
                                            <div class="input-group date">
                                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input id="endTime" name="endTime" type="text" class="form-control" value="${recruitmentDetail.endTime!}">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">职位描述名称</label>
                                        <div class="col-sm-4">
                                            <input id="positionDesc" name="positionDesc" type="text" class="form-control"  value="${recruitmentDetail.positionDesc!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">职位描述</label>
                                        <div class="col-sm-10">
                                            <#--<input id="position" name="position" type="text" class="form-control"  value="${recruitmentDetail.position!}">-->
                                        <textarea id="position" name="position"  style="width: 100%;height: 100px">${recruitmentDetail.position!}</textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">能力要求名称</label>
                                        <div class="col-sm-4">
                                            <input id="abilityDesc" name="abilityDesc" type="text" class="form-control"  value="${recruitmentDetail.abilityDesc!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">能力要求</label>
                                        <div class="col-sm-10">
                                            <textarea id="ability" name="ability"  style="width: 100%;height: 100px">${recruitmentDetail.ability!}</textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">能力要求名称</label>
                                        <div class="col-sm-4">
                                            <input id="otherDesc" name="otherDesc" type="text" class="form-control"  value="${recruitmentDetail.otherDesc!}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">能力要求</label>
                                        <div class="col-sm-10">
                                            <textarea id="other" name="other"  style="width: 100%;height: 100px">${recruitmentDetail.other!}</textarea>
                                        </div>
                                    </div>

                                </form>
                                <br/>
                                <button type="button" class="btn btn-sm btn-primary" onclick="Recruitment.update()">确定提交</button>
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
<script src="/static/modular/career/recruitment/edit.js"></script>

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
        $('#endTime').datepicker({
            todayBtn: "linked",
            keyboardNavigation: false,
            forceParse: false,
            calendarWeeks: true,
            autoclose: true,
            format: "yyyy-mm-dd"
        });
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
