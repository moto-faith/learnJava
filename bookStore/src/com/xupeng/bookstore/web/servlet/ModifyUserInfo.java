package com.xupeng.bookstore.web.servlet;

import com.xupeng.bookstore.model.User;
import com.xupeng.bookstore.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-04
 * Time: 9:36
 */
@WebServlet("/modifyUserInfo")
public class ModifyUserInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        try {
            BeanUtils.populate(user,request.getParameterMap());
            UserService userService = new UserService();
            userService.modifyUserInfo(user);
            response.sendRedirect(request.getContextPath()+"/modifyUserInfoSuccess.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
