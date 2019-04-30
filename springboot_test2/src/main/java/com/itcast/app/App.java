package com.itcast.app;

import com.itcast.dbconfig.DBConfig1;
import com.itcast.dbconfig.DBConfig2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-28
 * Time: 16:30
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.itcast"})
//@EnableConfigurationProperties(value = {DBConfig1.class, DBConfig2.class})
@MapperScan(value = {"com.itcast.mapper"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
