package cn.itcast.web.response;

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
 * Date: 2019-03-14
 * Time: 15:56
 */
@WebServlet("/responseDemo1")
public class responseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo01............");

//        response.setStatus(302);
//        response.setHeader("location","/response/responseDemo2");
//        request.setAttribute("msg","response");
//        String contextPath = request.getContextPath();
//        response.sendRedirect(contextPath+"/responseDemo2");

        response.setContentType("text/html;charset=utf-8");
        response.getOutputStream().write("你好啊".getBytes("utf-8"));



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
