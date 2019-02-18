var Recruitment = {
    table: null,
    domain: "recruitment"
};

/**
 * 插入
 */
Recruitment.update = function () {

    var createForm = document.getElementById("create-form");
    var formData = new FormData(createForm);
    $.ajax({
        url: "/backstageApi/career/recruitment/edit",
        type: 'POST',
        data: formData,
        async: true,
        cache: false,
        contentType: false,
        processData: false,
        success: function (r) {
            if (r.code === 0) {
                successthen("修改成功",null,"/backstageApi/career/recruitment")//"/createDemand/create");
            }
        }
    })
};
// Recruitment.updateImg = function () {
//
//     var createForm = document.getElementById("create-form");
//     var formData = new FormData(createForm);
//     $.ajax({
//         url: "/backstageApi/career/recruitment/editImg",
//         type: 'POST',
//         data: formData,
//         async: true,
//         cache: false,
//         contentType: false,
//         processData: false,
//         success: function (r) {
//             if (r.code === 0) {
//                 successthen("修改成功",null,"/backstageApi/career/recruitment")//"/createDemand/create");
//             }
//         }
//     })
// };
$(function() {
});