package com.itcast.service;


import com.itcast.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-12
 * Time: 18:25
 */
@Component
public class UserServiceImpl implements UserService {



    @Override
        public void add(User user) {
        System.out.println("service 添加用户:" + user);
        //调用dao

    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void add() {
        System.out.println("创建用户...." + name);
    }

    @Override
    public void addUser() {
        System.out.println("添加用户。。。。");
    }

    @Override
    public void updateUser() {
        System.out.println("更新用户。。。。");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户。。。。");
    }

    @Override
    public int deleteUser(int id) {
        System.out.println("通过id删除用户");
        return 1;
    }


    public UserServiceImpl() {

//        System.out.println("UserServiceImpl（）调用了");
    }
}

