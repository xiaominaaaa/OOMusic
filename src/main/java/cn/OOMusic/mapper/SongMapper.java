package cn.OOMusic.mapper;

import cn.OOMusic.pojo.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongMapper {
    /**
     * 添加一条歌曲
     * @param song
     * @return
     */
    int addSong(Song song);

    /**
     * 删除一条歌曲
     * @param song
     * @return
     */
    int deleteSong(Song song);

    /**
     * 修改一条歌曲
     * @param song
     * @return
     */
    int updataSong(Song song);

    /**
     * 查询一条或者多条歌曲
     */
    List<Song> findSong(List<Song> list);

    /**
     * 查询一条条歌曲
     */

    List<Song> selectsong(int songId);


}
