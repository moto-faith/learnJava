package com.learn.java;

import java.util.function.Consumer;

public class Demo10consumeAndThen {
    private static void consumeString(Consumer<String> one,Consumer<String> two){
        one.andThen(two).accept("hello");
    }

    public static void main(String[] args) {
        consumeString(s -> System.out.println(s.toUpperCase()),
                s -> System.out.println(s.toLowerCase()));
    }
}
