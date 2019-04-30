package com.itcast.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-29
 * Time: 9:25
 */
@EnableAutoConfiguration
@RequestMapping("teacher")
public class TeacherController {

    @RequestMapping("list")
    public String list(){
        System.out.println("aaaaa");
        return "teacher/list";
    }

    public static void main(String[] args) {
        SpringApplication.run(TeacherController.class,args);
    }
}
