package cn.vtyc.officalWebsite.dao.front;


import cn.vtyc.officalWebsite.core.BaseDao;
import cn.vtyc.officalWebsite.entity.front.Recruitment;
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
