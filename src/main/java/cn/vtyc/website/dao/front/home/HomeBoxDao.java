package cn.vtyc.website.dao.front.home;


import cn.vtyc.website.core.BaseDao;
import cn.vtyc.website.entity.front.home.HomeBox;
import cn.vtyc.website.entity.front.home.HomeClient;
import cn.vtyc.website.entity.front.home.HomeIntroduce;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HomeBoxDao extends BaseDao<HomeBox> {
    @Select("select * from home_box where locales = '${locales}'")
    List<HomeBox> getHomeBoxByLocales(@Param("locales")String locales);
}
