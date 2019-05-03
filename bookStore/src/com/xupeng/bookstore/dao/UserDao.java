package com.xupeng.bookstore.dao;

import com.xupeng.bookstore.model.User;
import com.xupeng.bookstore.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-03
 * Time: 11:06
 */
public class UserDao {
    public void addUser(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into user (username,PASSWORD,gender,email,telephone,introduce,activeCode,state,role,registTime) values(?,?,?,?,?,?,?,?,?,?)";
        List<Object> list = new ArrayList<>();
        list.add(user.getUsername());
        list.add(user.getPassword());
        list.add(user.getGender());
        list.add(user.getEmail());
        list.add(user.getTelephone());
        list.add(user.getIntroduce());
        list.add(user.getActiveCode());
        list.add(user.getState());
        list.add(user.getRole());
        list.add(user.getRegistTime());
        qr.update(sql,list.toArray());

    }

    public User findUserByActiveCode(String activeCode) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from user where activeCode = ?";
        return qr.query(sql,new BeanHandler<User>(User.class),activeCode);
    }

    public void updateState(String activeCode) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "update user set state = 1 where activeCode = ?";
        qr.update(sql,activeCode);
    }

    public User findUserByUsernameAndPassword(String username,String password) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from user where username = ? and password = ?";
        return qr.query(sql,new BeanHandler<User>(User.class),username,password);
    }

}
