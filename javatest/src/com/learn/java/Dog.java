package com.learn.java;

public class Dog extends Animal {
    @Override
    void eat() {
        System.out.println("Dog Eat");
    }

    public  void watchHouse(){
        System.out.println("Dog watch house");
    }
}
