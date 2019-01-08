package cn.vtyc.website.controller.frontApi;


import cn.vtyc.website.controller.BaseController;
import cn.vtyc.website.core.JSONResult;
import cn.vtyc.website.core.Result;
import cn.vtyc.website.dao.front.*;
import cn.vtyc.website.entity.front.PageNav;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/frontApi/career")
public class CareerController extends BaseController {

    @Autowired
    private PageNavDao pageNavDao;
    @Autowired
    private FaqDao faqDao;
    @Autowired
    private RecruitmentDao recruitmentDao;
    @Autowired
    private RecruitmentDetailDao recruitmentDetailDao;

    @RequestMapping(value = "/faq")
    @ResponseBody
    public Result faq(@RequestBody JSONObject jsonObject) {
        String locales = jsonObject.getString("locales");
        PageNav pageNav = pageNavDao.getImgByPageName("faq",locales);
        return new JSONResult(pageNav.getImg(),pageNav.getPageHead(),faqDao.getFaqByLocales(locales));
    }

    @RequestMapping(value = "/recruitment")
    @ResponseBody
    public Result recruitment(@RequestBody JSONObject jsonObject) {
        String locales = jsonObject.getString("locales");
        PageNav pageNav = pageNavDao.getImgByPageName("recruitment",locales);
        return new JSONResult(pageNav.getImg(),pageNav.getPageHead(),recruitmentDao.getRecruitmentByLocales(locales));
    }

    @RequestMapping(value = "/recruitmentDetail")
    @ResponseBody
    public Result recruitmentDetail(@RequestBody JSONObject jsonObject) {
        String locales = jsonObject.getString("locales");
        Integer id = jsonObject.getInteger("id");
        PageNav pageNav = pageNavDao.getImgByPageName("recruitmentDetail",locales);
        return new JSONResult(pageNav.getImg(),pageNav.getPageHead(),recruitmentDetailDao.getRecruitmentDetailByIdAndLocales(id,locales));
    }
}
