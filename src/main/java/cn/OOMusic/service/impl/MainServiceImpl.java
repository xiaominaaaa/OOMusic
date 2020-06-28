package cn.OOMusic.service.impl;

import cn.OOMusic.mapper.MainMapper;
import cn.OOMusic.mapper.UserMapper;
import cn.OOMusic.pojo.MainData;
import cn.OOMusic.pojo.Song;
import cn.OOMusic.service.MainService;
import cn.OOMusic.util.DataMap;
import cn.OOMusic.util.PropertiesUtil;
import cn.OOMusic.web.AfterSendPageProcessor;
import cn.OOMusic.web.SendPageProcessor;
import cn.OOMusic.web.SongPageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class MainServiceImpl implements MainService {
    @Autowired
    MainMapper mainMapper;
    @Autowired
    SendPageProcessor processor;
    @Autowired
    DataMap dataMap;
    @Autowired
    AfterSendPageProcessor sendPageProcessor;
    @Autowired
    PropertiesUtil propertiesUtil;
    @Autowired
    SongPageProcessor songPageProcessor;


    @Override
    public List<MainData> mainData() {
        return mainMapper.mainData();
    }

    @Override
    public String getSerch(String search) {
        processor.run(propertiesUtil.getProperties().getProperty("sercah")+search);
        //返回并且移除数据
        String s = (String) dataMap.getHashMap().remove("data");
        System.out.println(s);
        return s ;
    }

    @Override
    public List getgedan(String string) {
        sendPageProcessor.run(string);
        //返回并且移除数据
        return ( List<Song>) dataMap.getHashMap().remove("listdata");
    }

    @Override
    public Song getSong(Song song) {
        songPageProcessor.run(propertiesUtil.getProperties().getProperty("song").replace("#song",song.getSongId()));
        String image = (String) dataMap.getHashMap().remove("songimg");
        song.setSongImage(image);
        processor.run(propertiesUtil.getProperties().getProperty("songurl")
                .replace("#mid",song.getSongId()).
                replace("#uid",propertiesUtil.getProperties().getProperty("guid")));
        String songurl = (String) dataMap.getHashMap().get("data");
        song.setSongUrl(songurl);
        return song;
    }
}
