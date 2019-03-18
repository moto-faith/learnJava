package cn.itcast.userFind.service.impl;

import cn.itcast.userFind.dao.UserDao;
import cn.itcast.userFind.dao.impl.UserDaoImpl;
import cn.itcast.userFind.domain.PageBean;
import cn.itcast.userFind.domain.User;
import cn.itcast.userFind.service.UserService;

import java.util.List;
import java.util.Map;

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

    @Override
    public User login(User user) {
        return userDao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        userDao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return userDao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if (ids!=null&&ids.length>0){
            for (String id : ids) {
                userDao.delete(Integer.parseInt(id));
            }
        }

    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage<=0){
            currentPage = 1;
        }

        PageBean<User> pb = new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        int totalCount = userDao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        int totalPage = (totalCount%rows)==0?totalCount/rows:(totalCount/rows)+1;
        pb.setTotalPage(totalPage);

        if (currentPage>totalPage){
            currentPage = totalPage;
            pb.setCurrentPage(currentPage);
        }

        int start = (currentPage-1)*rows;
        List<User> list = userDao.findByPage(start,rows,condition);
        pb.setList(list);

        return pb;
    }
}
