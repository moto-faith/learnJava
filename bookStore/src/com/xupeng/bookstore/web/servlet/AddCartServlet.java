package com.xupeng.bookstore.web.servlet;

import com.xupeng.bookstore.model.Product;
import com.xupeng.bookstore.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-04
 * Time: 16:50
 */
@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ProductService productService = new ProductService();
        Product product = productService.findBook(id);
        Map<Product,Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");
        if (cart==null){
            cart = new HashMap<Product,Integer>();
            cart.put(product,1);
        }else {
            if (cart.containsKey(product)){
                cart.put(product,cart.get(product)+1);
            }else {
                cart.put(product,1);
            }
        }


//        for(Map.Entry<Product, Integer> entry : cart.entrySet()){
//            System.out.println(entry.getKey() + "数量" + entry.getValue());
//        }
//        System.out.println("===============================");

        request.getSession().setAttribute("cart",cart);
        String a1 = "<a href=\"" + request.getContextPath()+"/showProductByPage\">继续购物</a>";
        String a2 = "&nbsp;&nbsp;<a href=\"" + request.getContextPath()+"/cart.jsp\">查看购物车</a>";
        response.getWriter().write(a1);
        response.getWriter().write(a2);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
