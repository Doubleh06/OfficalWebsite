package cn.vtyc.officalWebsite.dao.front;


import cn.vtyc.officalWebsite.core.BaseDao;
import cn.vtyc.officalWebsite.entity.front.PageNav;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PageNavDao extends BaseDao<PageNav> {
    @Select("select img,page_head from page_nav where page_name = '${pageName}' and locales = '${locales}'")
    PageNav getImgByPageName(@Param("pageName")String pageName,@Param("locales")String locales);

    @Update("update page_nav set img = '${img}' where page_name = '${pageName}'")
    void updateImgByPageName(@Param("img")String img , @Param("pageName")String pageName);

    @Select("select * from page_nav where locales = 'zh-CN'")
    List<PageNav> getAllByLocales();

}
