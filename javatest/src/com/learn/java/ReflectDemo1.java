package com.learn.java;

public class ReflectDemo1 {
    public static void main(String[] args) throws Exception {
        Class cls1 = Class.forName("com.learn.java.Person");
        System.out.println(cls1);

        Class cls2 = Person.class;
        System.out.println(cls2);

        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);

        System.out.println(cls1==cls2);
        System.out.println(cls1==cls3);

        Class c = Student.class;
        System.out.println(c==cls1);

    }
}
