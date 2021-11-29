import com.tuzhi.mapper.UserMapper;
import com.tuzhi.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @program: spring-study
 * @description:
 * @author: 兔子
 * @create: 2021-11-29 18:24
 **/

public class MyTest {
    @Test
    public void getSelectUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper selectUser = context.getBean("userMapper", UserMapper.class);
        List<User> userList = selectUser.selectUser();
        for (User user : userList) {
            System.out.println(user);
        }
    }
    @Test
    public void addUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper selectUser = context.getBean("userMapper", UserMapper.class);
        int user = selectUser.addUser(new User(6, "shiwu", "123456"));
        System.out.println(user);
    }
    @Test
    public void deleteUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper selectUser = context.getBean("userMapper", UserMapper.class);
        int user = selectUser.deleteUser(6);
        System.out.println(user);
    }
}
