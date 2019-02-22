var Questionnaire = {
    tableId: "#grid-table",
    pagerId: "#grid-pager",
    table: null,
    domain: "questionnaire"
};

/**
 * jqGrid初始化参数
 */
Questionnaire.initOptions = function () {
    var options = {
        url : "/backstageApi/customers/questionnaire/grid",
        autowidth:true,
        colNames: ['编号','问卷名称','操作'],
        colModel: [
            {name: 'id', index: 'id', width: 20},
            {name: 'name', index: 'name', width: 80},
            {name: 'operations', index: 'operations', width:50 , sortable: false, formatter: function (cellValue, options, rowObject) {
                    var id = "'"+rowObject["id"]+"'";
                    var str = "";
                    // str += '<input type="button" class="btn btn-sm btn-primary"   value="上  传" onclick="Questionnaire.preEdit(' + id +')"/>&nbsp;';
                    str += '<input type="button" class="btn btn-sm btn-danger"   value="删  除" onclick="Questionnaire.delete(' + id +')"/>&nbsp;';

                    return str;
                }}
        ]
        // ,
        // gridComplete: function () {
        //     refreshPermission(Questionnaire.domain);
        // }
    };
    return options;
};

/**
 * 根据关键词搜索
 */
Questionnaire.search = function () {
    var searchParam = {};
    searchParam.name = $("#name").val();
    searchParam.locales = $("#locales").val();
    Questionnaire.table.reload(searchParam);
};

/**
 * 重置搜索
 */
Questionnaire.resetSearch = function () {
    $("#title").val("");
    $("#locales").empty();
    $("#locales").append("<option value=\"zh-CN\" >中文</option> <option value=\"zh-TW\" >繁体</option> <option value=\"en-US\">English</option>");
    Questionnaire.search();
};

/**
 * 保存用户
 */
Questionnaire.insert = function () {
    var questionnaire = getFormJson($("#create-form"));
    $.ajax({
        url: "/backstageApi/customers/questionnaire/insert",
        type: 'POST',
        data: JSON.stringify(questionnaire),
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function (r) {
            if (r.code === 0) {
                $("#createModal").modal("hide");
                success("保存成功");
                Questionnaire.search();
                $("#create-form")[0].reset();
            }
        }
    })
};

/**
 * 删除
 *
 * @param id    userId
 */
Questionnaire.delete = function (id) {
    warning("确定删除吗", "", function () {
        $.get("/backstageApi/customers/questionnaire/delete?id=" + id, function () {
            success("成功删除");
            Questionnaire.search();
        });
    })
};


/**
 * 新增
 */
Questionnaire.create = function(){
    $("#createModal").modal();
}



$(function() {
    var jqGrid = new JqGrid("#grid-table", "#grid-pager", Questionnaire.initOptions());
    Questionnaire.table = jqGrid.init();

});