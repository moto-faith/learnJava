package com.xupeng.bookstore.service;

import com.xupeng.bookstore.dao.UserDao;
import com.xupeng.bookstore.exception.UserException;
import com.xupeng.bookstore.model.User;
import com.xupeng.bookstore.utils.SendJMail;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-03
 * Time: 11:11
 */
public class UserService {
    UserDao userDao = new UserDao();

    public void register(User user) throws UserException {
        try {
            userDao.addUser(user);

            String link = "http://localhost:8080/bookstore/active?activeCode=" + user.getActiveCode();

            String html = "<a href=\"" + link + "\">欢迎你注册网上书城帐号,请点击激活</a>";
            System.out.println(html);
            //发送激活邮件
            SendJMail.sendMail(user.getEmail(), html);


        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserException("注册失败，用户名重复");
        }
    }

    public void activeUser(String activeCode) throws UserException {
        try {
            User user = userDao.findUserByActiveCode(activeCode);
            if (user==null){
                throw new UserException("非法激活，用户不存在");
            }
            if (user!=null && user.getState()==1){
                throw new UserException("用户已经激活过了...");
            }
            userDao.updateState(activeCode);
        } catch (SQLException e) {
            throw new UserException("激活失败");
        }
    }

    public User login(String username,String password) throws UserException {
        try {
            User user = userDao.findUserByUsernameAndPassword(username,password);
            if (user==null){
                throw new UserException("用户名或者密码不正确");
            }
            if (user!=null && user.getState()==0){
                throw new UserException("用户未激活，请先登录邮件进行激活");
            }
            return user;
        } catch (SQLException e) {
            throw new UserException("登录失败");
        }
    }

    public User findUserById(String id) throws UserException {
        try {
            User user = userDao.findUserById(id);
            if (user==null){
                throw new UserException("用户名不存在");
            }
            return user;
        } catch (SQLException e) {
            throw new UserException("查找用户失败");
        }
    }

    public void modifyUserInfo(User user) throws UserException {
        try {
            userDao.modifyUserInfo(user);
        } catch (SQLException e) {
            throw new UserException("修改用户失败");
        }
    }

}
