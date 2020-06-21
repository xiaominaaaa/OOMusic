package cn.OOMusic.controller;

import cn.OOMusic.pojo.Example;
import cn.OOMusic.pojo.Like;
import cn.OOMusic.pojo.Massage;
import cn.OOMusic.pojo.Song;
import cn.OOMusic.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 收藏控制器
 */
@Controller
public class LikeController {

    @Autowired
    private LikeService likeService;
    /**
     * 添加收藏
     *  userid 和 songid
     * @return
     */
    @RequestMapping(value = "/like/add",method = RequestMethod.POST)
    @ResponseBody
    public Massage addLike(@RequestBody Like like){
        if(likeService.isLike(like
        )){
            return  new Massage(200,"已经收藏过了");
        }
        return likeService.addLike(like);
    }

    /**
     * 删除收藏
     * userid 和 songid
     */
    @RequestMapping(value = "/like/delete",method = RequestMethod.POST)
    @ResponseBody
    public Massage deleteLike(@RequestBody Like like){
        return likeService.deleteLike(like);
    }

    /**
     * 获取所有收藏
     * userId
     */
    @RequestMapping(value = "/like/get",method = RequestMethod.POST)
    @ResponseBody
    public Example<Song> getLike(@RequestBody Like like){
        return likeService.getLikes(like.getUserId());
    }

}
