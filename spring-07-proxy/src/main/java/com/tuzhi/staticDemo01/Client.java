package com.tuzhi.staticDemo01;

/**
 * @program: spring-study
 * @description: 客户
 * @author: 兔子
 * @create: 2021-11-26 11:01
 **/

public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        Proxy proxy = new Proxy(host);
        proxy.rent();
    }
}
