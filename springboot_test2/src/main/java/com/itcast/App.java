package com.itcast;

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
@ComponentScan(basePackages = {"com.itcast.aspect","com.itcast.dbconfig","com.itcast.web","com.itcast.datasource","com.itcast.test1.service","com.itcast.test2.service"})
@EnableConfigurationProperties(value = {DBConfig1.class, DBConfig2.class})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
