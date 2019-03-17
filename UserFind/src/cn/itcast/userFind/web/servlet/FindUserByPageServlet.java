package cn.itcast.userFind.web.servlet;

import cn.itcast.userFind.domain.PageBean;
import cn.itcast.userFind.domain.User;
import cn.itcast.userFind.service.UserService;
import cn.itcast.userFind.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-03-17
 * Time: 16:59
 */
@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if (currentPage==null||"".equals(currentPage)){
            currentPage = "1";
        }

        if (rows==null||"".equals(rows)){
            rows ="5";
        }

        Map<String, String[]> condition = request.getParameterMap();
        System.out.println(condition.keySet());
        UserService service = new UserServiceImpl();
        PageBean<User> pb = service.findUserByPage(currentPage,rows,condition);

        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);
        request.getRequestDispatcher("/list.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
