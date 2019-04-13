package com.itcast.service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-13
 * Time: 16:25
 */
public class UserSereviceFactory1 {

    public static UserService createUserService(){
        return new UserServiceImpl();
    }
}