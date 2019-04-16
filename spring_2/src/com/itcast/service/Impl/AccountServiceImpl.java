package com.itcast.service.Impl;

import com.itcast.dao.AccountDao;
import com.itcast.dao.Impl.AccountDaoImpl;
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
public class AccountServiceImpl implements AccountService {

    private AccountDao dao;

    public void setDao(AccountDao dao) {
        this.dao = dao;
    }

    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public void transfer(String outer, String inner, Integer money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                dao.out(outer,money);
                dao.in(inner,money);


            }
        });




    }
}
