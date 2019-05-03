package com.xupeng.bookstore.web.servlet;

import com.xupeng.bookstore.exception.UserException;
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
import java.util.Date;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-03
 * Time: 11:14
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        try {
            String checkcode_client = request.getParameter("checkcode");
            String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
            if (!checkcode_client.equals(checkcode_session)){
                request.setAttribute("checkcode_err","验证错误");
                request.getRequestDispatcher("/register.jsp").forward(request,response);
                return;
            }

            BeanUtils.populate(user,request.getParameterMap());
            user.setActiveCode(UUID.randomUUID().toString());//激活码
            user.setRole("普通用户");//角色
            user.setRegistTime(new Date());
            System.out.println(user);
            UserService userService = new UserService();
            userService.register(user);
            request.getRequestDispatcher("/registersuccess.jsp").forward(request, response);

        }catch (UserException e) {
            e.printStackTrace();
            request.setAttribute("register_err", e.getMessage());
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
