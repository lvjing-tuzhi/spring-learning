package com.tuzhi.mapper;

import com.tuzhi.pojo.User;

import java.util.List;

/**
 * @program: spring-study
 * @description:
 * @author: 兔子
 * @create: 2021-11-29 17:42
 **/

public interface UserMapper {
    List<User> selectUser();
    int addUser(User user);
    int deleteUser(int id);
}
