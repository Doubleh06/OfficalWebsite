var CompanyIntroduce = {
    table: null,
    domain: "companyIntroduce"
};

/**
 * 插入
 */
CompanyIntroduce.update = function () {

    var createForm = document.getElementById("create-form");
    var formData = new FormData(createForm);
    $.ajax({
        url: "/backstageApi/aboutUs/companyIntroduce/update",
        type: 'POST',
        data: formData,
        async: true,
        cache: false,
        contentType: false,
        processData: false,
        success: function (r) {
            if (r.code === 0) {
                successthen("修改成功",null,"/backstageApi/aboutUs/companyIntroduce")//"/createDemand/create");
            }
        }
    })
};

$(function() {
});