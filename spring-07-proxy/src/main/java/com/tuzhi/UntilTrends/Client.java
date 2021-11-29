package com.tuzhi.UntilTrends;

import com.tuzhi.staticDemo02.UserService;
import com.tuzhi.staticDemo02.UserServiceImp;

/**
 * @program: spring-study
 * @description: 客户类
 * @author: 兔子
 * @create: 2021-11-27 11:52
 **/

public class Client {
    public static void main(String[] args) {
        UserServiceImp userServiceImp = new UserServiceImp();
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setTarget(userServiceImp);
        UserService proxy = (UserService) pih.getProxy();
        proxy.add();
    }
}
