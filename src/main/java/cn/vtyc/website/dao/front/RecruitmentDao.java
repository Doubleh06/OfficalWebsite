package cn.vtyc.website.dao.front;


import cn.vtyc.website.core.BaseDao;
import cn.vtyc.website.entity.front.CompanyDynamics;
import cn.vtyc.website.entity.front.Faq;
import cn.vtyc.website.entity.front.Recruitment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecruitmentDao extends BaseDao<Recruitment> {
    @Select("select * from recruitment where locales = '${locales}'")
    List<Recruitment> getRecruitmentByLocales(@Param("locales")String locales);

    @Select("select * from recruitment ${sql}")
    List<Recruitment> selectRecruitmentList(@Param("sql") String sql);
}
