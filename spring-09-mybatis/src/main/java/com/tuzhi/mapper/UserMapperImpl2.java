package com.tuzhi.mapper;

import com.tuzhi.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @program: spring-study
 * @description: 使用继承的方式得到sqlSession
 * @author: 兔子
 * @create: 2021-11-29 09:50
 **/

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {
    @Override
    public List<User> getSelectUser() {
//        SqlSession sqlSession = getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        return mapper.getSelectUser();
        return getSqlSession().getMapper(UserMapper.class).getSelectUser();
    }
}
