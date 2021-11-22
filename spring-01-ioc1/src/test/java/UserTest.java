import com.tuzhi.dao.UserMysql;
import com.tuzhi.dao.UserOraclo;
import com.tuzhi.service.UserServiceImpl;
import org.junit.Test;

/**
 * @program: spring-study
 * @description: 用户测试类
 * @author: 兔子
 * @create: 2021-11-22 13:29
 **/

public class UserTest {

    @Test
    public void getUser() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserOraclo());
        userService.getUser();
    }

}
