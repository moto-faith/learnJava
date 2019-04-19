package com.itcast.dao;

import com.itcast.model.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

    @Override
    public User findUserById(int id) {
        return this.getSqlSession().selectOne("user.findUserById",id);
    }
}
