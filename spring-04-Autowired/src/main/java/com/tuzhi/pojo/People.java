package com.tuzhi.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @program: spring-study
 * @description:
 * @author: 兔子
 * @create: 2021-11-23 20:34
 **/

@Data
public class People {
    private String name;
    @Resource
    private Cat cat;
    @Autowired
    private Dog dog;
}
