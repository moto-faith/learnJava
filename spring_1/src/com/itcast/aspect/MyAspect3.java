package com.itcast.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-14
 * Time: 9:16
 */
public class MyAspect3 {

    public void before(){
        System.out.println("before");
    }
    public void after(){
        System.out.println("after");
    }

    public Object myRound(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知");
        System.out.println(pjp.getSignature().getName());
        System.out.println("开启事务");
        Object proceed = pjp.proceed();
        System.out.println("提交事务");
        return proceed;

    }
}
