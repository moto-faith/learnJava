package com.xupeng.bookstore.web.servlet;

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
 * Time: 16:14
 */
@WebServlet("/productInfo")
public class ProductInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductService();
        String id = request.getParameter("id");
        Product product = productService.findBook(id);
        request.setAttribute("product",product);
        request.getRequestDispatcher("/product_info.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
