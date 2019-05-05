package com.xupeng.bookstore.web.servlet;

import com.xupeng.bookstore.model.Order;
import com.xupeng.bookstore.model.User;
import com.xupeng.bookstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-05
 * Time: 11:30
 */
@WebServlet("/findOrderById")
public class FindOrderByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
            response.getWriter().write("非法访问..");
            return;
        }

        OrderService orderService = new OrderService();
        List<Order> orders = orderService.findOrdersByUserId(user.getId() + "");
        request.setAttribute("ordersCount",orders.size());
        request.setAttribute("orders",orders);
        request.getRequestDispatcher("/orderlist.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
