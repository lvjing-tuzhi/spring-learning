package com.tuzhi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

/**
 * @program: spring-study
 * @description: Hello实体类
 * @author: 兔子
 * @create: 2021-11-22 14:58
 **/

@Data
public class HelloT {
    private String name;

    public HelloT() {
        System.out.println("HelloT 被创建");
    }
}
