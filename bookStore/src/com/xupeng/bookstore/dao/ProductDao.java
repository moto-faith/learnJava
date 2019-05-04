package com.xupeng.bookstore.dao;

import com.xupeng.bookstore.model.Product;
import com.xupeng.bookstore.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-04
 * Time: 10:25
 */
public class ProductDao {

    public long count(String category) throws SQLException {
        long count = 0;
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select count(*) from products where 1=1";
        if (category!=null && !"".equals(category)){
            sql += " and category = ?";
            count = (long)queryRunner.query(sql,new ScalarHandler(),category);
        }else {
            count = (long)queryRunner.query(sql,new ScalarHandler());
        }
        return count;

    }

    public List<Product> findBooks(String category,int page,int pageSize) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from products where 1=1";
        List<Object> params = new ArrayList<>();
        if (category!=null && !"".equals(category)){
            sql += " and category = ?";
            params.add(category);
        }
        sql += " limit ?, ?";
        int start = (page-1)* pageSize;
        int length = pageSize;
        params.add(start);
        params.add(length);
        return queryRunner.query(sql,new BeanListHandler<Product>(Product.class),params.toArray());


    }
    public Product findBook(String id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from products where id = ?";
        return queryRunner.query(sql,new BeanHandler<Product>(Product.class),id);
    }



}
