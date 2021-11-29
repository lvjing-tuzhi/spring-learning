package com.tuzhi.trendsDemo03;

/**
 * @program: spring-study
 * @description: 客户类
 * @author: 兔子
 * @create: 2021-11-27 11:39
 **/

public class Client {
    public static void main(String[] args) {
//        真实用户
        Host host = new Host();
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setRent(host);
        Rent proxy = (Rent) pih.getProxy();
        proxy.rent();
    }
}
