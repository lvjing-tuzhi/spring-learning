# 1、创建一个maven项目

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