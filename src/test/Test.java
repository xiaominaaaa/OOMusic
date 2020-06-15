import cn.OOMusic.mapper.UserMapper;
import cn.OOMusic.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory factory =  new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = factory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);

        List<User> users = mapper.select();
        for (User user : users){
            System.out.println(user);
        }
    }
}
