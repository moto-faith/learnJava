package com.xupeng.edu.service.base;

import com.xupeng.edu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-05-06
 * Time: 11:27
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {

    @Autowired
    protected UserMapper userMapper;
}
