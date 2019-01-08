package cn.vtyc.website.dao.front;


import cn.vtyc.website.core.BaseDao;
import cn.vtyc.website.entity.front.CompanyIntroduce;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CompanyIntroduceDao extends BaseDao<CompanyIntroduce> {
    @Select("select * from company_introduce where locales = '${locales}'")
    List<CompanyIntroduce> getCompanyIntroduceByLocales(@Param("locales")String locales);
}
