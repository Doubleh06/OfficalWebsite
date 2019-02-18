var Recruitment = {
    tableId: "#grid-table",
    pagerId: "#grid-pager",
    table: null,
    domain: "recruitment"
};

/**
 * jqGrid初始化参数
 */
Recruitment.initOptions = function () {
    var options = {
        url : "/backstageApi/career/recruitment/grid",
        autowidth:true,
        colNames: ['编号','职位名称','工作年限','招聘人数','工作地区','发布事件', '工作性质','组id','操作'],
        colModel: [
            {name: 'id', index: 'id', width: 20},
            {name: 'jobTitle', index: 'jobTitle', width: 80},
            {name: 'workLife', index: 'workLife', width: 50},
            {name: 'recruitNum', index: 'recruitNum', width: 50},
            {name: 'workDistinct', index: 'workDistinct', width: 50},
            {name: 'releaseTime', index: 'releaseTime', width: 50,formatter: function (cellvar, options, rowObject) {
                    if (cellvar == "" || cellvar == undefined) {
                        return "";
                    }
                    var da = new Date(cellvar);
                    return dateFtt("yyyy-MM-dd hh:mm:ss", da);
                }},
            {name: 'workNature', index: 'workNature', width: 50},
            {name: 'groupId', index: 'groupId', width: 50},
            {name: 'operations', index: 'operations', width:50 , sortable: false, formatter: function (cellValue, options, rowObject) {
                    var id = "'"+rowObject["id"]+"'";
                    var str = "";
                    str += '<input type="button" class="btn btn-sm btn-primary"   value="编  辑" onclick="Recruitment.preEdit(' + id +')"/>&nbsp;';
                    str += '<input type="button" class="btn btn-sm btn-warning"   value="详  细" onclick="Recruitment.detail(' + id +')"/>&nbsp;';
                    str += '<input type="button" class="btn btn-sm btn-danger"   value="删  除" onclick="Recruitment.delete(' + id +')"/>&nbsp;';

                    return str;
                }}
        ]
        // ,
        // gridComplete: function () {
        //     refreshPermission(Recruitment.domain);
        // }
    };
    return options;
};

/**
 * 根据关键词搜索
 */
Recruitment.search = function () {
    var searchParam = {};
    searchParam.jobTitle = $("#jobTitle").val();
    searchParam.locales = $("#locales").val();
    Recruitment.table.reload(searchParam);
};

/**
 * 重置搜索
 */
Recruitment.resetSearch = function () {
    $("#title").val("");
    $("#locales").empty();
    $("#locales").append("<option value=\"zh-CN\" >中文</option> <option value=\"zh-TW\" >繁体</option> <option value=\"en-US\">English</option>");
    Recruitment.search();
};



/**
 * 删除
 *
 * @param id    userId
 */
Recruitment.delete = function del(id) {
    warning("确定删除吗", "", function () {
        $.get("/backstageApi/career/recruitment/delete?id=" + id, function () {
            success("成功删除");
            Recruitment.search();
        });
    })
};

/**
 * 编辑跳转
 *
 * @param id    userId
 */
Recruitment.preEdit = function (id) {
    window.location.href = "/backstageApi/career/recruitment/mainPreEdit?id=" + id;
};
/**
 * 详细跳转
 *
 * @param id    userId
 */
Recruitment.detail = function (id) {
    window.location.href = "/backstageApi/career/recruitment/detail?id=" + id;
};
/**
 * 新增
 */
Recruitment.create = function(){
    window.location.href = "/backstageApi/career/recruitment/mainPreEdit?id=";
}


function dateFtt(fmt,date) { //author: meizz
    var o = {
        "M+" : date.getMonth()+1,                 //月份
        "d+" : date.getDate(),                    //日
        "h+" : date.getHours(),                   //小时
        "m+" : date.getMinutes(),                 //分
        "s+" : date.getSeconds(),                 //秒
        "q+" : Math.floor((date.getMonth()+3)/3), //季度
        "S"  : date.getMilliseconds()             //毫秒
    };
    if(/(y+)/.test(fmt))
        fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
        if(new RegExp("("+ k +")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    return fmt;
}

$(function() {
    var jqGrid = new JqGrid("#grid-table", "#grid-pager", Recruitment.initOptions());
    Recruitment.table = jqGrid.init();

});