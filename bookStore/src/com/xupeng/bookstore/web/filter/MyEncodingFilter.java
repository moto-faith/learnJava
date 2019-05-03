package com.xupeng.bookstore.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-03
 * Time: 11:22
 */
@WebFilter("/*")
public class MyEncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hsr = (HttpServletRequest)request;
        if(hsr.getMethod().equalsIgnoreCase("post")){
            request.setCharacterEncoding("UTF-8");
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
