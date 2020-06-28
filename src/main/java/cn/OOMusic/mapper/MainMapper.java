package cn.OOMusic.mapper;

import cn.OOMusic.pojo.MainData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainMapper {
    /**
     * 返回主页面数据
     * @return
     */
    List<MainData> mainData();

    /**
     * 添加主页数据
     * @param mainData
     * @return
     */
    int addMaindata(MainData mainData);

}
