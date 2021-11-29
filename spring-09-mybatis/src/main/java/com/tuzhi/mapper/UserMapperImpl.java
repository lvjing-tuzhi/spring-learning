package com.tuzhi.mapper;

import com.tuzhi.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * @program: spring-study
 * @description:
 * @author: 兔子
 * @create: 2021-11-29 09:04
 **/

public class UserMapperImpl implements UserMapper{

//    SqlSessionTemplate，也就是sqlsession
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> getSelectUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.getSelectUser();
    }
}
