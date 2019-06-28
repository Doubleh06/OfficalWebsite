package cn.vtyc.officalWebsite.core;

import lombok.Data;

@Data
public class Pagination {
    private Integer currentPage;
    private Integer PageSize;
    private Integer total;

    public Pagination(Integer currentPage, Integer pageSize, Integer total) {
        this.currentPage = currentPage;
        PageSize = pageSize;
        this.total = total;
    }
}
