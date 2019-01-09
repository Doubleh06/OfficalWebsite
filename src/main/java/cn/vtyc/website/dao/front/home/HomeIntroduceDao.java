package cn.vtyc.website.dao.front.home;


import cn.vtyc.website.core.BaseDao;
import cn.vtyc.website.entity.front.CompanyIntroduce;
import cn.vtyc.website.entity.front.home.HomeGallery;
import cn.vtyc.website.entity.front.home.HomeIntroduce;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HomeIntroduceDao extends BaseDao<HomeIntroduce> {
    @Select("select * from home_introduce where locales = '${locales}'")
    List<HomeIntroduce> getHomeIntroduceByLocales(@Param("locales")String locales);
}
