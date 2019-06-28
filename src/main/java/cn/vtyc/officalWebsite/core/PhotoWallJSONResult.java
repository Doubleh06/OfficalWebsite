package cn.vtyc.officalWebsite.core;

import lombok.Data;

import java.util.List;

/**
 * Created by fonlin on 2017/9/8.
 * 可以装填对象返回的Result
 */
@Data
public class PhotoWallJSONResult {

    private List list;
    private Pagination pagination;
    private String navImg;
    private String pageHead;


    public PhotoWallJSONResult(List list, Pagination pagination, String navImg,String pageHead) {
        this.list = list;
        this.pagination = pagination;
        this.navImg = navImg;
        this.pageHead = pageHead;
    }

    public PhotoWallJSONResult(String navImg,String pageHead) {
        this.navImg = navImg;
        this.pageHead = pageHead;
    }
}
