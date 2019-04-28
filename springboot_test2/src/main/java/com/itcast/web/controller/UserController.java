package com.itcast.web.controller;

import com.itcast.model.User;
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
    @RequestMapping("{id}")
    @ResponseBody
    /**
     * 通过id查询用户的信息
     */
    public User userInfo(@PathVariable() Integer id){
        User user = new User("xp","123");
        user.setId(id);
        return user;
    }
}
