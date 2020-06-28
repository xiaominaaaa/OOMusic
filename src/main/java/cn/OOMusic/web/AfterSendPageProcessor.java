package cn.OOMusic.web;

import cn.OOMusic.pojo.Song;
import cn.OOMusic.web.pipeline.SendPipeline;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;

import javax.xml.bind.Element;
import java.util.ArrayList;
import java.util.List;
@Component
public class AfterSendPageProcessor extends MusicPageProcessor {
    @Autowired
    SendPipeline pipeline;
    Song song;
    public AfterSendPageProcessor() {
    }

    public AfterSendPageProcessor(Site site) {
        super(site);
    }

    @Override
    public void process(Page page) {
        //分析拿到数据装成
        //拿到数据ul
        List<String> list1 = page.getHtml().css(".songlist__list > li").all();
        list = new ArrayList<Song>();
        for ( String string:list1){
            song = new Song();
            document = Jsoup.parse(string);
            element = document.getElementsByClass("js_song").first();
            String href = element.attr("href");
//        System.out.println(); songId
            song.setSongId(href.substring(href.lastIndexOf("/")+1,href.lastIndexOf(".")));

            element = document.getElementsByClass("songlist__songname_txt").first();
            // System.out.println(); songName
            song.setSongName(element.text());

            element = document.getElementsByClass("songlist__time").first();
            String[] time = element.text().split(":");
            int ti = Integer.parseInt(time[0])*60;
            ti += Integer.parseInt(time[1]);
            // System.out.println(ti); playTime
            song.setPlayTime(ti);

            element = document.getElementsByClass("songlist__album").first();
            //System.out.println(element.text()); aloubName
            song.setAlbumName(element.text());

            element = document.getElementsByClass("singer_name").first();
//        System.out.println(element.text()); singer
            song.setSinger(element.text());
            list.add(song);
        }

       page.putField("listdata",list);

    }

    @Override
    public void run(String url) {
        System.setProperty("selenuim_config","D:/OOMusic/src/main/resources/config.ini");
        Spider.create(this).addUrl(url)
                .thread(5)
                .setDownloader(new SeleniumDownloader("D:/study/pachong/chromedriver.exe").setSleepTime(5000))
                .addPipeline(pipeline)
                .run();
    }

}
