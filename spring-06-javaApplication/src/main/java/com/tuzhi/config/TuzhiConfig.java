package com.tuzhi.config;

import com.tuzhi.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-study
 * @description:
 * @author: 兔子
 * @create: 2021-11-24 23:06
 **/

@Configuration
@ComponentScan("com.tuzhi")
public class TuzhiConfig {

    @Bean
    public User getUser() {
        return new User();
    }
}
