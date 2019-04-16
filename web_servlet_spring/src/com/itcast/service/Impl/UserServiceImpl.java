package com.itcast.service.Impl;

import com.itcast.service.UserService;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-16
 * Time: 15:43
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add(String username) {
        System.out.println("添加用户成功 ..." + username);
    }
}
