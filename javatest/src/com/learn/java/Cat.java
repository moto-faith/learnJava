package com.learn.java;

public class Cat extends Animal{
    @Override
    void eat() {
        System.out.println("Cat Eat");
    }

    public  void catchMouse(){
        System.out.println("cat catch mouse");
    }
}
