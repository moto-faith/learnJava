package com.itcast.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/stu")
public class StudentController {

    @RequestMapping("/test1")
    public String test1() {
        //不同控制器转发
        //return "forward:/user/list.do";
        //不同控制器转发
        return "redirect:/user/list.do";
    }

    @RequestMapping("/test2")
    public String test2(@RequestParam(value = "uid",required = true,defaultValue = "30") Integer uid) {
        System.out.println(uid);
        return "redirect:/user/list.do";
    }
}