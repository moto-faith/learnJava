package com.xupeng.bookstore.web.servlet;

import com.xupeng.bookstore.model.Product;
import com.xupeng.bookstore.service.ProductService;

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
 * Date: 2019-05-04
 * Time: 17:40
 */
@WebServlet("/changeNum")
public class ChangeNumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String num = request.getParameter("num");
        ProductService productService = new ProductService();
        Product product = productService.findBook(id);
        Map<Product,Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");
        if (cart.containsKey(product)){
            if ("0".equals(num)){
                cart.remove(product);
            }else if (product.getPnum()<Integer.parseInt(num)){
                cart.put(product,product.getPnum());
            }else {
                cart.put(product,Integer.parseInt(num));
            }
        }

        request.getSession().setAttribute("cart",cart);
        response.sendRedirect(request.getContextPath()+"/cart.jsp");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
