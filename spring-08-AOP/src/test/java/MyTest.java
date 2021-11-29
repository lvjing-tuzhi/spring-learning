import com.tuzhi.service.UserService;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring-study
 * @description:
 * @author: 兔子
 * @create: 2021-11-28 15:24
 **/
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        切片是面向接口
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}
