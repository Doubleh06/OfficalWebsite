package cn.vtyc.website.dao.front;


import cn.vtyc.website.core.BaseDao;
import cn.vtyc.website.entity.front.CompanyDynamics;
import cn.vtyc.website.entity.front.Faq;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CompanyDynamicsDao extends BaseDao<CompanyDynamics> {
    @Select("select * from company_dynamics where locales = '${locales}' limit ${currentPage} , ${pageSize}")
    List<CompanyDynamics> getCompanyDynamicsByLocales(@Param("locales") String locales,@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    @Select("select count(*) from company_dynamics where locales = '${locales}'")
    Integer getCompanyDynamicsTotalByLocales(@Param("locales") String locales);

}
