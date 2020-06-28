package cn.OOMusic.web;

import cn.OOMusic.pojo.MainData;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

public abstract class MusicPageProcessor implements PageProcessor {
    //文档对象
    Document document;

    //容器，包装song对象
    List list;
    //获取节点
    Element element;

    /**
     * 爬虫相关配置
     */
    private Site site;


    public void setSite(Site site){
        this.site = site;
    }

    @Override
    public Site getSite() {
        return site;
    }

    public MusicPageProcessor(){this.setSite(Site.me());}

    public MusicPageProcessor(Site site){
        this.site = site;
    }

    public abstract void  run(String url);
}
