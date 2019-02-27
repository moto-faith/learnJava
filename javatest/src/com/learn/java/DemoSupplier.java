package com.learn.java;

import java.util.function.Supplier;

public class DemoSupplier {
    private static String getString(Supplier<String> function){
        return function.get();
    }

    public static void main(String[] args) {
        String msgA = "hello ";
        String msgB = "world ";
        System.out.println(getString(()-> msgA+msgB));
    }
}
