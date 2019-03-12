package cn.itcast.java;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/servletDemo01")
public class ServletDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String method = request.getMethod();
//        System.out.println(method);
//        String contextPath = request.getContextPath();
//        System.out.println(contextPath);
//        String servletPath = request.getServletPath();
//        System.out.println(servletPath);
//        System.out.println(request.getQueryString());
//        System.out.println(request.getRequestURI());
//        System.out.println(request.getRequestURL());
//        System.out.println(request.getProtocol());
//        System.out.println(request.getRemoteAddr());
        request.setCharacterEncoding("utf-8");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        System.out.println(username);
//        System.out.println(password);
//        String[] hobbies = request.getParameterValues("hobby");
//        for (String hobby : hobbies) {
//            System.out.println(hobby);
//        }
//        Enumeration<String> parameterNames = request.getParameterNames();
//        while (parameterNames.hasMoreElements()){
//            System.out.println(parameterNames.nextElement());
//        }
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        Set<String> strings = parameterMap.keySet();
//        for (String string : strings) {
//            String[] strings1 = parameterMap.get(string);
//            System.out.println(string+":");
//            for (String s : strings1) {
//                System.out.println(s);
//            }
//            System.out.println("--------------");
//        }


    }
}
