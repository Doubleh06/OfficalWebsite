package cn.vtyc.officalWebsite.service;


import cn.vtyc.officalWebsite.core.AbstractService;
import cn.vtyc.officalWebsite.core.BaseDao;
import cn.vtyc.officalWebsite.core.jqGrid.JqGridParam;
import cn.vtyc.officalWebsite.dao.front.CompanyDynamicsDao;
import cn.vtyc.officalWebsite.dto.CompanyDynamicsJqGridParam;
import cn.vtyc.officalWebsite.entity.front.CompanyDynamics;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyDynamicsService extends AbstractService<CompanyDynamics> {

    @Resource
    private CompanyDynamicsDao companyDynamicsDao;



    @Override
    protected BaseDao<CompanyDynamics> getDao() {
        return companyDynamicsDao;
    }

    @Override
    protected List<CompanyDynamics> selectByJqGridParam(JqGridParam jqGridParam) {
        CompanyDynamicsJqGridParam param = (CompanyDynamicsJqGridParam) jqGridParam;
        StringBuilder sql = new StringBuilder();
        sql.append("1=1 ");
        if (StringUtils.isNotEmpty(param.getSidx())) {
            sql.append("order by ").append(param.getSidx()).append(" ").append(param.getSord()).append("");
        }
        return companyDynamicsDao.selectBySql("article",sql.toString());
    }


    public PageInfo<CompanyDynamics> selectByJqGridParam(CompanyDynamicsJqGridParam param ){
        StringBuilder sql = new StringBuilder();
        sql.append(" where 1 = 1 ");

        if(StringUtils.isNotEmpty(param.getLocales())){
            sql.append(" and locales = '").append(param.getLocales()).append("'");
        }else{
            sql.append(" and locales = 'zh-CN'");
        }
        if(StringUtils.isNotEmpty(param.getTitle())){
            sql.append(" and title like '%").append(param.getTitle()).append("%'");
        }
        return new PageInfo<>(companyDynamicsDao.selectCompanyDynamicsList(sql.toString()));
    }


}
