package cn.vtyc.website.controller.backstageApi;


import cn.vtyc.website.controller.BaseController;

import cn.vtyc.website.core.ErrorCode;
import cn.vtyc.website.core.JSONResult;
import cn.vtyc.website.core.Result;
import cn.vtyc.website.core.jqGrid.JqGridResult;
import cn.vtyc.website.dao.front.PhotoWallDao;
import cn.vtyc.website.dao.front.QuestionnaireDao;
import cn.vtyc.website.dto.*;
import cn.vtyc.website.entity.front.PhotoWall;
import cn.vtyc.website.entity.front.Questionnaire;
import cn.vtyc.website.entity.payload.UploadFileResponse;
import cn.vtyc.website.service.PhotoWallService;
import cn.vtyc.website.service.QuestionnaireService;
import cn.vtyc.website.service.file.FileStorageService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;


@Controller
@RequestMapping(value = "/backstageApi/customers")
public class CustomersMaintainController extends BaseController {

    @Autowired
    private QuestionnaireService questionnaireService;
    @Autowired
    private QuestionnaireDao questionnaireDao;
    @Autowired
    private Environment environment;
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private PhotoWallService photoWallService;
    @Autowired
    private PhotoWallDao photoWallDao;
    /*******************************************************问卷调查*******************************************************************/
    @RequestMapping(value = "/questionnaire")
    public String questionnaire(Model model) {
        model.addAttribute("menus", getMenus("questionnaire"));
        return "customers/questionnaire/list";
    }

    @RequestMapping(value = "/questionnaire/grid")
    @ResponseBody
    public Result questionnaireGrid( QuestionnaireJqGridParam param) {
        PageInfo<Questionnaire> pageInfo = questionnaireService.selectByJqGridParam(param);
        JqGridResult<Questionnaire> result = new JqGridResult<>();
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

    @RequestMapping("/questionnaire/insert")
    @ResponseBody
    public Result questionnaireInsert(@RequestBody JSONObject jsonObject) {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setName(jsonObject.getString("name"));
        questionnaire.setLocales(jsonObject.getString("locales"));
        questionnaireDao.insert(questionnaire);
        return OK;
    }
    @RequestMapping("/questionnaire/delete")
    @ResponseBody
    public Result questionnaireDelete(@RequestParam Integer id) {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setId(id);
        questionnaireDao.delete(questionnaire);
        return OK;
    }
    /*******************************************************照片墙*******************************************************************/
    @RequestMapping(value = "/headLight")
    public String headLight(Model model) {
        model.addAttribute("menus", getMenus("headLight"));
        model.addAttribute("headLight",photoWallService.getImgAndFileName(1));
        return "customers/lights/headLight";
    }
    @RequestMapping(value = "/tailLight")
    public String tailLight(Model model) {
        model.addAttribute("menus", getMenus("tailLight"));
        model.addAttribute("tailLight",photoWallService.getImgAndFileName(2));
        return "customers/lights/tailLight";
    }
    @RequestMapping(value = "/headLight/uploadFiles", method = RequestMethod.POST)
    @ResponseBody
    public Result headLightUploadFile(@RequestParam("file") MultipartFile file) {
        if(!photoWallService.filenameIsExist(file.getOriginalFilename(),1)){
            return  new JSONResult(ErrorCode.FILENAME_REPEAT.code(),ErrorCode.FILENAME_REPEAT.message());
        }
        String imgUrl = environment.getProperty("view.img.url")+"/customers/headLight";
        String path = environment.getProperty("static.img.path")+"/customers/headLight";
        String fileName = fileStorageService.storeFile(file,path);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(fileName).toUriString();

        PhotoWall photoWall = new PhotoWall();
        photoWall.setUrl(imgUrl+"/"+fileName);
        photoWall.setType(1);
        photoWall.setTitle(fileName.substring(0,fileName.indexOf(".")));
        photoWall.setFilename(fileName);
        photoWallService.insert(photoWall);

        return new JSONResult(new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize()));
//        return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    }

    @RequestMapping(value = "/tailLight/uploadFiles", method = RequestMethod.POST)
    @ResponseBody
    public Result tailLightUploadFile(@RequestParam("file") MultipartFile file) {
        if(!photoWallService.filenameIsExist(file.getOriginalFilename(),2)){
            return  new JSONResult(ErrorCode.FILENAME_REPEAT.code(),ErrorCode.FILENAME_REPEAT.message());
        }
        String imgUrl = environment.getProperty("view.img.url")+"/customers/tailLight";
        String path = environment.getProperty("static.img.path")+"/customers/tailLight";
        String fileName = fileStorageService.storeFile(file,path);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(fileName).toUriString();

        PhotoWall photoWall = new PhotoWall();
        photoWall.setUrl(imgUrl+"/"+fileName);
        photoWall.setType(2);
        photoWall.setTitle(fileName.substring(0,fileName.indexOf(".")));
        photoWall.setFilename(fileName);
        photoWallService.insert(photoWall);

        return new JSONResult(new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize()));
//        return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    }

    @RequestMapping(value = "/headLight/deleteFile")
    @ResponseBody
    public Result headLightDeleteFile(@RequestParam String filename) {
        photoWallDao.deleteFile(filename);
        //删除本地文件
        deleteLocalFile("",filename,"headLight");
        return OK;
    }
    @RequestMapping(value = "/tailLight/deleteFile")
    @ResponseBody
    public Result tailLightDeleteFile(@RequestParam String filename) {
        photoWallDao.deleteFile(filename);
        //删除本地文件
        deleteLocalFile("",filename,"tailLight");
        return OK;
    }
    public boolean deleteLocalFile(String imgName,String filename,String path){
        String imgPath = environment.getProperty("static.img.path");
        imgPath = imgPath + "customers\\"+path+"\\";
        String pathName = imgPath+imgName+""+filename;
        boolean flag = false;
        File file = new File(pathName);
        if (file.exists()&&file.isFile()){
            file.delete();
            flag = true;
        }
        return flag;
    }

}
