package com.itcast.service.Impl;

import com.itcast.dao.AccountDao;
import com.itcast.service.AccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-15
 * Time: 17:54
 */
public class AccountServiceImpl2 implements AccountService {

    private AccountDao dao;

    public void setDao(AccountDao dao) {
        this.dao = dao;
    }



    @Override
    public void transfer(String outer, String inner, Integer money) {
        dao.out(outer,money);
        int i = 10/0;
        dao.in(inner,money);

    }
}
