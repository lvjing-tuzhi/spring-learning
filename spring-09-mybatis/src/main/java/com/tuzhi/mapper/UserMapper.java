package com.tuzhi.mapper;

import com.tuzhi.pojo.User;

import java.util.List;

/**
 * @program: spring-study
 * @description:
 * @author: 兔子
 * @create: 2021-11-28 20:22
 **/

public interface UserMapper {
    List<User> getSelectUser();
}
