package com.tuzhi.trendsDemo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: spring-study
 * @description: 动态代理类
 * @author: 兔子
 * @create: 2021-11-27 11:35
 **/

public class ProxyInvocationHandler implements InvocationHandler {
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        Object invoke = method.invoke(rent, args);
        return invoke;
    }

    public void log(String msg) {
        System.out.println("【log】:" + msg);
    }
}
