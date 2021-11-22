package com.tuzhi.dao;

/**
 * @program: spring-study
 * @description: 用户dao层接口层
 * @author: 兔子
 * @create: 2021-11-22 13:24
 **/

public class UserDaoImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.println("UserDaoImpl");
    }
}
