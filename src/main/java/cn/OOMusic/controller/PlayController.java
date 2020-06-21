package cn.OOMusic.controller;

import cn.OOMusic.pojo.Example;
import cn.OOMusic.pojo.Massage;
import cn.OOMusic.pojo.PlayList;
import cn.OOMusic.pojo.Song;
import cn.OOMusic.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.ref.SoftReference;
import java.util.List;

@Controller
public class PlayController {

    @Autowired
    PlayService playService;
    /**
     * 添加一个歌单
     * userId playlistName (用户id 歌曲名)
     */
    @RequestMapping(value = "/play/add",method = RequestMethod.POST)
    @ResponseBody
    public Massage addPaly(@RequestBody PlayList playList){
        System.out.println(playList);
        return  playService.addPaly(playList);
    }

    /**
     * 删除一个歌单
     */
    @RequestMapping(value = "/play/delete",method = RequestMethod.POST)
    @ResponseBody
    public Massage deletePaly(@RequestBody PlayList playList){
        return  playService.deleteplayList(playList);
    }

    /**
     * 添加一首歌曲
     * userId songId id (用户id 歌曲id 歌单id)
     */
    @RequestMapping(value = "/play/addsong",method = RequestMethod.POST)
    @ResponseBody
    public Massage addsongPaly(@RequestBody PlayList playList){
        return  playService.addSong(playList);
    }

    /**
     * 删除一首歌曲
     */
    @RequestMapping(value = "/play/removesong",method = RequestMethod.POST)
    @ResponseBody
    public Massage removesongPaly(@RequestBody PlayList playList){
        return  playService.removesong(playList);
    }

    /**
     * 获取所有的歌单歌曲
     */
    @RequestMapping(value = "/play/getplaysong",method = RequestMethod.POST)
    @ResponseBody
    public List<PlayList> getsongPaly(@RequestBody PlayList playList){
        return playService.getall(playList.getUserId());
    }
}
