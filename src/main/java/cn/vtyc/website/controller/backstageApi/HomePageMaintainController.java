package cn.vtyc.website.controller.backstageApi;


import cn.vtyc.website.controller.BaseController;
import cn.vtyc.website.core.JSONResult;
import cn.vtyc.website.core.Result;
import cn.vtyc.website.dao.front.home.*;
import cn.vtyc.website.entity.front.Home;
import cn.vtyc.website.entity.front.home.HomeCarousel;
import cn.vtyc.website.entity.payload.UploadFileResponse;
import cn.vtyc.website.service.file.FileStorageService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/backstageApi/home")
public class HomePageMaintainController extends BaseController {

    @Autowired
    private HomeCarouselDao homeCarouselDao;
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private Environment environment;


    @RequestMapping(value = "/getCarousel")
    @ResponseBody
    public Result getCarousel() {
        List<HomeCarousel> homeCarouselList = homeCarouselDao.selectAll();
        List<Map> list = new ArrayList<>();
        for(HomeCarousel carousel : homeCarouselList){
            Map map = new HashMap();
            map.put("uid",carousel.getId());
            map.put("url",carousel.getImg());
            map.put("status","done");
            map.put("name",carousel.getImg().substring(carousel.getImg().lastIndexOf("/")+1));
            list.add(map);
        }
        return new JSONResult(list);
    }

    @PostMapping("/uploadCarousel")
    @ResponseBody
    public Result uploadFile(@RequestParam("file") MultipartFile file) {
        String path = environment.getProperty("static.img.path")+"\\home";
        String fileName = fileStorageService.storeFile(file,path);
        String viewUrl = environment.getProperty("view.img.url")+"/home/"+fileName;
        HomeCarousel homeCarousel = new HomeCarousel();
        homeCarousel.setImg(viewUrl);
        homeCarouselDao.insert(homeCarousel);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

//        Map map = new HashMap();
//        map.put("uid",homeCarousel.getId());
//        map.put("url",homeCarousel.getImg());
//        map.put("status","done");
//        map.put("name",homeCarousel.getImg().substring(homeCarousel.getImg().lastIndexOf("/")+1));
//        return new JSONResult(map);
        List<HomeCarousel> homeCarouselList = homeCarouselDao.selectAll();
        List<Map> list = new ArrayList<>();
        for(HomeCarousel carousel : homeCarouselList){
            Map map = new HashMap();
            map.put("uid",carousel.getId());
            map.put("url",carousel.getImg());
            map.put("status","done");
            map.put("name",carousel.getImg().substring(carousel.getImg().lastIndexOf("/")+1));
            list.add(map);
        }
        return new JSONResult(list);
    }

    @RequestMapping(value = "/removeCarousel")
    @ResponseBody
    public Result removeCarousel(@RequestParam String id) {
        //删除数据库
        System.out.println(id);
        //删除文件
        return OK;
    }

}
