package cn.vtyc.officalWebsite.dao.front.home;


import cn.vtyc.officalWebsite.core.BaseDao;
import cn.vtyc.officalWebsite.entity.front.home.HomeGallery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HomeGalleryDao extends BaseDao<HomeGallery> {
    @Select("select * from home_gallery where locales = '${locales}'")
    List<HomeGallery> getHomeGalleryByLocales(@Param("locales")String locales);
}
