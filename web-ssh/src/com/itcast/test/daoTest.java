package com.itcast.test;

import com.itcast.model.User;
import com.itcast.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-16
 * Time: 16:38
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class daoTest {

    @Autowired
    private UserService userService;

    @Test
    public void test01(){
        User user = new User("xp", "123", 12);
        userService.register(user);

    }

}
