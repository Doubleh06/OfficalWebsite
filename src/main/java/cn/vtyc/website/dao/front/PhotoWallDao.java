package cn.vtyc.website.dao.front;


import cn.vtyc.website.core.BaseDao;
import cn.vtyc.website.entity.front.Faq;
import cn.vtyc.website.entity.front.PhotoWall;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PhotoWallDao extends BaseDao<PhotoWall> {
//    @Select("select * from photo_wall where type = ${type} limit ${currentPage} , ${pageSize}")
//    List<PhotoWall> getPhotoWallByType(@Param("type") Integer type, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    @Select("select url from photo_wall where type = ${type} limit ${currentPage} , ${pageSize}")
    List<String> getPhotoWallByType(@Param("type") Integer type, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    @Select("select count(*) from photo_wall where type = ${type} ")
    Integer getTotalByType(@Param("type")Integer type);
}
