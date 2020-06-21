import cn.OOMusic.web.MusicMianPageProcessor;
import us.codecraft.webmagic.Site;

public class TestWeb {

    public static void main(String[] args) {
        new MusicMianPageProcessor(Site.me()).run();
    }
}
