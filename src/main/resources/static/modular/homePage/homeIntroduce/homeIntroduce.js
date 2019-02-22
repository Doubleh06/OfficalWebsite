var HomeIntroduce = {
    table: null,
    domain: "gallery"
};

/**
 * 插入
 */
HomeIntroduce.update = function () {


    var createForm = document.getElementById("create-form");
    var formData = new FormData(createForm);
    $.ajax({
        url: "/backstageApi/home/homeIntroduce/update",
        type: 'POST',
        data: formData,
        async: true,
        cache: false,
        contentType: false,
        processData: false,
        success: function (r) {
            if (r.code === 0) {
                successthen("修改成功",null,"/backstageApi/home/homeIntroduce")//"/createDemand/create");
            }
        }
    })
};

$(function() {
});