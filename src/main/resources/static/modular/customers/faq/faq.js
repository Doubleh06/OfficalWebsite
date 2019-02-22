var Faq = {
    table: null,
    domain: "faq"
};

/**
 * 插入
 */
Faq.update = function () {
    var imgUrl=$('#imgUrl').val();
    var previewImgUrl = $('#previewImgUrl').attr("src");
    if($.trim(imgUrl)=="" && $.trim(previewImgUrl)==""){
        info("图片必须要上传！");
        return ;
    }

    var createForm = document.getElementById("create-form");
    var formData = new FormData(createForm);
    $.ajax({
        url: "/backstageApi/career/faq/update",
        type: 'POST',
        data: formData,
        async: true,
        cache: false,
        contentType: false,
        processData: false,
        success: function (r) {
            if (r.code === 0) {
                successthen("修改成功",null,"/backstageApi/career/faq")//"/createDemand/create");
            }
        }
    })
};

$(function() {
});