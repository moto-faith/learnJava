package com.itcast.dao.impl;

import com.itcast.dao.UserDao;
import com.itcast.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-16
 * Time: 16:27
 */
public class UserDaoImpl implements UserDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void add(User user) {
        hibernateTemplate.save(user);
    }
}
