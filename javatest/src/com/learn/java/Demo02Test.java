package com.learn.java;

import java.util.function.Supplier;

public class Demo02Test {
    public static  int getMax(Supplier<Integer> sup){
        return sup.get();
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,52,333,23};
        int maxNum = getMax(()->{
            int max = arr[0];
            for (int i : arr) {
                if (i>max){
                    max = i;
                }
            }
            return max;
        });
        System.out.println(maxNum);
    }
}
