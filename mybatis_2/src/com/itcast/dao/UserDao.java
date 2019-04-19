package com.itcast.dao;

import com.itcast.model.User;

public interface UserDao {
    public User findUserById(int id);
}
