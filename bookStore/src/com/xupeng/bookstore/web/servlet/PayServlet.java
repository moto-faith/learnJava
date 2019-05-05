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
 * Time: 17:03
 */
@WebServlet("/pay")
public class PayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = (Order) request.getSession().getAttribute("order");
        if (order==null){
            response.getWriter().write("没获取到订单");
            return;
        }
        if (order.getPaystate()==1){
            response.getWriter().write("该订单已支付");
            return;
        }
        OrderService orderService = new OrderService();
        orderService.payByOrderId(order.getId());
        response.sendRedirect(request.getContextPath()+"/paysuccess.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
