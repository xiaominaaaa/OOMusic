package cn.OOMusic.service.impl;

import cn.OOMusic.mapper.PlayMapper;
import cn.OOMusic.mapper.SongMapper;
import cn.OOMusic.pojo.Example;
import cn.OOMusic.pojo.Massage;
import cn.OOMusic.pojo.PlayList;
import cn.OOMusic.pojo.Song;
import cn.OOMusic.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayServiceImpl implements PlayService {
    @Autowired
    private PlayMapper playMapper;
    @Autowired
    private SongMapper songMapper;
    @Override
    public Massage addPaly(PlayList playList) {
        return playMapper.addPaly(playList) > 0 ? new Massage(200, "添加歌单成功"):new Massage(500,"添加歌单失败");
    }

    @Override
    public Massage addSong(PlayList playList) {
        return  playMapper.addSong(playList) > 0 && playMapper.updataSongnum(playList)>0 ? new Massage(200, "添加歌曲成功"):new Massage(500,"添加歌曲失败");

    }

    @Override
    public Massage deleteplayList(PlayList playList) {
        return  playMapper.deleteplayList(playList) > 0 && playMapper.deletelistofsong(playList.getId()) > 0? new Massage(200, "删除歌单成功"):new Massage(500,"添加歌单失败");
    }

    @Override
    public Massage removesong(PlayList playList) {
        return  playMapper.removesong(playList) > 0 && playMapper.updataSongnum(playList)>0 ? new Massage(200, "移除歌曲成功"):new Massage(500,"移除歌曲失败");
    }

    @Override
    public List<PlayList> getall(int uid) {
        return playMapper.getall(uid) ;
    }


    @Override
    public Massage updataePlayname(PlayList playList) {
        return  playMapper.updataePlayname(playList) > 0 ? new Massage(200, "歌曲改名成功"):new Massage(500,"歌曲改名失败");
    }


}
