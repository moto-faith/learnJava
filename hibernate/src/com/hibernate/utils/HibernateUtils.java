package com.hibernate.utils;

import org.dom4j.rule.Rule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory factory;
    static{
        //1.获取核心 配置文件对象
        Configuration cfg = new Configuration().configure();

        //2.创建会话工厂
        factory = cfg.buildSessionFactory();

        //监听程序关闭
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.out.println("程序关闭...");
                //关闭会话工厂
                factory.close();
            }
        });

    }

    public static Session openSession(){
        return factory.openSession();
    }

    public static Session getCurrentSession(){
        return factory.getCurrentSession();
    }

}
