package com.itcast.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //这边可以用于多个对象共同的事情的处理
        System.out.println("5:预处理:" + bean + ":" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("8:后处理:" + bean + ":" + beanName);
        return bean;
    }
}
