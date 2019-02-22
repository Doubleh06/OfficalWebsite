package cn.vtyc.website.core;

/**
 * Created by fonlin on 2017/9/8.
 */
public enum ErrorCode {

    OK(0, "操作成功"),

    CANNOT_DELETE(1, "无法删除"),

    CANNOT_UPDATE(2, "无法更新"),

    CANNOT_UPLOAD(3, "无法上传"),

    FAIL_DELETE(5, "文件删除异常"),

    BAD_REQUEST(400, "请求有异常"),

    UNAUTHORIZED(401, "未认证"),

    USER_ALREADY_REG(400, "该用户已经注册"),

    ROLE_KEY_EXIST(400, "角色key不能重复"),

    NOT_LOGIN(401, "未登录"),

    FORBIDDEN(403, "访问被禁止"),

    NOT_FOUND(404, "找不到资源"),

    INTERNAL_SERVER_TIMEOUT(-2, "请求超时"),

    INTERNAL_SERVER_ERROR(-1, "服务器内部错误"),

    HR_INTERFACE_ERROR(-3, "访问hr接口异常"),

    IMPORTEXCEL_ERROR(-4, "导入excel失败"),

    FILE_NOT_FOUND(-5, "文件未找到"),

    FILE_UPLOAD_FAIL(-6, "上传失败"),

    FILENAME_ERROR(-7, "文件名有误"),

    FILENAME_REPEAT(-9, "文件名重复"),

    CANNOT_CREAT_UPLOADFILE(-8,"无法创建上传目录");



    int code;

    String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
