package cn.OOMusic.web.pipeline;

import cn.OOMusic.mapper.MainMapper;
import cn.OOMusic.mapper.SongMapper;
import cn.OOMusic.pojo.MainData;
import cn.OOMusic.service.MainService;
import cn.OOMusic.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;
import java.util.Map;

@Component
public class MainPipeline implements Pipeline {
    @Autowired
    MainMapper mainMapper;

    @Override
    public void process(ResultItems resultItems, Task task) {
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            System.out.println(entry.getKey() );
            List<MainData> list = (List<MainData>) entry.getValue();
            System.out.println(mainMapper);
            for (MainData data:list){
                mainMapper.addMaindata(data);
            }
        }
    }
}
