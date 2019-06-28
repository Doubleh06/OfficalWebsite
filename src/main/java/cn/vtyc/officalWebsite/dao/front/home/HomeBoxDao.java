package cn.vtyc.officalWebsite.dao.front.home;


import cn.vtyc.officalWebsite.core.BaseDao;
import cn.vtyc.officalWebsite.entity.front.home.HomeBox;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HomeBoxDao extends BaseDao<HomeBox> {
    @Select("select * from home_box where locales = '${locales}'")
    List<HomeBox> getHomeBoxByLocales(@Param("locales")String locales);
}
