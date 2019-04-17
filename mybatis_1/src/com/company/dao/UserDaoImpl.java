package com.company.dao;

import com.company.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-17
 * Time: 11:25
 */
public class UserDaoImpl implements UserDao {
    private SqlSessionFactory ssf;

    public UserDaoImpl() {
    }

    public UserDaoImpl(SqlSessionFactory ssf) {

        this.ssf = ssf;
    }

    @Override
    public void save(User user) {
        SqlSession session = ssf.openSession();
        session.insert("insertUser",user);
        session.commit();
        session.close();

    }

    @Override
    public User findUserById(int id) {
        SqlSession session = ssf.openSession();
        User user = session.selectOne("findUserById", id);
        session.close();
        return user;
    }
}
