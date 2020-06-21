package cn.OOMusic.pojo;

import java.util.List;

/**
 *歌单
 */
public class PlayList {
    private int id;
    private int userId;
    private int songId;
    private String playlistName;
    private String playlistNum;
    private List<Song> songList;

    @Override
    public String toString() {
        return "PlayList{" +
                "id=" + id +
                ", userId=" + userId +
                ", songId=" + songId +
                ", playlistName='" + playlistName + '\'' +
                ", playlistNum='" + playlistNum + '\'' +
                ", songList=" + songList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistNum() {
        return playlistNum;
    }

    public void setPlaylistNum(String playlistNum) {
        this.playlistNum = playlistNum;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
}
