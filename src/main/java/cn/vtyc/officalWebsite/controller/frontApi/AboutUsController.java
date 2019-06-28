package cn.vtyc.officalWebsite.controller.frontApi;


import cn.vtyc.officalWebsite.controller.BaseController;
import cn.vtyc.officalWebsite.core.CompanyDynamicsJSONResult;
import cn.vtyc.officalWebsite.core.JSONResult;
import cn.vtyc.officalWebsite.core.Pagination;
import cn.vtyc.officalWebsite.core.Result;
import cn.vtyc.officalWebsite.dao.front.*;

import cn.vtyc.officalWebsite.entity.front.*;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/frontApi/aboutUs")
public class AboutUsController extends BaseController {

    @Autowired
    private PageNavDao pageNavDao;
    @Autowired
    private CompanyIntroduceDao companyIntroduceDao;
    @Autowired
    private ContactUsDao contactUsDao;
    @Autowired
    private EndorsementDao endorsementDao;
    @Autowired
    private CompanyDynamicsDao companyDynamicsDao;


    @RequestMapping(value = "/companyIntroduce")
    @ResponseBody
    public Result companyIntroduce(@RequestBody JSONObject jsonObject) {
        String locales = jsonObject.getString("locales");
        PageNav pageNav = pageNavDao.getImgByPageName("companyIntroduce",locales);
        return new JSONResult(pageNav.getImg(),pageNav.getPageHead(), companyIntroduceDao.getCompanyIntroduceByLocales(locales));
    }

    @RequestMapping(value = "/contactUs")
    @ResponseBody
    public Result contactUs(@RequestBody JSONObject jsonObject) {
        String locales = jsonObject.getString("locales");
        PageNav pageNav = pageNavDao.getImgByPageName("contactUs",locales);
        return new JSONResult(pageNav.getImg(),pageNav.getPageHead(), contactUsDao.getContactUsByLocales(locales));
    }

    @RequestMapping(value = "/endorsement")
    @ResponseBody
    public Result endorsement(@RequestBody JSONObject jsonObject) {
        String locales = jsonObject.getString("locales");
        PageNav pageNav = pageNavDao.getImgByPageName("endorsement",locales);
        return new JSONResult(pageNav.getImg(),pageNav.getPageHead(), endorsementDao.getEndorsementByLocales(locales).get(0));
    }
    @RequestMapping(value = "/companyDynamics")
    @ResponseBody
    public CompanyDynamicsJSONResult companyDynamics(@RequestBody JSONObject jsonObject) {
        String locales = jsonObject.getString("locales");
        Integer currentPage = jsonObject.getInteger("currentPage");
        Integer pageSize = jsonObject.getInteger("pageSize");
        PageNav pageNav = pageNavDao.getImgByPageName("companyDynamics",locales);
        //计算总数
        Integer total = companyDynamicsDao.getCompanyDynamicsTotalByLocales(locales);
        Pagination pagination = new Pagination(currentPage,0,total);
        return new CompanyDynamicsJSONResult(companyDynamicsDao.getCompanyDynamicsByLocales(locales,(currentPage-1)*pageSize,pageSize),pageNav.getImg(),pageNav.getPageHead(),pagination);
    }
    @RequestMapping(value = "/companyDynamics/detail")
    @ResponseBody
    public Result companyDynamicsDetail(@RequestBody JSONObject jsonObject) {
        String locales = jsonObject.getString("locales");
        Integer id = jsonObject.getInteger("id");
        PageNav pageNav = pageNavDao.getImgByPageName("companyDynamicsDetail",locales);
        CompanyDynamics companyDynamics = new CompanyDynamics();
        companyDynamics.setId(id);
        return new JSONResult(pageNav.getImg(),pageNav.getPageHead(), companyDynamicsDao.selectByPrimaryKey(companyDynamics));
    }

}
