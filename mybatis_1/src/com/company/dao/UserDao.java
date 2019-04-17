package com.company.dao;

import com.company.model.User;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-17
 * Time: 11:24
 */
public interface UserDao {
    public void save(User user);


    public User findUserById(int id);
}
