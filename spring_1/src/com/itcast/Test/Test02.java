package com.itcast.Test;

import com.itcast.model.Customer;
import com.itcast.model.Programmer;
import com.itcast.model.Student;
import com.itcast.model.User;
import com.itcast.service.UserSereviceFactory1;
import com.itcast.service.UserService;
import com.itcast.service.UserServiceImpl;
import com.itcast.web.action.UserAction;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-12
 * Time: 18:26
 */
public class Test02 {

    @Test
    public void test1(){
//        ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\10640\\java\\spring_1\\src\\beans3.xml");

//        BeanFactory factory =  new XmlBeanFactory(new FileSystemResource("C:\\Users\\10640\\java\\spring_1\\src\\beans3.xml"));


//        UserService userService2 = (UserService) factory.getBean("userService3");
//        userService2.add();
    }
    @Test
    public void test2(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        UserService userService = (UserService) context.getBean("userService");
//        userService.add();
        String path ="C:\\Users\\10640\\java\\spring_1\\src\\beans3.xml";
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(path));
        UserService user = (UserService) factory.getBean("userService");
        user.add();

    }
    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");
//        UserService userService3 = (UserService) context.getBean("userService");
//        userService3.add();

        UserService userService = UserSereviceFactory1.createUserService();
        UserService userService2 = (UserService) context.getBean("userService2");
        userService2.add();

    }
    @Test
    public void test4() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans5.xml");

        User user = (User) context.getBean("user");
        System.out.println(user);
        context.getClass().getMethod("close").invoke(context);


    }
    @Test
    public void test5() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans6.xml");
        Student stu = (Student) context.getBean("stu");
        System.out.println(stu);

    }
    @Test
    public void test6() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans8.xml");
        Customer customer = (Customer) context.getBean("customer");
        System.out.println(customer);
        System.out.println(customer.getAddress());

    }
    @Test
    public void test7() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans9.xml");
        Programmer programmer = (Programmer) context.getBean("programmer");
        System.out.println("车:" + programmer.getCars());
        System.out.println("宠物:" + programmer.getPats());
        System.out.println("个人信息:" + programmer.getInfos());
        System.out.println("数据库连接信息:" + programmer.getMysqlInfos());
        System.out.println("家庭成员:");
        for (String member: programmer.getMembers()){
            System.out.println(member);
        }
    }
    @Test
    public void test8() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans10.xml");
        UserService service = context.getBean(UserServiceImpl.class);
//        UserService service = context.getBean(UserService.class);
//        UserService service = (UserService) context.getBean("userService");
        User user = new User();
        user.setUsername("xp");
        service.add(user);


    }
    @Test
    public void test9() throws Exception {

        //注解的使用
        //web开发流程 action -> service -> dao
        ApplicationContext context = new ClassPathXmlApplicationContext("beans10.xml");


        //获取action
        UserAction userAction =  context.getBean(UserAction.class);

        //添加用户
        User user = new User();
        user.setUsername("gyf");
        user.setPassword("1234");
        userAction.save(user);
    }
    @Test
    public void test10() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans10.xml");
        UserService service = context.getBean(UserService.class);
        System.out.println(service);
        User user = new User();
        user.setUsername("xp");
        user.setPassword("123");
        service.add(user);


    }



}
