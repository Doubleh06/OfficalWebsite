package cn.vtyc.website.dao.front;


import cn.vtyc.website.core.BaseDao;
import cn.vtyc.website.entity.front.ContactUs;
import cn.vtyc.website.entity.front.Endorsement;
import cn.vtyc.website.entity.front.Faq;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EndorsementDao extends BaseDao<Endorsement> {
    @Select("select * from endorsement where locales = '${locales}'")
    List<Endorsement> getEndorsementByLocales(@Param("locales")String locales);
}
