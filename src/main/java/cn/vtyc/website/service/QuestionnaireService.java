package cn.vtyc.website.service;


import cn.vtyc.website.core.AbstractService;
import cn.vtyc.website.core.BaseDao;
import cn.vtyc.website.core.jqGrid.JqGridParam;
import cn.vtyc.website.dao.front.CompanyDynamicsDao;
import cn.vtyc.website.dao.front.QuestionnaireDao;
import cn.vtyc.website.dto.CompanyDynamicsJqGridParam;
import cn.vtyc.website.dto.QuestionnaireJqGridParam;
import cn.vtyc.website.entity.front.CompanyDynamics;
import cn.vtyc.website.entity.front.Questionnaire;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionnaireService extends AbstractService<Questionnaire> {

    @Resource
    private QuestionnaireDao questionnaireDao;



    @Override
    protected BaseDao<Questionnaire> getDao() {
        return questionnaireDao;
    }

    @Override
    protected List<Questionnaire> selectByJqGridParam(JqGridParam jqGridParam) {
        CompanyDynamicsJqGridParam param = (CompanyDynamicsJqGridParam) jqGridParam;
        StringBuilder sql = new StringBuilder();
        sql.append("1=1 ");
        if (StringUtils.isNotEmpty(param.getSidx())) {
            sql.append("order by ").append(param.getSidx()).append(" ").append(param.getSord()).append("");
        }
        return questionnaireDao.selectBySql("questionnaire",sql.toString());
    }


    public PageInfo<Questionnaire> selectByJqGridParam(QuestionnaireJqGridParam param ){
        StringBuilder sql = new StringBuilder();
        sql.append(" where 1 = 1 ");

        if(StringUtils.isNotEmpty(param.getLocales())){
            sql.append(" and locales = '").append(param.getLocales()).append("'");
        }else{
            sql.append(" and locales = 'zh-CN'");
        }
        if(StringUtils.isNotEmpty(param.getName())){
            sql.append(" and name like '%").append(param.getName()).append("%'");
        }
        return new PageInfo<>(questionnaireDao.selectCompanyDynamicsList(sql.toString()));
    }


}
