package cn.vtyc.officalWebsite.core;

import lombok.Data;

import java.util.List;

/**
 * Created by fonlin on 2017/9/8.
 * 可以装填对象返回的Result
 */
@Data
public class CompanyDynamicsJSONResult {

    private List list;
    private String navImg;
    private String pageHead;
    private Pagination pagination;

    public CompanyDynamicsJSONResult(List list, String navImg, String pageHead, Pagination pagination) {
        this.list = list;
        this.navImg = navImg;
        this.pageHead = pageHead;
        this.pagination = pagination;
    }
}
