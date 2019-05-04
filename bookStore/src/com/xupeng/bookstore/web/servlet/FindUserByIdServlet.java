package com.xupeng.bookstore.web.servlet;

import com.xupeng.bookstore.exception.UserException;
import com.xupeng.bookstore.model.User;
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
 * Date: 2019-05-04
 * Time: 9:07
 */
@WebServlet("/findUserById")
public class FindUserByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        UserService userService = new UserService();
        try {
            User user = userService.findUserById(id);
            request.setAttribute("u",user);
            request.getRequestDispatcher("/modifyuserinfo.jsp").forward(request,response);
        } catch (UserException e) {
            response.getWriter().write(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
