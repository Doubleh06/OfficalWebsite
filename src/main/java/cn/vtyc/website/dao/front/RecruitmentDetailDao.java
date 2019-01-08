package cn.vtyc.website.dao.front;


import cn.vtyc.website.core.BaseDao;
import cn.vtyc.website.entity.front.Recruitment;
import cn.vtyc.website.entity.front.RecruitmentDetail;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecruitmentDetailDao extends BaseDao<RecruitmentDetail> {
    @Select("select * from recruitment_detail where group_id = ${id} and locales = '${locales}'")
    RecruitmentDetail getRecruitmentDetailByIdAndLocales(@Param("id")Integer id,@Param("locales")String locales);
}
