package cn.OOMusic.controller;

import cn.OOMusic.pojo.Example;
import cn.OOMusic.pojo.Example02;
import cn.OOMusic.pojo.MainData;
import cn.OOMusic.pojo.Song;
import cn.OOMusic.service.MainService;
import cn.OOMusic.service.UserService;
import cn.OOMusic.service.impl.MainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    /***
     * 搜索数据
     * @return
     */
    @RequestMapping(value = "/main/search" )
    @ResponseBody
    public Example02<String> getSerch(MainData mainData){
        Example02 example02 = new Example02();
        example02.setT(mainService.getSerch(mainData.getNextUrl()));
        return example02;
    }

    /**
     * 获取歌单推荐内容
     */
    @RequestMapping(value = "/main/ge",method = RequestMethod.POST)
    @ResponseBody
    public List<Song> getGedan(@RequestBody  MainData data){
        List<Song> list = mainService.getgedan(data.getNextUrl());
        System.out.println(list);
        return list;
    }

    /**
     * 获取一首完整的歌
     */
    @RequestMapping(value = "/main/getsong",method = RequestMethod.POST)
    @ResponseBody
    public Song getSong(   @RequestBody Song song){
        return mainService.getSong(song);
    }
}
