package cn.vtyc.website.controller.frontApi;


import cn.vtyc.website.controller.BaseController;
import cn.vtyc.website.core.JSONResult;
import cn.vtyc.website.core.Pagination;
import cn.vtyc.website.core.PhotoWallJSONResult;
import cn.vtyc.website.core.Result;
import cn.vtyc.website.dao.front.*;
import cn.vtyc.website.entity.front.PageNav;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(value = "/frontApi/customers")
public class CustomersController extends BaseController {

    @Autowired
    private PageNavDao pageNavDao;
    @Autowired
    private QuestionnaireDao questionnaireDao;
    @Autowired
    private CzCapabilityDao czCapabilityDao;
    @Autowired
    private CqCapabilityDao cqCapabilityDao;
    @Autowired
    private PhotoWallDao photoWallDao;



    @RequestMapping(value = "/questionnaire")
    @ResponseBody
    public Result questionnaire(@RequestBody JSONObject jsonObject) {
        String locales = jsonObject.getString("locales");
        PageNav pageNav = pageNavDao.getImgByPageName("questionnaire",locales);
        return new JSONResult(pageNav.getImg(),pageNav.getPageHead(),questionnaireDao.selectAll());
    }
    @RequestMapping(value = "/czCapability")
    @ResponseBody
    public Result czCapability(@RequestBody JSONObject jsonObject) {
        String locales = jsonObject.getString("locales");
        PageNav pageNav = pageNavDao.getImgByPageName("czCapability",locales);
        return new JSONResult(pageNav.getImg(),pageNav.getPageHead(),czCapabilityDao.selectAll());
    }
    @RequestMapping(value = "/cqCapability")
    @ResponseBody
    public Result cqCapability(@RequestBody JSONObject jsonObject) {
        String locales = jsonObject.getString("locales");
        PageNav pageNav = pageNavDao.getImgByPageName("cqCapability",locales);
        return new JSONResult(pageNav.getImg(),pageNav.getPageHead(),cqCapabilityDao.selectAll());
    }
    @RequestMapping(value = "/designCapability")
    @ResponseBody
    public Result designCapability(@RequestBody JSONObject jsonObject) {
        String locales = jsonObject.getString("locales");
        PageNav pageNav = pageNavDao.getImgByPageName("designCapability",locales);
        return new JSONResult(pageNav.getImg(),pageNav.getPageHead(),cqCapabilityDao.selectAll());
    }
//    @RequestMapping(value = "/photoWall")
//    @ResponseBody
//    public PhotoWallJSONResult photoWall(@RequestBody JSONObject jsonObject) {
//        Integer type = jsonObject.getInteger("type");
//        Integer currentPage = jsonObject.getInteger("currentPage");
//        Integer pageSize = jsonObject.getInteger("pageSize");
//        String navimg = pageNavDao.getImgByPageName("photoWall");
//        Integer total = photoWallDao.getTotalByType(type);
//        Pagination pagination = new Pagination(currentPage,pageSize,total);
//        return new PhotoWallJSONResult(photoWallDao.getPhotoWallByType(type,(currentPage-1)*pageSize,pageSize),pagination,navimg);
////        return new JSONResult(navimg,total,photoWallDao.getPhotoWallByType(type,(currentPage-1)*pageSize,pageSize));
//    }
    @RequestMapping(value = "/photoWall")
    @ResponseBody
    public PhotoWallJSONResult photoWall(@RequestBody JSONObject jsonObject) {
        Integer type = jsonObject.getInteger("type");
        Integer currentPage = jsonObject.getInteger("currentPage");
        Integer pageSize = jsonObject.getInteger("pageSize");
        String locales = jsonObject.getString("locales");
        PageNav pageNav = pageNavDao.getImgByPageName("photoWall",locales);
        Integer total = photoWallDao.getTotalByType(type);
        Pagination pagination = new Pagination(currentPage,pageSize,total);
        return new PhotoWallJSONResult(photoWallDao.getPhotoWallByType(type,(currentPage-1)*pageSize,pageSize),pagination,pageNav.getImg(),pageNav.getPageHead());
//        return new JSONResult(navimg,total,photoWallDao.getPhotoWallByType(type,(currentPage-1)*pageSize,pageSize));
    }


//    @RequestMapping(value = "/productContainer")
//    @ResponseBody
//    public PhotoWallJSONResult productContainer(@RequestBody JSONObject jsonObject) {
//        String locales = jsonObject.getString("locales");
//        PageNav pageNav = pageNavDao.getImgByPageName("productContainer",locales);
//        return new PhotoWallJSONResult(pageNav.getImg(),pageNav.getPageHead());
//    }
}
