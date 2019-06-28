package cn.vtyc.officalWebsite.dao.front.home;


import cn.vtyc.officalWebsite.core.BaseDao;
import cn.vtyc.officalWebsite.entity.front.home.HomeCarousel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HomeCarouselDao extends BaseDao<HomeCarousel> {
    @Delete("delete from home_carousel where img_source_name = '${imgSourceName}' ")
    void deleteFile(@Param("imgSourceName") String imgSourceName);

    @Select("select img_path from home_carousel")
    List<String> getImgPathList();

    @Select("select * from home_carousel where img_source_name = '${imgSourceName}' ")
    List<HomeCarousel> getAllByImgSourceMame (@Param("imgSourceName") String imgSourceName);

}
