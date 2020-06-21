package cn.OOMusic.service.impl;

import cn.OOMusic.mapper.LikeMapper;
import cn.OOMusic.pojo.*;
import cn.OOMusic.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeMapper likeMapper;

    @Override
    public Massage addLike(Like like) {
        return likeMapper.addLike(like) > 0 ? new Massage(200,"增加用户成功"):new Massage(500,"增加用户失败");
    }

    @Override
    public Massage deleteLike(Like like) {
        return likeMapper.deleteLike(like) > 0 ? new Massage(200,"删除用户成功"):new Massage(500,"删除用户失败");

    }

    @Override
    public Example getLikes(int id) {
        Example<Song> example = new Example<Song>();
        example.setList( likeMapper.getLikes(id));
        return example;
    }

    @Override
    public Boolean isLike(Like like) {
        return likeMapper.isLike(like)>0;
    }
}
