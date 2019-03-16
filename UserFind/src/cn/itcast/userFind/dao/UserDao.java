package cn.itcast.userFind.dao;

import cn.itcast.userFind.domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-03-16
 * Time: 15:44
 */
public interface UserDao {
    public List<User> findAll();
}
