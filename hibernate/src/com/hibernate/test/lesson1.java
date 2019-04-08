package com.hibernate.test;

import com.hibernate.domain.Customer;
import com.hibernate.domain.Order;
import com.hibernate.domain.User;
import com.hibernate.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-07
 * Time: 15:28
 */
public class lesson1 {

    @Test
    public void test1(){
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        User user = new User("lili", "123");
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }
    @Test
    public void test2(){
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
//        User user = new User("zhangsan", "123");
//        user.setBirthday(new Date().getTime());
        User user = (User) session.get(User.class, 1);
//        user.setPassword("345");
        session.save(user);

        session.getTransaction().commit();

    }
    @Test
    public void test3() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        User user1 = (User) session.get(User.class, 1);
        User user2 = (User) session.get(User.class, 4);
        session.evict(user1);
        User user4 = (User) session.get(User.class, 1);


        session.getTransaction().commit();
    }

    @Test
    public void test4() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        User user1 = (User) session.get(User.class, 1);
        User user2 = (User) session.get(User.class, 1);
        System.out.println(user1==user2);
        session.getTransaction().commit();
    }

    @Test
    public void test5() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        User user1 = (User) session.get(User.class, 1);
        user1.setUsername("abc");
        session.flush();
        user1.setUsername("bbb");

        session.getTransaction().commit();
    }

    @Test
    public void test6() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        Criteria criteria =  session.createCriteria(User.class);
        List list  = criteria.list();
        User user = (User) session.get(User.class,3);
        System.out.println(user);

        session.getTransaction().commit();
    }

    @Test
    public void test7() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        User user = new User("ggg", "555");
//        user.setUid(2);
        session.persist(user);
        System.out.println(user);

//        session.clear();//user脱管状态
//        session.save(user);
        session.getTransaction().commit();

    }

    @Test
    public void test8() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        Customer customer = new Customer();
        customer.setName("hah");

        Order order = new Order();
        order.setName("order1");
        Order order1 = new Order();
        order1.setName("order2");
        order.setCustomer(customer);
        order1.setCustomer(customer);

        customer.getOrders().add(order);
        customer.getOrders().add(order1);
        session.save(customer);
        session.save(order);
        session.save(order1);

        session.getTransaction().commit();
    }

}
