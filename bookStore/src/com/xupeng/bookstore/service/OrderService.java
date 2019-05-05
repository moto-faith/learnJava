package com.xupeng.bookstore.service;

import com.xupeng.bookstore.dao.OrderDao;
import com.xupeng.bookstore.dao.OrderItemDao;
import com.xupeng.bookstore.dao.ProductDao;
import com.xupeng.bookstore.model.Order;
import com.xupeng.bookstore.model.OrderItem;
import com.xupeng.bookstore.utils.ManagerThreadLocal;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-05
 * Time: 9:23
 */
public class OrderService {

    private OrderDao orderDao = new OrderDao();
    private OrderItemDao orderItemDao = new OrderItemDao();
    private ProductDao productDao = new ProductDao();
    public void createOder(Order order){
        try {
            ManagerThreadLocal.beginTransaction();
            orderDao.add(order);
            orderItemDao.addOrderItems(order.getItems());

            for (OrderItem orderItem : order.getItems()) {
                productDao.updatePNum(orderItem.getProduct().getId(),orderItem.getBuynum());
            }
            ManagerThreadLocal.commitTransaction();

        } catch (SQLException e) {
            e.printStackTrace();
            ManagerThreadLocal.rollbackTransaction();
        }

    }

    public List<Order> findOrdersByUserId(String userid){
        try {
            return orderDao.findOrdersByUserId(userid);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public Order findOrderByOrderId(String orderId){
        try {
            return orderDao.findOrderByOrderId(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void payByOrderId(String orderId){
        try {
            orderDao.payByOrderId(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delOrderByOrderId(String orderId){
        try {
            ManagerThreadLocal.beginTransaction();
            orderDao.delOrderByOrderId(orderId);
            orderItemDao.delOrderByOrderId(orderId);
            ManagerThreadLocal.commitTransaction();
        } catch (SQLException e) {
            e.printStackTrace();
            ManagerThreadLocal.rollbackTransaction();
        }
    }



}
