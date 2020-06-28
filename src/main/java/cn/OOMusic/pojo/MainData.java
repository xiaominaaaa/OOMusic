package cn.OOMusic.pojo;

public class MainData {
    private int id;
    private String songName;
    private String image;
    private String singer;
    private String playTime;

    @Override
    public String toString() {
        return "MainData{" +
                "id=" + id +
                ", songName='" + songName + '\'' +
                ", image='" + image + '\'' +
                ", singer='" + singer + '\'' +
                ", playTime='" + playTime + '\'' +
                ", nextUrl='" + nextUrl + '\'' +
                ", play='" + play + '\'' +
                ", type=" + type +
                '}';
    }

    private String nextUrl;
    private String play;
    private int type;

    public MainData(int id, String songName, String image, String singer, String playTime, String nextUrl, int type) {
        this.id = id;
        this.songName = songName;
        this.image = image;
        this.singer = singer;
        this.playTime = playTime;
        this.nextUrl = nextUrl;
        this.type = type;
    }

    public MainData(){}

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
