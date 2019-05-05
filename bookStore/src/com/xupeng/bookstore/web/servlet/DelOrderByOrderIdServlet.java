package com.xupeng.bookstore.web.servlet;

import com.xupeng.bookstore.model.User;
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
 * Time: 17:41
 */
@WebServlet("/delOrderByOrderId")
public class DelOrderByOrderIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
            response.getWriter().write("您没有权限删除订单");
            return;
        }
        OrderService orderService = new OrderService();
        orderService.delOrderByOrderId(orderId);

        request.getRequestDispatcher("/delOrderSuccess.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
