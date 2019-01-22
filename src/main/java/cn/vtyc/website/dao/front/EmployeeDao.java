package cn.vtyc.website.dao.front;


import cn.vtyc.website.core.BaseDao;
import cn.vtyc.website.entity.front.Employee;
import cn.vtyc.website.entity.front.Faq;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeDao extends BaseDao<Employee> {
    @Select("select * from employee where locales = '${locales}'")
    List<Employee> getEmployeeByLocales(@Param("locales") String locales);
}
