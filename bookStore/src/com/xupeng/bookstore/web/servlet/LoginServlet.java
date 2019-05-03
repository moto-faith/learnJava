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
 * Date: 2019-05-03
 * Time: 17:37
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserService();
        try {
            User user = userService.login(username, password);
            request.getSession().setAttribute("user",user);
            if ("管理员".equals(user.getRole())){
                response.sendRedirect(request.getContextPath()+"/admin/login/home.jsp");
            }else {
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }
        } catch (UserException e) {
            request.setAttribute("login_msg",e.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
