package com.learn.java;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {
    public static void main(String[] args) throws Exception {

        Properties pro = new Properties();
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        System.out.println(className+methodName);

        Class cls = Class.forName(className);

        Object obj = cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.invoke(obj);


    }
}
