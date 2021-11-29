# 1、创建一个maven,spring项目

## 1.1、maven配置

~~~xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.0.RELEASE</version>
</dependency>

~~~

## 1.2、bean的配置

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="..." class="...">  
        <!-- collaborators and configuration for this bean go here -->
    </bean>

</beans>
~~~



# 2、IOC原型

## 2.1、UserDao接口

~~~java
public interface UserDao {
    void getUser();
}
~~~

## 2.2、UserDao实现类

~~~java
public class UserDaoImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.println("UserDaoImpl");
    }
}
~~~

~~~java
public class UserMysql implements UserDao{
    @Override
    public void getUser() {
        System.out.println("UserMysql");
    }
}
~~~

~~~java
public class UserOraclo implements UserDao{
    @Override
    public void getUser() {
        System.out.println("UserOraclo");
    }
}
~~~

## 2.3、业务层接口

~~~java
public interface UserService {
    void getUser();
}

~~~

## 2.4、业务层实现类

~~~java
public class UserServiceImpl implements UserService{
    private UserDao userDao;

//    ioc原型
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}

~~~

# 3、依赖注入dl

## 3.1、Collections注入

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="adress" class="com.tuzhi.pojo.Address"/>

    <bean id="student" class="com.tuzhi.pojo.Student">
        <!--   普通值注入，value-->
        <property name="name" value="吕静"/>
        <!--    对象注入-->
        <property name="address" ref="adress"></property>
        <!--        数组注入-->
        <property name="books">
            <array>
                <value>aArray</value>
                <value>bArray</value>
            </array>
        </property>
        <!--        List依赖-->
        <property name="hobby">
            <list>
                <value>oneList</value>
                <value>twoList</value>
            </list>
        </property>
        <!--        Map依赖-->
        <property name="card">
            <map>
                <entry key="1" value="one"/>
                <entry key="2" value="Two"/>
            </map>
        </property>
        <!--        Set依赖-->
        <property name="games">
            <set>
                <value>aSet</value>
                <value>bSet</value>
            </set>
        </property>
        <!--        注入空null-->
        <property name="wife">
            <null></null>
        </property>
        <!--        属性注入-->
        <property name="info">
            <props>
                <prop key="drive">com</prop>
                <prop key="url">127.0.0.1</prop>
                <prop key="username">root</prop>
                <prop key="password">root</prop>
            </props>
        </property>
    </bean>
</beans>
~~~

## 3.2、p-namespace方式注入

* 添加xmlns

   ~~~xml
   xmlns:p="http://www.springframework.org/schema/p"
   ~~~

* 使用

  ~~~xml
  <bean name="p-namespace" class="com.example.ExampleBean"
          p:email="someone@somewhere.com"/>
  ~~~

## 3.3、c-namespace方式注入构造器

* 添加xmlns

  ~~~xml
   xmlns:c="http://www.springframework.org/schema/c"
  ~~~

* 使用

  ~~~xml
  <bean id="beanOne" class="x.y.ThingOne" c:thingTwo-ref="beanTwo"
        c:thingThree-ref="beanThree" c:email="something@somewhere.com"/>
  
  ~~~


## 3.4、Bean Scopes bean的作用域

* 单例模式：默认机制

  ~~~xml
  <bean id="accountService" class="com.something.DefaultAccountService" scope="singleton"/>
  ~~~

  每次取出的值地址都相等都是从一个地方取出来

* 原型模式

  ~~~xml
  <bean id="accountService" class="com.something.DefaultAccountService" scope="prototype"/>
  ~~~

  每次从容器中get的时候，都会产生一个新对象

# 4.自动装配Bean

## 4.1、autowire属性

* autowire="byName"

  ~~~xml
  <bean id="cat" class="com.tuzhi.pojo.Cat"/>
      <bean id="dog" class="com.tuzhi.pojo.Dog"/>
  
      <bean id="people" class="com.tuzhi.pojo.People" autowire="byName"/>
  ~~~

* autowire="byType"

  ~~~xml
  <bean class="com.tuzhi.pojo.Cat"/>
      <bean class="com.tuzhi.pojo.Dog"/>
  
      <bean id="people" class="com.tuzhi.pojo.People" autowire="byType"/>
  
  ~~~

  

## 4.2、使用注解进行装配

* 进行配置，在xml中添加context

  ~~~xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns:context="http://www.springframework.org/schema/context"
         xsi:schemaLocation="http://www.springframework.org/schema/beans
          https://www.springframework.org/schema/beans/spring-beans.xsd
          http://www.springframework.org/schema/context
          https://www.springframework.org/schema/context/spring-context.xsd">
  
      
      <context:annotation-config/>
  
  </beans>
  ~~~

* 使用

  ~~~java
  @Data
  public class People {
      private String name;
      @Autowired
      private Cat cat;
      @Autowired
      private Dog dog;
  }
  
  ~~~

  注意@Autowired与@Resource区别：@Autowired更常用，@Resource更灵活可以加参数，但是效率更低
## 5、java的applicationContext.xml配置
* config配置，TuzhiConfig.java
  ~~~java
    @Configuration
    @ComponentScan("com.tuzhi")
    public class TuzhiConfig {
    
        @Bean
        public User getUser() {
            return new User();
        }
    }
  ~~~
* 实体类
  ~~~java
    @Data
    @Component
    public class User {
    
        @Value("吕竟Java")
        private String name;
    }
  
  ~~~
* 测试
  ~~~java
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TuzhiConfig.class);
        User getUser = context.getBean("getUser", User.class);
        System.out.println(getUser);
    }
  ~~~
# 5、静态代理
* 不修改原有代码，功能更纯粹，使用一个中介来进行代理
* 抽象类
  ~~~java
    public interface Rent {
      void rent();
    }
  
  ~~~
* 房东类
  ~~~java
    public class Host implements Rent{
      @Override
      public void rent() {
          System.out.println("房东要出租房子");
        }
    }
  
  ~~~
* 代理类，最重要的，通过此类给其他的类添加更多的附加功能，便于维护和后期扩展
  ~~~java
    public class Proxy {
    private Host host;
  
    public Proxy(Host host) {
        this.host = host;
    }
  
    public void rent() {
        seeHose();
        host.rent();
        cost();
        contract();
    }
    public void seeHose() {
        System.out.println("中介带你看房");
    }
    public void contract() {
        System.out.println("中介和你签合同");
    }
    public void cost() {
        System.out.println("中介收取中介费");
    }
  } 
  ~~~
* 客户类
  ~~~java
    public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        Proxy proxy = new Proxy(host);
        proxy.rent();
    }
  }
  ~~~

# 6、AOP面向切面
##7.1、方式一使用spingapi，接口实现
### 6.1.1、添加maven依赖
~~~xml
<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.6</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjrt</artifactId>
    <version>1.6.11</version>
</dependency>

~~~
### 6.1.2、前置日志
* 实现MethodBeforeAdvice接口
~~~java
public class BeforeLog implements MethodBeforeAdvice {
  @Override
  public void before(Method method, Object[] objects, Object o) throws Throwable {
    System.out.println("[BeforLoge]" + method.getClass().getName() + "   :" + method.getName());
  }
}
~~~
### 6.1.3、后置日志
* 实现AfterReturningAdvice接口
~~~java
public class AfterLog implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("[AfterLog]" + method.getName() + o);
    }
}
~~~
### 6.1.4、配置applicationContext.xml
* 添加bean依赖
~~~xml
xmlns:aop="http://www.springframework.org/schema/aop"
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd
        ">
~~~

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"

       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd
        ">

    <bean id="userService" class="com.tuzhi.service.UserServiceImpl"/>
    <bean id="beforeLog" class="com.tuzhi.log.BeforeLog"/>
    <bean id="afterLog" class="com.tuzhi.log.AfterLog"/>

<!--    配置AOP-->
    <aop:config>
<!--        切入点 expression切入点表达式，要切入点位置  -->
        <aop:pointcut id="pointcut" expression="execution(* com.tuzhi.service.UserServiceImpl.*(..))"/>

<!--        执行环绕增强-->
        <aop:advisor advice-ref="beforeLog" pointcut-ref="pointcut"/>
        <aop:advisor advice-ref="afterLog" pointcut-ref="pointcut"/>

    </aop:config>

</beans>
~~~
### 6.1.5、测试
~~~java
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        切片是面向接口
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
~~~
## 6.2、实现方式二，自定义
### 6.2.1、创建自定义类
~~~java
public class DiyPointCut {
    public void before() {
        System.out.println("======before======");
    }
    public void after() {
        System.out.println("======after======");
    }
}
~~~
### 6.2.2、配置bean
~~~xml
<!--    AOP实现方式二，使用自定义-->
    <bean id="diy" class="com.tuzhi.diy.DiyPointCut"/>
    <aop:config>
        <aop:pointcut id="pointcut" expression="execution(* com.tuzhi.service.UserServiceImpl.*(..))"/>
        <aop:aspect ref="diy">
            <aop:before method="before" pointcut-ref="pointcut"/>
            <aop:after method="after" pointcut-ref="pointcut"/>
        </aop:aspect>
    </aop:config>
~~~
### 6.2.3、测试
~~~java
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        切片是面向接口
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
~~~
## 6.2、实现方式三，使用注解
### 6.2.1、配置beans
~~~xml
<!--    AOP实现方式三，使用注解-->
<!--    注册bean-->
    <bean id="annotationPoingtCut" class="com.tuzhi.diy.AnnotationPointCut"/>
<!--    开启注解支持-->
    <aop:aspectj-autoproxy/>
~~~
### 6.2.2 使用注解实现
~~~java
@Aspect
public class AnnotationPointCut {

//    前置切片插入点
    @Before("execution(* com.tuzhi.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("======AnnotationBefore======");
    }

    //    后置切片插入点
    @After("execution(* com.tuzhi.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("======AnnotationAfter======");
    }

//    环绕切点
    @Around("execution(* com.tuzhi.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint joinPoint) {
        System.out.println("环绕前");
        try {
            Object proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕后");
    }

}
~~~
### 6.3.3、测试
~~~java
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        切片是面向接口
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
~~~

# 7、spring整合mybatis

## 7.1、第一种整合

* 创建一个spring-do.xml

  ~~~xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns:context="http://www.springframework.org/schema/context"
         xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">
  
  <!--    配置数据库，也就是mybatis-config.xml中的dataSource-->
      <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
          <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
          <property name="url" value="jdbc:mysql://localhost:3306/mybatis?serverTimezone=Asia/Shanghai&amp;useSSL=true&amp;useUnicode=true&amp;characterEncoding=utf-8"/>
          <property name="username" value="root"/>
          <property name="password" value="root"/>
      </bean>
  
  <!--    sqlSessionFactory-->
      <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
  <!--        绑定数据源（数据库）-->
          <property name="dataSource" ref="dataSource"/>
  <!--        mybatis文件配置-->
  <!--        <property name="configLocation" value="classpath:mybatis-config.xml"/>-->
  <!--        绑定mapper-->
          <property name="mapperLocations" value="com/tuzhi/mapper/*.xml"/>
      </bean>
  <!--    SqlSessionTemplate就是sqlSession-->
      <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
  <!--        有参构造值注入-->
          <constructor-arg index="0" ref="sqlSessionFactory"/>
      </bean>
  
  </beans>
  ~~~

* 创建一个接口实现类

  ~~~java
  public class UserMapperImpl implements UserMapper{
  
  //    SqlSessionTemplate，也就是sqlsession
      private SqlSessionTemplate sqlSession;
  
      public void setSqlSession(SqlSessionTemplate sqlSession) {
          this.sqlSession = sqlSession;
      }
  
      @Override
      public List<User> getSelectUser() {
          UserMapper mapper = sqlSession.getMapper(UserMapper.class);
          return mapper.getSelectUser();
      }
  }
  ~~~

* 在applicationContext.xml中导入spring-do配置并且注册实现类，并注入值

  ~~~xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns:context="http://www.springframework.org/schema/context"
         xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">
  
      <import resource="spring-do.xml"/>
  
  <!--    方式一，把sqlSessionFactory注入到sqlSession，然后再把sqlSeesion注入到实现类中-->
      <bean id="userMapper" class="com.tuzhi.mapper.UserMapperImpl">
          <!--        把SqlSessionTemplate就是sqlSession给userMapperImpl中的sqlSession变量-->
          <property name="sqlSession" ref="sqlSession"/>
      </bean>
  </beans>
  ~~~

* 测试

  ~~~java
  @Test
      public void getUserSpring() {
          ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
          UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
          List<User> selectUser = userMapper.getSelectUser();
          for (User user : selectUser) {
              System.out.println(user);
          }
      }
  ~~~

## 7.2、第二种整合

* 实现类继承SqlSessionDaoSupport，来直接获得sqlSession

  ~~~java
  public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {
      @Override
      public List<User> getSelectUser() {
  //        SqlSession sqlSession = getSqlSession();
  //        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
  //        return mapper.getSelectUser();
          return getSqlSession().getMapper(UserMapper.class).getSelectUser();
      }
  }
  ~~~

* 注册实体类

  ~~~java
  <!--    方式二，直接把把sqlSessionFactory注入到实现类中-->
      <bean id="userMapper2" class="com.tuzhi.mapper.UserMapperImpl2">
          <property name="sqlSessionFactory" ref="sqlSessionFactory"/>
      </bean>
  ~~~

* 测试

  ~~~java
  @Test
      public void getUserSpring() {
          ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
          UserMapper userMapper = context.getBean("userMapper2", UserMapper.class);
          List<User> selectUser = userMapper.getSelectUser();
          for (User user : selectUser) {
              System.out.println(user);
          }
      }  
  ~~~

# 8、spring声名式事务

* 在spring-do.xml或者在applicationContext.xml中配置

  ~~~xml
  <tx:advice id="txAdvice" transaction-manager="transactionManager">
          <tx:attributes>
              <tx:method name="add*"/>
              <tx:method name="delete*"/>
              <tx:method name="update*"/>
              <tx:method name="query*"/>
              <tx:method name="*" rollback-for="java.lang.Exception"/>
          </tx:attributes>
      </tx:advice>
  
      <aop:config>
          <aop:pointcut id="txPointCut" expression="execution(* com.tuzhi.mapper.*.*(..))"/>
          <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointCut"/>
      </aop:config>
  ~~~

  ## 注

  在mysql数据库中 myisam引擎不支持事务，innodb引擎支持事务，把表修改为innodb
