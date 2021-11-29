package com.tuzhi.diy;

/**
 * @program: spring-study
 * @description: diy
 * @author: 兔子
 * @create: 2021-11-28 15:51
 **/


public class DiyPointCut {

    public void before() {
        System.out.println("======before======");
    }
    public void after() {
        System.out.println("======after======");
    }
}
