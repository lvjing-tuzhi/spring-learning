package com.tuzhi.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @program: spring-study
 * @description:
 * @author: 兔子
 * @create: 2021-11-23 16:17
 **/

@Data
public class Student {
    private String name;
    private Address address;
    private String[] books;
    private List<String> hobby;
    private Map<String,String> card;
    private Set<String> games;
    private String wife;
    private Properties info;

}
