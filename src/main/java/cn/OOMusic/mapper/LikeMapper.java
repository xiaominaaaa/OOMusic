package cn.OOMusic.mapper;

import cn.OOMusic.pojo.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeMapper {
    /**
     * 添加收藏
     * @param like
     * @return
     */
    int addLike(Like like);

    /**
     * 删除收藏
     * @param like
     * @return
     */
    int deleteLike(Like like);

    /**
     *获取收藏
     * @return
     */
    List getLikes(int id);

    /**
     * 判断是否已经加入收藏
     */
    int isLike(Like like);
}
