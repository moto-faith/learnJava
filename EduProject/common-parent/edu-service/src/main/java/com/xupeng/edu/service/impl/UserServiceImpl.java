package com.xupeng.edu.service.impl;

import com.xupeng.edu.model.User;
import com.xupeng.edu.service.IUserService;
import com.xupeng.edu.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-06
 * Time: 11:31
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public User findById(Integer id) {
        User user = userMapper.findById(id);
        return user;
    }

    @Override
    public User findByUUId(String uuid) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteByUUId(String uuid) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void insert(User user) {

    }
}
