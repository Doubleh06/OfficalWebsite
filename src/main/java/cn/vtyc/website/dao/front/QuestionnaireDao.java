package cn.vtyc.website.dao.front;


import cn.vtyc.website.core.BaseDao;
import cn.vtyc.website.entity.front.CompanyDynamics;
import cn.vtyc.website.entity.front.Faq;
import cn.vtyc.website.entity.front.Questionnaire;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface QuestionnaireDao extends BaseDao<Questionnaire> {
    @Select("select * from questionnaire where locales = '${locales}'")
    List<Questionnaire> getQuestionnaireByLocales(@Param("locales")String locales);

    @Select("select * from questionnaire ${sql}")
    List<Questionnaire> selectCompanyDynamicsList(@Param("sql") String sql);
}
