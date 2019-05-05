package com.xupeng.bookstore.model;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-05
 * Time: 8:56
 */
public class Order {

    private String id;
    private double money;
    private String receiverAddress;//收件的地址
    private String receiverName;//收件人的名字
    private String receiverPhone;//收件的电脑
    private int paystate;//支付状态0:未支付 1：已经支付
    private Date ordertime;

    private List<OrderItem> items;//定单下的所有详情(商品)
    /**
     * 如果表是一个外键关系，一般都是设置成对象
     */
    //private int user_id;
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public int getPaystate() {
        return paystate;
    }

    public void setPaystate(int paystate) {
        this.paystate = paystate;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", money=" + money + ", receiverAddress=" + receiverAddress + ", receiverName="
                + receiverName + ", receiverPhone=" + receiverPhone + ", paystate=" + paystate + ", ordertime="
                + ordertime + ", user=" + user + "]";
    }

}
