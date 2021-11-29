package com.tuzhi.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @program: spring-study
 * @description: 后置日志
 * @author: 兔子
 * @create: 2021-11-28 15:11
 **/

public class AfterLog implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("[AfterLog]" + method.getName() + o);
    }
}
