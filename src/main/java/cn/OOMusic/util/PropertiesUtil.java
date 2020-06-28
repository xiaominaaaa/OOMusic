package cn.OOMusic.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

/**
 *读取oomusic的配置文件类
 */
@Component
public class PropertiesUtil {
        private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public PropertiesUtil(){
        this.properties = new Properties();
        try {
            properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("ooconfig.properties"));
        } catch (IOException e) {
            System.out.println("加载oomuisic配置文件失败");
            e.printStackTrace();
        }
    }
}
