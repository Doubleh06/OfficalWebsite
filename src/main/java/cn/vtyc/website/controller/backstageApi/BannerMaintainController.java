package cn.vtyc.website.controller.backstageApi;


import cn.vtyc.website.controller.BaseController;
import cn.vtyc.website.core.JSONResult;
import cn.vtyc.website.core.Result;
import cn.vtyc.website.core.jqGrid.JqGridResult;
import cn.vtyc.website.dao.front.FaqDao;
import cn.vtyc.website.dao.front.PageNavDao;
import cn.vtyc.website.dao.front.RecruitmentDao;
import cn.vtyc.website.dao.front.RecruitmentDetailDao;
import cn.vtyc.website.dto.*;
import cn.vtyc.website.entity.front.Faq;
import cn.vtyc.website.entity.front.Recruitment;
import cn.vtyc.website.entity.front.RecruitmentDetail;
import cn.vtyc.website.service.RecuritmentService;
import cn.vtyc.website.util.MyFileUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping(value = "/backstageApi")
public class BannerMaintainController extends BaseController {


    @Autowired
    private Environment environment;
    @Autowired
    private PageNavDao pageNavDao;


    /*******************************************************在线答疑*******************************************************************/
    @RequestMapping(value = "/banner")
    public String banner(Model model) {
        model.addAttribute("menus", getMenus("banner"));
        model.addAttribute("pageNavs",pageNavDao.getAllByLocales());
        return "/banner/banner";
    }


    @RequestMapping(value = "/banner/query")
    @ResponseBody
    public  Result queryBanner(@RequestParam String pageName){
        return new JSONResult(pageNavDao.getImgByPageName(pageName,"zh-CN"));
    }

    @RequestMapping(value = "/banner/edit")
    @ResponseBody
    public  Result bannerEdit(BannerDto dto,MultipartFile imgUrl){
        String imgName = MyFileUtil.saveFile(imgUrl,"nav/");
        String url = environment.getProperty("view.img.url");
        url = url + "/" + "nav" + "/"+imgName;
        if (!imgUrl.isEmpty()){
            pageNavDao.updateImgByPageName(url,dto.getPageName());
        }
        return OK;
    }


}
