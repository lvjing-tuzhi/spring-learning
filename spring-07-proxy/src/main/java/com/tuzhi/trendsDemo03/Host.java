package com.tuzhi.trendsDemo03;


/**
 * @program: spring-study
 * @description: 房东
 * @author: 兔子
 * @create: 2021-11-26 10:59
 **/

public class Host implements Rent{
    @Override
    public void rent() {
        System.out.println("房东要出租房子");
    }
}
