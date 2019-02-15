var Client = {
    table: null,
    domain: "client"
};

/**
 * 插入
 */
Client.update = function () {
    var form = $("#create-form");
    var formData = getFormJson(form);

    $.ajax({
        url: "/backstageApi/home/client/update",
        type: 'POST',
        data: JSON.stringify(formData),
        async: true,
        cache: false,
        contentType: "application/json",
        success: function (r) {
            if (r.code === 0) {
                successthen("修改成功",null,"/backstageApi/home/client")//"/createDemand/create");
            }
        },
        error: function () {
            info('服务错误请刷新后重新提交！');
        }
    })
};

$(function() {
});