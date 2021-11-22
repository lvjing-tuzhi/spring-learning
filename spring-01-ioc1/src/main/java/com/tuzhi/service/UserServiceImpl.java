package com.tuzhi.service;

import com.tuzhi.dao.UserDao;
import com.tuzhi.dao.UserDaoImpl;

/**
 * @program: spring-study
 * @description: 用户业务层实现类
 * @author: 兔子
 * @create: 2021-11-22 13:25
 **/

public class UserServiceImpl implements UserService{
    private UserDao userDao;

//    ioc原型
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

//    public UserServiceImpl() {
//        userDao = new UserDaoImpl();
//    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
