package cn.vtyc.officalWebsite.service;


import cn.vtyc.officalWebsite.core.AbstractService;
import cn.vtyc.officalWebsite.core.BaseDao;
import cn.vtyc.officalWebsite.core.jqGrid.JqGridParam;
import cn.vtyc.officalWebsite.dao.front.home.HomeCarouselDao;
import cn.vtyc.officalWebsite.dto.CompanyDynamicsJqGridParam;
import cn.vtyc.officalWebsite.entity.front.home.HomeCarousel;
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
