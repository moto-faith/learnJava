package com.itcast.aspect;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-14
 * Time: 9:16
 */
public class MyAspect implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        System.out.println("开启事务");
        Object o = mi.proceed();
        System.out.println("提交事务");

        return o;
    }
}
