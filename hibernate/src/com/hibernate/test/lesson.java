package com.hibernate.test;

import com.hibernate.domain.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-05
 * Time: 9:31
 */
public class lesson {

    @Test
    public void test1(){
        Configuration cfg = new Configuration().configure();

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
//        Transaction trans = session.getTransaction();
//        trans.begin();
//        查询
//        User user = (User) session.get(User.class, 2);
        session.getTransaction().begin();//开启事务
//        插入
//        User user = new User();
//        user.setUsername("ccc");
//        user.setPassword("234");
//        session.save(user);
//        trans.commit();


//        删除方法1
//        User user = (User) session.get(User.class, 1);
//        session.delete(user);
//        删除方法2
//        User user = new User();
//        user.setUid(2);
//        session.delete(user);

//        修改方法1
//        User user = (User) session.get(User.class, 1);
//        user.setPassword("222");
//        修改方法2
//        User user = new User();
//        user.setUid(1);
//        user.setPassword("222");
//        user.setUsername("bbb");
//        session.update(user);

        session.getTransaction().commit();//事务提交
        session.close();
        factory.close();
    }

    @Test
    public void test2(){
        Configuration cfg = new Configuration().configure();

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        //条件查询
//        Query query =  session.createQuery("from User where username=? and password=?");
//        query.setParameter(0,"bbb");
//        query.setParameter(1,"222");
//        User user = (User) query.uniqueResult();
//        System.out.println(user);

        //分页查询
        Query query = session.createQuery("from User ");
        query.setFirstResult(2);//起始位置
        query.setMaxResults(2);//每页条数
        List<User> list = query.list();
        for (User user : list) {
            System.out.println(user);
        }

        session.close();
        factory.close();
    }

    @Test
    public void test3() {
        Configuration cfg = new Configuration().configure();

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(User.class);
//        criteria.add(Restrictions.eq("username","a"));
//        criteria.add(Restrictions.eq("password","1"));
//        System.out.println(criteria.uniqueResult());

//        criteria.add(Restrictions.gt("id",3));

        criteria.add(Restrictions.like("username","%b%"));
        System.out.println(criteria.list());

    }

    @Test
    public void test4() {
        Configuration cfg = new Configuration().configure();

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        SQLQuery query = session.createSQLQuery("SELECT * from t_user");
        List<Object[]> list = query.list();
        for (Object[] o : list) {
            for (Object o1 : o) {
                System.out.println(o1);
            }
            System.out.println("----------");
        }

        session.close();
    }


}
