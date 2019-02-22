package cn.vtyc.website.service;


import cn.vtyc.website.core.AbstractService;
import cn.vtyc.website.core.BaseDao;
import cn.vtyc.website.core.jqGrid.JqGridParam;
import cn.vtyc.website.dao.front.QuestionnaireDao;
import cn.vtyc.website.dao.front.home.HomeCarouselDao;
import cn.vtyc.website.dto.CompanyDynamicsJqGridParam;
import cn.vtyc.website.dto.QuestionnaireJqGridParam;
import cn.vtyc.website.entity.front.Home;
import cn.vtyc.website.entity.front.Questionnaire;
import cn.vtyc.website.entity.front.home.HomeCarousel;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarouselService extends AbstractService<HomeCarousel> {

    @Resource
    private HomeCarouselDao homeCarouselDao;



    @Override
    protected BaseDao<HomeCarousel> getDao() {
        return homeCarouselDao;
    }

    @Override
    protected List<HomeCarousel> selectByJqGridParam(JqGridParam jqGridParam) {
        CompanyDynamicsJqGridParam param = (CompanyDynamicsJqGridParam) jqGridParam;
        StringBuilder sql = new StringBuilder();
        sql.append("1=1 ");
        if (StringUtils.isNotEmpty(param.getSidx())) {
            sql.append("order by ").append(param.getSidx()).append(" ").append(param.getSord()).append("");
        }
        return homeCarouselDao.selectBySql("homeCarousel",sql.toString());
    }


    public String getImgAndFileName() {
        List<HomeCarousel> homeCarousels = homeCarouselDao.selectAll();
        String data = "";
        for (HomeCarousel homeCarousel:homeCarousels){
            data += homeCarousel.getImg() + "~" + homeCarousel.getImgSourceName() + "|";
        }
        return data.substring(0,data.length()-1);
    }

    public Boolean imgSourceNameIsExist(String imgSourceName){
        List<HomeCarousel> homeCarousels = homeCarouselDao.getAllByImgSourceMame(imgSourceName);
        if (homeCarousels.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

}
