package com.itcast.service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-12
 * Time: 18:25
 */
public class UserServiceImpl implements UserService {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void add() {
        System.out.println("add do it  "+name);
    }
}
