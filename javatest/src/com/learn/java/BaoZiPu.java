package com.learn.java;

public class BaoZiPu extends Thread {
    private BaoZi bz;
    public BaoZiPu(String name,BaoZi bz){
        super(name);
        this.bz=bz;
    }

    @Override
    public void run() {
        int count = 0;
        while (true){
            synchronized (bz){
                if (bz.flag==true){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("包子铺开始做包子");
                if(count%2==0){
                    bz.pier="冰皮";
                    bz.xianer="五仁";
                }else {
                    bz.pier="薄皮";
                    bz.xianer="牛肉大葱";
                }
                count++;

                bz.flag=true;
                System.out.println("包子造好了："+bz.pier+bz.xianer);
                System.out.println("吃货来吃吧");
                bz.notify();
            }
        }
    }
}
