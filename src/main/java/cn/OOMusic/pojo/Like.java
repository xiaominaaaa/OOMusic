package cn.OOMusic.pojo;

/**
 * 收藏
 */
public class Like {
    private int userId;
    private int songId;

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
}
