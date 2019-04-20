package com.itcast.web.controller;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpController implements HttpRequestHandler{


    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
/*        ModelAndView mav = new ModelAndView("user/userlist");
        mav.addObject("name","gyf");
        return mav;*/
        request.setAttribute("name","xupeng");
        request.getRequestDispatcher("/WEB-INF/views/user/userlist.jsp").forward(request,response);

    }
}
