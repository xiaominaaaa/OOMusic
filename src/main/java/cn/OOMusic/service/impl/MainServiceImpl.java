package cn.OOMusic.service.impl;

import cn.OOMusic.mapper.MainMapper;
import cn.OOMusic.mapper.UserMapper;
import cn.OOMusic.pojo.MainData;
import cn.OOMusic.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl implements MainService {
    @Autowired
    MainMapper mainMapper;

    @Override
    public List<MainData> mainData() {
        return mainMapper.mainData();
    }
}
