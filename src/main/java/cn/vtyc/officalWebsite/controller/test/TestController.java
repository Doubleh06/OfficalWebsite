package cn.vtyc.officalWebsite.controller.test;


import cn.vtyc.officalWebsite.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/test")
public class TestController extends BaseController {




    @RequestMapping(value = "/home")
    public String home(Model model) {
        return "/test/home";
    }

}
