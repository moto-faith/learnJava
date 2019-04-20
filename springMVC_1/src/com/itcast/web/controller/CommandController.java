package com.itcast.web.controller;


import com.itcast.web.model.User;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandController extends AbstractCommandController {

    public CommandController(){
        //告诉springmvc把表单数据存在User模型里去
        this.setCommandClass(User.class);
    }
    @Override
    protected ModelAndView handle(HttpServletRequest requeset, HttpServletResponse response,
                                  Object o, BindException e) throws Exception {
        User user = (User) o;
        System.out.println(user);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/info");
        mav.addObject("user",user);
        return mav;
    }
}
