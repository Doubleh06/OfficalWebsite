package cn.vtyc.website.entity.front.home;

import cn.vtyc.website.entity.BaseEntity;
import lombok.Data;

@Data
public class HomeIntroduce extends BaseEntity {
    private String img;
    private String h2;
    private String h4;
    private String locales;
}
