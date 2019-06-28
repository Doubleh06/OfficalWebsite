package cn.vtyc.officalWebsite.service;


import cn.vtyc.officalWebsite.core.AbstractService;
import cn.vtyc.officalWebsite.core.BaseDao;
import cn.vtyc.officalWebsite.core.jqGrid.JqGridParam;
import cn.vtyc.officalWebsite.dao.front.PhotoWallDao;
import cn.vtyc.officalWebsite.dto.CompanyDynamicsJqGridParam;
import cn.vtyc.officalWebsite.entity.front.PhotoWall;
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
