package cn.itcast.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-03-22
 * Time: 14:18
 */
public class ProxyTest {
    public static void main(String[] args) {
        Lenovo lenovo = new Lenovo();
        SaleComputer newLenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("sale")){
                    double money = (double)args[0];
                    money = money * 0.85;
                    String obj = (String) method.invoke(lenovo, money);
                    return obj+"_鼠标垫";
                }else {
                    Object obj = method.invoke(lenovo, args);
                    return obj;
                }


            }
        });
        String sale = newLenovo.sale(8000);
        System.out.println(sale);
        newLenovo.show();

    }
}
