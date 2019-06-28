package cn.vtyc.officalWebsite.dao.front.home;


import cn.vtyc.officalWebsite.core.BaseDao;
import cn.vtyc.officalWebsite.entity.front.home.HomeClient;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HomeClientDao extends BaseDao<HomeClient> {
    @Select("select * from home_client where locales = '${locales}'")
    List<HomeClient> getHomeClientByLocales(@Param("locales")String locales);

}
