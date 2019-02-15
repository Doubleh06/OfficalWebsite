package cn.vtyc.website.entity.front.home;

import cn.vtyc.website.entity.BaseEntity;
import lombok.Data;

@Data
public class HomeCarousel extends BaseEntity {
    private String img;
    private String uuid;
    private String imgPath;
    private String imgSourceName;

    public HomeCarousel(String img, String uuid, String imgPath, String imgSourceName) {
        this.img = img;
        this.uuid = uuid;
        this.imgPath = imgPath;
        this.imgSourceName = imgSourceName;
    }
}
