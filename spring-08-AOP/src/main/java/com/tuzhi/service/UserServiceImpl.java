package com.tuzhi.service;

/**
 * @program: spring-study
 * @description:
 * @author: 兔子
 * @create: 2021-11-28 15:14
 **/

public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("添加了一条方法");
    }

    @Override
    public void delete() {
        System.out.println("删除了一条方法");
    }

    @Override
    public void update() {
        System.out.println("更新了一条方法");
    }

    @Override
    public void select() {
        System.out.println("查询了一条方法");
    }
}
