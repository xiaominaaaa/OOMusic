package cn.OOMusic.service.impl;

import cn.OOMusic.mapper.UserMapper;
import cn.OOMusic.pojo.Massage;
import cn.OOMusic.pojo.User;
import cn.OOMusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;



    @Override
    public Massage addUser(User user) {
            if(userMapper.addUser(user) >0 ){
                return new Massage(200,"添加用户成功");
            }
                return new Massage(500,"添加用户失败");

    }



    @Override
    public User findUser(int userId) {
        return userMapper.findUser(userId);
    }

    @Override
    public Massage updataPassName(User user) {
        return userMapper.update(user)>0?new Massage(200,"修改成功"):new Massage(500,"修改失败");
    }

    @Override
    public Massage updataEmailPhone(User user) {
        return userMapper.update(user)>0?new Massage(200,"修改成功"):new Massage(500,"修改失败");
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
