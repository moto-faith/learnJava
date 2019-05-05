package com.xupeng.bookstore.web.servlet;

import com.xupeng.bookstore.model.Order;
import com.xupeng.bookstore.model.OrderItem;
import com.xupeng.bookstore.model.Product;
import com.xupeng.bookstore.model.User;
import com.xupeng.bookstore.service.OrderService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-05
 * Time: 9:26
 */
@WebServlet("/createOrder")
public class CreateOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
            response.getWriter().write("非法访问...");
            return;
        }

        Map<Product,Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");
        if (cart==null || cart.size()==0){
            response.getWriter().write("购物车没商品");
            return;
        }

        Order order = new Order();
        try {
            BeanUtils.populate(order,request.getParameterMap());
            order.setId(UUID.randomUUID().toString());
            order.setOrdertime(new Date());
            order.setUser(user);

            List<OrderItem> orderItems = new ArrayList<>();
            double totalPrice = 0;
            for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setBuynum(entry.getValue());
                orderItem.setProduct(entry.getKey());
                orderItem.setOrder(order);

                totalPrice += entry.getKey().getPrice() * entry.getValue();

                orderItems.add(orderItem);

            }

            order.setItems(orderItems);
            order.setMoney(totalPrice);
            OrderService orderService = new OrderService();
            orderService.createOder(order);
            request.getSession().removeAttribute("cart");

            response.sendRedirect(request.getContextPath()+"/createOrderSuccess.jsp");


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
