package cn.vtyc.website.entity.front.home;

import cn.vtyc.website.entity.BaseEntity;
import lombok.Data;

@Data
public class HomeBox extends BaseEntity {
    private String a;
    private String icon;
    private String h2;
    private String h3;
    private String locales;

    public HomeBox() {
    }

    public HomeBox(Integer id, String h2, String h3) {
        super(id);
        this.h2 = h2;
        this.h3 = h3;
    }
}
