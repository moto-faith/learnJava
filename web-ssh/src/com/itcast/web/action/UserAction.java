package com.itcast.web.action;

import com.itcast.model.User;
import com.itcast.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-16
 * Time: 16:52
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
    private  User user = new User();
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User getModel() {
        return user;
    }

    public String register(){
        System.out.println(user);
        userService.register(user);
        return SUCCESS;
    }
}
