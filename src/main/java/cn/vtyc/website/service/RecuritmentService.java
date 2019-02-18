package cn.vtyc.website.service;


import cn.vtyc.website.core.AbstractService;
import cn.vtyc.website.core.BaseDao;
import cn.vtyc.website.core.jqGrid.JqGridParam;
import cn.vtyc.website.dao.front.CompanyDynamicsDao;
import cn.vtyc.website.dao.front.RecruitmentDao;
import cn.vtyc.website.dto.CompanyDynamicsJqGridParam;
import cn.vtyc.website.dto.RecruitmentJqGridParam;
import cn.vtyc.website.entity.front.CompanyDynamics;
import cn.vtyc.website.entity.front.Recruitment;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecuritmentService extends AbstractService<Recruitment> {

    @Resource
    private RecruitmentDao recruitmentDao;



    @Override
    protected BaseDao<Recruitment> getDao() {
        return recruitmentDao;
    }

    @Override
    protected List<Recruitment> selectByJqGridParam(JqGridParam jqGridParam) {
        CompanyDynamicsJqGridParam param = (CompanyDynamicsJqGridParam) jqGridParam;
        StringBuilder sql = new StringBuilder();
        sql.append("1=1 ");
        if (StringUtils.isNotEmpty(param.getSidx())) {
            sql.append("order by ").append(param.getSidx()).append(" ").append(param.getSord()).append("");
        }
        return recruitmentDao.selectBySql("recruitment",sql.toString());
    }


    public PageInfo<Recruitment> selectByJqGridParam(RecruitmentJqGridParam param ){
        StringBuilder sql = new StringBuilder();
        sql.append(" where 1 = 1 ");

        if(StringUtils.isNotEmpty(param.getLocales())){
            sql.append(" and locales = '").append(param.getLocales()).append("'");
        }else{
            sql.append(" and locales = 'zh-CN'");
        }
        if(StringUtils.isNotEmpty(param.getJobTitle())){
            sql.append(" and job_title like '%").append(param.getJobTitle()).append("%'");
        }
        return new PageInfo<>(recruitmentDao.selectRecruitmentList(sql.toString()));
    }


}
