package cn.vtyc.officalWebsite.entity.front.home;

import cn.vtyc.officalWebsite.entity.BaseEntity;
import lombok.Data;

@Data
public class HomeClient extends BaseEntity {
    private String h3;
    private String span;
    private String p;
    private String locales;

    public HomeClient() {
    }

    public HomeClient(String h3, String span, String p, String locales) {
        this.h3 = h3;
        this.span = span;
        this.p = p;
        this.locales = locales;
    }
}
