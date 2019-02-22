var Box = {
    table: null,
    domain: "box"
};

/**
 * 插入
 */
Box.update = function () {


    var createForm = document.getElementById("create-form");
    var formData = new FormData(createForm);
    $.ajax({
        url: "/backstageApi/home/box/update",
        type: 'POST',
        data: formData,
        async: true,
        cache: false,
        contentType: false,
        processData: false,
        success: function (r) {
            if (r.code === 0) {
                successthen("修改成功",null,"/backstageApi/home/box")//"/createDemand/create");
            }
        }
    })
};

$(function() {
});