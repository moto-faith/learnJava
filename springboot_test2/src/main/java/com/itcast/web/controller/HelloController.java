package com.itcast.web.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-28
 * Time: 15:57
 */
@RestController
@EnableAutoConfiguration
public class HelloController {
    @RequestMapping("hello/{name}")
    @ResponseBody
    public String hello(@PathVariable() String name){
        return name + ":Hello,Spring Boot";
    }

/*    public static void main(String[] args) {
        //启动springboot项目
        SpringApplication.run(HelloController.class,args);
    }*/
}
