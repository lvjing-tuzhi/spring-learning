package com.tuzhi.staticDemo02;

/**
 * @program: spring-study
 * @description:
 * @author: 兔子
 * @create: 2021-11-26 11:27
 **/

public class UserServiceImp implements UserService{
    @Override
    public void add() {
        System.out.println("添加一条记录");
    }

    @Override
    public void select() {
        System.out.println("查询一条记录");
    }

    @Override
    public void delete() {
        System.out.println("删除一条记录");
    }

    @Override
    public void update() {
        System.out.println("修改一条记录");
    }
}
