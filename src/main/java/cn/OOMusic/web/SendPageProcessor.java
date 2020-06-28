package cn.OOMusic.web;

import cn.OOMusic.web.pipeline.SendPipeline;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;

@Component
public class SendPageProcessor extends MusicPageProcessor {

    public SendPageProcessor() {
        this.setSite(Site.me());
    }

    public SendPageProcessor(Site site) {
        super(site);
    }

    @Autowired
    SendPipeline pipeline;

    @Override
    public void process(Page page) {
        //拿到里面的数据 一般是个json
        document = Jsoup.parse(page.getHtml().toString());
        page.putField("data",document.text());
    }

    @Override
    public void run(String url) {
        Spider.create(this)
                .addPipeline(pipeline)
                .thread(10)
                .addUrl(url).run();
    }


}
