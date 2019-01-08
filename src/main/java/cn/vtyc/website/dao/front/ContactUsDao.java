package cn.vtyc.website.dao.front;


import cn.vtyc.website.core.BaseDao;
import cn.vtyc.website.entity.front.CompanyIntroduce;
import cn.vtyc.website.entity.front.ContactUs;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ContactUsDao extends BaseDao<ContactUs> {
    @Select("select * from contact_us where locales = '${locales}'")
    List<ContactUs> getContactUsByLocales(@Param("locales")String locales);
}
