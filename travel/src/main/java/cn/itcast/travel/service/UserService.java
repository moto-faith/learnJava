package cn.itcast.travel.service;

import cn.itcast.travel.domain.User;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-02
 * Time: 11:45
 */
public interface UserService {
    public boolean regist(User user);
    public boolean active(String code);

    User login(User user);
}
