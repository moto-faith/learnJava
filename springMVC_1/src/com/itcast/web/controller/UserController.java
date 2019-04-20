package com.itcast.web.controller;

import com.itcast.web.model.User;
import com.itcast.web.model.UserExt;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-20
 * Time: 9:00
 */
@org.springframework.stereotype.Controller
@RequestMapping("/user")
public class UserController  {

    @RequestMapping("list")
    public String list(Model model){

        //1.模拟数据库的数据
        List<User> userList = new ArrayList<User>();
        User user1 = new User("习总",60,"男",new Date());
        User user2 = new User("李总",50,"男",new Date());
        User user3 = new User("上官",18,"男",new Date());

        user1.setId(1);
        user2.setId(2);
        user3.setId(3);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        //2.把数据存在model
        model.addAttribute("userList",userList);

        return "user/userlist";
    }

    @RequestMapping("/edit")
    public String edit(int id,Model model){

        System.out.println("id : "+id);
        User user1 = new User("习总",60,"男",new Date());
        model.addAttribute("user",user1);

        return "user/useredit";
    }
    @RequestMapping("/edit1/{id}")
    public String edit1(@PathVariable int id, Model model){

        System.out.println("id : "+id);
        User user1 = new User("习总",60,"男",new Date());
        model.addAttribute("user",user1);

        return "user/useredit";
    }

    @RequestMapping("/toRegister")
    public String toRegister(){

        return "user/register";
    }

    @RequestMapping("/register")
    public String register(String username,String password,
                           int age,String gender,Date birthday,
                           String[] hobbyIds){

        System.out.println(username);
        System.out.println(password);
        System.out.println(age);
        System.out.println(gender);
        System.out.println(birthday);
        System.out.println(Arrays.toString(hobbyIds));
        return "user/info";
    }
    @RequestMapping("/register2")
    public String register2(User user){

        System.out.println(user);

        return "user/info";
    }
    @RequestMapping("/register3")
    public String register3(UserExt user){

        System.out.println(user);

        return "user/info";
    }
    @RequestMapping("/register4")
    public String register4(UserExt user){

        System.out.println(user.getUsers());

        return "user/info";
    }
    @RequestMapping("/register5")
    public String register5(UserExt user){

        System.out.println(user.getInfos());

        return "user/info";
    }
    @RequestMapping("test1")
    public String test1(){
        //同一个控制器转发
        return "forward:list.do";
    }
}
