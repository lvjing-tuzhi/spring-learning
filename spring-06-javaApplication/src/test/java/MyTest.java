import com.tuzhi.config.TuzhiConfig;
import com.tuzhi.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring-study
 * @description:
 * @author: 兔子
 * @create: 2021-11-24 23:09
 **/

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TuzhiConfig.class);
        User getUser = context.getBean("getUser", User.class);
        System.out.println(getUser);
    }
}
