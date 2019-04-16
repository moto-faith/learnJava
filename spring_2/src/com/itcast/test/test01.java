package com.itcast.test;

import com.itcast.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-15
 * Time: 18:03
 */
public class test01 {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans01.xml");
        AccountService service = (AccountService) context.getBean("accountService");
        service.transfer("jack","rose",100);


    }
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans02.xml");
        AccountService service = (AccountService) context.getBean("proxyService");
        service.transfer("jack","rose",100);


    }
}
