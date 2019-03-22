package cn.itcast.userFind.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-03-22
 * Time: 13:14
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        chain.doFilter(req, resp);
        HttpServletRequest request = (HttpServletRequest) req;
        String uri = request.getRequestURI();
        if (uri.contains("/login.jsp") || uri.contains("/LoginServlet")|| uri.contains("/checkCodeServlet")|| uri.contains("/css/")|| uri.contains("/js/")|| uri.contains("/fonts/")){
            chain.doFilter(req, resp);
        }else {
            Object user = request.getSession().getAttribute("user");
            if (user!=null){
                chain.doFilter(req, resp);
            }else {
                request.setAttribute("login_msg","您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }
    }
    public void init(FilterConfig config) throws ServletException {
    }
}
