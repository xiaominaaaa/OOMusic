package cn.OOMusic.service;

import cn.OOMusic.pojo.Example;
import cn.OOMusic.pojo.Massage;
import cn.OOMusic.pojo.PlayList;
import cn.OOMusic.pojo.Song;

import java.util.List;


public interface PlayService {

    /**
     * 添加一个歌单
     * @param playList
     * @return
     */
    Massage addPaly(PlayList playList);

    /**
     * 添加一首歌
     * @param playList
     * @return
     */
    Massage addSong(PlayList playList);


    /**
     * 删除一个歌单
     * @param playList
     * @return
     */
    Massage deleteplayList(PlayList playList);

    /**
     * 删除一首歌
     * @param playList
     * @return
     */
    Massage removesong(PlayList playList);

    /**
     * 获取所有的歌单
     * @return
     */
    List<PlayList> getall(int uid);


    /**
     * 修改歌单名字
     * @param playList
     * @return
     */
    Massage updataePlayname(PlayList playList);


}
