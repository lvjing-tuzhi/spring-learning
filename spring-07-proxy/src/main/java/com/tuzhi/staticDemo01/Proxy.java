package com.tuzhi.staticDemo01;

/**
 * @program: spring-study
 * @description: 中介，代理
 * @author: 兔子
 * @create: 2021-11-26 11:00
 **/


public class Proxy {
    private Host host;

    public Proxy(Host host) {
        this.host = host;
    }

    public void rent() {
        seeHose();
        host.rent();
        cost();
        contract();
    }
    public void seeHose() {
        System.out.println("中介带你看房");
    }
    public void contract() {
        System.out.println("中介和你签合同");
    }
    public void cost() {
        System.out.println("中介收取中介费");
    }
}
