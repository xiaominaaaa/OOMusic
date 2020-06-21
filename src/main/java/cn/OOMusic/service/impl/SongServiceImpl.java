package cn.OOMusic.service.impl;

import cn.OOMusic.mapper.SongMapper;
import cn.OOMusic.pojo.Song;
import cn.OOMusic.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongMapper songMapper;

    @Override
    public int addSong(Song song) {
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
