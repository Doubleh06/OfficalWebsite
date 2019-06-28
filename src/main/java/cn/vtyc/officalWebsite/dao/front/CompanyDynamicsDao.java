package cn.vtyc.officalWebsite.dao.front;


import cn.vtyc.officalWebsite.core.BaseDao;
import cn.vtyc.officalWebsite.entity.front.CompanyDynamics;
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

    @Select("select * from company_dynamics ${sql}")
    List<CompanyDynamics> selectCompanyDynamicsList(@Param("sql") String sql);

}
