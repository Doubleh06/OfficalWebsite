package cn.vtyc.website.service;


import cn.vtyc.website.core.AbstractService;
import cn.vtyc.website.core.BaseDao;
import cn.vtyc.website.core.jqGrid.JqGridParam;
import cn.vtyc.website.dao.front.PhotoWallDao;
import cn.vtyc.website.dao.front.home.HomeCarouselDao;
import cn.vtyc.website.dto.CompanyDynamicsJqGridParam;
import cn.vtyc.website.entity.front.PhotoWall;
import cn.vtyc.website.entity.front.home.HomeCarousel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PhotoWallService extends AbstractService<PhotoWall> {

    @Resource
    private PhotoWallDao photoWallDao;



    @Override
    protected BaseDao<PhotoWall> getDao() {
        return photoWallDao;
    }

    @Override
    protected List<PhotoWall> selectByJqGridParam(JqGridParam jqGridParam) {
        CompanyDynamicsJqGridParam param = (CompanyDynamicsJqGridParam) jqGridParam;
        StringBuilder sql = new StringBuilder();
        sql.append("1=1 ");
        if (StringUtils.isNotEmpty(param.getSidx())) {
            sql.append("order by ").append(param.getSidx()).append(" ").append(param.getSord()).append("");
        }
        return photoWallDao.selectBySql("photoWall",sql.toString());
    }


    public String getImgAndFileName(Integer type) {
        List<PhotoWall> photoWalls = photoWallDao.getAllByType(type);
        String data = "";
        for (PhotoWall photoWall:photoWalls){
            data += photoWall.getUrl() + "~" + photoWall.getFilename() + "|";
        }
        return data==""? "": data.substring(0,data.length()-1);
    }

    public Boolean filenameIsExist(String filename ,Integer type){
        List<PhotoWall> photoWalls = photoWallDao.getAllByFileMameAndType(filename,type);
        if (photoWalls.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

}
