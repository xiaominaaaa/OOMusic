package cn.OOMusic.service.impl;

import cn.OOMusic.mapper.SongMapper;
import cn.OOMusic.pojo.Song;
import cn.OOMusic.service.SongService;
import cn.OOMusic.util.DataMap;
import cn.OOMusic.web.SongPageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongMapper songMapper;
    @Autowired
    SongPageProcessor pageProcessor;
    @Autowired
    DataMap dataMap;

    @Override
    public int addSong(Song song) {
        //进行查重
        if(songMapper.isSide(song.getSongId())>0){
            return  0;
        }
        //不重复
        return songMapper.addSong(song);
    }

    @Override
    public int deleteSong(Song song) {
        return songMapper.deleteSong(song);
    }

    @Override
    public int updataSong(Song song) {
        return songMapper.updataSong(song);
    }

    @Override
    public List<Song> findSong(List<Song> list) {
        return songMapper.findSong(list);
    }

    @Override
    public List<Song> selectsong(int songId) {
        return null;
    }


}
