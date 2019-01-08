package cn.vtyc.website.entity.front;


import cn.vtyc.website.entity.BaseEntity;
import cn.vtyc.website.entity.front.home.*;
import lombok.Data;

import java.util.List;

/**
 * 菜单资源类（菜单及页面上的按钮链接等资源）
 *
 * @author fonlin
 * @date 2018/4/19
 */
@Data
public class Home extends BaseEntity {
    private List<HomeCarousel> homeCarousel;
    private List<HomeBox> HomeBox;
    private List<HomeClient> homeClient;
    private List<HomeGallery> homeGallery ;
    private HomeIntroduce homeIntroduce;

}
