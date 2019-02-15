package cn.vtyc.website.entity.front;


import cn.vtyc.website.entity.BaseEntity;
import lombok.Data;

/**
 * 菜单资源类（菜单及页面上的按钮链接等资源）
 *
 * @author fonlin
 * @date 2018/4/19
 */
@Data
public class PageNav extends BaseEntity {
    private String pageName;
    private String img;
    private String pageHead;
    private String locales;

    public PageNav() {
    }

    public PageNav(String pageName, String img) {
        this.pageName = pageName;
        this.img = img;
    }
}
