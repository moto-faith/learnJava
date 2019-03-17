package cn.itcast.userFind.dao;

import cn.itcast.userFind.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-03-16
 * Time: 15:44
 */
public interface UserDao {
    public List<User> findAll();
    User findUserByUsernameAndPassword(String username, String password);

    void add(User user);

    void delete(int id);

    User findUserById(int i);

    void updateUser(User user);

    int findTotalCount(Map<String, String[]> condition);

    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
