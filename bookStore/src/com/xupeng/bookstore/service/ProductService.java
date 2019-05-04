package com.xupeng.bookstore.service;

import com.xupeng.bookstore.dao.ProductDao;
import com.xupeng.bookstore.model.PageResult;
import com.xupeng.bookstore.model.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-04
 * Time: 11:00
 */
public class ProductService {
    private ProductDao productDao = new ProductDao();
    public PageResult<Product> findBooks(String category,int page){
        try {
            PageResult<Product> pr= new PageResult<Product>();
            long totalCount = productDao.count(category);
            pr.setTotalCount(totalCount);
            int totalPage = (int) Math.ceil(totalCount*1.0/pr.getPageSize());
            pr.setTotalPage(totalPage);
            pr.setCurrentPage(page);

            List<Product> list = productDao.findBooks(category, page, pr.getPageSize());
            pr.setList(list);
            return pr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Product findBook(String id){
        try {
            return productDao.findBook(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
