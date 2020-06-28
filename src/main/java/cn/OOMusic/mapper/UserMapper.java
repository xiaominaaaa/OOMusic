package cn.OOMusic.mapper;
import cn.OOMusic.pojo.Massage;
import cn.OOMusic.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> select();
    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 根据id找到用户
     * @param userId
     * @return
     */
    User findUser(int userId);

    /**
     * 修改
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

}
