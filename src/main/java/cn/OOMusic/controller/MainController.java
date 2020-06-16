package cn.OOMusic.controller;

import cn.OOMusic.pojo.Example;
import cn.OOMusic.pojo.MainData;
import cn.OOMusic.service.MainService;
import cn.OOMusic.service.UserService;
import cn.OOMusic.service.impl.MainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 主页控制器
 */
@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    /***
     * 获取主页数据
     * @return
     */
    @RequestMapping(value = "/main" )
    @ResponseBody
    public Example<MainData> getMainData(){
        Example<MainData> example = new Example<>();
        example.setList(mainService.mainData());
        return  example;
    }
}
