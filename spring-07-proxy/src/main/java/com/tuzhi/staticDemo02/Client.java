package com.tuzhi.staticDemo02;

/**
 * @program: spring-study
 * @description:
 * @author: 兔子
 * @create: 2021-11-26 11:32
 **/

public class Client {
    public static void main(String[] args) {
        UserServiceImp userServiceImp = new UserServiceImp();
        UserServiceProxy userServiceProxy = new UserServiceProxy();
        userServiceProxy.setUserService(userServiceImp);
        userServiceProxy.add();
    }
}
