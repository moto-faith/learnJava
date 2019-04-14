package com.itcast.Test;

import com.itcast.factory.MyBeanFactory;
import com.itcast.service.StudentService;
import com.itcast.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-14
 * Time: 9:24
 */
public class test1 {

    @Test
    public void test01(){
        UserService userService = MyBeanFactory.createUserService();
        userService.addUser();
        userService.deleteUser();
        userService.updateUser();
        userService.deleteUser(10);

    }

    @Test
    public void test02(){
        StudentService studentService = MyBeanFactory.createStudentService();
        studentService.add();
        studentService.delete();
        studentService.update();

    }

    @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans07.xml");
        UserService serviceProxy = (UserService) context.getBean("serviceProxy");
        serviceProxy.deleteUser();

    }
    @Test
    public void test04(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans09.xml");
        UserService serviceProxy = (UserService) context.getBean("userService");
        serviceProxy.deleteUser();

        StudentService studentService = (StudentService) context.getBean("studentService");
        studentService.add();
    }
    @Test
    public void test05(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans10.xml");
        UserService service = (UserService) context.getBean("userService");
        service.addUser();

    }
}
