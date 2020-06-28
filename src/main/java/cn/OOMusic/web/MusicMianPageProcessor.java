package cn.OOMusic.web;

import cn.OOMusic.mapper.MainMapper;
import cn.OOMusic.pojo.MainData;
import cn.OOMusic.pojo.Song;
import cn.OOMusic.util.Constant;
import cn.OOMusic.util.PropertiesUtil;
import cn.OOMusic.web.pipeline.MainPipeline;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;
import us.codecraft.webmagic.selector.Selector;

import javax.annotation.PostConstruct;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * 取到主页数据的爬虫程序
 */
@Component
public class MusicMianPageProcessor extends MusicPageProcessor {
    //中介的主页数据对象;
    MainData data;
    //配置类对象
    @Autowired
    PropertiesUtil propertiesUtil;
    @Autowired
    MainPipeline pipeline;
    /**
     * 为了使初始化主页数据时不报空指针异常
     */
    @Autowired
    MainMapper mainMapper;


    public MusicMianPageProcessor() {
    }

    public MusicMianPageProcessor(Site site) {
        super(site);
    }


    @Override
    public void process(Page page) {
//        //文档对象
//        Document document;
//        //中介的主页数据对象;
//        MainData data;
//        //容器，包装song对象
//        List list;
//        //获取节点
//        Element element;
        //拿到歌单推荐 5条
        List<String> s1 =  page.getHtml().css("ul[class=playlist__list slide__list] > li").all();
        page.putField("gedan",getGedan(s1));

        //拿到新歌首发 9条
        s1 = page.getHtml().css(".songlist__list > li").all();
        page.putField("newsong",getnewSong(s1));


        //拿到新碟首发 正常获取是10条 ，但是不一定每天都能爬到10条
        s1 =  page.getHtml().css(".playlist__list>li").all().subList(5,page.getHtml().css(".playlist__list>li").all().size());
        page.putField("newdie",getNewDie(s1));

        //拿到排行榜 15条
        s1 = page.getHtml().css(".mod_toplist").css(".toplist__song").all();
        page.putField("top",getTop(s1));

    }

    /**
     * 获取排行榜数据
     * @return
     */
    private List<MainData> getTop(List<String> s2) {
        //准备原始封装数据
        list = new ArrayList<MainData>();
        for (String string : s2) {
            data = new MainData();
            document = Jsoup.parse(string);
            element = document.getElementsByClass("toplist__songname").first();
//        System.out.println(element.text()); songName
            data.setSongName(element.text());

            element = document.getElementsByClass("toplist__artist").first();
//        System.out.println(element.text()); singer
            data.setSinger(element.text());

            //设置类型为3
            data.setType(3);
            list.add(data);
        }
        return list;
    }


    /**
     * 获取新碟首发
     * @return
     */
    private List<MainData> getNewDie(List<String> s2) {
        //准备原始封装数据
        list = new ArrayList<MainData>();
        for (String string : s2) {
            data = new MainData();
            document = Jsoup.parse(string);
            //  System.out.println(document);
            element = document.getElementsByClass("playlist__title").get(0);
    //        System.out.println(element.text()); songName
            data.setSongName(element.text());
            element = document.getElementsByClass("playlist__pic").get(0);
            // System.out.println(element.attr("src")); image
            data.setImage(element.attr("src"));
            element = document.getElementsByClass("playlist__author").get(0);
//        System.out.println(element.text()); singer
            data.setSinger(element.text());
            //设置类型为2
            data.setType(2);
            list.add(data);
        }
        return list;
    }

    /**
     * 获取歌单推荐
     * @return
     */
    private List<MainData> getGedan(List<String> s2){
        //准备原始封装数据
        list = new ArrayList<MainData>();
        for (String string: s2){
            document = Jsoup.parse(string);
            //初始化歌曲
            data = new MainData();
            document = Jsoup.parse(string);
            //  System.out.println(document);
            element = document.getElementsByClass("playlist__title_txt").get(0);
            // System.out.println(); songName
            data.setSongName(element.text());

            element = document.getElementsByClass("playlist__cover mod_cover").get(0).getElementsByClass("js_playlist").get(0);
            // System.out.println(Constant.HTTP+element.attr("href"));  nextUrl
            data.setNextUrl(Constant.HTTP+element.attr("href"));

            // System.out.println(element.child(0).attr("src")); image
            data.setImage(element.child(0).attr("src"));

            element = document.getElementsByClass("playlist__other").get(0);
            // System.out.println(element.text().substring(4)); play
            data.setPlay(element.text().substring(4));

            //设置类型为0
            data.setType(0);
            list.add(data);
        }

        return this.list;
    }

    /**
     * 获取新歌首发
     * @return
     */
    private List<MainData> getnewSong(List<String> s1){
        list = new ArrayList<MainData>();
        for (String string:s1){
            data = new MainData();
            document = Jsoup.parse(string);
            //  System.out.println(document);
            element = document.getElementsByClass("songlist__song").get(0);
            //System.out.println(element.text());
            data.setSongName(element.text());

            element = document.getElementsByClass("songlist__pic").first();
        //  System.out.println(element.attr("src"));
            data.setImage(element.attr("src"));

            element = document.getElementsByClass("songlist__author").first();
            // System.out.println(element.text());
            data.setSinger(element.text());

            //设置类型为1
            data.setType(1);
            list.add(data);
        }

        return list;
    }

    /**
     * bean初始化之后就加载的
     * @param url
     */
    @Override
    public void run(String url){
        Spider.create(this)
                .thread(5) //开启五个线程抓取
                .addUrl(url)
                .addPipeline(pipeline)
                .run();
    }

    /**
     * 加载首页数据
     */
    @PostConstruct
    public void init(){
        run(propertiesUtil.getProperties().getProperty("maindata"));
    }

}
