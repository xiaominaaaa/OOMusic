package cn.OOMusic.service;

import cn.OOMusic.pojo.Example;
import cn.OOMusic.pojo.Like;
import cn.OOMusic.pojo.Massage;
import cn.OOMusic.pojo.User;

/**
 */
public interface LikeService {
    /**
     * 添加收藏
     * @param like
     * @return
     */
    Massage addLike(Like like);

    /**
     * 删除收藏
     * @param like
     * @return
     */
    Massage deleteLike(Like like);

    /**
     *获取收藏
     * @return
     */
    Example getLikes(int id);

    /**
     * 判断是否已经加入收藏
     */
    Boolean isLike(Like like);
}
