package com.learn.java;

import java.util.function.Consumer;

public class Demo09Consumer {
    private static void consumeString(Consumer<String> function){
        function.accept("hello");
    }

    public static void main(String[] args) {
        consumeString(s-> System.out.println(s));
    }
}
