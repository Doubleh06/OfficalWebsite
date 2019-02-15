package cn.vtyc.website.dao.front.home;


import cn.vtyc.website.core.BaseDao;
import cn.vtyc.website.entity.front.home.HomeCarousel;
import cn.vtyc.website.entity.front.home.HomeClient;
import cn.vtyc.website.entity.front.home.HomeGallery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HomeClientDao extends BaseDao<HomeClient> {
    @Select("select * from home_client where locales = '${locales}'")
    List<HomeClient> getHomeClientByLocales(@Param("locales")String locales);

}
