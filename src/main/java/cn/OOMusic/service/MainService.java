package cn.OOMusic.service;

import cn.OOMusic.pojo.MainData;

import java.util.List;

public interface MainService {
    /**
     * 返回主页面数据
     * @return
     */
    List<MainData> mainData();
}
