package cn.vtyc.officalWebsite.dao.front;


import cn.vtyc.officalWebsite.core.BaseDao;
import cn.vtyc.officalWebsite.entity.front.Endorsement;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EndorsementDao extends BaseDao<Endorsement> {
    @Select("select * from endorsement where locales = '${locales}'")
    List<Endorsement> getEndorsementByLocales(@Param("locales")String locales);
}
