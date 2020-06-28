package cn.OOMusic.service;

import cn.OOMusic.pojo.Massage;
import cn.OOMusic.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {

    /**
     * 添加用户
     * @param user
     * @return
     */
    Massage addUser(User user);

    /**
     * 根据id找到用户
     * @param userId
     * @return
     */
    User findUser(int userId);

    /**
     *修改密码和用户名
     * @param user
     * @return
     */
    Massage updataPassName(User user);

    /**
     *修改电话号码和邮箱
     * @param user
     * @return
     */
    Massage updataEmailPhone(User user);

    /**
     *用户登录
     * @param user
     * @return
     */
    User login(User user);
}
