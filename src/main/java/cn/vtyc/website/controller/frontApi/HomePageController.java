package cn.vtyc.website.controller.frontApi;


import cn.vtyc.website.controller.BaseController;
import cn.vtyc.website.core.JSONResult;
import cn.vtyc.website.core.Result;
import cn.vtyc.website.dao.front.home.*;
import cn.vtyc.website.entity.front.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/frontApi")
public class HomePageController extends BaseController {

    @Autowired
    private HomeCarouselDao homeCarouselDao;
    @Autowired
    private HomeGalleryDao homeGalleryDao;
    @Autowired
    private HomeClientDao homeClientDao;
    @Autowired
    private HomeBoxDao homeBoxDao;
    @Autowired
    private HomeIntroduceDao homeIntroduceDao;


    @RequestMapping(value = "/home")
    @ResponseBody
    public Result home() {
        Home home = new Home();
        home.setHomeCarousel(homeCarouselDao.selectAll());
        home.setHomeGallery(homeGalleryDao.selectAll());
        home.setHomeClient(homeClientDao.selectAll());
        home.setHomeIntroduce(homeIntroduceDao.selectByPrimaryKey(1));
        home.setHomeBox(homeBoxDao.selectAll());
        return new JSONResult(home);
    }

}
