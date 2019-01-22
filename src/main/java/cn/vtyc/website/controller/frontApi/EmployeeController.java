package cn.vtyc.website.controller.frontApi;


import cn.vtyc.website.controller.BaseController;
import cn.vtyc.website.core.CompanyDynamicsJSONResult;
import cn.vtyc.website.core.JSONResult;
import cn.vtyc.website.core.Pagination;
import cn.vtyc.website.core.Result;
import cn.vtyc.website.dao.front.*;
import cn.vtyc.website.entity.front.PageNav;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/frontApi")
public class EmployeeController extends BaseController {

    @Autowired
    private PageNavDao pageNavDao;
    @Autowired
    private EmployeeDao employeeDao;



    @RequestMapping(value = "/employee")
    @ResponseBody
    public Result companyIntroduce(@RequestBody JSONObject jsonObject) {
        String locales = jsonObject.getString("locales");
        PageNav pageNav = pageNavDao.getImgByPageName("employee",locales);
        return new JSONResult(pageNav.getImg(),pageNav.getPageHead(),employeeDao.getEmployeeByLocales(locales).get(0));
    }



}
