package cn.OOMusic.web;

import cn.OOMusic.web.MusicPageProcessor;
import cn.OOMusic.web.pipeline.SendPipeline;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;

import javax.xml.bind.Element;

@Component
public class SongPageProcessor extends MusicPageProcessor {
    @Autowired
    SendPipeline pipeline;
    @Override
    public void run(String url) {
        Spider.create(this)
                .addUrl(url)
                .addPipeline(pipeline)
                .thread(5).run();
    }

    public SongPageProcessor() {
        super();
    }

    public SongPageProcessor(Site site) {
        super(site);
    }

    @Override
    public void process(Page page) {
        element  = Jsoup.parse(page.getHtml().css(".data__photo").get());
        page.putField("songimg",element.getElementsByClass("data__photo").first().attr("src"));
    }
}
