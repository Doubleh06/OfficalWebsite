package cn.vtyc.officalWebsite.dao.front.home;


import cn.vtyc.officalWebsite.core.BaseDao;
import cn.vtyc.officalWebsite.entity.front.home.HomeIntroduce;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HomeIntroduceDao extends BaseDao<HomeIntroduce> {
    @Select("select * from home_introduce where locales = '${locales}'")
    List<HomeIntroduce> getHomeIntroduceByLocales(@Param("locales")String locales);
}
