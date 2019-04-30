package com.itcast.test2.service.impl;



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
public class CustomerServiceImpl {

    @Autowired
    private CustomerMapper customerMapper;
    public void save(String name, String tel) {
        customerMapper.save(name,tel);
    }




}
