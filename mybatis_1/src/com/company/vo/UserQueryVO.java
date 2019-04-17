package com.company.vo;

import com.company.model.Order;
import com.company.model.User;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-17
 * Time: 17:48
 */
public class UserQueryVO {
    private User user;
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
