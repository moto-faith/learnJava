package com.xupeng.edu.mapper.base;

import com.xupeng.edu.model.User;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-06
 * Time: 11:18
 */
public interface BaseMapper<T> {

    public T findById(Integer id);
    public T findByUUId(String uuid);

    public void deleteById(Integer id);
    public void deleteByUUId(String uuid);

    public void update(T t);

    public void insert(T t);
}
