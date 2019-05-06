package com.xupeng.edu.web.controller;

import com.xupeng.edu.model.User;
import com.xupeng.edu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-06
 * Time: 11:08
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("login")
    public String login(){
        return "Default";
    }


    @RequestMapping("find")
    public String find(Integer id){
        User user = userService.findById(id);
        System.out.println(user);
        return null;
    }

    @RequestMapping("manage")
    public String manage(){


        return "User/UserManage";
    }
    @RequestMapping("info")
    public String info(){
        return "User/UserInfo";
    }
}
