package com.itcast.dao;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-15
 * Time: 17:46
 */
public interface AccountDao {
    public void out(String outer,Integer money);
    public void in(String inner,Integer money);
}
