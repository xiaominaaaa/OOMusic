package cn.OOMusic.mapper;

import cn.OOMusic.pojo.Example;
import cn.OOMusic.pojo.Massage;
import cn.OOMusic.pojo.PlayList;
import cn.OOMusic.pojo.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayMapper {
    /**
     * 添加一个歌单
     * @param playList
     * @return
     */
    int addPaly(PlayList playList);

    /**
     * 添加一首歌
     * @param playList
     * @return
     */
    int addSong(PlayList playList);


    /**
     * 删除一个歌单
     * @param playList
     * @return
     */
    int deleteplayList(PlayList playList);

    /**
     * 删除一首歌
     * @param playList
     * @return
     */
    int removesong(PlayList playList);

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
    int updataePlayname(PlayList playList);

    /**
     * 根据歌单id找到此歌单所有的歌曲
     */
    List<Song> getSongByPlayList(int playid);

    /**
     * 更新歌单曲目数
     */
    int updataSongnum(PlayList playList);

    /**
     * 删除歌单里的歌曲
     */
    int deletelistofsong(int id);
}
