package cn.vtyc.website.controller.backstageApi;


import cn.vtyc.website.controller.BaseController;
import cn.vtyc.website.core.JSONResult;
import cn.vtyc.website.core.Result;

import cn.vtyc.website.core.jqGrid.JqGridResult;
import cn.vtyc.website.dao.front.*;

import cn.vtyc.website.dto.*;
import cn.vtyc.website.entity.front.CompanyDynamics;
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
@RequestMapping(value = "/backstageApi/career")
public class CareerMaintainController extends BaseController {


    @Autowired
    private Environment environment;
    @Autowired
    private PageNavDao pageNavDao;
    @Autowired
    private FaqDao faqDao;
    @Autowired
    private RecruitmentDao recruitmentDao;
    @Autowired
    private RecuritmentService recuritmentService;
    @Autowired
    private RecruitmentDetailDao recruitmentDetailDao;

    /*******************************************************在线答疑*******************************************************************/
    @RequestMapping(value = "/faq")
    public String faq(Model model) {
        model.addAttribute("menus", getMenus("faq"));
        model.addAttribute("imgUrl",pageNavDao.getImgByPageName("faq","zh-CN").getImg());
        model.addAttribute("faqs",faqDao.getFaqByLocales("zh-CN"));
        return "/career/faq/faq";
    }

    @RequestMapping(value = "/faq/changeLocales")
    @ResponseBody
    public Result faqChangeLocales(@RequestParam String locales) {
        return new JSONResult(faqDao.getFaqByLocales(locales));
    }

    @RequestMapping(value = "/faq/update" ,method =RequestMethod.POST)
    @ResponseBody
    public Result faqUpdate(FaqDto dto , MultipartFile imgUrl){
        Faq faq1 = new Faq(dto.getId0(),dto.getQuestion0(),dto.getAnswer0());
        Faq faq2 = new Faq(dto.getId1(),dto.getQuestion1(),dto.getAnswer1());
        Faq faq3 = new Faq(dto.getId2(),dto.getQuestion2(),dto.getAnswer2());
        Faq faq4 = new Faq(dto.getId3(),dto.getQuestion3(),dto.getAnswer3());
        Faq faq5 = new Faq(dto.getId4(),dto.getQuestion4(),dto.getAnswer4());
        Faq faq6 = new Faq(dto.getId5(),dto.getQuestion5(),dto.getAnswer5());
        Faq faq7 = new Faq(dto.getId6(),dto.getQuestion6(),dto.getAnswer6());
        faqDao.updateByPrimaryKeySelective(faq1);
        faqDao.updateByPrimaryKeySelective(faq2);
        faqDao.updateByPrimaryKeySelective(faq3);
        faqDao.updateByPrimaryKeySelective(faq4);
        faqDao.updateByPrimaryKeySelective(faq5);
        faqDao.updateByPrimaryKeySelective(faq6);
        faqDao.updateByPrimaryKeySelective(faq7);

        String imgName = MyFileUtil.saveFile(imgUrl,"nav/");
        String url = environment.getProperty("view.img.url");
        url = url + "/" + "nav" + "/"+imgName;
        if (!imgUrl.isEmpty()){
            pageNavDao.updateImgByPageName(url,"faq");
        }

        return OK;
    }

    /*******************************************************人才招聘******************************************************************/
    @RequestMapping(value = "/recruitment")
    public String recruitment(Model model) {
        model.addAttribute("menus", getMenus("recruitment"));
        model.addAttribute("imgUrl",pageNavDao.getImgByPageName("recruitment","zh-CN").getImg());
//        model.addAttribute("recruitment",recruitmentDao.getRecruitmentByLocales("zh-CN"));
        return "/career/recruitment/list";
    }

    @RequestMapping(value = "/recruitment/grid")
    @ResponseBody
    public Result grid( RecruitmentJqGridParam param) {
        PageInfo<Recruitment> pageInfo = recuritmentService.selectByJqGridParam(param);
        JqGridResult<Recruitment> result = new JqGridResult<>();
        //当前页
        result.setPage(pageInfo.getPageNum());
        //数据总数
        result.setRecords(pageInfo.getTotal());
        //总页数
        result.setTotal(pageInfo.getPages());
        //当前页数据
        result.setRows(pageInfo.getList());
        return new JSONResult(result);
    }

    @RequestMapping(value = "/recruitment/changeLocales")
    @ResponseBody
    public Result recruitmentChangeLocales(@RequestParam String locales) {
        return new JSONResult(recruitmentDao.getRecruitmentByLocales(locales));
    }

    @RequestMapping(value = "/recruitment/mainPreEdit")
    public String mainPreEdit( Model model, @RequestParam Integer id) {
        model.addAttribute("menus", getMenus("recruitment"));
        if (null == id){
            model.addAttribute("recruitment",new Recruitment());
        }else {
            model.addAttribute("recruitment",recruitmentDao.selectByPrimaryKey(id));
        }
        return "/career/recruitment/mainEdit";
    }
    @RequestMapping(value = "/recruitment/mainEdit")
    @ResponseBody
    public  Result mainEdit(RecruitmentDto dto){
        Recruitment recruitment = new Recruitment();
        BeanUtils.copyProperties(dto,recruitment);
        if (null == dto.getId()){
            recruitmentDao.insert(recruitment);
        }else{
            recruitmentDao.updateByPrimaryKeySelective(recruitment);
        }
        return OK;
    }
    @RequestMapping(value = "/recruitment/delete")
    @ResponseBody
    public Result recruitmentDelete( @RequestParam Integer id) {
        recruitmentDao.deleteByPrimaryKey(id);
        recruitmentDetailDao.deleteRecruitmentDetailByRecruitmentId(id);
        return OK;
    }


    @RequestMapping(value = "/recruitment/detail")
    public String recruitmentPreEdit( Model model, @RequestParam Integer id) {
        model.addAttribute("menus", getMenus("recruitment"));
        if (null == id || null == recruitmentDetailDao.getRecruitmentDetailByRecruitmentId(id)){
            RecruitmentDetail recruitmentDetail = new RecruitmentDetail();
            recruitmentDetail.setRecruitmentId(id);
            model.addAttribute("recruitmentDetail",recruitmentDetail);
        }else {
            model.addAttribute("recruitmentDetail",recruitmentDetailDao.getRecruitmentDetailByRecruitmentId(id));
        }
        return "/career/recruitment/detailEdit";
    }

    @RequestMapping(value = "/recruitment/edit")
    @ResponseBody
    public  Result recruitmentEdit(RecruitmentDetailDto dto){
        RecruitmentDetail recruitmentDetail = new RecruitmentDetail();
        BeanUtils.copyProperties(dto,recruitmentDetail);
        if (null == dto.getId()){
            recruitmentDetailDao.insert(recruitmentDetail);
        }else{
            recruitmentDetailDao.updateByPrimaryKeySelective(recruitmentDetail);
        }
        return OK;
    }
//    @RequestMapping(value = "/recruitment/editImg")
//    @ResponseBody
//    public  Result recruitmentEditImg(MultipartFile imgUrl){
//        String imgName = MyFileUtil.saveFile(imgUrl,"nav\\");
//        String url = environment.getProperty("view.img.url");
//        url = url + "/" + "nav" + "/"+imgName;
//        if (!imgUrl.isEmpty()){
//            pageNavDao.updateImgByPageName(url,"recruitment");
//        }
//        return OK;
//    }


}
