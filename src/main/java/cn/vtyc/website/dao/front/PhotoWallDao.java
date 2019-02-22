package cn.vtyc.website.dao.front;


import cn.vtyc.website.core.BaseDao;
import cn.vtyc.website.entity.front.Faq;
import cn.vtyc.website.entity.front.PhotoWall;
import cn.vtyc.website.entity.front.home.HomeCarousel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PhotoWallDao extends BaseDao<PhotoWall> {
//    @Select("select * from photo_wall where type = ${type} limit ${currentPage} , ${pageSize}")
//    List<PhotoWall> getPhotoWallByType(@Param("type") Integer type, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    @Select("select * from photo_wall where type = ${type} limit ${currentPage} , ${pageSize}")
    List<PhotoWall> getPhotoWallByType(@Param("type") Integer type, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    @Select("select count(*) from photo_wall where type = ${type} ")
    Integer getTotalByType(@Param("type")Integer type);

    @Select("select * from photo_wall where filename = '${filename}' and type = ${type} ")
    List<PhotoWall> getAllByFileMameAndType (@Param("filename") String filename,@Param("type") Integer type);

    @Select("select * from photo_wall where type = ${type} ")
    List<PhotoWall> getAllByType (@Param("type") Integer type);

    @Delete("delete from photo_wall where filename = '${filename}' ")
    void deleteFile(@Param("filename") String filename);
}
