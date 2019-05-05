package com.xupeng.bookstore.dao;

import com.xupeng.bookstore.model.OrderItem;
import com.xupeng.bookstore.utils.C3P0Utils;
import com.xupeng.bookstore.utils.ManagerThreadLocal;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-05
 * Time: 9:05
 */
public class OrderItemDao {

    public void addOrderItems(List<OrderItem> items) throws SQLException {
        String sql ="insert into orderitem (order_id,product_id,buynum) values(?,?,?)";
        Object[][] params = new Object[items.size()][];
        for (int i = 0; i < items.size(); i++) {
            OrderItem item = items.get(i);
            params[i] = new Object[]{item.getOrder().getId(),item.getProduct().getId(),item.getBuynum()};
        }
        QueryRunner queryRunner = new QueryRunner();
        queryRunner.batch(ManagerThreadLocal.getConnection(),sql,params);

    }

    public void delOrderByOrderId(String orderId) throws SQLException {
        String sql1 = "SET FOREIGN_KEY_CHECKS=0";
        String sql = "delete from orderitem where order_id = ?";
        String sql2 = "SET FOREIGN_KEY_CHECKS=1";
        QueryRunner queryRunner = new QueryRunner();
        queryRunner.update(ManagerThreadLocal.getConnection(),sql1);
        queryRunner.update(ManagerThreadLocal.getConnection(),sql,orderId);
        queryRunner.update(ManagerThreadLocal.getConnection(),sql2);
    }
}
