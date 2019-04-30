package com.itcast.test1.service.impl;

import com.itcast.test1.mapper.UserMapper;

import com.itcast.test2.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-29
 * Time: 9:56
 */
@Service
@Transactional
public class UserServiceImpl {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CustomerMapper customerMapper;
    public void register(String username, String password) {

        customerMapper.save(username,"110");
        userMapper.save(username,password);


    }




}
