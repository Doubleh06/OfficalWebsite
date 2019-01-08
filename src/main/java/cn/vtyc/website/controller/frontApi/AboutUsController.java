package cn.vtyc.website.controller.frontApi;


import cn.vtyc.website.controller.BaseController;
import cn.vtyc.website.core.JSONResult;
import cn.vtyc.website.core.Result;
import cn.vtyc.website.dao.front.CompanyIntroduceDao;

import cn.vtyc.website.dao.front.ContactUsDao;
import cn.vtyc.website.dao.front.EndorsementDao;
import cn.vtyc.website.dao.front.PageNavDao;
import cn.vtyc.website.entity.front.CompanyIntroduce;
import cn.vtyc.website.entity.front.ContactUs;
import cn.vtyc.website.entity.front.Endorsement;
import cn.vtyc.website.entity.front.PageNav;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


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


    @RequestMapping(value = "/companyIntroduce")
    @ResponseBody
    public Result companyIntroduce(@RequestBody JSONObject jsonObject) {
        String locales = jsonObject.getString("locales");
        PageNav pageNav = pageNavDao.getImgByPageName("companyIntroduce",locales);
        return new JSONResult(pageNav.getImg(),pageNav.getPageHead(), companyIntroduceDao.getCompanyIntroduceByLocales(locales).get(0));
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
}
