package com.itcast.dao.Impl;

import com.itcast.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-15
 * Time: 17:48
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {


    @Override
    public void out(String outer, Integer money) {
        getJdbcTemplate().update("update account set money = money-? where username=?",money,outer);
    }

    @Override
    public void in(String inner, Integer money) {
        getJdbcTemplate().update("update account set money = money+? where username=?",money,inner);
    }
}
