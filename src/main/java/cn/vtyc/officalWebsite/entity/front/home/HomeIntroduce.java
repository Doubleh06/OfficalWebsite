package cn.vtyc.officalWebsite.entity.front.home;

import cn.vtyc.officalWebsite.entity.BaseEntity;
import lombok.Data;

@Data
public class HomeIntroduce extends BaseEntity {
    private String img;
    private String h2;
    private String h4;
    private String locales;

    public HomeIntroduce(Integer id, String h2, String h4) {
        super(id);
        this.h2 = h2;
        this.h4 = h4;
    }

    public HomeIntroduce() {
    }
}
