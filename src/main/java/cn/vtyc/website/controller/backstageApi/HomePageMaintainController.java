package cn.vtyc.website.controller.backstageApi;


import cn.vtyc.website.controller.BaseController;
import cn.vtyc.website.core.JSONResult;
import cn.vtyc.website.core.Result;
import cn.vtyc.website.dao.ImageDao;
import cn.vtyc.website.dao.front.home.*;
import cn.vtyc.website.entity.Image;
import cn.vtyc.website.entity.front.Home;
import cn.vtyc.website.entity.front.home.HomeCarousel;
import cn.vtyc.website.entity.front.home.HomeClient;
import cn.vtyc.website.entity.payload.UploadFileResponse;
import cn.vtyc.website.service.file.FileStorageService;
import cn.vtyc.website.util.MyFileUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
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
    private HomeClientDao homeClientDao;



    @RequestMapping(value = "/carousel")
    public String getCarousel(Model model) {
        model.addAttribute("menus", getMenus("carousel"));
        model.addAttribute("uuid", UUID.randomUUID());
        if(homeCarouselDao.getImgPathList().isEmpty()){
            model.addAttribute("imgPaths","");
        }else {
            model.addAttribute("imgPaths",StringUtils.join(homeCarouselDao.getImgPathList(),","));
        }

        return "/homePage/carousel/carousel2";
    }

    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    @ResponseBody
    public Result uploadFile(MultipartFile[] files, @RequestParam String uuid) {
        List<String> subImgs = new ArrayList<>();
        String direct = "home\\";
        for (MultipartFile file : files) {
            String imgPath  = MyFileUtil.saveFile(file,direct);
            subImgs.add(imgPath);
        }
        //图片入库
        List<Image> imageList = new ArrayList<>();
        for (String subImg : subImgs){
            Image image = new Image();
            image.setUuid(uuid);
            image.setImgName(subImg.split("~")[0]);
            image.setImgSourceName(subImg.split("~")[1]);
            imageList.add(image);
        }
        imageDao.insertList(imageList);
        String subImgsString= StringUtils.join(subImgs.toArray(), ",");
        return new JSONResult(subImgsString);
    }

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

    @RequestMapping(value = "/deleteFile")
    @ResponseBody
    public Result deleteFile(@RequestParam String imgSourceName, @RequestParam String uuid) {
        //获取img_name
        String imgName = imageDao.selectImgName(imgSourceName,uuid);
        //删除数据库
        imageDao.deleteFile(imgSourceName, uuid);
        homeCarouselDao.deleteFile(imgSourceName,uuid);
        //删除本地文件
        deleteLocalFile(imgName,imgSourceName);
        return OK;
    }
    public boolean deleteLocalFile(String imgName,String imgSourceName){
        String imgPath = environment.getProperty("static.img.path");
        imgPath = imgPath + "home\\";
        String pathName = imgPath+imgName+"~"+imgSourceName;
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
}
