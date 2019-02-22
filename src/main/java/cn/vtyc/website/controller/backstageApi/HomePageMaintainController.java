package cn.vtyc.website.controller.backstageApi;


import cn.vtyc.website.controller.BaseController;
import cn.vtyc.website.core.ErrorCode;
import cn.vtyc.website.core.JSONResult;
import cn.vtyc.website.core.Result;
import cn.vtyc.website.dao.ImageDao;
import cn.vtyc.website.dao.front.home.*;
import cn.vtyc.website.dto.BannerDto;
import cn.vtyc.website.dto.GalleryDto;
import cn.vtyc.website.dto.HomeBoxDto;
import cn.vtyc.website.dto.HomeIntroduceDto;
import cn.vtyc.website.entity.Image;
import cn.vtyc.website.entity.front.Home;
import cn.vtyc.website.entity.front.home.*;
import cn.vtyc.website.entity.payload.UploadFileResponse;
import cn.vtyc.website.service.CarouselService;
import cn.vtyc.website.service.file.FileStorageService;
import cn.vtyc.website.util.MyFileUtil;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.x.protobuf.Mysqlx;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping(value = "/backstageApi/home")
public class HomePageMaintainController extends BaseController {

    @Autowired
    private ImageDao imageDao;
    @Autowired
    private Environment environment;
    @Autowired
    private HomeCarouselDao homeCarouselDao;
    @Autowired
    private CarouselService carouselService;
    @Autowired
    private HomeClientDao homeClientDao;
    @Autowired
    private HomeGalleryDao homeGalleryDao;
    @Autowired
    private HomeIntroduceDao homeIntroduceDao;
    @Autowired
    private HomeBoxDao homeBoxDao;
    @Autowired
    private FileStorageService fileStorageService;



    @RequestMapping(value = "/carousel")
    public String getCarousel(Model model) {
        model.addAttribute("menus", getMenus("carousel"));
//        model.addAttribute("uuid", UUID.randomUUID());
        if(homeCarouselDao.getImgPathList().isEmpty()){
            model.addAttribute("imgPaths","");
        }else {
            model.addAttribute("imgPaths",carouselService.getImgAndFileName());
        }

        return "/homePage/carousel/carousel2";
    }
    @RequestMapping(value = "/carousel/uploadFiles", method = RequestMethod.POST)
    @ResponseBody
    public Result myUploadFile(@RequestParam("file") MultipartFile file) {
        if(!carouselService.imgSourceNameIsExist(file.getOriginalFilename())){
            return  new JSONResult(ErrorCode.FILENAME_REPEAT.code(),ErrorCode.FILENAME_REPEAT.message());
        }
        String imgUrl = environment.getProperty("view.img.url")+"/home";
        String path = environment.getProperty("static.img.path")+"/home";
        String fileName = fileStorageService.storeFile(file,path);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(fileName).toUriString();

        HomeCarousel homeCarousel = new HomeCarousel();
        homeCarousel.setImgSourceName(fileName);
        homeCarousel.setImg(imgUrl+"/"+fileName);
        homeCarouselDao.insert(homeCarousel);

        return new JSONResult(new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize()));
//        return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    }
//    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
//    @ResponseBody
//    public Result uploadFile(MultipartFile[] files) {
//        System.out.println(files.length);
//        List<String> subImgs = new ArrayList<>();
//        String direct = "home\\";
//        for (MultipartFile file : files) {
//            String imgPath  = MyFileUtil.saveFile(file,direct);
//            System.out.println(imgPath);
//            subImgs.add(imgPath);
//        }
////        //图片入库
////        List<Image> imageList = new ArrayList<>();
////        for (String subImg : subImgs){
////            Image image = new Image();
////            image.setImgName(subImg.split("~")[0]);
////            image.setImgSourceName(subImg.split("~")[1]);
////            imageList.add(image);
////        }
////        imageDao.insertList(imageList);
////        String subImgsString= StringUtils.join(subImgs.toArray(), ",");
////        return new JSONResult(subImgsString);
//        return OK;
//    }

//    @PostMapping("/uploadCarousel")
//    @ResponseBody
//    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
//        String path = environment.getProperty("static.img.path")+"\\home";
//        String fileName = fileStorageService.storeFile(file,path);
//        String viewUrl = environment.getProperty("view.img.url")+"/home/"+fileName;
//        HomeCarousel homeCarousel = new HomeCarousel();
//        homeCarousel.setImg(viewUrl);
//        homeCarouselDao.insert(homeCarousel);
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();
//
//        return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
//    }

    @RequestMapping(value = "/carousel/deleteFile")
    @ResponseBody
    public Result deleteFile(@RequestParam String imgSourceName) {
        homeCarouselDao.deleteFile(imgSourceName);
        //删除本地文件
        deleteLocalFile("",imgSourceName);
        return OK;
    }
    public boolean deleteLocalFile(String imgName,String imgSourceName){
        String imgPath = environment.getProperty("static.img.path");
        imgPath = imgPath + "home\\";
        String pathName = imgPath+imgName+""+imgSourceName;
        boolean flag = false;
        File file = new File(pathName);
        if (file.exists()&&file.isFile()){
            file.delete();
            flag = true;
        }
        return flag;
    }

    @RequestMapping(value = "insert")
    @ResponseBody
    public Result insert(@RequestBody JSONObject jsonObject) {
        //获取http图片连接
        String viewPath = environment.getProperty("view.img.url");
        //获取图片连接
        String imgPath = environment.getProperty("static.img.path");
        String uuid = jsonObject.getString("uuid");
        List<Image> imageList = imageDao.selectImgSourceName(uuid);
        List<HomeCarousel> homeCarouselList = new ArrayList<>();
        for (Image image : imageList){
            HomeCarousel homeCarousel = new HomeCarousel(viewPath+"/home/"+image.getImgName()+"~"+image.getImgSourceName(),uuid,("/picture/home/"+image.getImgName()+"~"+image.getImgSourceName()),image.getImgSourceName());
            homeCarouselList.add(homeCarousel);
        }
        homeCarouselDao.insertList(homeCarouselList);
        return OK;
    }

    /********************************************client***********************************************/

    @RequestMapping(value = "/client")
    public String getClient(Model model) {
        model.addAttribute("menus", getMenus("client"));
        String locales = "zh-CN";
        model.addAttribute("client1",homeClientDao.getHomeClientByLocales(locales).get(0));
        model.addAttribute("client2",homeClientDao.getHomeClientByLocales(locales).get(1));
        return "/homePage/client/client";
    }

    @RequestMapping(value = "/client/changeLocales")
    @ResponseBody
    public Result changeLocales(@RequestParam String locales){
        return new JSONResult(homeClientDao.getHomeClientByLocales(locales));
    }

    @RequestMapping(value = "/client/update")
    @ResponseBody
    public Result clientUpdate(@RequestBody JSONObject jsonObject){
        String locales = jsonObject.getString("locales");
        Integer id1 = jsonObject.getInteger("id1");
        String h3_1 = jsonObject.getString("greenTitle1");
        String span1 = jsonObject.getString("whiteTitle1");
        String p1 = jsonObject.getString("content1");
        Integer id2 = jsonObject.getInteger("id2");
        String h3_2 = jsonObject.getString("greenTitle2");
        String span2 = jsonObject.getString("whiteTitle2");
        String p2 = jsonObject.getString("content2");
        HomeClient homeClient1 = new HomeClient(h3_1,span1,p1,locales);
        homeClient1.setId(id1);
        homeClientDao.updateByPrimaryKeySelective(homeClient1);
        HomeClient homeClient2 = new HomeClient(h3_2,span2,p2,locales);
        homeClient2.setId(id2);
        homeClientDao.updateByPrimaryKeySelective(homeClient2);
        return OK;
    }
    /********************************************gallery***********************************************/
    @RequestMapping(value = "/gallery")
    public String gallery(Model model) {
        model.addAttribute("menus", getMenus("gallery"));
        String locales = "zh-CN";
        model.addAttribute("galleries",homeGalleryDao.getHomeGalleryByLocales(locales));
        return "/homePage/gallery/gallery";
    }

    @RequestMapping(value = "/gallery/changeLocales")
    @ResponseBody
    public Result galleryChangeLocales(@RequestParam String locales){
        return new JSONResult(homeGalleryDao.getHomeGalleryByLocales(locales));
    }

    @RequestMapping(value = "/gallery/update")
    @ResponseBody
    public  Result galleryUpdate(GalleryDto dto, MultipartFile imgUrl0, MultipartFile imgUrl1, MultipartFile imgUrl2){
        String imgName0 = MyFileUtil.saveFile(imgUrl0,"home\\");
        String imgName1 = MyFileUtil.saveFile(imgUrl1,"home\\");
        String imgName2 = MyFileUtil.saveFile(imgUrl2,"home\\");
        String url = environment.getProperty("view.img.url");
        String url0 = url + "/" + "home" + "/"+imgName0;
        String url1 = url + "/" + "home" + "/"+imgName1;
        String url2 = url + "/" + "home" + "/"+imgName2;
        HomeGallery gallery0 = new HomeGallery(dto.getId0(),dto.getTitle0(),dto.getContent0(),dto.getLabel0());
        HomeGallery gallery1 = new HomeGallery(dto.getId1(),dto.getTitle1(),dto.getContent1(),dto.getLabel1());
        HomeGallery gallery2 = new HomeGallery(dto.getId2(),dto.getTitle2(),dto.getContent2(),dto.getLabel2());
        if (!imgUrl0.isEmpty()){
            gallery0.setImg(url0);
        }
        if (!imgUrl1.isEmpty()){
            gallery1.setImg(url1);
        }
        if (!imgUrl2.isEmpty()){
            gallery2.setImg(url2);
        }
        homeGalleryDao.updateByPrimaryKeySelective(gallery0);
        homeGalleryDao.updateByPrimaryKeySelective(gallery1);
        homeGalleryDao.updateByPrimaryKeySelective(gallery2);
        return OK;
    }

    /********************************************companyIntroduce***********************************************/
    @RequestMapping(value = "/homeIntroduce")
    public String companyIntroduce(Model model) {
        model.addAttribute("menus", getMenus("homeIntroduce"));
        String locales = "zh-CN";
        model.addAttribute("homeIntroduce",homeIntroduceDao.getHomeIntroduceByLocales(locales).get(0));
        return "/homePage/homeIntroduce/homeIntroduce";
    }

    @RequestMapping(value = "/homeIntroduce/changeLocales")
    @ResponseBody
    public Result homeIntroduceChangeLocales(@RequestParam String locales){
        return new JSONResult(homeIntroduceDao.getHomeIntroduceByLocales(locales).get(0));
    }

    @RequestMapping(value = "/homeIntroduce/update")
    @ResponseBody
    public  Result homeIntroduceUpdate(HomeIntroduceDto dto, MultipartFile imgUrl){
        String imgName = MyFileUtil.saveFile(imgUrl,"home\\");
        String url = environment.getProperty("view.img.url");
        String url0 = url + "/" + "home" + "/"+imgName;
        HomeIntroduce homeIntroduce = new HomeIntroduce(dto.getId(),dto.getTitle(),dto.getContent());
        if (!imgUrl.isEmpty()){
            homeIntroduce.setImg(url0);
        }
        homeIntroduceDao.updateByPrimaryKeySelective(homeIntroduce);
        return OK;
    }
    /********************************************box***********************************************/
    @RequestMapping(value = "/box")
    public String box(Model model) {
        model.addAttribute("menus", getMenus("box"));
        String locales = "zh-CN";
        model.addAttribute("boxes",homeBoxDao.getHomeBoxByLocales(locales));
        return "/homePage/box/box";
    }

    @RequestMapping(value = "/box/changeLocales")
    @ResponseBody
    public Result boxChangeLocales(@RequestParam String locales){
        return new JSONResult(homeBoxDao.getHomeBoxByLocales(locales));
    }

    @RequestMapping(value = "/box/update")
    @ResponseBody
    public  Result boxIntroduceUpdate(HomeBoxDto dto){
        HomeBox homeBox = new HomeBox(dto.getId0(),dto.getTitle0(),dto.getContent0());
        homeBoxDao.updateByPrimaryKeySelective(homeBox);
        return OK;
    }
}
