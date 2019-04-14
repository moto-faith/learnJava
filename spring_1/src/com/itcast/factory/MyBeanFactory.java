package com.itcast.factory;

import com.itcast.aspect.MyAspect;
import com.itcast.aspect.MyAspect2;
import com.itcast.service.StudentService;
import com.itcast.service.UserService;
import com.itcast.service.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-14
 * Time: 9:11
 */
public class MyBeanFactory {

    public static UserService createUserService(){
        final UserService userService = new UserServiceImpl();
        final MyAspect2 aspect = new MyAspect2();

        UserService serviceProxy = (UserService) Proxy.newProxyInstance(MyBeanFactory.class.getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        aspect.before();
                        Object o = method.invoke(userService, args);
                        aspect.after();


                        return o;
                    }
                }
        );

        return serviceProxy;

    }

    public static StudentService createStudentService(){
        final StudentService studentService = new StudentService();
        final MyAspect2 aspect = new MyAspect2();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(studentService.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                aspect.before();
                Object invoke = methodProxy.invokeSuper(o, objects);
                System.out.println("工厂");

                aspect.after();
                return invoke;
            }
        });
        StudentService serviceProxy = (StudentService) enhancer.create();


        return serviceProxy;


    }
}
