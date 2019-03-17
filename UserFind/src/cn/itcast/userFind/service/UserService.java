package cn.itcast.userFind.service;

import cn.itcast.userFind.domain.PageBean;
import cn.itcast.userFind.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-03-16
 * Time: 15:50
 */
public interface UserService {
    /**
     *
     * @return
     */
    public List<User> findAll();

    User login(User user);

    void add(User user);

    void deleteUser(String id);

    User findUserById(String id);

    void updateUser(User user);

    void delSelectedUser(String[] ids);

    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
