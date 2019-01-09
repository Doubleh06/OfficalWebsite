package cn.vtyc.website.entity.front.home;

import cn.vtyc.website.entity.BaseEntity;
import lombok.Data;

@Data
public class HomeClient extends BaseEntity {
    private String h3;
    private String span;
    private String p;
    private String locales;
}
