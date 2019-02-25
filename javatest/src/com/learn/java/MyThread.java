package com.learn.java;

public class MyThread extends Thread {

    public void run(){
        for (int i = 0; i < 100; i++) {
            if(i%100==0){
                System.out.println("-----------"+i);
            }
            System.out.println(i);
            try {
                Thread.sleep(1000);
                System.out.println("Thread is sleeping for 1 second");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
    }

}
