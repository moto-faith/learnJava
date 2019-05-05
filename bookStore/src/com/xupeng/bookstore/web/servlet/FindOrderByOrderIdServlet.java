package com.xupeng.bookstore.web.servlet;

import com.xupeng.bookstore.model.Order;
import com.xupeng.bookstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-05
 * Time: 15:18
 */
@WebServlet("/findOrderByOrderId")
public class FindOrderByOrderIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        OrderService orderService = new OrderService();
        Order order = orderService.findOrderByOrderId(orderId);
        request.getSession().setAttribute("order",order);
        request.getRequestDispatcher("/orderInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
