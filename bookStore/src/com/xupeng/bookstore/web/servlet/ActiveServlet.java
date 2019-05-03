package com.xupeng.bookstore.web.servlet;

import com.xupeng.bookstore.exception.UserException;
import com.xupeng.bookstore.service.UserService;

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
 * Date: 2019-05-03
 * Time: 17:03
 */
@WebServlet("/active")
public class ActiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("content-type","text/html;charset=utf-8");
        String activeCode = request.getParameter("activeCode");
        UserService userService = new UserService();
        try {
            userService.activeUser(activeCode);
            request.getRequestDispatcher("/activesuccess.jsp").forward(request, response);
        } catch (UserException e) {
            response.getWriter().write(e.getMessage());
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
