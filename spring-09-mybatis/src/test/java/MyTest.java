import com.tuzhi.mapper.UserMapper;
import com.tuzhi.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * @program: spring-study
 * @description:
 * @author: 兔子
 * @create: 2021-11-28 20:48
 **/

public class MyTest {

    @Test
    public void getUser() {
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> selectUser = mapper.getSelectUser();
        for (User user : selectUser) {
            System.out.println(user);
        }
    }

    @Test
    public void getUserSpring() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper2", UserMapper.class);
        List<User> selectUser = userMapper.getSelectUser();
        for (User user : selectUser) {
            System.out.println(user);
        }
    }

}
