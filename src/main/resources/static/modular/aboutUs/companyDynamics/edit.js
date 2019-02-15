var CompanyDynamicsEdit = {
    table: null,
    domain: "companyDynamicsEdit"
};

/**
 * 插入
 */
CompanyDynamicsEdit.update = function () {

    var createForm = document.getElementById("create-form");
    var formData = new FormData(createForm);
    $.ajax({
        url: "/backstageApi/aboutUs/companyDynamics/edit",
        type: 'POST',
        data: formData,
        async: true,
        cache: false,
        contentType: false,
        processData: false,
        success: function (r) {
            if (r.code === 0) {
                successthen("修改成功",null,"/backstageApi/aboutUs/companyDynamics")//"/createDemand/create");
            }
        }
    })
};

$(function() {
});