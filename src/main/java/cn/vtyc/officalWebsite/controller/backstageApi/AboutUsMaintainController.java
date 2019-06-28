package cn.vtyc.officalWebsite.controller.backstageApi;


import cn.vtyc.officalWebsite.controller.BaseController;
import cn.vtyc.officalWebsite.core.JSONResult;
import cn.vtyc.officalWebsite.core.Result;
import cn.vtyc.officalWebsite.core.jqGrid.JqGridResult;
import cn.vtyc.officalWebsite.dao.front.CompanyDynamicsDao;
import cn.vtyc.officalWebsite.dao.front.CompanyIntroduceDao;
import cn.vtyc.officalWebsite.dao.front.ContactUsDao;
import cn.vtyc.officalWebsite.dao.front.PageNavDao;
import cn.vtyc.officalWebsite.dto.CompanyDynamicsDto;
import cn.vtyc.officalWebsite.dto.CompanyIntroduceDto;
import cn.vtyc.officalWebsite.dto.ContactUsDto;
import cn.vtyc.officalWebsite.dto.CompanyDynamicsJqGridParam;
import cn.vtyc.officalWebsite.entity.front.CompanyDynamics;
import cn.vtyc.officalWebsite.entity.front.CompanyIntroduce;
import cn.vtyc.officalWebsite.entity.front.ContactUs;
import cn.vtyc.officalWebsite.service.CompanyDynamicsService;
import cn.vtyc.officalWebsite.util.MyFileUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping(value = "/backstageApi/aboutUs")
public class AboutUsMaintainController extends BaseController {

    @Autowired
    private ContactUsDao contactUsDao;
    @Autowired
    private PageNavDao pageNavDao;
    @Autowired
    private Environment environment;
    @Autowired
    private CompanyIntroduceDao companyIntroduceDao;
    @Autowired
    private CompanyDynamicsService companyDynamicsService;
    @Autowired
    private CompanyDynamicsDao companyDynamicsDao;

    /*******************************************************联系我们*******************************************************************/
    @RequestMapping(value = "/contactUs")
    public String contactUs(Model model) {
        model.addAttribute("menus", getMenus("contactUs"));
        model.addAttribute("imgUrl",pageNavDao.getImgByPageName("contactUs","zh-CN").getImg());
        model.addAttribute("contactUs1",contactUsDao.getContactUsByLocales("zh-CN").get(0));
        model.addAttribute("contactUs2",contactUsDao.getContactUsByLocales("zh-CN").get(1));
        return "/aboutUs/contactUs/contactUs";
    }

    @RequestMapping(value = "/contactUs/changeLocales")
    @ResponseBody
    public Result contactUsChangeLocales(@RequestParam String locales){
        return new JSONResult(contactUsDao.getContactUsByLocales(locales));
    }
    @RequestMapping(value = "/contactUs/update" ,method =RequestMethod.POST)
    @ResponseBody
    public Result contactUsUpdate(ContactUsDto dto , MultipartFile imgUrl){
        ContactUs contactUs1 = new ContactUs();
        contactUs1.setId(dto.getId1());
        contactUs1.setTitle(dto.getTitle1());
        contactUs1.setHotEmailDesc(dto.getHotEmailDesc1());
        contactUs1.setHotLine(dto.getHotLine1());
        contactUs1.setHotEmailDesc(dto.getHotEmailDesc1());
        contactUs1.setHotEmail(dto.getHotEmail1());
        contactUs1.setPurchaseEmailDesc(dto.getPurchaseEmailDesc1());
        contactUs1.setPurchaseEmail(dto.getPurchaseEmail1());
        contactUs1.setSaleEmailDesc(dto.getSaleEmailDesc1());
        contactUs1.setSaleEmail(dto.getSaleEmail1());
        contactUs1.setAddressDesc(dto.getAddressDesc1());
        contactUs1.setAddress(dto.getAddress1());
        contactUsDao.updateByPrimaryKeySelective(contactUs1);

        ContactUs contactUs2 = new ContactUs();
        contactUs2.setId(dto.getId2());
        contactUs2.setTitle(dto.getTitle2());
        contactUs2.setHotEmailDesc(dto.getHotEmailDesc2());
        contactUs2.setHotLine(dto.getHotLine2());
        contactUs2.setHotEmailDesc(dto.getHotEmailDesc2());
        contactUs2.setHotEmail(dto.getHotEmail2());
        contactUs2.setPurchaseEmailDesc(dto.getPurchaseEmailDesc2());
        contactUs2.setPurchaseEmail(dto.getPurchaseEmail2());
        contactUs2.setSaleEmailDesc(dto.getSaleEmailDesc2());
        contactUs2.setSaleEmail(dto.getSaleEmail2());
        contactUs2.setAddressDesc(dto.getAddressDesc2());
        contactUs2.setAddress(dto.getAddress2());
        contactUsDao.updateByPrimaryKeySelective(contactUs2);
        String imgName = MyFileUtil.saveFile(imgUrl,"nav/");
        String url = environment.getProperty("view.img.url");
        url = url + "/" + "nav" + "/"+imgName;
        if (!imgUrl.isEmpty()){
            pageNavDao.updateImgByPageName(url,"contactUs");
        }

        return OK;
    }
    /*******************************************************公司介绍*******************************************************************/
    @RequestMapping(value = "/companyIntroduce")
    public String companyIntroduce(Model model) {
        model.addAttribute("menus", getMenus("companyIntroduce"));
        model.addAttribute("imgUrl",pageNavDao.getImgByPageName("companyIntroduce","zh-CN").getImg());
        model.addAttribute("companyIntroduce",companyIntroduceDao.getCompanyIntroduceByLocales("zh-CN"));
        return "/aboutUs/companyIntroduce/companyIntroduce";
    }
    @RequestMapping(value = "/companyIntroduce/changeLocales")
    @ResponseBody
    public Result CompanyIntroduceChangeLocales(@RequestParam String locales){
        return new JSONResult(companyIntroduceDao.getCompanyIntroduceByLocales(locales));
    }
    @RequestMapping(value = "/companyIntroduce/update" ,method =RequestMethod.POST)
    @ResponseBody
    public Result companyIntroduceUpdate(CompanyIntroduceDto dto , MultipartFile imgUrl, MultipartFile czImgUrl, MultipartFile cqImgUrl){
        String imgName = MyFileUtil.saveFile(imgUrl,"nav/");
        String url = environment.getProperty("view.img.url");
        if (!imgUrl.isEmpty()){
            url = url + "/" + "nav" + "/"+imgName;
            pageNavDao.updateImgByPageName(url,"companyIntroduce");
        }

        String czImgName = MyFileUtil.saveFile(czImgUrl,"aboutUs/companyIntroduce/");
        String cqImgName = MyFileUtil.saveFile(cqImgUrl, "aboutUs/companyIntroduce/");
        CompanyIntroduce companyIntroduce = new CompanyIntroduce();
        BeanUtils.copyProperties(dto,companyIntroduce);
        if(!czImgName.isEmpty()){
            companyIntroduce.setCzImg(url+"/aboutUs/companyIntroduce/"+czImgName);
        }
        if (!cqImgName.isEmpty()){
            companyIntroduce.setCqImg(url+"/aboutUs/companyIntroduce/"+cqImgName);
        }
//        companyIntroduce.setId(dto.getId());
        companyIntroduceDao.updateByPrimaryKeySelective(companyIntroduce);
        return OK;
    }
    /*******************************************************公司动态*******************************************************************/
    @RequestMapping(value = "/companyDynamics")
    public String companyDynamics(Model model) {
        model.addAttribute("menus", getMenus("companyDynamics"));
        model.addAttribute("imgUrl",pageNavDao.getImgByPageName("companyIntroduce","zh-CN").getImg());
        model.addAttribute("companyIntroduce",companyIntroduceDao.getCompanyIntroduceByLocales("zh-CN"));
        return "/aboutUs/companyDynamics/list";
    }
    @RequestMapping(value = "/companyDynamics/grid")
    @ResponseBody
    public Result grid( CompanyDynamicsJqGridParam param) {
        PageInfo<CompanyDynamics> pageInfo = companyDynamicsService.selectByJqGridParam(param);
        JqGridResult<CompanyDynamics> result = new JqGridResult<>();
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
    @RequestMapping(value = "/companyDynamics/delete")
    @ResponseBody
    public Result companyDynamicsDelete( @RequestParam Integer id) {
        companyDynamicsDao.deleteByPrimaryKey(id);
        return OK;
    }
    @RequestMapping(value = "/companyDynamics/preEdit")
    public String companyDynamicsPreEdit( Model model, @RequestParam Integer id) {
        model.addAttribute("menus", getMenus("companyDynamics"));
        if (null == id){
            model.addAttribute("companyDynamics",new CompanyDynamics());
            model.addAttribute("img1","");
            model.addAttribute("img2","");
            model.addAttribute("img3","");
        }else {
            CompanyDynamics companyDynamics = companyDynamicsDao.selectByPrimaryKey(id);
            model.addAttribute("companyDynamics",companyDynamics);
            model.addAttribute("img1",companyDynamics.getImg().split("\\|",-1)[0]);
            model.addAttribute("img2",companyDynamics.getImg().split("\\|",-1)[1]);
            model.addAttribute("img3",companyDynamics.getImg().split("\\|",-1)[2]);
        }

        return "/aboutUs/companyDynamics/edit";
    }

    @RequestMapping(value = "/companyDynamics/edit")
    @ResponseBody
    public Result companyDynamicsEdit(CompanyDynamicsDto dto, MultipartFile imgUrl1, MultipartFile imgUrl2, MultipartFile imgUrl3) {
        String url = environment.getProperty("view.img.url");
        String img = "";
        String[] oldImgArr ;
        if (null == dto.getId()) {
            oldImgArr = "||".split("\\|",-1);
        }else{
            oldImgArr = companyDynamicsDao.selectByPrimaryKey(dto.getId()).getImg().split("\\|",-1);
        }
        if (!imgUrl1.isEmpty()){
            String imgName1 = MyFileUtil.saveFile(imgUrl1,"aboutUs/companyDynamicsDetail/");
            String url1 = url + "/" + "aboutUs/companyDynamicsDetail" + "/"+imgName1;
            img+=url1+"|";
        }else if(!oldImgArr[0].isEmpty()){
            img+=oldImgArr[0]+"|";
        }else{
            img+="|";
        }
        if (!imgUrl2.isEmpty()){
            String imgName2 = MyFileUtil.saveFile(imgUrl2,"aboutUs/companyDynamicsDetail/");
            String url2 = url + "/" + "aboutUs/companyDynamicsDetail" + "/"+imgName2;
            img+=url2+"|";
        }else if(!oldImgArr[1].isEmpty()){
            img+=oldImgArr[1]+"|";
        }else{
            img+="|";
        }
        if (!imgUrl3.isEmpty()){
            String imgName3 = MyFileUtil.saveFile(imgUrl3,"aboutUs/companyDynamicsDetail/");
            String url3 = url + "/" + "aboutUs/companyDynamicsDetail" + "/"+imgName3;
            img+=url3+"|";
        }else if(!oldImgArr[2].isEmpty()){
            img+=oldImgArr[2]+"|";
        }else{
            img+="|";
        }

        CompanyDynamics companyDynamics = new CompanyDynamics();
        BeanUtils.copyProperties(dto, companyDynamics);
        img = img.substring(0,img.length()-1);
        companyDynamics.setImg(img);
        if (null == dto.getId()) {
            //新增
            companyDynamics.setHref("/aboutUs/companyDynamics/detail?id=");
            companyDynamicsDao.insert(companyDynamics);
        } else {

            companyDynamicsDao.updateByPrimaryKeySelective(companyDynamics);
        }
        return OK;
    }

}
