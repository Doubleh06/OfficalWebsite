package cn.vtyc.website.dao.front;


import cn.vtyc.website.core.BaseDao;
import cn.vtyc.website.entity.front.ContactUs;
import cn.vtyc.website.entity.front.Faq;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FaqDao extends BaseDao<Faq> {
    @Select("select * from faq where locales = '${locales}'")
    List<Faq> getFaqByLocales(@Param("locales")String locales);
}
