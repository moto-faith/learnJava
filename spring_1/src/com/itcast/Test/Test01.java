package com.itcast.Test;

import com.itcast.service.UserService;
import com.itcast.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-12
 * Time: 18:26
 */
public class Test01 {

    @Test
    public void test1(){
        UserService userService  = new UserServiceImpl();
        userService.add();
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.add();
        UserService userService2 = (UserService) context.getBean("userService");
        userService2.add();
        System.out.println(userService==userService2);

    }

}
