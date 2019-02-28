package com.learn.java;

import java.lang.reflect.Method;

public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        Method eat_method = personClass.getMethod("eat");
        Person p = new Person();
        eat_method.invoke(p);

        Method eat_method2 = personClass.getMethod("eat", String.class);
        eat_method2.invoke(p,"dinner");
        System.out.println("--------------");

        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
        }

        String className = personClass.getName();
        System.out.println(className);


    }
}
