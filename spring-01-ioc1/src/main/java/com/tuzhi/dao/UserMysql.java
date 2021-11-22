package com.tuzhi.dao;

/**
 * @program: spring-study
 * @description:
 * @author: 兔子
 * @create: 2021-11-22 13:32
 **/

public class UserMysql implements UserDao{
    @Override
    public void getUser() {
        System.out.println("UserMysql");
    }
}
