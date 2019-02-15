package cn.vtyc.website.dao.front.home;


import cn.vtyc.website.core.BaseDao;
import cn.vtyc.website.entity.front.home.HomeBox;
import cn.vtyc.website.entity.front.home.HomeCarousel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HomeCarouselDao extends BaseDao<HomeCarousel> {
    @Delete("delete from home_carousel where img_source_name = '${imgSourceName}' and uuid = '${uuid}'")
    void deleteFile(@Param("imgSourceName") String imgSourceName, @Param("uuid") String uuid);

    @Select("select img_path from home_carousel")
    List<String> getImgPathList();
}
