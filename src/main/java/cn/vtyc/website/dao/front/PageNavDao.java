package cn.vtyc.website.dao.front;


import cn.vtyc.website.core.BaseDao;
import cn.vtyc.website.entity.front.Faq;
import cn.vtyc.website.entity.front.PageNav;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface PageNavDao extends BaseDao<PageNav> {
    @Select("select img,page_head from page_nav where page_name = '${pageName}' and locales = '${locales}'")
    PageNav getImgByPageName(@Param("pageName")String pageName,@Param("locales")String locales);
}
