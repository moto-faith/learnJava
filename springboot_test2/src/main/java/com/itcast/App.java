package com.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-28
 * Time: 16:30
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.itcast.web.controller")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
