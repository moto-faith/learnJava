package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-02
 * Time: 11:48
 */
public interface UserDao {
    public User findByUser(String username);
    public void save(User user);

    User findByCode(String code);

    void updateStatus(User user);

    User findByUsernameAndPassword(String username, String password);
}
