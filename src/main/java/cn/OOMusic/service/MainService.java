package cn.OOMusic.service;

import cn.OOMusic.pojo.MainData;
import cn.OOMusic.pojo.Song;

import java.util.List;

public interface MainService {
    /**
     * 返回主页面数据
     * @return
     */
    List<MainData> mainData();

    /**
     * 返回搜索数据
     * @return
     */
    String getSerch(String search);

    /**
     * 获取歌单内容
     * @param string
     * @return
     */
    List getgedan(String string);

    /**
     * 获取一首完整的歌
     * @param song
     * @return
     */
    Song getSong(Song song);
}
