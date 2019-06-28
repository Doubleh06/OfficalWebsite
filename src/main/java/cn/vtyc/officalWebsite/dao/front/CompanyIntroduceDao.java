package cn.vtyc.officalWebsite.dao.front;


import cn.vtyc.officalWebsite.core.BaseDao;
import cn.vtyc.officalWebsite.entity.front.CompanyIntroduce;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface CompanyIntroduceDao extends BaseDao<CompanyIntroduce> {
    @Select("select * from company_introduce where locales = '${locales}'")
    CompanyIntroduce getCompanyIntroduceByLocales(@Param("locales")String locales);
}
