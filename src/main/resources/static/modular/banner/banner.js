var Banner = {
    table: null,
    domain: "banner"
};

/**
 * 插入
 */
Banner.update = function () {
    var imgUrl=$('#imgUrl').val();
    var previewImgUrl = $('#previewImgUrl').attr("src");
    if($.trim(imgUrl)=="" && $.trim(previewImgUrl)==""){
        info("图片必须要上传！");
        return ;
    }

    var createForm = document.getElementById("create-form");
    var formData = new FormData(createForm);
    $.ajax({
        url: "/backstageApi/banner/edit",
        type: 'POST',
        data: formData,
        async: true,
        cache: false,
        contentType: false,
        processData: false,
        success: function (r) {
            if (r.code === 0) {
                successthen("修改成功",null,"/backstageApi/banner")//"/createDemand/create");
            }
        }
    })
};

$(function() {
});