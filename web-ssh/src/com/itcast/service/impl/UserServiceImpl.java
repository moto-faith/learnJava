package com.itcast.service.impl;

import com.itcast.dao.UserDao;
import com.itcast.model.User;
import com.itcast.service.UserService;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-16
 * Time: 16:30
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {

        this.userDao = userDao;
    }

    @Override
    public void register(User user) {
        userDao.add(user);
    }
}
