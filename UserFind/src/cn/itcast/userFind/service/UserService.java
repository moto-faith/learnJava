package cn.itcast.userFind.service;

import cn.itcast.userFind.domain.User;

import java.util.List;

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
}
