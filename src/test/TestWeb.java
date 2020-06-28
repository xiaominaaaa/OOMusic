import cn.OOMusic.web.AfterSendPageProcessor;
import cn.OOMusic.web.MusicMianPageProcessor;
import cn.OOMusic.web.SendPageProcessor;
import cn.OOMusic.web.SongPageProcessor;
import us.codecraft.webmagic.Site;

public class TestWeb {

    public static void main(String[] args) {
        new SongPageProcessor().run("");
    }
}
