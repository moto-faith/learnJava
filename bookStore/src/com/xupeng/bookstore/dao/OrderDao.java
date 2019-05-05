package com.xupeng.bookstore.dao;

import com.xupeng.bookstore.model.Order;
import com.xupeng.bookstore.model.OrderItem;
import com.xupeng.bookstore.model.Product;
import com.xupeng.bookstore.utils.C3P0Utils;
import com.xupeng.bookstore.utils.ManagerThreadLocal;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-05
 * Time: 8:58
 */
public class OrderDao {

    public void add(Order order) throws SQLException {
        String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
        List<Object> params = new ArrayList<>();
        params.add(order.getId());
        params.add(order.getMoney());
        params.add(order.getReceiverAddress());
        params.add(order.getReceiverName());
        params.add(order.getReceiverPhone());
        params.add(order.getPaystate());
        params.add(order.getOrdertime());
        params.add(order.getUser().getId());
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        queryRunner.update(sql,params.toArray());


    }

    public List<Order> findOrdersByUserId(String id) throws SQLException {
        String sql = "select * from orders where user_id =?";
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        return queryRunner.query(sql,new BeanListHandler<Order>(Order.class),id);
    }

    public Order findOrderByOrderId(String orderId) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql1 = "select * from orders where id = ?";
        Order order = queryRunner.query(sql1, new BeanHandler<Order>(Order.class), orderId);

        String sql2 = "select o.*,p.name,p.price from orderitem o,products p where o.product_id = p.id and order_id=?";
        List<OrderItem> mItems = queryRunner.query(sql2, new ResultSetHandler<List<OrderItem>>() {
            @Override
            public List<OrderItem> handle(ResultSet resultSet) throws SQLException {
                List<OrderItem> items = new ArrayList<OrderItem>();
                while (resultSet.next()){
                    OrderItem item = new OrderItem();
                    item.setBuynum(resultSet.getInt("buynum"));

                    Product product = new Product();

                    product.setId(resultSet.getInt("product_id"));
                    product.setName(resultSet.getString("name"));
                    product.setPrice(resultSet.getDouble("price"));

                    item.setProduct(product);
                    items.add(item);

                }
                return items;


            }
        }, orderId);
        order.setItems(mItems);
        return order;


    }

    public void payByOrderId(String orderId) throws SQLException {
        String sql = "update orders set paystate = 1 where id = ?";
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        queryRunner.update(sql,orderId);
    }

    public void delOrderByOrderId(String orderId) throws SQLException {
        String sql1 = "SET FOREIGN_KEY_CHECKS=0";
        String sql = "delete from orders where id = ?";
        String sql2 = "SET FOREIGN_KEY_CHECKS=1";
        QueryRunner queryRunner = new QueryRunner();
        queryRunner.update(ManagerThreadLocal.getConnection(),sql1);
        queryRunner.update(ManagerThreadLocal.getConnection(),sql,orderId);
        queryRunner.update(ManagerThreadLocal.getConnection(),sql2);
    }



}
