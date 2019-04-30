package com.itcast.web.controller;


import com.itcast.model.User;

import com.itcast.test1.service.impl.UserServiceImpl;
import com.itcast.test2.service.impl.CustomerServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-28
 * Time: 16:28
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("register")
    @ResponseBody
    public String register(String username,String password){

        userService.register(username,password);
        return "success";
    }



}
