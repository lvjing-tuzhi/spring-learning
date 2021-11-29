package com.tuzhi.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @program: spring-study
 * @description: 注解实现AOP
 * @author: 兔子
 * @create: 2021-11-28 18:33
 **/

@Aspect
public class AnnotationPointCut {

//    前置切片插入点
    @Before("execution(* com.tuzhi.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("======AnnotationBefore======");
    }

    //    后置切片插入点
    @After("execution(* com.tuzhi.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("======AnnotationAfter======");
    }

//    环绕切点
    @Around("execution(* com.tuzhi.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint joinPoint) {
        System.out.println("环绕前");
        try {
            Object proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕后");
    }

}
