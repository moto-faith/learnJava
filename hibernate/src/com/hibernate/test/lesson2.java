package com.hibernate.test;

import com.hibernate.domain.Course;
import com.hibernate.domain.Customer;
import com.hibernate.domain.Order;
import com.hibernate.domain.Student;
import com.hibernate.utils.HibernateUtils;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-08
 * Time: 16:11
 */
public class lesson2 {

    @Test
    public void test1(){
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        Customer customer = new Customer();
        customer.setName("abc");

        Order order1 = new Order();
        order1.setName("order1");

        Order order2 = new Order();
        order2.setName("order2");

        order1.setCustomer(customer);
        order2.setCustomer(customer);

        customer.getOrders().add(order1);
        customer.getOrders().add(order2);

        session.save(customer);
        session.save(order1);
        session.save(order2);


        session.getTransaction().commit();

    }

    @Test
    public void test2() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        Customer customer = (Customer) session.get(Customer.class, 2);
        System.out.println(customer.getName());
        Set<Order> orders = customer.getOrders();
        for (Order order : orders) {
            System.out.println(order.getName());
        }

        session.getTransaction().commit();
    }

    @Test
    public void test3() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        Customer customer = (Customer) session.get(Customer.class, 1);
        for (Order order : customer.getOrders()) {
            order.setCustomer(null);
        }
        session.delete(customer);


        session.getTransaction().commit();
    }

    @Test
    public void test4() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        Customer customer = (Customer) session.get(Customer.class, 2);
//        for (Order order : customer.getOrders()) {
//            order.setCustomer(null);
//        }
        session.delete(customer);


        session.getTransaction().commit();
    }

    @Test
    public void test5() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        Customer customer = (Customer) session.get(Customer.class,4);
        Set<Order> orders = customer.getOrders();
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
        session.delete(customer);


        session.getTransaction().commit();
    }
    @Test
    public void test6() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        Student stu1 = new Student("aa");
        Student stu2 = new Student("bb");
        Course c1 = new Course("哈哈");
        Course c2 = new Course("呵呵");
        stu1.getCourses().add(c1);
        stu1.getCourses().add(c2);
        stu2.getCourses().add(c1);
        stu2.getCourses().add(c2);
//        session.save(stu1);
//        session.save(stu2);

        c1.getStudents().add(stu1);
        c1.getStudents().add(stu2);
        c2.getStudents().add(stu1);
        c2.getStudents().add(stu2);
        session.save(c1);
        session.save(c2);


        session.getTransaction().commit();
    }

    @Test
    public void test7() {
        Session session = HibernateUtils.openSession();
        Student student = (Student) session.load(Student.class, 5);
        System.out.println("---------------");
        System.out.println(student.getName());


    }
    @Test
    public void test8() {
        Session session = HibernateUtils.openSession();
        Student student = (Student) session.load(Student.class, 5);
        System.out.println("---------------");
        Set<Course> courses = student.getCourses();
        System.out.println(courses);


    }
    @Test
    public void test9() {
        Session session = HibernateUtils.openSession();
        Student student = (Student) session.load(Student.class, 5);

        System.out.println(student);


    }
    @Test
    public void test10() {
        Session session = HibernateUtils.openSession();
        Query qu = session.createQuery("from Student ");
        List<Student> stus = qu.list();
        for (Student student : stus) {
            System.out.println(student.getName());
            System.out.println(student.getCourses());
        }

    }

    @Test
    public void test11() {
        Session session = HibernateUtils.openSession();
        Order order = (Order) session.load(Order.class, 7);
        System.out.println("======");
        System.out.println(order.getName());
        System.out.println("-------------");
        Customer customer = order.getCustomer();
        System.out.println(customer.getName());

    }
    @Test
    public void test12() {
        Session session = HibernateUtils.openSession();
        List<Customer> li = session.createQuery("from Customer ").list();
        for (Customer customer : li) {
            Set<Order> orders = customer.getOrders();
            for (Order order : orders) {


            }

        }

    }

    @Test
    public void test13() {
        Session session = HibernateUtils.openSession();
        List<Customer> li = session.createQuery("from Customer ").list();
        for (Customer customer : li) {
            Set<Order> orders = customer.getOrders();
            for (Order order : orders) {


            }

        }

    }


}
