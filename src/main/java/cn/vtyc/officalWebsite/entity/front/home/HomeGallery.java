package cn.vtyc.officalWebsite.entity.front.home;

import cn.vtyc.officalWebsite.entity.BaseEntity;
import lombok.Data;

@Data
public class HomeGallery extends BaseEntity {
    private String img;
    private String h3;
    private String h4;
    private String a;
    private String label;
    private String locales;

    public HomeGallery() {
    }

    public HomeGallery(Integer id, String h3, String h4, String label) {
        super(id);
        this.h3 = h3;
        this.h4 = h4;
        this.label = label;
    }
}
