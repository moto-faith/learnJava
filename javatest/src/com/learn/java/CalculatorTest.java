package com.learn.java;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    @Before
    public void init(){
        System.out.println("init...");
    }

    @After
    public void close(){
        System.out.println("close");
    }

    @Test
    public void testAdd(){
        System.out.println("testAdd...");
        Calculator c = new Calculator();
        int res = c.add(1, 2);
        Assert.assertEquals(3,res);
    }

    @Test
    public void testSub(){
        Calculator c = new Calculator();
        int res = c.sub(1, 2);
        System.out.println("testSub...");
        Assert.assertEquals(-1,res);
    }
}
