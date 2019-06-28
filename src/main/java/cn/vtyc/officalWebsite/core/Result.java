package cn.vtyc.officalWebsite.core;

/**
 * Created by fonlin on 2017/9/8.
 * Result顶层
 */
public class Result {

    private int code;

    private String msg;

    private String navImg;

    private Integer total;

    private String pageHead;

    public Result() {
        this(ErrorCode.OK);
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(ErrorCode httpCode) {
        this.code = httpCode.code();
        this.msg = httpCode.message();
    }

    public Result(String navImg,String pageHead,ErrorCode httpCode) {
        this.code = httpCode.code();
        this.msg = httpCode.message();
        this.navImg = navImg;
        this.pageHead = pageHead;
    }
    public Result(String navImg,Integer total,ErrorCode httpCode) {
        this.code = httpCode.code();
        this.msg = httpCode.message();
        this.navImg = navImg;
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNavImg() {
        return navImg;
    }

    public void setNavImg(String navImg) {
        this.navImg = navImg;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getPageHead() {
        return pageHead;
    }

    public void setPageHead(String pageHead) {
        this.pageHead = pageHead;
    }
}
