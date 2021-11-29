package com.tuzhi.staticDemo02;

/**
 * @program: spring-study
 * @description:
 * @author: 兔子
 * @create: 2021-11-26 11:29
 **/

public class UserServiceProxy implements UserService{
    private UserService userServiceImp;

    public void setUserService(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @Override
    public void add() {
        log("add");
        userServiceImp.add();
    }

    @Override
    public void select() {
        log("select");
        userServiceImp.select();
    }

    @Override
    public void delete() {
        log("delete");
        userServiceImp.delete();
    }

    @Override
    public void update() {
        log("update");
        userServiceImp.update();
    }

    public void log(String name) {
        System.out.println("[deBug]" + name + "添加一条日志");
    }
}
