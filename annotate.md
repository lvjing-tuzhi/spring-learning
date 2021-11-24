# applicationContext.xml配置
~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     xmlns:context="http://www.springframework.org/schema/context"
     xsi:schemaLocation="http://www.springframework.org/schema/beans
      https://www.springframework.org/schema/beans/spring-beans.xsd
      http://www.springframework.org/schema/context
      https://www.springframework.org/schema/context/spring-context.xsd">
    
<!--  指定要扫描到包，这个包下的注解就会生效-->
  <context:component-scan base-package="com.tuzhi"/>
<!--  注解驱动-->
  <context:annotation-config/>

  <bean class="com.tuzhi.pojo.Cat"/>

</beans>
~~~
# 注解说明
* @Scope():作用域，有单例模式和原型模式
* @Autowired:自动装配通过类型，名字。如果Autowired不能唯一自动
  装配上属性，则需要@Qualifiter(value="xxxxx")。
* @Nullable：字段标记了这个注解，说明这个类型可以为null。
* @Resource：自动装配通过名字类型。
* @Value():值注入 
* @Component：放在类上，说明该类被Spring管理了，就是bean
  <bean id="people" class="com.tuzhi.pojo.People"/>
  衍生类：功能相同，名字不同
  * dao[@Repository]
  * service[@Service]
  * controller[Controller]
* @Configuration:放在类上，这个类就变成配置类，相当于Beans
* @Bean：相当于bean放在方法上
* @ComponentScan:包扫描等价于<context:component-scan base-package="com.tuzhi"/>
* @Import():相当于xml的导入

