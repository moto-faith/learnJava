package com.xupeng.bookstore.web.servlet;

import com.xupeng.bookstore.model.PageResult;
import com.xupeng.bookstore.model.Product;
import com.xupeng.bookstore.service.ProductService;

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
 * Time: 11:11
 */
@WebServlet("/showProductByPage")
public class ShowProductByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("category");
        String pageStr = request.getParameter("page");
        int page = 1;
        if (pageStr!=null && !"".equals(pageStr)){
            page = Integer.parseInt(pageStr);
        }
        ProductService productService = new ProductService();
        PageResult<Product> pageResult = productService.findBooks(category, page);
        request.setAttribute("pageResult",pageResult);
        request.setAttribute("category",category);
        request.getRequestDispatcher("/product_list.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
