package cn.vtyc.officalWebsite.dao.front;


import cn.vtyc.officalWebsite.core.BaseDao;
import cn.vtyc.officalWebsite.entity.front.Employee;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeDao extends BaseDao<Employee> {
    @Select("select * from employee where locales = '${locales}'")
    List<Employee> getEmployeeByLocales(@Param("locales") String locales);
}
