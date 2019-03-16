package cn.itcast.userFind.service.impl;

import cn.itcast.userFind.dao.UserDao;
import cn.itcast.userFind.dao.impl.UserDaoImpl;
import cn.itcast.userFind.domain.User;
import cn.itcast.userFind.service.UserService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-03-16
 * Time: 15:51
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {



        return userDao.findAll();
    }
}
