var Carousel = {
    table: null,
    domain: "carousel"
};

/**
 * 插入
 */
Carousel.insert = function () {
    var form = $("#create-form");
    var formData = getFormJson(form);

    $.ajax({
        url: "/backstageApi/home/insert",
        type: 'POST',
        data: JSON.stringify(formData),
        async: true,
        cache: false,
        contentType: "application/json",
        success: function (r) {
            if (r.code === 0) {
                successthen("上传成功",null,"/backstageApi/home/carousel")//"/createDemand/create");
            }
        },
        error: function () {
            info('服务错误请刷新后重新提交！');
        }
    })
};

$(function() {
});