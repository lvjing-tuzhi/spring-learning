package com.tuzhi.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @program: spring-study
 * @description: 前置日志
 * @author: 兔子
 * @create: 2021-11-28 15:09
 **/

public class BeforeLog implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("[BeforLoge]" + method.getClass().getName() + "   :" + method.getName());
    }
}
