package cn.OOMusic.web.pipeline;

import cn.OOMusic.pojo.MainData;
import cn.OOMusic.service.impl.MainServiceImpl;
import cn.OOMusic.util.DataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.HashMap;
import java.util.Map;

/**
 * 把取到的数据进行转载
 */
@Component
public class SendPipeline implements Pipeline {
    @Autowired
    DataMap dataMap;
    @Override
    public void process(ResultItems resultItems, Task task) {
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            System.out.println(entry.getKey() + ":\t" + entry.getValue());
            dataMap.getHashMap().put(entry.getKey(),entry.getValue());
        }
    }
}
