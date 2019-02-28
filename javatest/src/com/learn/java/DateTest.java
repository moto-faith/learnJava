package com.learn.java;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String datestr = df.format(now);
        System.out.println(datestr);
    }
}
