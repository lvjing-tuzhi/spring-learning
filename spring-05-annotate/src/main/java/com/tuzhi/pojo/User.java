package com.tuzhi.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: spring-study
 * @description:
 * @author: 兔子
 * @create: 2021-11-24 22:17
 **/

@Data
@Component
public class User {
    @Value("吕竟")
    private String name;
}
