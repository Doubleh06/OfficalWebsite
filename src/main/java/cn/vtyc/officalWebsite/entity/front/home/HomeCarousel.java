package cn.vtyc.officalWebsite.entity.front.home;

import cn.vtyc.officalWebsite.entity.BaseEntity;
import lombok.Data;

@Data
public class HomeCarousel extends BaseEntity {
    private String img;
    private String uuid;
    private String imgPath;
    private String imgSourceName;

    public HomeCarousel() {
    }

    public HomeCarousel(String img, String uuid, String imgPath, String imgSourceName) {
        this.img = img;
        this.uuid = uuid;
        this.imgPath = imgPath;
        this.imgSourceName = imgSourceName;
    }
}
